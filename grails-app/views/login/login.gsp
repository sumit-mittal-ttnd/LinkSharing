<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Assignment 1</title>

    <style>
    .tab-space {
        padding-left: 10px
    }
    </style>
</head>

<body>
<div class="container">

    <div class="row">
        <div class=" panel panel-default">
            <div class="panel-body">
                <div class="col-xs-9">
                    <h3><a href="#">Link Sharing</a></h3>
                </div>

                <div class="col-xs-3 ">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
                        <input type="text" class="form-control" placeholder="Search" name="q">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-6">
            <div class="panel panel-default">
                <div class="panel-heading">Recent Shares</div>

                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-4 ">
                            <img height="100" width="100" src="images/userIcon.png" class="img-rounded">
                        </div>

                        <div class="col-xs-8">
                            <div>
                                <p style="font-size: 12px">Sumit Mittal  <span
                                        class="small text-center">@sumit 21 Jul 2014</span>           <a href="#"
                                                                                                         class="pull-right">Grails</a><br/>
                                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
                                </p>

                            </div>

                            <div class="">
                                <a href="#"><i class="fa fa-facebook-official"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>

                                <div class="pull-right"><a href="#">View post</a></div>
                            </div>
                        </div>
                    </div>
                    <br/>

                    <div class="row">
                        <div class="col-xs-4 ">
                            <img height="100" width="100" src="images/userIcon.png" class="img-rounded">
                        </div>

                        <div class="col-xs-8">
                            <div>
                                <p style="font-size: 12px">Sumit Mittal  <span
                                        class="small text-center">@sumit 21 Jul 2014</span>           <a href="#"
                                                                                                         class="pull-right">Grails</a><br/>
                                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
                                </p>
                            </div>

                            <div class="">
                                <a href="#"><i class="fa fa-facebook-official"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>

                                <div class="pull-right"><a href="#">View post</a></div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="col-xs-6">
            <div class="panel panel-default">
                <div class="panel-heading">Login</div>

                <div class="panel-body">
                    <form class="form-horizontal">
                        <div class="form-group form-group-sm">
                            <div class="col-xs-4 ">
                                <label class=" control-label" for="Username">Email/Username *</label>
                            </div>

                            <div class="col-xs-8 ">
                                <input class="form-control" type="text" id="Username">
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                            <div class="col-xs-4 ">
                                <label class="control-label" for="Password">Password *</label>
                            </div>

                            <div class="col-xs-8 ">
                                <input class="form-control" type="password" id="Password">
                            </div>
                        </div>

                        <div class="">
                            <a class="col-xs-4" href="#">Forget Password</a>
                            <button class="pull-right col-xs-3">Login</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>

        <div class="col-xs-6 pull-right">
            <div class="panel panel-default ">
                <div class="panel-heading">Register</div>

                <div class="panel-body">
                    <form class="form-horizontal">
                        <div class="form-group form-group-sm">
                            <div class="col-xs-4 ">
                                <label class=" control-label" for="fName">First Name *</label>
                            </div>

                            <div class="col-xs-8">
                                <input class="form-control" type="text" id="fName">
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                            <div class="col-xs-4 ">
                                <label class="control-label" for="lName">Last Name *</label>
                            </div>

                            <div class="col-xs-8">
                                <input class="form-control" type="text" id="lName">
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                            <div class="col-xs-4">
                                <label class="control-label" for="email">Email *</label>
                            </div>

                            <div class="col-xs-8">
                                <input class="form-control" type="text" id="email">
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                            <div class="col-xs-4 ">
                                <label class="control-label" for="rUsername">Username *</label>
                            </div>

                            <div class="col-xs-8">
                                <input class="form-control" type="text" id="rUsername">
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                            <div class="col-xs-4">
                                <label class=" control-label" for="rPassword">Password *</label>
                            </div>

                            <div class="col-xs-8">
                                <input class="form-control" type="text" id="rPassword">
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                            <div class="col-xs-4 ">
                                <label class="  control-label" for="cPassword">Confirm Password *</label>
                            </div>

                            <div class="col-xs-8">
                                <input class="form-control" type="text" id="cPassword">
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                            <div class="col-xs-4">
                                <label class="control-label" for="photo">Photo</label>
                            </div>

                            <div class="col-xs-8">
                                <input class="col-xs-4" type="text"/>
                                <input class="col-xs-8" type="file" id="photo"/>
                            </div>
                        </div>

                        <div>
                            <button class="pull-right col-xs-4">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-xs-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-9"><span>Top posts</span></div>

                        <div class="col-xs-3 pull-right">
                            <select class="dropdown">
                                <option>Today</option>
                                <option>1 Week</option>
                                <option>1 Month</option>
                                <option>1 Year</option>
                            </select>
                        </div>
                    </div>

                </div>

                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-4 ">
                            <img height="100" width="100" src="images/userIcon.png" class="img-rounded">
                        </div>

                        <div class="col-xs-8">
                            <div>
                                <p style="font-size: 12px">Sumit Mittal  <span
                                        class="small text-center">@sumit 21 Jul 2014</span>           <a href="#"
                                                                                                         class="pull-right">Grails</a><br/>
                                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
                                </p>
                            </div>

                            <div class="">
                                <a href="#"><i class="fa fa-facebook-official"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>

                                <div class="pull-right"><a href="#">View post</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>