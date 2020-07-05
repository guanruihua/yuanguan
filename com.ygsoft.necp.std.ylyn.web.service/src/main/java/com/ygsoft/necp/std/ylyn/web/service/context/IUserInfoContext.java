/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.service.context;

import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.UserInfo;
import com.ygsoft.necp.component.genentity.spec.IGenEntityContext;

/**
 * IUserInfoContext场景接口类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:24<br>
 * @since JDK 1.8.0_144
 */
public interface IUserInfoContext extends IGenEntityContext<UserInfo, String> {


	UserInfo getInfo(String gid);

	UserInfo getUserInfo(String postPublisher);


}