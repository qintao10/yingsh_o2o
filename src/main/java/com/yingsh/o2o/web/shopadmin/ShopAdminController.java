package com.yingsh.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qt on 2020/4/11.
 */
@Controller
@RequestMapping(value = "shopadmin", method = {RequestMethod.GET})
public class ShopAdminController {

    @RequestMapping(value = "/shopoperation")
    // 转发至店铺注册/编辑页面
    public String shopOperation() {
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    // 转发至店铺列表页面
    public String shopList() { return "shop/shoplist"; }

    @RequestMapping(value = "/shopmanagement")
    // 转发至店铺管理页面
    public String shopManagement() { return "shop/shopmanagement"; }

    @RequestMapping(value = "/productcategorymanagement")
    // 转发至类别管理页面
    public String productcategorymanagement() { return "shop/productcategorymanagement"; }

    @RequestMapping(value = "/productoperation")
    public String productOperation() {
        // 转发至商品添加/编辑页面
        return "shop/productoperation";
    }

    @RequestMapping(value = "/productmanagement")
    public String productManagement() {
        // 转发至商品管理页面
        return "shop/productmanagement";
    }

}
