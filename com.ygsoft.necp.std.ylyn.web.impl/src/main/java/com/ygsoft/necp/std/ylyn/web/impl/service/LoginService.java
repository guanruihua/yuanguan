/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.service;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.necp.component.genentity.annotation.SceneDesc;
import com.ygsoft.necp.component.genentity.spec.GenEntityService;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.User;
import com.ygsoft.necp.std.ylyn.web.service.service.IUserService;
import com.ygsoft.necp.std.ylyn.web.service.context.IUserContext;

/**
 * LoginService服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/service/login")
public class LoginService extends GenEntityService<User, IUserContext>
		implements IUserService {
	@Autowired
	IUserContext userContext;
    /**
     * 用户登录
     *
     */
 	@RequestMapping(value = "login")
 	@ResponseBody
 	@SceneDesc(gid = "e7e311bc0992de4e06e3245cd0992c5e", name = "用户登录")
 	public User login(String userName,String password,HttpSession session){
		User user=userContext.findByUserNameAndPassword(userName,password);
		if(user==null)
			return null;
		else {
			session.setAttribute("user", user);
			return user;
		}
			
 	}
	@RequestMapping(value = "logout")
	@ResponseBody		
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "logout";		
	}
}
