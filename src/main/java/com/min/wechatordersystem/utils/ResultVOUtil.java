package com.min.wechatordersystem.utils;

import com.min.wechatordersystem.entity.vo.ResultVO;

import java.util.ArrayList;
import java.util.List;

public class ResultVOUtil {
    private ResultVOUtil() {
    }

    /**
     * 封装响应返回结果 成功
     */
    public static <T> ResultVO<T> SUCCESS(ArrayList<T> list) {
        ResultVO<T> objectResultVO = new ResultVO<>();
        objectResultVO.setCode(0);
        objectResultVO.setMsg("success");
        objectResultVO.setData(list);
        return objectResultVO;
    }
}
