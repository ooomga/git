var dataGrid;
var addMemberWin;
var extraData ={};
$(function(){
	dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/member/searchMember"
		,colNames : ['序列号','会员账号','姓名','手机号','状态','会员等级','渠道来源', '类型','注册时间', '操作']
		,colModel:[
		   {width:'10%',align:'center',name:'seq',sortable:false,index:'seq'},
		   {width:'10%',align:'center',name:'account',sortable:false,index:'account'},
		   {width:'10%',align:'center',name:'name',sortable:false,index:'name'},
           {width:'10%',align:'center',name:'mobile',sortable:true,index:'mobile'},
           {width:'10%',align:'center',name:'status',sortable:true,index:'status',formatter:fmStatus},
           {width:'10%',align:'center',name:'level',sortable:true,index:'level'},
           {width:'10%',align:'center',name:'source',sortable:true,index:'source'},
           {width:'10%',align:'center',name:'type',sortable:true,index:'type',formatter:fmType},
           {width:'15%',align:'center',name:'registTime',sortable:false,index:'registTime',formatter:fmDate},
           {width:'15%',align:'center',name:'id',sortable:false,index:'id',formatter:memberOperate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:true
	});
	dataGrid.setLabel('0','序号');

	
	function memberOperate(cellvalue, options, member){
		var html = "";
		if(member.status=='normal'){
			html += '<button  type="button"  class="grid-btn"   onclick="forbid(&quot;'+member.id+'&quot;)" >禁用</button> ';
		}else{
			html += '<button  type="button"   class="grid-btn" onclick="recorver(&quot;'+member.id+'&quot;)"  >启用</button> ';
		}
		html += '<button  type="button"   class="grid-btn"   onclick="viewMember(&quot;'+member.id+'&quot;)" >查看</button> ';
		return html.replace("undefined", "");
	}
	
	function fmDate(cellvalue, options, rowObject) {
		return $.date.UnixToDate(cellvalue,true);
	}
	function fmType(cellvalue, options, rowObject) {
		if(cellvalue=='1'){
			return "个人";
		}else if(cellvalue=='2'){
			return "乘客";
		}else{
			return "其他";
		}
	}
	function fmStatus(cellvalue, options, rowObject) {
		if(cellvalue=='normal'){
			return "启用";
		}else if(cellvalue=='disabled'){
			return "禁用";
		}else{
			return "其他";
		}
	}
	
//	$(document).on("click",".js-search",function(){
//		extraData.account=$('#account').val();
//		extraData.status=$('#status').val();
//		extraData.name=$('#name').val();
//		extraData.level=$('#level').val();
//		extraData.type=$('#type').val();
//		extraData.mobile=$('#mobile').val();
//		extraData.beginTime=$('#beginTime').val();
//		extraData.endTime=$('#endTime').val();
//		extraData.source=$('#source').val();
//		dataGrid.search(extraData);
//	});
	search = function (){
		dataGrid.search(extraData);
	}
});
var addMemberWin;
var setMemberWin;

function forbid(id){
	//询问框
	layer.confirm('您确定要禁用该会员吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
		 layer.msg('禁用成功', {
			    time: 1000//1s后自动关闭
			  });
	}, function(){
	});
}

function recorver(id){
	//询问框
	layer.confirm('目前停用情况： 剩余 18小时29分39秒。<br/>您确定要启用该会员吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
		 layer.msg('启用成功', {
			    time: 1000//1s后自动关闭
			  });
	}, function(){
	});
}

function searchMember(){
	extraData.account=$('#account').val();
	extraData.status=$('#status').val();
	extraData.name=$('#name').val();
	extraData.level=$('#level').val();
	extraData.type=$('#type').val();
	extraData.mobile=$('#mobile').val();
	extraData.beginTime=$('#beginTime').val();
	extraData.endTime=$('#endTime').val();
	extraData.source=$('#source').val();
	dataGrid.search(extraData);
}

function viewMember(id){
	window.location.href=base+"/member/viewMember?id="+id;
	//iframe窗
/*	addMemberWin = layer.open({
	      type: 2,
	      title: '查看会员详情',
	      shadeClose: false,
	      shade: 0.2,
	      offset:'1%',
	      maxmin: true, //开启最大化最小化按钮
	      area: ['1000', '98%'],
	      content: base+"/member/viewMember?id="+id
	    });*/
}
function addMember(){
	//iframe窗
	addMemberWin = layer.open({
	      type: 2,
	      title: '添加会员',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '50%'],
	      content: base+"/member/toAddMember"
	    });
}
function modifyMember(id){
	//iframe窗
	addMemberWin = layer.open({
	      type: 2,
	      title: '修改会员',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/member/toModifyMember?id="+id
	    });
}


function deleteMember(id){
	//询问框
	layer.confirm('您确定要删除此会员记录吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/member/deleteMember",
			data : {
				id : id
			},
			success : function(data) {
				  layer.msg('删除成功', {
					    time: 800//1s后自动关闭
					  });
				  searchMember();
			}
		});
	}, function(){
	});
}
