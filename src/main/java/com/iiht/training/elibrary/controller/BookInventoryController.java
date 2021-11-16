package com.iiht.training.elibrary.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.iiht.training.elibrary.inventory.BookInventory;
import com.iiht.training.elibrary.model.Book;
import com.iiht.training.elibrary.model.BookIssue;

public class BookInventoryController {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BookInventory inventory = new BookInventory();

		System.out.println("Add Book");
		Book book = new Book(11, "1234567892", "Texation", 1, "Eco tech", "Commerce");
		inventory.addBook(book);

		inventory.issueBook("1234567892", "Pankaj");

		List<BookIssue> books = inventory.showIssuedBooks();
		books.forEach(System.out::println);
		System.out.println("All Books");
		List<Book> list = inventory.showInventory();
		list.forEach(System.out::println);
		
	}

}
