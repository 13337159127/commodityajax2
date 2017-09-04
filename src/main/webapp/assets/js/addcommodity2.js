//把id和提示语存放到obj对象里面
function traget() {
	var obj = new Object();
	obj["Id"] = "请输入id";
	obj["name"] = "请输入商品名称";
	obj["price"] = "请输入商品价格";
	obj["much"] = "请输入数量";
	obj["period"] = "请输入保质期";
	obj["yiedly"] = "请输入生产地";
	return obj;
}
// 判断：如果为空，元素如果为空，则弹出输入框
function judge(obj) {
	var Id = document.getElementById("Id");
	if (Id.value == "") {
		alert(obj["Id"]);
		Id.focus();
		return false;
	}
	var name = document.getElementById("name");
	if (name.value == "") {
		alert(obj["name"]);
		name.focus();
		return false;
	}
	var price = document.getElementById("price").value;
	if (price == "" || isNaN(price) != false) {
		alert(obj["price"]);
		document.getElementById("price").focus();
		return false;
	}
	var much = document.getElementById("much");
	if (much.value == "") {
		alert(obj["much"]);
		much.focus();
		return false;
	}
	var period = document.getElementById("period");
	if (period.value == "") {
		alert(obj["period"]);
		period.focus();
		return false;
	}
	var yiedly = document.getElementById("yiedly");
	if (yiedly.value == "") {
		alert(obj["yiedly"]);
		yiedly.focus();
		return false;
	}
	return true;
}

// js提交form表单
function commit() {
	// 这个函数是把ID和对应的 “请输入.....” 放到对象里 返回一个对象
	var obj = traget();
	// 调用这个函数，用一个变量接收返回值true或false
	var res = judge(obj);
	// 如果返回值为true，则执行提交表单语句，如果返回值为false，不执行提交表单语句。
	if (res == true) {
		document.getElementById("addcommodity").submit();
	}
}