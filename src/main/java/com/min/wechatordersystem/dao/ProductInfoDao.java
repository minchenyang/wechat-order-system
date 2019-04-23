package com.min.wechatordersystem.dao;

import com.min.wechatordersystem.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoDao extends CrudRepository<ProductInfo, String>, JpaSpecificationExecutor<ProductInfo> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    //查询多个主键返回
    @Query(nativeQuery = true, value = "SELECT * FROM product_info WHERE product_id in (:productId) ")
    List<ProductInfo> findSQL(@Param("productId") String productId);
}
