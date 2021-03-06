package com.ttnd.linksharing

class ApplicationFilters {

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
                    model.subscribedTopics = topicService.findSubscribedTopicsByUser(user);
                }
            }
            afterView = { Exception e ->
            }
        }

        preLogin(controller: 'login', action: '*') {
            after = { Map model ->
                if (model != null) {
                    User user = User.get(session.getAttribute("userId"));
                    if(user != null){
                        model.subscribedTopics = topicService.findSubscribedTopicsByUser(user);
                    }
                }
            }
            afterView = { Exception e ->
            }
        }


    }
}