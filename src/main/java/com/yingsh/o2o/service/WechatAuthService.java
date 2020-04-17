package com.yingsh.o2o.service;

import com.yingsh.o2o.dto.WechatAuthExecution;
import com.yingsh.o2o.entity.WeChatAuth;
import com.yingsh.o2o.exceptions.WechatAuthOperationException;

public interface WechatAuthService {

	/**
	 * 通过openId查找平台对应的微信帐号
	 * 
	 * @param openId
	 * @return
	 */
	WeChatAuth getWechatAuthByOpenId(String openId);

	/**
	 * 注册本平台的微信帐号
	 * 
	 * @param wechatAuth
	 * @return
	 * @throws RuntimeException
	 */
	WechatAuthExecution register(WeChatAuth wechatAuth) throws WechatAuthOperationException;

}
