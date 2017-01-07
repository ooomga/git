var topHtml = '<div class="top"><form action="" >'+
			'<div class="log leftTable"><img src="img/log.png"></div>'+
			'<div class="leftTable"><span>高亮线路</span><br/>'+
			'<select>'+
			'<option value="0">全网络路</option>'+
			'<option value="1">1号线</option>'+
			'<option value="2">2号线</option>'+
			'<option value="3">3号线</option>'+
			'</select></div>'+
			'<div class="leftTable"><span>单线图</span><br/>'+
			'<select>'+
			'<option value="0">全网络路</option>'+
			'<option value="1">1号线</option>'+
			'<option value="2">2号线</option>'+
			'<option value="3">3号线</option>'+
			'</select></div>'+
			'<div class="leftTable"><span>区域显示</span><br/>'+
			'<select>'+
			'<option value="0">全网络路</option>'+
			'<option value="1">1号线</option>'+
			'<option value="2">2号线</option>'+
			'<option value="3">3号线</option>'+
			'</select></div>'+
			'<div class="leftTable"><span>站名显示</span><br/>'+
			'<select>'+
			'<option value="0">全部</option>'+
			'<option value="1">宜山路</option>'+
			'<option value="2">镇平路</option>'+
			'<option value="3">徐家汇</option>'+
			'</select></div>'+
			'<div class="leftTable left-last">'+
			'<input type="checkbox" />'+
			'<span>仅显示红黄状态</span></div>'+
			'<div class="rightTable right-first">'+
			'<img src="img/green.png" ><span>正常</span><br>'+
			'<img src="img/yellow.png" ><span>拥堵</span><br>'+
			'<img src="img/red.png" ><span>停运</span><br>'+
			'</div>'+
			'<div class="rightTable">'+
			'<span>数据上次更新时间</span><br>'+
			'<span>17:29:30</span>'+
			'</div>'+
			'<div class="rightTable right-last">'+
			'<input type="reset"  value="重置" />'+
			'</div>'+
			'</form></div>';

			
 function createTopPane() {
	var topPanel = new ht.widget.Panel();
	topPanel.setConfig({
		titleHeight : '0',
		titleWidth : '0',
		titleBackground : '#1a7ebb',
		flowLayout : true,
		position : "relative",
		contentHeight : 80,
		content : topHtml
	});
	return topPanel;
}