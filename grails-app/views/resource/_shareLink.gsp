<div id="shareLinkModal" class="modal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Link</h4>
            </div>
            <div class="modal-body panel-body">

                <g:form id="shareLinkForm" name="shareLinkForm" controller="resource" action="save" method="POST" class="form-horizontal">
                    <g:hiddenField name="resourceType" value="linkResource"/>
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class=" control-label" for="url">Link* :</label>
                        </div>
                        <div class="col-xs-8 ">
                            <g:textField id="url" name="url" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class="control-label" for="description">Description* :</label>
                        </div>
                        <div class="col-xs-8 ">
                            <g:textArea id="description" name="description" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class="control-label" for="topicId">Topic* :</label>
                        </div>
                        <div class="col-xs-8 ">
                            <g:select id="topicId"
                                      name="topicId"
                                      from="${subscribedTopics}"
                                      optionKey="id"
                                      optionValue="name"
                                      class="form-control"/>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button class="btn btn-primary">Share</button>
                        <button class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </g:form>


            </div>

        </div>

    </div>
</div>