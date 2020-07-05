/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {
	/*
		var option = {};
		option.classId = "10002";
		option.typeId = "10002";
		option.sceneId = "780636b715ad13c77dc7c6bc74bbb85a";

		var controller = GenentityController.create(option);
		controller.show();
	*/
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
		$("#img-upload").change(function(e) {
			var imgBox = e.target;
			uploadImg($('#head'), imgBox)
		});
		function uploadImg(element, tag) {
			var file = tag.files[0];
			var imgSrc;
			if (!/image\/\w+/.test(file.type)) {
				alert("请好好上传图片");
				return false;
			}
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function() {
				var src = this.result
				$("#head").attr("src", src)
			};
		}
		$.ajax({
			async:false,
			type : 'post',
			url : '/necp/mapp/ylyn/service/personalInfo/personalInfo',
			success : function(data) {
				if (data.nickName == null) {
					var msg = confirm("您还没有登录，是否登录")
					if (msg) {
						top.location.href = "../login/login.html"
					} else {
						top.location.href = "../home/index.html"
					}
				} else {
					if (data.head.toString() != '') {
						var src = "data:image/png;base64," + data.head
						$("#head").attr("src", src)
					}
					$("#nickName").text(data.nickName)
					$("#realName").val(data.realName)
					$("#sex").find("option:contains('" + data.sex + "')").attr("selected", true);
					$("#address").val(data.homeAddress)
					$("#education").find("option:contains('" + data.education + "')").attr("selected", true);
					$("#pay").find("option:contains('" + data.pay + "')").attr("selected", true);
					$("#sign").val(data.personalSign)
				}
			}
		});
		$("#save").click(function() {
			var formData = new FormData();
			formData.append('photo', document.getElementById('img-upload').files[0])
			$.ajax({
				type : 'post',
				async:false,
				url : '/necp/mapp/ylyn/service/personalInfo/infoUpdate',
				data : {
					'nickName' : $("#nickName").text(),
					'realName' : $("#realName").val(),
					'sex' : $("#sex").val(),
					'address' : $("#address").val(),
					'education' : $("#education").val(),
					'pay' : $("#pay").val(),
					'sign' : $("#sign").val(),
				},
				success : function(data) {
					if (data.toString() == "success") {
						alert("保存成功")
						window.location.reload()
					}
					else
						alert("昵称已存在")
				}
			});
			$.ajax({
				async:false,
				url : "/necp/mapp/ylyn/service/personalInfo/uploadPhoto",
				type : "post",
				data : formData,
				contentType : false,
				processData : false,
				success : function() {
					window.location.reload()
				}
			});
		})
		$("#exit").click(function() {
			top.location.href = '../home/index.html'
		})
	})
});