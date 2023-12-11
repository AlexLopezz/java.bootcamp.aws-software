package com.ar.alexdev.cxfspringbootws_CRUD.config;

import com.ar.alexdev.cxfspringbootws_CRUD.services.impl.UserServicesImpl;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CxfConfig {
    //Config dispatch:
    @Bean
    @Primary
    public DispatcherServletPath dispatchProvider() { return () -> ""; }

    @Bean
    public ServletRegistrationBean<CXFServlet> dispatchServlet(){
        return new ServletRegistrationBean<>(new CXFServlet(), "/*");
    }

    //Config endpoints:
    @Bean
    public Endpoint userEndpoints(Bus bus, UserServicesImpl userServices){
        EndpointImpl endpoint = new EndpointImpl(bus, userServices);
        endpoint.publish("/user");


        return endpoint;
    }
}
