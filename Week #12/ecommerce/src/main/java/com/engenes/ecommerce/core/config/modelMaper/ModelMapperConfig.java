package com.engenes.ecommerce.core.config.modelMaper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    // proje başladığında bean oluşturuğ birtane model mapper nesnesi oluşturup IoC container a atıcak
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
