$(function() {
	$("#putin").click(function() {
		// 校验商品ID
		var Id = $('#Id').val();
		if (Id == "") {
			// 弹出请输入.....
			alert("请输入id");
			// ID元素触发focus事件
			$('#Id').focus();
			return;
		}
		// 校验商品名称
		var name = $('#name').val();
		if (name == "") {
			// 弹出请输入.....
			alert("请输入商品名称");
			// ID元素触发focus事件
			$('#name').focus();
			return;
		}
		// 校验商品价格
		var price = $('#price').val();
		if (price == "") {
			// 弹出请输入.....
			alert("请输入商品价格");
			// ID元素触发focus事件
			$('#price').focus();
			return;
		}
		// 校验商品数量
		var much = $('#much').val();
		if (much == "") {
			// 弹出请输入.....
			alert("请输入商品数量");
			// ID元素触发focus事件
			$('#much').focus();
			return;
		}
		// 校验商品保质期
		var period = $('#period').val();
		if (period == "") {
			// 弹出请输入.....
			alert("请输入商品保质期");
			// ID元素触发focus事件
			$('#period').focus();
			return;
		}
		// 校验商品保质期
		var yiedly = $('#yiedly').val();
		if (yiedly == "") {
			// 弹出请输入.....
			alert("请输入商品生产地");
			// ID元素触发focus事件
			$('#yiedly').focus();
			return;
		}
		$("#addcommodity").submit();
	});
});