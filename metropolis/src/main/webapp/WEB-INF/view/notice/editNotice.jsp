<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>编辑信息</title>
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
    <form id="editForm"  action="" method="post">
    	<div>
			是否发送:<input type="checkbox"  name="disable"  id="disable" <c:if test="${data.list[0].disable==0 }">checked</c:if>  />
		</div>
		<br/>
		<div>
			消息发送节点:${data.list[0].node}
		</div>
		<br/>
		<div>
			消息变量：<input type="text" disabled value="用户名" style="width: 40px;"/>&nbsp;<input type="text" disabled value="商城名称" style="width: 55px;" />
		</div>
		<br/>
		<div>
			站内信主题:<input type="text"  id="title" name="title" style="width: 200px;" value="${data.list[0].title }"   />
		</div>
		<br/>
	    <div>
		    站内信内容：<textarea id="content"  name="content" style="width: 200px;height:50px;">${data.list[0].content}</textarea>
		    <span>内容限制在1-300字符内</span>
		</div>
		<br/>
    	<div>
    		<input type="hidden" id="id" name="id" value="${data.list[0].id }" />
			<input type="button"  value="保存" onclick="saveNotice('${data.list[0].id}')"  />&nbsp;&nbsp;
			<input type="button"  value="返回" onclick="back()"  />
		</div>
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
<script type="text/javascript" src="${base }/resources/develop/js/notice/addNotice.js"></script>
<script type="text/javascript">
var ue = UE.getEditor('ueditor', {
	initialFrameHeight : 400,
	initialFrameWidth : 800
});
</script>
</html>