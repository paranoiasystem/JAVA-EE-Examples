package book;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author paranoia
 */
@Singleton
@Startup
@DataSourceDefinition(
    className = "org.apache.derby.jdbc.ClientDriver",
    name = "java:global/Book",
    user = "app",
    password = "app",
    databaseName = "book",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    public BookBean bookBean;
    public Book book1, book2;
    
    @PostConstruct
    private void populateDB() {
        book1 = new Book(null, "Prova 1", "Nessuno", "2012");
        book2 = new Book(2L, "Prova 2", "Io", "2016");
        bookBean.createBook(book1);
        bookBean.createBook(book2);
    }
    
    @PreDestroy
    private void clearDB() {
        bookBean.deleteBook(book1);
        bookBean.deleteBook(book2);
    }
}
