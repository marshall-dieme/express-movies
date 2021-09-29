package org.spring.expressmovie.repository;

import org.spring.expressmovie.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    public Director findByFirstNameOrLastName(String firstName, String lastName);
    public Director findByFirstNameAndLastName(String firstName, String lastName);
}