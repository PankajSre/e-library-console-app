package com.iiht.training.elibrary.testutils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iiht.training.elibrary.model.Book;
import com.iiht.training.elibrary.model.BookIssue;

public class MasterData {

	public static Book getBookData() {
		Book book = new Book();
		book.setId(1);
		book.setName("Java");
		book.setPublication("BPB");
		book.setStream("Science");
		book.setIsbn("1234567899");
		book.setQuantity(20);
		return book;
	}

	public static List<Book> getBookList() {
		List<Book> books = new ArrayList<>();
		Book book = new Book();
		book.setId(1);
		book.setName("Java");
		book.setPublication("BPB");
		book.setStream("Science");
		book.setIsbn("1234567890");
		book.setQuantity(20);
		books.add(book);
		book = new Book();
		book.setId(2);
		book.setName("PHP");
		book.setPublication("Tech Media");
		book.setStream("Science");
		book.setIsbn("2345678901");
		book.setQuantity(0);
		books.add(book);
		return books;
	}

	public static BookIssue getBookIssueData() {
		BookIssue bookIssue = new BookIssue();
		bookIssue.setId(1);
		bookIssue.setIsbn("1234567890");
		bookIssue.setStudentName("Mohan");
		bookIssue.setIssueDate(LocalDate.now());
		return bookIssue;
	}

	public static List<BookIssue> getBookIssueList() {
		List<BookIssue> bookIssues = new ArrayList<>();
		BookIssue bookIssue = new BookIssue();
		bookIssue.setId(1);
		bookIssue.setIsbn("1234567890");
		bookIssue.setStudentName("Mohan");
		bookIssue.setIssueDate(LocalDate.now());
		bookIssues.add(bookIssue);
		bookIssue = new BookIssue();
		bookIssue.setId(2);
		bookIssue.setIsbn("2345678901");
		bookIssue.setStudentName("Krishna");
		bookIssue.setIssueDate(LocalDate.now());
		bookIssues.add(bookIssue);
		return bookIssues;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			final String jsonContent = mapper.writeValueAsString(obj);

			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
