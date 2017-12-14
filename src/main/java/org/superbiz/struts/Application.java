package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Filter;

@SpringBootApplication
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean struts2() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FilterDispatcher());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("actionPackages", "com.lq");
        registration.setName("struts2");
        registration.setOrder(0);
        return registration;
    }

    @Bean
    public FilterRegistrationBean strutsCleanup() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ActionContextCleanUp());
        registration.addUrlPatterns("/*");
        //registration.addInitParameter("actionPackages", "com.lq");
        registration.setName("struts-cleanup");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean sitemesh() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new PageFilter());
        registration.addUrlPatterns("/*");
        //registration.addInitParameter("actionPackages", "com.lq");
        registration.setName("sitemesh");
        registration.setOrder(2);
        return registration;
    }



}
