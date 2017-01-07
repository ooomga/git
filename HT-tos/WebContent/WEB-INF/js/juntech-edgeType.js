ht.Default.setEdgeType('edge1', // 在起始点从左到右，在sourceNode.corner的位置向右下弯曲,成135度角
function(edge, gap, graphView, sameSourceWithFirstEdge) {
	var sourceNode = edge.getSourceAgent();
	var targetNode = edge.getTargetAgent();
	var points = new ht.List();
	var sp = sourceNode.getPosition();
	var tp = targetNode.getPosition();
	points.add({
		x : sp.x,
		y : sp.y
	});
	points.add({
		x : tp.x,
		y : tp.y
	});

	var obj =  {
			points : points,
			segments : new ht.List([ 1, 2])
		};
	
	return ht.Default.getPointsInfo(obj, gap);
});
ht.Default.setEdgeType('slope1', // 在起始点从左到右，在sourceNode.corner的位置向右下弯曲,成135度角
function(edge, gap, graphView, sameSourceWithFirstEdge) {
	var sourceNode = edge.getSourceAgent();
	var corner = sourceNode._attrObject.corner;
	var targetNode = edge.getTargetAgent();
	var points = new ht.List();
	var sp = sourceNode.getPosition();
	var tp = targetNode.getPosition();
	points.add({
		x : sp.x,
		y : sp.y
	});
	points.add({
		x : corner.x - 5,
		y : corner.y
	})
	points.add({
		x : corner.x - 2,
		y : corner.y
	});
	points.add({
		x : corner.x - 1,
		y : corner.y
	});
	points.add({
		x : corner.x + 4,
		y : corner.y + 5
	});
	points.add({
		x : tp.x,
		y : tp.y
	});

	var obj =  {
		points : points,
		segments : new ht.List([ 1, 2, 4, 2 ])
	};
	return ht.Default.getPointsInfo(obj, gap);
});
ht.Default.setEdgeType('slope2', // 在起始点从左到右，在sourceNode.corner的位置向右上弯曲,成135度角
function(edge, gap, graphView, sameSourceWithFirstEdge) {
	var sourceNode = edge.getSourceAgent();
	var corner = sourceNode._attrObject.corner;
	var targetNode = edge.getTargetAgent();
	var points = new ht.List();
	var sp = sourceNode.getPosition();
	var tp = targetNode.getPosition();
	points.add({
		x : sp.x,
		y : sp.y
	});
	points.add({
		x : corner.x - 5,
		y : corner.y
	})
	points.add({
		x : corner.x - 2,
		y : corner.y
	});
	points.add({
		x : corner.x - 1,
		y : corner.y
	});
	points.add({
		x : corner.x + 4,
		y : corner.y - 5
	});
	points.add({
		x : tp.x,
		y : tp.y
	});

	var obj =  {
			points : points,
			segments : new ht.List([ 1, 2, 4, 2 ])
		};
		return ht.Default.getPointsInfo(obj, gap);
});
ht.Default.setEdgeType('slope3', // 在起始点由上到下，在sourceNode.corner的位置向左下弯曲,成135度角
function(edge, gap, graphView, sameSourceWithFirstEdge) {
	var sourceNode = edge.getSourceAgent();
	var corner = sourceNode._attrObject.corner;
	var targetNode = edge.getTargetAgent();
	var points = new ht.List();
	var sp = sourceNode.getPosition();
	var tp = targetNode.getPosition();
	points.add({
		x : sp.x,
		y : sp.y
	});
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
		y : corner.y - 1
	});
	points.add({
		x : corner.x - 5,
		y : corner.y + 4
	});
	points.add({
		x : tp.x,
		y : tp.y
	});

	var obj =  {
			points : points,
			segments : new ht.List([ 1, 2, 4, 2 ])
		};
		return ht.Default.getPointsInfo(obj, gap);
});
ht.Default.setEdgeType('slope4', // 在起始点由上到下，在sourceNode.corner的位置向右下弯曲,成135度角
function(edge, gap, first, graphView, sameSourceWithFirstEdge) {
	var sourceNode = edge.getSourceAgent();
	var corner = sourceNode._attrObject.corner;
	var targetNode = edge.getTargetAgent();

	var points = new ht.List();
	var sp = sourceNode.getPosition();
	var tp = targetNode.getPosition();
	points.add({
		x : sp.x,
		y : sp.y
	});
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
		y : corner.y - 1
	});
	points.add({
		x : corner.x + 4,
		y : corner.y +3
	});
	points.add({
		x : tp.x,
		y : tp.y
	});

	var obj =  {
			points : points,
			segments : new ht.List([ 1, 2, 4, 2 ])
		};
		return ht.Default.getPointsInfo(obj, gap);
});
ht.Default.setEdgeType('slope5', // 在起始点由上到下，在sourceNode.corner的位置向右下弯曲,成135度角
function(edge, gap, first, graphView, sameSourceWithFirstEdge) {
	var sourceNode = edge.getSourceAgent();
	var corner = sourceNode._attrObject.corner;
	var targetNode = edge.getTargetAgent();

	var points = new ht.List();
	var sp = sourceNode.getPosition();
	var tp = targetNode.getPosition();
	if (edge.getAttrObject() && edge.getAttrObject().isNext) {
		points.add({
			x : sp.x+2,
			y : sp.y
		});
		points.add({
			x : corner.x,
			y : corner.y - 5
		})
		points.add({
			x : corner.x + 4,
			y : corner.y + 5
		});
		points.add({
			x : tp.x,
			y : tp.y
		});
	} else {
		points.add({
			x : sp.x-2,
			y : sp.y
		});
		points.add({
			x : corner.x,
			y : corner.y - 5
		})
		points.add({
			x : corner.x + 4,
			y : corner.y + 5
		});
		points.add({
			x : tp.x,
			y : tp.y
		});
	}

	var dx = tp.x - sp.x, dy = tp.y - sp.y;
	points.each(function(p) {
		p.x = p.x + gap * (dy > 0 ? -1 : 1);
		p.y = p.y + gap * (dx > 0 ? 1 : -1);
	});

	return {
		points : points,
		segments : new ht.List([ 1,  4 ])
	};
});
ht.Default.setEdgeType('slope7_1', // 7号线第一个不规则弯道，安托山-农林
		function(edge, gap, first, graphView, sameSourceWithFirstEdge) {
			var sourceNode = edge.getSourceAgent();
			var corners = sourceNode._attrObject.corner;
			var corner1 = corners[0];
			var corner2 = corners[1];
			var targetNode = edge.getTargetAgent();

			var points = new ht.List();
			var sp = sourceNode.getPosition();
			var tp = targetNode.getPosition();
			points.add({x : sp.x,y : sp.y});
			points.add({
				x : corner1.x,
				y : corner1.y - 5
			})
			points.add({
				x : corner1.x,
				y : corner1.y -2
			});
			points.add({
				x : corner1.x,
				y : corner1.y
			});
			points.add({
				x : corner1.x+5,
				y : corner1.y+5
			});
			points.add({
				x : corner2.x-5,
				y : corner2.y-5
			});
			points.add({
				x : corner2.x+1,
				y : corner2.y
			});
			points.add({
				x : corner2.x+2,
				y : corner2.y
			});
			points.add({
				x : corner2.x+5,
				y : corner2.y
			});
			points.add({
				x : tp.x,
				y : tp.y
			});
			
			var obj =  {
					points : points,
					segments : new ht.List([  1,2,4,2,4,2])
				};
				return ht.Default.getPointsInfo(obj, gap);
		});
