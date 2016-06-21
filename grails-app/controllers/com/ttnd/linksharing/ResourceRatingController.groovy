package com.ttnd.linksharing

import grails.converters.JSON

class ResourceRatingController {

    ResourceRatingService resourceRatingService;

    def rate(){
        resourceRatingService.rate(User.get(session.getAttribute("userId")), Resource.get(request.getParameter("resourceId")), Integer.parseInt(request.getParameter("rating")));
        Map<String, String> map = new HashMap<String, String>();
        map.put("response", "success")
        render map as JSON;
    }

}