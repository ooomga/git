<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<body>
	<div>
		<a href="javascript:void(0)">内容</a>
		<br>
	</div>
		<%-- 表格 --%>
		<div>
			<%-- jqGrid 表格 --%>
			<table id="gridTable"></table>
			<%-- jqGrid 分页 --%>
			<div id="gridPager"></div>
		</div>

	<script type="text/javascript">
	$(function(){
		var extraData;
		var dataGrid = new DataGrid({
			pageid:"#gridTable"
			,pager:"#gridPager"
			,postData:extraData
			,datatype:'json'
			,url: base + "/jqgridDataList"
			,colNames : ['A','B','C']
			,colModel:[
	           {width:'10%',align:'center',name:'a',sortable:false,index:'subject'},
	           {width:'10%',align:'center',name:'b',sortable:false,index:'id'},
	           {width:'10%',align:'center',name:'c',sortable:false,index:'id'}
	        ]
	        ,sortname:"date"
	        ,sortorder:"asc"
	        ,rownumbers:true
			,multiselect:false
		});
		dataGrid.setLabel('0','序号');
	});
	</script>
</body>
</html>