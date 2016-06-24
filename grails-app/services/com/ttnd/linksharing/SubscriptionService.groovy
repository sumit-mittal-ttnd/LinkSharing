package com.ttnd.linksharing

class SubscriptionService {

    void subscribe(User user, Topic topic){
        Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Subscription.Seriousness.SERIOUS);
        subscription.save(flush: true, failOnError: true);
    }

    void unsubscribe(Map params){
        Subscription subscription = Subscription.get(params.get("subscriptionId"));
        subscription.delete(flush: true)
    }

    void updateSeriousness(Map params){
        Subscription subscription = Subscription.get(params.get("subscriptionId"));
        String seriousness = params.get("seriousness");
        if(seriousness.equals("SERIOUS")) subscription.setSeriousness(Subscription.Seriousness.SERIOUS)
        else if(seriousness.equals("VERY_SERIOUS")) subscription.setSeriousness(Subscription.Seriousness.VERY_SERIOUS)
        else subscription.setSeriousness(Subscription.Seriousness.CASUAL)
        subscription.merge(flush: true, failOnError: true);
    }

}