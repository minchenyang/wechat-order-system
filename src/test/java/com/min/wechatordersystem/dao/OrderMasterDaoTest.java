package com.min.wechatordersystem.dao;

import com.min.wechatordersystem.entity.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao dao;

    @Test
    public void findAll(){
        List<OrderMaster> all = dao.findAll();
        System.out.println(all);
    }
}