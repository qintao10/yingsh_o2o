package com.yingsh.o2o.web.shopadmin;

import com.yingsh.o2o.dto.ProductCategoryExecution;
import com.yingsh.o2o.dto.Result;
import com.yingsh.o2o.entity.ProductCategory;
import com.yingsh.o2o.entity.Shop;
import com.yingsh.o2o.enums.ProductCategoryEnums;
import com.yingsh.o2o.exceptions.ProductCategoryOperationException;
import com.yingsh.o2o.service.ProductGategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qt on 2020/4/13.
 */
@Controller
@RequestMapping("/shopadmin")
public class ProductCategoryManagementController {

    @Autowired
    private ProductGategoryService productGategoryService;

    @RequestMapping(value = "/getproductcategorylist", method = RequestMethod.GET)
    @ResponseBody
    private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request) {
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        List<ProductCategory> productCategoryList = null;
        if (currentShop != null && currentShop.getShopId() > 0) {
            productCategoryList = productGategoryService.getProductCategoryList(currentShop.getShopId());
            return new Result<List<ProductCategory>>(true, productCategoryList);
        } else {
            ProductCategoryEnums pe = ProductCategoryEnums.INNER_ERROR;
            return new Result<List<ProductCategory>>(false, pe.getState(), pe.getStateInfo());
        }
    }

    @RequestMapping(value = "/addproductcategorys", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> addproductcategorys(@RequestBody List<ProductCategory> productCategoryList,
                                                    HttpServletRequest request) {
        Map<String, Object> ModelMap = new HashMap<String, Object>();
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        for (ProductCategory pc : productCategoryList) {
            pc.setShopId(currentShop.getShopId());
            pc.setCreateTime(new Date());
        }
        if (productCategoryList != null && productCategoryList.size() > 0){
            try {
                ProductCategoryExecution pe = productGategoryService.batchAddProductCategory(productCategoryList);
                if(pe.getState() == ProductCategoryEnums.SUCCESS.getState()){
                    ModelMap.put("success",true);
                }else{
                    ModelMap.put("success",false);
                    ModelMap.put("errMsg",pe.getStateInfo());
                }
            }catch (Exception e){
                ModelMap.put("success",false);
                ModelMap.put("errMsg",e.getMessage());
                return ModelMap;
            }
        }else{
            ModelMap.put("success",false);
            ModelMap.put("errMsg","请至少输入一个商品类别");
        }
        return ModelMap;
    }

    @RequestMapping(value = "/removeproductcategory", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> removeProductCategory(Long productCategoryId, HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (productCategoryId != null && productCategoryId > 0) {
            try {
                Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
                ProductCategoryExecution pe = productGategoryService.deleteProductCategory(productCategoryId,
                        currentShop.getShopId());
                if (pe.getState() == ProductCategoryEnums.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", pe.getStateInfo());
                }
            } catch (ProductCategoryOperationException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }

        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请至少选择一个商品类别");
        }
        return modelMap;
    }
}
