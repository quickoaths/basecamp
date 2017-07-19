package Dtbse;

import java.sql.*;

public class jdbc_ex1 {

	public static void main(String[] args) throws SQLException {
		
		 
		try {
			// Loading the driver class 
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded!");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		// Creating connection object by creating an interface - Connection
			Connection con = null;
			Statement stmt = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_shop?autoReconnect=true&useSSL=false","root","mysql123");
				System.out.println("Connection is established");
				
				// Create statement object
				stmt =con.createStatement();  
				System.out.println(con.getClass().getName()); // Returns connection details to know type of connection
						
				// CREATE Operation
				System.out.println("CREATE Operation");
				String sql_i = "INSERT INTO books (book_id, title, author_fname, author_lname, released_year, stock_quantity, pages) VALUES (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement_i = con.prepareStatement(sql_i);
				statement_i.setInt(1, 27);
				statement_i.setString(2, "Open Letter 5");
				statement_i.setString(3, "RORY");
				statement_i.setString(4, "Gates");
				statement_i.setInt(5, 2017);
				statement_i.setInt(6, 1000);
				statement_i.setInt(7, 12);
				
				int rowsInserted = statement_i.executeUpdate(); //This method returns an update count indicating how many rows in the table were affected
				System.out.println("Returns an update count of" + rowsInserted);
				
				// READ Operations
				System.out.println("READ Operations");
				ResultSet rs=stmt.executeQuery("select * from books");  
				while(rs.next())  
				System.out.println(rs.getInt("book_id") + "\t "+ rs.getString("title") + "\t "+ rs.getString("author_fname"));  
				
				// UPDATE Operations
				System.out.println("UPDATE Operations");
				String sql_u = "UPDATE books SET title=? WHERE author_fname=?";
				PreparedStatement statement_u = con.prepareStatement(sql_u);
				statement_u.setString(1, "Open Letter Melinda");
				statement_u.setString(2, "Melinda");
				statement_u.executeUpdate();
				ResultSet rs_u=stmt.executeQuery("select * from books"); 
				while(rs_u.next())  
				System.out.println(rs_u.getInt("book_id") + "\t "+ rs_u.getString("title") + "\t "+ rs_u.getString("author_fname"));  
					
				
				// DELETE Operations
				System.out.println("DELETE Operations");
				String sql_d = "DELETE FROM books WHERE author_fname=?";
				PreparedStatement statement_d = con.prepareStatement(sql_d);
				statement_d.setString(1, "Don");
				ResultSet rs_d=stmt.executeQuery("select * from books");
				statement_d.executeUpdate();
				while(rs_d.next())  
				System.out.println(rs_d.getInt("book_id") + "\t "+ rs_d.getString("title") + "\t "+ rs_d.getString("author_fname"));  
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
			}
			
			finally {
				if(con != null) {
					try {
						con.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}}	
		

	}


