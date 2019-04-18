package com.min.wechatordersystem.service.impl;

import com.min.wechatordersystem.dao.ProductCategoryDao;
import com.min.wechatordersystem.entity.ProductCategory;
import com.min.wechatordersystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDao dao;

    @Override
    public ProductCategory findOne(Integer id) {
        Optional<ProductCategory> optional = dao.findById(id);
        return optional.get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> ids) {
        return dao.findByCategoryTypeIn(ids);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return dao.save(productCategory);
    }
}
