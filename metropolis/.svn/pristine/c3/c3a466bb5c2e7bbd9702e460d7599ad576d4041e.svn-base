<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <link rel="stylesheet" type="text/css" href="${base }/resources/develop/css/menu.css" /> --%>
<link rel="stylesheet" type="text/css" href="${base }/resources/develop/css/down/need/laydate.css"/>
<link rel="stylesheet" type="text/css" href="${base }/resources/develop/css/down/style.css"/>
<script>
/*设置cookie*/
function setCookie(name, value, iDay)
{
  var oDate=new Date();
  oDate.setDate(oDate.getDate()+iDay);
  document.cookie=name+'='+value+';expires='+oDate+';path=/metropolis';
};
/*使用方法：setCookie('user', 'simon', 11);*/
/*获取cookie*/
function getCookie(name)
{
  var arr=document.cookie.split('; '); //多个cookie值是以; 分隔的，用split把cookie分割开并赋值给数组
  for(var i=0;i<arr.length;i++) //历遍数组
  {
    var arr2=arr[i].split('='); //原来割好的数组是：user=simon，再用split('=')分割成：user simon 这样可以通过arr2[0] arr2[1]来分别获取user和simon 
    if(arr2[0]==name) //如果数组的属性名等于传进来的name
    {
      return arr2[1]; //就返回属性名对应的值
    }
  }
  return ''; //没找到就返回空
};
/*使用方法：getCookie('user')*/
/*删除cookie*/
function removeCookie(name)
{
  setCookie(name, 1, -1,'/metropolis'); //-1就是告诉系统已经过期，系统就会立刻去删除cookie
};
function setMenu(){
	document.cookie="";
	var currentLiId = getCookie("currentLiId");
	console.info(document.cookie);
	console.info("currentLiId:"+currentLiId);
	if(currentLiId==null){
		currentLiId = "hygl";
	}
	$('#'+currentLiId).css('background','#0E6EB8').css('color','#fff');
}

$(function(){
	$('.con_left').find('ol>li').click(function(){
		var currentLiId = this.parentElement.parentElement.id;
		console.info("currentLiId:"+currentLiId);
		//setCookie('currentLiId',currentLiId,60); 
		setCookie("currentLiId",currentLiId, { path: "/metropolis"});
		 console.info(getCookie('currentLiId'));
	});

});
</script>
<%-- 	<ul class="root-ul">
		<li>
			会员管理
			<ul class="son-ul">
				<li>
					<a href="${base }/member/toMember">会员管理</a>
				</li>
				<li>
					<a href="${base }/user/toUserManage?channel=user_manage">实名认证管理</a>
				</li>
				<li><a href="${base }/upload/uploadIcon">上传头像</a></li>
			</ul>
		</li>
		<li>
			线路管理
			<ul class="son-ul">
				<li><a href="${base }/line/toLine">线路管理</a></li>
			</ul>
		</li>
		<li>
			车站管理
			<ul class="son-ul">
				<li>
					<a href="${base }/station/toStationManage">车站信息管理</a>
				</li>
				<li>
					<a href="${base }/station/toExit">出口信息管理</a>
				</li>
				<li><a href="${base }/station/toHardware">硬件设施管理</a></li>
				<li><a href="${base }/station/toLost">失物招领管理</a></li>
			</ul>
		</li>
		<li>
			资讯管理
			<ul class="son-ul">
				<li><a href="${base }/richtext/toRichText" >资讯管理</a></li>
			</ul>
		</li>
		<li>
			票务管理
			<ul class="son-ul">
				<li>购票记录管理</li>
				<li>车票种类管理</li>
			</ul>
		</li>
		<li>
			时刻表管理
			<ul class="son-ul">
				<li>时刻表导入</li>
			</ul>
		</li>
		<li>
			事件上报管理
			<ul class="son-ul">
				<li>志愿者记录管理</li>
				<li>志愿者规则管理</li>
			</ul>
		</li>
		<li>
			商品管理
			<ul class="son-ul">
				<li>爱心雨伞记录</li>
			</ul>
		</li>
		<li>
			积分管理
			<ul class="son-ul">
				<li>商品管理</li>
				<li>积分流水管理</li>
				<li>积分规则管理</li>
			</ul>
		</li>
		<li>
			信息管理
			<ul class="son-ul">
				<li><a href="${base }/message/toMessage">公式信息管理</a></li>
				<li><a href="${base }/notice/toNoticeMaster">站内信内容管理</a></li>
				<li>触发规则管理</li>
			</ul>
		</li>
		<li>
			系统设置
			<ul class="son-ul">
				<li>
					<a href="${base }/forbidden/toForbiddenManage?channel=forbidden_manage">敏感词管理</a>
				</li>
			</ul>
		</li>
		<li>
			权限管理
			<ul class="son-ul">
				<li><a href="${base }/department/toDepartment" >部门信息管理</a></li>
				<li><a href="${base }/organization/toOrganization" >组织信息管理</a></li>
				<li><a href="${base }/permission/toPermission" >权限信息管理</a></li>
				<li><a href="${base }/systemuser/toSystemUser" >系统用户管理</a></li>
			</ul>
		</li>
	</ul> --%>
