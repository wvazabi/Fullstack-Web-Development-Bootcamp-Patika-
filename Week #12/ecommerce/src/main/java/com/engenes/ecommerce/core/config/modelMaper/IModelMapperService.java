package com.engenes.ecommerce.core.config.modelMaper;

import org.modelmapper.ModelMapper;

public interface IModelMapperService  {

    ModelMapper forRequest();
    ModelMapper forResponse();

}
