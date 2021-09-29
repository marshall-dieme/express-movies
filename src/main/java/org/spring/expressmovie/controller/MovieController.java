package org.spring.expressmovie.controller;

import java.util.HashMap;
import java.util.Map;

import org.spring.expressmovie.model.Movie;
import org.spring.expressmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/movies/")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping(value="list")
    public ResponseEntity<Map<String, Object>> getMovieList(@RequestParam int page) {
        Page<Movie> movies = movieService.getAll(PageRequest.of(page, 5));

        Map<String, Object> moviesMap = new HashMap<>();

        moviesMap.put("movies", movies);

        return new ResponseEntity<>(moviesMap, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="add")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }
    
    @PostMapping(value="find")
    public Movie getByTitle(@RequestBody String title) {
        return movieService.getByTitle(title);
    }
    

    
}