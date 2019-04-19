package com.min.wechatordersystem.entity.vo;

import com.min.wechatordersystem.entity.OrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class OrderVO {
    private String name;
    private String phone;
    private String address;
    //用户微信
    private String openid;
    private List<OrderDetail> OrderDetailList;
}
