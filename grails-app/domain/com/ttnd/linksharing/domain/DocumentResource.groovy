package com.ttnd.linksharing.domain

class DocumentResource extends Resource {

    String filePath;


    static constraints = {
        filePath(nullable: false, blank: false)
    }
}
