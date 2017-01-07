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
    <form id="addForm"  action="" method="post">
    	<div>
			选择发送对象:<select id="send_object" name="send_object">
					 	<option value="">全部用户</option>
					 </select>
		</div>
		<br/>
		<div>
			标题:<input type="text"  id="title" name="title" style="width: 200px;" value=""  />
			<br/><span>标题长度限制在1-60个字符内</span>
		</div>
		<br/>
	    <div>
		           内容：<textarea id="content"  name="content" style="width: 200px;height:50px;"></textarea>
		    <br/><span>内容限制在1-300字符内</span>
		</div>
		<br/>
		<div>
			是否指定时间发送：<input type="radio" id="time" name="time" vale="1" />否&nbsp;&nbsp;<input type="radio" id="time" name="time" vale="0" />是
		</div>
		<br/>
    	<div>
    		<input type="button"  value="返回" onclick="back()"  />&nbsp;&nbsp;
			<input type="button"  value="保存" onclick="save()"  />&nbsp;&nbsp;
			<input type="button"  value="发送" onclick="send()"  />
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

</html>