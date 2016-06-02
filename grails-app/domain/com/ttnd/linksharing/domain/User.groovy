package com.ttnd.linksharing.domain

class User {

    String email;
    String userName;
    String password;
    String firstName;
    String lastName;
    Byte photo;
    Boolean admin;
    Boolean active;
    Date dateCreated;
    Date lastUpdated;

    Set<Topic> topics;
    Set<Subscription> subscriptions;
    Set<Resource> resources;
    Set<ResourceRating> resourceRatings;
    Set<ReadingItem> readingItems;


    static hasMany = [topics : Topic, subscriptions : Subscription, resources : Resource,
                      resourceRatings : ResourceRating, readingItems : ReadingItem]

    static constraints = {
        email(unique: true, email: true, nullable: false, blank: false)
        password(nullable: false, blank: false, minSize: 5)
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        photo(nullable: true, blank: true)
        admin(nullable: true, blank: true)
        active(nullable: true, blank: true)

        userName(nullable: true, blank: true)
        topics(nullable: true, blank: true)
    }


    static transients = ['name']

    String getName(){
        return "${firstName} ${lastName}";
    }


}