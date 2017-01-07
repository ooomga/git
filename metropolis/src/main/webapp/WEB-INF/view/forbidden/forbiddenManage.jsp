<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${base }/resources/develop/css/down/need/laydate.css"/>
<link rel="stylesheet" type="text/css" href="${base }/resources/develop/css/down/style.css"/>
<!-- JQuery -->
<script type="text/javascript"
	src="${base}/resources/plugIn/jquery/jquery-1.8.3.js"></script>
</head>
<body>
	<%-- <div>
		<a href="###">系统设置</a>
		<span>&gt;</span>
		<a href="###">敏感词管理</a>
	</div>
	<div style="height: 40px; background-color: rgba(204, 204, 204, 1); line-height: 40px; padding-left: 30px; font-weight: bold;">审核词库</div>
	<div>
		<div>
			<span>敏感词</span>
			<input type="text" name="forbiddenWords" />
			<button class="js-search">查询</button>
			<button class="js-reset">重置</button>
		</div>
	</div>
	<div style="height: 40px; background-color: rgba(204, 204, 204, 1); line-height: 40px; padding-left: 30px; font-weight: bold;">查询结果</div>
	<div>
		<div class="js-exist-no" style="display: none;">情况1：暂未收录在敏感词库中</div>
		<div class="js-exist" style="display: none;">情况2：已收录在敏感词库中</div>
	</div>
	<div>
		<button class="js-add-forbidden">新增敏感词</button>
		<span>（提示：敏感词用分号隔开） </span>
	</div>
	<div style="height: 40px; background-color: rgba(204, 204, 204, 1); line-height: 40px; padding-left: 30px; font-weight: bold;">敏感词库</div>
	<table>
		<thead>
			<tr>
				<td>敏感词分类</td>
				<td>自定义敏感词</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>政治性词汇</td>
				<td>
					<c:forEach items="${data.政治性词汇 }" var="entity">
					${entity.forbiddenWords };
				</c:forEach>
				</td>
			</tr>
			<tr>
				<td>侮辱性词汇</td>
				<td>
					<c:forEach items="${data.侮辱性词汇 }" var="entity">
					${entity.forbiddenWords };
				</c:forEach>
				</td>
			</tr>
			<tr>
				<td>其它</td>
				<td>
					<c:forEach items="${data.其它 }" var="entity">
					${entity.forbiddenWords };
				</c:forEach>
				</td>
			</tr>
		</tbody>
	</table> --%>
	<div class="vip_book">
		<div class="row">
				<div class="col-sm-12 mulu-list"  >
				<div class="right_menu">
					<span>系统设置
							&gt;敏感词管理</span>
							</div>
				</div>
			</div>
		<div>
		<br/>
			<p class="vip_book_sh">审核词库</p>
			<div>
				<div class="vip_book_mgc">
					敏感词：<input class="vip_book_input" type="text"  name="forbiddenWords" >
				</div>
			</div>


			<div class="vip_book_result">
				<p class="vip_book_result1">查询结果</p>
				<div class="vip_book_result2">
<!-- 					<p>情况1：暂未收录在敏感词库中</p>
					<p>情况2：已收录在敏感词库中</p> -->
					<p class="js-exist-no" style="display: none;">情况1：暂未收录在敏感词库中</p>
					<p class="js-exist" style="display: none;">情况2：已收录在敏感词库中</p>
				</div>
				<p class="vip_book_result3"></p>
				<div style="background: #0E6EB8;" class="vip_book_result3-1">新增敏感词</div>
				<div class="vip_book_result3-2">(提示：敏感词用分号隔开)</div>
				<p></p>
			</div>

			<br>

			<div class="vip_book_mgck">
				<p class="vip_book_mg">敏感词库</p>
				<table>
					<tbody>
						<tr style="background: #B3B3B3">
							<td>敏感词分类</td>
							<td>自定义敏感词</td>
						</tr>
						<tr>
							<td>政治性词汇</td>
							<td>
								<c:forEach items="${data.政治性词汇 }" var="entity">
									${entity.forbiddenWords };
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td>侮辱性词汇</td>
							<td>
								<c:forEach items="${data.侮辱性词汇 }" var="entity">
									${entity.forbiddenWords };
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td>其他</td>
							<td>
								<c:forEach items="${data.其它 }" var="entity">
									${entity.forbiddenWords };
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>


			<div class="vip_book_hidden">
				<form id="addForbiddenForm" action="${base }/forbidden/saveForbidden"  method="post" >
					<div class="vip_book_hidden1">
						<div class="vip_book_hidden1_1">新增词汇</div>
						<div class="vip_book_hidden1_2"
							style="width: 30px; height: 30px; background: url(images/xx.png); background-size: 30px 30px; float: right; margin-left: 0;"></div>
					</div>
					<p class="vip_book_hidden2">
						词汇类型 <select name="wordsType" id="wordsType"
							style="width: 200px; height: 26px; margin-left: 15px;">
							<option value="政治性词汇">政治性词汇</option>
							<option value="侮辱性词汇">侮辱性词汇</option>
							<option value="其它">其它</option>
						</select>
					</p>
					<p class="vip_book_hidden3"></p>
					<div class="vip_book_hidden3-1">内容</div>
					<div class="vip_book_hidden3-2">
						<textarea name="forbiddenWords" id="forbiddenWords" cols="30" rows="5"></textarea>
					</div>
					<p></p>
					<br>
					<p class="vip_book_hidden4"></p>
					<div class="vip_book_hidden4-1">取消</div>
					<div class="vip_book_hidden4-2"  onclick="saveForbiddenWord()" >确认保存</div>
					<p></p>
				</form>
			</div>

		</div>

	</div>
	<div style="width:70px;height:30px;background:#0E6EB8;float:left;cursor:pointer;text-align:center;line-height:30px;border-radius:3px;position:absolute;top:202px;left:380px;color:#fff;font-size:12px;" class="vip_find   js-search">查询</div>
	<div style="width:70px;height:30px;background:#0E6EB8;float:left;cursor:pointer;text-align:center;line-height:30px;border-radius:3px;position:absolute;top:202px;left:450px;margin-left:20px;color:#fff;font-size:12px;" class="vip_reset   js-reset">重置</div>

<script type="text/javascript" src="${base }/resources/develop/js/forbidden/forbidden.manage.js"></script>
<script>
	   $('.vip_book_result3-1').click(function(){
	    $('.vip_book_hidden').css('display','block');
	    $('.bg_hover').css('display','block');
	   })
	   
	    $('.vip_book_hidden1_2').click(function(){
	      $('.vip_book_hidden').css('display','none');
	      $('.bg_hover').css('display','none');
	   })

</script>
</body>
</html>