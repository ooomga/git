var dataGrid;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/notice/getNoticeMaster"
		,colNames : ['信息发送节点','站内信','短信']
		,colModel:[
           {width:'10%',align:'center',name:'node',sortable:true,index:'node'},
           {width:'15%',align:'center',name:'type001',sortable:false,index:'type001',formatter:Operate1},
           {width:'15%',align:'center',name:'type002',sortable:false,index:'type002',formatter:Operate2}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	
	dataGrid.setLabel('0','序号');
	function Operate1(cellvalue, options, notice){
		var html = "";
		if(notice.disable == 0){
			html += '<input type="checkbox" checked="checked" id="disable" name="disable" onclick="check(&quot;'+notice.nodeType+'&quot;)" />启用&nbsp;&nbsp;';
		}else{
			html += '<input type="checkbox" id="disable" name="disable" onclick="check(&quot;'+notice.nodeType+'&quot;)" />启用&nbsp;&nbsp;';
		}
		html += '<button   type="button"   class="grid-btn" onclick="editNotice(&quot;'+notice.nodeType+'&quot;,&quot;'+1+'&quot;)"  >编辑</button>';
		return html.replace("undefined", "");
	}
	function Operate2(cellvalue, options, notice){
		var html = "";
		if(notice.disable == 0){
			html += '<input  type="checkbox" checked="checked" id="disable" name="disable" onclick="check(&quot;'+notice.nodeType+'&quot;)" >启用</a>&nbsp;&nbsp;';
		}else{
			html += '<input type="checkbox" id="disable" name="disable" onclick="check(&quot;'+notice.nodeType+'&quot;)" />启用&nbsp;&nbsp;';
		}
		html += '<button   type="button"   class="grid-btn" onclick="editNotice(&quot;'+notice.nodeType+'&quot;,&quot;'+2+'&quot;)"  >编辑</button>';
		return html.replace("undefined", "");
	}
	
	$(document).on("click",".js-search",function(){
		dataGrid.search(extraData);
	});
	search = function (){
		dataGrid.search(extraData);
	}
});
var addNoticeWin;
var editNoticeWin;

function getNoticeMaster(){
	dataGrid.search(extraData);
}
function addNotice(){
	addNoticeWin = layer.open({
	      type: 2,
	      title: '添加信息',
	      offset:'1%',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['950px', '98%'],
	      content: base+"/notice/toAddNotice"
	    });
}
function editNotice(nodeType,noticeType){
	if(noticeType == 1){
		editNoticeWin = layer.open({
		      type: 2,
		      title: '编辑信息',
		      shadeClose: false,
		      shade: 0.2,
		      offset:'1%',
		      maxmin: true, //开启最大化最小化按钮
		      area: ['950px', '95%'],
		      content: base+"/notice/toEditNotice?nodeType="+nodeType+"&noticeType=001"
		    });
	}else if(noticeType == 2){
		editNoticeWin = layer.open({
		      type: 2,
		      title: '编辑信息',
		      shadeClose: false,
		      shade: 0.2,
		      offset:'1%',
		      maxmin: true, //开启最大化最小化按钮
		      area: ['950px', '95%'],
		      content: base+"/notice/toEditNotice?nodeType="+nodeType+"&noticeType=002"
		    });
	}
}
function check(nodeType){
	var disable=0;
	if($("#disable").prop("checked")){
		disable=1;
	}
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url : base + "/notice/updateNotice?nodeType="+nodeType+"&disable="+disable,
		data : {
			nodeType : nodeType
		},
		success : function(data) {
			  layer.msg('启用成功', {
				    time: 800//1s后自动关闭
				  });
			  getNoticeMaster();
		}
	});	
}
//function sendNotice(nodeType,noticeType){
//	var url=null
//	//站内信001
//	if(noticeType == 001){
//		url=base + "/notice/sendNotice"
//	}else{
//		url=base + "/notice/sendMessage"
//	}
//	$.ajax({
//		type : 'POST',
//		dataType : 'json',
//		url : url,
//		data : {
//			nodeType : nodeType,
//			noticeType : noticeType
//		},
//		success : function(data) {
//			  layer.msg('发送成功', {
//				    time: 800//1s后自动关闭
//				  });
//			  getNoticeMaster();
//		}
//	});	
//}




