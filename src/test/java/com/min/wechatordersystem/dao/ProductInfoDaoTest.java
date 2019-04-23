package com.min.wechatordersystem.dao;

import com.min.wechatordersystem.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao dao;

    @Test
    public void save() {
    }

    @Test
    public void getAll() {
        List<ProductInfo> all = dao.findAll(new SinoSpecification<ProductInfo>());
        System.out.println("------------" + all);
    }

    @Test
    public void getBySelect() {
        List<ProductInfo> sql = dao.findSQL("1");
        System.out.println("------------" + sql);
    }

}

class SinoSpecification<T> implements Specification<T> {

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<>();
        //list.add(cb.equal(root.get("productName").as(String.class), "1"));//某普通字段
        ArrayList<String> strings = new ArrayList<>();
        strings.add("0");
        list.add(root.get("productId").as(String.class).in(strings));//in
        Predicate[] p = new Predicate[list.size()];
        query.where(cb.and(list.toArray(p)));
        return query.getRestriction();
    }
}