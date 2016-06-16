package com.ttnd.linksharing

class UserController {

    UserService userService;

    def index() {
        User user = User.get(session.getAttribute("userId"));
        render(view:"dashboard", model:[user:user])
    }

    def edit(){
        User user = User.get(session.getAttribute("userId"));
        render(view:"profile", model:[user:user]);
    }

    def update(){
        User user = User.get(session.getAttribute("userId"));
        user.setFirstName(params.get("firstName"));
        user.setLastName(params.get("lastName"));
        user.setUserName(params.get("userName"));
        user.setPhoto(params.get("photo"));

        user.merge(flush: true, failOnError: true);
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