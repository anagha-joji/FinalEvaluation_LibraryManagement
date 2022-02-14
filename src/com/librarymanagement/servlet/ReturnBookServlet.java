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
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String bookname=request.getParameter("bookname");                                                                                                  //p
		final String userid=request.getParameter("userid");                                   
		
		IssueBook issuebook=new IssueBook();
		issuebook.setBookname(bookname);
		issuebook.setUserId(userid);
		int rowCount=DBUtil.returnBook(issuebook);
		if(rowCount>0) {
			response.sendRedirect("adminHome.jsp");
		}
		else {
			response.sendRedirect("error.jsp");;
		}
		
	}

	

}