ht.Default.setEdgeType('slope7_2', // 7号线第二个不规则弯道，车公庙-上沙
		function(edge, gap, first, graphView, sameSourceWithFirstEdge) {
			var sourceNode = edge.getSourceAgent();
			var corners = sourceNode._attrObject.corner;
			var corner1 = corners[0];
			var corner2 = corners[1];
			var targetNode = edge.getTargetAgent();

			var points = new ht.List();
			var sp = sourceNode.getPosition();
			var tp = targetNode.getPosition();
			var x0 = 0;
			var y0 = 0;
			if (edge.getAttrObject() && edge.getAttrObject().isNext) {// 若是第二个线段则isNext=true
				x0 = -0.5;
			}else{
				x0 = 0.5;
			}
			points.add({x : sp.x,y : sp.y});
			points.add({
				x : corner1.x+x0,
				y : sp.y +10
			})
			points.add({
				x : corner1.x+x0,
				y : corner1.y+30
			});
			points.add({
				x : corner2.x+x0,
				y : corner2.y
			});
			points.add({
				x : corner2.x+x0,
				y : tp.y-5
			});
			points.add({
				x : tp.x,
				y : tp.y
			});
//			
//			var obj =  {
//					points : points,
//					segments : new ht.List([ 1,3,2,3])
//				};
//				return ht.Default.getPointsInfo(obj, gap);

			var dx = tp.x - sp.x, dy = tp.y - sp.y;
			points.each(function(p) {
				p.x = p.x + gap * (dy > 0 ? -1 : 1);
				p.y = p.y + gap * (dx > 0 ? 1 : -1);

			});

			return {
				points : points,
				segments : new ht.List([ 1,3,2,3])
			};
		});
