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
            User loggedInUser = User.get(session.getAttribute("userId"));
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

    def save(){
        Resource resource;
        if(params.get("resourceType") == "linkResource")
            resource = new LinkResource(params);
        else
            resource = new DocumentResource(params);

        resource.setAddedBy(User.get(session.getAttribute("userId")));
        resource.setTopic(Topic.get(params.get("topicId")));

        if(!resource.validate()){
            flash.error = message(code: 'Resource.uploaded.invalid.message');
            redirect(controller: 'user', action: 'index')
            return;
        }

        resource.save(flush: true, failOnError: true);
        flash.message = message(code: 'Resource.added.successfully.message');
        redirect(controller: 'user', action: 'index')
    }

    def update(){
        Resource resource;
        if(params.get("resourceType") == "linkResource")
            resource = new LinkResource(params);
        else
            resource = new DocumentResource(params);

        resource.setId(params.get("resourceId"));
        resource.setTopic(Topic.get(params.get("topicId")));
        resource.setAddedBy(User.get(session.getAttribute("userId")));

        if(resource.hasErrors()){
            flash.error = message(code: 'Resource.invalid.message');
            redirect(controller: 'login', action: 'index')
        }

        resource.merge(flush: true, failOnError: true);
        flash.message = message(code: 'Resource.updated.successfully.message');
        redirect(controller: 'user', action: 'index')
    }



}