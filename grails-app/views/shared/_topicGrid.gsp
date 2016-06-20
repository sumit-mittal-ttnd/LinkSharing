<g:set var="userObj" value="${topicObj.createdBy}"/>

    <div class="col-xs-3 ">
        <g:img dir="images" file="${userObj.photoUrl}" width="80" height="80" class="img-rounded"/>
    </div>

    <div class="col-xs-9">
        <div class="row">
            <div class="col-xs-4">
                <g:link action="showTopic" controller="login" params="[id:topicObj.id]">${topicObj.name}</g:link>
                <br/> <small>@${userObj.firstName}</small>
                %{--<br/> <g:link action="delete" controller="subscription" params="['subscription.id':subscribeObj.id]">Unsubscribe</g:link>--}%
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

    <div class="row">
        <br/>
        <div class="col-xs-2"></div>
        <div class="col-xs-4">
            <g:if test="${session.userId == userObj.id}">
                %{--<g:select name="seriousness" from="${['SERIOUS','VERY_SERIOUS','CASUAL']}" value="${subscribeObj.seriousness}"/>--}%
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
<hr/>