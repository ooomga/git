<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${base }/resources/plugIn/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="row">
		<div class="right_menu">
			<span>车站信息管理 &gt;出口信息管理</span>
		</div>
	</div>
	<br/>
	<div style="height: 40px; background-color: rgba(204, 204, 204, 1); line-height: 40px; padding-left: 30px; font-weight: bold;">车站管理</div>
	<div style="height: 40px; line-height: 40px;">&nbsp;当前车站：莘庄站</div>
	<hr />
	<div class="btn-group">
		<button type="button" class="btn btn-default"  onclick="addMark()">新增地标</button>
	</div>
	<div class="btn-group">
		<button type="button" class="btn btn-default"  onclick="addExit()">新增出口</button>
	</div>
	<br/><br/>
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

	<script type="text/javascript" src="${base }/resources/develop/js/station/station.exit.js"></script>
</body>
</html>