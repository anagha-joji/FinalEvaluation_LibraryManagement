package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.librarymanagement.dto.IssueBook;
import com.librarymanagement.dto.Book;
//import com.librarymanagement.dto.Person;
import com.librarymanagement.dto.Login;

public class DBUtil {
	static int rowCount;
	
	//For login 
	
	public static Login getUser(String username, String password) throws SQLException {
		
		String sql = "Select username, password, name, user_type from USERS" //
				+ " where username = ? and password= ?";
		Connection conn;
		try {
			conn = MySqlConnection.getMySqlConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			Login user;
			if (rs.next()) {
				String Name = rs.getString("name");
				String userType = rs.getString("user_type");
				user = new Login();
				user.setUsername(username);
				user.setPassword(password);
				user.setDisplayName(Name);
				user.setUserType(userType);
	
				return user;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	//Adding new books to database
	
	public static int addBook(Book book) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			
			String sql = "insert into books(book_name,author_name,category,published_year) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthorName());
			ps.setString(3, book.getCategory());
			ps.setString(4, book.getPublishedYear());
		
			rowCount=ps.executeUpdate();
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(con);
		}
	return rowCount;
	}
	
	//Get all the book details from DB
	
	public static List<Book> showBook(){
		   Connection con = null;
		   List<Book> books=new ArrayList<Book>();
		    
		   try {
			   
			   con = ConnectionUtil.getConnection();
			   String query="select * from books";
			   PreparedStatement ps=con.prepareStatement(query);
				
				 
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   Book row=new Book();
				  
				   row.setBookId(rs.getInt("book_id"));
				   row.setBookName(rs.getString("book_name"));
				   row.setAuthorName(rs.getString("author_name"));
				   row.setCategory(rs.getString("category"));
				   row.setPublishedYear(rs.getString("published_year"));
				   
				   books.add(row);
				   
				   
			   }
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
				
				ConnectionUtil.close(con);
			}
		   return books;
	   }

	
	//searching books based on book_name or category or both
	
	public static List<Book> getAllBooks( String name, String category){
		   Connection con = null;
		   List<Book> books=new ArrayList<Book>();
		    
		   try {
			   
			   con = ConnectionUtil.getConnection();
			   String query="select * from books where book_name=? or category=?";
			   PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, name); 
				ps.setString(2, category);
				 
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   Book row=new Book();
				   
				   row.setBookId(rs.getInt("book_id"));
				   row.setBookName(rs.getString("book_name"));
				   row.setAuthorName(rs.getString("author_name"));
				   row.setCategory(rs.getString("category"));
				   row.setPublishedYear(rs.getString("published_year")); 
				   books.add(row);
				   
			   }
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
				ConnectionUtil.close(con);
			}
		   return books; 
	   }
	
	
	//issuing book for reader by admin
	
	public static int issueBook(IssueBook issuebook) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
				   String sql = "insert into issuebook(issue_date,return_date,book_name,name,status,book_id,uid) values(?,?,?,?,'No',?,?)";
				   PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, issuebook.getIssuedate());
					ps.setString(2, issuebook.getReturndate());
					ps.setString(3, issuebook.getBookname());
					ps.setString(4, issuebook.getName());
					ps.setString(5, issuebook.getBookId());
					ps.setString(6, issuebook.getUserId());
					rowCount=ps.executeUpdate();
					
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(con);
		}
		return rowCount;
	
	}
	
	//show issued books for admin and reader(Code Reusing)
	
	 public static List<IssueBook> showIssuedBooks(){
		   Connection con = null;
		   List<IssueBook> issuebook=new ArrayList<IssueBook>();
		    
		   try {
			   
			    con = ConnectionUtil.getConnection();
			   String query="select * from issuebook";
			   PreparedStatement ps=con.prepareStatement(query); 
		
			   ResultSet rs=ps.executeQuery();
				 while(rs.next()) { 
				 IssueBook row=new IssueBook();
				 row.setIssueid(rs.getString("issue_id"));
				 row.setIssuedate(rs.getString("issue_date"));
				 row.setReturndate(rs.getString("return_date"));
				 row.setBookname(rs.getString("book_name"));
				 row.setName(rs.getString("name"));
				 row.setStatus(rs.getString("status"));
				 row.setFineamount(rs.getInt("fine"));
				 row.setBookId(rs.getString("book_id"));		
				 row.setUserId(rs.getString("uid"));
			     issuebook.add(row); 
			   
				 }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
				ConnectionUtil.close(con);
			}
		   return issuebook;
	   } 
	 
	 
	 //admin return book
	 
	 public static int returnBook(IssueBook issuebook) {
			Connection con = null;
			try {
				con = ConnectionUtil.getConnection();
					   String sql = "update issuebook set status='Yes',fine=10 where book_name=? and uid=?";
					   PreparedStatement ps = con.prepareStatement(sql);
						
						ps.setString(1, issuebook.getBookname());
						ps.setString(2, issuebook.getUserId());
						rowCount=ps.executeUpdate();
						
				

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(con);
			}
		return rowCount;
		}
	 
	 //reader renew book
	 
	 public static int renewBook(IssueBook issuebook) {
			Connection con = null;
			try {
				con = ConnectionUtil.getConnection();
					   String sql = "update issuebook set status='No',return_date=? where book_name=?";
					   PreparedStatement ps = con.prepareStatement(sql);
						
						ps.setString(1, issuebook.getReturndate());
						ps.setString(2, issuebook.getBookname());
		
						rowCount=ps.executeUpdate();
						
				
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(con);
			}
		return rowCount; 
		
		}
	
	
}
