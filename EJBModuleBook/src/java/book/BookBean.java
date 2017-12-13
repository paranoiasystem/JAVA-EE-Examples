package book;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author paranoia
 */
@Stateless
@LocalBean
public class BookBean implements BookBeanRemote {
    
    @Inject
    private EntityManager entityManager;

    @Override
    public List<Book> findAllBooks() {
        TypedQuery<Book> query = entityManager.createNamedQuery("FIND_ALL", Book.class);
        return query.getResultList();
    }

    @Override
    public Book findBook(String id) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.id=?1", Book.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public Book createBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        entityManager.merge(book);
        return book;
    }

    @Override
    public void deleteBook(Book book) {
        entityManager.remove(entityManager.merge(book));
    }

}
