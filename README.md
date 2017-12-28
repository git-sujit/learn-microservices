# PART-1:Restful Web Services with Spring Boot
# Basic Topics
Setup Spring Boot Starter project

	- https://start.spring.io/
	- web, DevTools, JPA, H2
Spring Boot Auto configuration:

	- DispatcherServletAutoConfiguration: Configures spring's dispatcher servlet
	- ErrorMVCAutoConfiguration: Configures basic error page/whitelable error page
	- HttpMessageConverterAutoConfiguration: Jackson2ObjectMapper does json to bean and bean to json
	- Spring Boots Puts Spring MVC in classpath so that Dispatcher servlet is available
	- Dispatcher servlet follows the front controller design pattern
	-
Steps:

	- Dispatcher Servlet routes the request based on 
		- HTTP Method and URI
		- Dispatcher servlet knows about all the controllers and URI mapping
	- @RESTController has methods which maps to URI
		- @PathVariable: To get variable from URI
		- @RequestBody: To get http request body
		- @ResponseBody which converts the output to Response
	- Methods return Objects/Beans which is converts back to JSON by Jackson(Spring Boot auto config)
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
JPA

	- To make a bean as entity: Add @Entity annotation
	- Spring autoconfiguration creates the Table based on annotation
	- Pom dependency
		- spring-boot-starter-data-jpa
		- In memory db: H2
	- Using javax.persistence.*
	- application.properties
		- spring.jpa.show-sql=true
		- spring.h2.console.enabled=true
	- To insert data to table: create data.sql file in src/main/resources
	- To access H2 console
		- Set property: spring.h2.console.enabled=true
		- http://localhost:8080/h2-console
			- In console set [JDBC URL jdbc:h2:mem:testdb]
	- Getting data from database
		- Create interface which extends JpaRepository: Put @Repository
		- Inject this repository into the controller
		- Call methods on the repository like, findAll() etc
		- Spring autoconfiguration gets the correct class, creates object and calls findAll() method

# MICROSERVICES / Architectural Style
What is Microservices

	- REST based Small autonomous services that work together
	- Architectural style to develop single application as suite of small services
	- Each service is deployed independently as one or more instance depending on load
	- Each service runs in its own process
	- Should be cloud enabled
Challenges with Microservices
	
	- How to identify boundary(what to do in this service) of a service, Generally evolves
	- Configuration management: Multiple instance of microservice with multiple environment(DevOps)
	- Dynamic scale up and scale down depending upon load. Dynamic load balancing(DevOps)
	- Visibility: Multiple microservices so logging and monitoring is require to identify problem
	- Pack of Card: Services are build one top of other, so if fails depending services will fail to(Fault Tolerance)
Spring Cloud

	- Provides solution to above challenges of microservices
	- 	
Advantages of Microservices Architecture

	- Easy to adapt new technology which is difficult in Monolith
		- MS-1: Java, MS-2: .net, MS-3: Cotlin, MS-4: future technology
	- Dynamic scaling: Cloud enabled microservices can be scale up or down depending upon the load
	- Faster release cycle: Continuous deployment
Spring Cloud Config Server

	- Put configs in git and spring cloud config takes from there
	- spring-cloud-config-server
		- @EnableConfigServer on SpringBootApplication for config-server
		- application.properties
			- spring.cloud.config.server.git.uri=https://chaay-sujit@bitbucket.org/chaaynation/cn-configs.git
			- spring.cloud.config.server.git.username=cn-test-user
			- spring.cloud.config.server.git.password=Login123
		- Link Source:  To the folder where git repository is cloned 
		- Name of properties file in the Git MUST be same as the spring-cloud-config-client application-name
	- spring-cloud-config-client
		- @EnableDiscoveryClient on SpringBootApplication for config-client
		- Class for corresponding properties
			- @Component
			- @ConfigurationProperties("cn-test"): Must be same name as git-properties file / client-application-name
			- Class should have exactly the same instance variable as in the git-properties file
			
	
		
	
	
	
	

			

		

		
	
	
	


	
