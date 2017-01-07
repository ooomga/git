<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <link rel="stylesheet" type="text/css" href="${base }/resources/plugIn/bootstrap/css/bootstrap.min.css"/> --%>
<link rel="stylesheet" type="text/css" href="${base }/resources/develop/css/down/need/laydate.css"/>
<link rel="stylesheet" type="text/css" href="${base }/resources/develop/css/down/style.css"/>
<title>会员管理</title>
<%-- 引入基础js 包含jquery、路径、 --%>
<!-- JQuery -->
<script type="text/javascript"
	src="${base}/resources/plugIn/jquery/jquery-1.8.3.js"></script>
<style type="text/css">
tr{
margin-top:5px;
}
.btn{
    height: 100%;
    background: #0E6EB8;
    border: 0 solid #fff;
    border-radius: 5px;
    cursor: pointer;
    margin-left: 4%;
    font-size: 14px;
    color: #fff;
}
</style>
</head>
<body>
	<!-- 占位符 end -->
<!-- 		<form >
			<div class="row">
				<div class="col-sm-12 mulu-list"  >
					<a>会员管理 &nbsp;<</a>
					<a style="color:#C30D23">会员管理</a>
				</div>
				<br/><br/>
			</div>
				<div>
					<form>
					<table>
						<tbody>
							<tr>
								<td>
									<span>会员账号</span>
									<input type="text" id="account" />
								</td>
								<td>
									<span>会员姓名</span>
									<input type="text" id="name" id="name" />
								</td>
								<td>
									<span>手机号</span>
									<input type="text" id="mobile" id="mobile" />
								</td>
							</tr>
							<tr>
								<td>
									<span>会员状态</span>
									<select name="status" id="status">
										<option value="">全部</option>
										<option value="0">未审核</option>
										<option value="1">审核未通过</option>
										<option value="2">已审核</option>
										<option value="3">已禁用</option>
									</select>
								</td>
								<td>
									<span>会员类型</span>
									<select name="type" id="type">
										<option value="">全部</option>
										<option value="1">个人会员</option>
										<option value="2">公司会员</option>
									</select>
								</td>
								<td>
									<span>会员等级</span>
									<select name="level" id="level">
										<option value="">全部</option>
										<option value="V0">V0</option>
										<option value="V1">V1</option>
										<option value="V2">V2</option>
										<option value="V3">V3</option>
										<option value="V4">V4</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<span>渠道来源</span>
									<select name="source"  id="source" >
										<option value="">全部</option>
										<option value="1">渠道一</option>
										<option value="2">渠道二</option>
									</select>
								</td>
								<td>
									<span>注册时间</span>
									<input type="text" id="beginTime" style="width: 80px;" />
									至
									<input type="text" id="endTime" style="width: 80px;" />
								</td>
							</tr>
						</tbody>
					</table>
				<div class="btn-group">
					<button type="button" class="btn btn-default js-search"  >查询</button>
				    <button type="reset" class="btn btn-default"  >重置</button>
				    <button type="button" class="btn btn-default"  onclick=""  >添加</button>
				</div> 
					</form>-->
		<div class="vip_box">
        <div class="vip_con">
	            <div class="row">
					<div class="right_menu">
						<span>会员管理 &gt;会员查看</span>
					</div>
				</div>
            <div class="con_right vip_gl1" style="display:block">
                <form action="" class="wb" >
                    <span class="classSpam">会员帐号<input type="text" name=""  id="account" ></span>
                    <span>会员姓名<input type="text" name="" id="name"></span>
                    <span>&nbsp;手机号<input type="text" name="" id="mobile"></span>
                    <span>会员状态
                        <select name="" id="status">
                            <option value="">全部</option>
								<option value="normal">启用</option>
								<option value="disabled">禁用</option>
                        </select>
                    </span>
                    <span>会员类型
                        <select name="" id="type">
                            <option value="">全部</option>
							<option value="1">个人会员</option>
							<option value="2">公司会员</option>
                        </select>
                    </span>
                    <span>会员等级
                        <select name="" id="level">
                            <option value="">全部</option>
							<option value="V0">V0</option>
							<option value="V1">V1</option>
							<option value="V2">V2</option>
							<option value="V3">V3</option>
							<option value="V4">V4</option> 
                        </select>
                    </span>
                    <span>渠道来源
                        <select name="" id="source">
                            <option value="">全部</option>
							<option value="1">渠道一</option>
							<option value="2">渠道二</option>
                        </select>
                    </span>
                    <span>注册时间
                        <input class="zc" type="text" name=""  id="beginTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                        <a class="text">至</a>
                        <input class="zc zc1" type="text" name=""  id="endTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                    </span>
                    <div class="button">
                        <button type="button"  onclick="searchMember()">查询</button>
                        <button  type="button" >重置</button>
                        <button  type="button" >导出</button>
                        <a class="tjhy">添加会员</a>
                        <button  type="button"  class="pl">批量导入会员</button>
                    </div>
                </form>
                    <div class="top">
                        <div class="qx">
                            <button type="button"  onclick="recorver(true)">批量启用</button>
                            <button  type="button"  onclick="forbid(true)" class="style">批量停用</button>
                        </div>
                    </div>
                    <br/>
                    <div >
						<%-- jqGrid 表格 --%>
						<table id="gridTable"></table>
						<%-- jqGrid 分页 --%>
						<div  id="gridPager"></div>
					</div>
						
                    <!-- 账户停用开始 -->
                     <div class="vip_look_stop vip_stop">
                        <div class="vip_look_stop_head">
                            <p>账号停用</p>
                            <p class="vip_look_stop_x"><a>X</a></p>
                        </div>
                        
                        <div>
                            <div class="triangle-right1"></div>
                            <div class="triangle-right2"></div>
                            <div class="vip_look_stop_time">
                                <ul>
                                    <li>
                                        <input type="radio">
                                        <input type="number">&nbsp;小时
                                    </li>
                                    <li>
                                        <input type="radio">
                                        <input type="number">&nbsp;天
                                    </li>
                                    <li>
                                        <input type="radio">
                                        <input type="number">&nbsp;永久
                                    </li>
                                </ul>
                            </div>
                            <div class="vip_look_stop_time_button">
                                <div class="vip_look_stop_time_button1"><a>确认</a></div>
                                <div class="vip_look_stop_time_button2"><a>取消</a></div>
                            </div>
                        </div>
                     </div>
                    <!-- 账户停用结束 -->
                    <!-- 账号启用开始 -->
                    <div class="vip_look_stop vip_open">
                        <div class="vip_look_stop_head">
                            <p>账号启用</p>
                            <p class="vip_look_stop_x"><a>X</a></p>
                        </div>
                        
                        <div>
                            <div class="triangle-right1"></div>
                            <div class="triangle-right2"></div>
                              <div class="vip_look_stop_time">
                                <ul class="vip_ul">
                                    <li class="vip_li">
                                   目前停用情况：剩余
                                    </li>
                                    <li class="vip_li1">
                                    18小时29分39秒
                                    </li>
                                </ul>
                            </div>
                            <div class="vip_look_stop_time_button">
                                <div class="vip_look_stop_time_button1"><a>确认</a></div>
                                <div class="vip_look_stop_time_button2"><a>取消</a></div>
                            </div>
                        </div>
                     </div>
                    <!-- 账号启用结束 -->
                     <!-- 添加会员开始 -->
                     <div class="vip_look_stop vip_vip" id="vip_vip">
                        <div class="vip_look_stop_head">
                            <p>添加会员</p>
                            <p class="vip_look_stop_x"><a>X</a></p>
                        </div>
                        
                        <div>
                            <div class="triangle-right1"></div>
                            <div class="triangle-right2"></div>
                            <div class="vip_look_stop_time">
                             <a class="vip_vip_a"><b>*</b>用户名</a><input type="text">
                             <a class="vip_vip_a"><b>*</b>密码</a><input type="text">
                             <a class="vip_vip_a">姓名</a><input type="text">
                             <a class="vip_vip_a"><b>*</b>手机号</a><input type="text">
                            </div>
                            <div class="vip_look_stop_time_button">
                                <div class="vip_look_stop_time_button1"><a>确认</a></div>
                                <div class="vip_look_stop_time_button2"><a>取消</a></div>
                            </div>
                        </div>
                     </div>
                    <!-- 添加会员结束 -->
            </div>
        </div>

    </div>
		

	<%-- layer --%>
	<script type="text/javascript" src="${base}/resources/plugIn/layer/layer.js"></script>

	<%-- 时间格式化 --%>
	<script type="text/javascript" src="${base}/resources/develop/js/util/date.js"></script>
	<%-- 日期选择器 --%>
	<script type="text/javascript" src="${base}/resources/plugIn/My97DatePicker/WdatePicker.js"></script>

	<%-- jqgrid js --%>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery-ui.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.js"></script>
	<script type="text/javascript" src="${base }/resources/plugIn/jqgrid/js/jquery.jqGrid.extend.js"></script>
	<script type="text/javascript" src="${base}/resources/develop/js/down/js.js"></script>
	<script type="text/javascript" src="${base}/resources/develop/js/down/laydate.js"></script>
	
	<script type="text/javascript" src="${base}/resources/develop/js/member/memberList.js"></script>
</body>
</html>