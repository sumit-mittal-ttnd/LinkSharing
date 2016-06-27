<div id="topicEdit" class="modal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit Topic</h4>
            </div>
            <div class="modal-body panel-body">

                <g:form method="POST" class="form-horizontal" onsubmit="return editTopicPost();">
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class=" control-label" for="editTopicName">Name* :</label>
                        </div>
                        <div class="col-xs-8">
                            <g:hiddenField id="editTopicId" name="editTopicId" class="form-control" value=""/>
                            <g:textField id="editTopicName" name="editTopicName" class="form-control" placeholder="Topic Name" required="required"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" name="update">Update</button>
                        <button class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </g:form>

            </div>
        </div>
    </div>
</div>