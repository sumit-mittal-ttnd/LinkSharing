package com.ttnd.linksharing.domain

class ResourceRating {

    Resource resource;
    User createdBy;
    Integer score;
    Date dateCreated;
    Date lastUpdated;


    static belongsTo = [resource : Resource, createdBy : User]

    static constraints = {
        createdBy(nullable: false, unique: ['resource']) // Resourcerating can be given by a user only one time for a resource
        score(nullable: false, range: 1..5)
        resource(nullable: false)

    }
}
