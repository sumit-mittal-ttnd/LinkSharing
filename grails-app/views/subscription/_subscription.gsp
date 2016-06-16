<div class="col-xs-5" >
    <div class="panel panel-default">
        <div class="panel-heading">Subscriptions <a href="#" class="pull-right">View All</a></div>
        <div class="panel-body">

            <g:each var="subscribeObj" in="${user.subscriptions}" status="i">
                <g:set var="topicObj" value="${subscribeObj.topic}"/>
                <g:set var="userObj" value="${subscribeObj.user}"/>
                <div class="row">
                    <div class="row">
                        <div class="col-xs-3 ">
                            <g:img dir="images" file="userIcon.png" width="80" height="80" class="img-rounded"/>
                        </div>
                        <div class="col-xs-9">
                            <div class="row">
                                <div class="col-xs-4">
                                    <a href="#">${topicObj.name}</a>
                                    <br/> <small>${userObj.firstName}</small>
                                    <br/> <g:link action="delete" controller="subscription" params="['subscription.id':subscribeObj.id]">Unsubscribe</g:link>

                                </div>
                                <div class="col-xs-4">
                                    <br/><small>Subscription</small> <br/>
                                    ${topicObj.subscriptions.size()}
                                </div>
                                <div class="col-xs-4">
                                    <br/><small>Posts</small><br/>
                                    ${topicObj.resources.size()}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <br/>
                        <div class="col-xs-2"></div>
                        <div class="col-xs-4">
                            <g:if test="${session.userId == userObj.id}">
                                <g:select name="seriousness" from="${['SERIOUS','VERY_SERIOUS','CASUAL']}" value="${subscribeObj.seriousness}"/>
                            </g:if>
                        </div>
                        <div class="col-xs-3">
                            <g:if test="${session.userId == userObj.id}">
                                <g:select name="visibility" from="${['PUBLIC','PRIVATE']}" value="${topicObj.visibility}"/>
                            </g:if>
                        </div>
                        <div class="col-xs-3">
                            <a href="#"><i class="fa fa-envelope-o" aria-hidden="true"></i></a>
                            <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                            <a href="#"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                        </div>
                    </div>
                </div>
            </g:each>

        </div>
    </div>
</div>