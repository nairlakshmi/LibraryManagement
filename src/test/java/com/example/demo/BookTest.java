package com.example.demo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.BookRepo;
import com.example.demo.dao.LibRepo;
import com.example.demo.exceptions.DatabaseException;
import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.service.BookService;
import com.example.demo.service.LibraryService;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@ComponentScan("com.example.demo")
public class BookTest {

	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private LibraryService libraryService;
	
	@Rule
	public final ExpectedException ex = ExpectedException.none();

	@Before
    public void setUp() throws DatabaseException {
        Book firstBook = new Book();
        firstBook.setid(01);
        firstBook.setname("Test-01");
        firstBook.setdesc("Test-01-desc");
        firstBook.setLibId(011);
        bookService.save(firstBook);
        
        
        Book secBook = new Book();
        secBook.setid(02);
        secBook.setname("Test-02");
        secBook.setdesc("Test-02-desc");
        secBook.setLibId(011);
        bookService.save(secBook);
        
        
        Library firstLib = new Library();
        firstLib.setLibId(011);
        firstLib.setLibName("Library 011");
        libraryService.save(firstLib);
        
        Library secondLib = new Library();
        secondLib.setLibId(022);
        secondLib.setLibName("Library 022");
        libraryService.save(secondLib);
    }
	
	@Test
	public void testAddBook_success() throws DatabaseException {
		
		Book book = new Book();
		book.setid(03);
		book.setname("Test-03");
		book.setdesc("Test-03-desc");
		book.setLibId(011);
		
		bookService.save(book);
		
		assertEquals("Test-03", bookService.getBook(03).getname());
		
	}
	@Test
	public void testListofBooksFromLibrary_success() throws DatabaseException {
		
		//Optional<Book> firstBook = repo.findById(01);
		List<Book> list= bookService.getBooksofLib(011);
		
		//list.forEach(i -> assertEquals(011, i.getLibId()));
		for(Book b : list)
		{
			System.out.println("Book Name : "+b.getname());
			assertEquals(011, b.getLibId());
		}
		
	}
	
	@Test
	public void testMvBookToLib_success() throws DatabaseException {
		
		assertEquals(011, bookService.getBook(01).getLibId());
		bookService.updateBook(01, 022);	
		assertEquals(022, bookService.getBook(01).getLibId());
	
		
	}
	
	@Test
	public void delBook_success() throws DatabaseException {
		Book book4 = new Book();
		book4.setid(04);
		book4.setname("Test-04");
		book4.setdesc("Test-04-desc");
		book4.setLibId(011);
		
		bookService.save(book4);
		assertEquals(04, bookService.getBook(04).getid());
		
		bookService.delBook(04);
		
		ex.expect(DatabaseException.class);
		bookService.getBook(04);
		
		
		
	}
	
	@Test
	public void testUpdateBook_success() throws DatabaseException {
		
		assertEquals("Test-01", bookService.getBook(01).getname());
		assertEquals("Test-01-desc", bookService.getBook(01).getdesc());
		
		bookService.updateBookDetails("Test-01-up", "Test-01-desc-up", 01);
		
		assertEquals("Test-01-up", bookService.getBook(01).getname());
		assertEquals("Test-01-desc-up", bookService.getBook(01).getdesc());
		
	}
	
	@Test
	public void getBookDoesNotExist_Fail() throws DatabaseException {
		ex.expect(DatabaseException.class);
		bookService.getBook(100);
		
		
	}

}
