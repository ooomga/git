function save(){
	var form = $("#addDepartmentForm");
	var id = $("#departmentId").val();
	var url = base+"/department/saveDepartment";
	if(id!=undefined&&id!=""){
		url = base+"/department/updateDepartment";
	}
	$.ajax({
		cache: true,
		type: "POST",
		url:url,
		data:form.serialize(),// 你的formid
		async: true,
		dataType : "json",
		success: function(data) {
			layer.msg("保存成功", {
			    time: 1000//1s后自动关闭
			  });
			window.parent.searchDepartment();
			setTimeout(function(){
				window.parent.layer.close(window.parent.addDepartmentWin);
			},1000)
		}
	});
}