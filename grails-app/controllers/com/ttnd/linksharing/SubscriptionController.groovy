package com.ttnd.linksharing

import grails.converters.JSON

class SubscriptionController {

    SubscriptionService subscriptionService;


// ============================ CHECKED =============================

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










    /*def update() {
        Subscription subscription = new Subscription(params);
        if (!subscription.validate()){
            flash.error = "Not a valid request";
        } else{
            flash.message= "Successfully Updated";
            subscriptionService.update(subscription);
        }
    }*/



}