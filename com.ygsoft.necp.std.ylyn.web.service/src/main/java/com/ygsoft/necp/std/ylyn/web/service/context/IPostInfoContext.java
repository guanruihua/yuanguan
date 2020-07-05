/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.service.context;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostInfo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import com.ygsoft.necp.component.genentity.spec.IGenEntityContext;

/**
 * IPostInfoContext场景接口类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
public interface IPostInfoContext extends IGenEntityContext<PostInfo, String> {


	Page<PostInfo> show1();

	Page<PostInfo> show2();

	Page<PostInfo> show3();

	Page<PostInfo> showFriend(String postType,Integer page);

	int getCount(String postType);
	
	int getPostCount(String nickName);

	Page<PostInfo> showByNickName(String nickName,Integer page);

	PostInfo findByGid(String postId);

	List<PostInfo> search(String content);

	List<PostInfo> getAll();

	
	
}
