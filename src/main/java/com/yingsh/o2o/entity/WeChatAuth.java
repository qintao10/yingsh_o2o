package com.yingsh.o2o.entity;

import java.util.Date;

/**
 * Created by qt on 2020/4/8.
 */
public class WeChatAuth {
    //微信用户ID
    private Long wechatAuthId;
    //微信唯一识别openId
    private String openId;
    //创建时间
    private Date createTime;
    //用户实体类对象
    private PersonInfo personInfo;

    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
