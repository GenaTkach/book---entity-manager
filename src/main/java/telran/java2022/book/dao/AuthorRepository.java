package telran.java2022.book.dao;

import java.util.Optional;

import telran.java2022.book.model.Author;

public interface AuthorRepository{

    Optional<Author> findById(String authorName);
    
    Author save(Author author);

    void delete(Author author);
}
