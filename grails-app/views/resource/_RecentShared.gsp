<div class="col-xs-6">
    <div class="panel panel-default">
        <div class="panel-heading">Recent Shares</div>

        <div class="panel-body">

            <g:each var="resource" in="${recentResources}">
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
                <br/>
            </g:each>

        </div>
    </div>
</div>