package com.example.bookreview.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookreview.exception.DataAlreadyExistException;
import com.example.bookreview.model.Novel;
import com.example.bookreview.repository.NovelRepository;

@Service
public class NovelService {
	@Autowired
	private NovelRepository novelRepo;

	public void saveNewNovel(Long authorId, Novel novel) {
//		novel per author must be unique

		if (novelRepo.countNovelsByAuthor(authorId, novel.getName()) > 0) {
			throw new DataAlreadyExistException("Data already exists");
		} else {
			novelRepo.save(novel);
		}
	}

}
