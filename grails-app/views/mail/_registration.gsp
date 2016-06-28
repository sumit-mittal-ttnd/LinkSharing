<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome To LinkSharing</title>
</head>

<body>

    <h3>Greetings ${firstName}!</h3>
    <p>Welcome to Our Service</p>
    <p>Please click this <g:link controller="login" action="activate" params="[activateCode:activateCode, userId:userId]" absolute="true">link</g:link> to activate you account!!</p>
    <p>If you think it was sent incorrectly, please contact administrator at admin@linksharing.com.</p>
    <br/>
    <br/>

    <p>---</p>
    <p>admin team</p>
    <p>Linksharing</p>

</body>
</html>