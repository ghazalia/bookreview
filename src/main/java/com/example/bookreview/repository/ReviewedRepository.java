package com.example.bookreview.repository;

import com.example.bookreview.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewedRepository extends CrudRepository<Review, Long> {
}