ht.Default.setEdgeType('slope11_1', // 11号线第一个不规则弯道，红树湾南-车公庙
		function(edge, gap, first, graphView, sameSourceWithFirstEdge) {
			var sourceNode = edge.getSourceAgent();
			var corners = sourceNode._attrObject.corner;
			var corner1 = corners[0];
			var corner2 = corners[1];
			var corner3 = corners[2];
			var targetNode = edge.getTargetAgent();

			var points = new ht.List();
			var sp = sourceNode.getPosition();
			var tp = targetNode.getPosition();
			points.add({x : sp.x,y : sp.y});
			points.add({
				x : corner1.x-5,
				y : corner1.y+5
			});
			points.add({
				x : corner1.x,
				y : corner1.y
			});
			points.add({
				x : corner1.x+10,
				y : corner1.y
			});
			points.add({
				x : corner2.x-10,
				y : corner2.y
			});
			points.add({
				x : corner2.x-3,
				y : corner2.y
			});
			points.add({
				x : corner2.x,
				y : corner2.y-3
			});
			points.add({
				x : corner2.x,
				y : corner2.y-10
			});
			points.add({
				x : corner3.x,
				y : corner3.y+10
			});
			points.add({
				x : corner3.x,
				y : corner3.y
			});
			points.add({
				x : corner3.x+5,
				y : corner3.y-5
			});
			points.add({
				x : tp.x,
				y : tp.y
			});
			
			var obj =  {
					points : points,
					segments : new ht.List([1,2,3,2,4,2,3,2])
				};
				return ht.Default.getPointsInfo(obj, gap);
		});
ht.Default.setEdgeType('slope11_2', // 11号线第一个不规则弯道，红树湾南-车公庙
		function(edge, gap, first, graphView, sameSourceWithFirstEdge) {
			var sourceNode = edge.getSourceAgent();
			var corners = sourceNode._attrObject.corner;
			var corner1 = corners[0];
			var corner2 = corners[1];
			var targetNode = edge.getTargetAgent();

			var points = new ht.List();
			var sp = sourceNode.getPosition();
			var tp = targetNode.getPosition();
			points.add({x : sp.x,y : sp.y});
			points.add({
				x : corner1.x-5,
				y : corner1.y+5
			});
			points.add({
				x : corner1.x,
				y : corner1.y
			});
			points.add({
				x : corner1.x+5,
				y : corner1.y
			});
			points.add({
				x : corner2.x-5,
				y : corner2.y
			});
			points.add({
				x : corner2.x,
				y : corner2.y
			});
			points.add({
				x : corner2.x+5,
				y : corner2.y-5
			});
			points.add({
				x : tp.x,
				y : tp.y
			});
			
			var obj =  {
					points : points,
					segments : new ht.List([ 1,2,3,2,3,2])
				};
				return ht.Default.getPointsInfo(obj, gap);

		});
