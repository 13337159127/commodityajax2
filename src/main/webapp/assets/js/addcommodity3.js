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
	var IDString = "Id";
	var commodityName = "name";
	var commodityPrice = "price";
	var commodityMuch = "much";
	var commodityPeriod = "period";
	var commodityYiedly = "yiedly";
	var idValidateRes = validate(IDString, obj);
	if (idValidateRes == false) {
		return false;
	}
	var nameValidateRes = validate(commodityName, obj);
	if (nameValidateRes == false) {
		return false;
	}
	var priceValidateRes = validate(commodityPrice, obj);
	if (priceValidateRes == false) {
		return false;
	}
	var muchValidateRes = validate(commodityMuch, obj);
	if (muchValidateRes == false) {
		return false;
	}
	var periodValidateRes = validate(commodityPeriod, obj);
	if (periodValidateRes == false) {
		return false;
	}
	var yiedlyValidateRes = validate(commodityYiedly, obj);
	if (yiedlyValidateRes == false) {
		return false;
	}
	return true;
}

// 校验：如果元素的值为空值，则校验失败，返回一个false。如果元素值，不为空，校验成功，返回true。
function validate(elementId, obj) {
	var element = document.getElementById(elementId);
	if (element.value == "") {
		alert(obj[elementId]);
		element.focus();
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
