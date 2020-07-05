/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.context;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ygsoft.necp.component.genentity.spec.GenEntityContext;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostInfo;
import com.ygsoft.necp.std.ylyn.web.service.dao.IPostInfoDao;
import com.ygsoft.necp.std.ylyn.web.service.context.IPostInfoContext;

import com.ygsoft.necp.component.genentity.context.EntityContext;
import com.ygsoft.necp.core.service.dcispec.annotation.EventSource;

/**
 * PostInfo场景类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@Service
@Transactional
@EventSource
@EntityContext(classId = "10002", typeId = "10003")
public class PostInfoContext extends GenEntityContext<PostInfo, String, IPostInfoDao>
		implements IPostInfoContext {
		
	/**
	 * 构造函数.
	 */
	public PostInfoContext() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.ygsoft.necp.core.service.dcispec.GeneralContext#newModel()
	 */
	@Override
	protected PostInfo newModel() {
		return new PostInfo();
	}

	@Override
	public Page<PostInfo> show1() {
		// TODO Auto-generated method stub
		String postType="交友区";
		int pageindex=0;
		int pagesize=10;
		Pageable page = new PageRequest(pageindex, pagesize);
		return this.getDao().findByPostTypePageable(postType, page);
	}
	@Override
	public Page<PostInfo> show2() {
		// TODO Auto-generated method stub
		String postType="闲谈区";
		int pageindex=0;
		int pagesize=10;
		Pageable page = new PageRequest(pageindex, pagesize);
		return this.getDao().findByPostTypePageable(postType, page);
	}

	@Override
	public Page<PostInfo> show3() {
		// TODO Auto-generated method stub
		String postType="公告区";
		int pageindex=0;
		int pagesize=10;
		Pageable page = new PageRequest(pageindex, pagesize);
		return this.getDao().findByPostTypePageable(postType, page);
	}

	@Override
	public Page<PostInfo> showFriend(String postType,Integer page) {
		page=page-1;
		int pagesize=20;
		System.out.println("page");
		Pageable pg = new PageRequest(page, pagesize);
		return this.getDao().findByPostTypePageable(postType, pg);
	}

	@Override
	public int getCount(String postType) {
		return this.getDao().count(postType);
	}

	

	@Override
	public PostInfo findByGid(String postId) {
		// TODO Auto-generated method stub
		return this.getDao().findByGid(postId);
	}

	@Override
	public int getPostCount(String nickName) {
		// TODO Auto-generated method stub
		return this.getDao().countPost(nickName);
	}

	@Override
	public Page<PostInfo> showByNickName(String nickName, Integer page) {
		// TODO Auto-generated method stub
		page=page-1;
		int pagesize=10;
		Pageable pg = new PageRequest(page, pagesize);
		return this.getDao().showByNickName(nickName, pg);
	}

	@Override
	public List<PostInfo> search(String content) {
		// TODO Auto-generated method stub
		content="%"+content+"%";
		System.out.println(content);
		return this.getDao().findByPostNameLikeOrderByIsSUETMDesc(content);
	}

	@Override
	public List<PostInfo> getAll() {
		return this.getDao().findAll();
	}


}
