package applicationclientbook;

import book.Book;
import book.BookBeanRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author paranoia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context context = new InitialContext();
        BookBeanRemote bookBeanRemote = (BookBeanRemote) context.lookup("java:global/EJBModuleBook/BookBean!book.BookBeanRemote");
        bookBeanRemote.createBook(new Book(4L, "POOO", "POOO", "2001"));
        List<Book> books = bookBeanRemote.findAllBooks();
        for (Book book : books)
            System.out.println("libro: " + book.toString());
    }
    
}
