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
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.PostInfo;

/**
 * IPostInfoDao数据访问类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@Repository
public interface IPostInfoDao extends IGenEntityDao<PostInfo, String> {
	@Query(value = "select l from PostInfo l where l.postType = :postType order by l.isSUETM desc ")
	Page<PostInfo> findByPostTypePageable(@Param("postType") String postType,Pageable page);
	
	@Query(value = "select l from PostInfo l where l.postPublisher = :nickName order by l.isSUETM desc ")
	Page<PostInfo> showByNickName(@Param("nickName") String nickName,Pageable page);
	
	@Query(value = "SELECT COUNT(*) FROM PostInfo where postType = :postType")
	int count(@Param("postType") String postType);
	
	@Query(value = "SELECT COUNT(*) FROM PostInfo where postPublisher = :nickName")
	int countPost(@Param("nickName") String nickName);

	List<PostInfo> findByPostPublisher(String publisher);
	
	PostInfo findByGid(String postId);

	List<PostInfo> findByPostNameLikeOrderByIsSUETMDesc(String content);


}
