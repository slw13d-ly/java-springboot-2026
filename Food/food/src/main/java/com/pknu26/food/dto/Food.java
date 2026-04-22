package com.pknu26.food.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Food {
    private Long id;
    private String name;
    private String category;
    private Integer rating;
    private String memo;
    private LocalDate eatDate;
    private LocalDateTime createdAt;
}
