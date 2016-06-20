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
                <div class="panel-body">
                    <g:render template="/shared/resourceGrid" model="[resourceObj: resource]"/>
                </div>
            </div>
        </div>

        <div class="col-xs-6 pull-right" >
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