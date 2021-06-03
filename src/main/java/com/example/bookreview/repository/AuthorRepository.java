package com.example.bookreview.repository;

import com.example.bookreview.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByName(String name);

    @Query("select a from Author a where a.name = ?1")
    Author searchByName(String name);
}
