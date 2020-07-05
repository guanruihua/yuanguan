/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
require([ "necp.genentity.controller" ], function(GenentityController) {

	/*var option = {};
	option.classId = "10002";
	option.typeId = "10003";
	option.sceneId = "94ab988c6e665c422df908509b7f945f";

	var controller = GenentityController.create(option);
	controller.show();*/

	$(function() {
		$.ajax({
			type : "post",
			url : "/necp/mapp/ylyn/service/browsePost/getUser",
			success : function(result) {
				if (result != '') {
					$("#login").hide()
					$("#userName").text(result.nickName)
					if (result.personalSign != null)
						$("#personalSigna").text("个性签名：" + result.personalSign)
					if (result.head.toString() != '') {
						var src = "data:image/png;base64," + result.head
						$("#posterHead").attr("src", src)
					}
				}
				$.ajax({
					type : "post",
					url : "/necp/mapp/ylyn/service/browsePost/getPostInfo",
					data : {
						'postId' : window.location.search.substr(1, 32),
					},
					success : function(data) {
						if (data != '') {
							if (data.head.toString() != "") {
								var src = "data:image/png;base64," + data.head
								$("#ownerHead").attr("src", src)
							}
							if (data.postPublisher == result.nickName)
								$("#deleteButton").show()
							if (data.concern != null)
								$("#like").text(data.concern)
							if(data.postType=="公告区"){
								$("#like").hide()
							}
							$("#postName").text(data.postName)
							$("#oneFloor").text(data.postPublisher)
							$("#oneContext").text(data.postContent)
							var time = data.isSUETM;
							time.replace(/Date\([\d+]+\)/, function(a) {
								eval('d = new ' + a)
							})
							$("#oneDate").text(d.toLocaleDateString())
						}
					}
				});
			}
		});
		$.ajax({
			type : "post",
			url : "/necp/mapp/ylyn/service/browsePost/getAllPostMessage",
			async : false,
			data : {
				'postId' : window.location.search.substr(1, 32),
			},
			success : function(data) {
				var last = 0;
				if (data.length % 2 == 0) {
					last = data.length / 2;
				} else {
					last = (data.length / 2) + 1;
				}
				if (window.location.search.substr(33) > 1) {
					$("#page").append('<a href=http://127.0.0.1:8080/necp/mapp/ylyn/page/browsePost/browsePost.html?' + window.location.search.substr(1, 32) + (parseInt(window.location.search.substr(33)) - 1) + '>上一页</a>')
				}
				$("#page").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
				for (var i = 1; i <= last; i++) {
					$("#page").append('<a href=http://127.0.0.1:8080/necp/mapp/ylyn/page/browsePost/browsePost.html?' + window.location.search.substr(1, 32) + i + '>' + i + '</a>')
					$("#page").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
				}
				if (window.location.search.substr(33) < last - 1) {
					$("#page").append('<a href=http://127.0.0.1:8080/necp/mapp/ylyn/page/browsePost/browsePost.html?' + window.location.search.substr(1, 32) + (parseInt(window.location.search.substr(33)) + 1) + '>下一页</a>')
				}
				$("#replyButton").click(function() {
					$.ajax({
						async : false,
						type : 'post',
						url : '/necp/mapp/ylyn/service/browsePost/reply',
						data : {
							'message' : $("#replyText").val(),
							'postID' : window.location.search.substr(1, 32),
							'messageNum' : data.length + 2,
						},
						success : function(data) {
							if (data.toString() == 'success') {
								alert("回复成功")
								window.location.href = "http://127.0.0.1:8080/necp/mapp/ylyn/page/browsePost/browsePost.html?" + window.location.search.substr(1)
							} else {
								var msg = confirm("您还没有登录，是否登录")
								if (msg) {
									window.location.href = "../login/login.html"
								}
							}
						}
					});
				})
			}
		});
		$.ajax({
			type : "post",
			url : "/necp/mapp/ylyn/service/browsePost/getPostMessageByPage",
			data : {
				'postId' : window.location.search.substr(1, 32),
				'index' : parseInt(window.location.search.substr(33)),
			},
			success : function(data) {
				if (data.length == 1) {
					$("#two").show()
					if (data[0].head.toString() != "") {
						var src = "data:image/png;base64," + data[0].head
						$("#twoFloorHead").attr("src", src)
					}
					$("#twoFloor").text(data[0].messageOwner)
					$("#twoFloorNum").text(data[0].messageNum + "楼")
					$("#twoContext").text(data[0].message)
					var time = data[0].messageTime;
					time.replace(/Date\([\d+]+\)/, function(a) {
						eval('d = new ' + a)
					})
					$("#twoDate").text(d.toLocaleDateString())
				} else if (data.length == 2) {
					$("#two").show()
					$("#three").show()
					if (data[0].head.toString() != "") {
						var src = "data:image/png;base64," + data[0].head
						$("#twoFloorHead").attr("src", src)
					}
					$("#twoFloor").text(data[0].messageOwner)
					$("#twoFloorNum").text(data[0].messageNum + "楼")
					$("#twoContext").text(data[0].message)
					var time = data[0].messageTime;
					time.replace(/Date\([\d+]+\)/, function(a) {
						eval('d = new ' + a)
					})
					$("#twoDate").text(d.toLocaleDateString())
					$("#threeFloor").text(data[1].messageOwner)
					if (data[1].head.toString() != "") {
						var src = "data:image/png;base64," + data[1].head
						$("#threeFloorHead").attr("src", src)
					}
					$("#threeFloorNum").text(data[1].messageNum + "楼")
					$("#threeContext").text(data[1].message)
					var time = data[1].messageTime;
					time.replace(/Date\([\d+]+\)/, function(a) {
						eval('d = new ' + a)
					})
					$("#threeDate").text(d.toLocaleDateString())
				}
			}
		});
		$("#delete").click(function() {

			$.ajax({
				type : "post",
				url : "/necp/mapp/ylyn/service/browsePost/deletePost",
				data : {
					'postId' : window.location.search.substr(1, 32),
				},
				success : function() {
					alert("删除成功")
					window.location.href = "../home/index.html"
				}
			});
		})
		$("#like").click(function() {
			console.log($("#like").text())
			if ($("#like").text().toString() == "关注该贴") {
				$.ajax({
					type : "post",
					url : "/necp/mapp/ylyn/service/browsePost/like",
					data : {
						'postId' : window.location.search.substr(1, 32),
					},
					success : function(data) {
						if (data.toString() == "success") {
							alert("关注成功")
							window.location.reload()
						} else {
							var msg = confirm("您还没有登录，是否登录")
							if (msg) {
								window.location.href = "../login/login.html"
							}
						}
					}
				});
			} else if ($("#like").text() == "已关注") {
				$.ajax({
					type : "post",
					url : "/necp/mapp/ylyn/service/browsePost/notlike",
					data : {
						'postId' : window.location.search.substr(1, 32),
					},
					success : function(data) {
						if (data.toString() == "success") {
							alert("已取消关注")
							window.location.reload()
						}
					}
				});
			}
		})
	})
});