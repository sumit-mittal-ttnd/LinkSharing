package com.ttnd.linksharing

class LoginController {

    LoginService loginService;
    ResourceService resourceService;
    TopicService topicService;

    def index() {
        User user = User.get(session.getAttribute("userId"));
        if(user == null)
            render(view:"login", model: [recentResources:resourceService.findRecentResources(), topResources:resourceService.findTopResources(5), unreadResources:null]);
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
        User user = loginService.preRegister(params);
        if(!user.validate()){
            flash.error = message(code: 'User.invalid.message');
        }else{
            loginService.register(user, params, request);
            flash.message = message(code: 'User.register.success.message');
        }
        redirect (controller: 'login', action: 'index')
    }

    def activate(){
        User user = User.get(params.get("userId"));
        if(user != null && user.getActivateCode().equals(params.get("activateCode"))){
            loginService.activateUser(user);
            flash.message = message(code: 'User.activate.success.message');
        }else{
            flash.error= message(code: 'invalid.request.message');
        }
        redirect (controller: 'login', action: 'index')
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

    def showTopic(){
        Topic topic = Topic.read(params.get("id"));
        render(view:"/topic/show", model:[topic:topic, unreadResources:resourceService.findUnreadResourcesByUser(User.get(session.getAttribute("userId")), 0), resourcesByTopic: resourceService.findResourcesByTopic(topic.getId(), 5)])
    }

    def findResourcesByTopic(){
        render(view:"/resource/list", model:[resources: resourceService.findResourcesByTopic(Long.parseLong(params.get("topicId")), 0)]);
    }

    def topicsCreated(){
        render(view:"/topic/list", model:[topicsByUser:topicService.findTopicsByUser(User.get(params.get("userId")), User.get(session.getAttribute("userId")))]);
    }

    def showUser(){
        User user = User.get(Integer.parseInt(params.get("userId")));
        render(view:"/user/show", model:[user:user, unreadResources:resourceService.findUnreadResourcesByUser(user, 0), topicsByUser:topicService.findTopicsByUser(user, User.get(session.getAttribute("userId")))]);
    }

    def showResource(){
        User loggedInUser = User.get(session.getAttribute("userId"));
        Resource resource = Resource.get(Integer.parseInt(params.get("resourceId")));
        if(loggedInUser != null)
            resourceService.markAsRead(resource, loggedInUser);
        render(view:"/resource/show", model:[resource: resource, trendingTopics:topicService.findTrendingTopics(loggedInUser, 5), unreadResources:resourceService.findUnreadResourcesByUser(loggedInUser, 0)]);
    }

    def findTopResources(){
        render(view:"/resource/list", model:[resources: resourceService.findTopResources(0)]);
    }

    def findSubscriptionsByUser(){
        User user = User.get(params.get("userId"));
        render(view:"/subscription/list", model:[subscriptions:user.subscriptions])
    }

    def findTrendingTopicsByUser(){
        render(view:"/topic/list", model:[topicsByUser:topicService.findTrendingTopics(User.get(session.getAttribute("userId")), 0)])
    }

    def showUserImage(final Long id) {
        User user = User.load(id);
        File file = new File(user.photoUrl);
        byte[] photo = new byte[(int)file.length()];

        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(photo);
        response.contentLength = photo?.length;
        response.contentType = 'image/png';
        response.outputStream << photo;
        response.outputStream.flush();
    }

    def downloadResource(){
        DocumentResource docResource = (DocumentResource)Resource.get(params.get("resourceId"));
        def file = new File(docResource.getFilePath())
        response.setContentType("application/octet-stream")
        response.setHeader("Content-disposition", "filename=${file.getName()}")
        response.outputStream << file.newInputStream()
    }

    def search(){
        User user = User.get(session.getAttribute("userId"));
        String searchValue = params.get("searchValue");
        render(view:"/login/search", model:[searchValue:searchValue, trendingTopics:topicService.findTrendingTopics(user, 5), topResources:resourceService.findTopResources(5), searchedResources:resourceService.findSearchedResources(searchValue, user, 5), unreadResources:resourceService.findUnreadResourcesByUser(user, 0)]);
    }

    def findAllSearchedResource(){
        User user = User.get(session.getAttribute("userId"));
        String searchValue = params.get("searchValue");
        render(view:"/resource/list", model:[searchValue:searchValue, resources:resourceService.findSearchedResources(searchValue, user, 0)]);
    }


}