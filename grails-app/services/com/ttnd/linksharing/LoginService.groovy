package com.ttnd.linksharing

import grails.plugin.mail.MailService
import org.apache.commons.lang.RandomStringUtils

class LoginService {

    MailService mailService;


    User preRegister(User user){
        user.setActivateCode(RandomStringUtils.randomAlphanumeric(10));
        user.setAdmin(Boolean.FALSE);
        user.setActive(Boolean.FALSE)
        return user;
    }

    def register(User user){
        user.save(flush: true, failOnError: true);
        mailService.sendMail {
            async true
            to user.getEmail()
            subject "Welcome to LinkSharing App"
            html(view:'/mail/_registration', model:[firstName:user.firstName, activateCode:user.activateCode, userId:user.id])
        }
    }

    def activateUser(User user){
        user.setActive(Boolean.TRUE);
        user.setActivateCode(null);
        user.merge(flush: true, failOnError: true);
    }

    def forgotPassword(User user){
        user.setPassword(RandomStringUtils.randomAlphanumeric(10))
        user.merge(flush: true, failOnError: true);
        mailService.sendMail {
            async true
            to user.getEmail()
            subject "Forgot Password - LinkSharing"
            html(view:'/mail/_forgotPassword', model:[firstName:user.firstName, password : user.getPassword()])
        }
    }



}