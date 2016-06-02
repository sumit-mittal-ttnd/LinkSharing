package com.ttnd.linksharing.domain

class LinkResource extends Resource{

    String url;


    static constraints = {
        url(url: true, nullable: false, blank: false)
    }
}
