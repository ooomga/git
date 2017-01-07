function saveNotice(id){
		var form = $("#editForm");
		var url = base+"/notice/editNotice?id="+id;
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
				window.parent.getNoticeMaster();
				setTimeout(function(){
					window.parent.layer.close(window.parent.editNoticeWin);
				},1000)
			}
		});
	
}

function save(){
	var form = $("#addForm");
	var url = base+"/notice/saveNotice";
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
			window.parent.getNoticeMaster();
			setTimeout(function(){
				window.parent.layer.close(window.parent.editNoticeWin);
			},1000)
		}
	});
}

function send(){
	var form = $("#addForm");
	var url = base+"/notice/saveNotice";
	$.ajax({
		cache: true,
		type: "POST",
		url:url,
		data:form.serialize(),// 你的formid
		async: true,
		dataType : "json",
		success: function(data) {
			layer.msg("发送成功", {
				time: 1000//1s后自动关闭
			});
			window.parent.getNoticeMaster();
			setTimeout(function(){
				window.parent.layer.close(window.parent.editNoticeWin);
			},1000)
		}
	});
}




