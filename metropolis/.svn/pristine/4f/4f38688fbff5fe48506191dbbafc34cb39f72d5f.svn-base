function save(){
		var form = $("#addLostForm");
		var url = null;
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
				window.parent.getLost();
				setTimeout(function(){
					window.parent.layer.close(window.parent.addLostWin);
				},1000)
			}
		});
}



