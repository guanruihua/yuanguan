/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.service.domain.model.bo;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.ygsoft.ecp.core.framework.annotations.Topic;
import com.ygsoft.necp.component.genentity.domain.model.GenObjectEntity;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.UserTag;
import java.util.List;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostInfo;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostBrowse;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.ConcernUser;
import javax.persistence.Transient;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.UserInfo;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.ConcernPost;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PersonalPost;

/**
 * User的POJO类.<br>
 * 
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:25<br>
 * @since JDK 1.8.0_144
 */
@Entity
@Table(name = "user", indexes = {})
@Topic(classId = "1001", typeId = "10001")
public class User extends GenObjectEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
												
	/**
	 * 用户名.
	 */
	private String userName;
											
	/**
	 * 密码.
	 */
	private String password;
											
	/**
	 * 昵称.
	 */
	private String nickName;
											
	/**
	 * 邮箱.
	 */
	private String mailBox;
											
	/**
	 * 手机号.
	 */
	private String phone;
											
	/**
	 * 身份证.
	 */
	private String idCard;
						
	private String level;
	/**
	 * ref_用户信息.
	 */
	private UserInfo ref_UserInfo;
											
	/**
	 * ref_帖子信息.
	 */
	private List<PostInfo> ref_PostInfo;
											
	/**
	 * ref_关注用户.
	 */
	private List<ConcernUser> ref_ConcernUser;
											
	/**
	 * ref_关注帖子.
	 */
	private ConcernPost ref_ConcernPost;
											
	/**
	 * ref_帖子浏览记录.
	 */
	private List<PostBrowse> ref_PostBrowse;
											
	/**
	 * ref_用户标签.
	 */
	private List<UserTag> ref_UserTag;
											
	/**
	 * ref_我的帖子.
	 */
	private List<PersonalPost> ref_PersonalPost;
	
	/**
     * 用户名的get方法
     * @return userName
     */
	@Column(name = "USERNAME", nullable = false,unique=true, length = 20)
    public String getUserName() {
        return userName;
    }
		
    /**
     * 设置用户名.
     * @param userName
     */
    public void setUserName(final String newUserName) {
		this.userName = newUserName;
	}
	
	/**
     * 密码的get方法
     * @return password
     */
	@Column(name = "PASSWORD", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }
		
    /**
     * 设置密码.
     * @param password
     */
    public void setPassword(final String newPassword) {
		this.password = newPassword;
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
     * 邮箱的get方法
     * @return mailBox
     */
	@Column(name = "MAILBOX", nullable = false,unique=true, length = 30)
    public String getMailBox() {
        return mailBox;
    }
		
    /**
     * 设置邮箱.
     * @param mailBox
     */
    public void setMailBox(final String newMailBox) {
		this.mailBox = newMailBox;
	}
	
	/**
     * 手机号的get方法
     * @return phone
     */
	@Column(name = "PHONE", nullable = false,unique=true, precision = 11)
    public String getPhone() {
        return phone;
    }
		
    /**
     * 设置手机号.
     * @param phone
     */
    public void setPhone(final String phone) {
		this.phone = phone;
	}
	
	/**
     * 身份证的get方法
     * @return idCard
     */
	@Column(name = "IDCARD", nullable = false,unique=true, length = 18)
    public String getIdCard() {
        return idCard;
    }
		
    /**
     * 设置身份证.
     * @param idCard
     */
    public void setIdCard(final String newIdCard) {
		this.idCard = newIdCard;
	}
	
	/**
     * ref_用户信息的get方法
     * @return ref_UserInfo
     */
	@Transient
    public UserInfo getRef_UserInfo() {
        return ref_UserInfo;
    }
		
    /**
     * 设置ref_用户信息.
     * @param ref_UserInfo
     */
    public void setRef_UserInfo(final UserInfo newRef_UserInfo) {
		this.ref_UserInfo = newRef_UserInfo;
	}
	
	/**
     * ref_帖子信息的get方法
     * @return ref_PostInfo
     */
	@Transient
	public List<PostInfo> getRef_PostInfo() {
		return ref_PostInfo;
	}
		
    /**
     * 设置ref_帖子信息.
     * @param ref_PostInfo
     */
	public void setRef_PostInfo(final List<PostInfo> newRef_PostInfo) {
		this.ref_PostInfo = newRef_PostInfo;
	}
	
	/**
     * ref_关注用户的get方法
     * @return ref_ConcernUser
     */
	@Transient
	public List<ConcernUser> getRef_ConcernUser() {
		return ref_ConcernUser;
	}
		
    /**
     * 设置ref_关注用户.
     * @param ref_ConcernUser
     */
	public void setRef_ConcernUser(final List<ConcernUser> newRef_ConcernUser) {
		this.ref_ConcernUser = newRef_ConcernUser;
	}
	
	/**
     * ref_关注帖子的get方法
     * @return ref_ConcernPost
     */
	@Transient
    public ConcernPost getRef_ConcernPost() {
        return ref_ConcernPost;
    }
		
    /**
     * 设置ref_关注帖子.
     * @param ref_ConcernPost
     */
    public void setRef_ConcernPost(final ConcernPost newRef_ConcernPost) {
		this.ref_ConcernPost = newRef_ConcernPost;
	}
	
	/**
     * ref_帖子浏览记录的get方法
     * @return ref_PostBrowse
     */
	@Transient
	public List<PostBrowse> getRef_PostBrowse() {
		return ref_PostBrowse;
	}
		
    /**
     * 设置ref_帖子浏览记录.
     * @param ref_PostBrowse
     */
	public void setRef_PostBrowse(final List<PostBrowse> newRef_PostBrowse) {
		this.ref_PostBrowse = newRef_PostBrowse;
	}
	
	/**
     * ref_用户标签的get方法
     * @return ref_UserTag
     */
	@Transient
	public List<UserTag> getRef_UserTag() {
		return ref_UserTag;
	}
		
    /**
     * 设置ref_用户标签.
     * @param ref_UserTag
     */
	public void setRef_UserTag(final List<UserTag> newRef_UserTag) {
		this.ref_UserTag = newRef_UserTag;
	}
	
	/**
     * ref_我的帖子的get方法
     * @return ref_PersonalPost
     */
	@Transient
	public List<PersonalPost> getRef_PersonalPost() {
		return ref_PersonalPost;
	}
		
    /**
     * 设置ref_我的帖子.
     * @param ref_PersonalPost
     */
	public void setRef_PersonalPost(final List<PersonalPost> newRef_PersonalPost) {
		this.ref_PersonalPost = newRef_PersonalPost;
	}
	/**
	 * 序列化版本.
	 */
	@Column(name = "LEVEL", nullable = false, length = 10)
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}


