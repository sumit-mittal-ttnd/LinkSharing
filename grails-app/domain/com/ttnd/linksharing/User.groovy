package com.ttnd.linksharing

class User {

    String email;
    String userName;
    String password;
    String confirmPassword;
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
        password(nullable: false, blank: false, minSize: 5 /*, validator: {password, obj ->
                                                                            def confirmPassword = obj.properties['confirmPassword'];
                                                                            if(confirmPassword == null) return true;
                                                                            password == confirmPassword ? true : "Password Mismatch";
                                                                        }*/
        )

        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        photo(nullable: true, blank: true)
        admin(nullable: true, blank: true)
        active(nullable: true, blank: true)

        userName(nullable: true, blank: true)
        topics(nullable: true, blank: true)
    }


    static transients = ['name', 'confirmPassword']

    String getName(){
        return "${firstName} ${lastName}";
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof User)) return false

        User user = (User) o

        if (active != user.active) return false
        if (admin != user.admin) return false
        if (dateCreated != user.dateCreated) return false
        if (email != user.email) return false
        if (firstName != user.firstName) return false
        if (id != user.id) return false
        if (lastName != user.lastName) return false
        if (lastUpdated != user.lastUpdated) return false
        if (password != user.password) return false
        if (photo != user.photo) return false
        if (readingItems != user.readingItems) return false
        if (resourceRatings != user.resourceRatings) return false
        if (resources != user.resources) return false
        if (subscriptions != user.subscriptions) return false
        if (topics != user.topics) return false
        if (userName != user.userName) return false
        if (version != user.version) return false

        return true
    }

    int hashCode() {
        int result
        result = email.hashCode()
        result = 31 * result + (userName != null ? userName.hashCode() : 0)
        result = 31 * result + password.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + (photo != null ? photo.hashCode() : 0)
        result = 31 * result + (admin != null ? admin.hashCode() : 0)
        result = 31 * result + (active != null ? active.hashCode() : 0)
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0)
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0)
        result = 31 * result + id.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}