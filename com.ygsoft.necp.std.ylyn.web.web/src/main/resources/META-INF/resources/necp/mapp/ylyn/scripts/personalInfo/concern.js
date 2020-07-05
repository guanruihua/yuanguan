/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {
	$(function() {
		$.ajax({
			type : "post",
			url : "/necp/mapp/ylyn/service/concernPost/countPost",
			success : function(data) {
				if (parseInt(window.location.search.substr(1)) > 1) {
					$("#Page").append('<a href=http://127.0.0.1:8080/necp/mapp/ylyn/page/personalinfo/post.html?' + (parseInt(window.location.search.substr(1)) - 1) + "style='display:inline-block'>上一页</a>")
				}
				for (var i = 1; i <= data; i++) {
					$("#Page").append('<a href=http://127.0.0.1:8080/necp/mapp/ylyn/page/personalinfo/post.html?' + i + "style='display:inline-block'>" + i + '</a>')
				}
				if (parseInt(window.location.search.substr(1)) < data) {
					$("#Page").append('<a href=http://127.0.0.1:8080/necp/mapp/ylyn/page/personalinfo/post.html?' + (parseInt(window.location.search.substr(1)) + 1) + "style='display:inline-block'>下一页</a>")
				}
			}
		});
		$.ajax({
			type : "post",
			url : "/necp/mapp/ylyn/service/concernPost/show",
			data : {
				'page' : parseInt(window.location.search.substr(1)),
			},
			success : function(data) {
				var post = ''
				$("#length").text("(" + data.length + ")")
				if (data != '') {
					for (var i = 0; i < data.length; i++) {
						var time = data[i].isSUETM
						time.replace(/Date\([\d+]+\)/, function(a) {
							eval('d = new ' + a)
						})
						post += "<a href='../browsePost/browsePost.html?" + data[i].gid + "1' target='top'><span class=''>[" + data[i].postType + "]" + data[i].postName + "</span><span class='right'>发表时间："
							+ d.toLocaleDateString() + "</span></a><br>"
						$("#post_y").html(post)
					}
				} else{
					$("#post_y").html("没有记录")
				}
					
			}
		});
		$("#publish").click(function() {
			top.location.href="../postPublish/postPublish.html"
		})

	})
});