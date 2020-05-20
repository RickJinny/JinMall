package com.rick.jinmall.seckill.controller;

import com.rick.jinmall.seckill.mapper.ItemKillSuccessMapper;
import com.rick.jinmall.seckill.model.BaseResponse;
import com.rick.jinmall.seckill.model.KillDto;
import com.rick.jinmall.seckill.model.StatusCode;
import com.rick.jinmall.seckill.service.KillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class KillController {

    private static final Logger log = LoggerFactory.getLogger(KillController.class);

    private static final String prefix = "kill";

    @Autowired
    private KillService killService;

    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;

    /***
     * 商品秒杀核心业务逻辑
     */
    @RequestMapping(value = prefix + "/execute", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BaseResponse execute(@RequestBody @Validated KillDto dto, BindingResult result, HttpSession session) {
        if (result.hasErrors() || dto.getKillId() <= 0) {
            return new BaseResponse(StatusCode.INVALID_PARAMS);
        }
        Object uId = session.getAttribute("uid");
        if (uId == null) {
            return new BaseResponse(StatusCode.USER_NOT_LOGIN);
        }
        Integer userId = (Integer) uId;
        BaseResponse response = new BaseResponse(StatusCode.SUCCESS);
        try {
            Boolean res = killService.killItem(dto.getKillId(), userId);
            if (!res) {
                return new BaseResponse(StatusCode.FAIL.getCode(), "哈哈~商品已抢购完毕或者不在抢购时间段哦!");
            }
        } catch (Exception e) {
            response = new BaseResponse(StatusCode.FAIL.getCode(), e.getMessage());
        }
        return response;
    }
}
