<div id="topicModal" class="modal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Topic</h4>
            </div>
            <div class="modal-body panel-body">

                <form class="form-horizontal">
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class=" control-label" for="fName">Name* :</label>
                        </div>
                        <div class="col-xs-8">
                            <input class="form-control" placeholder="Name" type="text" id="fName"/>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <div class="col-xs-4 ">
                            <label class="control-label" for="lName">Visibility* :</label>
                        </div>
                        <div class="col-xs-8">
                            <select id="lName" class="form-control">
                                <option>Public</option>
                                <option>Friends</option>
                                <option>Only Me</option>
                            </select>
                        </div>

                    </div>

                    <div>
                        <button class="col-xs-3 pull-right">Cancel</button>
                        <button class="col-xs-3 pull-right">Save</button>
                    </div>
                </form>


            </div>

        </div>

    </div>
</div>