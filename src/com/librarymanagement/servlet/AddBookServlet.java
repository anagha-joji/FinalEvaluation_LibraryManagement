package com.librarymanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarymanagement.dao.DBUtil;
import com.librarymanagement.dto.Book;


@WebServlet("/AddBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String name = request.getParameter("name");
		final String author =request.getParameter("author"); 
		final String category =request.getParameter("category"); 
		final String year =request.getParameter("year");
		
		
		Book book=new Book(); 
		book.setBookName(name); 
		book.setAuthorName(author);
		book.setCategory(category); 
		book.setPublishedYear(year);
		
		int rowCount=DBUtil.addBook(book); 
		 if(rowCount>0) {
		       response.sendRedirect("adminHome.jsp"); 
		 } 
		 else {
		       response.sendRedirect("error.jsp");; 
		 }
	}

 }
