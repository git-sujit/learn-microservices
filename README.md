# PART-1:Restful Web Services with Spring Boot
Setup Spring Boot Starter project
	- https://start.spring.io/
	- web, DevTools, JPA, H2
Spring Boot Auto configuration
	- Puts Spring MVC in classpath so that Dispatcher servlet is available
	- Dispatcher servlet follows the front controller design pattern
	- 
Steps:
	- Spring Boot Application
		- Dispatcher Servlet routes the resquest based on 
			- HTTP Method and URI
		- RESTController has methods which maps to URI
		- Methods return Objects/Beans which is convertes back to JSON by Jackson(Spring Boot auto config)
		- ResponseEntityExceptionHandler
			- Define methods and type of exceptions to be handled
			- Define ExceptionResponse
		- Return ResponseEntity	
	- Request/Response validation
		- javax.validation / hibernate.validation package
HATEOS: Hypermedia as The Engine of Application State
	- To pass additional data/metadat in the REST response
	- e.g: returning additional/useful information/links in the response
	- Add spring-boot-starter-hateoas dependency in the POM
	- Note: ControllerLinkBuilder and Resource classes on hateoas
