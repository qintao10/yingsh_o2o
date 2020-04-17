package com.yingsh.o2o.service.impl;

import com.yingsh.o2o.dao.ProductCategoryDao;
import com.yingsh.o2o.dao.ProductDao;
import com.yingsh.o2o.dto.ProductCategoryExecution;
import com.yingsh.o2o.entity.ProductCategory;
import com.yingsh.o2o.enums.ProductCategoryEnums;
import com.yingsh.o2o.exceptions.ProductCategoryOperationException;
import com.yingsh.o2o.service.ProductGategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qt on 2020/4/13.
 */
@Service
public class ProductGategoryServiceImpl implements ProductGategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.qureyProductCategoryList(shopId);
    }

    @Override
    @Transactional
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException {
        if (productCategoryList != null && productCategoryList.size() > 0) {
            try {
                int effectNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
                if (effectNum <= 0) {
                    throw new ProductCategoryOperationException("商品类别创建失败!");
                } else {
                    return new ProductCategoryExecution(ProductCategoryEnums.SUCCESS);
                }

            } catch (Exception e) {
                throw new ProductCategoryOperationException("batchAddProductCategory error is :" + e.getMessage());
            }
        } else {
            return new ProductCategoryExecution(ProductCategoryEnums.EMPTY_LIST);
        }
    }

    @Override
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
            throws ProductCategoryOperationException {
        // 解除tb_product里的商品与该producategoryId的关联
        try {
            int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
            if (effectedNum < 0) {
                throw new ProductCategoryOperationException("商品类别更新失败");
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("deleteProductCategory error: " + e.getMessage());
        }
        // 删除该productCategory
        try {
            int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("商品类别删除失败");
            } else {
                return new ProductCategoryExecution(ProductCategoryEnums.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
        }
    }
}
