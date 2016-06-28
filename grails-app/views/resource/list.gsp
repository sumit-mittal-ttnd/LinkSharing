<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Resources List</title>
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
        <div class="col-xs-12" style="font-size: 24px;">
            <center>  <strong>Resources List</strong> </center>
        </div>
    </div><br/>


    <div class="row">
        <table id="resourceListTable" class="display">
            <thead>
                <tr>
                    <th>Resource Id</th>
                    <th class="col-xs-3">Resource Description</th>
                    <th>Topic</th>
                    <th>AddedBy</th>
                    <th>AvgRating</th>
                    <th>DateCreated</th>
                    <th>LastUpdated</th>
                </tr>
            </thead>
            <tbody>
                <g:each var="resourceObj" in="${resources}">
                    <tr>
                        <td>${resourceObj.id}</td>
                        <td><g:link action="showResource" controller="login" params="[resourceId:resourceObj.id]">${resourceObj.description}</g:link></td>
                        <td><g:link action="showTopic" controller="login" params="[id:resourceObj.topic.id]">${resourceObj.topic.name}</g:link></td>
                        <td><g:link action="showUser" controller="login" params="[userId:resourceObj.addedBy.id]">${resourceObj.addedBy.name}</g:link></td>
                        <td>${resourceObj.avgRating}</td>
                        <td><g:formatDate format="dd-MMM-yyyy" date="${resourceObj.dateCreated}"/></td>
                        <td><g:formatDate format="dd-MMM-yyyy" date="${resourceObj.lastUpdated}"/></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</div>
<script>
    $(document).ready( function () {
        $('#resourceListTable').DataTable({
            "order": [[ 4, "desc" ]]
        });
    } );
</script>
</body>
</html>