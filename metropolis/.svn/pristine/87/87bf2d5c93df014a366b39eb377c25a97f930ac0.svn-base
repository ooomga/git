<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" href="${base }/resources/develop/css/layout.css" />
<!-- jqgrid-css -->
<link rel="stylesheet" type="text/css" href="${base}/resources/plugIn/jqgrid/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="${base}/resources/plugIn/jqgrid/css/ui.jqgrid.css">

<style type="text/css">
a {
	text-decoration: none;
}
</style>

</head>
<body width="100%">
	<%-- 当前页面JS必须放前面 --%>
	<!-- JQuery -->
	<script type="text/javascript" src="${base}/resources/plugIn/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${base}/resources/plugIn/jquery/jquery.validate.js"></script>
	<%-- layer --%>
	<script type="text/javascript" src="${base}/resources/plugIn/layer/layer.js"></script>
	<%-- 日期选择器 --%>
	<script type="text/javascript" src="${base}/resources/plugIn/My97DatePicker/WdatePicker.js"></script>
	<%-- jqgrid js --%>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery-ui.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.extend.js"></script>
	<%-- 通用 --%>
	<script type="text/javascript" src="${base}/resources/develop/js/common/common.js"></script>
	<script type="text/javascript">
		window.error = function(e) {
			console.error(e);
		}
		window.info = function(e) {
			console.info(e);
		}
		window.log = function(e) {
			console.log(e);
		}
		window.warn = function(e) {
			console.warn(e);
		}
		window.base = "${base}";
		window.fullPath = "${fullPath}";
	</script>

	<div>
		<div class="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="body">
			<div class="menu">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="content">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			if($("#gridTable").text()!=''){
				$("#gridTable").setGridWidth($(window).width() - $(".menu").width() - 6);
				$(window).resize(function() {
					$("#gridTable").setGridWidth($(window).width() - $(".menu").width() - 6);
				});
			}
		});

		function isEmptyArray(e) {
			var t;
			for (t in e)
				return !1;
			return !0
		}
	</script>
</body>
</html>
