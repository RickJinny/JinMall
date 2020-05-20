package com.rick.jinmall.seckill.service;

public interface KillService {

    Boolean killItem(Integer killId, Integer userId) throws Exception;

    Boolean killItemV2(Integer killId, Integer userId);

    Boolean killItemV3(Integer killId, Integer userId);

    Boolean killItemV4(Integer killId, Integer userId);

    Boolean killItemV5(Integer killId, Integer userId);

}
