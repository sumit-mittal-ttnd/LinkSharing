// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

function markAsRead(resId){
	$.ajax({
		url: "/resource/markAsRead",
		type:"post",
		data:"resourceId="+resId,
		dataType: 'json',
		success: function(data) {
			if(data.response == "success")
				alert("Resource Has been marked as read !!!");
			else
				alert("Some error has been occurred !!!");
			location.reload();
		}
	});
}