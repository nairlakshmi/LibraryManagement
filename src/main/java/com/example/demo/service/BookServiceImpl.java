package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.BookRepo;
import com.example.demo.exceptions.DatabaseException;
import com.example.demo.model.Book;

import javassist.expr.Instanceof;

@Component
public class BookServiceImpl implements BookService{


	@Autowired
	BookRepo repo;
	private Book result;
	private List<Book> books;

	@Override
	public Book save(Book book) throws DatabaseException {
		
		try {

			repo.save(book);
			
		}catch(Exception ex) 
		{
			throw new DatabaseException("Unable to save in database");
		}
		return book;

	}
	
	@Override
	public void updateBook(int id, int libId) throws DatabaseException {
		
		try {
			repo.updateBook(id, libId);
		}catch(Exception ex)
		{
			throw new DatabaseException("Unable to save in database");
		}
		
	}

	@Override
	public Book getBook(int id) throws DatabaseException {
		
		try {

			Optional<Book> res = repo.findById(id);
			result = res.get();
			System.out.println("INSIDE GETBOOK : "+result);
			
		}catch(Exception ex) 
		{
			throw new DatabaseException("Unable to save in database");
		}
		return result;
	}

	@Override
	public List<Book> getBooksofLib(int libId) throws DatabaseException {
		try {

			books = repo.getBooksofLib(libId);
			
		}catch(Exception ex) 
		{
			throw new DatabaseException("Unable to save in database");
		}
		return books;
	}

	@Override
	public void updateBookDetails(String name, String desc, int id) throws DatabaseException {
		
		try {
			repo.updateBookDetails(name, desc, id);
		}catch(Exception ex)
		{
			throw new DatabaseException("Unable to save in database");
		}
		
	}

	@Override
	public void delBook(int id) throws DatabaseException {
		
		try {
			repo.deleteById(id);
		}catch(Exception ex)
		{
			throw new DatabaseException("Unable to save in database");
		}
		
	}
	
	
	



}
