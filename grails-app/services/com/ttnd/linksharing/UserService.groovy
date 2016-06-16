package com.ttnd.linksharing

class UserService {


    List<User> findUsersList(){
        List<User> users = User.createCriteria().listDistinct {
            eq("admin",Boolean.FALSE)
        };
        return users;
    }


}