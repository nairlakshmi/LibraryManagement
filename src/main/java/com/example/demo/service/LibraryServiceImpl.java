package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.BookRepo;
import com.example.demo.dao.LibRepo;
import com.example.demo.exceptions.DatabaseException;
import com.example.demo.model.Book;
import com.example.demo.model.Library;

@Component
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
	LibRepo libRepo;
	private Library result;

	@Override
	public Library save(Library lib) throws DatabaseException {
		try {

			libRepo.save(lib);
			
		}catch(Exception ex) 
		{
			throw new DatabaseException("Unable to save in database");
		}
		return lib;
	}

}
