<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<script type="text/javascript">	 
	$(function() {
		$("#putin").click(function() {
			//根据id取出元素的值
			var userId = $("#userid").val();
			//如果值为空，进入循环
			if (userId == "") {
				alert("请输入用户ID");
				$("#userid").focus();
				return;
			}
			var loginName = $("#loginname").val();
			if (loginName == "") {
				alert("请输入用户名");
				$("#loginname").focus();
				return;
			}
			var passWord = $("#password").val();
			if (passWord == "") {
				alert("请输入用户密码");
				$("#password").focus();
				return;
			}
			$.post("${ctxPath}/user/addUserName.kexin", {
				userId : $("#userid").val(),
				loginName : $("#loginname").val(),
				passWord : $("#password").val()
			}, function(data) {
				alert("添加成功，返回首页");
				window.location.href = '${ctxPath}/user/getFindUserJsp.kexin';
			});

		});
	});
</script>
</head>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">添加用户信息</h4>
						</div>
						<div class="content table-responsive table-full-width">
							<form action="${ctxPath}/user/addUserName.kexin" method="get">
								<table class="table table-striped">
									<tr>
										<th width="30%">用户名ID</th>
										<td width="70%"><input type="text" name="userId"
											id="userid" value=""></td>
									</tr>
									<tr>
										<th width="30%">用户名</th>
										<td width="70%"><input type="text" name="loginName"
											id="loginname" value=""></td>
									</tr>
									<tr>
										<th width="30%">用户名密码</th>
										<td width="70%"><input type="text" name="passWord"
											id="password" value=""></td>
									</tr>
								</table>
								<div class="text-center">
									<input type="button" value="添加" id="putin"
										class="btn btn-info btn-fill btn-wd">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>