package com.ttnd.linksharing

class ResourceRatingService {

    def rate(User user, Resource resource, int score){
        ResourceRating resourceRating = ResourceRating.findByUserAndResource(user, resource);
        if(resourceRating == null){
            resourceRating = new ResourceRating(user:user,resource: resource);
            resourceRating.setScore(score);
            resourceRating.save(flush: true, failOnError: true);
        }else{
            resourceRating.setScore(score);
            resourceRating.merge(flush: true, failOnError: true);
        }
    }


}