package com.management.hospital.serviceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class something {

    public something(){
        System.err.println("Something loaded");
    }


    //method - load nahi hot fkt vrcha class load hotoy - use annotation @Bean
    @Bean
    public String getSomething(){
        System.err.println("get something execute");
        return "something";
    }
}
