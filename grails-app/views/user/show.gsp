<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Profile</title>

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
                    <div class="panel-body">
                        <g:render template="/shared/userGrid" model="[userObj:user]"/>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">Topics</div>
                    <div class="panel-body">
                        <g:each var="topicObj" in="${topicsByUser}">
                            <g:render template="/shared/topicGrid" model="[topicObj: topicObj]"/>
                        </g:each>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">Subscriptions
                    <g:if test="${user.subscriptions.size()>0}">
                        <g:link action="findSubscriptionsByUser" controller="login" params="[userId:user.id]" class="pull-right">View All</g:link>
                    </g:if>
                    </div>
                    <div class="panel-body">
                        <g:each var="subscribeObj" in="${user.subscriptions}" status="i">
                            <g:render template="/shared/subscriptionGrid" model="[subscribeObj: subscribeObj]"/>
                        </g:each>

                    </div>
                </div>
            </div>


            <div class="col-xs-7 pull-left" >

                <g:if test="${session.userId == user.id}">
                    <g:render template="/user/profileEdit"/>
                    <g:render template="/user/changePassword"/>
                </g:if>
                <g:else>
                    <div class="panel panel-default">
                        <div class="panel-heading">Posts</div>
                        <div class="panel-body">
                            <div class="panel-body">
                                <g:each var="resourceObj" in="${user.resources}" status="i">
                                    <g:render template="/shared/resourceGrid" model="[resourceObj: resourceObj, unreadResources:unreadResources]"/>
                                </g:each>
                            </div>
                        </div>
                    </div>
                </g:else>
            </div>
        </div>

    </div>
</body>
</html>