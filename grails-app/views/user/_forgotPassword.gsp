<div id="forgotPasswordModal" class="modal" role="dialog">
    <div class="modal-dialog">
        <div class="panel panel-default ">
            <div class="panel-heading">Forgot Password</div>

            <div class="panel-body">
                <g:form id="forgotPasswordForm" name="forgotPasswordForm" controller="login" action="forgotPassword" method="POST" class="form-horizontal">
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4">
                            <label class="control-label" for="email">Email *</label>
                        </div>

                        <div class="col-xs-8">
                            <g:textField id="email" name="email" class="form-control"/>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button class="col-xs-3 pull-right">Submit</button>
                        <button type="button" class="col-xs-3 pull-right" data-dismiss="modal">Close</button>
                    </div>
                </g:form>
            </div>
        </div>
    </div>
</div>