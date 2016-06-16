<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>
			<g:layoutTitle default="LinkSharing App"/>
		</title>


		%{--Added Scripts and Style Sheets--}%
		<asset:stylesheet src="bootstrap.min.css"/>
		<asset:stylesheet src="font-awesome.min.css"/>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<asset:javascript src="jquery.validate.min.js"/>
		<asset:javascript src="application.js"/>
		<asset:javascript src="bootstrap.min.js"/>

		<g:layoutHead/>

	</head>
	<body>


		%{--Added for error messages--}%
		<g:hasErrors bean="${user}">
			<div class="alert alert-danger">
				<g:eachError var="err" bean="${user}">
					<g:message error="${err}"/>
				</g:eachError>
			</div>
		</g:hasErrors>


		<div class="flashDiv">
			<g:if test="${flash.error}">
				<div class="alert alert-danger" style="display: block">${flash.error}</div><br/>
			</g:if>
			<g:if test="${flash.message}">
				<div class="alert alert-success" style="display: block">${flash.message}</div><br/>
			</g:if>
		</div>


		<g:render template="/topic/createTopic"/>
		<g:render template="/shared/sendInvitation"/>
		<g:render template="/resource/shareLink"/>
		<g:render template="/resource/shareDocument"/>


		<g:layoutBody/>


	</body>
</html>