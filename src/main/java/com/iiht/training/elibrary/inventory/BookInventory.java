package com.iiht.training.elibrary.inventory;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.activity.InvalidActivityException;

import com.iiht.training.elibrary.exception.BookNotAvailableException;
import com.iiht.training.elibrary.exception.ISBNAlreadyExistsException;
import com.iiht.training.elibrary.exception.ISBNDoesNotExistsException;
import com.iiht.training.elibrary.exception.InvalidBookQuantityException;
import com.iiht.training.elibrary.model.Book;
import com.iiht.training.elibrary.model.BookIssue;

public class BookInventory {

	static Set<Book> books = new LinkedHashSet<>();
	Set<BookIssue> issuedBooks = new LinkedHashSet<>();
	static {
		books.add(new Book(1, "1234567890", "Programming in C", 20, "Tata Hills", "Science"));
		books.add(new Book(2, "1234567891", "Java 8 Concepts", 10, "Rachna Publications", "Science"));
		books.add(new Book(3, "1234567892", "Psychology", 0, "Creations Publications", "Arts"));
		books.add(new Book(4, "1234567893", "How To Act", 30, "Tech Media", "Media"));
		books.add(new Book(5, "1234567894", "How to become CA", 15, "Tata Hills", "Commerce"));
	}

	public boolean addBook(Book book) {
		boolean status = false;
		for (Book b : books) {
			if (b.getIsbn().equalsIgnoreCase(book.getIsbn())) {
				status = true;
			}
			if (book.getQuantity() <= 0) {
				throw new InvalidBookQuantityException("Book quantity must be greater than zero");
			}
		}
		if (status) {
			throw new ISBNAlreadyExistsException("The ISBN " + book.getIsbn() + " already exists");
		} else {
			book.setId(books.size() + 1);
			books.add(book);
			return true;
		}

	}

	public boolean issueBook(String isbn, String studentName) {
		for (Book book : books) {
			if (book.getIsbn().equalsIgnoreCase(isbn)) {
				if (book.getQuantity() <= 0) {
					throw new BookNotAvailableException("There is no book available to Issue");
				}
				BookIssue bookIssue = new BookIssue(issuedBooks.size() + 1, isbn, studentName, LocalDate.now());
				issuedBooks.add(bookIssue);
				book.setQuantity(book.getQuantity() - 1);
				return true;
			}
		}

		throw new ISBNDoesNotExistsException("ISBN " + isbn + " does not exists");
	}

	public Set<Book> showInventory() {
		return books;
	}

	public Set<BookIssue> showIssuedBooks() {
		return issuedBooks;
	}
}
