package com.min.wechatordersystem.service;

import com.min.wechatordersystem.entity.vo.OrderVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    //创建订单
    OrderVO create(OrderVO orderVo);

    //查询一个订单
    OrderVO findOne(String orderId);

    //查询订单列表
    Page<OrderVO> findList(String buyerOpenid, Pageable pageable);

    //取消订单
    OrderVO cancel(OrderVO orderVO);

    //完结订单
    OrderVO finish(OrderVO orderVO);

    //支付订单
    OrderVO paid(OrderVO orderVO);
}
