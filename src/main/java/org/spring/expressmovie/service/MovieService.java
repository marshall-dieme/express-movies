package org.spring.expressmovie.service;

import java.util.Date;

import org.spring.expressmovie.model.Movie;
import org.spring.expressmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
    @Autowired
    MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Page<Movie> getAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public Movie getByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public Movie updateMovie(Movie oldMovie, Movie newMovie) {
        if(oldMovie.equals(newMovie)){
            oldMovie = newMovie;
            return movieRepository.save(oldMovie);
        }
        return null;
    }

    public Movie updateByTitle(String title, Date newReleaseDate) {
        Movie movie = getByTitle(title);
        if (movie != null) {
            movie.setRelease(newReleaseDate);
            return addMovie(movie);
        }
        return null;
    }

    public void removeMovie(String title){
        movieRepository.delete(getByTitle(title));
    }
    
}