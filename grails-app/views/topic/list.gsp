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

    <div class="container bodyMinHeight">

        <g:render template="/shared/header"/>

        <div class="row">
            <table id="topicListTable" class="display">
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
                    <g:each var="topicObj" in="${topicsByUser}">
                        <tr>
                            <td>${topicObj.id}</td>
                            <td><g:link action="showTopic" controller="login" params="[id:topicObj.id]">${topicObj.name}</g:link></td>
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
    <script>
        $(document).ready( function () {
            $('#topicListTable').DataTable();
        } );
    </script>
</body>
</html>


