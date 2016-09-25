function init() {
		var graph = window.graph = new ht.graph.GraphView(), 
			dataModel = graph.dm(), 
			view = graph.getView(), 
			line = new ht.Shape();
		 line.setPoints(stationList9);
		stationList9.each(function(st) {
			var node = new ht.Node();
			node.setWidth(15);
			node.setHeight(15);
			node.s("shape", "circle");
			node.s("select.border.width", 2);
			node.s("shape.background", 'white');
			node.s("shape.border.color", "#c8c8c8");
			node.s("shape.border.width", 4);
			node.s("select.width", 0);
			node.s("label.color",'white');
	 		node.s("label.offset.x",-(st.stationName.length*10)-5);
			node.s("label.offset.y",-20);
			
			node.a("pointIndex", st.index);
			node.a("type", "station");
			node.setName(st.stationName);
			node.a("pointIndex",st.pointIndex);
			node.setLayer(2);
			node.setHost(line);
			node.setPosition(st.x, st.y);
			dataModel.add(node);
		});
		line.setLayer(1);
		line.s("shape.background", null);
		line.s("shape.border.color", "#00ebb3");
		line.s("shape.border.width", 5);
		dataModel.add(line);

		dataModel.sm().setFilterFunc(function(data) {
			return true;
		});

        dataModel.md(function(e) {
            var property = e.property,
                data = e.data,
                newPosition = e.newValue;
            if (property === "position" && data.a("type") === "station") {
                var pointIndex = data.a("pointIndex");
                ht.Default.setIsolating(true);
                line.setPoint(pointIndex, {x: newPosition.x, y: newPosition.y});
                
                ht.Default.setIsolating(false);
                var rect = ht.Default.unionPoint(line.getPoints());
                if (rect) {
                	line._position.x = rect.x + rect.width/2;
                	line._position.y = rect.y + rect.height/2;
                	line._width = rect.width;
                	line._height = rect.height;
                }
            }
        });
		graph.setLayers([ 1, 2 ]);
		graph.translate(100, 100);
		view.className = "main";
		document.getElementById("main").appendChild(view);
	}
