var dataGrid;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/station/getLost"
		,colNames : ['ID','物品名称','物品图片','拾取位置','关键信息','操作']
		,colModel:[
           {width:'10%',align:'center',name:'id',sortable:true,index:'id'},
           {width:'10%',align:'center',name:'name',sortable:false,index:'name'},
           {width:'10%',align:'center',name:'image',sortable:false,index:'image',formatter:image},
           {width:'10%',align:'center',name:'address',sortable:false,index:'address'},
           {width:'10%',align:'center',name:'keyInfo',sortable:false,index:'keyInfo'},
           {width:'10%',align:'center',name:'id',sortable:false,index:'id',formatter:Operate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	
	dataGrid.setLabel('0','序号');
	function Operate(cellvalue, options, lost){
		var html = "";
		html += '<button  type="button"  class="grid-btn"  onclick="delLost(&quot;'+lost.id+'&quot;)"  >删除</button>';
		return html.replace("undefined", "");
	}
	function image(cellvalue, options, lost){
		var html = "";
		html += '<button  type="button"  class="grid-btn"  onclick="view(&quot;'+lost.id+'&quot;)"  >查看</button>';
		return html.replace("undefined", "");
	}
	$(document).on("click",".js-search",function(){
		dataGrid.search(extraData);
	});
	search = function (){
		dataGrid.search(extraData);
	}
});
var addLostWin;

function getLost(){
	dataGrid.search(extraData);
}
function addLost(){
	addLostWin = layer.open({
	      type: 2,
	      title: '添加失物',
	      offset:'1%',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['950px', '98%'],
	      content: base+"/station/toAddLost"
	    });
}

function delLost(id){
	//询问框
	layer.confirm('您确定要删除这个物品吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
//	 	$.ajax({
//			type : 'POST',
//			dataType : 'json',
//			url : base + "/station/deleteStation",
//			data : {
//				seq : seq
//			},
//			success : function(data) {
				  layer.msg('删除成功', {
					    time: 800//1s后自动关闭
					  });
				  getLost();
//			}
//		});
	}, function(){
	});
}





