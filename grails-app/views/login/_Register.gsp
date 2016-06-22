<div class="col-xs-6 pull-right">
    <div class="panel panel-default ">
        <div class="panel-heading">Register</div>

        <div class="panel-body">
            <g:form controller="login" action="register" method="POST" class="form-horizontal" enctype="multipart/form-data">
                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class=" control-label" for="fName">First Name *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="fName" name="firstName" class="form-control"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class="control-label" for="lName">Last Name *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="lName" name="lastName" class="form-control"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4">
                        <label class="control-label" for="email">Email *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="email" name="email" class="form-control"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class="control-label" for="rUsername">Username *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="rUsername" name="userName" class="form-control"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4">
                        <label class=" control-label" for="rPassword">Password *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="rPassword" name="password" class="form-control"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class="  control-label" for="cPassword">Confirm Password *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="cPassword" name="confirmPassword" class="form-control"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4">
                        <label class="control-label" for="photo">Photo</label>
                    </div>

                    <div class="col-xs-8">
                        <input type="file" class="col-xs-8" id="photo" name="photo">
                    </div>
                </div>

                <g:submitButton name="Register"  value="Register" class="pull-right col-xs-4"/>

            </g:form>
        </div>
    </div>
</div>