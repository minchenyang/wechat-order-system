package com.min.wechatordersystem.service;

import com.min.wechatordersystem.entity.ProductInfo;
import com.min.wechatordersystem.entity.vo.OrderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void findOne(){
        OrderVO one = orderService.findOne("1");
        System.out.println("--------------------------");
        System.out.println(one);
        System.out.println("--------------------------");
    }
}