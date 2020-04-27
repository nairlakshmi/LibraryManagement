package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BookRepo;
import com.example.demo.dao.LibRepo;
import com.example.demo.exceptions.DatabaseException;
import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.service.BookService;
import com.example.demo.service.LibraryService;

@Controller
public class HomeController  
{
	@Autowired
	private BookService bookService;
	
	@Autowired
	private LibraryService libraryService;
	
	private ModelAndView mv;
	
	private Book book;
	
	private Library lib;
	
	private List<Book> books;
	

	@RequestMapping("/home")
	public String home()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/addBook")
	public ModelAndView addBook(Book bookInput)
	{
		try {
			book = bookService.save(bookInput);
		}catch (DatabaseException ex) {
			mv = new ModelAndView("error.jsp");
			mv.addObject("error", "Unable to add the Book - "+bookInput.getname()+" "+ex);
		}
		
		mv = new ModelAndView("status.jsp");
		mv.addObject("title","Added Book");
		mv.addObject("result", book);
		return mv;
	
	}
	
	@RequestMapping("/mvBook")
	public ModelAndView updateBook(@RequestParam(name = "id")int id, @RequestParam(name = "libId")int libId)
	{
		
		try {
			bookService.updateBook(id, libId);
		} catch (DatabaseException ex) {
			mv = new ModelAndView("error.jsp");
			mv.addObject("error", "Unable to move the Book with book id - "+id+" "+ex);
		}
		mv = new ModelAndView("status.jsp");
		mv.addObject("title","Moved Book to Library");
		mv.addObject("result", "Successfully moved the book with id "+id+" under Library with libId ");
		return mv;
	}
	
	@RequestMapping("/addLib")
	public ModelAndView addLibrary(Library libInput)
	{
		try {
			lib = libraryService.save(libInput);
		}catch (DatabaseException ex) {
			mv = new ModelAndView("error.jsp");
			mv.addObject("error", "Unable to add the Library - "+libInput.getLibName()+" "+ex);
		}
		
		mv = new ModelAndView("status.jsp");
		mv.addObject("title","Added Library");
		mv.addObject("result", lib);
		return mv;
	}
	
	@RequestMapping("/getBook")
	public ModelAndView getBook(@RequestParam(name = "id", defaultValue="0", required=true)int id)
	{
		
		try {
			book = bookService.getBook(id);
			mv = new ModelAndView("status.jsp");
			mv.addObject("title","Retrieved Book details");
			mv.addObject("result", book);
		}catch (DatabaseException ex) {
			mv = new ModelAndView("error.jsp");
			mv.addObject("error", "Unable to retrieve details for the Book with id - "+id+" "+ex);
		}
		return mv;
		
		
	}
	
	
	@RequestMapping("/getBooksofLib")
	public ModelAndView getBooksofLib(@RequestParam(name = "libId")int libId) {
		try {
			books = bookService.getBooksofLib(libId);
		}catch (DatabaseException ex) {
			mv = new ModelAndView("error.jsp");
			mv.addObject("error", "Unable to retrieve list of books from library with id  - "+libId+" "+ex);
		}
		
		mv = new ModelAndView("status.jsp");
		mv.addObject("title","Retrieved List of Books from Library with id - "+libId);
		mv.addObject("result", books);
		return mv;
		
	}
	
	@RequestMapping("/updateBook")
	public ModelAndView updateBookDetails(@RequestParam(name = "name")String name, @RequestParam(name = "desc")String desc, @RequestParam(name = "id")int id)
	{
		try {
			bookService.updateBookDetails(name, desc, id);
		} catch (DatabaseException ex) {
			mv = new ModelAndView("error.jsp");
			mv.addObject("error", "Unable to update details of the Book with book id - "+id+" "+ex);
		}
		mv = new ModelAndView("status.jsp");
		mv.addObject("title","Updated Book Details");
		mv.addObject("result", "Successfully updated the details of book with id "+id);
		return mv;
	}

	@RequestMapping("/delBook")
	public ModelAndView delBook(@RequestParam(value="id") int id) {
		try {
			bookService.delBook(id);
		} catch (DatabaseException ex) {
			mv = new ModelAndView("error.jsp");
			mv.addObject("error", "Unable to delete the Book with book id - "+id+" "+ex);
		}
		mv = new ModelAndView("status.jsp");
		mv.addObject("title","Deleted Book record");
		mv.addObject("result", "Successfully deleted the book with id "+id);
		return mv;
		
	}
}