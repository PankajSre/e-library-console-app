package com.iiht.training.elibrary.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

import com.iiht.training.elibrary.inventory.BookInventory;
import com.iiht.training.elibrary.model.Book;
import com.iiht.training.elibrary.model.BookIssue;

public class BookInventoryController {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BookInventory inventory = new BookInventory();

//		System.out.println("Add Book");
//		Book book = new Book(11, "1234567895", "Texation", 50, "Eco tech", "Commerce");
//		inventory.addBook(book);

		inventory.issueBook("1234567892", "Pankaj");

		Set<BookIssue> books = inventory.showIssuedBooks();
		books.forEach(System.out::println);
		System.out.println("All Books");
		Set<Book> list = inventory.showInventory();
		list.forEach(System.out::println);
		
	}

}
