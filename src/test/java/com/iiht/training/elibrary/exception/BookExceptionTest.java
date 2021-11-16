package com.iiht.training.elibrary.exception;

import static com.iiht.training.elibrary.testutils.TestUtils.currentTest;
import static com.iiht.training.elibrary.testutils.TestUtils.exceptionTestFile;
import static com.iiht.training.elibrary.testutils.TestUtils.testReport;
import static com.iiht.training.elibrary.testutils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.elibrary.inventory.BookInventory;
import com.iiht.training.elibrary.model.Book;
import com.iiht.training.elibrary.testutils.MasterData;

class BookExceptionTest {

	static BookInventory inventory;

	@BeforeAll
	public static void setUp() {
		inventory = new BookInventory();
		inventory.books = MasterData.getBookList();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test()
	public void testBookIsbnAlreadyExists() throws IOException {
		Book book = MasterData.getBookData();
		book.setIsbn("1234567890");
		ISBNAlreadyExistsException thrown = Assertions.assertThrows(ISBNAlreadyExistsException.class, () -> {
			inventory.addBook(book);
		});
		String message = "The ISBN " + book.getIsbn() + " already exists";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);
		
	}

	@Test()
	public void testInvalidBookQuantityException() throws IOException {
		Book book = MasterData.getBookData();
		book.setQuantity(0);
		InvalidBookQuantityException exception = Assertions.assertThrows(InvalidBookQuantityException.class, () -> {
			inventory.addBook(book);
		});
		String message = "Book quantity must be greater than zero";
		yakshaAssert(currentTest(), message.contentEquals(exception.getMessage()) ? true : false, exceptionTestFile);
	}

}
