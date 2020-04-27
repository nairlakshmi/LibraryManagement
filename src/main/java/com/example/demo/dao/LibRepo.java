package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Library;

public interface LibRepo extends CrudRepository<Library, Integer> {

}
