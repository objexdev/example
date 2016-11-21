# Simple Apache CXF, Spring Security Example with Stand-alone Embedded Jetty Server
Java JAX-RS, HSQLDB Embedded Database, Embedded Jetty and Spring Security Example

##Install

git clone https://github.com/objexdev/example.git

mvn clean package

##Run App

java -jar target/simple-jaxrs-1.jar

##Test Persistence

Save (saves a list of products)
curl -u user:password http://localhost:8080/simple-jaxrs/prodcut/save
List all products
curl user:password http://localhost:8080/simple-jaxrs/prodcut/all

Product details
curl user:password http://localhost:8080/simple-jaxrs/prodcut/1
REST Service Security - Test with or without credentials

HTTP/200
curl -u user:password http://localhost:8080/simple-jaxrs/prodcut/list
HTTP/401
curl http://localhost:8080/simple-jaxrs/product/list
