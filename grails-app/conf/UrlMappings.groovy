class UrlMappings {

	static mappings = {


        "/"(controller: "login", action: "index")
        "500"(view:'/error-500')
        "404"(view:'/error-404')


        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        /*"/"(view:"/index")*/

	}

}