<div class="col-xs-5" >
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="col-xs-4 ">
                <g:img dir="images" file="userIcon.png" width="80" height="80" class="img-rounded"/>
            </div>
            <div class="col-xs-8">
                <div class="row">
                    <h4>${user.firstName} ${user.lastName} <br/> <small>@${user.firstName}</small></h4>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                       <small>Subscriptions</small> <br/>
                        <g:link action="topicsSubscribed" controller="topic">${user.subscriptions.size()}</g:link>
                    </div>
                    <div class="col-xs-6">
                        <small>Topics</small><br/>
                        <g:link action="topicsCreated" controller="topic">${user.topics.size()}</g:link>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>