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

public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			ServletContext ctx = getServletContext();
			Connection conn = (Connection) ctx.getAttribute("con");

			String actnumber = (String) ctx.getAttribute("actnumber");

			PreparedStatement psmt = conn
					.prepareStatement("select Balance,Holder_name, act_type from BankData  where act_number=?");

			psmt.setString(1, actnumber);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				out.print("<html><head><link rel='stylesheet' href='Style.css'></head><body>");
				out.print("<h3>Account Holder's Details : </h3>");
				out.print("<h4><br> Account Number : " + actnumber + "<br><br>");
				out.print(" Balance : " + rs.getDouble(1) + "$ <br><br>");
				out.print(" Holder name : " + rs.getString(2) + "<br><br>");
				out.print(" Account type : " + rs.getString(3) + "</h4>");
				out.print("</body></html>");
				request.getRequestDispatcher("Action.jsp").include(request, response);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
