package com.ttnd.linksharing

class ApplicationFilters {

    def filters = {

        loginCheck(controller:'login', action:'*', invert : true) {
            before = {
                User user = session.getAttribute("user");
                if(user == null ){
                    redirect (controller: 'login', action: 'index')
                    return false;
                }else if(user.getActive()){
                    redirect (controller: 'login', action: 'index')
                    return false;
                }
            }


            after = { Map model ->
            }


            afterView = { Exception e ->
            }
        }


    }
}
