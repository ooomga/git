$(function(){
	var extraData;
	var dataGrid = new DataGrid({
		pageid:"#gridTable"
		,pager:"#gridPager"
		,postData:extraData
		,datatype:'json'
		,url: base + "/listStation"
		,colNames : ['会员ID','会员账号','会员姓名','手机号','会员状态','会员等级','渠道来源','会员类型','注册时间','操作']
		,colModel:[
           {width:'10%',align:'center',name:'a',sortable:false,index:'subject'},
           {width:'10%',align:'center',name:'b',sortable:false,index:'id'},
           {width:'10%',align:'center',name:'b',sortable:false,index:'id'},
           {width:'10%',align:'center',name:'b',sortable:false,index:'id'},
           {width:'10%',align:'center',name:'b',sortable:false,index:'id'},
           {width:'10%',align:'center',name:'b',sortable:false,index:'id'},
           {width:'10%',align:'center',name:'b',sortable:false,index:'id'},
           {width:'10%',align:'center',name:'b',sortable:false,index:'id'},
           {width:'10%',align:'center',name:'b',sortable:false,index:'id'},
           {width:'10%',align:'center',name:'c',sortable:false,index:'id'}
        ]
        ,sortname:"date"
        ,sortorder:"asc"
		,multiselect:true
	});
});