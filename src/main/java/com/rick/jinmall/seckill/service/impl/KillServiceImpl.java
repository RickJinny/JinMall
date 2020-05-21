package com.rick.jinmall.seckill.service.impl;

import com.rick.jinmall.seckill.mapper.ItemKillMapper;
import com.rick.jinmall.seckill.mapper.ItemKillSuccessMapper;
import com.rick.jinmall.seckill.model.ItemKill;
import com.rick.jinmall.seckill.model.ItemKillSuccess;
import com.rick.jinmall.seckill.model.SysConstant;
import com.rick.jinmall.seckill.mq.RabbitSenderService;
import com.rick.jinmall.seckill.service.KillService;
import com.rick.jinmall.seckill.utils.RandomUtil;
import com.rick.jinmall.seckill.utils.SnowFlake;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class KillServiceImpl implements KillService {

    private static final Logger log = LoggerFactory.getLogger(KillService.class);

    private SnowFlake snowFlake = new SnowFlake(2, 3);

    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;

    @Autowired
    private ItemKillMapper itemKillMapper;

    @Autowired
    private RabbitSenderService rabbitSenderService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public Boolean killItem(Integer killId, Integer userId) throws Exception {
        Boolean result = false;
        // 判断当前用户是否已经抢购过当前的商品
        if (itemKillSuccessMapper.countByKillUserId(killId, userId) <= 0) {
            // 查询待秒杀商品详情
            ItemKill itemKill = itemKillMapper.selectById(killId);
            // 判断是否可以被秒杀
            if (itemKill != null && 1 == itemKill.getCanKill()) {
                // 扣减库存，减 1
                int res = itemKillMapper.updateKillItem(killId);
                // 扣减是否成功？成功：生成秒杀成功的订单, 同时通知用户秒杀成功的消息
                if (res > 0) {
                    commonRecordKillSuccessInfo(itemKill, userId);
                    result = true;
                }
            }
        } else {
            throw new Exception("您已经抢购过该商品了");
        }
        return result;
    }

    /**
     * MySQL 的优化
     */
    @Override
    public Boolean killItemV2(Integer killId, Integer userId) throws Exception {
        Boolean result = false;
        // 判断当前用户是否已经抢购过当前的商品
        if (itemKillSuccessMapper.countByKillUserId(killId, userId) <= 0) {
            // 查询待秒杀商品详情
            ItemKill itemKill = itemKillMapper.selectByIdV2(killId);
            // 判断是否可以被秒杀
            if (itemKill != null && 1 == itemKill.getCanKill() && itemKill.getTotal() > 0) {
                // 扣减库存，减 1
                int res = itemKillMapper.updateKillItem(killId);
                // 扣减是否成功？成功：生成秒杀成功的订单, 同时通知用户秒杀成功的消息
                if (res > 0) {
                    commonRecordKillSuccessInfo(itemKill, userId);
                    result = true;
                }
            }
        } else {
            throw new Exception("您已经抢购过该商品了");
        }
        return result;
    }

    /**
     * Redis的分布式锁
     */
    @Override
    public Boolean killItemV3(Integer killId, Integer userId) throws Exception {
        Boolean result = false;
        // 判断当前用户是否已经抢购过当前的商品
        if (itemKillSuccessMapper.countByKillUserId(killId, userId) <= 0) {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            String key = new StringBuffer().append(killId).append(userId).append("-RedisLock").toString();
            String value = RandomUtil.generateOrderCode();
            // setIfAbsent 只有不存在 key 的时候，才能 set 成功。
            Boolean cacheRes = valueOperations.setIfAbsent(key, value);
            /**
             * 如果操作了上面的步骤之后，Redis 宕机了。那么后面就会这个 key 就释放不了。
             * 第一种方法：可以使用 lua 脚本
             * 第二种方法：使用 Redisson 锁
             */
            if (cacheRes) {
                try {
                    redisTemplate.expire(key, 30, TimeUnit.SECONDS);
                    // 查询待秒杀商品详情
                    ItemKill itemKill = itemKillMapper.selectByIdV2(killId);
                    // 判断是否可以被秒杀
                    if (itemKill != null && 1 == itemKill.getCanKill() && itemKill.getTotal() > 0) {
                        // 扣减库存，减 1
                        int res = itemKillMapper.updateKillItem(killId);
                        // 扣减是否成功？成功：生成秒杀成功的订单, 同时通知用户秒杀成功的消息
                        if (res > 0) {
                            commonRecordKillSuccessInfo(itemKill, userId);
                            result = true;
                        }
                    }
                } catch (Exception e) {
                    throw new Exception("还没到抢购日期, 已过了抢购时间或已被抢购完毕!");
                } finally {
                    if (value.equals(valueOperations.get(key).toString())) {
                        // 释放锁
                        redisTemplate.delete(key);
                    }
                }
            }
        } else {
            throw new Exception("您已经抢购过该商品了");
        }
        return result;
    }

    /**
     * 使用 Redisson 
     */
    @Override
    public Boolean killItemV4(Integer killId, Integer userId) throws Exception {
        Boolean result = false;
        String key = new StringBuffer().append(killId).append(userId).append("-RedissonLock").toString();
        RLock rLock = redissonClient.getLock(key);
        try {
            Boolean cacheRes = rLock.tryLock(30, 10, TimeUnit.SECONDS);
            if (cacheRes) {
                // 执行核心业务逻辑
                // 判断当前用户是否已经抢购过当前的商品
                if (itemKillSuccessMapper.countByKillUserId(killId, userId) <= 0) {
                    // 查询待秒杀商品详情
                    ItemKill itemKill = itemKillMapper.selectByIdV2(killId);
                    // 判断是否可以被秒杀
                    if (itemKill != null && 1 == itemKill.getCanKill() && itemKill.getTotal() > 0) {
                        // 扣减库存，减 1
                        int res = itemKillMapper.updateKillItem(killId);
                        // 扣减是否成功？成功：生成秒杀成功的订单, 同时通知用户秒杀成功的消息
                        if (res > 0) {
                            commonRecordKillSuccessInfo(itemKill, userId);
                            result = true;
                        }
                    }
                } else {
                    throw new Exception("您已经抢购过该商品了");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
        return result;
    }

    @Override
    public Boolean killItemV5(Integer killId, Integer userId) {
        return null;
    }

    /**
     * 记录用户秒杀成功后生成的订单，并进行异步邮件消息的通知
     */
    private void commonRecordKillSuccessInfo(ItemKill itemKill, Integer userId) {
        // 记录抢购成功后，生成的秒杀订单记录
        ItemKillSuccess itemKillSuccess = new ItemKillSuccess();
        // 使用雪花算法，生成订单 id
        String orderId = String.valueOf(snowFlake.nextId());
        itemKillSuccess.setCode(orderId);
        itemKillSuccess.setItemId(itemKill.getItemId());
        itemKillSuccess.setKillId(itemKill.getId());
        itemKillSuccess.setUserId(userId.toString());
        itemKillSuccess.setStatus(SysConstant.OrderStatus.SuccessNotPayed.getCode().byteValue());
        itemKillSuccess.setCreateTime(new Date());
        //
        if (itemKillSuccessMapper.countByKillUserId(itemKill.getId(), userId) <= 0) {
            int res = itemKillSuccessMapper.insertSelective(itemKillSuccess);
            if (res > 0) {
                // 进行异步邮件消息的通知，使用 RabbitMQ
                rabbitSenderService.sendKillSuccessEmailMsg(orderId);
                // 入死信队列，用于 "失效" 超过指定的 TTL 时间时仍然未支付的订单
                rabbitSenderService.sendKillSuccessOrderExpireMsg(orderId);
            }
        }
    }
}
