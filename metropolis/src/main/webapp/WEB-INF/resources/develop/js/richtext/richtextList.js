var dataGrid;
var addRichTextWin;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/richtext/searchRichText"
		,colNames : ['标题','发布者', '类型','是否发布','发布时间', '操作']
		,colModel:[
		   {width:'20%',align:'center',name:'title',sortable:false,index:'title'},
           {width:'10%',align:'center',name:'author',sortable:false,index:'author'},
           {width:'5%',align:'center',name:'typeName',sortable:false,index:'type'},
           {width:'10%',align:'center',name:'publish',sortable:false,index:'publish',formatter:fmPublish},
           {width:'10%',align:'center',name:'createTime',sortable:false,index:'createTime',formatter:fmDate},
           {width:'18%',align:'center',name:'id',sortable:false,index:'id',formatter:richtextOperate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	
	dataGrid.setLabel('0','序号');
	function fmPublish(cellvalue, options, richtext){
		if(cellvalue==0){
			return "未发布";
		}else{
			return "已发布";
		}
		var html = "";
		return html.replace("undefined", "");
	}
	function richtextOperate(cellvalue, options, richtext){
		var html = "";
		html += '<button  type="button"  class="grid-btn"   onclick="deleteRichText(&quot;'+richtext.id+'&quot;)"  >删除</button>&nbsp;';
		if(richtext.publish==0){
			html += '<button  type="button"   class="grid-btn"   onclick="publishRichText(&quot;'+richtext.id+'&quot;)"  >发布</button>&nbsp;';
		}
		html += '<button  type="button"   class="grid-btn"   onclick="modifyRichText(&quot;'+richtext.id+'&quot;)"  >修改</button>&nbsp;';
		html += '<button  type="button"   class="grid-btn"   onclick="viewRichText(&quot;'+richtext.id+'&quot;)"  >查看</button>';
		return html.replace("undefined", "");
	}
	
	function fmDate(cellvalue, options, rowObject) {
		return $.date.UnixToDate(cellvalue,true);
	}
	
	$(document).on("click",".js-search",function(){
		dataGrid.search(extraData);
	});
	search = function (){
		dataGrid.search(extraData);
	}
});
var addRichTextWin;
var setRichTextWin;

function searchRichText(){
	dataGrid.search(extraData);
}
function addRichText(){
	//iframe窗
	addRichTextWin = layer.open({
	      type: 2,
	      title: '添加资讯',
	      offset:'1%',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['950px', '98%'],
	      content: base+"/richtext/toAddRichText"
	    });
}
function modifyRichText(id){
	//iframe窗
	addRichTextWin = layer.open({
	      type: 2,
	      title: '修改资讯',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['950px', '95%'],
	      content: base+"/richtext/toModifyRichText?id="+id
	    });
}

function viewRichText(id){
	//iframe窗
	addRichTextWin = layer.open({
	      type: 2,
	      title: '查看资讯',
	      shadeClose: false,
	      shade: 0.2,
	      offset:'1%',
	      maxmin: true, //开启最大化最小化按钮
	      area: ['950px', '95%'],
	      content: base+"/richtext/viewRichText?id="+id
	    });
}

function deleteRichText(id){
	//询问框
	layer.confirm('您确定要删除此资讯记录吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/richtext/deleteRichText",
			data : {
				id : id
			},
			success : function(data) {
				  layer.msg('删除成功', {
					    time: 800//1s后自动关闭
					  });
				  searchRichText();
			}
		});
	}, function(){
	});
}

function publishRichText(id){
	//询问框
	layer.confirm('您确定要发布该条资讯吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/richtext/publishRichText",
			data : {
				id : id
			},
			success : function(data) {
				  layer.msg('发布成功', {
					    time: 800//1s后自动关闭
					  });
				  searchRichText();
			}
		});
	}, function(){
	});
}
