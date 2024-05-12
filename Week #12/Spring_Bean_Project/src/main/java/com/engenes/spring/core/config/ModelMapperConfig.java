package com.engenes.spring.core.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig  {
@Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        //loose olması birazdaha esnek camel case de bezeyen ama faklı olanları gözardı et vb.
        //matchlemek için otomatik olarak yapıyor
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }
}
