package com.yingsh.o2o.dao;

import com.yingsh.o2o.BaseTest;
import com.yingsh.o2o.entity.PersonInfo;
import com.yingsh.o2o.entity.WeChatAuth;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WechatAuthDaoTest extends BaseTest {
	@Autowired
	private WechatAuthDao wechatAuthDao;

	@Test
	@Ignore
	public void testAInsertWechatAuth() throws Exception {
		// 新增一条微信帐号
		WeChatAuth wechatAuth = new WeChatAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		// 给微信帐号绑定上用户信息
		wechatAuth.setPersonInfo(personInfo);
		// 随意设置上openId
		wechatAuth.setOpenId("dafahizhfdhaih");
		wechatAuth.setCreateTime(new Date());
		int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testBQueryWechatAuthByOpenId() throws Exception {
		WeChatAuth wechatAuth = wechatAuthDao.queryWechatInfoByOpenId("dafahizhfdhaih");
		assertEquals("测试", wechatAuth.getPersonInfo().getName());
	}

}
