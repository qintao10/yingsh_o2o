package com.yingsh.o2o.dao;

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
public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void testQueryArea(){
        List<Area> areaList = areaDao.QueryArea();
        assertEquals(2,areaList.size());
    }
}
