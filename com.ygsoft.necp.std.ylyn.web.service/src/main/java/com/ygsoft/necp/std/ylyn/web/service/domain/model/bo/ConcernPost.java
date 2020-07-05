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
 * ConcernPost的POJO类.<br>
 * 
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
@Entity
@Table(name = "postConcern", indexes = {})
@Topic(classId = "1001", typeId = "10006")
public class ConcernPost extends GenBizEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
												
	/**
	 * 帖子ID.
	 */
	private String postID;
		
	private String userID;
	/**
	 * 帖子名称.
	 */
	
	/**
     * 帖子ID的get方法
     * @return postID
     */
	@Column(name = "POSTID", nullable = false)
    public String getPostID() {
        return postID;
    }
		
    /**
     * 设置帖子ID.
     * @param postID
     */
    public void setPostID(final String PostID) {
		this.postID = PostID;
	}
	
	/**
     * 帖子名称的get方法
     * @return postName
     */
	@Column(name = "USERID", nullable = false)
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
