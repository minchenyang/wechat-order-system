package com.min.wechatordersystem.service;

import com.min.wechatordersystem.entity.ProductCategory;

import java.util.List;

public interface CategoryService {
    ProductCategory findOne(Integer id);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> ids);
    ProductCategory save(ProductCategory productCategory);
}
