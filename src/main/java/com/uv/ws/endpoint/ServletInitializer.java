package com.uv.ws.endpoint;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.ws.transport.http.support.AbstractAnnotationConfigMessageDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigMessageDispatcherServletInitializer {



    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebServiceConfig.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
}
