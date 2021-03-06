package com.min.wechatordersystem.service;

import com.min.wechatordersystem.entity.OrderDetail;
import com.min.wechatordersystem.entity.ProductInfo;
import com.min.wechatordersystem.entity.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品
 */
public interface ProductService {

    ProductInfo findOne(String productId);
    List<ProductInfo> findAll();
    //分页
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    //加库存

    //减库存
    void decreaseStork(List<CartDTO> orderDetailList);
}
