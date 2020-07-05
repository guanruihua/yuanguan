/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.Manageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.ecp.service.tool.UuidUtil;
import com.ygsoft.necp.component.genentity.annotation.SceneDesc;
import com.ygsoft.necp.component.genentity.spec.GenEntityService;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.ConcernPost;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PersonalPost;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostInfo;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostMessage;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.User;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.UserInfo;
import com.ygsoft.necp.std.ylyn.web.service.service.IPostInfoService;
import com.ygsoft.necp.std.ylyn.web.service.context.IConcernPostContext;
import com.ygsoft.necp.std.ylyn.web.service.context.IPersonalPostContext;
import com.ygsoft.necp.std.ylyn.web.service.context.IPostInfoContext;
import com.ygsoft.necp.std.ylyn.web.service.context.IPostMessageContext;
import com.ygsoft.necp.std.ylyn.web.service.context.IUserInfoContext;

/**
 * BrowsePostService服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/service/browsePost")
public class BrowsePostService extends GenEntityService<PostInfo, IPostInfoContext> implements IPostInfoService {
	@Autowired
	IPostInfoContext postinfo;
	@Autowired
	IPostMessageContext postmessage;
	@Autowired
	IUserInfoContext userInfo;
	@Autowired
	IPersonalPostContext personal;
	@Autowired
	IConcernPostContext concern;

	/**
	 * 浏览帖子
	 *
	 */

	@RequestMapping(value = "manage")
	@ResponseBody
	public void manage(String postId, String postName) {
		PostInfo pif = postinfo.findByGid(postId);
		PersonalPost pspoPost = personal.findByPostId(postId);
		List<ConcernPost> con = concern.findByPostID(postId);
		List<PostMessage> psmessage = new ArrayList<PostMessage>();
		psmessage = postmessage.findByPostID(postId);
		postmessage.deleteList(psmessage);
		if (con.size() != 0)
			concern.deleteList(con);
		if (psmessage.size() != 0)
			personal.delete(pspoPost);
		if (pspoPost != null)
			personal.delete(pspoPost);
		postinfo.delete(pif);
	}

	@RequestMapping(value = "getPostInfo")
	@ResponseBody
	public PostInfo getPostInfo(String postId, HttpSession session) {
		PostInfo pif = postinfo.findByGid(postId);
		UserInfo info = new UserInfo();
		info = userInfo.getUserInfo(pif.getPostPublisher());
		if (info.getHead() != null) {
			pif.setHead(info.getHead());
			ConcernPost con = new ConcernPost();
			User user = new User();
			user = (User) session.getAttribute("user");
			if (user != null) {
				con = concern.findByPostIDAndUserID(postId, user.getGid());
				if (con != null) {
					pif.setConcern("已关注");
				} else {
					pif.setConcern("关注该贴");
				}
			}
		}

		return pif;
	}

	@RequestMapping(value = "getUser")
	@ResponseBody
	public UserInfo getUser(HttpSession session) {
		User user = new User();
		user = (User) session.getAttribute("user");
		if (user != null) {
			UserInfo info = new UserInfo();
			info = userInfo.getInfo(user.getGid());
			return info;
		} else
			return null;
	}
	
	@RequestMapping(value = "getAllPostMessage")
	@ResponseBody
	public List<PostMessage> getAllPostMessage(String postId) {
		List<PostMessage> postList = new ArrayList<PostMessage>();
		postList = postmessage.findByPostIDOrderByMessageNumAsc(postId);
		return postList;
	}

	@RequestMapping(value = "getPostMessageByPage")
	@ResponseBody
	public List<PostMessage> getPostMessageByPage(String postId, int index) {
		List<PostMessage> postList = new ArrayList<PostMessage>();
		postList = postmessage.getPostMessageByPage(postId, index - 1).getContent();
		for (int i = 0; i < postList.size(); i++) {
			UserInfo info = new UserInfo();
			info = userInfo.getUserInfo(postList.get(i).getMessageOwner());
			postList.get(i).setHead(info.getHead());
		}

		return postList;
	}

	@RequestMapping(value = "reply")
	@ResponseBody
	public String reply(String message, String postID, int messageNum, HttpSession session) {
		User user = new User();
		user = (User) session.getAttribute("user");
		PostMessage post = new PostMessage();
		Date date = new Date();
		String gid = UuidUtil.newUUID();
		post.setGid(gid);
		post.setMessage(message);
		post.setMessageNum(messageNum);
		post.setMessageOwner(user.getNickName());
		post.setMessageTime(date);
		post.setPostID(postID);
		try {
			postmessage.save(post);
			return "success";
		} catch (Exception e) {
			return "fail";
		}
	}

	@RequestMapping(value = "deletePost")
	@ResponseBody
	public void delete(String postId) {
		PostInfo pif = new PostInfo();
		pif = postinfo.findByGid(postId);
		postinfo.delete(pif);
		PersonalPost pspost = new PersonalPost();
		pspost = personal.findByPostId(postId);
		personal.delete(pspost);
		List<PostMessage> psmessage = new ArrayList<PostMessage>();
		psmessage = postmessage.findByPostID(postId);
		postmessage.deleteList(psmessage);
		List<ConcernPost> con = concern.findByPostID(postId);
		concern.deleteList(con);
	}

	@RequestMapping(value = "like")
	@ResponseBody
	public String like(String postId, HttpSession session) {
		ConcernPost con = new ConcernPost();
		User user = new User();
		user = (User) session.getAttribute("user");
		if (user == null) {
			return "fail";
		} else {
			con.setGid(UuidUtil.newUUID());
			con.setPostID(postId);
			con.setUserID(user.getGid());
			concern.save(con);
			return "success";
		}
	}

	@RequestMapping(value = "notlike")
	@ResponseBody
	public String notlike(String postId, HttpSession session) {
		ConcernPost con = new ConcernPost();
		User user = new User();
		user = (User) session.getAttribute("user");
		if (user == null) {
			return "fail";
		} else {
			con = concern.findByPostIDAndUserID(postId, user.getGid());
			concern.delete(con);
			return "success";
		}
	}
}
