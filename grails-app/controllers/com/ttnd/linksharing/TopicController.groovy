package com.ttnd.linksharing

import grails.converters.JSON

class TopicController {

    TopicService topicService;

    def save() {
        Topic topic = topicService.init(params, User.get(session.getAttribute("userId")));
        if(!topic.validate()){
            flash.error = message(code: 'Topic.name.duplicate.message');
        }else{
            topicService.save(topic);
            flash.message = message(code: 'Topic.save.success.message');
        }
        redirect(controller: 'user', action: 'index')
    }

    def delete(){
        topicService.delete(params);
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }

    def list(){
        User user = User.get(session.getAttribute("userId"));
        if(user.getAdmin()){
            render(view:"list", model:[topicsByUser:Topic.findAll()]);
        } else{
            flash.error = message(code: 'User.no.rights.message');
            redirect (controller: 'user', action: 'index')
        }
    }

    def topicsSubscribed(){
        List<Topic> topics = topicService.findSubscribedTopicsByUser(User.get(params.get("userId")));
        render(view:"list", model:[topicsByUser:topics]);
    }

    def sendInvite(){
        topicService.sendInvite(params,session.getAttribute("userId"));
        flash.message = message(code: 'Topic.invitation.success.message');
        redirect (controller: 'user', action: 'index');
    }

    def updateVisibility(){
        topicService.updateVisibility(params);
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }

    def update(){
        topicService.update(params);
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }


}