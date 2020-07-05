/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.service.domain.model.bo;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.ygsoft.ecp.core.framework.annotations.Topic;
import com.ygsoft.necp.component.genentity.domain.model.GenBizEntity;

/**
 * PostBrowse的POJO类.<br>
 * 
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
@Entity
@Table(name = "PostBrowse", indexes = {})
@Topic(classId = "1001", typeId = "10007")
public class PostBrowse extends GenBizEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
												
	/**
	 * 帖子ID.
	 */
	private int postID;
											
	/**
	 * 帖子名称.
	 */
	private String tsUBNAME;
											
	/**
	 * 浏览时间.
	 */
	private Date browTime;
	
	/**
     * 帖子ID的get方法
     * @return postID
     */
	@Column(name = "POSTID", nullable = false)
    public int getPostID() {
        return postID;
    }
		
    /**
     * 设置帖子ID.
     * @param postID
     */
    public void setPostID(final int newPostID) {
		this.postID = newPostID;
	}
	
	/**
     * 帖子名称的get方法
     * @return tsUBNAME
     */
	@Column(name = "TSUBNAME", nullable = false, length = 50)
    public String getTsUBNAME() {
        return tsUBNAME;
    }
		
    /**
     * 设置帖子名称.
     * @param tsUBNAME
     */
    public void setTsUBNAME(final String newTsUBNAME) {
		this.tsUBNAME = newTsUBNAME;
	}
	
	/**
     * 浏览时间的get方法
     * @return browTime
     */
	@Column(name = "BROWTIME", nullable = true)
    public Date getBrowTime() {
        return browTime;
    }
		
    /**
     * 设置浏览时间.
     * @param browTime
     */
    public void setBrowTime(final Date newBrowTime) {
		this.browTime = newBrowTime;
	}
}
