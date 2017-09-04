<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="/assets/jspfactory.jsp"%>
</head>
<body>
<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                                        超市管理系统
                </a>
            </div>
            <ul class="nav">
                <li class="active">  
                    <a href="${ctxPath}/commodity/getCommodityShowJsp.kexin">                  
                        <i class="ti-user"></i>
                        <p>查询商品信息</p>
                    </a>
                </li>
                <li class="active">
                    <a>
                        <i class="ti-text"></i>
                        <p id="commoditySum">用户商品总数</p>
                    </a>
                </li>
                <li class="active">
                    <a>
                        <i class="ti-pencil-alt2"></i>
                        <p id="daySumCommodity">每天录入商品总数</p>
                    </a>
                </li>
                <li class="active">
                    <a>
                        <i class="ti-map"></i>
                        <p id="classify">每个分类商品总数</p>
                    </a>
                </li>
                <li class="active"><a href="${ctxPath}/classify/getFindClassifyJsp.kexin"> <i class="ti-map"></i>
							<p>商品分类管理</p>
					</a></li>
					<li class="active"><a href="${ctxPath}/user/getFindUserJsp.kexin"> <i class="ti-bell"></i>
							<p>用户名管理</p>
					</a></li>
					<li class="active"><a href="${ctxPath}/supplier/getSupplierShowJsp.kexin"> <i class="ti-map"></i>
							<p>供货商管理</p>
					</a></li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
		<nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">成功页面</a>
                </div>
               <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-panel"></i>
								<p>用户管理</p>
								<b class="caret"></b>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-bell"></i>
									<p>分类管理</p>
									<b class="caret"></b>
                              </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <center><h2>登录成功，欢迎您:<font color="red">${name}</font></h2></center>     
    </div>
</div>
<script type="text/javascript">
    $(function(){   	 
    	$("#commoditySum").click(function(){
    		$(".main-panel").load("${ctxPath}/commodity/commoditySum.kexin",function(data){
    			alert("用户商品总数");
    		});
    	});
    	$("#daySumCommodity").click(function(){
    		$(".main-panel").load("${ctxPath}/commodity/getDaySumCommodityJsp.kexin",function(data){
    			alert("每天商品总数");
    		});
    	});
    	$("#classify").click(function(){
    		$(".main-panel").load("${ctxPath}/commodity/classifySumCommodityJsp.kexin",function(data){
    			alert("每个分类商品总数");
    		});
    	});
    });
</script>
</body>   
</html>
