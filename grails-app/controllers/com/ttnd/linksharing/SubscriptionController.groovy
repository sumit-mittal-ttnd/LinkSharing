package com.ttnd.linksharing

class SubscriptionController {

    ReadingItemController readingItemController;
    SubscriptionService subscriptionService;

    def index() { }

    def save(){
        User loggedInUser = User.get(session.getAttribute("userId"));
        Topic topic = Topic.get(params.get("topicId"));
        Subscription.Seriousness seriousness = params.get("seriousness");
        subscriptionService.subscribeTopic(loggedInUser, topic, seriousness);
    }

    def update() {
        Subscription subscription = new Subscription(params);
        if (!subscription.validate()){
            flash.error = "Not a valid request";
        } else{
            flash.message= "Successfully Updated";
            subscriptionService.update(subscription);
        }
    }

    def delete(Subscription subscription){
        subscriptionService.delete(subscription);
        flash.message = "Successfully Unsubscribed";
        redirect(controller:'user', action:'index');
    }

    def findSubscriptionsByUser(){
        render(view:"list", model:[subscriptions:subscriptionService.findSubscriptionsByUser(User.get(params.get("userId")))])
    }





















    /*def subscribeTopic(User user, Topic topic, Subscription.Seriousness seriousness){
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
    }*/

}