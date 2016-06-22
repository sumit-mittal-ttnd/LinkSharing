package com.ttnd.linksharing

import org.springframework.web.multipart.MultipartFile

class UserService {


    List<User> findUsersList(){
        List<User> users = User.createCriteria().listDistinct {
            eq("admin",Boolean.FALSE)
        };
        return users;
    }

    def update(User user, Map params){
        user.setFirstName(params.get("firstName"));
        user.setLastName(params.get("lastName"));
        user.setUserName(params.get("userName"));
        if(params.photo.size>0){
            uploadUserPic(user, params);
        }
        user.merge(flush: true, failOnError: true);
    }



    def uploadUserPic(User user, Map params){
        String folderUrl = "/home/ttnd/sumit/GrailsProject/users_photo/";
        File file = new File(folderUrl);
        if(!file.exists()){
            file.mkdir();
        }

        String photoUrl = folderUrl +  user.getId()+".jpg";
        user.setPhotoUrl(photoUrl);

        MultipartFile document = params.photo;
        document.transferTo(new File(photoUrl));
    }

}