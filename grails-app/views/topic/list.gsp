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
        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>CreatedBy</th>
                <th>visibility</th>
                <th># Subscription</th>
                <th># Resources</th>
                <th>DateCreated</th>
                <th>LastUpdated</th>
            </tr>
            </thead>
            <tbody>
                <g:each var="topicObj" in="${topicsListByUser}" status="i">
                    <g:set var="classInfo" value="${ (i % 2) == 0 ? 'success' : 'info'}"/>
                    <tr class="${classInfo}">
                        <td>${topicObj.id}</td>
                        <td>${topicObj.name}</td>
                        <td>${topicObj.createdBy.firstName} ${topicObj.createdBy.lastName}</td>
                        <td>${topicObj.visibility}</td>
                        <td>${topicObj.subscriptions.size()}</td>
                        <td>${topicObj.resources.size()}</td>
                        <td><g:formatDate format="dd-MMM-yyyy" date="${topicObj.dateCreated}"/></td>
                        <td><g:formatDate format="dd-MMM-yyyy" date="${topicObj.lastUpdated}"/></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>


