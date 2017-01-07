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
	<h1>helloWord ${jump }</h1>
	<div>
		<a href="${base }/temp/toForward.htm">转发</a>
	</div>
	<div>
		<a href="${base }/temp/toRedirect.htm">重定向</a>
	</div>
	<div>
		<span>获取数据库时间：</span>
		<span class="js-dbdate"></span>
	</div>
	<div>
		<h3>文件上传</h3>
		<div id="uploadfile"></div>
	</div>


	<span>验证脚本注入</span>
	<form action="${base }/temp/save.htm" method="post">
		<%-- <input type="text" name="map['id']" value="<textarea>alert(4444)</textarea>" /> --%>
		<input type="text" name="id" value="<textarea>alert(4444)</textarea>" />
		<input type="text" name="name" value="当时的撒发生萨芬撒非" />
		<input type="submit" value="提交" />
	</form>

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