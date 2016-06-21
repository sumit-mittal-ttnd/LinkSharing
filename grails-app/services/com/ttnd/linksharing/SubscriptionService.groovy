package com.ttnd.linksharing

class SubscriptionService {

    ReadingItemService readingItemService;

    def subscribeTopic(Topic topic, User user, Subscription.Seriousness seriousness) {
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: seriousness);
        if(!subscription.validate()){
            log.error "Errors Occurred While Saving Subscription: "+subscription.getErrors();
        }else{
            subscription.save(flush: true, failOnError: true);
            // As he will subscribe the topic we will add entries in ReadingItem
            ReadingItem.withNewSession {session ->
                readingItemService.create(topic, user, Boolean.TRUE);
            }
            log.info "Subscription Persisted in the DB with ID "+subscription.getId();
        }
    }

    def update(Subscription subscription){
        subscription.merge(flush: true, failOnError: true);
    }

    def delete(Subscription subscription){
        User user = subscription.getUser();
        Topic topic = subscription.getTopic();

        // removed the cascaded entries
        user.removeFromSubscriptions(subscription);
        user.save();
        topic.removeFromSubscriptions(subscription);
        topic.save();

        subscription.delete(flush: true);
    }

    List<Topic> findSubscribedTopics(User user){
        List<Topic> topics = Subscription.createCriteria().listDistinct {
            projections{
                property("topic")
            }
            eq("user", user)
        };
        return topics;
    }

    List<Subscription> findSubscriptionsByUser(User user){
        List<Subscription> subscriptions;

        subscriptions = Subscription.createCriteria().listDistinct {
            and {
                "topic"{
                    order("name", "asc")
                }
                if(!user.admin){
                    eq("user", user)
                }
            }
        };
        return subscriptions;
    }

}