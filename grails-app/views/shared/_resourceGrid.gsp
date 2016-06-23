<g:set var="topicCreatedBy" value="${resourceObj.topic.createdBy}"/>
<g:set var="resourceAddedBy" value="${resourceObj.addedBy}"/>

<div class="row">
    <div class="col-xs-3 ">
        <g:link action="showUser" controller="login" params="['userId':resourceAddedBy.id]">
            <tg:userImage userId="${resourceAddedBy.id}" alt="user" class="img-circle" width="100" height="100"/>
        </g:link>
    </div>

    <div class="col-xs-9">
        <div>
            <p style="font-size: 12px">${resourceAddedBy.firstName} ${resourceAddedBy.lastName}
                <span class="small text-center">@${resourceAddedBy.firstName} <g:formatDate format="dd-MMM-yyyy" date="${resourceObj.lastUpdated}"/></span>
                <g:link action="showTopic" controller="login" params="[id:resourceObj.topic.id]" class="pull-right">${resourceObj.topic.name}</g:link><br/>
                ${resourceObj.description}
            </p>
        </div>

        <div class="">
            <a href="#"><i class="fa fa-facebook-official"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-google-plus"></i></a>
            <div class="pull-right">
                <g:if test="${resourceObj.instanceOf(com.ttnd.linksharing.LinkResource)}">
                    <g:link url="${resourceObj.url}" target="_blank" class="small">View full site</g:link>
                </g:if>
                <g:else>
                    <g:link action="downloadResource" controller="login" params="['resourceId':resourceObj.id]" class="small">Download</g:link>
                </g:else>

                <g:if test="${session.userId}">

                    %{-- to check that i have suisbscribed that topic--}%
                    <g:set var="isSubscribed" value="FALSE" />
                    <g:each var="subObj" in="${resourceObj.topic.subscriptions}">
                        <g:if test="${subObj.user.id == session.userId}">
                            <g:set var="isSubscribed" value="TRUE" />
                        </g:if>
                    </g:each>

                    %{-- to check that i havn't read that object earlier--}%
                    <g:set var="isResourceUnRead" value="TRUE" />
                    <g:each var="resReadingObj" in="${resourceObj.readingItems}">
                        <g:if test="${resReadingObj.user.id == session.userId}">
                            <g:set var="isResourceUnRead" value="FALSE" />
                        </g:if>
                    </g:each>

                    <g:if test="${isSubscribed == 'TRUE' && isResourceUnRead == 'TRUE'}">
                        <a href="javascript:markAsRead(${resourceObj.id})" class="small">Mark as read</a>
                    </g:if>
                </g:if>

                <g:link action="showResource" controller="login" params="['resourceId':resourceObj.id]" class="small">View Post</g:link>
            </div>
        </div>
    </div>
</div>
<hr>