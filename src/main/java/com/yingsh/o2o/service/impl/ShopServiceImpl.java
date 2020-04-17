package com.yingsh.o2o.service.impl;

import com.yingsh.o2o.dao.ShopDao;
import com.yingsh.o2o.dto.ImageHolder;
import com.yingsh.o2o.dto.ShopExecution;
import com.yingsh.o2o.entity.Shop;
import com.yingsh.o2o.enums.ShopStateEnums;
import com.yingsh.o2o.exceptions.ShopOperationException;
import com.yingsh.o2o.service.ShopService;
import com.yingsh.o2o.util.ImageUtil;
import com.yingsh.o2o.util.PageCalculator;
import com.yingsh.o2o.util.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by qt on 2020/4/11.
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    private static Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        //将页码转换成行码
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        //依据查询条件，调用dao层返回相关的店铺列表
        List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
        //依据相同的查询条件，返回店铺总数
        int count = shopDao.queryShopCount(shopCondition);
        ShopExecution se = new ShopExecution();
        if (shopList != null) {
            se.setShopList(shopList);
            se.setCount(count);
        } else {
            se.setState(ShopStateEnums.INNER_ERROR.getState());
        }
        return se;
    }

    @Override
    public Shop getByShopId(long shopId) {
        return shopDao.queryByShopId(shopId);
    }

    @Override
    @Transactional
    public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {
        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnums.NULL_SHOP);
        } else {
            // 1.判断是否需要处理图片
            try {
                if (thumbnail.getImage() != null && thumbnail.getImageName() != null
                        && !"".equals(thumbnail.getImageName())) {
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if (tempShop.getShopImg() != null) {
                        ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                    }
                    addShopImage(shop, thumbnail);
                }
                // 2.更新店铺信息
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnums.INNER_ERROR);
                } else {
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnums.SUCCESS, shop);
                }
            } catch (Exception e) {
                throw new ShopOperationException("modifyShop error:" + e.getMessage());
            }
        }
    }

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {
        // 空值判断
        if (shop == null) {
            return new ShopExecution(ShopStateEnums.NULL_SHOP);
        }
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            // 添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                return new ShopExecution(ShopStateEnums.INNER_ERROR);
            } else {
                if (thumbnail.getImage() != null) {
                    // 存储图片
                    addShopImage(shop, thumbnail);
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0) {
                        return new ShopExecution(ShopStateEnums.INNER_ERROR);
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addshop error" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnums.CHECK, shop);
    }

    private void addShopImage(Shop shop, ImageHolder thumbnail) {
        // 获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
        shop.setShopImg(shopImgAddr);
    }
}
