package com.min.wechatordersystem.entity.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    RESULT_NOT_EXIST(10, "商品不存在"),
    SHORTAGE_OF_GOODS(11,"商品数量不足");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
