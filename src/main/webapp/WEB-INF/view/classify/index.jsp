<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="/assets/jspfactory.jsp"%>
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
					<li class="active"><a href="dashboard.html"> <i class="ti-panel"></i>
							<p>分类信息列表</p>
					</a></li>
					<li><a> 
					        <i class="ti-user"></i>
							<p id="addClassify">添加分类</p>
					</a></li>
					<li><a href="${ctxPath}/commodity/getCommodityShowJsp.kexin"> <i class="ti-view-list-alt"></i>
							<p>返回首页</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">分类信息</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-panel"></i>
								<p>用户名管理</p> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="${ctxPath}/user/getFindUserJsp.kexin">查询用户名</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-bell"></i>								 
								<p>分类管理</p> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="${ctxPath}/classify/getFindClassifyJsp.kexin">查询分类</a></li>
							</ul></li>
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
									<h4 class="title">分类信息</h4>
								</div>

								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th>分类ID</th>
                                            <th>商品分类</th> 
                                            <th>编辑分类</th>
                                            <th>删除分类</th>
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
	</div>
 </div>
<script type="text/javascript">
   $(function(){
	   //使用$.get()从服务器获取数据，相当于$.ajax()
	   $.get("${ctxPath}/classify/findClassify.kexin",function(data){
		     alert("展示分类信息");
		     //返回来的data是 json 串，将json串转换为json对象，才能从data中取值
	         $.each($.parseJSON(data),function(index,value){
	    		$("tbody").append("<tr><td>"+value.categoryId+"</td><td>"+value.category+"</td><td><a href='${ctxPath}/classify/getUpdateClassifyJsp.kexin?categoryId="+value.categoryId+"'>编辑分类</a></td><td><a href='${ctxPath}/classify/deleteClassify.kexin?categoryId="+value.categoryId+"'>删除分类</a></td></tr>");
	    	});	    	
	   });
   });
</script>
<script type="text/javascript">
   $(function(){
	  $("#addClassify").click(function(){	
		 //是用load()方法，异步添加添加页面
		 $(".row").load("${ctxPath}/classify/returnAddClassifyJsp.kexin",function(data, status, jqXHR){
			 alert("load方法执行了");
		 }); 
	  }); 	  
   });
</script>
</body>
</html>