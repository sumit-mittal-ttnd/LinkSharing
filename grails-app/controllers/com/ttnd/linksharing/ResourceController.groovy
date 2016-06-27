package com.ttnd.linksharing

import grails.converters.JSON

class ResourceController {

    ResourceService resourceService;

    def findUnreadResourcesByUser(){
        render(view:"list", model:[resources:resourceService.findUnreadResourcesByUser(User.get(session.getAttribute("userId")))])
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
            flash.error = message(code: 'Resource.link.invalid.message');
            redirect(controller: 'user', action: 'index')
            return;
        }
        resource.save(flush: true, failOnError: true);
        flash.message = message(code: 'Resource.added.successfully.message');
        redirect(controller: 'user', action: 'index')
    }

    def update(){
        resourceService.update(params);
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }

    def delete(){
        resourceService.delete(params);
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }

    def markAsRead(){
        Resource resource = Resource.get(params.get("resourceId"));
        resourceService.markAsRead(resource, User.get(session.getAttribute("userId")));
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }



}