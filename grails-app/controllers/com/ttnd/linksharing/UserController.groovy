package com.ttnd.linksharing

class UserController {

    UserService userService;
    TopicService topicService;
    ResourceService resourceService;

    def index() {
        User user = User.get(session.getAttribute("userId"));
        render(view:"dashboard", model:[user:user, trendingTopics:topicService.findTrendingTopics(user), unreadResources:resourceService.findUnreadResourcesByUser(user)])
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
            userService.activate(params);
            flash.message = message(code: 'User.updated.success.message');
            render(view:"list", model:[usersList:userService.findUsersList()]);
        }else{
            flash.error = message(code: 'User.no.rights.message');
            redirect (controller: 'user', action: 'index')
        }
    }








}