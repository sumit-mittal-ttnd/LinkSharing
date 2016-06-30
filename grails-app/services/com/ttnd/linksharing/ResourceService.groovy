package com.ttnd.linksharing

import grails.util.Holders
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.StringUtils
import org.springframework.web.multipart.MultipartFile

class ResourceService {

    // unread resources
    List<Resource> findUnreadResourcesByUser(User loggedInUser, int resultCount){
        List<Resource> resources = Resource.createCriteria().listDistinct {
            and{
                "topic"{
                    "subscriptions"{
                        eq("user", loggedInUser)
                    }
                }
                isEmpty("readingItems")
                order("avgRating", "desc")
                if(resultCount != 0){
                    maxResults 5
                }
            }
        };
        return resources;
    }

    List<Resource> findResourcesByTopic(Long topicId, int resultCount){
        List<Resource> resources = Resource.createCriteria().listDistinct {
            and{
                "topic"{
                    eq("id", topicId)
                }
                order("avgRating", "desc")
                if(resultCount != 0){
                    maxResults resultCount
                }
            }
        };
        return resources;
    }

    // order by lastUpdated desc
    List<Resource> findRecentResources(){
        List<Resource> resources = Resource.createCriteria().listDistinct {
            and{
                maxResults 5
                "topic"{
                    eq("visibility", Topic.Visibility.PUBLIC)
                }
                order("lastUpdated", "desc")
            }
        };
        return resources;
    }

    // order by avgRating desc
    List<Resource> findTopResources(int resultCount){
        List<Resource> resources = Resource.createCriteria().listDistinct {
            and{
                "topic"{
                    eq("visibility", Topic.Visibility.PUBLIC)
                }
                order("avgRating", "desc")
                if(resultCount != 0){
                    maxResults 5
                }
            }
        };
        return resources;
    }

    List<Resource> findSearchedResources(String searchValue, User user, int resultCount){
        List<Resource> resources;
        if(searchValue != null && searchValue.trim().equals("")) searchValue = null;
        else searchValue = searchValue.trim();

        if(user == null && searchValue == null){
            resources = new ArrayList<Resource>(); //
        }else{
            resources = Resource.createCriteria().listDistinct {
                and{
                    if(searchValue != null){
                        or {
                            "topic" {
                                ilike("name", "%" + searchValue + "%")
                            }
                            ilike("description", "%" + searchValue + "%")
                        }
                    }

                    or{
                        if(user == null || !user.admin){
                            "topic" {
                                eq("visibility", Topic.Visibility.PUBLIC)
                            }
                        }

                        if(user != null && !user.admin){
                            "topic" {
                                eq("createdBy",user)
                            }
                        }
                    }

                    if(resultCount != 0){
                        maxResults 5
                    }
                    order("avgRating", "desc")
                }
            };
        }
        return resources;
    }


    Resource preSave(Map params, Long userId){
        Resource resource;
        if(params.get("resourceType") == "linkResource")
            resource = new LinkResource(params);
        else{
            resource = new DocumentResource(params);
            if(params.document.size>0){
                uploadDocumentResource(resource, params);
            }
        }
        resource.setAddedBy(User.get(userId));
        resource.setTopic(Topic.get(params.get("topicId")));
        return resource;
    }

    void save(Resource resource){
        resource.save(flush: true, failOnError: true);
    }

    void update(Map params){
        Resource resource = Resource.get(params.get("resourceId"));
        resource.setDescription(params.get("resourceDesc"));
        resource.merge(flush: true);
    }

    void delete(Map params){
        Resource resource = Resource.get(params.get("resourceId"))
        resource.delete(flush: true);
    }

    void markAsRead(Resource resource, User loggedInUser){
        boolean alreadyRead = Boolean.FALSE;
        loggedInUser.readingItems.each {it ->
            if(it.resource.id == resource.id)
                alreadyRead = Boolean.TRUE;
        }
        if(!alreadyRead){
            ReadingItem readingItem = new ReadingItem(resource: resource, user: loggedInUser, isRead: Boolean.TRUE);
            readingItem.save(flush: true, failOnError: true);
        }
    }

    void uploadDocumentResource(DocumentResource documentResource, Map params){
        String folderUrl = Holders.config.files.paths.fileDocDir as String;
        File file = new File(folderUrl);
        if(!file.exists()){
            file.mkdir();
        }

        MultipartFile document = params.document;
        String originalFN = document.getOriginalFilename();
        String extension = originalFN.substring(originalFN.lastIndexOf(".")+1,originalFN.length());

        String docUrl = folderUrl + File.separator + RandomStringUtils.randomAlphanumeric(10) + "." + extension;
        documentResource.setFilePath(docUrl);
        document.transferTo(new File(docUrl));
    }

}