import com.ttnd.linksharing.domain.Topic
import com.ttnd.linksharing.domain.User

class BootStrap {

    def init = { servletContext ->

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
