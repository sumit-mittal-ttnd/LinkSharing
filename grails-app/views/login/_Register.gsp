<div class="col-xs-6 pull-right">
    <div class="panel panel-default ">
        <div class="panel-heading">Register</div>

        <div class="panel-body">
            <g:form id="registerForm" name="registerForm" controller="login" action="register" method="POST" class="form-horizontal" enctype="multipart/form-data">
                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class=" control-label" for="firstName">First Name *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="firstName" name="firstName" class="form-control" required="required"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class="control-label" for="lastName">Last Name *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="lastName" name="lastName" class="form-control" required="required"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4">
                        <label class="control-label" for="email">Email *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="email" name="email" class="form-control" required="required"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class="control-label" for="userName">Username *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:textField id="userName" name="userName" class="form-control" required="required"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4">
                        <label class=" control-label" for="password">Password *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:passwordField id="password" name="password" class="form-control" required="required"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class="  control-label" for="confirmPassword">Confirm Password *</label>
                    </div>

                    <div class="col-xs-8">
                        <g:passwordField id="confirmPassword" name="confirmPassword" class="form-control" required="required"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4">
                        <label class="control-label" for="photo">Photo</label>
                    </div>

                    <div class="col-xs-8">
                        <input type="file" class="col-xs-8" id="photo" name="photo" accept="image/*">
                    </div>
                </div>

                <g:submitButton name="Register"  value="Register" class="pull-right col-xs-4"/>

            </g:form>
        </div>
    </div>
</div>