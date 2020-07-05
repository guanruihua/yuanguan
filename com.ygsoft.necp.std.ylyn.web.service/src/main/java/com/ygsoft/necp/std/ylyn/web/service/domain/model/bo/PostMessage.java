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
 * PostMessage的POJO类.<br>
 * 
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@Entity
@Table(name = "postMessage", indexes = {})
@Topic(classId = "10002", typeId = "10004")
public class PostMessage extends GenBizEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
												
	/**
	 * 留言内容.
	 */
	private String message;
	
	private String postID;
											
	/**
	 * 留言人.
	 */
	private String messageOwner;
											
	/**
	 * 留言时间.
	 */
	private Date messageTime;
											
	/**
	 * 留言楼数.
	 */
	private int messageNum;
	
	private byte[] head;
	
	/**
     * 留言内容的get方法
     * @return message
     */
	@Column(name = "MESSAGE", nullable = false, length = 100)
    public String getMessage() {
        return message;
    }
		
    /**
     * 设置留言内容.
     * @param message
     */
    public void setMessage(final String newMessage) {
		this.message = newMessage;
	}
	
	/**
     * 留言人的get方法
     * @return messageOwner
     */
	@Column(name = "MESSAGEOWNER", nullable = false, length = 20)
    public String getMessageOwner() {
        return messageOwner;
    }
		
    /**
     * 设置留言人.
     * @param messageOwner
     */
    public void setMessageOwner(final String newMessageOwner) {
		this.messageOwner = newMessageOwner;
	}
	
	/**
     * 留言时间的get方法
     * @return messageTime
     */
	@Column(name = "MESSAGETIME", nullable = true)
    public Date getMessageTime() {
        return messageTime;
    }
		
    /**
     * 设置留言时间.
     * @param messageTime
     */
    public void setMessageTime(final Date newMessageTime) {
		this.messageTime = newMessageTime;
	}
	
	/**
     * 留言楼数的get方法
     * @return messageNum
     */
	@Column(name = "MESSAGENUM", nullable = true)
    public int getMessageNum() {
        return messageNum;
    }
		
    /**
     * 设置留言楼数.
     * @param messageNum
     */
    public void setMessageNum(final int newMessageNum) {
		this.messageNum = newMessageNum;
	}
    
    @Column(name = "POSTID", nullable = true, length = 36)
	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public byte[] getHead() {
		return head;
	}

	public void setHead(byte[] head) {
		this.head = head;
	}
}
