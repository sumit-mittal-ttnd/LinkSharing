package com.ttnd.linksharing

class LinkResource extends Resource{

    String url;


    static constraints = {
        url(url: true, nullable: false, blank: false)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof LinkResource)) return false

        LinkResource that = (LinkResource) o

        if (id != that.id) return false
        if (url != that.url) return false
        if (version != that.version) return false

        return true
    }

    int hashCode() {
        int result
        result = url.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}
