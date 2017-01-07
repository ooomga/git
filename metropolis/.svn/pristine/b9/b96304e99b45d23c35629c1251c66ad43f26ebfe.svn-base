function save(){
	var form = $("#addPermissionForm");
	$.ajax({
		cache: true,
		type: "POST",
		url:base+"/permission/savePermission",
		data:form.serialize(),// 你的formid
		async: true,
		dataType : "json",
		success: function(data) {
			layer.msg("保存成功", {
			    time: 1000//1s后自动关闭
			  });
			window.parent.searchPermission();
			setTimeout(function(){
				window.parent.layer.close(window.parent.addPermissionWin);
			},1000)
		}
	});
}