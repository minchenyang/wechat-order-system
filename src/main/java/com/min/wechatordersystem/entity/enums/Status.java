package com.min.wechatordersystem.entity.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum Status {
    UP(0, "在架"),
    DOWN(1, "下架");
    private Integer code;
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
