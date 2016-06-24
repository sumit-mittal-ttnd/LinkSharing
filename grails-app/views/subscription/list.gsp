<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Subscriptions List</title>

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
        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Topic Name</th>
                <th>User Name</th>
                <th>Seriousness</th>
                <th>DateCreated</th>
                <th>LastUpdated</th>
            </tr>
            </thead>
            <tbody>
                <g:each var="subscribeObj" in="${subscriptions}" status="i">
                    <g:set var="classInfo" value="${ (i % 2) == 0 ? 'success' : 'info'}"/>
                    <tr class="${classInfo}">
                        <td>${subscribeObj.id}</td>
                        <td><g:link action="showTopic" controller="login" params="[id:subscribeObj.topic.id]">${subscribeObj.topic.name}</g:link></td>
                        <td><g:link action="showUser" controller="login" params="[userId:subscribeObj.user.id]">${subscribeObj.user.firstName} ${subscribeObj.user.lastName}</g:link></td>
                        <td>${subscribeObj.seriousness}</td>
                        <td><g:formatDate format="dd-MMM-yyyy" date="${subscribeObj.dateCreated}"/></td>
                        <td><g:formatDate format="dd-MMM-yyyy" date="${subscribeObj.lastUpdated}"/></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>


