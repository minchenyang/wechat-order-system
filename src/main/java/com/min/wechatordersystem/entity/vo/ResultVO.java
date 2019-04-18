package com.min.wechatordersystem.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResultVO<T> {
    //错误码
    private Integer Code;
    //提示信息
    private String msg;
    //具体内容
    private List<T> data;
}
