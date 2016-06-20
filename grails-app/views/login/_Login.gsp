<div class="col-xs-6">
    <div class="panel panel-default">
        <div class="panel-heading">Login</div>

        <div class="panel-body">
            <g:form controller="login" action="login" method="POST" class="form-horizontal">
                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class=" control-label" for="signInUserName">Email/Username *</label>
                    </div>

                    <div class="col-xs-8 ">
                        <g:textField id="signInUserName" name="userName" class="form-control"/>
                    </div>
                </div>

                <div class="form-group form-group-sm">
                    <div class="col-xs-4 ">
                        <label class="control-label" for="signinPassword">Password *</label>
                    </div>

                    <div class="col-xs-8 ">
                        <g:textField id="signinPassword" name="password" class="form-control"/>
                    </div>
                </div>

                <div class="">
                    <a aria-hidden="true" title="Forget Password" data-toggle="modal" data-target="#forgotPasswordModal">Forget Password</a>
                    <g:submitButton name="Login"  value="Login" class="pull-right col-xs-4"/>
                </div>
            </g:form>

        </div>
    </div>
</div>