/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.service.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ygsoft.necp.component.genentity.spec.IGenEntityDao;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.ConcernPost;

/**
 * IConcernPostDao数据访问类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
@Repository
public interface IConcernPostDao extends IGenEntityDao<ConcernPost, String> {

	ConcernPost findByPostIDAndUserID(String postId, String gid);

	@Query(value = "SELECT COUNT(*) FROM ConcernPost where userID = :userID")
	int countConcern(@Param("userID")String gid);
	
	@Query(value = "select l from ConcernPost l where l.userID = :userID ")
	Page<ConcernPost> findConcern(@Param("userID")String gid, Pageable pg);

	List<ConcernPost> findByPostID(String postId);
	

}
