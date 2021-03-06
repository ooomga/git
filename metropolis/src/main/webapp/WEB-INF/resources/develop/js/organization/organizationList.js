var dataGrid;
var addOrganizationWin;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/organization/searchOrganization"
		,colNames : ['编号','组织名称', '上级组织','修改时间', '操作']
		,colModel:[
		   {width:'10%',align:'center',name:'seq',sortable:true,index:'seq'},
           {width:'10%',align:'center',name:'name',sortable:true,index:'name'},
           {width:'10%',align:'center',name:'parentName',sortable:true,index:'parentName'},
           {width:'20%',align:'center',name:'modifyTime',sortable:false,index:'modifyTime',formatter:fmDate},
           {width:'10%',align:'center',name:'id',sortable:false,index:'id',formatter:organizationOperate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	
	dataGrid.setLabel('0','序号');
	
	function organizationOperate(cellvalue, options, organization){
		var html = "";
		html += '	<button   type="button"  class="grid-btn" onclick="deleteOrganization(&quot;'+organization.id+'&quot;)"  >删除</button>&nbsp;&nbsp;';
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
var addOrganizationWin;
var setOrganizationWin;

function searchOrganization(){
	dataGrid.search(extraData);
}
function addOrganization(){
	//iframe窗
	addOrganizationWin = layer.open({
	      type: 2,
	      title: '添加组织',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '50%'],
	      content: base+"/organization/toAddOrganization"
	    });
}
function modifyOrganization(id){
	//iframe窗
	addOrganizationWin = layer.open({
	      type: 2,
	      title: '修改组织',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/organization/modifyOrganization?id="+id
	    });
}


function deleteOrganization(id){
	//询问框
	layer.confirm('您确定要删除此组织记录吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/organization/deleteOrganization",
			data : {
				id : id
			},
			success : function(data) {
				  layer.msg('删除成功', {
					    time: 800//1s后自动关闭
					  });
				  searchOrganization();
			}
		});
	}, function(){
	});
}
