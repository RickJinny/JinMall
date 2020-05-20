package com.rick.jinmall.seckill.mapper;

import com.rick.jinmall.seckill.model.ItemKillSuccess;
import com.rick.jinmall.seckill.model.KillSuccessUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemKillSuccessMapper {

    int deleteByPrimaryKey(String code);

    int insert(ItemKillSuccess record);

    int insertSelective(ItemKillSuccess record);

    ItemKillSuccess selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ItemKillSuccess record);

    int updateByPrimaryKey(ItemKillSuccess record);

    int countByKillUserId(@Param("killId") Integer killId, @Param("userId") Integer userId);

    KillSuccessUserInfo selectByCode(@Param("code") String code);

    int expireOrder(@Param("code") String code);

    List<ItemKillSuccess> selectExpireOrders();

}