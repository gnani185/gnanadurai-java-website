package com.gnanadurai.website.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.gnanadurai.website.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
   
   @Override
   public void addResourceHandlers(final ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/css/**").addResourceLocations("/assets/css/");
       registry.addResourceHandler("/fonts/**").addResourceLocations("/assets/fonts/");
       registry.addResourceHandler("/images/**").addResourceLocations("/assets/images/");
       registry.addResourceHandler("/js/**").addResourceLocations("/assets/js/");
   }

}