package bankapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String withdraw = request.getParameter("withdraw1");
		double withdraw1 = Double.parseDouble(withdraw);
		
		try {
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("con");
		
		String actnumber = (String) ctx.getAttribute("actnumber");
		
			PreparedStatement psmt = conn.prepareStatement("select balance from BankData  where act_number=?");
		 
			
			psmt.setString(1, actnumber);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				if(rs.getDouble(1)<withdraw1)
				{
					out.print("<html><head><link rel=\"stylesheet\" href=\"Style.css\"></head><body>");
					out.print("<h3>You have insufficient balance, can't withdraw.</h3>");
					out.print("</body></html>");
					request.getRequestDispatcher("Account.jsp").include(request, response);
					
				}
				else
				{
					double b2 = rs.getDouble(1)-withdraw1;
					out.print("<html><head><link rel=\"stylesheet\" href=\"Style.css\"></head><body>");
					out.print("<br><br><h3>Your new balance is : </h3>"+"<h2>"+b2+"$</h2>");
					
					out.print("<form action='Account.jsp'>");
					out.print("<br><input type='submit' value='Continue' class='btn_wdr' style='margin-left:38.5%;'/>");
					out.print("</form>");
					
					
					out.print("<form action='index.jsp'>");
					out.print("<input type='submit' value='Home Page' class='btn_home' style='margin-left:38%; margin-top:2%;'/>");
					out.print("</form>");
					out.print("</body></html>");

					
					
				
				
			PreparedStatement psmt1 = conn.prepareStatement("update BankData set balance=? where act_number=?");	
			psmt1.setDouble(1, b2);
			psmt1.setString(2, actnumber);
			
			int row =psmt1.executeUpdate();
			System.out.println(row +" row is updated");
			}
			}
		
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
