/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.service;


import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.ecp.service.tool.UuidUtil;
import com.ygsoft.necp.component.genentity.annotation.SceneDesc;
import com.ygsoft.necp.component.genentity.spec.GenEntityService;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PersonalPost;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostInfo;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.User;
import com.ygsoft.necp.std.ylyn.web.service.service.IPostInfoService;
import com.ygsoft.necp.std.ylyn.web.service.context.IPersonalPostContext;
import com.ygsoft.necp.std.ylyn.web.service.context.IPostInfoContext;
	
/**
 * PostPublishService服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/service/postPublish")
public class PostPublishService extends GenEntityService<PostInfo, IPostInfoContext>
		implements IPostInfoService {
	@Autowired
	IPostInfoContext postInfoContext;
	@Autowired
	IPersonalPostContext personalContext;
    /**
     * 发布帖子
     *
     */
 	@RequestMapping(value = "postPublish")
 	@ResponseBody
 	public String postPublish(String postName,String postType,String postContent,HttpSession session) {
		User user = new User();
		user = (User) session.getAttribute("user");
		PostInfo post=new PostInfo();
		Date date=new Date();
		String postID=UuidUtil.newUUID();
		post.setGid(postID);
		post.setPostPublisher(user.getNickName());
		post.setPostName(postName);
		post.setPostType(postType);
		post.setPostContent(postContent);
		post.setIsSUETM(date);
		PersonalPost personal=new PersonalPost();
		personal.setGid(UuidUtil.newUUID());
		personal.setPostOwner(user.getNickName());
		personal.setPostName(postName);
		personal.setPostID(postID);
		System.out.println(postID+postName+postType+date+user.getNickName()+postContent);
		try {
			postInfoContext.save(post);
			personalContext.save(personal);
			return "success";
		} catch (Exception e) {
			return "fail";
			// TODO: handle exception
		}
	}
}
