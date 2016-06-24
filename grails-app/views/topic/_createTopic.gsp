<div id="topicModal" class="modal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Topic</h4>
            </div>
            <div class="modal-body panel-body">

                <g:form controller="topic" action="save" method="POST" class="form-horizontal">
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class=" control-label" for="fName">Name* :</label>
                        </div>
                        <div class="col-xs-8">
                            <g:textField id="fName" name="name" class="form-control" placeholder="Name"/>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class="control-label" for="visibility">Visibility* :</label>
                        </div>
                        <div class="col-xs-8">
                            <select id="visibility" name="visibility" class="form-control">
                                <option value="PUBLIC">Public</option>
                                <option value="PRIVATE">Private</option>
                            </select>
                        </div>

                    </div>

                    <div class="modal-footer">
                        <button class="btn btn-primary">Save</button>
                        <button class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </g:form>


            </div>

        </div>

    </div>
</div>