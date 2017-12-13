package book;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author paranoia
 */
@Remote
public interface BookBeanRemote {
    public List<Book> findAllBooks();
    public Book findBook(String id);
    public Book createBook(Book book);
    public Book updateBook(Book book);
    public void deleteBook(Book book);
}
