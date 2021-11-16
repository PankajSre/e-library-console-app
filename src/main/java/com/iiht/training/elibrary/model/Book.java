package com.iiht.training.elibrary.model;

import java.util.Objects;

public class Book {

	private Integer id;
	private String isbn;
	private String name;
	private Integer quantity;
	private String publication;
	private String stream;

	public Book() {
		
	}

	public Book(Integer id, String isbn, String name, Integer quantity, String publication, String stream) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.quantity = quantity;
		this.publication = publication;
		this.stream = stream;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	@Override
	public int hashCode() {
		return Objects.hash(stream, id, isbn, name, publication, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(stream, other.stream) && Objects.equals(id, other.id)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(name, other.name)
				&& Objects.equals(publication, other.publication) && Objects.equals(quantity, other.quantity);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", name=" + name + ", quantity=" + quantity + ", publication="
				+ publication + ", category=" + stream + "]";
	}

	
}
