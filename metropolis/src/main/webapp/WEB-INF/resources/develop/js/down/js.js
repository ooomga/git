$('.tjhy').click(function() {
	$('.vip_vip').css('display', 'block');
	$('.bg_hover').css('display', 'block');
})
$('#input').click(function() {
	if (this.checked) {
		$("input[name='checkname']").attr('checked', true)
	} else {
		$("input[name='checkname']").attr('checked', false)
	}
});
$('.qy').click(function() {
	$('.vip_open').css('display', 'block');
	$('.bg_hover').css('display', 'block');
})
$('.ty').click(function() {
	$('.vip_stop').css('display', 'block');
	$('.bg_hover').css('display', 'block');
})
$('.vip_look_stop_x').click(function() {
	$('.vip_look_stop').css('display', 'none');
	$('.bg_hover').css('display', 'none');
})
$('.vip_look_stop_time_button1').click(function() {
	$('.vip_look_stop').css('display', 'none');
	$('.bg_hover').css('display', 'none');
})
$('.vip_look_stop_time_button2').click(function() {
	$('.vip_look_stop').css('display', 'none');
	$('.bg_hover').css('display', 'none');
})
$('.vip_look_stop_head_2').click(function() {
	$('.vip_look_stop').css('display', 'none');
	$('.bg_hover').css('display', 'none');
})
$('.certification_button').click(function() {
	$('.bg_hover').css({
		display : 'block'
	});
	$('.certification_hover').css({
		display : 'block'
	});
})
$('#button>button').click(function() {
	$('.bg_hover').css({
		display : 'none'
	});
	$('.certification_hover').css({
		display : 'none'
	});
});
$('.certification_hover .top_2').click(function() {
	$('.bg_hover').css({
		display : 'none'
	});
	$('.certification_hover').css({
		display : 'none'
	});
});
$('.new_yj').click(function() {
	$('.hardware_ss_gl_yj').css('display', 'block');
	$('.bg_hover').css('display', 'block');
});
$('.vip_look_stop_head_2').click(function() {
	$('.vip_look_stop').css('display', 'none');
	$('.bg_hover').css('display', 'none');
})