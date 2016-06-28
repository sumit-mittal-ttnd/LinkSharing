package com.ttnd.linksharing

import grails.converters.JSON

class ResourceController {

    ResourceService resourceService;

    def findUnreadResourcesByUser(){
        render(view:"list", model:[resources:resourceService.findUnreadResourcesByUser(User.get(session.getAttribute("userId")), 0)])
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
        resourceService.save(params, session.getAttribute("userId"));
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