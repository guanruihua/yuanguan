/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.context;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ygsoft.necp.component.genentity.spec.GenEntityContext;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.UserInfo;
import com.ygsoft.necp.std.ylyn.web.service.dao.IUserInfoDao;
import com.ygsoft.necp.std.ylyn.web.service.context.IUserInfoContext;

import com.ygsoft.necp.component.genentity.context.EntityContext;
import com.ygsoft.necp.core.service.dcispec.annotation.EventSource;

/**
 * UserInfo场景类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
@Service
@Transactional
@EventSource
@EntityContext(classId = "10002", typeId = "10002")
public class UserInfoContext extends GenEntityContext<UserInfo, String, IUserInfoDao>
		implements IUserInfoContext {
		
	/**
	 * 构造函数.
	 */
	public UserInfoContext() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.ygsoft.necp.core.service.dcispec.GeneralContext#newModel()
	 */
	@Override
	protected UserInfo newModel() {
		return new UserInfo();
	}

	@Override
	public UserInfo getInfo(String gid) {
		// TODO Auto-generated method stub
		return this.getDao().findByGid(gid);
	}

	@Override
	public UserInfo getUserInfo(String postPublisher) {
		// TODO Auto-generated method stub
		return this.getDao().findByNickName(postPublisher);
	}


	

}
