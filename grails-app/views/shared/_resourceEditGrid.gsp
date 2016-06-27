<div id="resourceEdit" class="modal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit Resource</h4>
            </div>
            <div class="modal-body panel-body">

                <g:form id="resourceEditForm" name="resourceEditForm" method="POST" class="form-horizontal" onsubmit="return false">
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class=" control-label" for="editResourceDesc">Description* :</label>
                        </div>
                        <div class="col-xs-8">
                            <g:hiddenField id="editResourceId" name="editResourceId" class="form-control" value=""/>
                            <g:textArea id="editResourceDesc" name="editResourceDesc" class="form-control" placeholder="Description" value="" required="required"/>
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