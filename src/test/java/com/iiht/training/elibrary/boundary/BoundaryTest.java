package com.iiht.training.elibrary.boundary;

import static com.iiht.training.elibrary.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.elibrary.testutils.TestUtils.currentTest;
import static com.iiht.training.elibrary.testutils.TestUtils.testReport;
import static com.iiht.training.elibrary.testutils.TestUtils.yakshaAssert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.elibrary.inventory.BookInventory;
import com.iiht.training.elibrary.model.Book;
import com.iiht.training.elibrary.model.BookIssue;
import com.iiht.training.elibrary.testutils.MasterData;

public class BoundaryTest {

	static BookInventory bookInventory = null;

	@BeforeAll
	public static void setUp() {
		bookInventory = new BookInventory();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testBookNameNotNull() throws Exception {
		Book book = MasterData.getBookData();
		yakshaAssert(currentTest(), book.getName().length() > 0 ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookNameMinThree() throws Exception {
		Book book = MasterData.getBookData();
		yakshaAssert(currentTest(), book.getName().length() >= 3 ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookNameMaxHundred() throws Exception {
		Book book = MasterData.getBookData();
		String name = "";
		for (int i = 0; i < 120; i++) {
			name.concat("A");
		}
		book.setName(name);
		yakshaAssert(currentTest(), book.getName().length() <= 100 ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookQuantityNotNull() throws Exception {
		Book book = MasterData.getBookData();
		yakshaAssert(currentTest(), book.getQuantity() != null ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookQuantityMinOne() throws Exception {
		Book book = MasterData.getBookData();
		yakshaAssert(currentTest(), book.getQuantity() >= 1 ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookIsbnNotNull() throws Exception {
		Book book = MasterData.getBookData();
		yakshaAssert(currentTest(), book.getIsbn() != null ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookIsbnLengthMinTen() throws Exception {
		Book book = MasterData.getBookData();
		book.setIsbn("1234567890");
		yakshaAssert(currentTest(), book.getIsbn().length() == 10 ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookIsbnLengthMaxTen() throws Exception {
		Book book = MasterData.getBookData();
		book.setIsbn("1234567890");
		yakshaAssert(currentTest(), book.getIsbn().length() == 10 ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookStreamIsFixed() throws Exception {
		Book book = MasterData.getBookData();
		List<String> streams = Arrays.asList("Science", "Commerce", "Arts", "Management", "Media");
		yakshaAssert(currentTest(), streams.contains(book.getStream()) ? true : false, boundaryTestFile);
	}

	@Test
	public void testBookIssueIsbnAlreadyExists() throws Exception {
		Set<Book> books = bookInventory.showInventory();
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
