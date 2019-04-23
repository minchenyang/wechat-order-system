package com.min.wechatordersystem.service.impl;

import com.min.wechatordersystem.dao.OrderDetailDao;
import com.min.wechatordersystem.dao.OrderMasterDao;
import com.min.wechatordersystem.entity.OrderDetail;
import com.min.wechatordersystem.entity.OrderMaster;
import com.min.wechatordersystem.entity.ProductInfo;
import com.min.wechatordersystem.entity.dto.CartDTO;
import com.min.wechatordersystem.entity.enums.ResultEnum;
import com.min.wechatordersystem.entity.vo.OrderVO;
import com.min.wechatordersystem.exception.CustomException;
import com.min.wechatordersystem.service.OrderService;
import com.min.wechatordersystem.service.ProductService;
import com.min.wechatordersystem.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
        //扣除库存
        List<CartDTO> collect = orderVo.getOrderDetailList().stream().map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productService.decreaseStork(collect);
        return orderVo;
    }

    @Override
    public OrderVO findOne(String orderId) {
        Optional<OrderMaster> optional = orderMasterDao.findById(orderId);
        OrderVO orderVO = new OrderVO();
        OrderMaster orderMaster = optional.get();
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
        orderVO.setOrderDetailList(orderDetailList);
        BeanUtils.copyProperties(orderMaster, orderVO);
        orderVO.setName(orderMaster.getBuyerName());
        orderVO.setAddress(orderMaster.getBuyerAddress());
        orderVO.setPhone(orderMaster.getBuyerPhone());
        orderVO.setOpenid(orderMaster.getBuyerOpenid());
        return orderVO;
    }

    @Override
    public Page<OrderVO> findList(String buyerOpenid, Pageable pageable) {

        return null;
    }

    @Override
    public OrderVO cancel(OrderVO orderVO) {
        return null;
    }

    @Override
    public OrderVO finish(OrderVO orderVO) {
        return null;
    }

    @Override
    public OrderVO paid(OrderVO orderVO) {
        return null;
    }
}
