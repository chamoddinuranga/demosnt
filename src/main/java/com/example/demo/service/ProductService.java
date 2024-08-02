package com.example.demo.service;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;
import com.example.demo.util.VarList;
import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Add new Product to the database
    public String saveProduct(ProductDTO productDTO) {

        if (productRepository.existsById(productDTO.getProductId())) {
            return VarList.RSP_DUPLICATED;
        } else if (productRepository.existsByProductName(productDTO.getProductName())) {
            return VarList.RSP_DUPLICATED;
        } else {
            productRepository.save(modelMapper.map(productDTO, Product.class));
            return VarList.RSP_SUCCESS;
        }
    }
}
