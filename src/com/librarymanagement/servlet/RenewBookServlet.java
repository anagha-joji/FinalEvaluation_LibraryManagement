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
 * Servlet implementation class RenewBook
 */
@WebServlet("/RenewBook")
public class RenewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String returndate=request.getParameter("returndate");
		String bookname=request.getParameter("bookname");
		
		IssueBook issuebook=new IssueBook();
		issuebook.setReturndate(returndate);
		issuebook.setBookname(bookname);
		
		int rowCount=DBUtil.renewBook(issuebook);
		
		if(rowCount>0) {
			response.sendRedirect("readerHome.jsp");
		}
		else {
			response.sendRedirect("error.jsp");;
		}
		
		
	}


}
