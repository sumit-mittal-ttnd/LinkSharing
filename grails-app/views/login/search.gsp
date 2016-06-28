<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Searched Results</title>

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

            <div class="col-xs-5">
                <div class="panel panel-default">
                    <div class="panel-heading">Trending topics
                        <g:if test="${trendingTopics.size()>0}">
                            <g:link action="findTrendingTopicsByUser" controller="login" class="pull-right">View All</g:link>
                        </g:if>
                    </div>
                    <div class="panel-body">
                        <g:each var="topicObj" in="${trendingTopics}">
                            <g:render template="/shared/topicGrid" model="[topicObj: topicObj]"/>
                            <br/>
                        </g:each>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">Top Posts
                        <g:if test="${topResources.size()>0}">
                            <g:link controller="login" action="findTopResources" class="pull-right">View All</g:link>
                        </g:if>
                    </div>
                    <div class="panel-body">
                        <g:each var="resourceObj" in="${topResources}">
                            <g:render template="/shared/resourceGrid" model="[resourceObj: resourceObj, unreadResources:unreadResources]"/>
                            <br/>
                        </g:each>
                    </div>
                </div>
            </div>

            <div class="col-xs-7 pull-right" >
                <div class="panel panel-default">
                    <div class="panel-heading">Search for "${searchValue}"
                        <g:if test="${searchedResources.size()>0}">
                            <g:link controller="login" action="findAllSearchedResource" class="pull-right" params="[searchValue:searchValue]">View All</g:link>
                        </g:if>
                    </div>
                    <div class="panel-body">
                        <g:each var="resourceObj" in="${searchedResources}">
                            <g:render template="/shared/resourceGrid" model="[resourceObj: resourceObj, unreadResources:unreadResources]"/>
                            <br/>
                        </g:each>
                    </div>
                </div>
            </div>

        </div>

    </div>
</body>
</html>