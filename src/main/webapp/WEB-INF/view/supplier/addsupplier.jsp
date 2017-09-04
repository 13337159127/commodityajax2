<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
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
			$.post("${ctxPath}/supplier/addSupplier.kexin",
					{
						supplierID : $("#ID").val(),
						supplierName : $("#name").val(),
						supplierAddress : $("#address").val(),
						supplierPhone : $("#phone").val()
					},
					function(data) {
						alert("返回首页");
						window.location.href = "${ctxPath}/supplier/getSupplierShowJsp.kexin";
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
							<h4 class="title">添加供货商信息</h4>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<tr>
									<th width="30%">供货商ID</th>
									<td width="70%"><input type="text" name="supplierID"
										id="ID" value=""></td>
								</tr>
								<tr>
									<th width="30%">供货商姓名</th>
									<td width="70%"><input type="text" name="supplierName"
										id="name" value=""></td>
								</tr>
								<tr>
									<th width="30%">供货商地址</th>
									<td width="70%"><input type="text" name="supplierAddress"
										id="address" value=""></td>
								</tr>
								<tr>
									<th width="30%">供货商电话</th>
									<td width="70%"><input type="text" name="supplierPhone"
										id="phone" value=""></td>
								</tr>
							</table>
							<div class="text-center">
								<input type="button" id="putin"
									class="btn btn-info btn-fill btn-wd" value="添加">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>