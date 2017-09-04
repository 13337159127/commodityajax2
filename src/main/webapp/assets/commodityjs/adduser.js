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
		$.ajax({
			  type : 'get',
			  url : 'addUserName.kexin',
			  data : {
					userId : $("#userid").val(),
					loginName : $("#loginname").val(),
					passWord : $("#password").val()
		   },
		      dataType : 'json',
			  success : function(data) {
			  alert("操作成功");
			  window.location.href = 'getFindUserJsp.kexin';
		   },
			  error : function() {
			  alert("操作失败");
			  },
		  });
	 });
});