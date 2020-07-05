/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.service;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.necp.component.genentity.spec.GenEntityService;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostInfo;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.User;
import com.ygsoft.necp.std.ylyn.web.service.service.IPostInfoService;
import com.ygsoft.necp.std.ylyn.web.service.context.IPostInfoContext;

/**
 * HomeService服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/service/home")
public class HomeService extends GenEntityService<PostInfo, IPostInfoContext> implements IPostInfoService {
	@Autowired
	IPostInfoContext post;

	/**
	 * 浏览首页
	 *
	 */
	@RequestMapping(value = "home")
	@ResponseBody
	public User home(HttpSession session) {
		User user = new User();
		user = (User) session.getAttribute("user");
		if (user == null) {
			return null;
		} else {
			return user;
		}

	}

	@RequestMapping(value = "search")
	@ResponseBody
	public List<PostInfo> search(String content) {
		System.out.println(content);
		List<PostInfo> postList = new ArrayList<PostInfo>();
		postList = post.search(content);
		return postList;

	}

	@RequestMapping(value = "logout")
	@ResponseBody
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";

	}

	@RequestMapping(value = "show1")
	@ResponseBody
	public List<PostInfo> show1() {
		List<PostInfo> postList = new ArrayList<PostInfo>();
		postList = post.show1().getContent();
		return postList;
	}

	@RequestMapping(value = "show2")
	@ResponseBody
	public List<PostInfo> show2() {
		List<PostInfo> postList = new ArrayList<PostInfo>();
		postList = post.show2().getContent();
		return postList;
	}

	@RequestMapping(value = "show3")
	@ResponseBody
	public List<PostInfo> show3() {
		List<PostInfo> postList = new ArrayList<PostInfo>();
		postList = post.show3().getContent();
		return postList;
	}
}
