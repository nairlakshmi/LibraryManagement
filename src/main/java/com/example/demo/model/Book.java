package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	@Id
	private int id;
	@Nullable
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Column(name = "LIBID")
	private int libId;
	@NotEmpty
	private String name;
	@NotEmpty
	private String desc;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}
	
	public int getLibId() {
		return libId;
	}

	public void setLibId(int libId) {
		this.libId = libId;
	}


	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public String getdesc() {
		return desc;
	}

	public void setdesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", libId=" + libId + ", name=" + name + ", desc=" + desc + "]";
	}

	

}
