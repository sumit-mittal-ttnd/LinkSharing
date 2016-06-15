package com.ttnd.linksharing


class LoginController {

    def index() {
        User user = session.getAttribute("user");
        if(user == null){
            render(view:"login");
        }else {
            redirect(controller: 'user', action: 'index')
        }
    }

    def login() {
        String userName = params.get("userName");
        String password = params.get("password");
        User user = User.findByUserNameAndPassword(userName, password);
        if(user != null){
            if(user.active){
                session.setAttribute("user", user);
                redirect (controller: 'user', action: 'index')
            }else{
                flash.message = "Your account is not active !!";
                redirect (controller: 'login', action: 'index')
            }
        }else{
            flash.message = "User not found !!";
            redirect (controller: 'login', action: 'index')
        }
    }

    def logout() {
        session.invalidate();
        flash.message = message(code: 'User.logout.success.message');
        redirect (controller: 'login', action: 'index')
    }

    def register(){
        def user = new User(params);
        if(user == null || !user.validate()){
            flash.error = message(code: 'User.invalid.message');
            render(view:"login", model:[user:user])
            return;
        }

        User userByEmail = User.findByEmail(user.getEmail());
        if(userByEmail != null){
            flash.error = message(code: 'User.email.duplicate.message');
            render(view:"login", model:[user:user])
            return;
        }

        User userByUserName = User.findByUserName(user.getUserName());
        if(userByUserName != null){
            flash.error = message(code: 'User.userName.duplicate.message');
            render(view:"login", model:[user:user])
            return;
        }

        user.setAdmin(Boolean.FALSE);
        user.setActive(Boolean.FALSE)
        user.save(flush: true, failOnError: true);
        flash.message = message(code: 'User.register.success.message');
        render(view:"login", model:[user:user])
        return;
    }


}