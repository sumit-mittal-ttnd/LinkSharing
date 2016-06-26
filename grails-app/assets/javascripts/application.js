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

function unsubscribe(subscriptionId){
	$.ajax({
		url: "/subscription/unsubscribe",
		type:"post",
		data:"subscriptionId="+subscriptionId,
		dataType: 'json',
		success: function(data) {
			if(data.response == "success"){
				alert("You have successfully unsubscribed !!!");
				location.reload();
			}else
				alert("Some error has been occurred !!!");
		}
	});
}

function subscribe(userId, topicId){
	$.ajax({
		url: "/subscription/subscribe",
		type:"post",
		data:"userId="+userId+"&topicId="+topicId,
		dataType: 'json',
		success: function(data) {
			if(data.response == "success"){
				alert("You have successfully Subscribed !!!");
				location.reload();
			}else
				alert("Some error has been occurred !!!");
		}
	});
}

function deleteTopic(topicId){
	$.ajax({
		url: "/topic/delete",
		type:"post",
		data:"topicId="+topicId,
		dataType: 'json',
		success: function(data) {
			if(data.response == "success"){
				alert("Topic has been deleted successfully !!!");
				window.location.href = USER_DASHBOARD_URL;
			}else
				alert("Some error has been occurred !!!");
		}
	});
}

function updateSeriousness(subscriptionId, seriousness){
	$.ajax({
		url: "/subscription/updateSeriousness",
		type:"post",
		data:"subscriptionId="+subscriptionId+"&seriousness="+seriousness,
		dataType: 'json',
		success: function(data) {
			if(data.response == "success"){
				alert("Seriousness has been changed to "+seriousness+" !!!");
				location.reload();
			}else
				alert("Some error has been occurred !!!");
		}
	});
}

function updateVisibility(topicId, visibility){
	$.ajax({
		url: "/topic/updateVisibility",
		type:"post",
		data:"topicId="+topicId+"&visibility="+visibility,
		dataType: 'json',
		success: function(data) {
			if(data.response == "success"){
				alert("Visibility has been changed to "+visibility+" !!!");
				location.reload();
			}else
				alert("Some error has been occurred !!!");
		}
	});
}



function editTopicGet(topicId, topicName){
	console.log(topicId+"--"+topicName)
	$("#editTopicId").val(topicId);
	$("#editTopicName").val(topicName);
}

function editTopicPost(){
	var topicId = $("#editTopicId").val();
	var topicName = $("#editTopicName").val();
	$.ajax({
		async:false,
		url: "/topic/update",
		type:"post",
		data:"topicId="+topicId+"&topicName="+topicName,
		dataType: 'json',
		success: function(data) {
			if(data.response == "success"){
				$('#topicEdit').modal('toggle');
				alert("Topic name has been changed successfully !!!");
				location.reload();
			}else
				alert("Some error has been occurred !!!");
		}
	});
	return false;
}




