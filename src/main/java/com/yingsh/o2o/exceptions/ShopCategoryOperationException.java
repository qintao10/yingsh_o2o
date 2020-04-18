package com.yingsh.o2o.exceptions;

/**
 * Created by qt on 2020/4/18.
 */
public class ShopCategoryOperationException extends RuntimeException {

    private static final long serialVersionUID = 5423986306645291467L;

    public ShopCategoryOperationException(String msg){
        super(msg);
    }
}
