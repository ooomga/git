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
<title>添加系统用户</title>
<%-- 引入基础js 包含jquery、路径、 --%>
<style type="text/css">
.form-div{
maring-left:10px;
maring-right:10px;
}
</style>
</head>
<body >
	<!-- 占位符 end -->
	<div class="form-div" >
		<form  id="addSystemUserForm">
			<br>
			<div class="input-group"  >
				<span class="input-group-addon">姓名</span>
				 <input type="text"	name="name"	class="form-control"  value="${data.name}" placeholder="名称为必填">
				 <input type="hidden" id="systemuserId"  name="id"  value="${data.id}"  />
			</div>
			<br>
			<div class="input-group"  >
				<span class="input-group-addon">用户名</span>
				 <input type="text"	name="account"	 class="form-control"  value="${data.account}" placeholder="登录时以用户名登录，必填">
			</div>
			<br>
			<div class="input-group"  >
				<span class="input-group-addon">密码</span>
				 <input type="password"	name="password"	 class="form-control"  value="${data.password}" placeholder="请输入密码">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">所属组织</span>
				<select  name="orgId" class="form-control"  placeholder="组织为必填"  onchange="changeDepartment(this.value)">
					 <c:forEach items="${orgList}" var="org" >
					 	<option <c:if test="${data.orgId==org.id}">selected="selected"</c:if> value="${org.id}">${org.name}</option>
					 </c:forEach>
				</select>
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">所属部门</span>
				<select id="departmentId"  name="departmentId" class="form-control"  placeholder="部门为必填">
					 <c:forEach items="${depList}" var="dep" >
					 	<option <c:if test="${data.departmentId==dep.id}">selected="selected"</c:if> value="${dep.id}">${dep.name}</option>
					 </c:forEach>
				</select>
			</div>
			<br>
			<div class="input-group"  >
				<span class="input-group-addon">手机号</span>
				 <input type="text"	name="phone"	class="form-control"  value="${data.phone}" placeholder="请输入手机号">
			</div>
			<br>
			<div class="input-group"  >
				<span class="input-group-addon">邮箱</span>
				 <input type="text"	name="email"	class="form-control"  value="${data.email}" placeholder="请输入邮箱">
			</div>
			<br>
			<div class="input-group"  >
				<span class="input-group-addon">类型</span>
				 <select  name="type" class="form-control"  >
				 	<option value="1">普通用户</option>	
				 	<option value="2">管理员</option>	
				 </select> 
			</div>
			<br>
			<br/>
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
		src="${base}/resources/develop/js/systemuser/addSystemUser.js"></script>
</body>
</html>