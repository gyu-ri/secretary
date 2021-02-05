package com.nj.secretary.services.diary;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/diaryImage/**").addResourceLocations("file:///C:\\Users\\clipse\\IdeaProjects\\secretary\\src\\main\\resources\\static\\images\\diaryImage");
    }
}
