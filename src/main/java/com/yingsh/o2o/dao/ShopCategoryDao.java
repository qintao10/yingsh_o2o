package com.yingsh.o2o.dao;

import com.yingsh.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qt on 2020/4/11.
 */
public interface ShopCategoryDao {

    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);

}
