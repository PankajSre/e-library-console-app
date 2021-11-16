package com.iiht.training.elibrary.inventory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.iiht.training.elibrary.exception.BookNotAvailableException;
import com.iiht.training.elibrary.exception.ISBNAlreadyExistsException;
import com.iiht.training.elibrary.exception.ISBNDoesNotExistsException;
import com.iiht.training.elibrary.exception.InvalidBookQuantityException;
import com.iiht.training.elibrary.model.Book;
import com.iiht.training.elibrary.model.BookIssue;

public class BookInventory {

	public List<Book> books = new ArrayList<>();
	public List<BookIssue> issuedBooks = new ArrayList<>();

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
		if (isIsbnExists(isbn)) {
			Book book = getBook(isbn);
			if (book.getQuantity() <= 0) {
				throw new BookNotAvailableException("There is no book available to Issue");
			}
			BookIssue bookIssue = new BookIssue(issuedBooks.size() + 1, isbn, studentName, LocalDate.now());
			issuedBooks.add(bookIssue);
			book.setQuantity(book.getQuantity() - 1);
			return true;
		} else {
			throw new ISBNDoesNotExistsException("ISBN " + isbn + " does not exists");
		}

	}

	public List<Book> showInventory() {
		return books;
	}

	public List<BookIssue> showIssuedBooks() {
		return issuedBooks;
	}

	private boolean isIsbnExists(String isbn) {
		boolean status = false;
		for (Book book : books) {
			if (book.getIsbn().equalsIgnoreCase(isbn)) {
				status = true;
			}
		}
		return status;
	}

	private Book getBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equalsIgnoreCase(isbn)) {
				return book;
			}
		}
		return null;
	}
}
