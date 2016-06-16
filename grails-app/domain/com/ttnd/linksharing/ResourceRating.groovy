package com.ttnd.linksharing

class ResourceRating {

    Resource resource;
    User user;
    Integer score;
    Date dateCreated;
    Date lastUpdated;


    static belongsTo = [resource : Resource, user : User]

    static constraints = {
        user(nullable: false, unique: ['resource']) // Resourcerating can be given by a user only one time for a resource
        score(nullable: false, range: 1..5)
        resource(nullable: false)
    }

    def afterInsert = {
        ResourceRating.withNewSession {session ->
            int count = ResourceRating.countByResource(this.resource);
            int newAvgRating = 0;
            List<ResourceRating> list = ResourceRating.findByResource(this.resource);
            for(ResourceRating resRat : list){
                newAvgRating += resRat.score;
            }
            this.resource.avgRating = newAvgRating/count;
            this.resource.save(flush: true, failOnError: true);
        }
    }


    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof ResourceRating)) return false

        ResourceRating that = (ResourceRating) o

        if (dateCreated != that.dateCreated) return false
        if (id != that.id) return false
        if (lastUpdated != that.lastUpdated) return false
        if (score != that.score) return false
        if (version != that.version) return false

        return true
    }

    int hashCode() {
        int result
        result = resource.hashCode()
        result = 31 * result + score.hashCode()
        result = 31 * result + dateCreated.hashCode()
        result = 31 * result + lastUpdated.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}
