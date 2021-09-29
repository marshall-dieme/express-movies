package org.spring.expressmovie.service;

import org.spring.expressmovie.model.Director;
import org.spring.expressmovie.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    
    @Autowired
    DirectorRepository directorRepository;

    public Director addDirector(Director director) {
        return directorRepository.save(director);
    }

    public Page<Director> getAll(Pageable pageable) {
        return directorRepository.findAll(pageable);
    }

    public Director getByFirstNameOrLastName(String firstName, String lastName) {
        return directorRepository.findByFirstNameOrLastName(firstName, lastName);
    }
}