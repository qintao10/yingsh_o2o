package com.yingsh.o2o.service;

import com.yingsh.o2o.dto.ProductCategoryExecution;
import com.yingsh.o2o.entity.ProductCategory;
import com.yingsh.o2o.exceptions.ProductCategoryOperationException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qt on 2020/4/13.
 */
public interface ProductGategoryService {

    /**
     * 查询指定某个店铺下的所有商品类别信息
     *
     * @param shopId
     * @return List<ProductCategory>
     */
    List<ProductCategory> getProductCategoryList(long shopId);

    /**
     * 批量插入商品类别信息
     *
     * @param productCategoryList
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;


    /**
     * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws RuntimeException
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
            throws ProductCategoryOperationException;


}
