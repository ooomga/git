<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理查看</title>
<link rel="stylesheet" type="text/css" href="${base}/resources/develop/css/down/laydate.css"/>
<link rel="stylesheet" type="text/css" href="${base}/resources/develop/css/down/style.css"/>
<link type="text/css" rel="stylesheet"	href="http://www.cunzaiganit.com/demo/js/need/laydate.css">
<link type="text/css" rel="stylesheet" 	href="http://www.cunzaiganit.com/demo/js/skins/default/laydate.css"
	id="LayDateSkin">
<style>
/* a{text-decoration: underline;}*/
.hidden_vip_look {
	width: 89%;
	float: left;
	position: relative;
	background: #fff;
	z-index: 99;
	position: absolute;
	left: 148px;
	top: 0px;
	display: none;
}

.hidden_vip_look_zw {
	width: 100%;
	height: 72px;
	background: #EFEFEF;
}

.hidden_vip_look_ml {
	background: #F6F8F7;
	line-height: 35px;
	font-size: 11px;
	color: #2E2C2B;
	padding-left: 10px;
}

.hidden_vip_look_jb {
	background: #0E6EB8;
	line-height: 35px;
	font-size: 12px;
	color: #fff;
	padding-left: 20px;
}

.hidden_vip_look table {
	font-size: 11px;
	margin-left: 20px;
}

.hidden_vip_look table tr {
	height: 30px;
}

.hidden_vip_look table tr td {
	width: 150px;
}

.hidden_vip_look_xx {
	background: #0E6EB8;
	line-height: 35px;
	font-size: 12px;
	color: #fff;
	padding-left: 20px;
}

.hidden_vip_look_button {
	cursor: pointer;
}

.hidden_vip_look_button div {
	background: #0E6EB8;
	width: 65px;
	height: 20px;
	color: #fff;
	line-height: 20px;
	text-align: center;
	border-radius: 2px;
}

.hidden_vip_look_button a {
	color: #fff;
}

.hidden_vip_look_button1 div {
	background: #0E6EB8;
	width: 65px;
	height: 20px;
	color: #fff;
	line-height: 20px;
	text-align: center;
	border-radius: 2px;
	font-size: 11px;
	float: left;
	margin-left: 500px;
	margin-top: 10px;
}

.hidden_vip_look_button1 a {
	color: #fff;
}

.hidden_vip_look_button2 div {
	background: #C9CACA;
	width: 65px;
	height: 20px;
	color: #fff;
	line-height: 20px;
	text-align: center;
	border-radius: 2px;
	font-size: 11px;
	float: left;
	margin-left: 20px;
	margin-top: 10px;
}

.hidden_vip_look_button2 a {
	color: #383735;
}

/*头像设置*/
.hidden_vip_look_head {
	position: absolute;
	top: 540px;
	right: 260px;
	width: 200px;
	height: 50px;
}

.hidden_vip_look_head img {
	width: 50px;
	height: 50px;
}

.hidden_vip_look_head p {
	margin-left: 100px;
	margin-top: -20px;
	margin-left: 61px;
	font-size: 10px;
	color: #1C1C1C;
	cursor: pointer;
}

.hidden_vip_look_head td {
	width: 100px;
}

/*重置密码*/
#hidden_vip_look_reset_hidden {
	position: absolute;
	top: 200px;
	left: 485px;
	width: 330px;
	height: 180px;
	z-index: 6;
	background: #fff;
	display: none;
}

.hidden_vip_look_reset_hidden-1 {
	border-bottom: 1px solid #DADADA;
	width: 330px;
	height: 30px;
	line-height: 30px;
}

.hidden_vip_look_reset_hidden-1-1 {
	display: block;
	float: left;
	margin-left: 140px;
	font-size: 10px;
}

.hidden_vip_look_reset_hidden-1-2 {
	display: block;
	float: left;
	margin-left: 125px;
	cursor: pointer;
}

.hidden_vip_look_reset_hidden_button {
	background: #0E6EB8;
	width: 65px;
	height: 20px;
	color: #fff;
	line-height: 20px;
	text-align: center;
	border-radius: 2px;
	font-size: 11px;
	float: left;
	margin-top: 10px;
	margin-left: 20px;
}

.hidden_vip_look_reset_hidden-2 {
	margin-top: 45px;
	margin-left: 88px;
	font-size: 11px;
}

