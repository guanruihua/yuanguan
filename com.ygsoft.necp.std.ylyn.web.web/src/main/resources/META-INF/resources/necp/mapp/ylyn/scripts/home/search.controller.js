/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {
	$(function() {
		$("#search").click(function() {
			window.location.href="../home/search.html?"+$("#content").val()
		})
	})
});