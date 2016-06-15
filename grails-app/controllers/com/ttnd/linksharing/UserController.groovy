package com.ttnd.linksharing

class UserController {

    def index() {
        User user = session.getAttribute("user");
        if(user != null && user.active){
            render(view:"dashboard", model:[user:user])
        }
    }


}