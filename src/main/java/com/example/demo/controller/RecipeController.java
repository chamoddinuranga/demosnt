package com.example.demo.controller;

import com.example.demo.dto.RecipeDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.repo.RecipeRepository;
import com.example.demo.service.RecipeService;
import com.example.demo.util.VarList;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/recipe")
@CrossOrigin
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private RecipeRepository recipeRepository;

    private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @PostMapping("/saveRecipe")
    public ResponseEntity<ResponseDTO> saveRecipe(@RequestBody RecipeDTO recipeDTO) {
        System.out.println(recipeDTO.toString());
        try {
            String res = recipeService.saveRecipe(recipeDTO);
            if (res.equals(VarList.RSP_SUCCESS)) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(recipeDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals(VarList.RSP_DUPLICATED)) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Recipe Already Exists");
                responseDTO.setContent(recipeDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
