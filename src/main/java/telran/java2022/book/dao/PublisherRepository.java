package telran.java2022.book.dao;

import java.util.List;
import java.util.Optional;

import telran.java2022.book.model.Publisher;

public interface PublisherRepository {

    Optional<Publisher> findById(String publisher);
//    @Query("SELECT DISTINCT p.publisherName FROM Book b JOIN b.authors a JOIN b.publisher p WHERE a.name=?1")
    List<String> findPublishersByAuthor(String name);

    Publisher save(Publisher publisher);


}
