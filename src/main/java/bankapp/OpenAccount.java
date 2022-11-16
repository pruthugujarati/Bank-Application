package bankapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OpenAccount")
public class OpenAccount extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String type= req.getParameter("choice");
		String name= req.getParameter("name");
		String bdate = req.getParameter("bdate");
		String drnumber = req.getParameter("drnumber");
		String pin = req.getParameter("pin");
		String deposit= req.getParameter("deposit");
		String q1 = req.getParameter("q1");
		String ans1 = req.getParameter("ans1");
		String q2 = req.getParameter("q2");
		String ans2 = req.getParameter("ans2");
		String q3 = req.getParameter("q3");
		String ans3 = req.getParameter("ans3");
		String q4 = req.getParameter("q4");
		String ans4 = req.getParameter("ans4");
		
		
		if( pin.length()==4)
		{
			
			
			
			LocalDate d = LocalDate.parse(bdate);
			int m = d.getYear();
			System.out.println(m);
			System.out.println(name.charAt(0));
			
			String actnumber = String.valueOf(m)+String.valueOf(name.charAt(0))+drnumber.substring(2, 5);
			System.out.println(actnumber);
			
			out.print("<html><head><link rel='stylesheet' href='Style.css'></head><body>");
			out.print("<h3><br>Account Holder's Details: </h3>");
			out.print("<h4><br>Your Account Type : </b>"+type );
			out.print("<br><br>Account Holder Name   : </b>"+name);
			out.print("<br><br>Your Birth Date : </b>"+bdate);
			out.print("<br><br>Your Driving License Number : </b>"+drnumber);
			out.print("<br><br>Your Pin Number : </b>"+pin+"</h4>");
			
			out.print("<h4><br>Your Account Number : "+actnumber);
			
			out.print("<br><br>Your current balance : $"+deposit+"</h4>");
			out.print("</body></html>");
//			Scanner n = new Scanner(System.in);
//			out.print("Enter amount to deposit money :");
//			double amount1 = n.nextDouble();
//			String amount = String.valueOf(amount1);
			
			try {
				ServletContext ctx= getServletContext();
				Connection conn = (Connection) ctx.getAttribute("con");
				PreparedStatement psmt = conn.prepareStatement("insert into BankData values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				//ctx.setAttribute("actnumber", actnumber);
				
				psmt.setString(1, null);
				psmt.setString(2, name);
				psmt.setString(3, type);
				psmt.setString(4, actnumber );
				psmt.setString(5, bdate);
				psmt.setString(6, drnumber);
				psmt.setString(7, pin);
				psmt.setString(8, deposit);
				psmt.setString(9, q1);
				psmt.setString(10, ans1);
				psmt.setString(11, q2);
				psmt.setString(12, ans2);
				psmt.setString(13, q3);
				psmt.setString(14, ans3);
				psmt.setString(15, q4);
				psmt.setString(16, ans4);
				
				int count = psmt.executeUpdate();
				if(count==1)
					System.out.println(count+"row inserted successfully");
				else
					System.out.println("no record inserted");
				
				out.print("<html><head><link rel='stylesheet' href='Style.css'></head><body>");
				out.print("<form action='Account.jsp'>");
				out.print("<br><input type='submit' value='Login to Perform Operation' id='btn_open'>");
				out.print("</form>");
				out.print("</body></html>");
			}
			catch(SQLException e)
			{
			System.out.println(e);
			}
		}
		else
		{
			out.print("<html><head><link rel='stylesheet' href='Style.css'></head><body>");
			out.print("<h4><br><br>Pin Number should be 4 digits.<br></h4>");
			out.print("</body></html>");
			req.getRequestDispatcher("OpenAccount.jsp").include(req, resp);
		}
	}

}
