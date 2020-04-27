package com.example.demo.service;

import com.example.demo.exceptions.DatabaseException;
import com.example.demo.model.Book;
import com.example.demo.model.Library;

public interface LibraryService {
	
	public Library save(Library lib) throws DatabaseException;

}
