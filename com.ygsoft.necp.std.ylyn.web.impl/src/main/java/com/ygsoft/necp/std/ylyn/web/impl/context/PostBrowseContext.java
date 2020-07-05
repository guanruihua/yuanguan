/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.context;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ygsoft.necp.component.genentity.spec.GenEntityContext;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostBrowse;
import com.ygsoft.necp.std.ylyn.web.service.dao.IPostBrowseDao;
import com.ygsoft.necp.std.ylyn.web.service.context.IPostBrowseContext;

import com.ygsoft.necp.component.genentity.context.EntityContext;
import com.ygsoft.necp.core.service.dcispec.annotation.EventSource;

/**
 * PostBrowse场景类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
@Service
@Transactional
@EventSource
@EntityContext(classId = "1001", typeId = "10007")
public class PostBrowseContext extends GenEntityContext<PostBrowse, String, IPostBrowseDao>
		implements IPostBrowseContext {
		
	/**
	 * 构造函数.
	 */
	public PostBrowseContext() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.ygsoft.necp.core.service.dcispec.GeneralContext#newModel()
	 */
	@Override
	protected PostBrowse newModel() {
		return new PostBrowse();
	}
	

}
