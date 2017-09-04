<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="/assets/jspfactory.jsp"%>
<script type="text/javascript">
	$(function() {
		$.get("${ctxPath}/supplier/getSupplierbyId.kexin?supplierID=${supplierID}",function(data) {
			$.each($.parseJSON(data), function(index, value) {
				$("#ID").val(value.supplierID), 
				$("#name").val(value.supplierName), 
				$("#address").val(value.supplierAddress), 
				$("#phone").val(value.supplierPhone)
			});
		});
	});
</script>
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="#" class="simple-text"> 超市管理系统 </a>
				</div>
				<ul class="nav">
					<li class="active"><a
						href="${ctxPath}/commodity/getCommodityShowJsp.kexin"> <i
							class="ti-panel"></i>
							<p>返回首页</p>
					</a></li>
					<li><a href="${ctxPath}/classify/getFindClassifyJsp.kexin">
							<i class="ti-map"></i>
							<p>商品分类管理</p>
					</a></li>
					<li><a href="${ctxPath}/user/getFindUserJsp.kexin"> <i
							class="ti-bell"></i>
							<p>用户名管理</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">供货商信息</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-panel"></i>
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
									<h4 class="title">修改供货商信息</h4>
								</div>
								<div class="content table-responsive table-full-width">
									<form action="${ctxPath}/supplier/updateSupplier.kexin"
										method="get">
										<table class="table table-striped">

											<tr>
												<th width="30%">供货商ID</th>
												<td width="70%"><input type="text" name="supplierID"
													id="ID" value=" "></td>
											</tr>
											<tr>
												<th width="30%">供货商姓名</th>
												<td width="70%"><input type="text" name="supplierName"
													id="name" value=" "></td>
											</tr>
											<tr>
												<th width="30%">供货商地址</th>
												<td width="70%"><input type="text"
													name="supplierAddress" id="address" value=" "></td>
											</tr>
											<tr>
												<th width="30%">供货商电话</th>
												<td width="70%"><input type="text" name="supplierPhone"
													id="phone" value=" "></td>
											</tr>

										</table>
										<div class="text-center">
											<input type="button" value="修改" id="putin"
												class="btn btn-info btn-fill btn-wd">
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
		$(function() {
			$("#putin").click(function() {
				var supplierID = $("#ID").val();
				if (supplierID == "") {
					alert("请输入供货商ID");
					$("#ID").focus();
					return;
				}
				var supplierName = $("#name").val();
				if (supplierName == "") {
					alert("请输入供货商姓名");
					$("#name").focus();
					return;
				}
				var supplierAddress = $("#address").val();
				if (supplierAddress == "") {
					alert("请输入供货商地址");
					$("#address").focus();
					return;
				}
				var supplierPhone = $("#phone").val();
				if (supplierPhone == "") {
					alert("请输入供货商电话");
					$("#phone").focus();
					return;
				}		
		 $.post("${ctxPath}/supplier/updateSupplier.kexin",
			{
				supplierID : $("#ID").val(),
				supplierName : $("#name").val(),
				supplierAddress : $("#address").val(),
				supplierPhone : $("#phone").val()
			},
			function(data){
			 alert("返回首页");
			 window.location.href = "${ctxPath}/supplier/getSupplierShowJsp.kexin";
		 });		
		  
	});
});
</script>
</body>
</html>