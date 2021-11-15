package com.iiht.training.elibrary.model;

import java.time.LocalDate;
import java.util.Objects;

public class BookIssue {

	private Integer id;
	private String isbn;
	private String studentName;
	private LocalDate issueDate;

	public BookIssue() {
	}

	public BookIssue(Integer id, String isbn, String studentName, LocalDate issueDate) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.studentName = studentName;
		this.issueDate = issueDate;
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isbn, issueDate, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookIssue other = (BookIssue) obj;
		return Objects.equals(id, other.id) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(issueDate, other.issueDate) && Objects.equals(studentName, other.studentName);
	}

	@Override
	public String toString() {
		return "BookIssue [id=" + id + ", isbn=" + isbn + ", studentName=" + studentName + ", issueDate=" + issueDate
				+ "]";
	}

	
}
