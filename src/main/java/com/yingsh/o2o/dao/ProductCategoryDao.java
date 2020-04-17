package com.yingsh.o2o.dao;

import com.yingsh.o2o.dto.ProductCategoryExecution;
import com.yingsh.o2o.entity.ProductCategory;
import com.yingsh.o2o.exceptions.ProductCategoryOperationException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qt on 2020/4/13.
 */
public interface ProductCategoryDao {
    /**
     *
     * 通过shop id 查询店铺商品类别
     * @param shopId
     * @return List<ProductCategory>
     */
    List<ProductCategory> qureyProductCategoryList(long shopId);

    /**
     * 批量新增商品类别
     *
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 删除指定商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}
