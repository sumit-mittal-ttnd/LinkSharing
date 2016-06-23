package com.ttnd.linksharing

class SubscriptionService {

// ============================ CHECKED =============================

    List<Subscription> findSubscriptionsByUser(User user){
        List<Subscription> subscriptions = Subscription.createCriteria().listDistinct {
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

    void subscribe(User user, Topic topic){
        Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Subscription.Seriousness.SERIOUS);
        subscription.save(flush: true, failOnError: true);
    }

    void unsubscribe(Map params){
        Subscription subscription = Subscription.get(params.get("subscriptionId"));
        subscription.delete(flush: true)
    }









    /*def subscribeTopic(Topic topic, User user, Subscription.Seriousness seriousness) {
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
    }*/

    /*def update(Subscription subscription){
        subscription.merge(flush: true, failOnError: true);
    }*/






}