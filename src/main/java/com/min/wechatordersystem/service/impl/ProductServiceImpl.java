package com.min.wechatordersystem.service.impl;

import com.min.wechatordersystem.dao.ProductInfoDao;
import com.min.wechatordersystem.entity.ProductInfo;
import com.min.wechatordersystem.entity.enums.Status;
import com.min.wechatordersystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao dao;

    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> product = dao.findById(productId);
        return product.get();
    }

    @Override
    public List<ProductInfo> findAll() {
        return dao.findByProductStatus(Status.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return dao.save(productInfo);
    }
}
