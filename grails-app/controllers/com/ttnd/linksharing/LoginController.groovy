package com.ttnd.linksharing


class LoginController {

    LoginService loginService;
    ResourceService resourceService;

    def index() {
        User user = User.get(session.getAttribute("userId"));
        if(user == null)
            render(view:"login", model: ["recentResources":resourceService.findRecentResources(), "topResources":resourceService.findTopResources() ]);
        else
            redirect(controller: 'user', action: 'index')
    }

    def login() {
        String userName = params.get("userName");
        String password = params.get("password");
        User user = User.findByUserNameAndPassword(userName, password);
        if(user != null){
            if(user.active){
                session.setAttribute("userId", user.getId());
                session.setAttribute("userIsAdmin", user.getAdmin()?"TRUE":"FALSE");
                redirect (controller: 'user', action: 'index')
            }else{
                flash.error = "Your account is not active !!";
                redirect (controller: 'login', action: 'index')
            }
        }else{
            flash.error = "User not found !!";
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

        if(!user.validate()){
            flash.error = message(code: 'User.invalid.message');
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