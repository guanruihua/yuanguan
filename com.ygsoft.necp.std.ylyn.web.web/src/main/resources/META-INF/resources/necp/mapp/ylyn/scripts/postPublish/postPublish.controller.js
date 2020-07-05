/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {

/*	var option = {};
	option.classId = "10002";
	option.typeId = "10003";
	option.sceneId = "28f5ab8a7980a7e6d35ec5cd5038b6d5";

	var controller = GenentityController.create(option);
	controller.show();*/
	$(function() {
		$.ajax({
			type : 'post',
			url : '/necp/mapp/ylyn/service/home/home',
			async : false,
			success : function(data) {
				if (data.nickName == null) {
					var choice = confirm("您还没有登录,是否登录？")
					if (choice)
						window.location.href = "../login/login.html"
					else
						window.location.href = "../home/index.html"
				} else if (data.nickName != null) {
					$("#submit").click(function() {
						var postType = $("#postType").val()
						if( $("#postName").val() == ""){
							alert("请输入标题");
						}else if( $("#postContent").val()==""){
							alert("请输入内容");
						}else{
							$.ajax({
								async : false,
								type : 'post',
								url : '/necp/mapp/ylyn/service/postPublish/postPublish',
								data : {
									'postName' : $("#postName").val(),
									'postType' : postType,
									'postContent' : $("#postContent").val()
								},
								success : function(data) {
									if (data.toString() == 'success') {
										alert("发布成功")
										window.location.href="../home/index.html"
									} else {
										alert("发布失败")
									}
								}
							});
						}
					})
				}
			}
		});
		$("#reset").click(function() {
			$("input").attr("value","");
			$("textarea").attr("value", "");
		})
	})
});