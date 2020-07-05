/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.necp.component.genentity.spec.GenEntityService;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.User;
import com.ygsoft.necp.std.ylyn.web.service.service.IUserService;
import com.ygsoft.necp.std.ylyn.web.service.context.IUserContext;

/**
 * UserService服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:25<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/service/user")
public class UserService extends GenEntityService<User, IUserContext>
		implements IUserService {
	@Autowired
	IUserContext userContext;
	@RequestMapping(value = "show")
 	@ResponseBody
 	public User changePwd(HttpSession session){
		User user=new User();
		user=(User) session.getAttribute("user");
		return user;
		
	}
	@RequestMapping(value = "fixemail")
 	@ResponseBody
 	public String changeEmail(String xgemain,HttpSession session){
		User user=new User();
		user=(User) session.getAttribute("user");
		user.setMailBox(xgemain);
		session.setAttribute("user", user);
		try {
			userContext.save(user);
			return "success";
		} catch (Exception e) {
			return "fail";
			// TODO: handle exception
		}	
	}
	
	@RequestMapping(value = "fixphone")
 	@ResponseBody
 	public String changePhone(String xgphone,HttpSession session){
		User user=new User();
		user=(User) session.getAttribute("user");
		user.setPhone(xgphone);
		session.setAttribute("user", user);
		try {
			userContext.save(user);
			return "success";
		} catch (Exception e) {
			return "fail";
			// TODO: handle exception
		}	
	}
	
	@RequestMapping(value = "fixpwd")
 	@ResponseBody
 	public String changePwd(String newpwd,HttpSession session){
		User user=new User();
		user=(User) session.getAttribute("user");
		user.setPassword(newpwd);
		session.invalidate();
		try {
			userContext.save(user);
			return "success";
		} catch (Exception e) {
			return "fail";
			// TODO: handle exception
		}	
	}
}
