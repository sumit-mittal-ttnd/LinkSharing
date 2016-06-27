<g:set var="topicCreatedBy" value="${topicObj.createdBy}"/>

<g:set var="subIdObj" value="0"></g:set>
<g:set var="seriousnessObj" value="NO"></g:set>
<g:each var="subObj" in="${topicObj.subscriptions}">
    <g:if test="${subObj.user.id == session.userId}">
        <g:set var="subIdObj" value="${subObj.id}"></g:set>
        <g:set var="seriousnessObj" value="${subObj.seriousness}"></g:set>
    </g:if>
</g:each>

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
                <br/> <small>@${topicCreatedBy.userName}</small>
                <g:if test="${session.userId && topicCreatedBy.id != session.userId}">
                    <br/>
                    <g:if test="${subIdObj=='0'}">
                        <a href="javascript:subscribe('${session.userId}', '${topicObj.id}')">Subscribe</a>
                    </g:if>
                    <g:else>
                        <a href="javascript:unsubscribe(${subIdObj})">Unsubscribe</a>
                    </g:else>
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
    <div class="col-xs-2"></div>
    <div class="col-xs-4">
        <g:if test="${subIdObj!='0'}">
            <g:select name="seriousness" from="${['SERIOUS','VERY_SERIOUS','CASUAL']}" value="${seriousnessObj}" onchange="javascript:updateSeriousness(${subIdObj}, this.value);"/>
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
<hr/>