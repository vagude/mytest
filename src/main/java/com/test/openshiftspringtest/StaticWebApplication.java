package com.test.openshiftspringtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class StaticWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StaticWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(getClass());
    }

}