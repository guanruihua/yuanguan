/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.std.ylyn.web.impl.action;

import org.springframework.stereotype.Component;

import com.ygsoft.ecp.core.framework.domain.AbstractBusinessAction;
import com.ygsoft.necp.std.ylyn.web.service.action.ITagKAction;
import com.ygsoft.necp.std.ylyn.web.service.domain.model.bo.TagK;

/**
 * TagK动作类.<br>
 *
 * @author 170202104078 <br>
 * @version 1.0.0 2020-06-18 14:50:26<br>
 * @since JDK 1.8.0_144
 */
@Component
public class TagKAction extends AbstractBusinessAction<TagK> implements ITagKAction {
	
	/**
	 * TagKAction constructor.
	 * @param newBo newBo.
	 */
	public TagKAction(TagK newBo) {
		super(newBo);
	}
	
}
