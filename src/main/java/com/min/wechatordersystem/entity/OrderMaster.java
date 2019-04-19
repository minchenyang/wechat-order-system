package com.min.wechatordersystem.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 */

@Entity
@DynamicUpdate//自动更新修改时间
@Data
public class OrderMaster {
    @Id
    private String OrderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;//订单状态 0默认新下单
    private Integer payStatus;//支付状态 0默认未支付
    private Date createTime;
    private Date updateTime;
}