.hidden_vip_look_reset_hidden-3 {
	margin-top: 30px;
	margin-left: 70px;
}

.hidden_vip_look_reset_hidden_button a {
	color: #fff;
}

/*解绑手机*/
#hidden_vip_look_Unbundling_phone_hidden {
	position: absolute;
	top: 200px;
	left: 485px;
	width: 330px;
	height: 180px;
	z-index: 6;
	background: #fff;
	display: none;
}

.hidden_vip_look_Unbundling_phone_hidden-1 {
	border-bottom: 1px solid #DADADA;
	width: 330px;
	height: 30px;
	line-height: 30px;
}

.hidden_vip_look_Unbundling_phone_hidden-1-1 {
	display: block;
	float: left;
	margin-left: 140px;
	font-size: 10px;
}

.hidden_vip_look_Unbundling_phone_hidden-1-2 {
	display: block;
	float: left;
	margin-left: 125px;
	cursor: pointer;
}

.hidden_vip_look_Unbundling_phone_hidden_button {
	background: #0E6EB8;
	width: 65px;
	height: 20px;
	color: #fff;
	line-height: 20px;
	text-align: center;
	border-radius: 2px;
	font-size: 11px;
	float: left;
	margin-top: 10px;
	margin-left: 20px;
}

.hidden_vip_look_Unbundling_phone_hidden-2 {
	margin-top: 45px;
	margin-left: 88px;
	font-size: 11px;
}

.hidden_vip_look_Unbundling_phone_hidden-3 {
	margin-top: 30px;
	margin-left: 70px;
}

.hidden_vip_look_Unbundling_phone_hidden_button a {
	color: #fff;
}

/*解绑微信*/
#hidden_vip_look_Unbundling-WeChat_hidden {
	position: absolute;
	top: 200px;
	left: 485px;
	width: 330px;
	height: 180px;
	z-index: 6;
	background: #fff;
	display: none;
}

.hidden_vip_look_Unbundling-WeChat_hidden-1 {
	border-bottom: 1px solid #DADADA;
	width: 330px;
	height: 30px;
	line-height: 30px;
}

.hidden_vip_look_Unbundling-WeChat_hidden-1-1 {
	display: block;
	float: left;
	margin-left: 140px;
	font-size: 10px;
}

.hidden_vip_look_Unbundling-WeChat_hidden-1-2 {
	display: block;
	float: left;
	margin-left: 125px;
	cursor: pointer;
}

.hidden_vip_look_Unbundling-WeChat_hidden_button {
	background: #0E6EB8;
	width: 65px;
	height: 20px;
	color: #fff;
	line-height: 20px;
	text-align: center;
	border-radius: 2px;
	font-size: 11px;
	float: left;
	margin-top: 10px;
	margin-left: 20px;
}

.hidden_vip_look_Unbundling-WeChat_hidden-2 {
	margin-top: 45px;
	margin-left: 88px;
	font-size: 11px;
}

.hidden_vip_look_Unbundling-WeChat_hidden-3 {
	margin-top: 30px;
	margin-left: 70px;
}

.hidden_vip_look_Unbundling-WeChat_hidden_button a {
	color: #fff;
}

/*查看明细开始*/
.hidden_vip_look_add {
	width: 500px;
	height: 210px;
	border: 2px solid #C8C9CB;
	position: absolute;
	top: 250px;
	left: 480px;
	background: #fff;
	display: none;
	z-index: 6;
}

.hidden_vip_look_add a {
	color: #251716;
	font-size: 10px;
	margin-left: 460px;
	line-height: 30px;
}

.hidden_vip_look_add table {
	border-collapse: collapse;
}

.hidden_vip_look_add table tr td {
	height: 30px;
	width: 200px;
	line-height: 30px;
	text-align: center;
}

.hidden_vip_look_add table tr:nth-child(2n) {
	background: #C9E6EE;
	font-size: 10px;
}

.hidden_vip_look_add table tr:nth-child(2n+1) {
	background: #fff;
	font-size: 10px;
}

.hidden_vip_look_add table tr:nth-child(1) {
	background: #036DB7;
	font-size: 10px;
	color: #fff;
}

/*头像审核*/
#hidden_vip_look_review_hidden {
	position: absolute;
	top: 200px;
	left: 485px;
	width: 440px;
	height: 320px;
	z-index: 6;
	background: #fff;
	display: none;
}

