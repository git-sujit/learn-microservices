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
Common Feature of Microservices:
	
	- Small components
	- Independent deployment
	- Simple Communication between these microservices (RESTful services over HTTP)
	- Stateless
	- Dynamic scale up and scale down
	- Automated Build, Deployment and Testing
	- Refer:
		- https://martinfowler.com/articles/microservices.html
		- https://12factor.net/
		- https://dzone.com/articles/the-12-factor-app-a-java-developers-perspective
	

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
		- Add spring-cloud-config-server dependency to pom.xml
		- @EnableConfigServer on SpringBootApplication for config-server
		- application.properties
			- spring.cloud.config.server.git.uri=https://chaay-sujit@bitbucket.org/chaaynation/cn-configs.git
			- spring.cloud.config.server.git.username=cn-test-user
			- spring.cloud.config.server.git.password=Login123
		- Link Source:  To the folder where git repository is cloned 
		- Name of properties file in the Git MUST be same as the spring-cloud-config-client application-name
	- spring-cloud-config-client
		- Add spring-cloud-config-client dependency to pom.xml
		- bootstrap.properties
			- spring.cloud.config.uri=http://localhost:8888
			- spring.profiles.active=qa
		- Class for corresponding properties
			- @Component
			- @ConfigurationProperties("cn-test"): Must be same name as git-properties file / client-application-name
			- Class should have exactly the same instance variable as in the git-properties file
			
Netflix-Feign: Makes easy to invoke other REST services

	- Add spring cloud dependency for netflix-feign to pom.xml
	- @EnableFeignClients on spring boot application. Pass package to scan by feign
	- @Feign-Client("spring-boot-app-name"): Create Feign-Proxy for service to invoke outer service (Similar to JPA-Repository)
	- Use proxy to invoke outer service

Netflix-Eureka: Service Registry & Discovery

	- Eureka Naming Server
		- New Spring Boot Application having Eureka-Naming-Server dependency
		- @EnableEurekaServer
		- application.properties: server will nor register itself
			- eureka.client.register-with-eureka=false
			- eureka.client.fetch-registry=false
	- Eureka Naming Client
		- Add dependency: spring-cloud-starter-netflix-eureka-client
		- application.properties: Add eureka server End Point (Default port: 8761)
			- eureka.client.service-url.defaultZone=http://localhost:8010/eureka
		- @EnableEurekaClient: Add this annotation to SpringBootApplication class
		

Netflix-Ribbon (Works with Feign): Makes easy to invoke other REST services

	- Add spring cloud dependency for netflix-ribbon to pom.xml
	- @RibbonClient("spring-boot-app-name"): put on Feign-Proxy
	- application.properties: Naming server url to find all the servers(For service discovery) to be load-balanced
		- eureka.client.service-url.default-zone=http://localhost:8761/eureka

Netflix-Zuul: API Gateway Server

	- Why API Gateway
		- Provides Common features (Auth/Sec etc) for all microservices will be implemented at API Gateway
		- Fault Tolerance: If a microservice is down then some default begavior should kick-in
		- Service aggregation: aggregate multiple service and give one response instead of making multiple calls
	- Zuul Server set up
		- Add zuul API dependency to Spring boot application
		- @EnableZuulProxy: Put on spring boot application class
		- Intercept request and implement "What it should do"
			- New Class that extends ZuulFilter (Implement abstract methods)
			- Implement run() method, it will have logic
	- Zuul Client set up: No coding, just route it thru API Gateway by changing the end point URI
		- Microservice end point will have Zuul server end point
		- zuul-api server/{application-name}/uri
		- localhost:8003/cn-test/config (cn-test is registered with eureka naming server)

Distributed Tracing(Spring clound Sleuth with Zipkin)

	- Spring Cloud Sleuth: Assigns unique id to request so that request can be traced goes thru multiple microservices
	- Zipkin: Distributed tracing system
	- All logs will be put into Rabbit MQ 
	- These Rabbiut MQ logs will be sent to Zipkin
	
	
Spring Cloud Sleuth

	- Add spring cloud dependency for Sleuth to pom.xml
	- Goto SpringBootApplication class
		- create method defaultSampler() method
		
Centralize The Log: 

	- Zipkin/Rabbit MQ
	- ELK/Kafka Appender

Spring Cloud Bus

	- Why:
		- Spring cloud config refers to properties files present in GIT repository
		- If properties file is changed to new value then it will not reflect automatically
		- Invoke actuator endpoiont to reflect the changes: localhost:8080/application/refresh
		- This needs to be run for all microservices pointing to this properties file
		- Spring cloud bus: Provides one url which refreshes all the instances of microserevices
	- Spring cloud is used with 
		- RabbitMQ or
		- Kafka
		
Hystrix: Fault Tolerance(What if some functionality is not working as expected, then have some default behavior)

	- In microservices architecture there are many many mi croservices which interact with each other
	- If one service is down then it can bring other services down as well
	- So, we need to make our microservices fault tolerant
	- Hystrix helps building Fault Tolerent microservices
	- @EnableHystrix: put on springboot application
	- @HystrixCommand(fallbackMethod = "fallbackRetrieveConfig"): Put on method/Service endpoint

Distributed Logging Architecture for Microservices

	- https://dzone.com/articles/distributed-logging-architecture-for-microservices
	- Why
		- microservices run on multiple hosts
		- To fulfill single business requirement it may talk to multiple services running on different machines
		- So, we should send all the generated logs across the hosts to an external, centralized place (Kafka/RabbitMQ)
	- Correlation ID: generate unique id and pass across all the microservices invoked for single request
		- Spring cloud Sleuth

# JPA:

	- One-To-Many establishment between Product & ProductCategory
		- One category - Many products
		- Both MappedBy & JoinColumn will refer to the same column in Product table
		- Product bean: JoinColumn will be the name of Column in Product table
			@ManyToOne(fetch = FetchType.EAGER)
			@JoinColumn(name = "productCategory", nullable = true)
			private CnProductCategory productCategory;
		- ProductCategory bean: mapped by is the name of column in Product table
			@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
			private Set<CnProduct> products;
# Liquibase

	- Database migration tool
	- Write your schema and data agnostic of database
	- help you create the schema, run them during deployment and also help you write automated 
		tests so that you are confident that your changes will work in production
	- Spring-boot provides the support for both Flyway and Liquibase out of the box.
	- Pom dependency: <artifactId>liquibase-core</artifactId>
	- 
		
# References:

	- Custom ID generator
		https://vladmihalcea.com/how-to-implement-a-custom-string-based-sequence-identifier-generator-with-hibernate/
	- HTTP PUT, PATCH or POST - Partial updates or full replacement?
		http://soabits.blogspot.dk/2013/01/http-put-patch-or-post-partial-updates.html
	- Spring security 
		https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d
		https://github.com/TechPrimers/spring-security-db-example.git
	- 
		
