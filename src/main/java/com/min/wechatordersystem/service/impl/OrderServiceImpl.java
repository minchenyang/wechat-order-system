package com.min.wechatordersystem.service.impl;

import com.min.wechatordersystem.dao.OrderDetailDao;
import com.min.wechatordersystem.dao.OrderMasterDao;
import com.min.wechatordersystem.entity.OrderDetail;
import com.min.wechatordersystem.entity.OrderMaster;
import com.min.wechatordersystem.entity.ProductInfo;
import com.min.wechatordersystem.entity.enums.ResultEnum;
import com.min.wechatordersystem.entity.vo.OrderVO;
import com.min.wechatordersystem.exception.CustomException;
import com.min.wechatordersystem.service.OrderService;
import com.min.wechatordersystem.service.ProductService;
import com.min.wechatordersystem.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    public OrderVO create(OrderVO orderVo) {
        String orderId = KeyUtils.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //1.查询 商品 数量 价格
        for (OrderDetail orderDetail : orderVo.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new CustomException(ResultEnum.RESULT_NOT_EXIST);
            }
            //计算总价
            orderAmount = orderDetail.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtils.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailDao.save(orderDetail);
        }
        // 订单表入库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderVo, orderMaster);
        orderMasterDao.save(orderMaster);

        return null;
    }
}
