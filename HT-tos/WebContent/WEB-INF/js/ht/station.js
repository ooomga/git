var halfPI = Math.PI * 0.5;
ht.Default.setImage('station', {
	width: 100,
	height: 100,
	clip: function(g, width, height, data) {
		g.beginPath();
		g.arc(width / 2, height / 2, 45, 0, Math.PI * 2, true);
		g.clip();
	},
	comps: [
		{
			type: 'arc',
			rect: [ 5, 5, 90, 90 ],
			background: { func: 'attr@rightColor' },
			arcFrom: { 
				func: function(data) {
					return data.a('leftRotation') || 0;
				}
			},
			arcTo: { 
				func: function(data) {
					return data.a('rightRotation')  || 0;
				}
			}
		},
		{
			type: 'arc',
			rect: [ 5, 5, 90, 90 ],
			background: { func: 'attr@leftColor' },
			arcFrom: {
				func: function(data) {					
						return data.a('rightRotation')|| 0;				
				}
			},
			arcTo: {
				func: function(data) {
					return data.a('leftRotation') || 0;
				}
			}
		},
		{
			type: 'shape',
			borderColor: '#515151',
			borderWidth: 13,
			points: [ 50, 0, 50, 50, 50, 100 ],
			segments: [1, 2, 1],
			rotation: { func:  function(data){ return data.a('rightRotation')+Math.PI*0.5}, value: 0 },
			visible: { func: 'attr@rightLineVisible' }
		},
		{
			type: 'shape',
			borderColor: '#515151',
			borderWidth: 13,
			points: [ 50, 0, 50, 50, 50, 100 ],
			segments: [1, 2, 1],
			rotation: { func: function(data){return data.a('leftRotation')+Math.PI*0.5}, value: 0 },
			visible: { func: 'attr@lefttLineVisible' }
		},
		{
			type: 'circle',
			rect: [ 20, 20, 60, 60 ],
			background: 'white'
		},
		{
			type: 'text',
			rect: [0, 0, 100, 100],
			align: 'center',
			text: { func: 'attr@label' },
			font: 'bold 32px Arial',
			color: { func: 'attr@labelColor' }
		}
	]
});
