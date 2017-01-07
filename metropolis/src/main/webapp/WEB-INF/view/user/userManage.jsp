<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<body>
	<div>
		<a href="###">会员管理</a>
		<span>&gt;</span>
		<a href="###">会员信息管理</a>
	</div>
	<div>
		<table>
			<tbody>
				<tr>
					<td>
						<span>会员账号</span>
						<input type="text" name="" />
					</td>
					<td>
						<span>会员姓名</span>
						<input type="text" name="" />
					</td>
					<td>
						<span>手机号</span>
						<input type="text" name="" />
					</td>
				</tr>
				<tr>
					<td>
						<span>会员状态</span>
						<select name="">
							<option value="">全部</option>
							<option value="">正常</option>
							<option value="">停用</option>
						</select>
					</td>
					<td>
						<span>会员类型</span>
						<select name="">
							<option value="">全部</option>
							<option value="">个人会员</option>
							<option value="">公司会员</option>
						</select>
					</td>
					<td>
						<span>会员等级</span>
						<select name="">
							<option value="">V1</option>
							<option value="">V2</option>
							<option value="">V3</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<span>渠道来源</span>
						<select name="">
							<option value="">全部</option>
							<option value="">渠道一</option>
							<option value="">渠道二</option>
						</select>
					</td>
					<td>
						<span>注册时间</span>
						<input type="text" name="" style="width: 80px;" />
						至
						<input type="text" name="" style="width: 80px;" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div style="text-align: center;">
		<div>
			<button>查询</button>
			<button>重置</button>
			<button>导出</button>
			<button>添加会员</button>
			<button>批量导入会员</button>
		</div>
	</div>
	<div>
		<div>
			<button>批量启用</button>
			<button>批量停用</button>
		</div>
	</div>
	<%-- 表格 --%>
	<div>
		<%-- jqGrid 表格 --%>
		<table id="gridTable"></table>
		<%-- jqGrid 分页 --%>
		<div id="gridPager"></div>
	</div>

	<script type="text/javascript" src="${base }/resources/develop/js/user/user.manage.js"></script>
</body>
</html>