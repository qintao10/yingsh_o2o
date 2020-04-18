package com.yingsh.o2o.service;

import com.yingsh.o2o.BaseTest;
import com.yingsh.o2o.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HeadLineServiceTest extends BaseTest {
	@Autowired
	private HeadLineService headLineService;

	@Test
	public void testGetHeadLineList() {
		List<HeadLine> headLineList = headLineService.getHeadLineList(new HeadLine());
		System.out.println(headLineList.get(0).getLineName());
		HeadLine headLineCondition = new HeadLine();
		headLineCondition.setEnableStatus(1);
		headLineList = headLineService.getHeadLineList(headLineCondition);
		System.out.println(headLineList.get(0).getLineName());
	}
}
