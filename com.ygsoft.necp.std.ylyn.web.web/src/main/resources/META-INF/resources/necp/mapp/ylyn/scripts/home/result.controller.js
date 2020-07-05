/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {
	$(function() {
		url = location.href
		var content = url.substr((0, url.indexOf("?") + 1))
		console.log(content)
		$.ajax({
			type : "post",
			url : "/necp/mapp/ylyn/service/home/search",
			data : {
				'content' : content
			},
			success : function(data) {
				var post = ''
				if (data.length>=1) {
					for (var i = 0; i < data.length; i++) {
						var time = data[i].isSUETM
						console.log(data[i])
						time.replace(/Date\([\d+]+\)/, function(a) {
							eval('d = new ' + a)
						})
						post += "<a href='../browsePost/browsePost.html?"
							+ data[i].gid + "1'>[" + data[i].postType + "]&#12288;" + data[i].postName + "<span>"
							+ d.toLocaleDateString() + "&#12288;</span></a>"
						$("#post").html(post)
					}
				} else {
					post += "<br><br><br>"+"抱歉,没有类似的帖子"+"<br><br><br><br>"
					$("#post").html(post)
				}

			}
		});
	})
});