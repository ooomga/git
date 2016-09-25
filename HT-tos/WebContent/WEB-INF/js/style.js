var gap = 4;
var edgeWidth = 2;
var nodeStyle = {
	'shape.border.color' : '#00ebb3',
	'shape.background' : 'white',
	'shape.border.width' : 2,
	'select.width' : 0,
	'label.scale':0.5,
	'label.color':'white',
	'label.position':31,
	'label2.color':'white',
	'label2.rotation':Math.PI*1.5,
	'label2.position':31,
	'label2.scale':0.5,
}
var roundRectStyle = {
		'shape' : 'roundRect',
		'shape.border.color' : '#c8c8c8',
		'shape.background' : 'white',
		'shape.border.width' : 2,
		'select.width' : 0,
		'2d.selectable':false,
		'shape.corner.radius':8,
		'label.scale':1.4
	}

var edgeStyle_slope0 = {		//最简单的直线连接
		'edge.type' : 'edge1',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.gap':gap
    };
var edgeStyle_slope1 = {		//拐直角的直线连接
    	'edge.type': 'edgeHV',
        'edge.color': '#00ebb3',
        'edge.corner.radius':5,
        'edge.width' : edgeWidth,
        'edge.center' : true,
        'edge.gap': gap
    };
var edgeStyle_slope2 = {		//拐直角的直线连接
    	'edge.type': 'edgeHV',
        'edge.color': '#00ebb3',
        'edge.corner.radius':5,
        'edge.width' : edgeWidth,
        'edge.center' : true,
        'edge.gap': gap
    };
var edgeStyle_slope3 = {		//线段
		'edge.type' : 'slope1',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.gap':gap
    };

var edgeStyle_slope4 = {		//线段
		'edge.type' : 'slope2',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.gap':gap
    };
var edgeStyle_slope5 = {		//线段
		'edge.type' : 'slope3',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.gap':gap
    };
var edgeStyle_slope6 = {		//线段
		'edge.type' : 'slope4',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.gap':gap
    };
var edgeStyle_slope7 = {		//线段
		'edge.type' : 'test2',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.center' : true,
		'edge.gap':gap,
		'edge.corner.radius':0
    };
var edgeStyle_slope8 = {		// 7号线第一个不规则弯道，安托山-农林
		'edge.type' : 'slope7_1',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.center' : true,
		'edge.gap':gap,
		'edge.corner.radius':0
    };
var edgeStyle_slope9 = {		   //  7号线第二个不规则弯道，车公庙-上沙
		'edge.type' : 'slope7_2',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.center' : true,
		'edge.gap':gap,
		'edge.corner.radius':0
    };
var edgeStyle_slope10 = {		//  11号线第一个不规则弯道，红树湾南-车公庙
		'edge.type' : 'slope11_1',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.center' : true,
		'edge.gap':gap,
		'edge.corner.radius':0
    };
var edgeStyle_slope11 = {		//  11号线第二个不规则弯道，车公庙-福田
		'edge.type' : 'slope11_2',
		'edge.color' : '#00ebb3',
		'edge.width' : edgeWidth,
		'edge.center' : true,
		'edge.gap':gap,
		'edge.corner.radius':0
    };
var edgeNoteStyle = {		//线段标签样式（路线数字标号）
        'note': '11',
        'note.color':'white',
        'note.background':'red',
        'note.position': 17,
        'note.offset.x': 0,
        'note.offset.y': 0 
}
var flowEdgeStyle = {			//流动样式
		'flow':true,
		'flow.element.shadow.max':4,
		'flow.element.shadow.min':4,
		'flow.element.image':'arrow',
		'flow.element.count':1,
		'flow.element.max':4
}
var edgeTypes = [edgeStyle_slope0,edgeStyle_slope1,edgeStyle_slope2,edgeStyle_slope3,edgeStyle_slope4,edgeStyle_slope5,edgeStyle_slope6,edgeStyle_slope7,edgeStyle_slope8,edgeStyle_slope9,edgeStyle_slope10,edgeStyle_slope11];

function getImgStyle(data){
	return {
			'label': data.lineId,
			'leftColor': '#00ebb3',
			'leftRotation': data.img.left.ro,
			'leftLineVisible': data.img.left.vis,
			'rightColor': '#00ebb3',
			'rightRotation': data.img.right.ro,
			'rightLineVisible': data.img.right.vis,
			'labelColor': data.img.labelColor
	}
}