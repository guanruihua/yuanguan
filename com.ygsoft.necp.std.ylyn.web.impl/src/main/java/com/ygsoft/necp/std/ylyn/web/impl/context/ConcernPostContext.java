/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.context;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ygsoft.necp.component.genentity.spec.GenEntityContext;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.ConcernPost;
import com.ygsoft.necp.std.ylyn.web.service.dao.IConcernPostDao;
import com.ygsoft.necp.std.ylyn.web.service.context.IConcernPostContext;

import com.ygsoft.necp.component.genentity.context.EntityContext;
import com.ygsoft.necp.core.service.dcispec.annotation.EventSource;

/**
 * ConcernPost场景类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
@Service
@Transactional
@EventSource
@EntityContext(classId = "1001", typeId = "10006")
public class ConcernPostContext extends GenEntityContext<ConcernPost, String, IConcernPostDao>
		implements IConcernPostContext {
		
	/**
	 * 构造函数.
	 */
	public ConcernPostContext() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.ygsoft.necp.core.service.dcispec.GeneralContext#newModel()
	 */
	@Override
	protected ConcernPost newModel() {
		return new ConcernPost();
	}

	@Override
	public ConcernPost findByPostIDAndUserID(String postId, String gid) {
		// TODO Auto-generated method stub
		return this.getDao().findByPostIDAndUserID(postId,gid);
	}
	
	@Override
	public int getConcernCount(String gid) {
		// TODO Auto-generated method stub
		return this.getDao().countConcern(gid);
	}

	@Override
	public Page<ConcernPost> getConcern(String gid, Integer page) {
		page=page-1;
		int pagesize=10;
		Pageable pg = new PageRequest(page, pagesize);
		return this.getDao().findConcern(gid,pg);
	}

	@Override
	public List<ConcernPost> findByPostID(String postId) {
		// TODO Auto-generated method stub
		return this.getDao().findByPostID(postId);
	}
}
