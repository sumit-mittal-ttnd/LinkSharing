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
    <asset:stylesheet src="jquery.rateyo.min.css"/>
    <asset:javascript src="jquery.rateyo.min.js"/>
</head>
<body>

    <div class="container bodyMinHeight">

        <g:render template="/shared/header"/>

        <div class="row">

            <div class="col-xs-6">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <g:set var="yourRating" value="0"></g:set>
                        <g:each var="resRateObj" in="${resource.resourceRatings}">
                            <g:if test="${resRateObj.user.id == session.userId}">
                                <g:set var="yourRating" value="${resRateObj.score}"></g:set>
                            </g:if>
                        </g:each>
                        <g:set var="topicCreatedBy" value="${resource.topic.createdBy}"/>
                        <g:set var="resourceAddedBy" value="${resource.addedBy}"/>

                        <div class="row">
                            <div class="col-xs-3 ">
                                <g:link action="showUser" controller="login" params="['userId':resourceAddedBy.id]">
                                    <tg:userImage userId="${resourceAddedBy.id}" alt="user" class="img-circle" width="100" height="100"/>
                                </g:link>
                            </div>

                            <div class="col-xs-3">
                                <p style="font-size: 12px">${resourceAddedBy.name}
                                    <br/><span class="small text-center">@${resourceAddedBy.userName}</span>
                                </p>
                            </div>

                            <div class="col-xs-6">
                                <g:link action="showTopic" controller="login" params="[id:resource.topic.id]" class="pull-right">${resource.topic.name}</g:link><br/>
                                <div class="small pull-right"><g:formatDate format="dd-MMM-yyyy" date="${resource.lastUpdated}"/></div><br/>
                                <div class="small pull-right" id="rateYo"></div><br/>
                                <g:if test="${yourRating != "0"}">
                                    <div class="col-xs-12">
                                        <div class="small pull-right">You rated as ${yourRating} </div>
                                    </div>
                                </g:if>
                            </div>
                        </div>

                        <div class="panel-body row">
                            <div class="col-xs-12" id="resDescDiv">${resource.description}</div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12 p-a-3">
                                <a href="#"><i class="fa fa-facebook-official"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                                <div class="pull-right">
                                    <g:if test="${(session.userId == resourceAddedBy.id) || (session.userIsAdmin=='TRUE')}">
                                        <a class="fa fa-pencil-square-o" aria-hidden="true" title="Edit Resource" data-toggle="modal" data-target="#resourceEdit" onclick="editResourceGet('${resource.id}');"></a>
                                        <a href="javascript:deleteResource('${resource.id}')"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </g:if>
                                    <g:if test="${resource.instanceOf(com.ttnd.linksharing.LinkResource)}">
                                        <g:link url="${resource.url}" target="_blank" class="small">View full site</g:link>
                                    </g:if>
                                    <g:else>
                                        <g:link action="downloadResource" controller="login" params="['resourceId':resource.id]" class="small">Download</g:link>
                                    </g:else>

                                    <g:if test="${(session.userId && unreadResources.contains(resource))}">
                                        <a href="javascript:markAsRead(${resource.id})" class="small">Mark as read</a>
                                    </g:if>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>


            <g:if test="${session.userId}">
                <div class="col-xs-6 pull-right" >
                    <div class="panel panel-default">
                        <div class="panel-heading">Trending topics
                        <g:if test="${trendingTopics.size()>0}">
                            <g:link action="findTrendingTopicsByUser" controller="login" class="pull-right">View All</g:link>
                        </g:if>
                        </div>
                        <div class="panel-body">
                            <g:each var="topicObj" in="${trendingTopics}">
                                <g:render template="/shared/topicGrid" model="[topicObj: topicObj]"/>
                            </g:each>
                        </div>
                    </div>
                </div>
            </g:if>
            <g:else>
                <g:render template="/login/Login"/>
                <g:render template="/login/Register"/>
            </g:else>






        </div>
    </div>

    <script type="text/javascript">
        $(function () {
            $("#rateYo").rateYo({
                rating: ${resource.avgRating},
                starSize: 10,
                fullStar: true,
                onSet: function (rating, rateYoInstance) {
                    var sessionUserId = '${session.userId}';
                    if(sessionUserId == '')
                        alert("Please Login to give rating !!!");
                    else{
                        $.ajax({
                            url: "/resourceRating/rate",
                            type:"post",
                            dataType: 'json',
                            data:'rating='+rating+"&resourceId="+${resource.id},
                            success: function(data) {
                                if(data.response == "success")
                                    alert("Rating has been saved successfully !!!");
                                else if(data.response == "subscribeFirst")
                                    alert("Please subscribe first to rate it!!!");
                                else
                                    alert("Some error has been occurred !!!");
                                location.reload();
                            }
                        });
                    }
                }
            });
        });
    </script>
</body>
</html>