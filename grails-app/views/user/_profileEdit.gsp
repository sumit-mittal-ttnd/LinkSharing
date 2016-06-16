<div class="col-xs-6 pull-right">
    <div class="panel panel-default ">
        <div class="panel-heading">Profile</div>

        <div class="panel-body">
            <g:form controller="user" action="update" method="POST" class="form-horizontal">
                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class=" control-label" for="fName">First Name *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="fName" name="firstName" class="form-control" value="${user.firstName}"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class="control-label" for="lName">Last Name *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="lName" name="lastName" class="form-control" value="${user.lastName}"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class="control-label" for="rUsername">Username *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="rUsername" name="userName" class="form-control" value="${user.userName}"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4">
                        <label class="control-label" for="photo">Photo</label>
                    </div>

                    <div class="col-xs-8">
                        <input class="col-xs-4" type="text"/>
                        %{--<input class="col-xs-8" type="file" id="photo"/>
                        <g:uploadForm name="myUpload" action="actionName" controller="controllerName">
                            <input type="file" id="photo" name="photo" class="col-xs-8" />
                        </g:uploadForm>--}%

                    </div>
                </div>
                <g:submitButton name="update"  value="Update" class="pull-right col-xs-4"/>
            </g:form>
        </div>
    </div>
</div>