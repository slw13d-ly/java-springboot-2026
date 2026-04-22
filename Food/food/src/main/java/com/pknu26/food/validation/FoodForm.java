package com.pknu26.food.validation;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FoodForm {

    private Long id;

    @NotBlank(message = "음식 이름은 필수입니다.")
    @Size(max = 200, message = "음식 이름은 200자 이하로 입력하세요.")
    private String name;

    @NotBlank(message = "카테고리는 필수입니다.")
    @Size(max = 50, message = "카테고리는 50자 이하로 입력하세요.")
    private String category;

    @NotNull(message = "평점은 필수입니다.")
    @Min(value = 1, message = "평점은 최소 1점입니다.")
    @Max(value = 5, message = "평점은 최대 5점입니다.")
    private Integer rating;

    @Size(max = 1000, message = "메모는 1000자 이하로 입력하세요.")
    private String memo;

    @NotNull(message = "먹은 날짜는 필수입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eatDate;
}