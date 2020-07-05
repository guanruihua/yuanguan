/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {

	/*	var option = {};
		option.classId = "1001";
		option.typeId = "10001";
		option.sceneId = "e7e311bc0992de4e06e3245cd0992c5e";
		var controller = GenentityController.create(option);
		controller.show();*/
	$(function() {
		$("#register").click(function() {
			window.location.href = "../rgst/rgst.html"
		})
		$("#login").click(function() {
			if ($("#userName").val() == "" || $("#password").val() == "") {
				alert("用户名密码不能为空")
				return false;
			} else if ($("#userName").val().length < 6 || $("#password").val().length < 6) {
				alert("用户名密码必须在6位以上")
				return false;
			}

			$.ajax({
				type : "post",
				url : "/necp/mapp/ylyn/service/login/login",
				data : {
					'userName' : $("#userName").val(),
					'password' : $("#password").val()
				},
				success : function(data) {
					if (data != "") {
						if (data.level.toString() == '0') {
							window.location.href="../home/index.html"
						}

						else
							window.location.href = "../manage/admin.html"
					} else {
						alert("账号或密码错误")
					}
				}
			});

		})
	})
});