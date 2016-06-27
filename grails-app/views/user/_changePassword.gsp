<div class="panel panel-default ">
    <div class="panel-heading">Change Password</div>

    <div class="panel-body">
        <g:form id="changePwdForm" name="changePwdForm" controller="login" action="changePassword" method="POST" class="form-horizontal">
            <div class="form-group form-group-sm">
                <div class="col-xs-4 ">
                    <label class=" control-label" for="password">Password *</label>
                </div>

                <div class="col-xs-8">
                    <g:textField id="password" name="password" class="form-control" value="${pwd}"/>
                </div>
            </div>

            <div class="form-group form-group-sm">
                <div class="col-xs-4 ">
                    <label class="control-label" for="confirmPassword">Confirm Password *</label>
                </div>

                <div class="col-xs-8">
                    <g:textField id="confirmPassword" name="confirmPassword" class="form-control" value="${cPwd}"/>
                </div>
            </div>

            <g:submitButton name="update"  value="Update" class="pull-right col-xs-4"/>
        </g:form>
    </div>
</div>