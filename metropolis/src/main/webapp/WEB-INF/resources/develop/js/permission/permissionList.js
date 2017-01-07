var dataGrid;
var addPermissionWin;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/permission/searchPermission"
		,colNames : ['名称','描述', '等级','模块', '操作']
		,colModel:[
           {width:'10%',align:'center',name:'name',sortable:true,index:'name'},
           {width:'10%',align:'center',name:'description',sortable:false,index:'description'},
           {width:'10%',align:'center',name:'level',sortable:true,index:'level'},
           {width:'20%',align:'center',name:'module',sortable:false,index:'module'},
           {width:'10%',align:'center',name:'id',sortable:false,index:'id',formatter:permissionOperate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	
	dataGrid.setLabel('0','序号');
	
	function permissionOperate(cellvalue, options, permission){
		var html = "";
		html += '	<button  type="button" class="grid-btn"  onclick="deletePermission(&quot;'+permission.id+'&quot;)"  >删除</button>&nbsp;&nbsp;';
		return html.replace("undefined", "");
	}
	
	
	$(document).on("click",".js-search",function(){
		dataGrid.search(extraData);
	});
	search = function (){
		dataGrid.search(extraData);
	}
});
var addPermissionWin;
var setPermissionWin;

function searchPermission(){
	dataGrid.search(extraData);
}
function addPermission(){
	//iframe窗
	addPermissionWin = layer.open({
	      type: 2,
	      title: '添加权限',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '50%'],
	      content: base+"/permission/toAddPermission"
	    });
}
function modifyPermission(id){
	//iframe窗
	addPermissionWin = layer.open({
	      type: 2,
	      title: '修改权限',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/permission/modifyPermission?id="+id
	    });
}

function setPermission(id){
	//iframe窗
	setPermissionWin = layer.open({
	      type: 2,
	      title: '配置权限',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['1000px', '90%'],
	      content: base+"/permission/setPermission?id="+id
	    });
}

function deletePermission(id){
	//询问框
	layer.confirm('您确定要删除此权限记录吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/permission/deletePermission",
			data : {
				id : id
			},
			success : function(data) {
				  layer.msg('删除成功', {
					    time: 800//1s后自动关闭
					  });
				  searchPermission();
			}
		});
	}, function(){
	});
}
