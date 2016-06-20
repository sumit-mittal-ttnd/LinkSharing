<div id="shareDocumentModal" class="modal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Document</h4>
            </div>
            <div class="modal-body panel-body">

                <g:form controller="resource" action="save" method="POST" class="form-horizontal">
                    <g:hiddenField name="resourceType" value="documentResource"/>
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4">
                            <label class="control-label" for="photo">Document* :</label>
                        </div>
                        <div class="col-xs-8">
                            <input class="" type="file" id="photo">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class=" control-label" for="description">Description* :</label>
                        </div>
                        <div class="col-xs-8">
                            <g:textArea id="description" name="description" class="form-control"/>
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
                        <button class="col-xs-3 pull-right">Share</button>
                        <button type="button" class="col-xs-3 pull-right" data-dismiss="modal">Close</button>
                    </div>
                </g:form>


            </div>

        </div>

    </div>
</div>