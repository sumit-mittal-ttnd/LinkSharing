package com.ttnd.linksharing

class ApplicationFilters {

    SubscriptionService subscriptionService;

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
                    model.userFirstName = user.getFirstName();
                    model.subscribedTopics = subscriptionService.findSubscribedTopics(user);
                }
            }


            afterView = { Exception e ->
            }
        }


    }
}