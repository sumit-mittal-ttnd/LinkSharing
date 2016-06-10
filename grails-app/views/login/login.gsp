<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
	</head>

	<body>


		<div class="errorDiv">${responseMsg}</div><br/>

		<div class="flashDiv">
			<g:if test="${flash.error}">
				<div class="alert alert-error" style="display: block">${flash.error}</div>
			</g:if>
			<g:if test="${flash.message}">
				<div class="message" style="display: block">${flash.message}</div>
			</g:if>
		</div><br/>




	LOGIN PAGE


	</body>
</html>