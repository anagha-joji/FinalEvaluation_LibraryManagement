package com.librarymanagement.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.librarymanagement.dao.DBUtil;
import com.librarymanagement.dto.Book;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 final String name =request.getParameter("name"); 
		 final String category =request.getParameter("category"); 
		 List<Book> books=new ArrayList<Book>();
		
		 Book book=new Book();
		 book.setBookName(name); 
		 book.setCategory(category);
		 books = DBUtil.getAllBooks(name,category); 
		 
		 if(books!=null) { 
		    request.setAttribute("books", books);
		    RequestDispatcher rd = request.getRequestDispatcher("adminBookSearch.jsp");
		    rd.forward(request, response);
		 } 
		 else { 
			response.sendRedirect("adminHome.jsp"); 
			 }
	
	}

	

}
