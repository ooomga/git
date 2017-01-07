var graph = window.graph = new ht.graph.GraphView(), dataModel = graph.dm();
function init() {
	var view = graph.getView(), nodeList = new ht.List();
	line1.forEach(function(st) {
		var node = createNode(st)
		nodeList.add(node);
	});

	for (var i = 0; i < nodeList.size() - 1; i++) {
		createEdge(nodeList.get(i), nodeList.get(i + 1));
	}
	
	graph.setLayers([ 1, 2 ]);
	graph.enableDashFlow();
	graph.translate(100, 100);
	view.className = "main";
	document.getElementById("main").appendChild(view);
}
var nodeStyle = {
	'shape' : 'circle',
	'select.border.width' : 2,
	'shape.background' : 'white',
	'shape.border.color' : '#c8c8c8',
	'shape.border.width' : 4,
	'select.width' : 0,
	'label.color' : 'white'
};

var edgeStyle = {
	'edge.width' : 3,
	'edge.type': 'points',
	'edge.center' : true,
	'edge.corner.radius': 5,
	'edge.color' : '#00ebb3'
};
function createNode(data) {
	var node = new ht.Node();
	node.setPosition(data.position.x, data.position.y);
	node.setWidth(15);
	node.setHeight(15);
	node.s(nodeStyle);
	node.s("label.offset.x", -(data.name_ch.length * 10) - 5);
	node.s("label.offset.y", -20);
	node.a("pointIndex", data.index);
	node.a("type", "station");
	node.setName(data.name_ch);
	node.setLayer(2);
	dataModel.add(node);
	return node;
}
function createEdge(sourceNode, targetNode) {
	var edge;
	edge = new ht.Edge(sourceNode, targetNode);
	edge.s(edgeStyle);
	edge.setLayer(2);
	edge.s('edge.source.offset.x',3);
	edge.s('edge.source.offset.y',3);
	edge.s('edge.target.offset.x',3);
	edge.s('edge.target.offset.y',3);
	dataModel.add(edge);
	edge = new ht.Edge(targetNode , sourceNode);
	edge.s(edgeStyle);
	edge.s('edge.source.offset.x',-3);
	edge.s('edge.source.offset.y',-3);
	edge.s('edge.target.offset.x',-3);
	edge.s('edge.target.offset.y',-3);
	edge.setLayer(2);
	dataModel.add(edge);
}

