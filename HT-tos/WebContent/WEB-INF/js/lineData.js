var stationList9 = new ht.List(),
stationList1 = new ht.List(),
stationList4 = new ht.List();
stationList9.addAll([
                     {stationName:'九亭',x:100,y:100,pointIndex:0},
                     {stationName:'中春路',x:100,y:150,pointIndex:1},
                     {stationName:'七宝',x:150,y:200,pointIndex:2},
                     {stationName:'星中路',x:150,y:250,pointIndex:3},
                     {stationName:'合川路',x:200,y:290,pointIndex:4},
                     {stationName:'漕河泾',x:200,y:340,pointIndex:5},
                     {stationName:'桂林路',x:300,y:400,pointIndex:6},
                     {stationName:'宜山路',x:300,y:460,pointIndex:7},
                     {stationName:'徐家汇',x:500,y:580,pointIndex:8}
                     ]);
stationList4.addAll([
                     {stationName:'镇坪路',x:200,y:200},
                     {stationName:'曹杨路',x:190,y:110170},
                     {stationName:'金山江路',x:170,y:170},
                     {stationName:'中山公园',x:150,y:160},
                     {stationName:'中潭路',x:140,y:120},
                     {stationName:'宜山路',x:130,y:80}
                     ]);

var line4 = {
		lineName:'四号线',
		lineColor:'red',
		stationList:stationList4
	};
var line9 = {
		lineName:'九号线',
		lineColor:'lightblue',
		stationList:stationList4
	};
var lintList = [line4,line9];


