<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${base }/resources/plugIn/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="right_menu">
		<span>车站管理
		&gt;
		车站信息管理</span>
	</div>
	<br/>
	<div style="height: 40px; background-color: rgba(204, 204, 204, 1); line-height: 40px; padding-left: 30px; font-weight: bold;">车站管理</div>
	<div style="height: 40px; line-height: 40px;">&nbsp;&nbsp;您管理的车站：莘庄站</div>
	<hr />
	
	<div>
		<div style="height: 40px; background-color: rgba(204, 204, 204, 1); line-height: 40px; padding-left: 30px; font-weight: bold;">车站信息</div>
	</div>
	<br/>
	<div class="btn-group"  style="margin-left:10px;">
		<button type="button" class="btn btn-default"  onclick="addStation()">新增站点</button>
	</div><br/><br/>
	<%-- 表格 --%>
	<div>
		<%-- jqGrid 表格 --%>
		<table id="gridTable"></table>
		<%-- jqGrid 分页 --%>
		<div id="gridPager"></div>
	</div>

	<%-- layer --%>
	<script type="text/javascript" src="${base}/resources/plugIn/layer/layer.js"></script>
	
	<%-- 日期选择器 --%>
	<script type="text/javascript" src="${base}/resources/plugIn/My97DatePicker/WdatePicker.js"></script>
	
	<%-- jqgrid js --%>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery-ui.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.extend.js"></script>
	
	<script type="text/javascript" src="${base }/resources/develop/js/station/station.manage.js"></script>
</body>
</html>