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
    <div class="container">

        <g:render template="/shared/header"/>


        <div class="row">

            <div class="col-xs-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Recent Shares</div>
                    <div class="panel-body">
                        <g:each var="resourceObj" in="${recentResources}">
                            <g:render template="/shared/resourceGrid" model="[resourceObj: resourceObj]"/>
                            <br/>
                        </g:each>
                    </div>
                </div>
            </div>

            <g:render template="/login/Login"/>

            <g:render template="/login/Register"/>

            <div class="col-xs-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-9"><span>Top Posts</span></div>
                            <div class="col-xs-3 pull-right">
                                <select class="dropdown">
                                    <option>Today</option>
                                    <option>1 Week</option>
                                    <option>1 Month</option>
                                    <option>1 Year</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <g:each var="resourceObj" in="${topResources}">
                            <g:render template="/shared/resourceGrid" model="[resourceObj: resourceObj]"/>
                            <br/>
                        </g:each>
                    </div>
                </div>
            </div>

        </div>

    </div>
</body>
</html>