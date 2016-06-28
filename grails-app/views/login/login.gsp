<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Link Sharing App</title>

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

            <div class="col-xs-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Recent Shares</div>
                    <div class="panel-body">
                        <g:each var="resourceObj" in="${recentResources}">
                            <g:render template="/shared/resourceGrid" model="[resourceObj: resourceObj, unreadResources:unreadResources]"/>
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

            <g:render template="/login/Login"/>
            <g:render template="/login/Register"/>
        </div>

    </div>
</body>
</html>