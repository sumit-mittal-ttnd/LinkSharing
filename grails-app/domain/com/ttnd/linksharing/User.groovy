package com.ttnd.linksharing

class User {

    String email;
    String userName;
    String password;
    String confirmPassword;
    String firstName;
    String lastName;
    String photoUrl="temp";
    Boolean admin;
    String activateCode;
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
        confirmPassword(bindable: true, blank: true, nullable: true, validator: {cPwdVal,obj->
            if(cPwdVal == null || cPwdVal==obj.password) return true
            else return false
        })

        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        photoUrl(nullable: true, blank: true)
        admin(nullable: true, blank: true)
        active(nullable: true, blank: true)

        userName(unique: true, nullable: true, blank: true)
        topics(nullable: true, blank: true)
        activateCode(nullable: true, blank: true)
    }


    static transients = ['name', 'confirmPassword']

    static mapping = {
        sort name: "asc"
    }

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
        if (photoUrl != user.photoUrl) return false
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
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0)
        result = 31 * result + (admin != null ? admin.hashCode() : 0)
        result = 31 * result + (active != null ? active.hashCode() : 0)
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0)
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0)
        result = 31 * result + id.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}