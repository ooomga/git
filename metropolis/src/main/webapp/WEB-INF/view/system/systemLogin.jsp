<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<body>
	<form action="${base }/system/systemLogin" method="post" id="form">
		<div style="text-align: center;">
			<table style="margin: auto;">
				<tbody>
					<tr>
						<td>用户名：</td>
						<td>
							<input type="text" name="acount" />
						</td>
					</tr>
					<tr>
						<td>密码：</td>
						<td>
							<input type="text" name="password" />
						</td>
					</tr>
				</tbody>
			</table>
			<div style="margin-top: 30px;">
				<button type="button" class="js-regit">注册</button>
				<button type="submit">登陆</button>
			</div>
		</div>
	</form>
	<!-- JQuery -->
	<script type="text/javascript" src="${base}/resources/plugIn/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${base}/resources/plugIn/jquery/jquery.validate.js"></script>
	<script type="text/javascript">
		var base = "${base}";
	</script>
	<script type="text/javascript" src="${base }/resources/develop/js/system/systemUser.validate.js"></script>
</body>
</html>