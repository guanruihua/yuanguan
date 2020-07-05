/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.service.context;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.ConcernPost;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ygsoft.necp.component.genentity.spec.IGenEntityContext;

/**
 * IConcernPostContext场景接口类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
public interface IConcernPostContext extends IGenEntityContext<ConcernPost, String> {

	ConcernPost findByPostIDAndUserID(String postId, String gid);

	int getConcernCount(String gid);

	Page<ConcernPost> getConcern(String gid, Integer page);

	List<ConcernPost> findByPostID(String postId);


}
