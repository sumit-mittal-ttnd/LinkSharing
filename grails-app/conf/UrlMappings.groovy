class UrlMappings {

	static mappings = {


        "/"(controller: "login", action: "index")


        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "500"(view:'/error')
        /*"/"(view:"/index")*/

	}

}