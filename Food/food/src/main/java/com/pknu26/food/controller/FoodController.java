package com.pknu26.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.food.dto.Food;
import com.pknu26.food.service.FoodService;
import com.pknu26.food.validation.FoodForm;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // 목록
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("foodList", this.foodService.readFoodList());
        return "/food/list";
    }

    // 상세보기
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Food food = this.foodService.readFoodById(id);
        model.addAttribute("food", food);
        return "/food/detail";
    }

    // 등록 GET
    @GetMapping("/create")
    public String showCreateForm(FoodForm foodForm) {
        return "/food/form";
    }

    // 등록 POST
    @PostMapping("/create")
    public String create(@Valid FoodForm foodForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/food/form";
        }

        this.foodService.createFood(foodForm);
        return "redirect:/food/list";
    }

    // 수정 GET
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Food food = this.foodService.readFoodById(id);

        FoodForm foodForm = new FoodForm();
        foodForm.setId(food.getId());
        foodForm.setName(food.getName());
        foodForm.setCategory(food.getCategory());
        foodForm.setRating(food.getRating());
        foodForm.setMemo(food.getMemo());
        foodForm.setEatDate(food.getEatDate());

        model.addAttribute("foodForm", foodForm);
        return "/food/form";
    }

    // 수정 POST
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,
                       @Valid @ModelAttribute("foodForm") FoodForm foodForm,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/food/form";
        }

        foodForm.setId(id);
        this.foodService.updateFood(foodForm);
        return "redirect:/food/detail/" + id;
    }

    // 삭제 POST
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.foodService.deleteFood(id);
        return "redirect:/food/list";
    }
}