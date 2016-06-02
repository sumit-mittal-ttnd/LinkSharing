package com.ttnd.linksharing.domain

class Topic {

    String name;
    User createdBy;
    Visibility visibility;
    Date dateCreated;
    Date lastUpdated;

    Set<Subscription> subscriptions;
    Set<Resource> resources;


    static hasMany = [subscriptions : Subscription, resources : Resource]

    static belongsTo = [createdBy : User]

    enum Visibility{
        PUBLIC,
        PRIVATE
    }

    static constraints = {
        name(nullable: false, blank: false, unique: ['createdBy']) // Unique per user constraint
        visibility(nullable: false)
        createdBy(nullable: false)
    }
}