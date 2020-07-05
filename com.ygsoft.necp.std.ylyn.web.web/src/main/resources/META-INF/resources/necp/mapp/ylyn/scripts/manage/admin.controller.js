/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {
	$(function() {
		$.ajax({
			type : 'post',
			url : '/necp/mapp/ylyn/service/home/home',
			success : function(data) {
				if (data.nickName == null) {
					var msg = confirm("您还没有登录，是否登录")
					if (msg) {
						window.location.href = "../login/login.html"
					}
				} else if (data.level == null) {
					alert("您不是管理员")
					window.location.href = "../home/index.html"
				}
			}
		});
		$.ajax({
			type : "post",
			url : "/necp/mapp/ylyn/service/postInfo/showAll",
			success : function(data) {
				var post = ''
				if (data != null) {
					for (var i = 0; i < data.length; i++) {
						var time = data[i].isSUETM
						time.replace(/Date\([\d+]+\)/, function(a) {
							eval('d = new ' + a)
						})
						post += "<a href='../manage/browsePost.html?"
							+ data[i].gid + 1 + "'>[ " + data[i].postType + "] " + data[i].postName + "</a>"
						$("#post").html(post)
					}
				} else {
					$("#post").html("没有记录")
				}
			}
		});
		$("#search").click(function() {
			$.ajax({
				type : 'post',
				url : '/necp/mapp/ylyn/service/home/search',
				data : {
					'content' : $("#content").val()
				},
				success : function(data) {
					var post = ''
					if (data != null) {
						for (var i = 0; i < data.length; i++) {
							post += "<a href='../manage/browsePost.html?"
								+ data[i].gid + 1 + "'>[ " + data[i].postType + "] " + data[i].postName + "</a>"
							$("#post").html(post)
						}
					} else {
						$("#post").html("没有记录")
					}

				}
			});
		})
		$("#submit").click(function() {
			if ($("#postName").val() == "") {
				alert("请输入标题");
			} else if ($("#postContent").val() == "") {
				alert("请输入内容");
			} else {
				$.ajax({
					async : false,
					type : 'post',
					url : '/necp/mapp/ylyn/service/postPublish/postPublish',
					data : {
						'postName' : $("#postName").val(),
						'postType' : "公告区",
						'postContent' : $("#postContent").val()
					},
					success : function(data) {
						if (data.toString() == 'success') {
							alert("发布成功")
							window.location.reload()
						} else {
							alert("发布失败")
						}
					}
				});
			}
		})
		$("#reset").click(function() {
			$("input").attr("value", "");
			$("textarea").attr("value", "");
			$("select").find("option:contains('请选择')").attr("selected", true);
		})
		$("#logout").click(function() {
			$.ajax({
				type : 'post',
				url : '/necp/mapp/ylyn/service/home/logout',
				success : function(data) {
						alert("登出成功")
						window.location.href="../home/index.html"
				}
			});
		})
	})
});