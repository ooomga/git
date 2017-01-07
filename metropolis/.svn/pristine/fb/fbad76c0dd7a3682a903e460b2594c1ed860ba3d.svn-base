<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>完整demo</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript">
	    var base = "${base}";
    </script>
    <script type="text/javascript" charset="utf-8" src="${base}/resources/plugIn/jquery/jquery-1.8.3.js"></script>
    <link rel="stylesheet" type="text/css" href="${base }/resources/plugIn/ueditor-1.4.3.3/third-party/video-js/video-js.min.css"/>
	<script type="text/javascript" src="${base }/resources/plugIn/ueditor-1.4.3.3/third-party/video-js/video.js"></script>
	<script src="http://cdn.bootcss.com/html5media/1.1.8/html5media.min.js";></script>
<%--     <script type="text/javascript" charset="utf-8" src="${base}/resources/plugIn/ueditor-1.4.3.3/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${base}/resources/plugIn/ueditor-1.4.3.3/_examples/editor_api.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${base}/resources/plugIn/ueditor-1.4.3.3/lang/zh-cn/zh-cn.js"></script> --%>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<div >
    <form id="ueditorForm"  action="" method="post">
    	<div>
			标题:<input type="text"  name="title"   value="${data.title}"  />
		</div>
		<br/>
		<div>
			发布人:<input type="text"  name="author"  value="${data.author}"  />
		</div>
		<br/>
		<div>
			类型:<input type="text"  name="author"  value="${data.author}"  />
		</div>
		<br/>
	    <div>
		   ${data.content}
		</div>
		<br/>
		<div>
			<input type="button"  value="保存" onclick="save()"  />
		</div>
    
    </form>
    </div>
</body>
<%-- ueditor --%>
<script type="text/javascript" src="${base }/resources/plugIn/ueditor-1.4.3.3/ueditor.config.js"></script>
<script type="text/javascript" src="${base }/resources/plugIn/ueditor-1.4.3.3/ueditor.all.js"></script>
<script type="text/javascript" src="${base }/resources/plugIn/ueditor-1.4.3.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${base }/resources/develop/js/ueditor/testUEditor.js"></script>
<script type="text/javascript">
/* var ue = UE.getEditor('ueditor'); */
/* var editor =new UE.ui.Editor();
editor.render("ueditor"); */
var ue = UE.getEditor('ueditor', {
	initialFrameHeight : 400,
	initialFrameWidth : 800
});
//1.2.4以后可以使用一下代码实例化编辑器
//UE.getEditor('myEditor')
</script>
</html>