package com.ttnd.linksharing

import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.StringUtils
import org.springframework.web.multipart.MultipartFile

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
                "topic"{
                    eq("visibility", Topic.Visibility.PUBLIC)
                }
            }
        };
        return resources;
    }

    // unread resources
    List<Resource> findUnreadResourcesByUser(User loggedInUser){
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

    List<Resource> findSearchedResources(String searchValue, User user){
        List<Resource> resources = new ArrayList<Resource>();
        if(user == null){
            resources = findTopResources();
        }else{
            if(user.admin){
                if(StringUtils.isBlank(searchValue)){
                    return Resource.findAll();
                } else{
                    resources = Resource.createCriteria().listDistinct {
                        or{
                            "topic"{
                                ilike("name", "%"+searchValue+"%")
                            }
                            ilike("description", "%"+searchValue+"%")
                        }
                    };
                }
            } else {
                if(!StringUtils.isBlank(searchValue)) {
                    resources = Resource.createCriteria().listDistinct {
                        and{
                            or {
                                "topic" {
                                    ilike("name", "%" + searchValue + "%")
                                }
                                ilike("description", "%" + searchValue + "%")
                            }
                            or{
                                "topic" {
                                    eq("visibility", Topic.Visibility.PUBLIC)
                                }
                                "topic" {
                                    eq("createdBy",user)
                                }
                            }
                        }
                    };
                }

            }
        }
        return resources;
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
        String folderUrl = Constants.DOCUMENT_URL;
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