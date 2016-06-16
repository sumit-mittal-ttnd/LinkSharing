package com.ttnd.linksharing

class TopicController {

    TopicService topicService;
    SubscriptionService subscriptionService;

    def index() { }

    def show(){
        def topicId = params.get("id");
        Topic topic = Topic.read(topicId);
        if(topic == null){
            flash.message = "Topic Not Found !!!!";
            redirect(controller: 'login', action: 'index')
        }else if(topic.visibility == Topic.Visibility.PUBLIC){
            render(view:"show", model:[topic:topic])
        }else if(topic.visibility == Topic.Visibility.PRIVATE){
            // If topic is private then only subscribed users can see that topic
            User loggedInUser = User.get(session.getAttribute("userId"));
            Subscription subscription = Subscription.findByUserAndTopic(loggedInUser, topic);
            if(subscription != null){
                render(view:"show", model:[topic:topic])
            }else{
                flash.message = "Subscription Not Found !!!!";
                redirect(controller: 'user', action: 'index')
            }
        }
    }

    def save() {
        Topic topic = topicService.init(params, User.get(session.getAttribute("userId")));
        if(!topic.validate()){
            flash.error = message(code: 'Topic.name.duplicate.message');
        }else{
            topicService.create(topic);
            flash.message = message(code: 'Topic.save.success.message');
        }
        redirect(controller: 'user', action: 'index')
    }

    def topicsSubscribed(){
        List<Topic> topics = subscriptionService.findSubscribedTopics(User.get(session.getAttribute("userId")));
        render(view:"list", model:[topicsListByUser:topics]);
    }

    def topicsCreated(){
        User user = User.get(session.getAttribute("userId"));
        render(view:"list", model:[topicsListByUser:user.topics]);
    }







}