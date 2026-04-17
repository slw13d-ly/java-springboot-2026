package com.pknu26.movie_mng.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Lob;
// import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(name = "movie_seq", sequenceName = "SEQ_MOVIE", allocationSize = 1)
    
    // MOVIE_ID 영화 고유 ID (PK)
    @Column(name = "MOVIE_ID")
    private Long movieId;
    
    // TITLE 영화 제목
    @Column(name="TITLE", length = 200)
    private String title;
    
    // ORIGINAL_TITLE 원제
    @Column(name="ORIGINAL_TITLE", length = 200)
    private String originalTitle;
    
    // DIRECTOR 감독 (콤마로 구분)
    @Column(name="DIRECTOR", length = 100)
    private String director;
    
    // ACTORS 주요 배우 (콤마로 구분)
    @Column(name="ACTORS", length = 1000)
    private String actors;
    
    // GENRE 장르 (Action, Drama 등)
    @Column(name="GENRE", length = 100)
    private String genre;
    
    // RELEASE_DATE 개봉일
    @Column(name="RELEASE_DATE")
    private LocalDate releaseDate;

    // RUNNING_TIME 상영 시간 (분)
    @Column(name="RUNNING_TIME")
    private Integer runningTime;

    // RATING 평점 (예: 8.5)
    @Column(name="RATING")
    private Double rating;
    
    @Lob
    // DESCRIPTION 영화 설명
    @Column(name="DESCRIPTION")
    private String description;
    
    // CREATED_AT 작성일
    @Column(name="CREATED_AT")
    private LocalDateTime createdAt;
    // UPDATED_AT 수정일
    @Column(name="UPDATED_AT")
    private LocalDateTime updatedAt;


}
