/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ygsoft.necp.component.genentity.annotation.SceneDesc;
import com.ygsoft.necp.component.genentity.spec.GenEntityService;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.User;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.UserInfo;
import com.ygsoft.necp.std.ylyn.web.service.service.IUserInfoService;
import com.ygsoft.necp.std.ylyn.web.service.context.IUserContext;
import com.ygsoft.necp.std.ylyn.web.service.context.IUserInfoContext;

/**
 * PersonalInfoService服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/service/personalInfo")
public class PersonalInfoService extends GenEntityService<UserInfo, IUserInfoContext> implements IUserInfoService {
	@Autowired
	IUserInfoContext userInfo;
	@Autowired
	IUserContext userContext;
	/**
	 * 个人信息
	 *
	 */
	@RequestMapping(value = "personalInfo")
	@ResponseBody
	public UserInfo personalInfo(HttpSession session) {
		User user = new User();
		user = (User) session.getAttribute("user");
		UserInfo info = new UserInfo();
		if(user!=null)
		info = userInfo.getInfo(user.getGid());
		if (info != null) {
			return info;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "infoUpdate")
	@ResponseBody
	public String infoUpdate(String nickName, String realName, String sex, String pay, String education, String address,
			String sign, HttpSession session) {
		User user = new User();
		user = (User) session.getAttribute("user");
		UserInfo info = new UserInfo();
		info = userInfo.getInfo(user.getGid());
		info.setNickName(nickName);
		info.setRealName(realName);
		info.setSex(sex);
		info.setPay(pay);
		info.setEducation(education);
		info.setPersonalSign(sign);
		info.setHomeAddress(address);
		user.setNickName(nickName);
		session.setAttribute("user", user);
		try {
			userInfo.update(info);
			userContext.update(user);
			return "success";
		} catch (Exception e) {
			return "fail";
			// TODO: handle exception
		}

	}
	@RequestMapping(value = "uploadPhoto")
	@ResponseBody
	public void upload(MultipartFile photo,HttpSession session){
		if(photo!=null){
		byte[] head = null;
		try {
			head = photo.getBytes();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User user = new User();
		user = (User) session.getAttribute("user");
		UserInfo info = new UserInfo();
		info = userInfo.getInfo(user.getGid());
		info.setHead(head);
		userInfo.update(info);
		}
	}
}
