package com.ttnd.linksharing

class UserController {

    UserService userService;
    TopicService topicService;
    SubscriptionService subscriptionService;
    ResourceService resourceService;

    def index() {
        User user = User.get(session.getAttribute("userId"));
        List<Subscription> subscriptionsByUser = subscriptionService.findSubscriptionsByUser(user);
        if(subscriptionsByUser != null && subscriptionsByUser.size()>5) subscriptionsByUser.subList(0,5);
        render(view:"dashboard", model:[user:user, trendingTopics:topicService.findTrendingTopics(user), subscriptionsByUser:subscriptionsByUser , inboxResources:resourceService.findInboxResourcesByUser(user)])
    }

    def update(){
        User user = User.get(session.getAttribute("userId"));
        userService.update(user, params);
        flash.message = message(code: 'User.updated.success.message');
        redirect (controller: 'user', action: 'index')
    }

    def list(){
        User user = User.get(session.getAttribute("userId"));
        if(user.getAdmin()){
            render(view:"list", model:[usersList:userService.findUsersList()]);
        }else{
            flash.error = message(code: 'User.no.rights.message');
            redirect (controller: 'user', action: 'index')
        }
    }

    def activate(){
        User user = User.get(session.getAttribute("userId"));
        if(user.getAdmin()){
            User actionUser = User.load(params.get("userId"));
            if(params.get("activateUser").equals("true"))
                actionUser.setActive(Boolean.TRUE);
            else
                actionUser.setActive(Boolean.FALSE);
            flash.message = message(code: 'User.updated.success.message');
            render(view:"list", model:[usersList:userService.findUsersList()]);
        }else{
            flash.error = message(code: 'User.no.rights.message');
            redirect (controller: 'user', action: 'index')
        }
    }








}