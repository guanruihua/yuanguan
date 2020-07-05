/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.context;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ygsoft.necp.component.genentity.spec.GenEntityContext;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.TagK;
import com.ygsoft.necp.std.ylyn.web.service.dao.ITagKDao;
import com.ygsoft.necp.std.ylyn.web.service.context.ITagKContext;

import com.ygsoft.necp.component.genentity.context.EntityContext;
import com.ygsoft.necp.core.service.dcispec.annotation.EventSource;

/**
 * TagK场景类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@Service
@Transactional
@EventSource
@EntityContext(classId = "10002", typeId = "10009")
public class TagKContext extends GenEntityContext<TagK, String, ITagKDao>
		implements ITagKContext {
		
	/**
	 * 构造函数.
	 */
	public TagKContext() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.ygsoft.necp.core.service.dcispec.GeneralContext#newModel()
	 */
	@Override
	protected TagK newModel() {
		return new TagK();
	}
	

}
