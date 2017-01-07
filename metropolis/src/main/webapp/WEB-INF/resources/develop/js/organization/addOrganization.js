function save(){
	var form = $("#addOrganizationForm");
	$.ajax({
		cache: true,
		type: "POST",
		url:base+"/organization/saveOrganization",
		data:form.serialize(),// 你的formid
		async: true,
		dataType : "json",
		success: function(data) {
			layer.msg("保存成功", {
			    time: 1000//1s后自动关闭
			  });
			window.parent.searchOrganization();
			setTimeout(function(){
				window.parent.layer.close(window.parent.addOrganizationWin);
			},1000)
		}
	});
}