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
	var r = confirm("Are you sure you want to delete!");
	if (r == true) {
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

function editResourceGet(resourceId){
	var resDescDiv = $("#resDescDiv").html();
	$("#editResourceId").val(resourceId);
	$("#editResourceDesc").val(resDescDiv);
}

function editResourcePost(){
	var resourceId = $("#editResourceId").val();
	var resourceDesc = $("#editResourceDesc").val();
	$.ajax({
		async:false,
		url: "/resource/update",
		type:"post",
		data:"resourceId="+resourceId+"&resourceDesc="+resourceDesc,
		dataType: 'json',
		success: function(data) {
			if(data.response == "success"){
				$('#resourceEdit').modal('toggle');
				alert("Description has been changed successfully !!!");
				location.reload();
			}else
				alert("Some error has been occurred !!!");
		}
	});
	return false;
}

function deleteResource(resourceId){
	var r = confirm("Are you sure you want to delete!");
	if (r == true) {
		$.ajax({
			url: "/resource/delete",
			type:"post",
			data:"resourceId="+resourceId,
			dataType: 'json',
			success: function(data) {
				if(data.response == "success"){
					alert("Resource has been deleted successfully !!!");
					window.location.href = USER_DASHBOARD_URL;
				}else
					alert("Some error has been occurred !!!");
			}
		});
	}
}


$().ready(function(){

	$("#registerForm").validate({
		rules: {
			firstName: "required",
			lastName: "required",
			userName: "required",
			email: {
				required: true,
				email: true
			},
			password: {
				required: true,
				minlength: 5
			},
			confirmPassword: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			}
		},
		messages: {
			firstName: "Please enter your first name",
			lastName: "Please enter your last name",
			userName: "Please enter your user name",
			email: {
				required: "Please provide your email address",
				email: "Please enter a valid email address"
			},
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirmPassword: {
				required: "Please provide a confirm password",
				minlength: "Your confirm password must be at least 5 characters long",
				equalTo :  "Password and confirm password mismatch"
			}
		}
	});

	$("#loginForm").validate({
		rules: {
			userName: "required",
			password: "required"
		},
		messages: {
			userName: "Please specify Email/UserName",
			password: "Please enter your password"
		}
	});

	$("#forgotPasswordForm").validate({
		rules: {
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			email: {
				required: "Please provide your email address",
				email: "Please enter a valid email address"
			}
		}
	});

	$("#createTopicForm").validate({
		rules: {
			name: "required",
			visibility: "required"
		},
		messages: {
			name: "Please specify topic name",
			visibility: "Please select the visibility"
		}
	});

	$("#sendInvitationForm").validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			topicId: "required"
		},
		messages: {
			email: {
				required: "Please provide your email address",
				email: "Please enter a valid email address"
			},
			topicId: "Please select any topic"
		}
	});

	$("#shareLinkForm").validate({
		rules: {
			url: "required",
			description: "required",
			topicId: "required"
		},
		messages: {
			url: "Please specify link",
			description: "Please fill the description",
			topicId: "Please select any topic"
		}
	});

	$("#shareDocumentForm").validate({
		rules: {
			document: "required",
			description: "required",
			topicId: "required"
		},
		messages: {
			document: "Please upload any document",
			description: "Please fill the description",
			topicId: "Please select any topic"
		}
	});

	$("#resourceEditForm").validate({
		rules: {
			editResourceDesc: "required"
		},
		messages: {
			editResourceDesc: "Please Fill Resource Description"
		},
		submitHandler: function(form) {
			editResourcePost();
		}
	});

	$("#profileEditForm").validate({
		rules: {
			firstName: "required",
			lastName: "required",
			userName: "required"
		},
		messages: {
			firstName: "Please enter your first name",
			lastName: "Please enter your last name",
			userName: "Please enter your user name"
		}
	});

	$("#changePwdForm").validate({
		rules: {
			password: {
				required: true,
				minlength: 5
			},
			confirmPassword: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			}
		},
		messages: {
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirmPassword: {
				required: "Please provide a confirm password",
				minlength: "Your confirm password must be at least 5 characters long",
				equalTo :  "Password and confirm password mismatch"
			}
		}
	});
	
});