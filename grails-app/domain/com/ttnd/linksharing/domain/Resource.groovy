package com.ttnd.linksharing.domain

abstract class Resource {

    User createdBy;
    Topic topic;
    String description;
    Date dateCreated;
    Date lastUpdated;

    Set<ResourceRating> resourceRatings;
    Set<ReadingItem> readingItems;


    static hasMany = [resourceRatings : ResourceRating, readingItems : ReadingItem]

    static belongsTo = [createdBy : User, topic : Topic]

    static constraints = {
        createdBy(nullable: false)
        description(nullable: true, blank: true)
        topic(nullable: false)
    }
}
