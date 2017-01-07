var dataGrid;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/station/getHardware"
		,colNames : ['硬件名称','硬件位置','地铁位置','操作']
		,colModel:[
           {width:'10%',align:'center',name:'name',sortable:true,index:'name'},
           {width:'10%',align:'center',name:'address',sortable:true,index:'address'},
           {width:'10%',align:'center',name:'map',sortable:true,index:'map',formatter:Map},
           {width:'15%',align:'center',name:'id',sortable:false,index:'id',formatter:Operate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	
	dataGrid.setLabel('0','序号');
	function Operate(cellvalue, options, notice){
		var html = "";
		html += '<button  type="button"  class="grid-btn"  onclick="edit(&quot;'+notice.id+'&quot;)"  >编辑</button>';
		return html.replace("undefined", "");
	}
	function Map(cellvalue, options, notice){
		var html = "";
		html += '<button  type="button"  class="grid-btn"  onclick="show(&quot;'+notice.nodeType+'&quot;)"  >查看</button>';
		return html.replace("undefined", "");
	}
	
	$(document).on("click",".js-search",function(){
		dataGrid.search(extraData);
	});
	search = function (){
		dataGrid.search(extraData);
	}
});
var addHardWin;
var editHardWin;

function getHardware(){
	dataGrid.search(extraData);
}
function addHardware(){
	addHardWin = layer.open({
	      type: 2,
	      title: '新增硬件',
	      offset:'1%',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['950px', '98%'],
	      content: base+"/station/toAddHardware"
	    });
}

function edit(id){
	//iframe窗
	editHardWin = layer.open({
	      type: 2,
	      title: '编辑硬件设施',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['950px', '95%'],
	      content: base+"/station/toModifyHardware?id="+id
	    });
}




