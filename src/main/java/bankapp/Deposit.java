package bankapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

//		Scanner n = new Scanner(System.in);
//		out.print("Enter amount : ");
//		double bal = n.nextDouble();

		// String balance = String.valueOf(bal);
		String deposit2 = req.getParameter("deposit2");

		try {
			ServletContext ctx = getServletContext();
			Connection conn = (Connection) ctx.getAttribute("con");

			String actnumber = (String) ctx.getAttribute("actnumber");

			PreparedStatement psmt = conn.prepareStatement("select Balance from BankData  where act_number=?");

			psmt.setString(1, actnumber);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				double deposit3 = Double.parseDouble(deposit2);
				double b1 = rs.getDouble(1) + deposit3;

//			int count = psmt.executeUpdate();
//			if(count==1)
//				System.out.println(count+"row inserted successfully");
//			else
//				System.out.println("no record inserted");

				PreparedStatement psmt1 = conn.prepareStatement("Update BankData set Balance=? where act_number=?");

				psmt1.setDouble(1, b1);
				psmt1.setString(2, actnumber);

				int count = psmt1.executeUpdate();
				System.out.println(count + "row updated");

				out.print("<html><head><link rel=\"stylesheet\" href=\"Style.css\"></head><body>");
				out.print("<br><br><h3>Now, Your new balance is : </h3>" + "<h2>" + b1 + "$ </h2>");

				out.print("<form action='Account.jsp'>");
				out.print("<input type='submit' value='Continue' class='btn_deposit' style='margin-left:38.5%;'/>");
				out.print("</form>");
				out.print("<br>");

				out.print("<form action='index.jsp'>");
				out.print("<input type='submit' value='Home Page' class='btn_home' style='margin-left:38%; margin-top:2%;'>");
				out.print("</form>");
				out.print("</body></html>");

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
