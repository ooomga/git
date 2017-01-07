var dataGrid;
var extraData ={};
$(function(){
	 dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/station/listStation"
		,colNames : ['车站ID','车站名称','所经线路','出口信息','硬件设施','服务人员','操作']
		,colModel:[
		   {width:'10%',align:'center',name:'stationCode',sortable:false,index:'stationCode'},
           {width:'10%',align:'center',name:'stationName',sortable:false,index:'stationName'},
           {width:'10%',align:'center',name:'lineList',sortable:false,index:'lineList',formatter:line},
           {width:'10%',align:'center',name:'lineList',sortable:false,index:'lineList',formatter:view},
           {width:'10%',align:'center',name:'lineList',sortable:false,index:'lineList',formatter:view},
           {width:'10%',align:'center',name:'lineList',sortable:false,index:'lineList',formatter:view},
           {width:'10%',align:'center',name:'id',sortable:false,index:'id',formatter:Operate}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
        ,rownumbers:true
		,multiselect:false
	});
	dataGrid.setLabel('0','序号');
	function Operate(cellvalue, options, station){
		var html = "";
		html += '	<button  type="button"  class="grid-btn"  onclick="modifyStation(&quot;'+station.stationCode+'&quot;)"  >编辑</button>&nbsp;&nbsp;&nbsp;';
		html += '	<button  type="button"  class="grid-btn"  onclick="deleteStation(&quot;'+station.seq+'&quot;)"  >删除</button>';
		return html.replace("undefined", "");
	}
	function line(cellvalue, options, station){
		var html = "";
		if(station.extraLineCode == null){
			html += ' <input type="text" disabled id="lineCode" value="'+station.lineCode+'" />';
		}else{
			html += ' <input type="text" disabled id="lineCode" value="'+station.lineCode+','+station.extraLineCode+'" />';
		}
		return html.replace("undefined", "");
	}
	function view(cellvalue, options, station){
		var html = "";
		html += '<button  type="button"  class="grid-btn"  onclick="show(&quot;'+station.seq+'&quot;)"  >查看</button>';
		return html.replace("undefined", "");
	}
	$(document).on("click",".js-search",function(){
		dataGrid.search(extraData);
	});
	search = function (){
		dataGrid.search(extraData);
	}
});

function listStation(){
	dataGrid.search(extraData);
}

var addStationWin;

function addStation(){
	//iframe窗
	addStationWin = layer.open({
	      type: 2,
	      title: '添加站点',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/station/toAddStation"
	    });
}
function modifyStation(stationCode){
	//iframe窗
	addStationWin = layer.open({
	      type: 2,
	      title: '修改站点',
	      shadeClose: false,
	      shade: 0.2,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['800px', '90%'],
	      content: base+"/station/toModifyStation?stationCode="+stationCode
	    });
}


function deleteStation(seq){
	//询问框
	layer.confirm('您确定要删除这个站点吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
	 	$.ajax({
			type : 'POST',
			dataType : 'json',
			url : base + "/station/deleteStation",
			data : {
				seq : seq
			},
			success : function(data) {
				  layer.msg('删除成功', {
					    time: 800//1s后自动关闭
					  });
				  listStation();
			}
		});
	}, function(){
	});
}

