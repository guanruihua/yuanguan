/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {
	$(function() {
		$.ajax({
			type : 'post',
			url : '/necp/mapp/ylyn/service/user/show',
			success : function(data) {
				if (data.gid != null) {
					$("#ID").text(data.gid)
					$("#mail").text(data.mailBox)
					$("#phone").text(data.phone)
					$("#idCard").text(data.idCard)
					$("#password").text("********")
				} else {
					var msg = confirm("您还没有登录，是否登录")
					if (msg) {
						top.location.href = "../login/login.html"
					} else {
						top.location.href = "../home/index.html"
					}
				}
			}
		});
		$("#cgmail").click(function() {
			var xgemail = prompt("请输入您的邮箱：", $("#mail").text())
			if (xgemail == '') {
				alert("邮箱不能为空，修改失败")
			}else if(!(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/).test(xgemail)) {
				alert("邮箱不合法，修改失败")
			}
			else {
				$.ajax({
					type : 'post',
					url : '/necp/mapp/ylyn/service/user/fixemail',
					data : {
						'xgemain' : xgemail,
					},
					success : function(data) {
						if (data.toString() == 'success') {
							alert("邮箱修改成功")
							$("#mail").text(xgemail)
						} else
							alert("修改失败")

					}
				});
			}

		})
		$("#cgphone").click(function() {
			var xgphone = prompt("请输入您的手机号码", $("#phone").text())
			if (xgphone == '') {
				alert("手机不能为空，修改失败")
			} else if (!(/^1(3|4|5|6|7|8|9)\d{9}$/).test(xgphone)) {
				alert("手机格式不正确，修改失败")
			} else {
				$.ajax({
					type : 'post',
					url : '/necp/mapp/ylyn/service/user/fixphone',
					data : {
						'xgphone' : xgphone,
					},
					success : function(data) {
						if (data.toString() == 'success') {
							alert("手机号码修改成功")
							$("#phone").text(xgphone)
						} else
							alert("修改失败")

					}
				});
			}

		})
		$("#cgpwd").click(function() {
			var newpwd=prompt("请输入您的新密码","")
			if (newpwd == ''||newpwd==null) {
				alert("密码不能为空，修改失败")
			}
			else if(newpwd.length<6){
				alert("密码长度必须>6，修改失败")
			}else{
				var repwd = prompt("请确认您的新密码","")
				if(newpwd != repwd){
					alert("两次密码不一致，修改失败")
				}else{
					$.ajax({
						type : 'post',
						url : '/necp/mapp/ylyn/service/user/fixpwd',
						data : {
							'newpwd' : newpwd,
						},
						success : function(data) {
							if (data.toString() == 'success') {
								alert("密码修改成功")
								window.location.reload()
							} else
								alert("修改失败")
						}
					});
				}
			}
		})
	})
});