.hidden_vip_look_review_hidden_img {
	width: 130px;
	height: 130px;
	border: 1px solid #ccc;
}

.hidden_vip_look_review_hidden-1 {
	border-bottom: 1px solid #DADADA;
	width: 440px;
	height: 30px;
	line-height: 30px;
}

.hidden_vip_look_review_hidden-1-1 {
	display: block;
	float: left;
	margin-left: 200px;
	font-size: 10px;
}

.hidden_vip_look_review_hidden-1-2 {
	display: block;
	float: left;
	margin-left: 160px;
	cursor: pointer;
}

.hidden_vip_look_review_hidden_button {
	background: #0E6EB8;
	width: 65px;
	height: 20px;
	color: #fff;
	line-height: 20px;
	text-align: center;
	border-radius: 2px;
	font-size: 11px;
	float: left;
	margin-top: 10px;
	margin-left: 20px;
}

.hidden_vip_look_review_hidden-2 {
	margin-top: 45px;
	margin-left: 88px;
	font-size: 11px;
}

.hidden_vip_look_review_hidden-2-1 {
	margin-left: -60px;
}

.hidden_vip_look_review_hidden_img {
	margin-left: 70px;
}

.hidden_vip_look_review_hidden-2-2 {
	margin-left: 220px;
	cursor: pointer;
}

.hidden_vip_look_review_hidden-3 {
	margin-top: 30px;
	margin-left: 130px;
}

.hidden_vip_look_review_hidden_button {
	cursor: pointer;
}

