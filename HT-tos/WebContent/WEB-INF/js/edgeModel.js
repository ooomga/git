createEdgeModel = function(){
    
    var gap = 10,
        radius = 5,
        node1, node2;

    // flex
//    node1 = createNode(50, 460);
//    node2 = createNode(220, 400);
//    createEdge(node1, node2, 2, {
//        'edge.type': 'flex',
//        'edge.gap': gap
//    });    

    node1 = createNode(50, 460);
    node2 = createNode(220, 400);
    createEdge(node1, node2, 2, {
        'edge.type': 'flex',
        'edge.flex':10,
        'edge.width': 6,
        'edge.color': '#00ebb3',
        'edge.corner.radius':120,
        'edge.gap': gap
    });   
    



    // h.v

    node1 = createNode(280, 560,true);
    node2 = createNode(450, 500,false);
    createEdge(node1, node2, 2, {
        'edge.type': 'h.v',
        'edge.gap': gap,
        'edge.color': '#00ebb3',
        'edge.corner.radius':2
    });   


    // v.h
    node1 = createNode(50, 660);
    node2 = createNode(220, 600);
    createEdge(node1, node2, 2, {
        'edge.type': 'v.h',
        'edge.gap': gap
    });    

    node1 = createNode(280, 660);
    node2 = createNode(450, 600);
    createEdge(node1, node2, 2, {
        'edge.type': 'v.h',
        'edge.gap': gap,
        'edge.corner.radius': radius
    });   


    // extend.east
    node1 = createNode(50, 760);
    node2 = createNode(190, 700);
    createEdge(node1, node2, 2, {
        'edge.type': 'extend.east',
        'edge.color': '#00ebb3',
        'edge.corner.radius':45,
        'edge.width': 6,
        'edge.gap': 10
    });    

    node1 = createNode(280, 760);
    node2 = createNode(420, 700);
    createEdge(node1, node2, 2, {
        'edge.type': 'extend.east',
        'edge.gap': gap,
        'edge.corner.radius': radius
    });   


    // extend.west
    node1 = createNode(80, 860);
    node2 = createNode(220, 800);
    createEdge(node1, node2, 2, {
        'edge.type': 'extend.west',
        'edge.gap': gap
    });    

    node1 = createNode(310, 860);
    node2 = createNode(450, 800);
    createEdge(node1, node2, 2, {
        'edge.type': 'extend.west',
        'edge.gap': gap,
        'edge.corner.radius': radius
    });   


    // extend.north
    node1 = createNode(50, 960);
    node2 = createNode(220, 930);
    createEdge(node1, node2, 2, {
        'edge.type': 'extend.north',
        'edge.gap': gap
    });    

    node1 = createNode(280, 960);
    node2 = createNode(450, 930);
    createEdge(node1, node2, 2, {
        'edge.type': 'extend.north',
        'edge.gap': gap,
        'edge.corner.radius': radius
    });   




    

};