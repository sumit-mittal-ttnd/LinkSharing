<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Topics List</title>

    <style>
    .tab-space {
        padding-left: 10px
    }
    </style>
</head>

<body>
<div class="container">


    <g:render template="/shared/header"/>


    <div class="row">
        <g:each var="topic" in="${topicsListByUser}">
            <g:link action="showTopic" controller="login" params="[id:topic.id]">${topic.name}</g:link> - ${topic.visibility} - ${topic.dateCreated} - ${topic.lastUpdated} - ${topic.createdBy.firstName} ${topic.createdBy.lastName}
            <br/>
        </g:each>
    </div>
</div>
</body>
</html>