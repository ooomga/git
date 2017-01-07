<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>查看信息</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript">
	    var base = "${base}";
    </script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<div >
    <form id="Form"  action="" method="post">
    	<div>
			标题:<input type="text"  name="title"   value="${data.title}"  />
		</div>
		<br/>
		<div>
			发布人:<input type="text"  name="author"  value="${data.author}"  />
		</div>
		<br/>
		<div>
			banner图片:<input type="file"  id="imageFile"    />
			<input type="text" id="image"  name="image"   multiple="multiple"    value="${data.image }" /> 
		</div>
		<br/>
	    <div>
		    <script id="ueditor"  name="content" type="text/plain">${data.content}</script>
		</div>
		<br/>
    
    </form>
    </div>
</body>
<!-- JQuery -->
<script type="text/javascript" src="${base}/resources/plugIn/jquery/jquery-1.8.3.js"></script>
<%-- layer --%>
<script type="text/javascript" src="${base}/resources/plugIn/layer/layer.js"></script>
<%-- ueditor --%>
<link rel="stylesheet" type="text/css" href="${base }/resources/plugIn/ueditor-1.4.3.3/third-party/video-js/video-js.min.css"/>
<script type="text/javascript" src="${base }/resources/plugIn/ueditor-1.4.3.3/third-party/video-js/video.js"></script>
<script src="http://cdn.bootcss.com/html5media/1.1.8/html5media.min.js";></script>
<script type="text/javascript" src="${base }/resources/plugIn/ueditor-1.4.3.3/ueditor.config.js"></script>
<script type="text/javascript" src="${base }/resources/plugIn/ueditor-1.4.3.3/ueditor.all.js"></script>
<script type="text/javascript" src="${base }/resources/plugIn/ueditor-1.4.3.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${base }/resources/develop/js/message/messageList.js"></script>
<script type="text/javascript">
var ue = UE.getEditor('ueditor', {
	initialFrameHeight : 400,
	initialFrameWidth : 800
});
</script>
</html>