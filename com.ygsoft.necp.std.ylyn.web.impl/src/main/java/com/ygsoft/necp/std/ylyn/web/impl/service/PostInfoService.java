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
 * PostInfoService服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/service/postInfo")
public class PostInfoService extends GenEntityService<PostInfo, IPostInfoContext>
		implements IPostInfoService {
	@Autowired
	IPostInfoContext post;
	
 	@RequestMapping(value = "show")
 	@ResponseBody
 	public List<PostInfo> show(String postType,Integer page){
 		List<PostInfo> postList = new ArrayList<PostInfo>();
		postList = post.showFriend(postType, page).getContent();
		return postList;
 	}
 	
 	@RequestMapping(value = "showAll")
 	@ResponseBody
	public List<PostInfo> showAll(){
 		List<PostInfo> postList = new ArrayList<PostInfo>();
		postList = post.getAll();
		return postList;
 	}
 	
 	@RequestMapping(value = "count")
 	@ResponseBody
 	public int count(String postType){
		int count = post.getCount(postType);
		int countPage=0;
		if(count%20!=0){
			countPage=count/20+1;
		}
		else
			countPage=count/20;
		return countPage;
 	}
 	
 	@RequestMapping(value = "countPost")
 	@ResponseBody
 	public int countPost(HttpSession session){
 		User user=new User();
		user = (User) session.getAttribute("user");
		String nickName= user.getNickName();
		int count = post.getPostCount(nickName);
		int countPage=0;
		if(count%10!=0){
			countPage=count/10+1;
		}
		else
			countPage=count/10;
		return countPage;
 	}
 	

	@RequestMapping(value = "showByNickName")
	@ResponseBody
	public List<PostInfo> showByNickName(HttpSession session,Integer page){
		List<PostInfo> postList=new ArrayList<PostInfo>();
		User user=new User();
		user = (User) session.getAttribute("user");
		String nickName= user.getNickName();
		postList=post.showByNickName(nickName,page).getContent();
		return postList;
	}
}
