package com.iiht.training.elibrary.boundary;

import static com.iiht.training.elibrary.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.elibrary.testutils.TestUtils.currentTest;
import static com.iiht.training.elibrary.testutils.TestUtils.testReport;
import static com.iiht.training.elibrary.testutils.TestUtils.yakshaAssert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.elibrary.exception.ISBNAlreadyExistsException;
import com.iiht.training.elibrary.inventory.BookInventory;
import com.iiht.training.elibrary.model.Book;
import com.iiht.training.elibrary.model.BookIssue;
import com.iiht.training.elibrary.testutils.MasterData;

public class BoundaryTest {

	static BookInventory bookInventory = null;

	@BeforeAll
	public static void setUp() {
		bookInventory = new BookInventory();
		bookInventory.books = MasterData.getBookList();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testBookIsbnIsUnique() throws Exception {
		Book book = MasterData.getBookData();
		book.setIsbn("1234567890");
		try {
			bookInventory.addBook(book);
			yakshaAssert(currentTest(), false, boundaryTestFile);
		} catch (ISBNAlreadyExistsException e) {
			yakshaAssert(currentTest(), true, boundaryTestFile);
		}

	}

	@Test
	public void testBookStreamIsFixed() throws Exception {
		Book book = MasterData.getBookData();
		List<String> streams = Arrays.asList("Science", "Commerce", "Arts", "Management", "Media");
		if (streams.contains(book.getStream())) {
			bookInventory.addBook(book);
			yakshaAssert(currentTest(), true, boundaryTestFile);
		} else {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}

	}

	@Test
	public void testBookIssueIsbnAlreadyExists() throws Exception {
		List<Book> books = bookInventory.showInventory();
		BookIssue bookIssue = MasterData.getBookIssueData();
		List<String> isbns = new ArrayList<>();
		for (Book book : books) {
			isbns.add(book.getIsbn());
		}

		yakshaAssert(currentTest(), isbns.contains(bookIssue.getIsbn()) ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookIssueDateIsPastOrPresent() throws Exception {
		BookIssue bookIssue = MasterData.getBookIssueData();

		yakshaAssert(currentTest(),
				bookIssue.getIssueDate().isBefore(LocalDate.now()) || bookIssue.getIssueDate().isEqual(LocalDate.now())
						? true
						: false,
				boundaryTestFile);
	}

}
