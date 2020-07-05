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
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.UserTag;
import java.util.List;
import javax.persistence.Transient;

/**
 * TagK的POJO类.<br>
 * 
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:25<br>
 * @since JDK 1.8.0_144
 */
@Entity
@Table(name = "tagK", indexes = {})
@Topic(classId = "10002", typeId = "10009")
public class TagK extends GenBizEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
												
	/**
	 * 标签名称.
	 */
	private String taGNAME;
											
	/**
	 * ref_用户标签.
	 */
	private List<UserTag> ref_UserTag;
	
	/**
     * 标签名称的get方法
     * @return taGNAME
     */
	@Column(name = "TAGNAME", nullable = false, length = 50)
    public String getTaGNAME() {
        return taGNAME;
    }
		
    /**
     * 设置标签名称.
     * @param taGNAME
     */
    public void setTaGNAME(final String newTaGNAME) {
		this.taGNAME = newTaGNAME;
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
}
