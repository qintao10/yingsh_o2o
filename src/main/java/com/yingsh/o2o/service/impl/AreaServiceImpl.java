package com.yingsh.o2o.service.impl;

import com.yingsh.o2o.dao.AreaDao;
import com.yingsh.o2o.entity.Area;
import com.yingsh.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qt on 2020/4/9.
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> QueryAreaList() {
        return areaDao.QueryArea();
    }
}
