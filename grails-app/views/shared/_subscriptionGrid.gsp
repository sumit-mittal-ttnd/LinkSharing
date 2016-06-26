<g:set var="topicObj" value="${subscribeObj.topic}"/>
<g:set var="topicCreatedBy" value="${topicObj.createdBy}"/>

<div class="row">
    <div class="col-xs-3 ">
        <g:link action="showUser" controller="login" params="['userId':topicCreatedBy.id]">
            <tg:userImage userId="${topicCreatedBy.id}" alt="user" class="img-circle" width="100" height="100"/>
        </g:link>
    </div>
    <div class="col-xs-9">
        <div class="row">
            <div class="col-xs-4">
                <g:link action="showTopic" controller="login" params="[id:topicObj.id]">${topicObj.name}</g:link>
                <br/> <small>${topicCreatedBy.firstName}</small>
                <g:if test="${(session.userId != topicCreatedBy.id) && (session.userId == subscribeObj.user.id)}">
                    <br/><a href="javascript:unsubscribe(${subscribeObj.id})">Unsubscribe</a>
                </g:if>
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
        <g:if test="${session.userId == subscribeObj.user.id}">
            <g:select name="seriousness" from="${['SERIOUS','VERY_SERIOUS','CASUAL']}" value="${subscribeObj.seriousness}" onchange="javascript:updateSeriousness(${subscribeObj.id}, this.value);"/>
        </g:if>
    </div>
    <div class="col-xs-3">
        <g:if test="${session.userId == topicCreatedBy.id}">
            <g:select name="visibility" from="${['PUBLIC','PRIVATE']}" value="${topicObj.visibility}" onchange="javascript:updateVisibility(${topicObj.id}, this.value);"/>
        </g:if>
    </div>
    <div class="col-xs-3">
        <g:if test="${session.userId == topicCreatedBy.id}">
            <a class="fa fa-envelope-o" aria-hidden="true" title="Send Invitation" data-toggle="modal" data-target="#sendInviModal"></a>
            <a class="fa fa-pencil-square-o" aria-hidden="true" title="Edit Topic" data-toggle="modal" data-target="#topicEdit" onclick="editTopicGet('${topicObj.id}','${topicObj.name}');"></a>
            <a href="javascript:deleteTopic('${topicObj.id}')"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
        </g:if>
    </div>
</div>
<hr>