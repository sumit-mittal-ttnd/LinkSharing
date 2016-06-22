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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.1.1/jquery.rateyo.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.1.1/jquery.rateyo.min.js"></script>
</head>

<body>


    <div class="container">
        <g:render template="/shared/header"/>

        <div class="row">

            <div class="col-xs-6">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <g:set var="topicCreatedBy" value="${resource.topic.createdBy}"/>
                        <g:set var="resourceAddedBy" value="${resource.addedBy}"/>

                        <div class="row">
                            <div class="col-xs-3 ">
                                <g:link action="showUser" controller="login" params="['userId':resourceAddedBy.id]">
                                    <tg:userImage userId="${resourceAddedBy.id}" alt="user" class="img-circle" width="100" height="100"/>
                                </g:link>
                            </div>

                            <div class="col-xs-3">
                                <p style="font-size: 12px">${resourceAddedBy.firstName} ${resourceAddedBy.lastName}
                                    <br/><span class="small text-center">@${resourceAddedBy.firstName}</span>
                                </p>
                            </div>

                            <div class="col-xs-6">
                                <g:link action="showTopic" controller="login" params="[id:resource.topic.id]" class="pull-right">${resource.topic.name}</g:link><br/>
                                <div class="small pull-right"><g:formatDate format="dd-MMM-yyyy" date="${resource.lastUpdated}"/></div><br/>
                                <div class="small pull-right" id="rateYo"></div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                ${resource.description}
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12 p-a-3">
                                %{--<a href="#"><i class="fa fa-facebook-official"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>--}%
                                <div class="pull-right">
                                    <g:if test="${session.userId}">
                                        <g:if test="${resource.instanceOf(com.ttnd.linksharing.LinkResource)}">
                                            <g:link url="${resource.url}" target="_blank" class="small">View full site</g:link>
                                        </g:if>
                                        <g:else>
                                            <g:link action="showResource" controller="login" params="['resourceId':resource.id]" class="small">Download</g:link>
                                        </g:else>
                                        <g:if test="${session.userIsAdmin=='TRUE' || session.userId == resourceAddedBy.id}">
                                            <g:link action="markAsRead" controller="resource" params="['resourceId':resource.id]" class="small">Mark as read</g:link>
                                        </g:if>
                                    </g:if>
                                </div>
                            </div>
                        </div>

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

    <script type="text/javascript">
        $(function () {
            $("#rateYo").rateYo({
                rating: ${resource.avgRating},
                starSize: 20,
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