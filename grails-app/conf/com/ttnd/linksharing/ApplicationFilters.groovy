package com.ttnd.linksharing

class ApplicationFilters {

    SubscriptionService subscriptionService;
    TopicService topicService;

    def filters = {

        loginCheck(controller: 'login', action: '*', invert: true) {
            before = {
                User user = User.get(session.getAttribute("userId"));
                if (user == null || !user.getActive()) {
                    redirect(controller: 'login', action: 'index')
                    return false;
                }
            }

            after = { Map model ->
                if (model != null) {
                    User user = User.load(session.getAttribute("userId"));
                    model.subscribedTopics = subscriptionService.findSubscribedTopics(user);
                    model.topicsList = topicService.findTopics(user);
                }
            }


            afterView = { Exception e ->
            }
        }

    }
}