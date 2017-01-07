function save(type){
	var code= $("#stationCode").val();
	var name = $("#stationName").val();
	if(code=='' || name==''){
		layer.msg("必填项不能为空！", {
		    time: 1000//1s后自动关闭
		  });
	}
	if('add'){
		var form = $("#addStationForm");
//		$.ajax({
//			cache: true,
//			type: "POST",
//			url:base+"/station/saveStation",
//			data:form.serialize(),// formid
//			async: true,
//			dataType : "json",
//			success: function(data) {
				layer.msg("保存成功", {
				    time: 1000//1s后自动关闭
				  });
				window.parent.listStation();
				setTimeout(function(){
					window.parent.layer.close(window.parent.addStationWin);
				},1000)
//			}
//		});
	}else{
		var form = $("#modifyLineForm");
		var seq = $("#seq").val();
//		$.ajax({
//			cache: true,
//			type: "POST",
//			url:base+"/line/updateLine?seq="+seq,
//			data:form.serialize(),// formid
//			async: true,
//			dataType : "json",
//			success: function(data) {
				layer.msg("保存成功", {
				    time: 1000//1s后自动关闭
				  });
				window.parent.listStation();
				setTimeout(function(){
					window.parent.layer.close(window.parent.addStationWin);
				},1000)
//			}
//		});
	}
	
}

function delmark(){
	layer.msg('删除成功', {
	    time: 800//1s后自动关闭
	  });
  listStation();
}
