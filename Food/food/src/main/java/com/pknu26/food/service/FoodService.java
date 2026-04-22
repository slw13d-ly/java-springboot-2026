package com.pknu26.food.service;

import java.util.List;

import com.pknu26.food.dto.Food;
import com.pknu26.food.validation.FoodForm;

// 서비스들을 구현할 때 반드시 아래의 메서드를 전부 구현할 것
public interface FoodService {
    // CRUD = Create(Insert), Read(Select), Update, Delete
    void createFood(FoodForm foodForm);

    List<Food> readFoodList();

    Food readFoodById(Long id);

    void updateFood(FoodForm foodForm);

    void deleteFood(Long id);
}