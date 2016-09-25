;(function(window, ht) {
	var edgeTypeFunc = function(edge, gap, graphView) {
		var source = edge.getSourceAgent(),
			target = edge.getTargetAgent();

		var points = new ht.List(),
			sP = source.p(),
			tP = target.p(),
			corner = edge.a('corner');
		points.add({ x: sP.x, y: sP.y });
		points.add({
			x : corner.x,
			y : corner.y - 5
		})
		points.add({
			x : corner.x,
			y : corner.y - 2
		});
		points.add({
			x : corner.x,
			y : tP.y
		});
		points.add({ x: tP.x, y: tP.y });

		var obj = {
			points: points,
			segments: new ht.List([ 1, 2, 4 ])
		};

		if (edge.s('edge.type') === 'test') 
			obj = ht.Default.getPointsInfo(obj, gap);
		edge.__pointsInfo = obj;
		return obj;
	};

	ht.Default.setEdgeType('test', edgeTypeFunc);
	ht.Default.setEdgeType('simple', edgeTypeFunc);
}(window, ht));
