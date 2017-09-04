<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="/assets/jspfactory.jsp"%>
<script type="text/javascript">
   $(function(){
	  $.get("${ctxPath}/commodity/getCommoditybyId.kexin?commodityId=${commodityId}",function(data){
		  $.each($.parseJSON(data),function(index,value){
				 $("#Id").val(value.commodityId),
				 $("#Name").val(value.commodityName),
				 $("#Price").val(value.commodityPrice),
				 $("#Much").val(value.commodityMuch),
				 $("#Period").val(value.commodityPeriod),
				 $("#Yiedly").val(value.commodityYiedly),
				 $("#option1").val(value.categoryId)
			  });
	    });	  
   });
</script>
<script type="text/javascript">
$(function(){
   $.get("${ctxPath}/commodity/selectClassify.kexin",function(data){
	   $.each($.parseJSON(data),function(index,math){
			  //判断：如果查询出商品的ID等于分类的ID，就输出这个分类， 
			  if($("#option1").val() == math.categoryId){
				  $("#option1").text(math.category);
			  //如果查询出商品的ID不等于分类的ID，添加<option>元素，输出其它分类	  
			  }else if($("#option1").val() != math.categoryId){
				  $("#categoryid").append("<option value="+math.categoryId+">"+math.category+"</option>");
			  }
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
					<a href="#" class="simple-text">超市管理系统</a>
				</div>
				<ul class="nav">
					<li class="active"><a href="${ctxPath}/commodity/getCommodityShowJsp.kexin"> <i class="ti-panel"></i>
							<p>返回首页</p>
					</a></li>
					<li><a href="${ctxPath}/commodity/commoditySum.kexin"> <i class="ti-view-list-alt"></i>
							<p>用户商品总数</p>
					</a></li>
					<li><a href="${ctxPath}/commodity/daySumCommodity.kexin"> <i class="ti-text"></i>
							<p>每天录入商品总数</p>
					</a></li>
					<li><a href="${ctxPath}/commodity/classifySumCommodity.kexin"> <i class="ti-pencil-alt2"></i>
							<p>每个分类商品总数</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">修改商品信息</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-panel"></i>
								<p>用户名管理</p> <b class="caret"></b>
						</a>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-bell"></i>								 
								<p>分类管理</p> <b class="caret"></b>
						</a>
						</li>
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
									<h4 class="title">修改商品信息</h4>
								</div>
								<div class="content table-responsive table-full-width">
				<form action="${ctxPath}/commodity/updateCommodity.kexin" method="get">				
				<table class="table table-striped">
				 
				<tr>
					<th width="30%">商品id</th>
					<td width="70%"><input type="text" id="Id" name="commodityId" value=" ">
				</tr>
				<tr>
					<th width="30%">商品名称</th>
					<td width="70%"><input type="text" name="commodityName" id="Name" value=" ">
				</tr>
				<tr>
					<th width="30%">商品价格</th>
					<td width="70%"><input type="text" name="commodityPrice" id="Price" value=" ">
				</tr>
				<tr>
					<th width="30%">商品数量</th>
					<td width="70%"><input type="text" name="commodityMuch" id="Much" value=" ">
				</tr>
				<tr>
					<th width="30%">商品保质期</th>
					<td width="70%"><input type="text" name="commodityPeriod" id="Period" value=" ">
				</tr>
				<tr>
					<th width="30%">商品生产地</th>
					<td width="70%"><input type="text" name="commodityYiedly" id="Yiedly" value=" ">
				</tr>
				<tr>
					<th width="30%">商品分类</th>
					<td width="70%">
					<select name="categoryId" id="categoryid">				 
				     <option id="option1" value=" " selected="selected">  </option>
				    <!--  
			       <c:forEach  items="${re}" var="categor">  
                                                这里判断，如果商品的分类ID == 你当前分类的分类ID，说明这个分类就是这个商品的分类。 
                   <c:if test="${commodity.categoryId eq categor.categoryId}">  
   		              <option value=" " selected="selected">  </option>
                   </c:if>                 
                   <c:if test="${commodity.categoryId!= categor.categoryId}">
   		                <option value="${categor.categoryId}" >${categor.category}</option>
                   </c:if>
                   </c:forEach>
                    -->
				</select> 			 
					</td> 
				</tr> 
			 
				</table>
				<div class="text-center">
					<input type="button" value="修改" id="putin" class="btn btn-info btn-fill btn-wd">
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
 $(function(){
    $("#putin").click(function(){
      var commodityId=$("#Id").val();
        if(commodityId==""){
        	alert("请输入商品ID");
        	$("#Id").focus();
        	return;
        }
      var commodityName=$("#Name").val();
        if(commodityName==""){
        	alert("请输入商品名称");
        	$("#Name").focus();
        	return;
        }  
      var commodityPrice=$("#Price").val();
        if(commodityPrice==""){
        	alert("请输入商品价格");
        	$("#Price").focus();
        	return;
        }    
      var commodityMuch=$("#Much").val();
        if(commodityMuch==""){
        	alert("请输入商品数量");
        	$("#Much").focus();
        	return;
        }     
      var commodityPeriod=$("#Period").val();
        if(commodityPeriod==""){
        	alert("请输入商品保质期");
        	$("#Period").focus();
        	return;
        }       
      var commodityYiedly=$("#Yiedly").val();
        if(commodityYiedly==""){
        	alert("请输入商品生产地");
        	$("#Yiedly").focus();
        	return;
        }   
        $.post("${ctxPath}/commodity/updateCommodity.kexin",
        {
	    	  commodityId:$("#Id").val(),
	    	  commodityName:$("#Name").val(),
	    	  commodityPrice:$("#Price").val(),
	    	  commodityMuch:$("#Much").val(),
	    	  commodityPeriod:$("#Period").val(),
	    	  commodityYiedly:$("#Yiedly").val(),
	    	  categoryId:$("#categoryid").val()
	    },
	    function(data){
        	alert("操作成功");
	    	window.location.href='${ctxPath}/commodity/getCommodityShowJsp.kexin';
         });   		 
      });
   });
</script>	
</body>
</html>