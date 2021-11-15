package com.iiht.training.elibrary.functional;

import static com.iiht.training.elibrary.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.elibrary.testutils.TestUtils.businessTestFile;
import static com.iiht.training.elibrary.testutils.TestUtils.currentTest;
import static com.iiht.training.elibrary.testutils.TestUtils.exceptionTestFile;
import static com.iiht.training.elibrary.testutils.TestUtils.testReport;
import static com.iiht.training.elibrary.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.elibrary.exception.ISBNAlreadyExistsException;
import com.iiht.training.elibrary.inventory.BookInventory;
import com.iiht.training.elibrary.model.Book;
import com.iiht.training.elibrary.model.BookIssue;
import com.iiht.training.elibrary.testutils.MasterData;

class BookIssueUnitTest {

	static BookInventory inventory;

	@BeforeAll
	public static void setUp() {
		inventory = new BookInventory();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testBookQuantityIsNotNull() throws IOException {
		Book book = MasterData.getBookData();
		int quantity = book.getQuantity();
		yakshaAssert(currentTest(), quantity > 0 ? true : false, businessTestFile);
	}

	@Test
	public void testIssueBook() throws IOException {
		BookIssue bookIssue = MasterData.getBookIssueData();
		yakshaAssert(currentTest(), inventory.issueBook(bookIssue.getIsbn(), bookIssue.getStudentName()) ? true : false,
				businessTestFile);
	}

	@Test
	public void testGetAllIssueBooks() throws IOException {
		List<BookIssue> bookIssues = MasterData.getBookIssueList();
		yakshaAssert(currentTest(), bookIssues.size() == 2 ? true : false, businessTestFile);
	}
}
