package net.objex.example.jaxrs;

import net.objex.example.jaxrs.net.objex.example.jaxrs.config.ApplicationConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Server {
    public static void main( final String[] args ) throws Exception {
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server( 8080 );

        // Register and map the dispatcher servlet
        final ServletHolder servletHolder = new ServletHolder( new CXFServlet() );
        final ServletContextHandler context = new ServletContextHandler();
        context.setContextPath( "/" );
        context.addServlet( servletHolder, "/*" );
        context.addEventListener( new ContextLoaderListener() );

        context.setInitParameter( "contextClass", AnnotationConfigWebApplicationContext.class.getName() );
        context.setInitParameter( "contextConfigLocation", ApplicationConfig.class.getName() );

        // Add Spring Security Filter by the name
        context.addFilter(new FilterHolder( new DelegatingFilterProxy( "springSecurityFilterChain" ) ), "/*", EnumSet.allOf( DispatcherType.class ));

        server.setHandler( context );
        server.start();
        server.join();

        // database
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}