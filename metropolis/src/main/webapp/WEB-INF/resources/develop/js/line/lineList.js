var dataGrid;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/line/getLineList"
		,colNames : ['线路ID','线路名称','英文名称','操作']
		,colModel:[
           {width:'10%',align:'center',name:'lineCode',sortable:true,index:'lineCode'},
           {width:'10%',align:'center',name:'lineName',sortable:false,index:'lineName'},
           {width:'10%',align:'center',name:'lineEName',sortable:false,index:'lineEName'},
           {width:'20%',align:'center',name:'id',sortable:false,index:'id',formatter:Operate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	
	dataGrid.setLabel('0','序号');
	function Operate(cellvalue, options, station){
		var html = "";
		html += '	<a id="modifyBtn" href="javascript:void(0)" onclick="modifyLine(&quot;'+station.seq+'&quot;)"  >编辑</a>&nbsp;&nbsp;&nbsp;';
		html += '	<a id="deleteBtn" href="javascript:void(0)" onclick="deleteLine(&quot;'+station.seq+'&quot;)"  >删除</a>';
		return html.replace("undefined", "");
	}
	
	$(document).on("click",".js-search",function(){
		dataGrid.search(extraData);
	});
	search = function (){
		dataGrid.search(extraData);
	}
});
var addLineWin;

function getLineList(){
	dataGrid.search(extraData);
}
function addLine(){
	//iframe窗
	addLineWin = layer.open({
	      type: 2,
	      title: '添加线路',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '50%'],
	      content: base+"/line/toAddLine"
	    });
}
function modifyLine(seq){
	//iframe窗
	addLineWin = layer.open({
	      type: 2,
	      title: '修改线路',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/line/toModifyLine?seq="+seq
	    });
}


function deleteLine(id){
	//询问框
	layer.confirm('您确定要删除这条线路吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/line/deleteLine",
			data : {
				id : id
			},
			success : function(data) {
				  layer.msg('删除成功', {
					    time: 800//1s后自动关闭
					  });
				  getLineList();
			}
		});
	}, function(){
	});
}
