package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Library {

	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//private List<Book> books = new ArrayList<>();
	
	@Id
	@Column(name = "LIBID")
	private int libId;
	@NotEmpty
	private String libName;
	

//	public List<Book> getBooks() {
//		return books;
//	}
//	public void setBooks(List<Book> books) {
//		this.books = books;
//	}
	public String getLibName() {
		return libName;
	}
	public void setLibName(String libName) {
		this.libName = libName;
	}
	public int getLibId() {
		return libId;
	}
	public void setLibId(int libId) {
		this.libId = libId;
	}
	@Override
	public String toString() {
		return "Library [libName=" + libName + ", libId=" + libId + "]";
	}
	
	
	
	
	
}
