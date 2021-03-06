package com.ttnd.linksharing

import grails.plugin.mail.MailService

class TopicService {

    MailService mailService;

    // Topic Visibility = PUBLIC   OR   Created By Me   OR   Subscribed By Me   +   Ordered by No Of Resources
    List<Topic> findTrendingTopics(User user, int resultCount){
        List<Topic> topics;
        if(user == null){
            topics = Topic.createCriteria().listDistinct {
                or{
                    eq("visibility", Topic.Visibility.PUBLIC)
                    if(resultCount != 0){
                        maxResults 5
                    }
                }
            };
        } else if(user.admin){
            topics = Topic.createCriteria().listDistinct {
                if(resultCount != 0){
                    maxResults 5
                }
            };
        }else{
            topics = Topic.createCriteria().listDistinct {
                or{
                    eq("visibility", Topic.Visibility.PUBLIC)
                    eq("createdBy",user)
                    "subscriptions"{
                        eq("user", user)
                    }
                    if(resultCount != 0){
                        maxResults 5
                    }
                }
            };
        }
        topics.sort { -it.resources.size() }
        return topics;
    }
















    List<Topic> findSubscribedTopicsByUser(User user){
        List<Topic> topics = Topic.createCriteria().listDistinct {
            "subscriptions"{
                eq("user", user)
            }
        };
        return topics;
    }

    Topic init(Map params, User user){
        Topic topic = new Topic(params);
        if(params.get("visibility").equals("PUBLIC")) topic.setVisibility(Topic.Visibility.PUBLIC)
        else topic.setVisibility(Topic.Visibility.PRIVATE)
        topic.setCreatedBy(user);
        return topic;
    }

    void save(Topic topic) {
        topic.save(flush: true, failOnError: true);
    }

    void delete(Map params){
        Topic topic = Topic.get(params.get("topicId"))
        topic.delete(flush: true);
    }

    void sendInvite(Map params, Long loggedInUserId){
        Topic topic = Topic.get(params.get("topicId"));
        String email = params.get("email");
        mailService.sendMail {
            async true
            to email
            subject "Invitation For "+topic.getName()+" - LinkSharing"
            html(view:'/mail/_invitation', model:[email:email,firstName:User.get(loggedInUserId).firstName, topicId : topic.id, topicName : topic.name])
        }
    }

    // Topic Visibility = PUBLIC   OR   Created By Me   OR   Subscribed By Me   +   Ordered by No Of Resources
    List<Topic> findTopicsByUser(User viewUser, User loggedInUser){
        List<Topic> topics = Topic.createCriteria().listDistinct {
            and{
                eq("createdBy",viewUser)
                if((loggedInUser == null) || (viewUser != loggedInUser && !loggedInUser.admin))
                    eq("visibility", Topic.Visibility.PUBLIC)
            }
        };
        topics.sort { -it.resources.size() }
        return topics;
    }

    void updateVisibility(Map params){
        Topic topic = Topic.get(params.get("topicId"));
        String visibility = params.get("visibility");
        if(visibility.equals("PUBLIC")) topic.setVisibility(Topic.Visibility.PUBLIC)
        else topic.setVisibility(Topic.Visibility.PRIVATE)
        topic.merge(flush: true);
    }

    void update(Map params){
        Topic topic = Topic.get(params.get("topicId"));
        topic.setName(params.get("topicName"));
        topic.merge();
    }


}