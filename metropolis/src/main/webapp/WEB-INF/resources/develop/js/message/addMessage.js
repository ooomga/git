function saveUser(fileName){
	$("#image").val(fileName);
	if(ue){
		var form = $("#addMessageForm");
		var url = base+"/message/saveMessage";
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
				window.parent.getMessageList();
				setTimeout(function(){
					window.parent.layer.close(window.parent.addMessageWin);
				},1000)
			}
		});
	}
}

function uploadFile(file){
	 var form = new FormData();
    form.append("file", file);  
    form.append("folder", "richtext");  
   $.ajax({
     type: "POST",
     url: base+"/file/uploadFile",
     enctype: 'multipart/form-data',
     data: form,
     dataType:"json",
     processData: false,
     contentType: false,
     cache: false,
     async: true,
     success: function (data) {
   	  saveUser(data.fileNamePath)
     }
   });
}

function save(){
	 var file =  $('#imageFile').get(0).files[0];
	 if(file==undefined){
		 saveUser()
	 }else{
		 uploadFile(file);
	 }
}

