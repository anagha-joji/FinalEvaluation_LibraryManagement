 package com.librarymanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.librarymanagement.dao.DBUtil;
import com.librarymanagement.dto.Login;
import com.librarymanagement.utils.Constants;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		System.out.println("username: "+username);
		System.out.println("password: "+password);
		HttpSession session=request.getSession();
		
		Login login = null;
		try {
			
			login = DBUtil.getUser(username,password);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	    
		if(login == null) {
		   response.sendRedirect("error2.jsp");
	      }
		
		else if(Constants.USER_TYPE_ADMIN.equals(login.getUserType())){
			session.setAttribute("username", login.getUsername());
			response.sendRedirect("adminHome.jsp");
		}
		
		else if(Constants.USER_TYPE_READER.equals(login.getUserType())){
			session.setAttribute("username", login.getUsername());
			response.sendRedirect("readerHome.jsp");
		}
	    
	    response.getWriter().close();
	}

}
