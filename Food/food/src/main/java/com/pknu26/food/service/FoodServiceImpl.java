package com.pknu26.food.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pknu26.food.dto.Food;
import com.pknu26.food.mapper.FoodMapper;
import com.pknu26.food.validation.FoodForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    
    private final FoodMapper foodMapper;

    @Override
    public void createFood(FoodForm foodForm) {
        Food food = new Food();
        food.setName(foodForm.getName());
        food.setCategory(foodForm.getCategory());
        food.setRating(foodForm.getRating());
        food.setMemo(foodForm.getMemo());
        food.setEatDate(foodForm.getEatDate());
        

        this.foodMapper.insertFood(food);
    }

    @Override
    public List<Food> readFoodList() {
        return this.foodMapper.findAll();
    }

    @Override
    public Food readFoodById(Long id) {
        return this.foodMapper.findById(id);
    }

    @Override
    public void updateFood(FoodForm foodForm) {
        Food food = new Food();
        food.setId(foodForm.getId());
        food.setName(foodForm.getName());
        food.setCategory(foodForm.getCategory());
        food.setRating(foodForm.getRating());
        food.setMemo(foodForm.getMemo());
        food.setEatDate(foodForm.getEatDate());

        this.foodMapper.updateFood(food);
    }

    @Override
    public void deleteFood(Long id) {
        this.foodMapper.deleteFood(id);
    }
}