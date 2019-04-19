package com.min.wechatordersystem.dao;

import com.min.wechatordersystem.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {
}
