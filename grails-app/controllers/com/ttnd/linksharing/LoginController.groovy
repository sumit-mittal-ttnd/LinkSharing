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

    def loginHandler(String userName, String password) {
        User user = User.findByUserNameAndPassword(userName, password);
        if(user != null){
            if(user.active){
                session.setAttribute("user", user);
                redirect (controller: 'login', action: 'index')
            }else{
                flash.message = "Your account is not active !!";
            }
        }else{
            flash.message = "User not found !!";
        }
    }

    def logout() {
        session.invalidate();
        forward(controller: "login", action: "index");
    }

    def register(){
        def user = new User(params)
        if(user == null){
            render(view:"login", model:[user:user, responseMsg: message(code: 'User.null.message')])
            return;
        }

        if(!user.validate()){
            render(view:"login", model:[user:user, responseMsg: message(code: 'User.invalid.message')])
            return;
        }

        User userByEmail = User.findByEmail(user.getEmail());
        if(userByEmail != null){
            render(view:"login", model:[user:user, responseMsg: message(code: 'User.email.duplicate.message')])
            return;
        }

        User userByUserName = User.findByUserName(user.getUserName());
        if(userByUserName != null){
            render(view:"login", model:[user:user, responseMsg: message(code: 'User.userName.duplicate.message')])
            return;
        }

        user.setAdmin(Boolean.FALSE);
        user.setActive(Boolean.FALSE)
        user.save(flush: true, failOnError: true);
        render(view:"login", model:[user:user, responseMsg: message(code: 'User.register.success.message')])
        return;
    }


}