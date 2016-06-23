package com.ttnd.linksharing

import org.apache.commons.lang.RandomStringUtils
import org.springframework.web.multipart.MultipartFile

class ResourceService {

// ============================ CHECKED =============================

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

    // unread resources
    List<Resource> findInboxResourcesByUser(User loggedInUser){
        List<Resource> resources = Resource.createCriteria().listDistinct {
            and{
                "topic"{
                    "subscriptions"{
                        eq("user", loggedInUser)
                    }
                }
                isEmpty("readingItems")
            }
        };
        return resources;
    }

    void markAsRead(Resource resource, User loggedInUser){
        ReadingItem readingItem = new ReadingItem(resource: resource, user: loggedInUser, isRead: Boolean.TRUE);
        readingItem.save(flush: true, failOnError: true);
    }










    // unread resources by user
    List<Resource> findUnreadResources(){
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

    def uploadDocumentResource(DocumentResource documentResource, Map params){
        String folderUrl = "/home/ttnd/sumit/document_resources/";
        File file = new File(folderUrl);
        if(!file.exists()){
            file.mkdir();
        }

        MultipartFile document = params.document;
        String originalFN = document.getOriginalFilename();
        String extension = originalFN.substring(originalFN.lastIndexOf(".")+1,originalFN.length());

        String docUrl = folderUrl + RandomStringUtils.randomAlphanumeric(10) + "." + extension;
        documentResource.setFilePath(docUrl);
        document.transferTo(new File(docUrl));
    }


}