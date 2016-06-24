package com.ttnd.linksharing

import grails.converters.JSON

class ResourceRatingController {

    ResourceRatingService resourceRatingService;

    def rate(){
        User user = User.get(session.getAttribute("userId"));
        Resource resource = Resource.get(request.getParameter("resourceId"));
        Subscription subscription = Subscription.findByUserAndTopic(user, resource.getTopic());

        Map<String, String> map = new HashMap<String, String>();
        if(subscription == null){
            map.put("response", "subscribeFirst")
        }else{
            resourceRatingService.rate(user, resource, Integer.parseInt(request.getParameter("rating")));
            map.put("response", "success")
        }
        render map as JSON;
    }

}