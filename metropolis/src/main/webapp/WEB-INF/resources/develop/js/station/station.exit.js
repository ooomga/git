var dataGrid;
var extraData ={};
$(function(){
	 dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/station/getExitList"
		,colNames : ['附近地标','最近出口','操作']
		,colModel:[
           {width:'10%',align:'center',name:'mark',sortable:false,index:'mark'},
           {width:'10%',align:'center',name:'exitName',sortable:false,index:'exitName'},
           {width:'10%',align:'center',name:'seq',sortable:false,index:'seq',formatter:Operate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	dataGrid.setLabel('0','序号');
	function Operate(cellvalue, options, station){
		var html = "";
		html += '	<button  type="button"  class="grid-btn"   onclick="modifyExit(&quot;'+station.seq+'&quot;)"  >编辑</button>&nbsp;&nbsp;&nbsp;';
		return html.replace("undefined", "");
	}
	
	$(document).on("click",".js-search",function(){
		dataGrid.search(extraData);
	});
	search = function (){
		dataGrid.search(extraData);
	}
});

function getExitList(){
	dataGrid.search(extraData);
}

var addExitWin;
var addMarkWin; 

function addExit(){
	//iframe窗
	addExitWin = layer.open({
	      type: 2,
	      title: '添加出口',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/station/toAddExit"
	    });
}
function addMark(){
	//iframe窗
	addMarkWin = layer.open({
	      type: 2,
	      title: '添加地标',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/station/toAddMark"
	    });
}
function modifyExit(seq){
	//iframe窗
	addMarkWin = layer.open({
	      type: 2,
	      title: '编辑地标',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/station/toModifyExit?seq="+seq
	    });
}


function deleteExit(seq){
	//询问框
	layer.confirm('您确定要删除这个出口吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/station/deleteExit",
			data : {
				seq : seq
			},
			success : function(data) {
				  layer.msg('删除成功', {
					    time: 800//1s后自动关闭
					  });
				  getExitList();
			}
		});
	}, function(){
	});
}

