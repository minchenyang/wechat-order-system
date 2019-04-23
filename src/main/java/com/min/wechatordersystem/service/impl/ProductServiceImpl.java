package com.min.wechatordersystem.service.impl;

import com.min.wechatordersystem.dao.ProductInfoDao;
import com.min.wechatordersystem.entity.ProductInfo;
import com.min.wechatordersystem.entity.dto.CartDTO;
import com.min.wechatordersystem.entity.enums.ResultEnum;
import com.min.wechatordersystem.entity.enums.Status;
import com.min.wechatordersystem.exception.CustomException;
import com.min.wechatordersystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao dao;


    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> product = dao.findById(productId);
        dao.findById(productId);
        return product.get();
    }

    @Override
    public List<ProductInfo> findAll() {
        return dao.findByProductStatus(Status.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return dao.save(productInfo);
    }

    @Override
    @Transactional
    public void decreaseStork(List<CartDTO> cartDTOList) {
        List<String> collect = cartDTOList.stream().map(CartDTO::getProductId).collect(Collectors.toList());
        //取出所有对应主键的商品
        List<ProductInfo> productList = dao.findAll((Specification<ProductInfo>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(root.get("productId").as(String.class).in(collect));//in
            Predicate[] p = new Predicate[list.size()];
            criteriaQuery.where(criteriaBuilder.and(list.toArray(p)));
            return criteriaQuery.getRestriction();
        });

        for (CartDTO cartDTO : cartDTOList) {
            ListIterator<ProductInfo> productInfoListIterator = productList.listIterator();
            while (productInfoListIterator.hasNext()) {
                ProductInfo next = productInfoListIterator.next();
                if (next.getProductId().equals(cartDTO.getProductId())) {
                    if (next.getProductStock() - cartDTO.getProductQuantity() < 0) {
                        throw new CustomException(ResultEnum.SHORTAGE_OF_GOODS);
                    }
                    next.setProductStock(next.getProductStock() - cartDTO.getProductQuantity());
                    productInfoListIterator.remove();
                }
            }
        }
        dao.saveAll(productList);
    }
}
