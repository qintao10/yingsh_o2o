package com.yingsh.o2o.dto;

import com.yingsh.o2o.entity.ProductCategory;
import com.yingsh.o2o.enums.ProductCategoryEnums;

import java.util.List;

/**
 * Created by qt on 2020/4/14.
 */
public class ProductCategoryExecution {

    private int state;

    private String stateInfo;

    private List<ProductCategory> productCategoryList;

    public ProductCategoryExecution() {
    }
    // 操作失败的时候使用的构造器
    public ProductCategoryExecution(ProductCategoryEnums pe) {
        this.state = pe.getState();
        this.stateInfo = pe.getStateInfo();
    }
    // 操作成功的时候使用的构造器
    public ProductCategoryExecution(ProductCategoryEnums pe, List<ProductCategory> productCategoryList) {
        this.state = pe.getState();
        this.stateInfo = pe.getStateInfo();
        this.productCategoryList = productCategoryList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
