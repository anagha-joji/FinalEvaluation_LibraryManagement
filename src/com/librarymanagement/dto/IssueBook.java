package com.librarymanagement.dto;

public class IssueBook {
	
	private String issueId;
	private String issuedate;
	private String returndate;
	private String bookname;
	private String name;
	private String status;
	private int fine;
	private String bookid;
	private String userid;
	
	
	
	public int getFineamount() {
		return fine;
	}
	public void setFineamount(int fine) {
		this.fine = fine;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIssueid() {
		return issueId;
	}
	public void setIssueid(String issueId) {
		this.issueId = issueId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname ) {
		this.bookname = bookname;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public String getBookId() {
		return bookid;
	}
	public void setBookId(String bookid) {
		this.bookid = bookid;
	}
	public String getUserId() {
		return userid;
	}
	public void setUserId(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
