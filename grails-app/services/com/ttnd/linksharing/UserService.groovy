package com.ttnd.linksharing

import org.springframework.web.multipart.MultipartFile

class UserService {

    List<User> findUsersList(){
        List<User> users = User.createCriteria().listDistinct {
            eq("admin",Boolean.FALSE)
        };
        return users;
    }

    void update(User user, Map params){
        user.setFirstName(params.get("firstName"));
        user.setLastName(params.get("lastName"));
        user.setUserName(params.get("userName"));
        if(params.photo.size>0){
            uploadUserPic(user, params);
        }
        user.merge(flush: true, failOnError: true);
    }

    void uploadUserPic(User user, Map params){
        String folderUrl = Constants.USER_PHOTO_URL;
        File file = new File(folderUrl);
        if(!file.exists()){
            file.mkdir();
        }
        String photoUrl = folderUrl +  user.getId()+".jpg";
        user.setPhotoUrl(photoUrl);
        MultipartFile document = params.photo;
        document.transferTo(new File(photoUrl));
    }

    void activate(Map params){
        User actionUser = User.load(params.get("userId"));
        if(params.get("activateUser").equals("true"))
            actionUser.setActive(Boolean.TRUE);
        else
            actionUser.setActive(Boolean.FALSE);
        actionUser.merge(flush: true, failOnError: true);
    }


}