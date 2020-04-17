package com.yingsh.o2o.exceptions;

/**
 * Created by qt on 2020/4/14.
 */
public class ProductCategoryOperationException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1182563719599527969L;

    public ProductCategoryOperationException(String msg){
        super(msg);
    }
}
