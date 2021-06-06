package com.example.bookreview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookreview.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
	List<Author> findByName(String name);

	@Query("select a from Author a where a.name = ?1")
	Author searchByName(String name);

	@Query("select a from Author a where a.email = ?1")
	Author searchByEmail(String email);

	@Query("select a from Author a where a.name like %?1% order by a.name asc")
	List<Author> findNameByAnyChartersInAscOrder(String writerName);

}
