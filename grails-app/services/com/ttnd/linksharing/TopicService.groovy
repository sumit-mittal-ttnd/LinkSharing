package com.ttnd.linksharing

class TopicService {

    SubscriptionService subscriptionService;

    Topic init(Map params, User user){
        Topic topic = new Topic(params);
        if(params.get("visibility").equals("PUBLIC")) topic.setVisibility(Topic.Visibility.PUBLIC)
        else topic.setVisibility(Topic.Visibility.PRIVATE)
        topic.setCreatedBy(user);
        return topic;
    }

    void create(Topic topic) {
        topic.save(flush: true, failOnError: true);
        /*Topic.withNewSession {session ->
            subscriptionService.subscribeTopic(topic, topic.getCreatedBy(), Subscription.Seriousness.VERY_SERIOUS);
        }*/
    }




}