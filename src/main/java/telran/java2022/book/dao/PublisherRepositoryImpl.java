package telran.java2022.book.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import telran.java2022.book.model.Publisher;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<String> findPublishersByAuthor(String name) {
	TypedQuery<String> query = em.createQuery(
		"SELECT DISTINCT p.publisherName FROM Book b JOIN b.authors a JOIN b.publisher p WHERE a.name=?1",
		String.class);
	query.setParameter(1, name);
	return query.getResultList();
    }

    @Override
    public Optional<Publisher> findById(String publisherName) {
	Publisher publisher = em.find(Publisher.class, publisherName);
	return Optional.ofNullable(publisher);
    }

    @Override
    public Publisher save(Publisher publisher) {
	// метод persist() создает новую запись/объект
	em.persist(publisher);
//	em.merge(publisher);
	return publisher;
    }
}
