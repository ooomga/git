function save(){
//	var form = $("#addHardForm");
//	$.ajax({
//		cache: true,
//		type: "POST",
////		url:base+"/permission/savePermission",
//		data:form.serialize(),// 你的formid
//		async: true,
//		dataType : "json",
//		success: function(data) {
			layer.msg("保存成功", {
			    time: 1000//1s后自动关闭
			  });
			window.parent.getHardware();
			setTimeout(function(){
				window.parent.layer.close(window.parent.addHardWin);
			},1000)
//		}
//	});
}
function edit(){
	var form = $("#editHardForm");
//	$.ajax({
//		cache: true,
//		type: "POST",
////		url:base+"/permission/savePermission",
//		data:form.serialize(),// 你的formid
//		async: true,
//		dataType : "json",
//		success: function(data) {
			layer.msg("保存成功", {
			    time: 1000//1s后自动关闭
			  });
			window.parent.getHardware();
			setTimeout(function(){
				window.parent.layer.close(window.parent.editHardWin);
			},1000)
//		}
//	});
}