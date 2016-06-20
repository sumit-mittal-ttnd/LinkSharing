<div id="sendInviModal" class="modal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>
            <div class="modal-body panel-body">
            <g:form controller="topic" action="sendInvite" method="POST" class="form-horizontal">

                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class=" control-label" for="email">Email* :</label>
                        </div>
                        <div class="col-xs-8">
                            <g:textField id="email" name="email" class="form-control" placeholder="Email"/>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class="control-label" for="topicId">Topic* :</label>
                        </div>
                        <div class="col-xs-8">
                            <g:select id="topicId"
                                      name="topicId"
                                      from="${topicsList}"
                                      optionKey="id"
                                      optionValue="name"
                                      class="form-control"/>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button class="col-xs-3 pull-right">Invite</button>
                        <button type="button" class="col-xs-3 pull-right" data-dismiss="modal">Close</button>
                    </div>
            </g:form>
            </div>

        </div>

    </div>
</div>