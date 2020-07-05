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

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.ConcernPost;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostInfo;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.User;
import com.ygsoft.necp.std.ylyn.web.service.service.IConcernPostService;
import com.ygsoft.necp.std.ylyn.web.service.context.IConcernPostContext;
import com.ygsoft.necp.std.ylyn.web.service.context.IPostInfoContext;

/**
 * ConcernPostService服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/service/concernPost")
public class ConcernPostService extends GenEntityService<ConcernPost, IConcernPostContext>
		implements IConcernPostService {
	@Autowired
	IConcernPostContext concern;

	@Autowired
	IPostInfoContext psinfo;

	@RequestMapping(value = "countPost")
	@ResponseBody
	public int countConcern(HttpSession session) {
		User user = new User();
		user = (User) session.getAttribute("user");
		int count = concern.getConcernCount(user.getGid());
		int countPage = 0;
		if (count % 10 != 0) {
			countPage = count / 10 + 1;
		} else
			countPage = count / 10;
		return countPage;
	}

	@RequestMapping(value = "show")
	@ResponseBody
	public List<PostInfo> show(HttpSession session, Integer page) {
		User user = new User();
		user = (User) session.getAttribute("user");
		if (user.getGid() != null) {
			List<ConcernPost> list = new ArrayList<ConcernPost>();
			List<PostInfo> postList = new ArrayList<PostInfo>();
			list = concern.getConcern(user.getGid(), page).getContent();
			System.out.println(list.size()+"!!!!!!!");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getPostID());
				PostInfo post = new PostInfo();
				post = psinfo.findByGid(list.get(i).getPostID());
				System.out.println(post.getPostName()+"pppppppppp");
				postList.add(post);
				System.out.println("?????????"+postList.get(i).getPostName());
			}

			return postList;
		} else
			return null;

	}
}
