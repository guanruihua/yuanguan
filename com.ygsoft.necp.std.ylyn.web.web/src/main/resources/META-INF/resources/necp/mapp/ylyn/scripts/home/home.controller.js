/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {

	//	var option = {};
	//	option.classId = "10002";
	//	option.typeId = "10003";
	//	option.sceneId = "079bf6ad08c4f3f41b865070b5174619";
	//
	//	var controller = GenentityController.create(option);
	//	controller.show();
	$(function() {
		$("#logout").click(function() {
			$.ajax({
				type : 'post',
				url : '/necp/mapp/ylyn/service/home/logout',
				success : function(data) {
						alert("登出成功")
				}
			});
		})
		$.ajax({
			type : 'post',
			url : '/necp/mapp/ylyn/service/home/home',
			success : function(data) {
				if (data.nickName == null) {
					$("#publish").click(function() {
						var msg = confirm("您还没有登录，是否登录")
						if (msg) {
							window.location.href = "../login/login.html"
						}
					})
				} else if (data.nickName != null) {
					$("#publish").click(function() {
						window.location.href = "../postPublish/postPublish.html"
					})
					$("#name").text("欢迎您,"+data.nickName)
					$("#loginState").show()
					$("#logoutState").hide()
				}

			}
		});
		$.ajax({
			type : "post",
			dataType : "json",
			url : "/necp/mapp/ylyn/service/home/show1",
			success : function(data) {
				var post1 = ''
				if (data != null) {
					for (var i = 0; i < data.length; i++) {
						var time = data[i].isSUETM
						console.log(data[i])
						time.replace(/Date\([\d+]+\)/, function(a) {
							eval('d = new ' + a)
						})
						post1 += "<a href='http://127.0.0.1:8080/necp/mapp/ylyn/page/browsePost/browsePost.html?"
							+ data[i].gid + 1 + "'>[" + data[i].postType + "]&#12288;" + data[i].postName + "<span>"
							+ d.toLocaleDateString() + "&#12288;</span></a>"
						$("#post1").html(post1)
					}
				}
			}
		});
		$.ajax({
			type : "post",
			dataType : "json",
			url : "/necp/mapp/ylyn/service/home/show2",
			success : function(data) {
				var post2 = ''
				if (data != null) {
					for (var i = 0; i < data.length; i++) {
						var time = data[i].isSUETM
						console.log(data[i])
						time.replace(/Date\([\d+]+\)/, function(a) {
							eval('d = new ' + a)
						})
						post2 += "<a href='http://127.0.0.1:8080/necp/mapp/ylyn/page/browsePost/browsePost.html?"
							+ data[i].gid + 1 + "'>[" + data[i].postType + "]&#12288;" + data[i].postName + "<span>"
							+ d.toLocaleDateString() + "&#12288;</span></a>"
						$("#post2").html(post2)
					}
				}
			}
		});
		$.ajax({
			type : "post",
			dataType : "json",
			url : "/necp/mapp/ylyn/service/home/show3",
			success : function(data) {
				var post3 = ''
				if (data != null) {
					for (var i = 0; i < data.length; i++) {
						var time = data[i].isSUETM
						console.log(data[i])
						time.replace(/Date\([\d+]+\)/, function(a) {
							eval('d = new ' + a)
						})
						post3 += "<a href='http://127.0.0.1:8080/necp/mapp/ylyn/page/browsePost/browsePost.html?"
							+ data[i].gid + 1+ "'>[" + data[i].postType + "]&#12288;" + data[i].postName + "<span>"
							+ d.toLocaleDateString() + "&#12288;</span></a>"
						$("#post3").html(post3)
					}
				}
			}
		});
	})
});