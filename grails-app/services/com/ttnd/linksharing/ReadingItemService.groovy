package com.ttnd.linksharing

class ReadingItemService {

    void create(Topic topic, User user, Boolean isRead){
        Set<Resource> resources = topic.getResources();
        for(Resource resource : resources){
            // Because if user has added that resource then There shouldn't be entry in reading item
            if(!resource.getAddedBy().equals(user)){
                // check the record if same user with same resource already have reading item
                ReadingItem alreadyReadingItem = ReadingItem.findByResourceAndUser(resource, user);
                if(alreadyReadingItem == null){
                    ReadingItem readingItem = new ReadingItem(resource, user, isRead);
                    if(!readingItem.validate()){
                        log.error "Errors Occurred While Saving ReadingItem: "+readingItem.getErrors()
                    }else{
                        readingItem.save(flush: true, failOnError: true);
                        log.info "ReadingItem Persisted in the DB with ID "+readingItem.getId()
                    }
                }
            }
        }
    }








}