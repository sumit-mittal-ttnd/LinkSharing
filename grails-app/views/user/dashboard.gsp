<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Dashboard</title>

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


        <div class="col-xs-5" >
            <div class="panel panel-default">
                <div class="panel-body">
                    <g:render template="/shared/userGrid" model="[userObj:user]"/>
                </div>
            </div>
        </div>

        %{--Unread Resources of my subscribed Topics--}%
        <div class="col-xs-7 pull-right" >
            <div class="panel panel-default">
                <div class="panel-heading">Inbox <a href="#" class="pull-right">View All</a></div>
                <div class="panel-body">
                    <div class="panel-body">
                        <g:each var="resourceObj" in="${user.resources}" status="i">
                            <g:render template="/shared/resourceGrid" model="[resourceObj: resourceObj]"/>
                        </g:each>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>

        <div class="col-xs-5" >
            <div class="panel panel-default">
                <div class="panel-heading">Subscriptions <a href="#" class="pull-right">View All</a></div>
                <div class="panel-body">
                    %{--TOPICS i am subscribed too--}%
                    <g:each var="subscribeObj" in="${user.subscriptions}" status="i">
                        <g:render template="/shared/subscriptionGrid" model="[subscribeObj: subscribeObj]"/>
                    </g:each>

                </div>
            </div>
        </div>

        <div class="col-xs-7 pull-right" >
            <div class="panel panel-default">
                <div class="panel-heading"><a>Trending topics</a></div>
                <div class="panel-body">
                    <g:each var="topicObj" in="${trendingTopics}">
                        <g:render template="/shared/topicGrid" model="[topicObj: topicObj]"/>
                    </g:each>
                </div>
            </div>
        </div>


    </div>
</div>
</body>
</html>