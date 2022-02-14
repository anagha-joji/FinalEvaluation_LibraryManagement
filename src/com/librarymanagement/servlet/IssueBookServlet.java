 package com.librarymanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarymanagement.dao.DBUtil;
import com.librarymanagement.dto.IssueBook;

/**
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String issuedate=request.getParameter("issuedate");
		final String returndate=request.getParameter("returndate");
		final String bookname=request.getParameter("bookname");
		final String name=request.getParameter("name");
		final String bookid=request.getParameter("bookid");
		final String userid=request.getParameter("userid");
		
		IssueBook issuebook=new IssueBook();
		
		issuebook.setIssuedate(issuedate);
		issuebook.setReturndate(returndate);
		issuebook.setBookname(bookname);
		issuebook.setName(name);
		issuebook.setBookId(bookid);
		issuebook.setUserId(userid);
		
		int rowCount=DBUtil.issueBook(issuebook);
		if(rowCount>0) {
			response.sendRedirect("adminHome.jsp");
		}
		else {
			response.sendRedirect("error.jsp");;
		}
		
	}

}
