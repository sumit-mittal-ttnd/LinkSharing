package com.ttnd.linksharing

class UserController {

    UserService userService;
    TopicService topicService;
    ResourceService resourceService;

    def index() {
        User user = User.get(session.getAttribute("userId"));
        render(view:"dashboard", model:[user:user, trendingTopics:topicService.findTrendingTopics(user, 5), unreadResources:resourceService.findUnreadResourcesByUser(user, 5)])
    }

    def update(){
        User user = User.get(params.get("userId"));
        userService.update(user, params);
        flash.message = message(code: 'User.updated.success.message');
        redirect (controller: 'user', action: 'index')
    }

    def changePassword(){
        String pwd = params.get("password");
        String cPwd = params.get("confirmPassword");
        if(pwd != cPwd){
            flash.error = "Password Mismatch";
            redirect (controller: 'user', action: 'edit')
        }else{
            userService.changePassword(params);
            flash.message = "Password Successfully Changed";
            redirect (controller: 'user', action: 'index')
        }
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