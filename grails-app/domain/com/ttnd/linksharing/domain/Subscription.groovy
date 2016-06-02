package com.ttnd.linksharing.domain

class Subscription {

    Topic topic;
    User user;
    Seriousness seriousness;
    Date dateCreated;
    Date lastUpdated;


    enum Seriousness{
        SERIOUS,
        VERY_SERIOUS,
        CASUAL
    }

    static belongsTo = [user : User, topic : Topic]

    static constraints = {
        user(nullable: false, unique: ['topic'])  // user should not be able to subscribe to topic multiple times
        topic(nullable: false)
        seriousness(nullable: false)
    }
}