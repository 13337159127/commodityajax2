<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="/assets/jspfactory.jsp"%>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">商品信息</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="ti-panel"></i>
						<p>用户名管理</p> <b class="caret"></b>
				</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="ti-bell"></i>
						<p>分类管理</p> <b class="caret"></b>
				</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">每天录入信息</h4>
						</div>

						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>时间</th>
									<th>商品总数</th>
								</thead>

								<tbody>


								</tbody>

							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				type : "get",
				url : "${ctxPath}/commodity/daySumCommodity.kexin",
				dataType : "json",
				success : function(data) {
					$.each(data, function(index, value) {
						$("tbody").append("<tr><td>" + value.date + "</td><td>" + value.num + "</td></tr>");
					});
				},
				error : function() {
					alert("操作失败");
				}
			});
		});
	</script>
</body>
</html>