ht.Default.setEdgeType('test:west', // 在起始点由上到下，在sourceNode.corner的位置向右下弯曲,成135度角
function(edge, gap, gv) {
	var points = new ht.List();
	p1 = edge.getSourceAgent().getPosition(), x1 = p1.x, y1 = p1.y, p2 = edge
			.getTargetAgent().getPosition(), x2 = p2.x, y2 = p2.y,
			x = (x1 < x2 ? x1 : x2);

	if (y2 < y1) {
		points.add({
			x : x1,
			y : y1 + gap
		});
		points.add({
			x : x - gap,
			y : y1 + gap
		});
		points.add({
			x : x - gap,
			y : y2 - gap
		});
		points.add({
			x : x2,
			y : y2 + gap
		});
	} else {
		points.add({
			x : x1,
			y : y1 - gap
		});
		points.add({
			x : x - gap,
			y : y1 - gap
		});
		points.add({
			x : x - gap,
			y : y2 + gap
		});
		points.add({
			x : x2,
			y : y2 + gap
		});
	}
	return {
		points : points,
		segments : new ht.List([ 1, 3, 2 ])
	};
});
ht.Default.setEdgeType('test', // 在起始点由上到下，在sourceNode.corner的位置向右下弯曲,成135度角
		function(edge, gap, graphview) {
			var source = edge.getSourceAgent(),
				target = edge.getTargetAgent();
			
			var points = new ht.List();
			sp = source.p(),
			tp = target.p(),
			corner = source.a('corner');
			if (edge.getAttrObject() && edge.getAttrObject().isNext) {
				points.add({x:sp.x-2,y:sp.y-2});
				points.add({
					x:corner.x+68,
					y:corner.y-74
				});
				points.add({
					x:corner.x+3,
					y:corner.y-1
				});
			}else{
				points.add({x:sp.x+2,y:sp.y+2});
				points.add({
					x:corner.x+73.5,
					y:corner.y-69.5
				});
				points.add({
					x:corner.x-2,
					y:corner.y+2
				});
			}
			points.add({x:tp.x,y:tp.y});
			var dx = tp.x - sp.x, dy = tp.y - sp.y;
			points.each(function(p) {
				p.x = p.x + gap * (dy > 0 ? -1 : 1);
				p.y = p.y + gap * (dx > 0 ? 1 : -1);
			});
			return {
				points:points,
				segments:new ht.List([1,4])
			};
		});
ht.Default.setEdgeType('test2', // 在起始点由上到下，在sourceNode.corner的位置向右下弯曲,成135度角
		function(edge, gap, graphview) {
			var source = edge.getSourceAgent(),
				target = edge.getTargetAgent();
			
			var points = new ht.List();
			sp = source.p(),
			tp = target.p(),
			corner = source.a('corner');
			if (edge.getAttrObject() && edge.getAttrObject().isNext) {
				points.add({x:sp.x-2,y:sp.y-2});
				points.add({
					x:corner.x+68,
					y:corner.y-74
				});
				points.add({
					x:corner.x+3,
					y:corner.y-1
				});
			}else{
				points.add({x:sp.x+2,y:sp.y+2});
				points.add({
					x:corner.x+73.5,
					y:corner.y-69.5
				});
				points.add({
					x:corner.x-2,
					y:corner.y+2
				});
			}
			points.add({x:tp.x,y:tp.y});
			var dx = tp.x - sp.x, dy = tp.y - sp.y;
			points.each(function(p) {
				p.x = p.x + gap * (dy > 0 ? -1 : 1);
				p.y = p.y + gap * (dx > 0 ? 1 : -1);
			});
			return {
				points:points,
				segments:new ht.List([1,4])
			};
		});