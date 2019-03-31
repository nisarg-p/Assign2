import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		// Connect to mysql and verify username password
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test", "root", "root"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select * from login where username=? and password=?");
		ps.setString(1, un);
		ps.setString(2, pw);
 
		ResultSet rs = ps.executeQuery();
 
		while (rs.next()) {
			response.sendRedirect("success.html");
			return;
		}
		response.sendRedirect("error.html");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
//		try {
//			PrintWriter out = response.getWriter();
//			Class.forName("com.mysql.jdbc.Driver");  
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","root");  
//			
//			Statement stmt =  con.createStatement();  
//			ResultSet rs = stmt.executeQuery("select * from stud"); 
//			while(rs.next()) {
//				out.println(rs.getInt(1));
//			}
//		}
//		catch(Exception e) {
//			
//		}
			}

}