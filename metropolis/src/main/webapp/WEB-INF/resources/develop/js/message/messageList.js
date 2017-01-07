var dataGrid;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/message/getMessageList"
		,colNames : ['信息ID','信息标题','建立日期','状态','发布日期','操作']
		,colModel:[
           {width:'5%',align:'center',name:'seq',sortable:true,index:'seq'},
           {width:'15%',align:'center',name:'title',sortable:false,index:'title'},
           {width:'15%',align:'center',name:'createTime',sortable:false,index:'createTime',formatter:fmDate},
           {width:'10%',align:'center',name:'publish',sortable:false,index:'publish',formatter:publishState},
           {width:'15%',align:'center',name:'publishTime',sortable:false,index:'publishTime',formatter:fmDate},
           {width:'20%',align:'center',name:'id',sortable:false,index:'id',formatter:Operate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	
	dataGrid.setLabel('0','序号');
	function Operate(cellvalue, options, message){
		var html = "";
		if(message.publish == 0){
			html += '<button   type="button"   class="grid-btn" onclick="publicMessage(&quot;'+message.seq+'&quot;)"  >发布</button>&nbsp;&nbsp;';
		}
		html += '<button   type="button"   class="grid-btn" onclick="viewMessage(&quot;'+message.seq+'&quot;)"  >查看</button>&nbsp;&nbsp;';
		html += '<button   type="button"   class="grid-btn" onclick="deleteMessage(&quot;'+message.seq+'&quot;)"  >删除</button>';
		return html.replace("undefined", "");
	}
	
	function fmDate(cellvalue, options, rowObject) {
		var html = "";
		if(cellvalue == 0 || cellvalue == null){
			return html.replace("undefined", "");;
		}else{
			return $.date.UnixToDate(cellvalue,false);
		}
	}
	function publishState(cellvalue, options, message){
		var html = "";
		if(message.publish == 1){
			html += '<span>已发布</span>';
		}else{
			html += '<span>未发布</span>';
		}
		return html.replace("undefined", "");
	}
	
	$(document).on("click",".js-search",function(){
		dataGrid.search(extraData);
	});
	search = function (){
		dataGrid.search(extraData);
	}
});
var addMessageWin;

function getMessageList(){
	dataGrid.search(extraData);
}

function viewMessage(seq){
	//iframe窗
	addRichTextWin = layer.open({
	      type: 2,
	      title: '查看信息',
	      shadeClose: false,
	      shade: 0.2,
	      offset:'1%',
	      maxmin: true, //开启最大化最小化按钮
	      area: ['950px', '95%'],
	      content: base+"/message/toViewMessage?seq="+seq
	    });
}
function addMessage(){
	//iframe窗
	addMessageWin = layer.open({
	      type: 2,
	      title: '添加信息',
	      offset:'1%',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['950px', '98%'],
	      content: base+"/message/toAddMessage"
	    });
}
//发布
function publicMessage(seq){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/message/publicMessage",
			data : {
				seq : seq
			},
			success : function(data) {
				  layer.msg('发布成功', {
					    time: 800//1s后自动关闭
					  });
				  getMessageList();
			}
		});
}
 function deleteMessage(seq){
	//询问框
		layer.confirm('您确定要删除这条信息吗？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
		 	$.ajax({
				type : 'POST',
				dataType : 'json',
				url : base + "/message/deleteMessage",
				data : {
					seq : seq
				},
				success : function(data) {
					  layer.msg('删除成功', {
						    time: 800//1s后自动关闭
						  });
					  getMessageList();
				}
			});
		}, function(){
		});
 }



