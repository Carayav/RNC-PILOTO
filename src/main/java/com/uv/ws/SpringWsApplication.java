package com.uv.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages= {"com.uv"})
public class SpringWsApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(SpringWsApplication.class, args);
  }


   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(SpringWsApplication.class);
   }


}
