package com.ttnd.linksharing

class ReadingItemController {

    def index() { }

    void create(Resource resource, User user, Boolean isRead){
        ReadingItem readingItem = new ReadingItem(resource, user, isRead);
        if(!readingItem.validate()){
            log.error "Errors Occurred While Saving ReadingItem: "+readingItem.getErrors()
        }else{
            readingItem.save(flush: true, failOnError: true);
            log.info "ReadingItem Persisted in the DB with ID "+readingItem.getId()
        }
    }
}
