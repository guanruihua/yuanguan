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
 * PersonalPost的POJO类.<br>
 * 
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@Entity
@Table(name = "personalPost", indexes = {})
@Topic(classId = "1001", typeId = "10010")
public class PersonalPost extends GenBizEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
												
	/**
	 * 帖子ID.
	 */
	private String postID;
											
	/**
	 * 帖子名称.
	 */
	private String postName;
	
	/**
	 * 发帖人.
	 */
	private String postOwner;
	/**
     * 帖子ID的get方法
     * @return postID
     */
	@Column(name = "POSTID", nullable = true, length = 50)
    public String getPostID() {
        return postID;
    }
		
    /**
     * 设置帖子ID.
     * @param postID
     */
    public void setPostID(final String newPostID) {
		this.postID = newPostID;
	}
	
	/**
     * 帖子名称的get方法
     * @return postName
     */
	@Column(name = "POSTNAME", nullable = true, length = 50)
    public String getPostName() {
        return postName;
    }
		
    /**
     * 设置帖子名称.
     * @param postName
     */
    public void setPostName(final String newPostName) {
		this.postName = newPostName;
	}
    
    @Column(name = "POSTOWNER", nullable = true, length = 20)
	public String getPostOwner() {
		return postOwner;
	}

	public void setPostOwner(String postOwner) {
		this.postOwner = postOwner;
	}
}
