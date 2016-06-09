package com.ttnd.linksharing

abstract class Resource {

    User addedBy;
    Topic topic;
    String description;
    Date dateCreated;
    Date lastUpdated;

    Set<ResourceRating> resourceRatings;
    Set<ReadingItem> readingItems;


    static hasMany = [resourceRatings : ResourceRating, readingItems : ReadingItem]

    static belongsTo = [addedBy : User, topic : Topic]

    static constraints = {
        addedBy(nullable: false)
        description(nullable: true, blank: true)
        topic(nullable: false)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Resource)) return false

        Resource resource = (Resource) o

        if (addedBy != resource.addedBy) return false
        if (dateCreated != resource.dateCreated) return false
        if (description != resource.description) return false
        if (id != resource.id) return false
        if (lastUpdated != resource.lastUpdated) return false
        if (readingItems != resource.readingItems) return false
        if (resourceRatings != resource.resourceRatings) return false
        if (topic != resource.topic) return false
        if (version != resource.version) return false

        return true
    }

    int hashCode() {
        int result
        result = 31 * result + (description != null ? description.hashCode() : 0)
        result = 31 * result + dateCreated.hashCode()
        result = 31 * result + lastUpdated.hashCode()
        result = 31 * result + (id != null ? id.hashCode() : 0)
        result = 31 * result + (version != null ? version.hashCode() : 0)
        return result
    }
}