.hidden_vip_look_review_hidden_button a {
	color: #fff;
}
</style>
</head>
<body>
	<div class="bg_hover"></div>
	<div class="vip_box">
		<div class="vip_con">
			<!-- 查看页面开始 -->
			<div class="vip_look">
				<!-- <div class="vip_look_zw"></div> -->
				<p class="vip_look_ml">会员管理&gt;会员详情</p>
				<!-- 基本信息开始 -->
				<div>
					<p class="vip_look_jb">基本信息</p>
					<table>
						<tbody>
							<tr>
								<td>会员ID</td>
								<td>lyf-582351</td>
								<td></td>
								<td></td>
								<td>手机号</td>
								<td id="my-1-1">18829251234</td>
								<td class="vip_look_button"><div>
										<p id="vip_look_reset">重置密码</p>
									</div></td>
								<td class="vip_look_button"><div>
										<p id="vip_look_Unbundling_phone">解绑</p>
									</div></td>
							</tr>
							<tr>
								<td>会员账号</td>
								<td>528752008</td>
								<td></td>
								<td></td>
								<td>微信号</td>
								<td id="my-2-2">12345</td>
								<td class="vip_look_button"><div>
										<p id="vip_look_Unbundling-WeChat">解绑</p>
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>会员等级</td>
								<td id="my-5-5">V2</td>
								<td class="vip_look_button"><div id="vip_look_fd">查看明细</div></td>
								<td></td>
								<td>微博</td>
								<td id="my-3-3">123456</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>注册时间</td>
								<td>2016-09-10&nbsp;&nbsp;18:54:58</td>
								<td></td>
								<td></td>
								<td>QQ</td>
								<td id="my-4-4">123456</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>会员状态</td>
								<td id="my-6-6">正常</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>会员类型</td>
								<td id="my-7-7">个人会员</td>
								<td class="vip_look_button"><div id="vip_look_mystop">停用</div></td>
								<td>历史记录</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 基本信息结束 -->

				<!-- 详细信息开始 -->
				<div>
					<p class="vip_look_xx">详细信息</p>
					<table>
						<tbody>
							<tr>
								<td>姓名</td>
								<td id="my-8-8">王桢</td>
								<td></td>
								<td></td>
								<td>昵称</td>
								<td id="my-9-9">1232</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>生日</td>
								<td id="my-10-10">1992/08/04</td>
								<td></td>
								<td></td>
								<td>性别</td>
								<td id="my-11-11">女</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>身份证号</td>
								<td id="my-12-12">234********423</td>
								<td></td>
								<td></td>
								<td>备注</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>订单</td>
								<td><a href="" style="text-decoration: underline;">查看</a></td>
								<td></td>
								<td></td>
								<td class="my_head">头像</td>

							</tr>
							<tr></tr>
							<tr>
								<td>积分</td>
								<td><a href="" style="text-decoration: underline;">123</a></td>
								<td></td>
								<td></td>
								<td>优惠券</td>
								<td><a href="" style="text-decoration: underline;">查看</a></td>
							</tr>
							<tr>
								<td>余额</td>
								<td><a href="" style="text-decoration: underline;">112</a></td>
								<td></td>
								<td></td>
								<td>收货地址</td>
								<td><a href="" style="text-decoration: underline;">查看</a></td>
							</tr>
						</tbody>
					</table>
					<div class="vip_look_head">
						<img src="" alt="">
						<p id="vip_look_chakan">
							<a style="text-decoration: underline;" href="">查看大图</a>
						</p>
					</div>
					<div class="vip_look_button1" style="cursor: pointer;">
						<div>编辑</div>
					</div>
					<div class="vip_look_button2" style="cursor: pointer;">
						<div>操作日志</div>
					</div>
				</div>
				<!-- 详细信息结束 -->
			</div>
		</div>
		<!-- 查看页面结束 -->

		<!-- 重置密码开始 -->
		<div id="vip_look_reset_hidden">
			<div class="vip_look_reset_hidden-1">
				<p class="vip_look_reset_hidden-1-1">重置密码</p>
				<p class="vip_look_reset_hidden-1-2"
					style="width: 30px; height: 30px; background: url(images/xx.png); background-size: 30px 30px; float: right; margin-left: 0;"></p>
			</div>
			<div class="vip_look_reset_hidden-2">随机密码，发送至会员234手机</div>
			<div class="vip_look_reset_hidden-3">
				<div class="vip_look_reset_hidden_button" style="cursor: pointer;">确认</div>
				<div class="vip_look_reset_hidden_button" style="cursor: pointer;">取消</div>
			</div>
		</div>
		<!-- 重置密码结束 -->

		<!-- 解绑手机开始 -->
		<div id="vip_look_Unbundling_phone_hidden">
			<div class="vip_look_Unbundling_phone_hidden-1">
				<p class="vip_look_Unbundling_phone_hidden-1-1">解绑手机</p>
				<p class="vip_look_Unbundling_phone_hidden-1-2"
					style="width: 30px; height: 30px; background: url(images/xx.png); background-size: 30px 30px; float: right; margin-left: 0;"></p>
			</div>
			<div class="vip_look_Unbundling_phone_hidden-2">
				是否确认解绑手机：1234567</div>
			<div class="vip_look_Unbundling_phone_hidden-3">
				<div class="vip_look_Unbundling_phone_hidden_button">
					<a href="">确认</a>
				</div>
				<div class="vip_look_Unbundling_phone_hidden_button">
					<a href="">取消</a>
				</div>
			</div>
		</div>
		<!-- 解绑手机结束 -->

		<!-- 解绑微信开始 -->
		<div id="vip_look_Unbundling-WeChat_hidden">
			<div class="vip_look_Unbundling-WeChat_hidden-1">
				<p class="vip_look_Unbundling-WeChat_hidden-1-1">解绑微信</p>
				<p class="vip_look_Unbundling-WeChat_hidden-1-2"
					style="width: 30px; height: 30px; background: url(images/xx.png); background-size: 30px 30px; float: right; margin-left: 0;"></p>
			</div>
			<div class="vip_look_Unbundling-WeChat_hidden-2">
				是否确认解绑微信：1234567</div>
			<div class="vip_look_Unbundling-WeChat_hidden-3">
				<div class="vip_look_Unbundling-WeChat_hidden_button">
					<a href="">确认</a>
				</div>
				<div class="vip_look_Unbundling-WeChat_hidden_button">
					<a href="">取消</a>
				</div>
			</div>
		</div>
		<!-- 解绑微信结束 -->

		<!-- 查看明细开始 -->
		<div class="vip_look_add">
			<a href=""><div
					style="width: 30px; height: 30px; background: url(images/xx.png); background-size: 30px 30px; float: right; margin-left: 0; cursor: pointer;"></div></a>
			<div
				style="font-size: 20px; text-decoration: none; margin-left: 472px; margin-top: 30px;">

			</div>
			<div>
				<div class="triangle-right1"></div>
				<div class="triangle-right2"></div>
				<table>
					<tbody>
						<tr>
							<td>时间</td>
							<td>交易金额</td>
							<td>订单数</td>
							<td>等级</td>
							<td>备注</td>
						</tr>
						<tr>
							<td>2016-09-08</td>
							<td>1523.23</td>
							<td>2</td>
							<td>V1</td>
							<td>备注</td>
						</tr>
						<tr>
							<td>2016-09-08</td>
							<td>1523.23</td>
							<td>2</td>
							<td>V1</td>
							<td>备注</td>
						</tr>
						<tr>
							<td>2016-09-08</td>
							<td>1523.23</td>
							<td>2</td>
							<td>V1</td>
							<td>备注</td>
						</tr>
						<tr>
							<td>合计</td>
							<td>9635.23</td>
							<td>64</td>
							<td></td>
							<td>备注</td>
						</tr>
					</tbody>
				</table>
			</div>
			<a href="">导出</a>
		</div>
		<!-- 查看明细结束 -->

		<!-- 账户停用开始 -->
		<div style="position: absolute; top: 20%; left: 30%;"
			class="vip_look_stop">
			<div class="vip_look_stop_head">
				<p>账号停用</p>
				<p id="vip_look_stop_x"
					style="width: 30px; height: 30px; background: url(images/xx.png); background-size: 30px 30px; float: right; margin-left: 0;"></p>
			</div>

			<div>
				<!-- <div class="triangle-right1"></div>
                <div class="triangle-right2"></div> -->
				<div class="vip_look_stop_time">
					<ul>
						<li><input name="my_radio" type="radio"> <input
							type="number">&nbsp;小时</li>
						<li><input name="my_radio" type="radio"> <input
							type="number">&nbsp;天</li>
						<li><input name="my_radio" type="radio"> &nbsp;永久</li>
					</ul>
				</div>
				<br>
				<div class="vip_look_stop_time_button">
					<div class="vip_look_stop_time_button1">
						<a style="text-decoration: none; color: #fff;" href="">确认</a>
					</div>
					<div class="vip_look_stop_time_button2">
						<a style="text-decoration: none; color: #fff;" href="">取消</a>
					</div>
				</div>
			</div>
		</div>
		<!-- 账户停用结束 -->

		<!-- 头像审核开始 -->
		<div id="vip_look_review_hidden">
			<div class="vip_look_review_hidden-1">
				<p class="vip_look_review_hidden-1-1">头像审核</p>
				<p class="vip_look_review_hidden-1-2"
					style="width: 30px; height: 30px; background: url(images/xx.png); background-size: 30px 30px; float: right; margin-left: 0;"></p>
			</div>
			<div class="vip_look_review_hidden-2">
				<div class="vip_look_review_hidden-2-1">用户1</div>
				<div class="vip_look_review_hidden_img">
					<img src="" alt="">
				</div>
				<p class="vip_look_review_hidden-2-2">系统审核通过</p>

			</div>
			<div class="vip_look_review_hidden-3">
				<div class="vip_look_review_hidden_button">审核不通过</div>
				<div class="vip_look_review_hidden_button">审核通过</div>
			</div>
		</div>
		<!-- 头像审核结束 -->
	</div>
	<!-- ////////////////////////////// -->
	<!-- 查看页面开始 -->
	<div class="hidden_vip_look">
		<div class="hidden_vip_look_zw"></div>
		<p class="hidden_vip_look_ml">一级目录&gt;二级目录&gt;三级目录</p>
		<!-- 基本信息开始 -->
		<div>
			<p class="hidden_vip_look_jb">基本信息</p>
			<table>
				<tbody>
					<tr>
						<td>会员ID</td>
						<td>1234444445</td>
						<td></td>
						<td></td>
						<td>手机号</td>
						<td><input id="my-1" type="text" value="123456"></td>
					</tr>
					<tr>
						<td>会员账号</td>
						<td>1234567</td>
						<td></td>
						<td></td>
						<td>微信号</td>
						<td><input id="my-2" type="text" value="asdfghj"></td>
						<td></td>
					</tr>
					<tr>
						<td>会员等级</td>
						<td><select id="my-5" name="">
								<option value="v1">v1</option>
								<option value="v2">v2</option>
								<option value="v3">v3</option>
								<option value="v4">v4</option>
								<option value="v5">v5</option>
						</select></td>
						<td></td>
						<td></td>
						<td>微博</td>
						<td><input id="my-3" type="text" value="asdfghj"></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>注册时间</td>
						<td>2016-09-10&nbsp;&nbsp;18:54:58</td>
						<td></td>
						<td></td>
						<td>QQ</td>
						<td><input id="my-4" type="text" value="123456"></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>黑名单</td>
						<td><select name="" id="my-6">
								<option value="否">否</option>
								<option value="是">是</option>
						</select></td>
						<td></td>
						<td></td>
						<td>邮箱号</td>
						<td><input type="text" value="1234567"></td>
						<td></td>
					</tr>
					<tr>
						<td>会员状态</td>
						<td><select name="" id="my-6">
								<option value="正常">正常</option>
								<option value="停用">停用</option>
						</select></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>会员类型</td>
						<td><select name="" id="my-7">
								<option value="个人会员">个人会员</option>
								<option value="企业会员">企业会员</option>
						</select></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>来源</td>
						<td>PC</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 基本信息结束 -->

		<!-- 详细信息开始 -->
		<div>
			<p class="vip_look_xx">详细信息</p>
			<table>
				<tbody>
					<tr>
						<td>姓名</td>
						<td><input id="my-8" type="text" value="王桢"></td>
						<td></td>
						<td></td>
						<td>昵称</td>
						<td><input id="my-9" type="text" value="1234"></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>生日</td>
						<td><input id="my-10" class="zc" type="text" name=""
							onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
							value="1993/09/08"></td>
						<td></td>
						<td></td>
						<td>性别</td>
						<td id="my-11"><input type="radio" name="my_radio" value="男">男
							<input style="margin-left: 20px;" type="radio" name="my_radio"
							value="女">女</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>身份证号</td>
						<td id="my-id"><input id="my-12" type="text" value="123456"></td>
						<td></td>
						<td></td>
						<td>备注</td>
						<td style="color: #ccc;">平台自填写</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>订单</td>
						<td><a style="text-decoration: underline;" href="">查看</a></td>
						<td></td>
						<td></td>
						<td class="my_head">头像</td>

					</tr>
					<tr></tr>
					<tr>
						<td>积分</td>
						<td><a style="text-decoration: underline;" href="">123</a></td>
						<td></td>
						<td></td>
						<td>优惠券</td>
						<td><a style="text-decoration: underline;" href="">查看</a></td>
					</tr>
					<tr>
						<td>余额</td>
						<td><a style="text-decoration: underline;" href="">112</a></td>
						<td></td>
						<td></td>
						<td>收货地址</td>
						<td><a style="text-decoration: underline;" href="">查看</a></td>
					</tr>
				</tbody>
			</table>
			<div class="hidden_vip_look_head">
				<img src="" alt="">
				<p id="hidden_vip_look_chakan">
					<a style="text-decoration: underline;" href="">查看大图</a>
				</p>
			</div>
			<div style="cursor: pointer; text-decoration: none;"
				class="hidden_vip_look_button1">
				<div>保存</div>
			</div>
			<div style="cursor: pointer; text-decoration: none;"
				class="hidden_vip_look_button2">
				<div>放弃</div>
			</div>
		</div>
		<!-- 详细信息结束 -->
	</div>
	<!-- 查看页面结束 -->
	<script>
		$('.vip_look_button1').click(function() {
			$('.hidden_vip_look').css('display', 'block');
		})

		$('.hidden_vip_look_button1').click(
				function() {
					$('.hidden_vip_look').css('display', 'none');
					var myval = $('#my-1').val();
					$('#my-1-1').html(myval);

					var myval2 = $('#my-2').val();
					$('#my-2-2').html(myval2);

					var myval3 = $('#my-3').val();
					$('#my-3-3').html(myval3);

					var myval4 = $('#my-4').val();
					$('#my-4-4').html(myval4);

					var myval5 = $('#my-5').val();
					$('#my-5-5').html(myval5);

					var myval6 = $('#my-6').val();
					$('#my-6-6').html(myval6);

					var myval7 = $('#my-7').val();
					$('#my-7-7').html(myval7);

					var myval8 = $('#my-8').val();
					$('#my-8-8').html(myval8);

					var myval9 = $('#my-9').val();
					$('#my-9-9').html(myval9);

					var myval10 = $('#my-10').val();
					$('#my-10-10').html(myval10);

					var myval12 = $('#my-12').val();
					$('#my-12-12').html(myval12);

					var strstr = $('#my-12-12').html();
					var str1 = strstr.replace(/(\d{3})(\d+)(\d{3})/, function(
							x, y, z, p) {
						var i = "";
						while (i.length < z.length) {
							i += "*"
						}
						return y + i + p
					})
					$('#my-12-12').html(str1);

				})
		$('#my-11 input').click(function() {
			var myval11 = $(this).val();
			$('#my-11-11').html(myval11);
			// alert($(this).val());
		})
		$('.hidden_vip_look_button2').click(function() {
			$('.hidden_vip_look').css('display', 'none');
		})
		// 弹框
		// 重置密码
		$('#vip_look_reset').click(function() {
			$('#vip_look_reset_hidden').css('display', 'block');
			$('.bg_hover').css('display', 'block');
		})
		// 重置密码   X
		$('.vip_look_reset_hidden-1-2').click(function() {
			$('#vip_look_reset_hidden').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})
		// 重置密码  确认   取消
		$('.vip_look_reset_hidden_button').click(function() {
			$('#vip_look_reset_hidden').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})

		// 解绑手机
		$('#vip_look_Unbundling_phone').click(function() {
			$('#vip_look_Unbundling_phone_hidden').css('display', 'block');
			$('.bg_hover').css('display', 'block');
		})
		// 解绑手机  X
		$('.vip_look_Unbundling_phone_hidden-1-2').click(function() {
			$('#vip_look_Unbundling_phone_hidden').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})
		// 解绑手机  确认   取消
		$('.vip_look_reset_hidden_button').click(function() {
			$('#vip_look_Unbundling_phone_hidden').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})

		// 解绑微信
		$('#vip_look_Unbundling-WeChat').click(function() {
			$('#vip_look_Unbundling-WeChat_hidden').css('display', 'block');
			$('.bg_hover').css('display', 'block');
		})
		// 解绑微信   X
		$('.vip_look_Unbundling-WeChat_hidden-1-2').click(function() {
			$('#vip_look_Unbundling-WeChat_hidden').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})
		// 解绑微信   确认   取消
		$('.vip_look_reset_hidden_button').click(function() {
			$('#vip_look_Unbundling-WeChat_hidden').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})

		var bj = false;
		// 查看明细
		$('#vip_look_fd').click(function() {
			$('.vip_look_add').css('display', 'block');
			$('.bg_hover').css('display', 'block');
		})

		// 账户停用
		$('#vip_look_mystop').click(function() {
			$('.vip_look_stop').css('display', 'block');
			$('.bg_hover').css('display', 'block');
		})
		// 账户停用  X
		$('#vip_look_stop_x').click(function() {
			$('.vip_look_stop').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})
		// 账户停用 确定
		$('.vip_look_stop_time_button1').click(function() {
			$('.vip_look_stop').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})
		// 账户停用 取消
		$('.vip_look_stop_time_button2').click(function() {
			$('.vip_look_stop').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})

		// 查看头像
		$('#vip_look_chakan').click(function() {
			$('#vip_look_review_hidden').css('display', 'block');
			$('.bg_hover').css('display', 'block');
			$('.bg_hover').css('display', 'block');
		})
		// 查看头像   X
		$('.vip_look_review_hidden-1-2').click(function() {
			$('#vip_look_review_hidden').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})
		// 查看头像   审核不通过   
		$('.vip_look_review_hidden_button').click(function() {
			$('#vip_look_review_hidden').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})
		// 查看头像   审核通过   
		$('.vip_look_review_hidden_button').click(function() {
			$('#vip_look_review_hidden').css('display', 'none');
			$('.bg_hover').css('display', 'none');
		})

		var strstr = $('#my-12-12').html();
		var str1 = strstr.replace(/(\d{3})(\d+)(\d{3})/, function(x, y, z, p) {
			var i = "";
			while (i.length < z.length) {
				i += "*"
			}
			return y + i + p
		})
		$('#my-12-12').html(str1);

		$('#my-id input').blur(function() {
			var str = $('#my-id input').val();
			var str2 = str.replace(/(\d{3})(\d+)(\d{3})/, function(x, y, z, p) {
				var i = "";
				while (i.length < z.length) {
					i += "*"
				}
				return y + i + p
			})
			$('#my-id input').val(str2);
		})
	</script>
<!-- JQuery -->
<script type="text/javascript" 	src="${base}/resources/plugIn/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${base}/resources/develop/js/down/js.js"></script>
<script type="text/javascript" src="${base}/resources/develop/js/down/laydate.js"></script>
</body>
</html>