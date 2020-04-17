package com.yingsh.o2o.enums;

/**
 * Created by qt on 2020/4/13.
 */
public enum ProductCategoryEnums {
    SUCCESS(1, "创建成功"), INNER_ERROR(-1001, "操作失败"), EMPTY_LIST(-1002, "添加少于1");

    private int state;

    private String stateInfo;

    private ProductCategoryEnums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ProductCategoryEnums stateOf(int index){
        for(ProductCategoryEnums state : values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
