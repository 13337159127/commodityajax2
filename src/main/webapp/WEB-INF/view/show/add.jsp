<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script type="text/javascript">
	$(function() {
		$.get("${ctxPath}/commodity/selectClassify.kexin", function(data) {
			alert("商品分类信息");
			$.each($.parseJSON(data), function(index, value) {
				$("#categoryId").append("<option value="+value.categoryId+">" + value.category + "</option>");
			});
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#putin").click(function() {
			var commodityId = $("#Id").val();
			if (commodityId == "") {
				alert("请输入商品的ID");
				$("#Id").focus();
				return;
			}
			var commodityName = $("#name").val();
			if (commodityName == "") {
				alert("请输入商品的名称");
				$("#name").focus();
				return;
			}
			var commodityPrice = $("#price").val();
			if (commodityPrice == "") {
				alert("请输入商品的价格");
				$("#price").focus();
				return;
			}
			var commodityMuch = $("#much").val();
			if (commodityMuch == "") {
				alert("请输入商品的数量");
				$("#much").focus();
				return;
			}
			var commodityPeriod = $("#period").val();
			if (commodityPeriod == "") {
				alert("请输入商品的保质期");
				$("#period").focus();
				return;
			}
			var commodityYiedly = $("#yiedly").val();
			if (commodityYiedly == "") {
				alert("请输入商品生产地");
				$("#yiedly").focus();
				return;
			}					 
		 $.post("${ctxPath}/commodity/addCommodity.kexin",
				{
					commodityId : $("#Id").val(),
					commodityName : $("#name").val(),
					commodityPrice : $("#price").val(),
					commodityMuch : $("#much").val(),									 												 			 
					commodityPeriod : $("#period").val(),
					commodityYiedly : $("#yiedly").val(),
					categoryId : $("option").val()
				},
		  function(data) {
				 alert("添加成功，返回首页");
				 window.location.href = '${ctxPath}/commodity/getCommodityShowJsp.kexin';
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
							<h4 class="title">添加商品信息</h4>
						</div>
						<div class="content table-responsive table-full-width">
							<form id="addcommodity"
								action="${ctxPath}/commodity/addcommodity.kexin">
								<table class="table table-striped">
									<tr>
										<th width="30%">商品id</th>
										<td width="70%"><input type="text" id="Id"
											name="commodityId" value="">
									</tr>
									<tr>
										<th width="30%">商品名称</th>
										<td width="70%"><input type="text" id="name"
											name="commodityName" value="">
									</tr>
									<tr>
										<th width="30%">商品价格</th>
										<td width="70%"><input type="text" id="price"
											name="commodityPrice" value="">
									</tr>
									<tr>
										<th width="30%">商品数量</th>
										<td width="70%"><input type="text" id="much"
											name="commodityMuch" value="">
									</tr>
									<tr>
										<th width="30%">商品保质期</th>
										<td width="70%"><input type="text" id="period"
											name="commodityPeriod" value="">
									</tr>
									<tr>
										<th width="30%">商品生产地</th>
										<td width="70%"><input type="text" id="yiedly"
											name="commodityYiedly" value="">
									</tr>
									<tr>
										<th width="30%">商品分类</th>
										<td width="70%"><select name="categoryId" id="categoryId">

										</select></td>
									</tr>
								</table>
								<div class="text-center">
									<input type="button" id="putin" value="添加"
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