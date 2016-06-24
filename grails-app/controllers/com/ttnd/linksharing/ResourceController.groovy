package com.ttnd.linksharing

import grails.converters.JSON

class ResourceController {

    ResourceService resourceService;

    def findUnreadResourcesByUser(){
        render(view:"list", model:[resources:resourceService.findUnreadResourcesByUser(User.get(session.getAttribute("userId")))])
    }

    def delete(){
        User loggedInUser = User.get(session.getAttribute("userId"));
        Resource resource = Resource.load(params.get("id"));
        User addedByUser = resource.getAddedBy();
        if(loggedInUser.equals(addedByUser))
            resource.delete(flush: true);
        else
            flash.error = message(code: 'Resource.delete.error.message');
        redirect(controller: 'login', action: 'index')
    }

    def list(){
        User user = User.get(session.getAttribute("userId"));
        if(user.getAdmin()){
            render(view:"list", model:[resources:Resource.findAll()]);
        } else{
            flash.error = message(code: 'User.no.rights.message');
            redirect (controller: 'user', action: 'index')
        }
    }

    def save(){
        Resource resource;
        if(params.get("resourceType") == "linkResource")
            resource = new LinkResource(params);
        else{
            resource = new DocumentResource(params);
            if(params.document.size>0){
                resourceService.uploadDocumentResource(resource, params);
            }
        }
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

    def markAsRead(){
        Resource resource = Resource.get(params.get("resourceId"));
        resourceService.markAsRead(resource, User.get(session.getAttribute("userId")));
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }



}