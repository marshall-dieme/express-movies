package org.spring.expressmovie.repository;

import java.util.List;

import org.spring.expressmovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public Movie findByTitle(String title);

    public void deleteByTitle(String title);

    @Query("SELECT mv from Movie mv, Director dir where dir.firstName= ?1 OR dir.lastName = ?2")
    public List<Movie> findByDirectorName(String firstName, String lastName);
}