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

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostMessage;
import com.ygsoft.necp.std.ylyn.web.service.dao.IPostMessageDao;
import com.ygsoft.necp.std.ylyn.web.service.context.IPostMessageContext;

import com.ygsoft.necp.component.genentity.context.EntityContext;
import com.ygsoft.necp.core.service.dcispec.annotation.EventSource;

/**
 * PostMessage场景类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@Service
@Transactional
@EventSource
@EntityContext(classId = "10002", typeId = "10004")
public class PostMessageContext extends GenEntityContext<PostMessage, String, IPostMessageDao>
		implements IPostMessageContext {
		
	/**
	 * 构造函数.
	 */
	public PostMessageContext() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.ygsoft.necp.core.service.dcispec.GeneralContext#newModel()
	 */
	@Override
	protected PostMessage newModel() {
		return new PostMessage();
	}

	@Override
	public List<PostMessage> findByPostIDOrderByMessageNumAsc(String postId) {
		// TODO Auto-generated method stub
		return this.getDao().findByPostIDOrderByMessageNumAsc(postId);
	}

	@Override
	public Page<PostMessage> getPostMessageByPage(String postId, int index) {
		// TODO Auto-generated method stub
		int pageindex = index;
		int pagesize = 2;
		Pageable pg = new PageRequest(pageindex,pagesize);
		return this.getDao().findByPostIDPageable(postId,pg);
	}

	@Override
	public List<PostMessage> findByPostID(String postId) {
		// TODO Auto-generated method stub
		return this.getDao().findByPostID(postId);
	}

	
	

}
