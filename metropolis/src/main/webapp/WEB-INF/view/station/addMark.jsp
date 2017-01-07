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
		<form  id="addMarkWin">
			<br>
			<div class="input-group"  >
				<span class="input-group-addon">地标名称</span>
				 <input type="text" id="stationCode" name="stationCode"	class="form-control" placeholder="必填项" value="${data.list[0].mark }">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">最近出口</span> 
				<select name="lineCode" id="lineCode"  style="width: 200px;height: 38px;">
						<option value="1" >1号口</option>
						<option value="2" >2号口</option>
						<option value="3" >3号口</option>
						<option value="4" >4号口</option>
						<option value="5" >5号口</option>
						<option value="6" >6号口</option>
						<option value="7" >7号口</option>
				</select>
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">显示优先级</span> 
				<input type="text"	id="lineCode" name="lineCode"	class="form-control" >
				<span>（请在0-99之间选择，数字越大优先级越高，若重复，按照拼音先后顺序）
				</span>
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<button type="button" onclick="save()"   class="btn btn-default">保存</button>
					<button type="reset" class="btn btn-default  btn-center">重置</button>
					<c:if test="${not empty data }"><button type="button" class="btn btn-default" onclick="delmark()" >删除</button></c:if>
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