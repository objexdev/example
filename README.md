# Simple Apache CXF, Spring Security Example with Stand-alone Embedded Jetty Server
Java JAX-RS, HSQLDB Embedded Database, Embedded Jetty and Spring Security Example

##Install

git clone https://github.com/objexdev/simple-jaxrs.git

mvn clean package

##Run App

java -jar target/simple-jaxrs-1.jar

##Test Persistence

<dl>
  <dt>Save Products</dt>
  <dd>curl -u user:password http://localhost:8080/simple-jaxrs/prodcut/save</dd>

  <dt>List products</dt>
  <dd>curl user:password http://localhost:8080/simple-jaxrs/prodcut/all</dd>
  
  <dt>Product details</dt>
  <dd>curl user:password http://localhost:8080/simple-jaxrs/prodcut/1</dd>  
</dl>

##REST Service Security - Test with or without credentials

<dl>
  <dt>HTTP/200</dt>
  <dd>curl -u user:password http://localhost:8080/simple-jaxrs/prodcut/list</dd>
  
  <dt>HTTP/401</dt>
  <dd>curl http://localhost:8080/simple-jaxrs/product/list</dd>  
</dl>
