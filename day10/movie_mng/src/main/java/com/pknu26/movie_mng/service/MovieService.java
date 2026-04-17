package com.pknu26.movie_mng.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu26.movie_mng.entity.Movie;
import com.pknu26.movie_mng.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // 게시글 모두 가져오기
    public List<Movie> getMovieList(){
        return this.movieRepository.findAll();
    }

    // 게시글 하나 가져오기
    public Movie getMovieOne(Long movieId) {
        Optional<Movie> opMovie = this.movieRepository.findById(movieId);

        if(opMovie.isPresent()) {
            return opMovie.get();    
        } else {
            throw new RuntimeException("Movie Data not found");
        }
    }

    // 게시판 글 저장
    public boolean setMovieOne(String title,
                               String originalTitle,
                               String director,
                               String actors,
                               String genre,
                               java.time.LocalDate releaseDate,
                               Integer runningTime,
                               Double rating,
                               String description) {

        Movie movie = new Movie();

        try {
            movie.setTitle(title);
            movie.setOriginalTitle(originalTitle);
            movie.setDirector(director);
            movie.setActors(actors);
            movie.setGenre(genre);
            movie.setReleaseDate(releaseDate);
            movie.setRunningTime(runningTime);
            movie.setRating(rating);
            movie.setDescription(description);
            movie.setCreatedAt(LocalDateTime.now());

            // 저장
            this.movieRepository.save(movie);
            return true;

        } catch (Exception e) {
            
            return false;
        }
    }
}
