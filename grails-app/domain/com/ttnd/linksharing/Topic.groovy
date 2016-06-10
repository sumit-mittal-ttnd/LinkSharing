package com.ttnd.linksharing

class Topic {

    String name;
    User createdBy;
    Visibility visibility;
    Date dateCreated;
    Date lastUpdated;

    Set<Subscription> subscriptions;
    Set<Resource> resources;

    enum Visibility{
        PUBLIC,
        PRIVATE
    }

    static hasMany = [subscriptions : Subscription, resources : Resource]

    static belongsTo = [createdBy : User]

    static constraints = {
        name(nullable: false, blank: false, unique: ['createdBy']) // Unique per user constraint
        visibility(nullable: false)
        createdBy(nullable: false)
    }

    static mapping = {
        sort id: "desc"
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Topic)) return false

        Topic topic = (Topic) o

        if (createdBy != topic.createdBy) return false
        if (dateCreated != topic.dateCreated) return false
        if (id != topic.id) return false
        if (lastUpdated != topic.lastUpdated) return false
        if (name != topic.name) return false
        if (resources != topic.resources) return false
        if (subscriptions != topic.subscriptions) return false
        if (version != topic.version) return false
        if (visibility != topic.visibility) return false

        return true
    }

    int hashCode() {
        int result
        result = name.hashCode()
        result = 31 * result + createdBy.hashCode()
        result = 31 * result + visibility.hashCode()
        result = 31 * result + dateCreated.hashCode()
        result = 31 * result + lastUpdated.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}