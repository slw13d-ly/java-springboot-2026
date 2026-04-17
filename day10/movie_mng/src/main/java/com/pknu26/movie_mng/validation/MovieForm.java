package com.pknu26.movie_mng.validation;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieForm {

    // TITLE 영화 제목
    @Size(max = 200)
    @NotBlank(message = "제목은 필수입니다.")
    private String title;
    
    // ORIGINAL_TITLE 원제
    @Size(max = 200)
    private String originalTitle;
    
    // DIRECTOR 감독 (콤마로 구분)
    @Size(max = 100)
    private String director;
    
    // ACTORS 주요 배우 (콤마로 구분)
    @Size(max = 1000)
    private String actors;
    
    // GENRE 장르 (Action, Drama 등)
    @Size(max = 100)
    private String genre;
    
    // RELEASE_DATE 개봉일
    private LocalDate releaseDate;

    // RUNNING_TIME 상영 시간 (분)
    private Integer runningTime;

    // RATING 평점 (예: 8.5)
    private Double rating;

    // DESCRIPTION 영화 설명
    @Size(max = 8000)
    private String description;
}
