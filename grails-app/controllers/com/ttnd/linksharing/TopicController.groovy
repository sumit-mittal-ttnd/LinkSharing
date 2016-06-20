package com.ttnd.linksharing

class TopicController {

    TopicService topicService;
    SubscriptionService subscriptionService;

    def index() { }

    def save() {
        Topic topic = topicService.init(params, User.get(session.getAttribute("userId")));
        if(!topic.validate()){
            flash.error = message(code: 'Topic.name.duplicate.message');
        }else{
            topicService.save(topic);
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

    def list(){
        User user = User.get(session.getAttribute("userId"));
        if(user.getAdmin()){
            render(view:"list", model:[topicsListByUser:Topic.findAll()]);
        } else{
            flash.error = message(code: 'User.no.rights.message');
            redirect (controller: 'user', action: 'index')
        }
    }

    def sendInvite(){
        topicService.sendInvite(params,session.getAttribute("userId"));
        flash.message = message(code: 'Topic.invitation.success.message');
        redirect (controller: 'user', action: 'index');
    }







}