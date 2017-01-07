var dataGrid;
var addSystemUserWin;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/systemuser/searchSystemUser"
		,colNames : ['姓名','用户名', '手机号码','邮箱', '状态','类型','组织','部门','更新时间','操作']
		,colModel:[
		   {width:'10%',align:'center',name:'name',sortable:true,index:'name'},
           {width:'10%',align:'center',name:'account',sortable:true,index:'account'},
           {width:'10%',align:'center',name:'phone',sortable:true,index:'phone'},
           {width:'10%',align:'center',name:'email',sortable:true,index:'email'},
           {width:'10%',align:'center',name:'status',sortable:true,index:'status'},
           {width:'10%',align:'center',name:'type',sortable:true,index:'type'},
           {width:'10%',align:'center',name:'orgName',sortable:true,index:'orgName'},
           {width:'10%',align:'center',name:'departmentName',sortable:true,index:'departmentName'},
           {width:'20%',align:'center',name:'modifyTime',sortable:false,index:'modifyTime',formatter:fmDate},
           {width:'15%',align:'center',name:'id',sortable:false,index:'id',formatter:systemuserOperate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	
	dataGrid.setLabel('0','序号');
	
	function systemuserOperate(cellvalue, options, systemuser){
		var html = "";
		html += '	<button  type="button"  class="grid-btn" onclick="deleteSystemUser(&quot;'+systemuser.id+'&quot;)"  >删除</button>&nbsp;&nbsp;';
		html += '	<button  type="button"  class="grid-btn" onclick="modifySystemUser(&quot;'+systemuser.id+'&quot;)"  >修改</button>&nbsp;&nbsp;';
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
var addSystemUserWin;
var setSystemUserWin;

function searchSystemUser(){
	dataGrid.search(extraData);
}
function addSystemUser(){
	//iframe窗
	addSystemUserWin = layer.open({
	      type: 2,
	      title: '添加部门',
	      shadeClose: false,
	      shade: 0.2,
	      offset:'2.5',
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/systemuser/toAddSystemUser"
	    });
}
function modifySystemUser(id){
	//iframe窗
	addSystemUserWin = layer.open({
	      type: 2,
	      title: '修改部门',
	      shadeClose: false,
	      shade: 0.2,
	      offset:'2.5',
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/systemuser/toModifySystemUser?id="+id
	    });
}


function deleteSystemUser(id){
	//询问框
	layer.confirm('您确定要删除此部门记录吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/systemuser/deleteSystemUser",
			data : {
				id : id
			},
			success : function(data) {
				  layer.msg('删除成功', {
					    time: 800//1s后自动关闭
					  });
				  searchSystemUser();
			}
		});
	}, function(){
	});
}
