package org.spring.expressmovie.controller;

import java.util.HashMap;
import java.util.Map;

import org.spring.expressmovie.model.Director;
import org.spring.expressmovie.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/directors/")
public class DirectorController {
    
    @Autowired
    DirectorService directorService;

    @PostMapping(value="add")
    public Director addDirector(@RequestBody Director director) {
        return directorService.addDirector(director);
    }

    @GetMapping(value="list")
    public ResponseEntity<Map<String, Object>> getMovieList(@RequestParam int page) {
        Page<Director> directors = directorService.getAll(PageRequest.of(page, 5));

        Map<String, Object> directorsMap = new HashMap<>();

        directorsMap.put("movies", directors);

        return new ResponseEntity<>(directorsMap, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="find")
    public Director findByName(@RequestParam String firstName, @RequestParam String lastName) {
        return directorService.getByFirstNameOrLastName(firstName, lastName);
    }
    
}