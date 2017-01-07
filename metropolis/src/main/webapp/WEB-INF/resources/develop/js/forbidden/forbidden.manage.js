$(document).on("click", ".js-add-forbidden", function() {
	layer.open({
		type : 2,
		area : [ '700px', '60%' ],
		offset : '20%',
		fixed : false, // 不固定
		anim : 5,
		maxmin : true,
		shade : 0.2,
		title : '新增词汇',
		content : base + '/forbidden/toForbiddenAdd'
	});
});
$(document).on("click", ".js-search", function() {
	if ($("[name=forbiddenWords]").val() == "") {
		layer.msg("敏感词不能为空");
		return;
	}
	$.ajax({
		type : "POST",
		url : base + "/forbidden/viewForbidden",
		dataType : "json",
		data : {
			"forbiddenWords" : $("[name=forbiddenWords]").val()
		},
		success : function(data) {
			$("[class^=js-exist]").hide();
			if (isEmptyArray(data)) {
				$(".js-exist-no").show();
			} else {
				$(".js-exist").show();
			}
		},
		error : function(data) {
			window.parent.layer.msg("请求失败");
			console.info(data)
		},
	});
});
$(document).on("click", ".js-reset", function() {
	$("[name=forbiddenWords]").val("");
});

function saveForbiddenWord(){
	var form = $('#addForbiddenForm');
	if($('#forbiddenWords').val()==''){
		layer.msg("内容不能为空");
		return;
	}
	var data = form.serialize();
	$.ajax({
		type : "POST",
		url : base + "/forbidden/saveForbidden",
		dataType : "json",
		data : data,
		success : function(data) {
			layer.msg("保存成功");
			$('.vip_book_hidden').hide();
		}
	});
	
}
