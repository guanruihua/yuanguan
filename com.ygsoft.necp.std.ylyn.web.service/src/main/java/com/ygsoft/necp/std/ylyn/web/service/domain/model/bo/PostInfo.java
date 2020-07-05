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
import java.util.List;
import javax.persistence.Transient;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostMessage;

/**
 * PostInfo的POJO类.<br>
 * 
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@Entity
@Table(name = "postInfo", indexes = {})
@Topic(classId = "10002", typeId = "10003")
public class PostInfo extends GenBizEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
												
	/**
	 * 帖子名称.
	 */
	private String postName;
											
	/**
	 * 帖子内容.
	 */
	private String postContent;
	
	
									
	/**
	 * 帖子类型.
	 */
	private String postType;
											
	/**
	 * 发帖人.
	 */
	private String postPublisher;
											
	/**
	 * 发布时间.
	 */
	private Date isSUETM;
	
	private byte[] head;
							
	private String concern;
	/**
	 * ref_帖子留言.
	 */
	private List<PostMessage> ref_PostMessage;
	
	/**
     * 帖子名称的get方法
     * @return postName
     */
	@Column(name = "POSTNAME", nullable = false, length = 15)
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
	
	/**
     * 帖子内容的get方法
     * @return postContent
     */
	@Column(name = "POSTCONTENT", nullable = false, length = 100)
    public String getPostContent() {
        return postContent;
    }
		
    /**
     * 设置帖子内容.
     * @param postContent
     */
    public void setPostContent(final String newPostContent) {
		this.postContent = newPostContent;
	}
	
	/**
     * 帖子类型的get方法
     * @return postType
     */
	@Column(name = "POSTTYPE", nullable = false, length = 10)
    public String getPostType() {
        return postType;
    }
		
    /**
     * 设置帖子类型.
     * @param postType
     */
    public void setPostType(final String newPostType) {
		this.postType = newPostType;
	}
	
	/**
     * 发帖人的get方法
     * @return postPublisher
     */
	@Column(name = "POSTPUBLISHER", nullable = false, length = 20)
    public String getPostPublisher() {
        return postPublisher;
    }
		
    /**
     * 设置发帖人.
     * @param postPublisher
     */
    public void setPostPublisher(final String newPostPublisher) {
		this.postPublisher = newPostPublisher;
	}
	
	/**
     * 发布时间的get方法
     * @return isSUETM
     */
	@Column(name = "ISSUETM", nullable = false)
    public Date getIsSUETM() {
        return isSUETM;
    }
		
    /**
     * 设置发布时间.
     * @param isSUETM
     */
    public void setIsSUETM(final Date newIsSUETM) {
		this.isSUETM = newIsSUETM;
	}
	
	/**
     * ref_帖子留言的get方法
     * @return ref_PostMessage
     */
	@Transient
	public List<PostMessage> getRef_PostMessage() {
		return ref_PostMessage;
	}
		
    /**
     * 设置ref_帖子留言.
     * @param ref_PostMessage
     */
	public void setRef_PostMessage(final List<PostMessage> newRef_PostMessage) {
		this.ref_PostMessage = newRef_PostMessage;
	}

	public byte[] getHead() {
		return head;
	}

	public void setHead(byte[] head) {
		this.head = head;
	}


	public String getConcern() {
		return concern;
	}

	public void setConcern(String concern) {
		this.concern = concern;
	}

}
