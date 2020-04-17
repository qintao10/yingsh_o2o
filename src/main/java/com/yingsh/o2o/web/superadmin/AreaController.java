package com.yingsh.o2o.web.superadmin;

import com.yingsh.o2o.entity.Area;
import com.yingsh.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qt on 2020/4/9.
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {

    Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listArea() {
        logger.info("-----start-----");
        long startTime = System.currentTimeMillis();
        Map<String, Object> ModelMap = new HashMap<String, Object>();
        List<Area> areaList = new ArrayList<Area>();
        try {
            areaList = areaService.QueryAreaList();
            ModelMap.put("rows", areaList);
            ModelMap.put("total", areaList.size());
        } catch (Exception e) {
            e.printStackTrace();
            ModelMap.put("success", false);
            ModelMap.put("error", e.toString());
        }
        logger.error("error test");
        long endTime = System.currentTimeMillis();
        logger.debug("cosTime[{}ms]", endTime - startTime);
        logger.info("-----end-----");
        return ModelMap;
    }
}
