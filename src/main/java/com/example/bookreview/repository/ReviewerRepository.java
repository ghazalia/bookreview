package com.example.bookreview.repository;

import com.example.bookreview.model.Reviewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ReviewerRepository extends CrudRepository<Reviewer, Long> {
}
