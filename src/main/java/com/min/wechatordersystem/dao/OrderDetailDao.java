package com.min.wechatordersystem.dao;

import com.min.wechatordersystem.entity.OrderDetail;
import com.min.wechatordersystem.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
