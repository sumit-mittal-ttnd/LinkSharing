package com.ttnd.linksharing


class LoginController {

    LoginService loginService;
    ResourceService resourceService;
    TopicService topicService;

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
                session.setAttribute("userFirstName", user.getFirstName());
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
        User user = loginService.preRegister(new User(params));
        if(!user.validate()){
            flash.error = message(code: 'User.invalid.message');
        }else{
            loginService.register(user);
            flash.message = message(code: 'User.register.success.message');
        }
        redirect (controller: 'login', action: 'index')
    }

    def activate(String activateCode, String id){
        User user = User.get(id);
        if(user != null && user.getActivateCode().equals(activateCode)){
            loginService.activateUser(user);
            flash.message = message(code: 'User.activate.success.message');
        }else{
            flash.error= message(code: 'invalid.request.message');
        }
        render(view:"login");
    }

    def forgotPassword(){
        User user = User.findByEmail(params.get("email"));
        if(user == null)
            flash.error = message(code: 'User.not.found.message');
        else{
            flash.message = message(code: 'User.forgot.password.success.message');
            loginService.forgotPassword(user);
        }
        redirect (controller: 'login', action: 'index')
    }

    def changePassword(){
        String pwd = params.get("password");
        String cPwd = params.get("confirmPassword");
        if(pwd != cPwd){
            flash.error = "Password Mismatch";
            redirect (controller: 'user', action: 'edit')
        }else{
            User user = User.get(session.getAttribute("userId"));
            user.setPassword(pwd);
            if(!user.validate()){
                flash.error = "Invalid Password";
                redirect (controller: 'user', action: 'edit')
            }else{
                user.save(flush: true, failOnError: true);
                flash.message = "Password Successfully Changed";
                redirect (controller: 'user', action: 'index')
            }
        }
      }

    def showTopic(){
        Topic topic = Topic.read(params.get("id"));
        if(topic == null){
            flash.message = "Topic Not Found !!!!";
            redirect(controller: 'login', action: 'index')
        }else if(topic.visibility == Topic.Visibility.PUBLIC){
            render(view:"/topic/show", model:[topic:topic])
        }else if(topic.visibility == Topic.Visibility.PRIVATE){
            // If topic is private then only subscribed users can see that topic
            User loggedInUser = User.get(session.getAttribute("userId"));
            Subscription subscription = Subscription.findByUserAndTopic(loggedInUser, topic);
            if(subscription != null){
                render(view:"/topic/show", model:[topic:topic])
            }else{
                flash.message = "Subscription Not Found !!!!";
                redirect(controller: 'user', action: 'index')
            }
        }
    }

    def showUser(){
        User user = User.get(Integer.parseInt(params.get("userId")));
        render(view:"/user/profile", model:[user:user]);
    }


    def showResource(){
        Resource resource = Resource.get(Integer.parseInt(params.get("resourceId")));
        render(view:"/resource/show", model:[resource:resource, trendingTopics:topicService.findTrendingTopics()]);
    }

}