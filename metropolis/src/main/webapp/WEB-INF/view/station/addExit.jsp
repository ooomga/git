<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- 引入基础js 包含jquery、路径、 --%>
<jsp:include page="../base/base.jsp" />
<link rel="stylesheet" type="text/css"
	href="${base }/resources/plugIn/bootstrap/css/bootstrap.min.css" />
<!-- JQuery -->
<script type="text/javascript"
	src="${base}/resources/plugIn/jquery/jquery-1.8.3.js"></script>
<title>添站点</title>
<%-- 引入基础js 包含jquery、路径、 --%>
</head>
<body>
	<!-- 占位符 end -->
	<div>
		<form  id="addExitWin">
			<br>
			<div class="input-group"  >
				<span class="input-group-addon">请输入出口</span>
				 <input type="text" id="stationCode" name="stationCode"	class="form-control" placeholder="必填项">
			</div>
			<br>
			<div class="input-group"  >
				 <input type="button" id="stationCode" name="stationCode"	class="form-control" value="标记位置">
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<button type="button" onclick="save()"   class="btn btn-default">保存</button>
					<button type="reset" class="btn btn-default  btn-center">重置</button>
				</div>
			</div>
		</form>
	</div>


	<%-- layer --%>
	<script type="text/javascript"
		src="${base}/resources/plugIn/layer/layer.js"></script>

	<%-- 日期选择器 --%>
	<script type="text/javascript"
		src="${base}/resources/plugIn/My97DatePicker/WdatePicker.js"></script>

	<%-- jqgrid js --%>
	<script type="text/javascript"
		src="${base }/resources/plugIn/jqgrid/js/jquery-ui.js"></script>
	<script type="text/javascript"
		src="${base }/resources/plugIn/jqgrid/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript"
		src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.js"></script>
	<script type="text/javascript"
		src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.extend.js"></script>

	<script type="text/javascript"
		src="${base}/resources/develop/js/station/addExit.js"></script>
</body>
</html>