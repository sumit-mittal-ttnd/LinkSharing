<div class="row">
    <div class=" panel panel-default">
        <div class="panel-body">

            <div class="col-xs-6">
                <h3><g:link action="index" controller="login">Link Sharing</g:link></h3>
            </div>

            <div class="col-xs-3 ">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
                    <input type="text" class="form-control" placeholder="Search" name="q">
                </div>
            </div>

            <div class="col-xs-3">
                %{--<a href="javascript:showDialog('createTopicDiv');"><i class="fa fa-weixin" aria-hidden="true" title="Create Topic"></i></a>--}%&nbsp;

                <g:if test="${session.userId}">
                    <a class="fa fa-weixin" aria-hidden="true" title="Create Topic" data-toggle="modal" data-target="#topicModal"></a>
                    <a class="fa fa-envelope-o" aria-hidden="true" title="Send Invitation" data-toggle="modal" data-target="#sendInviModal"></a>
                    <a class="fa fa-link" aria-hidden="true" title="Share Link" data-toggle="modal" data-target="#shareLinkModal"></a>
                    <a class="fa fa-file-o" aria-hidden="true" title="Share Document" data-toggle="modal" data-target="#shareDocumentModal"></a>

                    <span class="dropdown">
                        <button class="dropdown-toggle" type="button" data-toggle="dropdown">
                            <i class="fa fa-user" aria-hidden="true"></i>&nbsp;&nbsp;${userFirstName}<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><g:link action="edit" controller="user">Profile</g:link></li>
                            <g:if test="${session.userIsAdmin == 'TRUE'}">
                                <li><g:link action="list" controller="user">Users</g:link></li>
                                <li><a href="#">Topics</a></li>
                                <li><a href="#">Posts</a></li>
                            </g:if>
                            <li><g:link action="logout" controller="login">Logout</g:link></li>
                        </ul>
                    </span>
                </g:if>
            </div>

        </div>
    </div>


</div>