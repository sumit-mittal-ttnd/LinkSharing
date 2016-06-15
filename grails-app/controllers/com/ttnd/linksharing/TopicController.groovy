package com.ttnd.linksharing

class TopicController {

    SubscriptionController subscriptionController;

    def index() { }

    def show(){
        def topicId = params.get("id");
        Topic topic = Topic.read(topicId);
        if(topic == null){
            flash.message = "Topic Not Found !!!!";
            redirect(controller: 'login', action: 'index')
        }else if(topic.visibility == Topic.Visibility.PUBLIC){
            render "success";
        }else{
            User loggedInUser = session.getAttribute("user");
            Subscription subscription = Subscription.findByUserAndTopic(loggedInUser, topic);
            if(subscription != null){
                render "success";
            }else{
                flash.message = "Subscription Not Found !!!!";
                redirect(controller: 'login', action: 'index')
            }

        }
    }

    def save() {
        def topic = new Topic(params)
        if(topic == null || !topic.validate()){
            render(view:"login", model:[topic:topic, responseMsg: message(code: 'Topic.invalid.message')])
            return;
        }

        Topic topicByNameAndUser = Topic.findByNameAndCreatedBy(topic.getName(), topic.getCreatedBy());
        if(topicByNameAndUser != null){
            render(view:"login", model:[topic:topic, responseMsg: message(code: 'Topic.name.duplicate.message')])
            return;
        }

        User loggedInUser = session.getAttribute("user");
        if(loggedInUser == null){
            render(view:"login", model:[topic:topic, responseMsg: message(code: 'User.invalid.message')])
            return;
        }

        topic.setCreatedBy(loggedInUser);
        topic.save(flush: true, failOnError: true);

        Subscription.Seriousness seriousness = params.get("seriousness");
        Topic.withNewSession {session ->
            subscriptionController.subscribeTopic(loggedInUser, topic, seriousness);
        }

        render(view:"login", model:[topic:topic, responseMsg: message(code: 'Topic.save.success.message')])
    }








}
