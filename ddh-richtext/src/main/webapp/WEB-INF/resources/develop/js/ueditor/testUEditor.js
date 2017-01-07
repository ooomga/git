function save(){
	if(ue){
		var form = $("#ueditorForm");
//		var content = ue.getContent();
		$.ajax({
            cache: true,
            type: "POST",
            url:base+"/richtext/saveRichText",
            data:form.serialize(),// 你的formid
            async: true,
            dataType : "json",
            success: function(data) {
            	if(data.success){
            		
            	}
            }
        });
	}
}

/*function save() {
	fadeDialog('bottom-list');
	var form = $("#incidentForm");
	var isValid = form.valid();
	if($('#caller_id').val()==null){//发起人为空
		$('#caller_id_error').text('发起人为必选字段');
		return;
	}
	if (isValid) {
		var index = layer.load(1,1);
		$.ajax({
            cache: true,
            type: "POST",
            url:base+"/incident/saveIncident",
            data:form.serialize(),// 你的formid
            async: true,
            dataType : "json",
            success: function(data) {
            	layer.msg("新建成功");
            	relate(data);//关联联系人
            }
        });
	} else {
	}
}*/