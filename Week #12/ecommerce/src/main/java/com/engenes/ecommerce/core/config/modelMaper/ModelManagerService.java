package com.engenes.ecommerce.core.config.modelMaper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelManagerService implements IModelMapperService{

    private final ModelMapper modelMapper;

    // bean de oluşan nesneyi ataması yapıyor
    @Autowired
    public ModelManagerService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        // responsda standarta uygun yap dışardan gelen bir veri
        this.modelMapper.getConfiguration().
                setAmbiguityIgnored(true).
                setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }

    // requestte bulunurken biraz daha snek olar benzer yakınları matchle response u biz veriyoruz
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().
                setAmbiguityIgnored(true).
                setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }
}
