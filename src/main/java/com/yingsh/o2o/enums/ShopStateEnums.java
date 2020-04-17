package com.yingsh.o2o.enums;

/**
 * Created by qt on 2020/4/11.
 */
public enum ShopStateEnums {
    CHECK(0, "审核中"), OFFLINE(-1, "非法店铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(-1001,
            "内部系统错误"), NULL_SHOPID(-1002, "ShopId为空"),NULL_SHOP(-1003, "shop信息为空");

    private int state;
    private String stateInfo;

    private ShopStateEnums(int state,String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 依据传入的state返回相应的enum值
     */
    private static ShopStateEnums stateOf(int state){
        for(ShopStateEnums stateEnums : values()){
            if(stateEnums.getState() == state){
                return stateEnums;
            }
        }
        return  null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
