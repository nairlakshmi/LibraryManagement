package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Book;


public interface BookRepo extends CrudRepository<Book,Integer>{
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
    @Query(value = "update BOOK b set b.libId=:libId where b.id=:id",nativeQuery = true)
	void updateBook(@RequestParam(name = "id")int id, @RequestParam(name = "libId")int libId);
	
	
	@Transactional
	@Query(value = "select * from book b where b.libId=:libId",nativeQuery=true)
	List<Book> getBooksofLib(@RequestParam(name="libId")int libId);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
    @Query(value = "update BOOK b set b.name=:name, b.desc=:desc where b.id=:id",nativeQuery = true)
	void updateBookDetails(@RequestParam(name = "name")String name, @RequestParam(name = "desc")String desc, @RequestParam(name = "id")int id);
	
	
}