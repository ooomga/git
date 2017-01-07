<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${base }/resources/plugIn/bootstrap/css/bootstrap.min.css"/>
<title>公示信息管理</title>
<%-- 引入基础js 包含jquery、路径、 --%>
</head>
<body>
	<!-- 占位符 end -->
	<div	 >
		<form >
			<div class="row">
				<div class="col-sm-12 mulu-list"  >
				<div class="right_menu">
					<span>信息管理
							&gt;公式信息管理</span>
				</div>
				</div>
			</div>
				<br/>
				<div class="btn-group">
				    <button type="button" class="btn btn-default"  onclick="addMessage()">新增信息</button>
				</div>
				<div class="ibox float-e-margins">
						<br/>
						<%-- 表格 --%>
						<div >
							<%-- jqGrid 表格 --%>
							<table id="gridTable"></table>
							<%-- jqGrid 分页 --%>
							<div id="gridPager"></div>
						</div>
			</div>

		</div>
		</form>
	</div>
		

	<%-- layer --%>
	<script type="text/javascript" src="${base}/resources/plugIn/layer/layer.js"></script>

	<%-- 时间格式化 --%>
	<script type="text/javascript" src="${base}/resources/develop/js/util/date.js"></script>
	<%-- 日期选择器 --%>
	<script type="text/javascript" src="${base}/resources/plugIn/My97DatePicker/WdatePicker.js"></script>

	<%-- jqgrid js --%>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery-ui.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.extend.js"></script>

	<script type="text/javascript" src="${base}/resources/develop/js/message/messageList.js"></script>
</body>
</html>