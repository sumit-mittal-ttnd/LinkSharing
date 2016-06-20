<g:set var="topicCreatedBy" value="${resourceObj.topic.createdBy}"/>
<g:set var="resourceAddedBy" value="${resourceObj.addedBy}"/>

<div class="row">
    <div class="col-xs-3 ">
        <g:link action="showUser" controller="login" params="['userId':resourceAddedBy.id]">
            <g:img dir="images" file="${resourceAddedBy.photoUrl}" width="100" height="100"/>
        </g:link>
    </div>

    <div class="col-xs-9">
        <div>
            <p style="font-size: 12px">${topicCreatedBy.firstName} ${topicCreatedBy.lastName}
                <span class="small text-center">@${topicCreatedBy.firstName} <g:formatDate format="dd-MMM-yyyy" date="${resourceObj.lastUpdated}"/></span>
                <a href="#" class="pull-right">${resourceObj.topic.name}</a><br/>
                ${resourceObj.description}
            </p>
        </div>

        <div class="">
            <a href="#"><i class="fa fa-facebook-official"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-google-plus"></i></a>
            <div class="pull-right">
                <a href="#" class="tab-space"><small>Download</small></a>
                <a href="#" class="tab-space"><small>View full site</small></a>
                <a href="#" class="tab-space"><small>Mark as read</small></a>
                <g:link action="showResource" controller="login" params="['resourceId':resourceObj.id]">View Post</g:link>
            </div>
        </div>
    </div>
</div>
<hr>