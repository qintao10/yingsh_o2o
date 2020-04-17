package com.yingsh.o2o.service;

import com.yingsh.o2o.BaseTest;
import com.yingsh.o2o.dto.ImageHolder;
import com.yingsh.o2o.dto.ShopExecution;
import com.yingsh.o2o.entity.Area;
import com.yingsh.o2o.entity.PersonInfo;
import com.yingsh.o2o.entity.Shop;
import com.yingsh.o2o.entity.ShopCategory;
import com.yingsh.o2o.enums.ShopStateEnums;
import com.yingsh.o2o.exceptions.ShopOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by qt on 2020/4/11.
 */
public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    @Ignore
    public void testGetShopList() {
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(22L);
        shopCondition.setShopCategory(sc);
        ShopExecution se = shopService.getShopList(shopCondition, 1, 2);
        System.out.println("店铺列表数为：" + se.getShopList().size());
        System.out.println("店铺总数为：" + se.getCount());
    }

    @Test
    @Ignore
    public void testModifyShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(50L);
        shop.setShopName("修改后的店铺名称");
//        File shopImg = new File("F:\\java\\image\\dabai.jpg");
//        InputStream is = new FileInputStream(shopImg);
//        ShopExecution shopExecution = shopService.modifyShop(shop, is, shopImg.getName());
        ShopExecution shopExecution = shopService.modifyShop(shop, null);
        System.out.println("新的图片地址为：" + shopExecution.getShop().getShopImg());
    }

    @Test
    @Ignore
    public void testShopService() {
        Shop shop = new Shop();
        Area area = new Area();
        PersonInfo personInfo = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        area.setAreaId(3);
        personInfo.setUserId(1L);
        shopCategory.setShopCategoryId(33L);
        shop.setOwner(personInfo);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺2");
        shop.setShopDesc("test2");
        shop.setShopAddr("test2");
        shop.setPhone("test2");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnums.CHECK.getState());
        File imgFile = new File("F:\\java\\image\\timg.jpg");
        InputStream is = null;
        try {
            is = new FileInputStream(imgFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageHolder imageHolder = new ImageHolder(imgFile.getName(), is);
        ShopExecution shopExecution = shopService.addShop(shop, imageHolder);
        assertEquals(ShopStateEnums.CHECK.getState(), shopExecution.getState());
    }
}
