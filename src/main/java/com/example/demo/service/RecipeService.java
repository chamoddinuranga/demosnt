package com.example.demo.service;

import com.example.demo.dto.RecipeDTO;
import com.example.demo.dto.RecipeDetailDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.RecipeDetail;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.RecipeRepository;
import com.example.demo.util.VarList;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class RecipeService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(RecipeService.class);
    public String saveRecipe(RecipeDTO recipeDTO) {
        System.out.println(recipeDTO);

        if (recipeRepository.existsByLabDip(recipeDTO.getLabDip())) {
            return VarList.RSP_DUPLICATED;
        } else {
            // Convert RecipeDTO to Recipe
            Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
            System.out.println(Recipe.class);

            // Initialize the recipe details list
            List<RecipeDetail> recipeDetails = new ArrayList<>();

            // Handle RecipeDetail entries
            for (RecipeDetailDTO detailDTO : recipeDTO.getRecipeDetails()) {
                RecipeDetail detail = new RecipeDetail();
                detail.setQuantityInGrams(detailDTO.getQuantityInGrams());
                detail.setAddFunction(detailDTO.getAddFunction()); // Set new fields
                detail.setDose(detailDTO.getDose());
                detail.setTemp(detailDTO.getTemp());

                // Set Recipe reference
                detail.setRecipe(recipe);

                // Fetch Product entity from the database and set reference
//                Product product = productRepository.findById(detailDTO.getProductId())
//                        .orElseThrow(() -> new RuntimeException("Product not found"));

                Product product = productRepository.findByProductName(detailDTO.getProductName())
                        .orElseThrow(() -> new RuntimeException("Product not found"));

                // Log the Product entity
                logger.debug("Fetched Product: {}", product);

                detail.setProduct(product);

                // Add RecipeDetail to the list
                recipeDetails.add(detail);
            }

            // Set the RecipeDetails in the Recipe entity
            recipe.setRecipeDetails(recipeDetails);

            // Log the Recipe and RecipeDetails before saving
            logger.debug("Recipe Before Save: {}", recipe);
            logger.debug("Recipe Details Before Save: {}", recipe.getRecipeDetails());

            // Save the Recipe entity
            recipeRepository.save(recipe);

            return VarList.RSP_SUCCESS;
        }
    }

}
