/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {

	$(function() {
		$("#reset").click(function() {
			$("input").val("")
			$("textarea").val("")
		})
		$.ajax({
			type : 'post',
			url : '/necp/mapp/ylyn/service/home/home',
			success : function(data) {
				if (data.nickName == null) {
					$("#submit").click(function() {
						var msg = confirm("您还没有登录，是否登录")
						if (msg) {
							window.location.href = "../login/login.html"
						}
					})
				} else if (data.nickName != null) {
					$("#submit").click(function() {
						$.ajax({
							type : "post",
							url : "/necp/mapp/ylyn/service/postPublish/postPublish",
							data : {
								'postName' : $("#postName").val(),
								'postContent' : $("#postContent").val(),
								'postType' : $("#type").text(),
							},
							success : function(data) {
								if (data.toString() == "success")
									alert("发布成功")
								window.location.reload()
							}
						}
						);
					})
				}

			}
		});
		$.ajax({
			type : "post",
			url : "/necp/mapp/ylyn/service/postInfo/count",
			data : {
				'postType' : $("#type").text()
			},
			success : function(data) {
				var text = "";
				if ($("#type").text() == "交友区") {
					text = "friend.html";
				} else if ($("#type").text() == "闲谈区") {
					text = "talk.html";
				} else if ($("#type").text() == "公告区") {
					text = "notice.html";
				}
				if (parseInt(window.location.search.substr(1)) > 1) {
					$("#Page").append('<a href=http://127.0.0.1:8080/necp/mapp/ylyn/page/home/' + text + '?' + (parseInt(window.location.search.substr(1)) - 1) + "style='display:inline-block'>上一页</a>")
				}
				$("#Page").append("&nbsp;")
				for (var i = 1; i <= data; i++) {
					$("#Page").append('<a href=http://127.0.0.1:8080/necp/mapp/ylyn/page/home/' + text + '?'+ i + " style='display:inline-block'>" + i + '</a>')
					$("#Page").append("&nbsp;")
				}
				if (parseInt(window.location.search.substr(1)) < data) {
					$("#Page").append('<a href=http://127.0.0.1:8080/necp/mapp/ylyn/page/home/' + text + '?' + (parseInt(window.location.search.substr(1)) + 1) + "style='display:inline-block'>下一页</a>")
				}
			}
		});
		$.ajax({
			type : "post",
			url : "/necp/mapp/ylyn/service/postInfo/show",
			data : {
				'postType' : $("#type").text(),
				'page' : parseInt(window.location.search.substr(1)),
			},
			success : function(data) {
				var post = ''
				if (data != '') {
					for (var i = 0; i < data.length; i++) {
						var time = data[i].isSUETM
						time.replace(/Date\([\d+]+\)/, function(a) {
							eval('d = new ' + a)
						})
						post += "<a href='../browsePost/browsePost.html?"
							+ data[i].gid + 1 + "'>" + data[i].postName + "<span>" + d.toLocaleDateString()
							+ "</span><span>" + data[i].postPublisher + "</span></a>"
						$("#post").html(post)
					}
				} else {
					$("#post").html("没有记录")
				}
			}
		});

	})
});