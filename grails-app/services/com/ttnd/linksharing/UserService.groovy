package com.ttnd.linksharing

import asset.pipeline.grails.AssetResourceLocator
import grails.util.Holders
import org.springframework.core.io.ByteArrayResource
import org.springframework.web.multipart.MultipartFile

import javax.servlet.http.HttpServletRequest

class UserService {

    AssetResourceLocator assetResourceLocator;

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

    void changePassword(Map params){
        User user = User.get(params.get("userId"));
        user.setPassword(params.get("password"));
        user.merge(flush: true, failOnError: true);
    }

    void uploadUserPic(User user, Map params){
        String folderUrl = Holders.config.files.paths.profilePicDir as String;
        File file = new File(folderUrl);
        if(!file.exists()){
            file.mkdir();
        }

        String photoUrl = folderUrl + File.separator +  user.getUserName()+".jpg";
        user.setPhotoUrl(photoUrl);
        MultipartFile document = params.photo;
        document.transferTo(new File(photoUrl));
    }

    void uploadDefaultUserPic(User user, HttpServletRequest request){
        try{
            String destinationFolderUrl = Holders.config.files.paths.profilePicDir as String;
            File file = new File(destinationFolderUrl);
            if(!file.exists()){
                file.mkdir();
            }
            String destinationPhotoUrl = destinationFolderUrl + File.separator + Constants.DEFAULT_USER_IMG_NAME;

            String sourceImgPath = request.getServletContext().getRealPath("/images/userIcon.png");
            FileOutputStream fileOutputStream = new FileOutputStream(destinationPhotoUrl);
            fileOutputStream.write(new File(sourceImgPath).bytes);
            fileOutputStream.close();
            user.setPhotoUrl(destinationPhotoUrl);
        } catch(Exception e){
            e.printStackTrace()
        }
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