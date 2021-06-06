package com.example.bookreview.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.bookreview.model.Novel;

/**
 * NovelRepository
 */
@Repository
public interface NovelRepository extends PagingAndSortingRepository<Novel, Long> {

	@Query("Select count(n) from Novel n where n.author.id = ?1 and n.name = ?2")
	Integer countNovelsByAuthor(Long id, String name);

}