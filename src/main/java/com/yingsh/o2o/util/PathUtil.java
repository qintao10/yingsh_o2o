package com.yingsh.o2o.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by qt on 2020/4/11.
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator");   //得到读取系统的文件分割符
    private static String os = System.getProperty("os.name");        //得到读取什么系统
    private static Logger logger = LoggerFactory.getLogger(PathUtil.class);

    //图片绝对路径
    public static String getImgBasePath() {
        String basePath = "";
        logger.debug("操作系统名称:" + os.toLowerCase());
        if (os.toLowerCase().equals("windows 10")) {
            basePath = "F:/java/image";
        } else {
            basePath = "/home/yingsh/image";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    //各店铺图片相对路径
    public static String getShopImagePath(Long shopId) {
        String imagePath = "";
        imagePath = "/upload/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
