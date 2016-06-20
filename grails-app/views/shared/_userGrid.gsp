<div class="col-xs-4 ">
    <g:img dir="images" file="${userObj.photoUrl}" width="80" height="80" class="img-rounded"/>
</div>
<div class="col-xs-8">
    <div class="row">
        <h4>${userObj.firstName} ${userObj.lastName} <br/> <small>@${userObj.firstName}</small></h4>
    </div>
    <div class="row">
        <div class="col-xs-6">
            <small>Subscriptions</small> <br/>
            <g:link action="topicsSubscribed" controller="topic">${userObj.subscriptions.size()}</g:link>
        </div>
        <div class="col-xs-6">
            <small>Topics</small><br/>
            <g:link action="topicsCreated" controller="topic">${userObj.topics.size()}</g:link>
        </div>
    </div>
</div>