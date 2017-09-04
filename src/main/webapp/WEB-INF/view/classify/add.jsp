<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"> 
<head>
<script type="text/javascript">
	$(function() {		 
		$(document).on("click","button",function() {
			var categoryId = $("#categoryid").val();
			   if (categoryId == "") {
					alert("请输入分类ID");
					$("#categoryid").focus();
					return;
				}
			var category = $("#categor").val();
				if (category == "") {
					alert("请输入分类");
					$("#categor").focus();
					return;
				}
			$.post("${ctxPath}/classify/addClassify.kexin",{categoryId:$("#categoryid").val(),category:$("#categor").val()},function(data){
				alert("操作成功,返回页面");
				window.location.href = '${ctxPath}/classify/getFindClassifyJsp.kexin';    
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
							<h4 class="title">添加分类信息</h4>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<tr>
									<th>分类ID</th>
									<td><input type="text" name="categoryId" id="categoryid" value=""></td>
								</tr>
								<tr>
									<th>商品分类</th>
									<td><input type="text" name="category" id="categor" value=""></td>
								</tr>
							</table>
							<div class="text-center">
								<button class="btn btn-info btn-fill btn-wd">添加</button>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div> 
</div>	
</body>
</html>	