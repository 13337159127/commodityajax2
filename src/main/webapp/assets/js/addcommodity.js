function judge() {
	// 获取元素，并赋值给变量ID。
	var Id = document.getElementById("Id");
	// 如果元素中的值等于空
	if (Id.value == "") {
		// 弹出请输入.....
		alert("请输入id");
		// ID元素触发focus事件
		Id.focus();
		return;
	}
	var name = document.getElementById("name");
	if (name.value == "") {
		alert("请输入商品名称");
		name.focus();
		return;
	}
	var price = document.getElementById("price");
	if (price.value == "") {
		alert("请输入商品价格");
		price.focus();
		return;
	}
	var much = document.getElementById("much");
	if (much.value == "") {
		alert("请输入数量");
		much.focus();
		return;
	}
	var period = document.getElementById("period");
	if (period.value == "") {
		alert("请输入保质期");
		period.focus();
		return;
	}
	var yiedly = document.getElementById("yiedly");
	if (yiedly.value == "") {
		alert("请输入生产地");
		yiedly.focus();
		return;
	}
	document.getElementById("addcommodity").submit();
}