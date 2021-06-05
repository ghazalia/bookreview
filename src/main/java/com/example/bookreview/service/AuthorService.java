package com.example.bookreview.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.bookreview.exception.DataAlreadyExistException;
import com.example.bookreview.exception.DataNotFoundException;
import com.example.bookreview.model.Author;
import com.example.bookreview.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepo;

	// create author
//    Email adalah unique
//    email dah ada throw exception
	public void save(Author author) throws DataAlreadyExistException {

		if (this.userExist(author.getEmail())) {
			throw new DataAlreadyExistException("Author already exist");
		} else {
			Author authorToSave = new Author();
			authorToSave.setEmail(author.getEmail());
			authorToSave.setPhone(author.getPhone());
			authorToSave.setName(author.getName());

			authorRepo.save(authorToSave);
		}

	}

	private boolean userExist(String email) {
		if (authorRepo.searchByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}

	// List all authors
	public List<Author> listAllAuthors() {
		List<Author> authors = new ArrayList<>();
		authorRepo.findAll().forEach(author -> authors.add(author));
		return authors;
	}

	public Long count() {
		return authorRepo.count();
	}

	public void delete(Long authorId) {
		authorRepo.deleteById(authorId);
	}

	public void updateAuthor(Author authorToUpdate) {
		Author authorInDB = authorRepo.findById(authorToUpdate.getId())
				.orElseThrow(() -> new DataNotFoundException("Data Not Found"));

		authorInDB.setEmail(authorToUpdate.getEmail());
		authorInDB.setPhone(authorToUpdate.getPhone());
		authorInDB.setName(authorToUpdate.getName());

		authorRepo.save(authorInDB);
	}

	public List<Author> findWriterByName(String writerName) {
//        String null find all
//        at least 1 char %string%
		List<Author> authors = new ArrayList<>();
		if (StringUtils.hasText(writerName)) {
			authorRepo.findNameByAnyChartersInAscOrder(writerName).forEach(author -> authors.add(author));

			return authors;

		} else {
			return this.listAllAuthors();
		}
	}

}