<body onload="setMenu()">
<div class="bg_hover"></div>
<div class="vip_box">
<div class="vip_con">
	<div class="con_left">
		<ul>
			<li id="hygl" >会员管理
				<ol>
					<li><a href="${base }/member/toMember">会员查看</a></li>
					<li class="smrzgl"><a href="javascript:void(0)">实名认证管理</a></li>
					<li><a href="${base }/upload/uploadIcon">上传头像</a></li>
				</ol>
			</li>
			<li id="czxxgl">车站信息管理
				<ol>
					<li class="czxx"><a href="${base }/station/toStationManage">车站信息管理</a></li>
					<li><a href="${base }/station/toExit">出口信息管理</a></li>
					<li><a href="${base }/station/toHardware">硬件设施管理</a></li>
					<li><a href="${base }/station/toLost">失物招领管理</a></li>
				</ol>
			</li>
			<li id="zxgl" >资讯管理
				<ol>
					<!-- <li><a href="article.html">文章管理</a></li>
					<li><a href="column_management.html">栏目管理</a></li> 
					<li><a href="sw_property_gl.html">失物招领管理</a></li>-->
					<li><a href="${base }/richtext/toRichText" >资讯管理</a></li>
				</ol></li>
			<li id="pwgl">票务管理
				<ol>
					<li>车票购买记录</li>
					<li>车票种类管理</li>
				</ol>
			</li>
			<li id="skbgl">时刻表管理
				<ol>
					<li>时刻表管理</li>
				</ol>
			</li>
			<li id="sjsbgl">事件上报管理
				<ol>
					<li>事件记录</li>
				</ol>
			</li>
			<li id="zyzgl">志愿者管理
				<ol>
					<li>发布志愿者信息</li>
					<li></li>
				</ol>
			</li>
			<li id="spgl">商品管理
				<ol>
					<li></li>
					<li></li>
				</ol>
			</li>
			<li id="jfsc">积分商城
				<ol>
					<li></li>
					<li></li>
				</ol>
			</li>
			<li id="xxgl">信息管理
				<ol>
					<li><a href="${base }/message/toMessage">公式信息管理</a></li>
					<li><a href="${base }/notice/toNoticeMaster">站内信内容管理</a></li>
				</ol>
			</li>
			<li id="xtsz">系统设置
				<ol>
					<li><a href="${base }/forbidden/toForbiddenManage?channel=forbidden_manage">敏感词管理</a></li>
					<!-- <li><a href="map_information.html">室内地图导入</a></li> -->
				</ol>
			</li>
			<li id="qxgl">权限管理
				<ol>
					<li><a href="${base }/department/toDepartment" >部门信息管理</a></li>
					<li><a href="${base }/organization/toOrganization" >组织信息管理</a></li>
					<li><a href="${base }/permission/toPermission" >权限信息管理</a></li>
					<li><a href="${base }/systemuser/toSystemUser" >系统用户管理</a></li>
				</ol>
			</li>
		</ul>
	</div>
	</div>
	</div>
	<div class="bg_hover"></div>
</body>