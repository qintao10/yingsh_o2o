package com.yingsh.o2o.service;

import com.yingsh.o2o.BaseTest;
import com.yingsh.o2o.dto.WechatAuthExecution;
import com.yingsh.o2o.entity.PersonInfo;
import com.yingsh.o2o.entity.WeChatAuth;
import com.yingsh.o2o.enums.WechatAuthStateEnum;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class WechatAuthServiceTest extends BaseTest {
	@Autowired
	private WechatAuthService wechatAuthService;

	@Test
	@Ignore
	public void testRegister() {
		// 新增一条微信帐号
		WeChatAuth wechatAuth = new WeChatAuth();
		PersonInfo personInfo = new PersonInfo();
		String openId = "dafahizhfdhaih";
		// 给微信帐号设置上用户信息，但不设置上用户Id
		// 希望创建微信帐号的时候自动创建用户信息
		personInfo.setCreateTime(new Date());
		personInfo.setName("测试一下");
		personInfo.setUserType(1);
		wechatAuth.setPersonInfo(personInfo);
		wechatAuth.setOpenId(openId);
		wechatAuth.setCreateTime(new Date());
		WechatAuthExecution wae = wechatAuthService.register(wechatAuth);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), wae.getState());
		// 通过openId找到新增的wechatAuth
		wechatAuth = wechatAuthService.getWechatAuthByOpenId(openId);
		// 打印用户名字看看跟预期是否相符
		System.out.println(wechatAuth.getPersonInfo().getName());
	}
}
