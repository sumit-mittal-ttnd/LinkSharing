package com.ttnd.linksharing

class ApplicationTagLib {

    private static final String USER_ID = "userId";

    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    //static defaultEncodeAs = [taglib:'html']
    static namespace = "tg";

    def userImage = { attrs, body ->
        Long userId = attrs.get(USER_ID);
        // remove userId attr from tag
        attrs.remove('userId')
        if (userId) {
            String parameters = attrs.collect { "${it.key}='${it.value}'" }.join(" ")
            out << "<img src='${createLink(controller: 'login', action: 'image', id: userId)}' ${parameters}/>"
        }
    }




}