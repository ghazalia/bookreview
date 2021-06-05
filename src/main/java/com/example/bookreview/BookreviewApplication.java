package com.example.bookreview;

import com.example.bookreview.model.Author;
import com.example.bookreview.model.Novel;
import com.example.bookreview.repository.AuthorRepository;
import com.example.bookreview.repository.NovelRepository;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookreviewApplication {
    private static final Logger log = LoggerFactory.getLogger(BookreviewApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookreviewApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepo, NovelRepository novelRepo) {
        return (args) -> {
//            Faker faker = new Faker();
//
//            for (int i = 0; i < 10; i++) {
//                Author author = new Author();
//                Novel novel = new Novel();
//
//                author.setName(faker.book().author());
////                ? character
////                # number
//                author.setPhone(faker.bothify("0##########"));
//                author.setEmail(faker.bothify("?????@gmail.com"));
//                novel.setName(faker.book().title());
//
//                authorRepo.save(author);
//                novel.setAuthor(author);
//                novelRepo.save(novel);
//            }


//            fetch writer by name
//            Author authorStored = authorRepo.searchByEmail("ghaz@gmail.com");
//            log.info("email to find: {}" , authorStored.getName());

//            fetch all writers
//            log.info("All writers");
//            log.info("---------------");
//            for (Author author : authorRepo.findAll()) {
//                log.info(author.toString());
//            }

//            fetch using searchByName
//            log.info("using search byName @Query");
//            log.info("---------------");
//            log.info(authorRepo.searchByName("ghazali").toString());

        };

    }

}
