package net.objex.example.jaxrs.net.objex.example.jaxrs.config;


import java.util.Arrays;

import javax.ws.rs.ext.RuntimeDelegate;

import net.objex.example.jaxrs.ProductService;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.jsrjsonp.JsrJsonpProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

/**
 * Created by mazharchoudhry on 2016-11-20.
 */
@Configuration
@Import( InMemorySecurityConfig.class )
public class ApplicationConfig {
    @Bean( destroyMethod = "shutdown" )
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean @DependsOn ( "cxf" )
    public Server jaxRsServer() {
        JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint( jaxRsApiApplication(), JAXRSServerFactoryBean.class );
        factory.setServiceBeans( Arrays.< Object >asList( productRestService() ) );
        factory.setAddress( factory.getAddress() );
        factory.setProviders( Arrays.< Object >asList( new JsrJsonpProvider() ) );
        return factory.create();
    }

    @Bean
    public JaxRsApiApplication jaxRsApiApplication() {
        return new JaxRsApiApplication();
    }

    @Bean
    public ProductService productRestService() {
        return new ProductService();
    }
}