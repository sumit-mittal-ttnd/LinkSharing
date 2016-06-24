package com.ttnd.linksharing

import grails.converters.JSON

class SubscriptionController {

    SubscriptionService subscriptionService;

    def subscribe(){
        subscriptionService.subscribe(User.load(params.get("userId")), Topic.load(params.get("topicId")));
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }

    def unsubscribe(){
        subscriptionService.unsubscribe(params);
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }

    def updateSeriousness(){
        subscriptionService.updateSeriousness(params);
        Map map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }


}