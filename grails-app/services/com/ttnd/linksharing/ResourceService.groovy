package com.ttnd.linksharing

class ResourceService {


    // order by lastUpdated desc
    List<Resource> findRecentResources(){
        List<Resource> resources = Resource.createCriteria().listDistinct {
            and{
                order("lastUpdated", "desc")
                maxResults 5
                "topic"{
                    eq("visibility", Topic.Visibility.PUBLIC)
                }
            }
        };
        return resources;
    }

    // order by avgRating desc
    List<Resource> findTopResources(){
        List<Resource> resources = Resource.createCriteria().listDistinct {
            and{
                order("avgRating", "desc")
                maxResults 5
                "topic"{
                    eq("visibility", Topic.Visibility.PUBLIC)
                }
            }
        };
        return resources;
    }




}