package com.example.officeProductSelector.config;

import com.example.officeProductSelector.dto.ProductDTO;
import com.example.officeProductSelector.model.Product;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;

public class MappingConfig {

    public BeanMappingBuilder beanMappingBuilder(){
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Product.class, ProductDTO.class);
            }
        };
    }
    @Bean
    public DozerBeanMapper beanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(beanMappingBuilder());
        return dozerBeanMapper;
    }
}
