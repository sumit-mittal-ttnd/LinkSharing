package com.ttnd.linksharing

class ResourceController {

    def index() { }

    def delete(){
        def resourceId = params.get("id");
        Resource resource = Resource.load(resourceId);
        if(resource == null){
            flash.message = "Resource Not Found !!!!";
            redirect(controller: 'login', action: 'index')
        }else{
            User loggedInUser = session.getAttribute("user");
            User addedByUser = resource.getAddedBy();
            if(!loggedInUser.equals(addedByUser)){
                flash.message = "You can't delete resources added by others !!!!";
                redirect(controller: 'login', action: 'index')
            }else{
                resource.delete(flush: true);
                render "success";
            }
        }
    }





}