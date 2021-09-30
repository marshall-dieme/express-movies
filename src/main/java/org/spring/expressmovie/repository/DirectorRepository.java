package org.spring.expressmovie.repository;

import java.util.List;

import org.spring.expressmovie.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    public Director findByFirstNameOrLastName(String firstName, String lastName);
    public Director findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT dir from Movie mv, Director dir where mv.title = ?1")
    public List<Director> findByMovieTitle(String title);
}