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
                <g:if test="${session.userId}">
                    <a class="fa fa-weixin" aria-hidden="true" title="Create Topic" style="font-size:30px;" data-toggle="modal" data-target="#topicModal"></a>&nbsp;
                    <a class="fa fa-envelope-o" aria-hidden="true" title="Send Invitation" style="font-size:30px;" data-toggle="modal" data-target="#sendInviModal"></a>&nbsp;
                    <a class="fa fa-link" aria-hidden="true" title="Share Link" style="font-size:30px;" data-toggle="modal" data-target="#shareLinkModal"></a>&nbsp;
                    <a class="fa fa-file-o" aria-hidden="true" title="Share Document" style="font-size:25px;" data-toggle="modal" data-target="#shareDocumentModal"></a>&nbsp;

                    <span class="dropdown pull-right">
                        <button class="dropdown-toggle" type="button" data-toggle="dropdown">
                            <i class="fa fa-user" aria-hidden="true"></i>&nbsp;&nbsp;${session.userFirstName}<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><g:link action="showUser" controller="login" params="[userId:session.userId]">Profile</g:link></li>
                            <g:if test="${session.userIsAdmin == 'TRUE'}">
                                <li><g:link action="list" controller="user">Users</g:link></li>
                                <li><g:link action="list" controller="topic">Topics</g:link></li>
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