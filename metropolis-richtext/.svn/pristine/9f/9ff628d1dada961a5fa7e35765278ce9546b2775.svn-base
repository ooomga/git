<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试功能</title>
<link rel="stylesheet" href="${base }/resources/plugIn/jqueryUpload/css/uploadfile-4.0.10.css" />
<style type="text/css">
div {
	line-height: 25px;
}
</style>
</head>
<body>
	<span>提交的数据是</span>
	<span>${entity.id }</span>
	<span>${entity.name }</span>

	<%-- 引入基础js 包含jquery、路径、 --%>
	<jsp:include page="../base/base.jsp" />

	<script type="text/javascript" src="${base }/resources/plugIn/jqueryUpload/js/jquery.uploadfile-4.0.10.js"></script>
	<script type="text/javascript" src="${base }/resources/develop/js/file/upload.js"></script>
	<script type="text/javascript">
		var base = "${base}";
		$.ajax({
			type : "POST",
			url : base + "/DBDate",
			dataType : "json",
			success : function(data) {
				console.info(data);
				$(".js-dbdate").html(data);
			},
			error : function(data) {
				console.info(data)
			},
		});
	</script>
</body>
</html>