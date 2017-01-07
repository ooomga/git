function save(){
	var form = $("#addSystemUserForm");
	var id = $("#systemuserId").val();
	var url = base+"/systemuser/saveSystemUser";
	if(id!=undefined&&id!=""){
		url = base+"/systemuser/updateSystemUser";
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
			window.parent.searchSystemUser();
			setTimeout(function(){
				window.parent.layer.close(window.parent.addSystemUserWin);
			},1000)
		}
	});
}

function changeDepartment(orgId){
	$.ajax({
		cache: true,
		type: "POST",
		url:base+"/systemuser/getOrgDepartments",
		data:{
			orgId:orgId
		},// 你的formid
		async: true,
		dataType : "json",
		success: function(data) {
			if(data!=null&&data!=undefined&&data.length>0){
				var html = "";
				for(var i=0;i<data.length;i++){
					var dep = data[i];
					if(dep!=undefined){
						html += '<option value="'+dep.id+'">'+dep.name+"</option>";
					}
				}
			}
			$("#departmentId").html(html);
		}
	});
}