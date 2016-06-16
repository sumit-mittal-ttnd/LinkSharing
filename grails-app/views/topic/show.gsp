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
        NAME : ${topic.name}<br/>
        CREATEDBY : ${topic.createdBy.firstName} ${topic.createdBy.lastName}<br/>
        VISIBILITY : ${topic.visibility}<br/>
        DATE CREATED : ${topic.dateCreated}<br/>
        LAST UPDATED : ${topic.lastUpdated}<br/>
    </div>
</div>
</body>
</html>