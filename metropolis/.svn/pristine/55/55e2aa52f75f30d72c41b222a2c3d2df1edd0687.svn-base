$("#form").validate({
	ignore : ":hidden",
	rules : {
		acount : {
			required : true,
		},
		password : {
			required : true,
			maxlength : 24,
		},
	},
	messages : {
		acount : {
			required : "请输入用户名",
		},
		password : {
			required : "请输入密码",
			maxlength : "密码超出长度限制{0}",
		},
	},
	// 指定错误信息位置
	errorPlacement : function(error, element) {
		// 如果是radio或checkbox
		error.css('color', 'red');
		if (element.is(':radio') || element.is(':checkbox')) {
			var eid = element.attr('name'); // 获取元素的name属性
			error.appendTo(element.parent()); // 将错误信息添加当前元素的父结点后面
		} else {
			error.insertAfter(element);
		}
	},
	submitHandler : function(form) {
		dubug: true
		submit(form);
	},
});
submit = function(form) { // 表单提交后更新页面显示的数据
	$.ajax({
		type : "POST",
		url : form.action,
		dataType : "json",
		data : $(form).serialize(),
		success : function(data) {
			if (!data.login) {
				alert("用户或密码错误");
			} else {
				window.location.href = base + "/system/toHome";
			}
		},
		error : function(data) {
			console.info(data)
		},
	});
}

$(document).on("click", ".js-regit", function() {
	alert("请联系管理员");
});
