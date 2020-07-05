/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.service.domain.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.ygsoft.ecp.core.framework.annotations.Topic;
import com.ygsoft.necp.component.genentity.domain.model.GenBizEntity;

/**
 * UserTag的POJO类.<br>
 * 
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:25<br>
 * @since JDK 1.8.0_144
 */
@Entity
@Table(name = "userTag", indexes = {})
@Topic(classId = "10002", typeId = "10008")
public class UserTag extends GenBizEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
												
	/**
	 * 用户ID.
	 */
	private int userID;
											
	/**
	 * 标签ID.
	 */
	private int tagID;
	
	/**
     * 用户ID的get方法
     * @return userID
     */
	@Column(name = "USERID", nullable = false)
    public int getUserID() {
        return userID;
    }
		
    /**
     * 设置用户ID.
     * @param userID
     */
    public void setUserID(final int newUserID) {
		this.userID = newUserID;
	}
	
	/**
     * 标签ID的get方法
     * @return tagID
     */
	@Column(name = "TAGID", nullable = false)
    public int getTagID() {
        return tagID;
    }
		
    /**
     * 设置标签ID.
     * @param tagID
     */
    public void setTagID(final int newTagID) {
		this.tagID = newTagID;
	}
}
