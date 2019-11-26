# Spring-boot-mvc-jsp

This Demo App uses Spring Boot for creating a simple MVC application which uses JSP for view

Basic database operations using Spring Data explained with simple examples

Create a Spring Boot application using https://start.spring.io (Spring Initializer) by chosing dependencies as Spring Web 

Please add the following 

Application.properties

```
spring.mvc.view.prefix=/WEB-INF/pages/
spring.mvc.view.suffix=.jsp
```

Add Tomcat Embed Jasper to parse JSP

Prefer the latest version from https://mvnrepository.com/artifact/org.apache.tomcat.embed/tomcat-embed-jasper 

```
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <version>9.0.8</version>
</dependency>
```
