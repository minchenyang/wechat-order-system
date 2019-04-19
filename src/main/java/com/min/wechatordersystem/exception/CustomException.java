package com.min.wechatordersystem.exception;

import com.min.wechatordersystem.entity.enums.ResultEnum;

public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
