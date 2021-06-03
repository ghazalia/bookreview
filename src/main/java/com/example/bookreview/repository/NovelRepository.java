package com.example.bookreview.repository;

import com.example.bookreview.model.Novel;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * NovelRepository
 */
@Repository
public interface NovelRepository extends PagingAndSortingRepository<Novel, Long> {

}