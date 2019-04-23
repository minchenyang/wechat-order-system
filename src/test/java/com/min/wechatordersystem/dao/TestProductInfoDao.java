package com.min.wechatordersystem.dao;

import com.min.wechatordersystem.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductInfoDao {

    @Autowired
    private ProductInfoDao dao;

    @Test
    public void save() {
        ProductInfo productInfo = ProductInfo.builder().productDescription("膨化食品").productIcon("xxx.jps").productId("1")
                .productName("威化饼干").productPrice(new BigDecimal(5)).productStatus(0).productStock(100).categoryType(1).createTime(null)
                .updateTime(null).build();
        dao.save(productInfo);
        productInfo.setProductId("2");
        dao.save(productInfo);
        productInfo.setProductId("3");
        dao.save(productInfo);
    }

}
