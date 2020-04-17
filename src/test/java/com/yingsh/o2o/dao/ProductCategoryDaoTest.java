package com.yingsh.o2o.dao;

import com.yingsh.o2o.BaseTest;
import com.yingsh.o2o.entity.ProductCategory;
import com.yingsh.o2o.entity.Shop;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by qt on 2020/4/13.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest{

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    @Ignore
    public void testBQueryByShopId(){
        long shopId = 36L;
        List<ProductCategory> productCategoryList = productCategoryDao.qureyProductCategoryList(shopId);
        assertEquals(5,productCategoryList.size());
    }

    @Test
    @Ignore
    public void testABatchInsertProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("类别1");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(36L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("累呗2");
        productCategory2.setPriority(2);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(36L);
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory2);
        int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        assertEquals(2, effectedNum);
    }

    @Test
    @Ignore
    public void testCDeleteProductCategory() throws Exception {
        long shopId = 36;
        List<ProductCategory> productCategoryList = productCategoryDao.qureyProductCategoryList(shopId);
        for (ProductCategory pc : productCategoryList) {
            if ("累呗2".equals(pc.getProductCategoryName()) || "类别1".equals(pc.getProductCategoryName())) {
                int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(),
                        shopId);
                assertEquals(1, effectedNum);
            }
        }
    }

}
