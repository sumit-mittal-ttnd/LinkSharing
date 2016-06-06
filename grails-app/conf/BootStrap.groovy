import com.ttnd.linksharing.domain.DocumentResource
import com.ttnd.linksharing.domain.LinkResource
import com.ttnd.linksharing.domain.ReadingItem
import com.ttnd.linksharing.domain.Resource
import com.ttnd.linksharing.domain.ResourceRating
import com.ttnd.linksharing.domain.Subscription
import com.ttnd.linksharing.domain.Subscription.Seriousness
import com.ttnd.linksharing.domain.Topic
import com.ttnd.linksharing.domain.User

class BootStrap {

    def init = { servletContext ->

        // create User
        User user = new User(firstName: "normal", lastName: "user", userName: "normalUser", email : "normalUser@gmail.com", password: "password", active: Boolean.TRUE, admin: Boolean.FALSE );
        createUser(user);

        // create admin user
        User adminUser = new User(firstName: "admin", lastName: "user", userName: "adminUser", email : "adminUser@gmail.com", password: "admin", active: Boolean.TRUE, admin: Boolean.TRUE );
        createUser(adminUser);


        // createTopic
        //User user = User.findById(2L);
        Topic topic = new Topic(name: "Java", createdBy: user, visibility: Topic.Visibility.PRIVATE);
        createTopic(user, topic, Subscription.Seriousness.VERY_SERIOUS);

        // create link resource and document resource
        String url = "http://www.google.com/downloads/grailsPdf";
        String filePath = "D://Docs//grails.pdf"
        String description = "Document for Grails";
        //User user = User.findById(3L);
        //Topic topic = Topic.findById(1L);
        addLinkResources(user, topic, url, description);
        addDocumentResources(user, topic, filePath, description);








        // subscribe topic 3-1
        /*User user = User.findById(3L);
        Topic topic = Topic.findById(1L);
        subscribeTopic(user, topic, Subscription.Seriousness.CASUAL);*/
    }

    void createUser(User user){
        if(!user.validate()){
            log.error "Errors Occurred : "+user.getErrors()
        }else{
            user.save(flush: true, failOnError: true);
            log.info "User Persisted in the DB with ID "+user.getId()
        }
    }

    void createTopic(User user, Topic topic, Subscription.Seriousness seriousness){
        if(!topic.validate()){
            log.error "Errors Occurred While Saving Topic: "+topic.getErrors()
        }else{
            topic.save(flush: true, failOnError: true);
            log.info "Topic Persisted in the DB with ID "+topic.getId()

            Topic.withNewSession {session ->
                subscribeTopic(user, topic, seriousness);
            }
        }
    }

    void addLinkResources(User addedBy, Topic topic, String url, String description){
        LinkResource linkResource = new LinkResource(addedBy: addedBy, topic: topic, description: description, url: url);
        if(!linkResource.validate()){
            log.error "Errors Occurred While Saving LinkResource: "+linkResource.getErrors()
        }else{
            linkResource.save(flush: true, failOnError: true);
            log.info "LinkResource Persisted in the DB with ID "+linkResource.getId()
        }
    }

    void addDocumentResources(User addedBy, Topic topic, String filePath, String description){
        DocumentResource documentResource = new DocumentResource(addedBy: addedBy, topic: topic, description: description, filePath: filePath);
        if(!documentResource.validate()){
            log.error "Errors Occurred While Saving DocumentResource: "+documentResource.getErrors()
        }else{
            documentResource.save(flush: true, failOnError: true);
            log.info "DocumentResource Persisted in the DB with ID "+documentResource.getId()
        }
    }

    void subscribeTopic(User user, Topic topic, Subscription.Seriousness seriousness){
        if(!topic.createdBy.equals(user)){
            Subscription subscription = new Subscription(topic: topic, user: user, seriousness: seriousness);
            if(!subscription.validate()){
                log.error "Errors Occurred While Saving Subscription: "+subscription.getErrors();
            }else{
                subscription.save();
                // As he will subscribe the topic we will add entries in ReadingItem
                ReadingItem.withNewSession {session ->
                    Set<Resource> resources = topic.getResources();
                    for(Resource resource : resources){
                        // Because if user has added that resource then There shouldn't be entry in reading item
                        if(!resource.getAddedBy().equals(user)){
                            // check the record if same user with same resource already have reading item
                            ReadingItem alreadyReadingItem = ReadingItem.findByResourceAndUser(resource, user);
                            if(alreadyReadingItem == null){
                                createReadingItems(resource, user, Boolean.FALSE);
                            }
                        }
                    }
                }
                log.info "Subscription Persisted in the DB with ID "+subscription.getId();
            }
        } else{
            log.error "User can't subscribe his own topic";
        }
    }

   void createReadingItems(Resource resource, User user, Boolean isRead){
       ReadingItem readingItem = new ReadingItem(resource, user, isRead);
       if(!readingItem.validate()){
           log.error "Errors Occurred While Saving ReadingItem: "+readingItem.getErrors()
       }else{
           readingItem.save(flush: true, failOnError: true);
           log.info "ReadingItem Persisted in the DB with ID "+readingItem.getId()
       }
   }

    void createResourceRatings(Resource resource, User user, Integer score){
        ResourceRating alreadyResourceRating = ResourceRating.findByResourceAndUser(resource, user);
        if(alreadyResourceRating == null){
            ResourceRating resourceRating = new ResourceRating(resource : resource, user : user, score : score);
            if(!resourceRating.validate()){
                log.error "Errors Occurred While Saving ResourceRating: "+resourceRating.getErrors()
            }else{
                resourceRating.save(flush: true, failOnError: true);
                log.info "ResourceRating Persisted in the DB with ID "+resourceRating.getId()
            }
        }
    }










    void test(){
        User user = new User(firstName: "Sumit",lastName: "Mittal", email: "sumit.mittal@tothenew.com", userName: "sumit12", password: "password");
        println user.validate()

        Topic topic1 = new Topic(name: "Java", createdBy: user, visibility: Topic.Visibility.PRIVATE);
        println topic1.validate()

        Topic topic2 = new Topic(name: "C", createdBy: user, visibility: Topic.Visibility.PUBLIC);
        println topic2.validate()

        Topic topic3 = new Topic(name: "C++", createdBy: user, visibility: Topic.Visibility.PUBLIC);
        println topic3.validate()

        Topic topic4 = new Topic(name: ".NET", createdBy: user, visibility: Topic.Visibility.PRIVATE);
        println topic4.validate()

        Topic topic5 = new Topic(name: "Ruby", createdBy: user, visibility: Topic.Visibility.PUBLIC);
        println topic5.validate()

        user.setTopics([topic1, topic2, topic3, topic4, topic5] as Set);
        println "User validate : " + user.validate();
        println " user : " + user.save();
    }

    def destroy = {
    }
}