package com.ttnd.linksharing.domain

class ReadingItem {

    Resource resource;
    User user;
    Boolean isRead;
    Date dateCreated;
    Date lastUpdated;


    static belongsTo = [resource : Resource, user : User]

    static constraints = {
        resource(nullable: false, unique: ['user'])
        user(nullable: false)
        isRead(nullable: false)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof ReadingItem)) return false

        ReadingItem that = (ReadingItem) o

        if (dateCreated != that.dateCreated) return false
        if (id != that.id) return false
        if (isRead != that.isRead) return false
        if (lastUpdated != that.lastUpdated) return false
        if (resource != that.resource) return false
        if (user != that.user) return false
        if (version != that.version) return false

        return true
    }

    int hashCode() {
        int result
        result = resource.hashCode()
        result = 31 * result + user.hashCode()
        result = 31 * result + isRead.hashCode()
        result = 31 * result + dateCreated.hashCode()
        result = 31 * result + lastUpdated.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}
