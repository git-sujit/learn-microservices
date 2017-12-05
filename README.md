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

Content Negotiation
	
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
	
	


	
