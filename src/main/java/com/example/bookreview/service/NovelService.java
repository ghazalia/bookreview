package com.example.bookreview.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookreview.exception.DataAlreadyExistException;
import com.example.bookreview.exception.DataNotFoundException;
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

	public Novel getNovelById(Long bookId) {
		return novelRepo.findById(bookId).orElseThrow(() -> new DataNotFoundException("Book does not exist"));
	}

	public List<Novel> getAllNovels() {
		return StreamSupport.stream(novelRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public boolean isPresent(Long novelId) {
		return novelRepo.findById(novelId).isPresent() ? true : false;
	}
}
