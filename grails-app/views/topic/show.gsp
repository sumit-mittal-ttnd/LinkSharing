<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Topic</title>

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

        <div class="col-xs-5" >
            <div class="panel panel-default">
                <div class="panel-heading">Topic : "${topic.name}"</div>
                <div class="panel-body">
                    <g:render template="/shared/topicGrid" model="[topicObj:topic]"/>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Users : "${topic.name}"</div>
                <div class="panel-body">
                    <g:each var="subscriptionObj" in="${topic.subscriptions}" status="i">
                        <g:render template="/shared/userGrid" model="[userObj:subscriptionObj.user]"/>
                    </g:each>

                </div>
            </div>
        </div>

        <div class="col-xs-7 pull-right" >
            <div class="panel panel-default">
                <div class="panel-heading">Post : "${topic.name}"</div>
                <div class="panel-body">
                    <g:each var="resourceObj" in="${topic.resources}" status="i">
                        <g:render template="/shared/resourceGrid" model="[resourceObj: resourceObj, unreadResources:unreadResources]"/>
                    </g:each>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>