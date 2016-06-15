package com.ttnd.linksharing

class ApplicationFilters {

    def filters = {

        loginCheck(controller:'login', action:'*', invert : true) {
            before = {
                User user = session.getAttribute("user");
                if(user == null || !user.getActive()){
                    redirect (controller: 'login', action: 'index')
                }
            }


            after = { Map model ->
            }


            afterView = { Exception e ->
            }
        }


    }
}
