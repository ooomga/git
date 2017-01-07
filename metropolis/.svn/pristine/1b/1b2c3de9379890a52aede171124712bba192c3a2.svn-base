function pie(id, data, param) {
	param.dateYear = new Date().getFullYear();
	if (param.date && param.date.length >= 4) {
		param.dateYear = param.date.substring(0, 4);
	}
	var legend = new Array();
	if (param.type == 1) {
		var colors = new Array();
		if (data.length == 0 || data[0].name == '无数据') {
			data.push({
				name : "无数据",
				value : "0"
			})
			colors.push('#CECBAD');
		}
		param.colors = colors;
		$.each(data, function(k, v) {
			if (!legend.hasOwnProperty(v.name)) {
				legend.push(v.name);
			}
		});
		param.legend = legend;
		pieCount(id, data, param);
	} else if (param.type == 2) { // 站点
		param.type = "pie";
		chart(id, data, param);
	}
}
/**
 * 饼图
 * 
 * @param id
 *            具体图表位置
 * @param data
 *            数据
 * @param param
 *            参数
 */
function pieCount(id, data, param) {
	option = {
		title : {
			subtext : opText(param.date),
		},
		toolbox : {
			show : true,
			feature : {
				myExport : {
					show : true,
					title : '导出报表',
					icon : 'image://' + base + '/resources/images/chart/xiazai.jpg',
					onclick : function() {
						window.location.href = encodeURI(encodeURI(base + "/payment/generateOrderCount?filePath=/upload/reports/" + param.dateYear + "年订单统计.xlsx"));
					}
				},
				saveAsImage : {
					show : true,
					title : '保存'
				},
			}
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			left : 'center',
			data : param.legend
		},
		series : [ {
			name : '访问来源',
			type : 'pie',
			radius : '70%',
			center : [ '50%', '60%' ],
			color : param.colors,
			data : data,
		} ],
	};
	// 使用刚指定的配置项和数据显示图表。
	var myChart = echarts.init(document.getElementById(id));
	myChart.setOption(option);
}

/**
 * 柱图
 * 
 * @param id
 *            具体图表位置
 * @param data
 *            数据
 * @param param
 *            参数
 */
function bar(id, data, param) {
	if (param.type == 1) {
		lin_bar_count(id, data, param, 'bar');
	} else if (param.type == 2) {
		param.type = "bar";
		chart(id, data, param);
	}
}
/**
 * 线图
 * 
 * @param id
 *            具体图表位置
 * @param data
 *            数据
 * @param param
 *            参数
 */
function line(id, data, param) {
	if (param.type == 1) {
		lin_bar_count(id, data, param, 'line');
	} else if (param.type == 2) {
		param.type = "line";
		chart(id, data, param);
	}
}

function lin_bar_count(id, data, param, type) {
	var legend = new Array();
	var colors = new Array();
	if (data.length == 0 || data[0].name == '无数据') {
		data.push({
			name : "无数据",
			value : "0"
		})
		colors.push('#CECBAD');
	}
	$.each(data, function(k, v) {
		legend.push(v.name);
	});

	var x = new Array();
	$.each(data[0], function(k, v) {
		if (k != 'name') {
			x.push(k);
		}
	});

	var series = new Array();
	var serie = {};
	$.each(data, function(k, v) {
		serie = {};
		serie.type = type;
		var data = new Array();
		$.each(v, function(k1, v1) {
			if (!isNaN(v1)) {
				data.push(v1);
			} else {
				serie.name = v1;
			}
		});
		serie.data = data;
		series.push(serie);
	});
	option = {
		title : {
			subtext : opText(param.date),
		},
		toolbox : {
			show : true,
			feature : {
				myExport : {
					show : true,
					title : '导出报表',
					icon : 'image://' + base + '/resources/images/chart/xiazai.jpg',
					onclick : function() {
						window.location.href = encodeURI(encodeURI(base + "/payment/generateOrderCount?filePath=/upload/reports/" + param.dateYear + "年订单统计.xlsx"));
					}
				},
				saveAsImage : {
					show : true,
					title : '保存'
				}
			}
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'shadow'
			}
		},
		legend : {
			data : legend
		},
		grid : {
			top : '20%',
			left : '3%',
			right : '8%',
			bottom : '3%',
			containLabel : true
		},
		yAxis : {
			type : 'value',
			name : '数量'
		},
		xAxis : {
			type : 'category',
			data : x,
			axisLabel : {
				interval : 0,
			},
		},
		series : series,
	};
	// 使用刚指定的配置项和数据显示图表。
	var myChart = echarts.init(document.getElementById(id));
	myChart.setOption(option);
}

function opText(date) {
	if (date == undefined || date.length == 0) {
		date = $.date.UnixToDate();
	}
	date = date.replace("-", "年").replace("-", "月");
	switch (date.length) {
	case 4:
		text = date + "年 订单统计";
		break;
	case 5:
	case 6:
		text = date.substring(0, 4) + "年第" + date.substring(4) + "周 订单统计";
		break;
	case 7:
		text = date + "月 订单统计";
		break;
	case 10:
		text = date + "日 订单统计";
		break;
	default:
		break;
	}
	return text;
}

function chart(id, data, param) {
//	console.info(data);
	option = {
		baseOption : {
			timeline : {
				axisType : 'category',
				autoPlay : true,
				playInterval : 10000,
				data : data.timeline.data
			},
			title : {
				subtext : '只显示有购票记录的站点'
			},
			tooltip : data.tooltip,
			grid : {
				top : 80,
				bottom : 100
			},
			legend : {
				data : data.legend,
				width : 450,
				left : 'center'
			},
			toolbox : {
				feature : {
					myExport : {
						show : true,
						title : '导出报表',
						icon : 'image://' + base + '/resources/images/chart/xiazai.jpg',
						onclick : function() {
							window.location.href = encodeURI(encodeURI(base + "/payment/generateOrderCount?filePath=/upload/reports/" + param.dateYear + "年订单统计.xlsx&date=" + param.dateYear));
						}
					},
					saveAsImage : {}
				}
			},
			xAxis : data.xAxis,
			yAxis : data.yAxis,
			series : [ {
				name : data.legend,
				type : param.type,
				radius : '28%'
			} ]
		},
		options : data.options
	};
	var myChart = echarts.init(document.getElementById(id));
	myChart.setOption(option);
}
