var DataGrid = function(opts) {
	var defaults = {
		datatype : "json", // 返回数据格式
		mtype : "POST", // 请求方式
		height : 'auto', // 高度自适应支持 数字，像素值或者百分比
		multiselect : true, // 是否可以多选
		multiboxonly : true,
		rowNum : 10, // 默认没页显示数
		rowList : [ 5, 10, 20, 30, 50 ], // 可选择记录条数
		viewrecords : true, // 是否显示总记录数
		altRows : false, // 是否实现表格分行不同样式显示
		pagerpos : 'center', // 分页显示位置
		recordpos : 'right', // 记录信息的位置
		pginput : true, // 是否显示跳转页面输入框
		pgtext : "第{0}页 / 共{1}页", // pginput 必须设置为true
		recordtext : "总条数：<span class='color-f00'>{2}</span>条", // 显示记录数信息
		caption : "", // 表格名称
		emptyrecords : "", // 无返回数据时提示
		autowidth : true, // 宽度是否自适应
		postData : null, // 请求参数
		pageid : "gridTable", // 表格名称
		pager : "gridPager", // 分页名称
	};

	opts = $.extend(defaults, opts);

	$(opts.pageid).jqGrid({
		/* 必须存在 */
		url : opts.url,
		colNames : opts.colNames,
		colModel : opts.colModel,
		pager : opts.pager,
		/* 可以选填 */
		datatype : opts.datatype,
		mtype : opts.mtype,
		height : opts.height,
		multiselect : opts.multiselect,
		multiboxonly : opts.multiboxonly,
		rowNum : opts.rowNum,
		rowList : opts.rowList,
		viewrecords : opts.viewrecords,
		altRows : opts.altRows,
		pagerpos : opts.pagerpos,
		recordpos : opts.recordpos,
		pgtext : opts.pgtext,
		recordtext : opts.recordtext,
		caption : opts.caption,
		emptyrecords : opts.emptyrecords,
		pginput : opts.pginput,
		autowidth : opts.autowidth,
		postData : opts.postData,
		loadComplete : fnLoadComplete
	});

	/**
	 * 加载完成后执行操作
	 */
	function fnLoadComplete() {
		console.info("加载完成");
		dataIsNullPoint();
	}

	/**
	 * 返回数据没有时提示没有查询到记录
	 */
	function dataIsNullPoint() {
		var gridTable = $(opts.pageid);
		var rowNum = gridTable.jqGrid('getGridParam', 'records');
		if (!rowNum) {
			if ($("#norecords").html() == null) {
				gridTable.parent().append("<pre id='norecords' style='text-align: center;color: red;'><div>没有查询记录！</div></pre>");
			}
			$("#norecords").show();
		} else {
			/* 如果存在记录，则隐藏提示信息。 */
			$("#norecords").hide();
		}
	}

	/**
	 * 搜索 参数: 自定义JSON格式 返回: 无
	 */
	this.search = function(params) {
		var postData = $(opts.pageid).jqGrid("getGridParam", "postData");
		$.extend(postData, params);

		$(opts.pageid).jqGrid("setGridParam", {
			search : true
		}).trigger("reloadGrid", [ {
			page : 1
		} ]);
	}

	/**
	 * 获取所选的所有数据 参数: 无 返回: 返回ID数组
	 */
	this.getSelectedData = function() {
		var ids = $(opts.pageid).jqGrid('getGridParam', 'selarrrow');
		return ids;
	}

	/**
	 * 获取单行数据 参数: id 此行的ID 返回: 当前行的数据
	 */
	this.getLineData = function(id) {
		var celldata = $(opts.pageid).jqGrid('getRowData', id);
		return celldata;
	}

	/**
	 * 获取所有行的ID, 不区分选中还是未选中 参数: 无 返回: 返回所有ID的数组
	 */
	this.getAllLineData = function() {
		var ids = $(opts.pageid).jqGrid('getDataIDs');
		return ids;
	}

	/**
	 * 刷新 参数: 无 返回: 无
	 */
	this.refreshData = function() {
		$(opts.pageid).trigger("reloadGrid");
	}

	/**
	 * 设置哪一行选中
	 * 
	 * 参数: id需要选中行的ID 返回: 无
	 */
	this.setLineSelected = function(id) {
		$(opts.pageid).jqGrid('setSelection', id);
	}

}
