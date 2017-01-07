/**
 * edgeType: 1-直线连接  2-直角折线  3-倾斜折线 4-？
 * nodeType: 1-小圆点   2-横向圆角矩形  3-纵向圆角矩形 4-叶节点
 */
/*           {
            	 name:{name_ch:'',name_en:''},
            	 img:{labelColor:'',right:{ro:0,vis:true},left:{ro:PI,vis:true}},label:{direction:'',position:{x:0,y:0}},
        		 nodeType:1,  //区分点图标类型：1-11线路
        		 box:{
        			 position:{x:0,y:0},
        			 size:{width:0,height:0}
        		 },
        		 position:{x:0,y:0},
            	edge:{
            		type:'',//线段类型
            		note:{},
            		corner:{x:0,y:0}
            	}
             }*/
var PI = Math.PI;
var nodeRadius = 10;

var line1, line2;
line1 = [
             {name:{name_ch:'竹\n子\n林',name_en:'zhuzilin'},position:{x:600,y:700},img:{labelColor:'#34ab54',right:{ro:0,vis:false},left:{ro:PI * 0.484,vis:true}},label:{direction:'1',position:{x:0,y:0}},type:1 , edge:{type:0,layer:'edge2'},flow:true,lineId:1},
             {name:{name_ch:'车\n公\n庙',name_en:'chegongmiao',hide:true},position:{x:840,y:700},img:{labelColor:'#34ab54',right:{ro:PI,vis:true},left:{ro:2*PI,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:2,edge:{type:0,layer:'edge2'},flow:true,lineId:1},
             {name:{name_ch:'香\n蜜\n湖',name_en:'xiangmihu'},position:{x:900,y:700},img:{labelColor:'#34ab54',right:{ro:0,vis:true},left:{ro:PI,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:0,layer:'edge2'},flow:true,lineId:1},
             ]
line7 = [
			{name:{name_ch:'安托山',name_en:'antuoshan'},position:{x:300,y:500},img:{labelColor:'#1a3c8c',right:{ro:0,vis:true},left:{ro:PI,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:8,layer:'edge3',corner:[{x:300,y:530},{x:450,y:680}]},flow:true,lineId:7},
			{name:{name_ch:'农林',name_en:'nonglin'},position:{x:700,y:680},img:{labelColor:'#1a3c8c',right:{ro:PI,vis:true},left:{ro:2*PI,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:2,edge:{type:3,layer:'edge3',corner:{x:800,y:680}},flow:true,lineId:7},
			{name:{name_ch:'车公庙',name_en:'chegongmiao',hide:true},position:{x:820,y:700},img:{labelColor:'#1a3c8c',right:{ro:-0.75*PI,vis:true},left:{ro:0.25*PI,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:9,layer:'edge3',corner:[{x:835,y:715},{x:835,y:885}]},flow:false,lineId:7},
			{name:{name_ch:'上沙',name_en:'shangsha'},position:{x:850,y:900},img:{labelColor:'#1a3c8c',right:{ro:-PI*0.87,vis:true},left:{ro:0,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:0,layer:'edge3'},flow:true,lineId:7},
			{name:{name_ch:'沙尾',name_en:'shawei'},position:{x:920,y:900},img:{labelColor:'#1a3c8c',right:{ro:0,vis:true},left:{ro:PI,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:0,layer:'edge3'},flow:true,lineId:7},
             ]
line9 = [
			{name:{name_ch:'景田',name_en:'jintian'},position:{x:800,y:500},img:{labelColor:'#86666e',right:{ro:PI*0.5,vis:true},left:{ro:PI*2.5,vis:false}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:0,layer:'edge2'},flow:true,lineId:9},
			{name:{name_ch:'香梅',name_en:'xiangmei'},position:{x:800,y:600},img:{labelColor:'#86666e',right:{ro:-PI*0.5,vis:true},left:{ro:PI*0.5,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:0,layer:'edge2'},flow:true,lineId:9},
			{name:{name_ch:'车公庙',name_en:'chegongmiao'},position:{x:800,y:700},img:{labelColor:'#86666e',right:{ro:-PI*0.5,vis:true},left:{ro:PI*0.5,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:2,edge:{type:1,layer:'edge2',corner:{x:800,y:1000}},flow:true,lineId:9,box:{position:{x:nodeRadius,y:0},size:{width:8*nodeRadius-4,height:nodeRadius*2-4}}},
			{name:{name_ch:'下沙',name_en:'xiasha'},position:{x:700,y:1000},img:{labelColor:'#86666e',right:{ro:-PI*0.75,vis:true},left:{ro:PI*1.5,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:0,layer:'edge2'},flow:true,lineId:9},
         ]
line11 = [
			{name:{name_ch:'红树湾南',name_en:'hongshuwannan'},position:{x:100,y:950},img:{labelColor:'#661e3a',right:{ro:0,vis:true},left:{ro:PI,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:10,layer:'edge2',corner:[{x:115,y:935},{x:765,y:935},{x:765,y:715}]},flow:true,lineId:11},
			{name:{name_ch:'车公庙',name_en:'chegongmiao',hide:true},position:{x:780,y:700},img:{labelColor:'#661e3a',right:{ro:0.75*PI,vis:true},left:{ro:1.75*PI,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:2,edge:{type:11,layer:'edge2',corner:[{x:800,y:680},{x:880,y:680}]},flow:true,lineId:11},
			{name:{name_ch:'福田',name_en:'futian'},position:{x:1060,y:500},img:{labelColor:'#661e3a',right:{ro:0,vis:true},left:{ro:PI,vis:true}},label:{direction:'1',position:{x:0,y:0}},nodeType:1 , edge:{type:0,layer:'edge2'},flow:true,lineId:11},
         ]
var map = [line1,line7,line9,line11 ];




















