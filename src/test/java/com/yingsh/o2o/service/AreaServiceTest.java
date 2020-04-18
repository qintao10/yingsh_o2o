package com.yingsh.o2o.service;

import com.yingsh.o2o.BaseTest;
import com.yingsh.o2o.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by qt on 2020/4/9.
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Autowired
    private CacheService cacheService;

    @Test
    public void getAreaList(){
        List<Area> areaList = areaService.QueryAreaList();
        cacheService.removeFromCache(areaService.AREAKEY);
        areaList = areaService.QueryAreaList();
        assertEquals(2, areaList.size());
    }
}
