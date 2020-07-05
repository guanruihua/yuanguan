/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {
/*
	var option = {};
	option.classId = "1001";
	option.typeId = "10001";
	option.sceneId = "2a968641520732e430b995231bd2ca4e";

	var controller = GenentityController.create(option);
	controller.show();*/
	$(function() {
		$("#submit").click(function() {
			if ($("#userName").val() == "" || $("#password").val() == "" || $("#nickName").val() == ''
				|| $("#mailBox").val() == '' || $("#phone").val() == '' || $("#idCard").val() == '') {
				alert("输入不能为空")
				return false;
			} else if ($("#userName").val().length < 6 || $("#password").val().length < 6) {
				alert("用户名密码必须在6位以上")
				return false;
			} else if ($("#userName").val().length < 6 || $("#password").val().length < 6) {
				alert("用户名密码必须在6位以上")
				return false;
			} else if ($("#password").val() != $("#confirmPassword").val()) {
				alert("确认密码不一致")
				return false;
			} else if (!(/^1(3|4|5|6|7|8|9)\d{9}$/).test($("#phone").val())) {
				alert("手机格式有误")
				return false;
			} else if (!(/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/).test($("#idCard").val())) {
				alert("身份证格式有误")
				return false;
			}else if(!(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/).test($("#mailBox").val())){
				alert("邮箱格式有误")
				return false;
			}
			$.ajax({
				type : "post",
				url : "/necp/mapp/ylyn/service/register/register",
				data : {
					'userName' : $("#userName").val(),
					'password' : $("#password").val(),
					'nickName' : $("#nickName").val(),
					'mailBox' : $("#mailBox").val(),
					'phone' : $("#phone").val(),
					'idCard' : $("#idCard").val(),
				},
				success : function(result) {
					if (result.toString() == 'success') {
						alert("注册成功")
						window.location.href = "../login/login.html"
					} else
						alert("注册失败,数据已存在")
				}
			});

		})
	})
	$(function() {
		$("#reset").click(function() {
			$("input").attr("value","");
		})
	})
});