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

        <g:if test="${session.userId}">
            <g:render template="/user/profileEdit"/>
        </g:if>
        <g:else>
            hiii
        </g:else>

        <div class="col-xs-5" >
            <div class="panel panel-default">
                <div class="panel-heading"><a>Topics</a></div>
                <div class="panel-body">
                    <g:each var="topicObj" in="${topics}">
                        <g:render template="/shared/topicGrid" model="[topicObj: topicObj]"/>
                    </g:each>
                </div>
            </div>
        </div>

        <g:render template="/user/changePassword"/>

    </div>
</div>
</body>
</html>