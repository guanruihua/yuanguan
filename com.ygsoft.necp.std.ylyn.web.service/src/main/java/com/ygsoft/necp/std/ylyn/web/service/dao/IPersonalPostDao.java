/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.service.dao;

import org.springframework.stereotype.Repository;

import com.ygsoft.necp.component.genentity.spec.IGenEntityDao;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PersonalPost;

/**
 * IPersonalPostDao数据访问类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@Repository
public interface IPersonalPostDao extends IGenEntityDao<PersonalPost, String> {

	PersonalPost findByPostID(String postId);
	

}
