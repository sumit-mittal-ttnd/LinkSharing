package com.ttnd.linksharing

class SubscriptionController {

    ReadingItemController readingItemController;

    def index() { }

    def save(){
        User loggedInUser = session.getAttribute("user");
        Topic topic = Topic.get(params.get("topicId"));
        Subscription.Seriousness seriousness = params.get("seriousness");
        // calling method to subscribe
        subscribeTopic(loggedInUser, topic, seriousness);
    }

    def update(){
        Subscription subscription = new Subscription(params);
        if(!subscription.validate()){
            log.error "Errors Occurred While Updating Subscription: "+subscription.getErrors();
        }else{
            subscription.save(flush: true, failOnError: true);
            log.info "Subscription updated in the DB with ID "+subscription.getId();
        }
    }

    def delete(){
        def subscriptionId = params.get("id");
        Subscription subscription = Subscription.load(subscriptionId);
        if(subscription == null){
            flash.message = "Subscription Not Found !!!!";
            redirect(controller: 'login', action: 'index')
        }else{
            User loggedInUser = session.getAttribute("user");
            User subscribedUser = subscription.getUser();
            if(!loggedInUser.equals(subscribedUser)){
                flash.message = "You were not subscribed to this topic !!!!";
                redirect(controller: 'login', action: 'index')
            }else{
                subscription.delete(flush: true);
                render "success";
            }
        }
    }

    def subscribeTopic(User user, Topic topic, Subscription.Seriousness seriousness){
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: seriousness);
        if(!subscription.validate()){
            log.error "Errors Occurred While Saving Subscription: "+subscription.getErrors();
        }else{
            subscription.save(flush: true, failOnError: true);
            // As he will subscribe the topic we will add entries in ReadingItem
            ReadingItem.withNewSession {session ->
                Set<Resource> resources = topic.getResources();
                for(Resource resource : resources){
                    // Because if user has added that resource then There shouldn't be entry in reading item
                    if(!resource.getAddedBy().equals(user)){
                        // check the record if same user with same resource already have reading item
                        ReadingItem alreadyReadingItem = ReadingItem.findByResourceAndUser(resource, user);
                        if(alreadyReadingItem == null){
                            readingItemController.create(resource, user, Boolean.FALSE);
                        }
                    }
                }
            }
            log.info "Subscription Persisted in the DB with ID "+subscription.getId();
        }
    }

}