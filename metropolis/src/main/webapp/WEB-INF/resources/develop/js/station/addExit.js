function save(){

			layer.msg("保存成功", {
			    time: 1000//1s后自动关闭
			  });
			window.parent.getExitList();
			setTimeout(function(){
				window.parent.layer.close(window.parent.addExitWin);
				window.parent.layer.close(window.parent.addMarkWin);
			},1000)
}