package com.ttnd.linksharing

class TopicController {

    def index() { }

    def show(){
        def topicId = params.get("id");
        println "IDDDDDDDDDDDDDDDDDDDDDDDDd is"+topicId
        Topic topic = Topic.findById(topicId);
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

}
