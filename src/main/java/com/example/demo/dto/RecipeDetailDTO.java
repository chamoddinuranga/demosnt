package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDetailDTO {
    private Long recipeDetailId;
    private Long recipeId; // ID reference to Recipe
    private String productName;
    private String addFunction;
    private double dose;
    private int temp;
    private int time;
    private double quantityInGrams;

}
