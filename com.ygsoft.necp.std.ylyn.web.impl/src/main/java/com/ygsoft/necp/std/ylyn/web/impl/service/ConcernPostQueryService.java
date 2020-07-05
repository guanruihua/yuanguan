/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.necp.component.genentity.spec.GenEntityQueryService;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.ConcernPost;
import com.ygsoft.necp.std.ylyn.web.service.service.IConcernPostQueryService;
import com.ygsoft.necp.std.ylyn.web.service.context.IConcernPostContext;

/**
 * ConcernPostQueryService查询服务类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
@RestController
@RequestMapping("/necp/mapp/ylyn/query/concernPost")
public class ConcernPostQueryService extends GenEntityQueryService<ConcernPost, IConcernPostContext>
		implements IConcernPostQueryService {

}
