<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Invitation from LinkSharing</title>
</head>

<body>

    <h4>Hello ${email}!</h4>
    <p>You are invited for the topic - ${topicName} by <b>${firstName}.</b></p>
    <p>Please click this <a href="http://localhost:8080/login/showTopic?id=${topicId}">link</a> to see the Topic!!</p>
    <p>If you think it was sent incorrectly, please contact administrator at admin@linksharing.com.</p>
    <br/>
    <br/>

    <p>---</p>
    <p>admin team</p>
    <p>Linksharing</p>

</body>
</html>