package com.yingsh.o2o.dao;

import com.yingsh.o2o.entity.Area;

import java.util.List;

/**
 * Created by qt on 2020/4/9.
 */
public interface AreaDao {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Area> QueryArea();
}
