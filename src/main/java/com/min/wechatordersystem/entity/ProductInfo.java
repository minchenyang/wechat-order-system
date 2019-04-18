package com.min.wechatordersystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "product_info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {
    @Id//主键
    @Column(name = "product_id")
    private String productId;
    //名字
    @Column(name = "product_name")
    private String productName;
    //单价
    @Column(name = "product_price")
    private BigDecimal productPrice;
    //库存
    @Column(name = "product_stock")
    private String productStock;
    //描述
    @Column(name = "product_description")
    private String productDescription;
    //小图
    @Column(name = "product_icon")
    private String productIcon;
    //类目编号
    @Column(name = "category_type")
    private Integer categoryType;

    //商品状态 0正常 1下架
    @Column(name = "product_status")
    private Integer productStatus;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;

}
