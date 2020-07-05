/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.service.domain.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.ygsoft.ecp.core.framework.annotations.Topic;
import com.ygsoft.necp.component.genentity.domain.model.GenBizEntity;

/**
 * UserInfo的POJO类.<br>
 * 
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
@Entity
@Table(name = "userInfo", indexes = {})
@Topic(classId = "10002", typeId = "10002")
public class UserInfo extends GenBizEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
												
	/**
	 * 生日.
	 */
	private String birthday;
											
	/**
	 * 昵称.
	 */
	private String nickName;
											
	/**
	 * 真实姓名.
	 */
	private String realName;
											
	/**
	 * 性别.
	 */
	private String sex;
											
	/**
	 * 家庭住址.
	 */
	private String homeAddress;
											
	/**
	 * 学历.
	 */
	private String education;
											
	/**
	 * 月薪.
	 */
	private String pay;
											
	/**
	 * 个人签名.
	 */
	private String personalSign;
	
	private byte[] head;
	
	/**
     * 生日的get方法
     * @return birthday
     */
	@Column(name = "BIRTHDAY", nullable = true, length = 50)
    public String getBirthday() {
        return birthday;
    }
		
    /**
     * 设置生日.
     * @param birthday
     */
    public void setBirthday(final String newBirthday) {
		this.birthday = newBirthday;
	}
	
	/**
     * 昵称的get方法
     * @return nickName
     */
	@Column(name = "NICKNAME", nullable = false,unique=true, length = 20)
    public String getNickName() {
        return nickName;
    }
		
    /**
     * 设置昵称.
     * @param nickName
     */
    public void setNickName(final String newNickName) {
		this.nickName = newNickName;
	}
	
	/**
     * 真实姓名的get方法
     * @return realName
     */
	@Column(name = "REALNAME", nullable = true, length = 15)
    public String getRealName() {
        return realName;
    }
		
    /**
     * 设置真实姓名.
     * @param realName
     */
    public void setRealName(final String newRealName) {
		this.realName = newRealName;
	}
	
	/**
     * 性别的get方法
     * @return sex
     */
	@Column(name = "SEX", nullable = true, length = 20)
    public String getSex() {
        return sex;
    }
		
    /**
     * 设置性别.
     * @param sex
     */
    public void setSex(final String newSex) {
		this.sex = newSex;
	}
	
	/**
     * 家庭住址的get方法
     * @return homeAddress
     */
	@Column(name = "HOMEADDRESS", nullable = true, length = 30)
    public String getHomeAddress() {
        return homeAddress;
    }
		
    /**
     * 设置家庭住址.
     * @param homeAddress
     */
    public void setHomeAddress(final String newHomeAddress) {
		this.homeAddress = newHomeAddress;
	}
	
	/**
     * 学历的get方法
     * @return education
     */
	@Column(name = "EDUCATION", nullable = true, length = 10)
    public String getEducation() {
        return education;
    }
		
    /**
     * 设置学历.
     * @param education
     */
    public void setEducation(final String newEducation) {
		this.education = newEducation;
	}
	
	/**
     * 月薪的get方法
     * @return pay
     */
	@Column(name = "PAY", nullable = true, length = 20)
    public String getPay() {
        return pay;
    }
		
    /**
     * 设置月薪.
     * @param pay
     */
    public void setPay(final String newPay) {
		this.pay = newPay;
	}
	
	/**
     * 个人签名的get方法
     * @return personalSign
     */
	@Column(name = "PERSONALSIGN", nullable = true, length = 50)
    public String getPersonalSign() {
        return personalSign;
    }
		
    /**
     * 设置个人签名.
     * @param personalSign
     */
    public void setPersonalSign(final String newPersonalSign) {
		this.personalSign = newPersonalSign;
	}
    
    @Lob
    @Column(name = "head", nullable = true, length = 500)
	public byte[] getHead() {
		return head;
	}

	public void setHead(byte[] head) {
		this.head = head;
	}
}
