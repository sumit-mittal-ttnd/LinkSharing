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

            <g:each var="resource" in="${topResources}">
                <div class="row">
                    <div class="col-xs-4 ">
                        <g:img dir="images" file="userIcon.png" width="100" height="100"/>
                    </div>

                    <div class="col-xs-8">
                        <div>
                            <p style="font-size: 12px">${resource.topic.createdBy.firstName} ${resource.topic.createdBy.lastName}
                                <span class="small text-center">@${resource.topic.createdBy.firstName} <g:formatDate format="dd-MMM-yyyy" date="${resource.lastUpdated}"/></span>
                                <a href="#" class="pull-right">${resource.topic.name}</a><br/>
                                ${resource.description}
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
            </g:each>

        </div>
    </div>
</div>