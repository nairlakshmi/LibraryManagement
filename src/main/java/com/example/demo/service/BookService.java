package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.DatabaseException;
import com.example.demo.model.Book;

public interface BookService{
	
	public Book save(Book book) throws DatabaseException;
	
	public void updateBook(int id, int libId) throws DatabaseException;
	
	public Book getBook(int id) throws DatabaseException;
	
	public List<Book> getBooksofLib(int libId) throws DatabaseException;
	
	public void updateBookDetails(String name, String desc, int id) throws DatabaseException;
	
	public void delBook(int id) throws DatabaseException;
	

}
