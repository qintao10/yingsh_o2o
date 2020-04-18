package com.yingsh.o2o.service;

import com.yingsh.o2o.entity.Area;

import java.util.List;

/**
 * Created by qt on 2020/4/9.
 */
public interface AreaService {

    public static final String AREAKEY = "arealist";

    List<Area> QueryAreaList();
}
