/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.ecp.service.tool.UuidUtil;
import com.ygsoft.necp.component.genentity.annotation.SceneDesc;
import com.ygsoft.necp.component.genentity.spec.GenEntityService;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.User;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.UserInfo;
import com.ygsoft.necp.std.ylyn.web.service.service.IUserService;
import com.ygsoft.necp.std.ylyn.web.service.context.IUserContext;
import com.ygsoft.necp.std.ylyn.web.service.context.IUserInfoContext;

/**
 * RegisterService服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/service/register")
public class RegisterService extends GenEntityService<User, IUserContext>
		implements IUserService {
	@Autowired
	IUserContext userContext;
	@Autowired
	IUserInfoContext userInfoContext;
    /**
     * 用户注册
     *
     */
 	@RequestMapping(value = "register")
 	@ResponseBody
 	public String register(String userName, String password, String nickName, String mailBox, String phone,
			String idCard) {
 		System.out.println(userName+password+nickName+mailBox+phone+idCard);
		String UID=UuidUtil.newUUID();
		User user=new User();
		UserInfo userInfo=new UserInfo();
		user.setGid(UID);
		user.setUserName(userName);
		user.setPassword(password);
		user.setNickName(nickName);
		user.setMailBox(mailBox);
		user.setPhone(phone);
		user.setIdCard(idCard);
		user.setLevel("0");
		userInfo.setGid(UID);
		userInfo.setNickName(nickName);
		try {
			userContext.save(user);
			userInfoContext.save(userInfo);
			return "success";
		} catch (Exception e) {
			return "fail";
			// TODO: handle exception
		}
		
			
	}

}
