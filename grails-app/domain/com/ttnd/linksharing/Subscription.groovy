package com.ttnd.linksharing

class Subscription {

    Topic topic;
    User user;
    Seriousness seriousness = Seriousness.VERY_SERIOUS;
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

    static mapping = {
        topic lazy:false
        user lazy: false
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Subscription)) return false
        Subscription that = (Subscription) o
        if (dateCreated != that.dateCreated) return false
        if (id != that.id) return false
        if (lastUpdated != that.lastUpdated) return false
        if (seriousness != that.seriousness) return false
        if (version != that.version) return false
        return true
    }

    int hashCode() {
        int result
        result = seriousness.hashCode()
        result = 31 * result + dateCreated.hashCode()
        result = 31 * result + lastUpdated.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}