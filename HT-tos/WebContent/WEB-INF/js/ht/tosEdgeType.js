(function(window, ht) {
	var edge1_Func = function(edge, gap, graphView) {
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
		
		if (edge.s('edge.type') === 'edge1') 
			obj = ht.Default.getPointsInfo(obj, gap);
		edge.__pointsInfo = obj;
		return obj;
	};

	ht.Default.setEdgeType('edge1_bg', edge1_Func);
	ht.Default.setEdgeType('edge1', edge1_Func);
	
	var edgeHV_Func = function(edge, gap, graphView) {
		var sourceNode = edge.getSourceAgent();
		var corner = sourceNode._attrObject.corner;
		var targetNode = edge.getTargetAgent();
		var points = new ht.List();
		var sp = sourceNode.getPosition();
		var tp = targetNode.getPosition();
		var x0 = sp.x-tp.x;
		var y0 = sp.y-tp.y;
		var x1,y1,x2,y2;
		if(x0>0&&y0>0){
			if(corner.x==sp.x){
				x1 = 0; y1 = 5; x2 = -5; y2 = 0;
			}else{
				x1 = 5; y1 = 0; x2 = 0; y2 = -5;
			}
		}else if(x0>0&&y0<0){
			if(corner.x==sp.x){
				x1 = 0; y1 = -5; x2 = -5; y2 = 0;
			}else{
				x1 = 5; y1 = 0; x2 = 0; y2 = 5;
			}
		}else if(x0<0&&y0>0){
			if(corner.x==sp.x){
				x1 = 0; y1 = 5; x2 = 5; y2 = 0;
			}else{
				x1 = -5; y1 = 0; x2 = 0; y2 = -5;
			}
		}else if(x0<0&&y0<0){
			if(corner.x==sp.x){
				x1 = 0; y1 = -5; x2 = 5; y2 = 0;
			}else{
				x1 = -5; y1 = 0; x2 = 0; y2 = 5;
			}
		}
		points.add({
			x : sp.x,
			y : sp.y
		});
		points.add({
			x : corner.x + x1,
			y : corner.y + y1
		})
		points.add({
			x : corner.x,
			y : corner.y
		});
		points.add({
			x : corner.x + x2,
			y : corner.y + y2
		});
		points.add({
			x : tp.x,
			y : tp.y
		});

		var obj =  {
				points : points,
				segments : new ht.List([ 1, 2, 3, 2 ])
			};
		
		if (edge.s('edge.type') === 'edgeHV') 
			obj = ht.Default.getPointsInfo(obj, gap);
		edge.__pointsInfo = obj;
		return obj;
	};

	ht.Default.setEdgeType('edgeHV_bg', edgeHV_Func);
	ht.Default.setEdgeType('edgeHV', edgeHV_Func);
	
	var slope1_Func = function(edge, gap, graphView) {
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
		
		if (edge.s('edge.type') === 'slope1') 
			obj = ht.Default.getPointsInfo(obj, gap);
		edge.__pointsInfo = obj;
		return obj;
	};

	ht.Default.setEdgeType('slope1_bg', slope1_Func);
	ht.Default.setEdgeType('slope1', slope1_Func);
	
	var slope2_Func = function(edge, gap, graphView) {
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
	};

	ht.Default.setEdgeType('slope2_bg', slope2_Func);
	ht.Default.setEdgeType('slope2', slope2_Func);
	
	var slope3_Func = function(edge, gap, graphView) {
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
	};

	ht.Default.setEdgeType('slope3_bg', slope3_Func);
	ht.Default.setEdgeType('slope3', slope3_Func);
	
	var slope4_Func = function(edge, gap, graphView) {
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
	};

	ht.Default.setEdgeType('slope4_bg', slope4_Func);
	ht.Default.setEdgeType('slope4', slope4_Func);
	
	var slope5_Func = function(edge, gap, graphView) {
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
	};

	ht.Default.setEdgeType('slope5_bg', slope5_Func);
	ht.Default.setEdgeType('slope5', slope5_Func);
	
	var slope7_1_Func = function(edge, gap, graphView) {
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
	};

	ht.Default.setEdgeType('slope7_1_bg', slope7_1_Func);
	ht.Default.setEdgeType('slope7_1', slope7_1_Func);
	
	var slope7_2_Func = function(edge, gap, graphView) {
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
			y : sp.y +10
		})
		points.add({
			x : corner1.x,
			y : corner1.y+30
		});
		points.add({
			x : corner2.x,
			y : corner2.y
		});
		points.add({
			x : corner2.x,
			y : tp.y-5
		});
		points.add({
			x : tp.x,
			y : tp.y
		});

		var obj =  {
				points : points,
				segments : new ht.List([ 1,3,2,3])
			};
			return ht.Default.getPointsInfo(obj, gap);
	};

	ht.Default.setEdgeType('slope7_2_bg', slope7_2_Func);
	ht.Default.setEdgeType('slope7_2', slope7_2_Func);
	
	var slope11_1_Func = function(edge, gap, graphView) {
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
	};

	ht.Default.setEdgeType('slope11_1_bg', slope11_1_Func);
	ht.Default.setEdgeType('slope11_1', slope11_1_Func);
	
	var slope11_2_Func = function(edge, gap, graphView) {
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
	};

	ht.Default.setEdgeType('slope11_2_bg', slope11_2_Func);
	ht.Default.setEdgeType('slope11_2', slope11_2_Func);
}(window, ht));