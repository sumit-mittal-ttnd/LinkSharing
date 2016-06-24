package com.ttnd.linksharing

class ResourceRatingService {

    void rate(User user, Resource resource, int score){
        ResourceRating resourceRating = ResourceRating.findByUserAndResource(user, resource);
        if(resourceRating == null){
            resourceRating = new ResourceRating(user:user,resource: resource, score: score);
            resourceRating.save();
        }else{
            resourceRating.setScore(score);
            resourceRating.merge();
        }
    }


}