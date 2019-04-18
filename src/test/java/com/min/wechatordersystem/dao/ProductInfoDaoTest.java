package com.min.wechatordersystem.dao;

import com.min.wechatordersystem.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao dao;

    @Test
    public void save(){}

    @Test
    public void getAll(){
        List<ProductInfo> all = dao.findAll();
        System.out.println(all);
    }
}