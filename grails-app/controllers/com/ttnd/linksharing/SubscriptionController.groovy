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




}