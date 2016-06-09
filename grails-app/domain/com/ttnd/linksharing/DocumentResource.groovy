package com.ttnd.linksharing

class DocumentResource extends Resource {

    String filePath;


    static constraints = {
        filePath(nullable: false, blank: false)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof DocumentResource)) return false

        DocumentResource that = (DocumentResource) o

        if (filePath != that.filePath) return false
        if (id != that.id) return false
        if (version != that.version) return false

        return true
    }

    int hashCode() {
        int result
        result = filePath.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}
