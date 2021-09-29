package org.spring.expressmovie.repository;


import org.spring.expressmovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public Movie findByTitle(String title);

}