package com.min.wechatordersystem.service.impl;

import com.min.wechatordersystem.entity.OrderDetail;
import com.min.wechatordersystem.entity.dto.CartDTO;
import com.min.wechatordersystem.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void decreaseStork() {
        List<CartDTO> cartDTOs = Arrays.asList(
                new CartDTO("1", 10),
                new CartDTO("2", 20),
                new CartDTO("3", 30)
        );
        productService.decreaseStork(cartDTOs);
    }
}