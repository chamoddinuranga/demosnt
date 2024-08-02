package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.RecipeDetailDTO;
import com.example.demo.entity.RecipeDetail;
import com.example.demo.entity.Product;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

//        // Configure mapping between RecipeDetail and RecipeDetailDTO
//        modelMapper.addMappings(new PropertyMap<RecipeDetail, RecipeDetailDTO>() {
//            @Override
//            protected void configure() {
//                map().setRecipeId(source.getRecipe().getRecipeId());
//                // Add other mappings as needed
//            }
//        });

        // Configure mapping between Product and ProductDTO
//        modelMapper.addMappings(new PropertyMap<Product, ProductDTO>() {
//            @Override
//            protected void configure() {
//                map().setProductId(source.getProductId());
//                map().setProductName(source.getProductName());
//                map().setProductType(source.getProductType());
//                // Add other mappings as needed
//            }
//        });

        return modelMapper;
    }
}


