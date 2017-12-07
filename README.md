# PART-1:Restful Web Services with Spring Boot
# Basic Topics
Setup Spring Boot Starter project

	- https://start.spring.io/
	- web, DevTools, JPA, H2
Spring Boot Auto configuration:

	- DispatcherServletAutoConfiguration: Configures spring's disapatcher servlet
	- ErrorMVCAutoConfiguration: Configures basic error page/whitelable error page
	- HttpMessageConverterAutoConfiguration: Jackson2ObjectMapper does json to bean and bean to json
	- Puts Spring MVC in classpath so that Dispatcher servlet is available
	- Dispatcher servlet follows the front controller design pattern
	-
Steps:

	- Dispatcher Servlet routes the request based on 
		- Dispatcher servlet knows about all the controllers and URI mapping
		- HTTP Method and URI
	- @RESTController has methods which maps to URI
		- @ResponseBody which converts the output to Response
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
	- Not very well used in applications but good to know
# Advanced Topics

Internationalization

	- LocaleResolver: To set default locale 
	- ResourceBundleMessageSource: To set up the messageSource(.properties files)

Content Negotiation(Json, XML etc)
	
	- Determining the content in the response: JSON or XML
	- To avoid HTTP_RESPONSE_CODE=406: Not Acceptable
	- Jackson2Object is used for Json to Object conversion and vice versa
	- jackson-dataformat-xml for XML to object conversion and vice versa
	- Request Header: Accept: application/xml
	
Swagger Documentation
	
	- To share the RESTFul services with consumer
	- To generate SOAP-WSDLS like documentation about the RESTFul services
	- POM dependency for swagger: springfox-swagger2 and swaggerUI
	- Details/Documentation about RESTFul services
		- Thru REST API: http://localhost:8080/v2/api-docs
		- Thru UI: http://localhost:8080/swagger-ui.html
	- ApiModel & ApiModelProperty to add description at bean-property level in Swagger documentation
Monitoring by Spring Actuator
	
	- Spring actuator provides monitoring of RESTful web services
	- Hal browser: To look monitoring provided by actuator in browser
	- HAL: Hypertext Application Language
	- localhost:8080/application or http://localhost:8080/actuator	
Filtering
	
	- To filter attributes in the response like card number / password
	Static Filtering:
		- Field is ignored across all the response/bean
		- Annotation at Bean level
			- @JsonIgnore at bean-field level: Better approach
			- @JsonIgnoreProperties: At bean class level
	Dynamic Filtering:
		- Response specific bean-field ignorance
		- Annotation at RestController level. Classes used
			- FilterProvider
			- MappingJacksonValue
Version of RESTful services: No perfect solution
	
	- URI Versioning: Different URI for different version(URI Pollution)
		- localhost:8080/v1/customer 
		- localhost:8080/v2/customer
		- Twitter
	- Request Parameter versioning: Same URI but request param has different versions(URI Pollution)
		- http://localhost:8080/customer?version=1
		- http://localhost:8080/customer?version=2
		- Amazon
	- Custom Header versioning (Caching is difficult / Cant run on browser / Misuse of headers)
		- Add header parameter: SKS_SVC_VERSION=1.0.0
		- Microsoft
	- Mime Type Versioning, Accept header or Produces versioning(Caching is difficult / Cant run on browser / Misuse of headers)
		- Add header parameter: Accept=abndb
		- Github
Secure RESTFul Web Services

	- Types of authentication
		- Basic authentication: Passing User Id/Pwd
		- Digest authentication: Digest is created out of id/pwd and passed
		- OAuth / OAuth 2
	- How to turn on authentication in spring application
		- add dependecy in pom: spring-boot-starter-security
		- default user is user and password is in start up log
		- configure user in application.properties file
			- security.user.name
			- security.user.password

			

		

		
	
	
	


	
