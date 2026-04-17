package com.pknu26.movie_mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.movie_mng.entity.Movie;
import com.pknu26.movie_mng.repository.MovieRepository;
import com.pknu26.movie_mng.service.MovieService;
import com.pknu26.movie_mng.validation.MovieForm;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RequestMapping("/movie")
@Controller
public class MovieController {

    private final MovieRepository movieRepository;
    @Autowired
    private MovieService movieService;

    MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // 게시글 보기
    @GetMapping("/list")
    public String showlist(Model model) {
        List<Movie> movieList = this.movieService.getMovieList();

        model.addAttribute("movieList", movieList);
        return "movie_list";
    }
    
    // 게시글 한 건 보기
    @GetMapping("/detail/{movieId}")
    public String showDetail(Model model, @PathVariable("movieId") Long movieId) {
        Movie movie = this.movieService.getMovieOne(movieId);

        model.addAttribute("movie", movie);
        return "movie_detail";
    }

    // 게시글 작성
    @GetMapping("/create")
    public String showCreate(Model model, MovieForm movieForm) {
        model.addAttribute("mode", "create");
        return "movie_create";
    }
    @PostMapping("/create")
    public String createMovie(@Valid MovieForm movieForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "movie_create";
        }

        this.movieService.setMovieOne(movieForm.getTitle(), 
                                      movieForm.getOriginalTitle(),
                                      movieForm.getDirector(), 
                                      movieForm.getActors(), 
                                      movieForm.getGenre(), 
                                      movieForm.getReleaseDate(), 
                                      movieForm.getRunningTime(), 
                                      movieForm.getRating(), 
                                      movieForm.getDescription());
        return "redirect:/movie/list";
    }
    
    
}
