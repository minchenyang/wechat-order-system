package com.min.wechatordersystem.dao;

import com.min.wechatordersystem.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductCategoryDao {

    @Autowired
    private ProductCategoryDao dao;

    @Test
    public void add() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(8);
        dao.save(productCategory);
    }

    @Test
    @Transactional//事务回滚 不会真的添加到数据库中去
    public void update() {
        Optional<ProductCategory> byId = dao.findById(4);
        ProductCategory productCategory = byId.get();
        productCategory.setCategoryType(12);
        dao.save(productCategory);
    }

    @Test
    public void customQuery(){
        List<Integer> integers = Arrays.asList(11, 8);
        List<ProductCategory> byCategoryTypeIn = dao.findByCategoryTypeIn(integers);
        System.out.println(byCategoryTypeIn);
    }
}
