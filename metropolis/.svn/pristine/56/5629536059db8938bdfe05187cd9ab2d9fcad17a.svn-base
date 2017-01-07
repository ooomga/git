<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<body>
	<div>
		<form action="${base }/forbidden/saveForbidden" id="form" method="post">
			<table>
				<tbody>
					<tr>
						<td>词汇类型</td>
						<td>
							<select name="wordsType">
								<option value="">请选择词汇类型</option>
								<option value="政治性词汇">政治性词汇</option>
								<option value="侮辱性词汇">侮辱性词汇</option>
								<option value="其它">其它</option>
							</select>
						</td>
					</tr>
					<tr>
						<td valign="top">内容</td>
						<td>
							<textarea rows="15" cols="80" name="forbiddenWords"></textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td style="text-align: right;">
							<button>取消</button>
							<button type="submit">确认保存</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

	<!-- JQuery -->
	<script type="text/javascript" src="${base}/resources/plugIn/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${base}/resources/plugIn/jquery/jquery.validate.js"></script>
	<script type="text/javascript" src="${base }/resources/develop/js/forbidden/forbidden.manage.js"></script>
	<script type="text/javascript" src="${base }/resources/develop/js/forbidden/forbidden.validate.js"></script>
</body>
</html>