package com.ttnd.linksharing

class ResourceRatingService {

    void rate(User user, Resource resource, int score){
        ResourceRating resourceRating = ResourceRating.findByUserAndResource(user, resource);
        if(resourceRating == null){
            resourceRating = new ResourceRating(user:user,resource: resource, score: score);
            resourceRating.save();
        }else{
            resourceRating.setScore(score);
            mergeResourceRating(resourceRating);
        }
    }

    void mergeResourceRating(ResourceRating resourceRating){
        Resource resource = resourceRating.getResource();
        int count = ResourceRating.countByResource(resource);
        int totalRating = 0;
        List<ResourceRating> list = ResourceRating.findAllByResource(resource);
        for(ResourceRating resRat : list){
            totalRating += resRat.score;
        }
        float avgRating = totalRating/count;
        resource.avgRating = avgRating;
        resourceRating.setResource(resource);
        resourceRating.merge(flush:true);
    }


}