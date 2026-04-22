package com.pknu26.food.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pknu26.food.dto.Food;

@Mapper
public interface FoodMapper {

    List<Food> findAll();
    Food findById(Long id);
    void insertFood(Food food);
    void updateFood(Food food);
    void deleteFood(Long id);
}