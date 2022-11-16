package bankapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String actnumber = req.getParameter("actnumber");
		String pin = req.getParameter("pin");
		
		
		try {
		ServletContext ctx = getServletContext();
		Connection conn = (Connection) ctx.getAttribute("con");
		ctx.setAttribute("actnumber", actnumber);
		
		PreparedStatement psmt = conn.prepareStatement("select pin, q1,ans1,q2,ans2,q3,ans3,q4,ans4 from BankData where act_number=?");
		
		psmt.setString(1, actnumber);
		
		ResultSet rs = psmt.executeQuery();
		
		while(rs.next())
		{
			if(pin.equals(rs.getString(1)))
			{
				String q1 = rs.getString(2);
				String q2 = rs.getString(4);
				String q3 = rs.getString(6);
				String q4 = rs.getString(8);
				
				Random random = new Random();
				int x = random.nextInt(4);
				
				List<String> list = new ArrayList<>();
				list.add(q1);
				list.add(q2);
				list.add(q3);
				list.add(q4);
				
				String que = list.get(x);
				//System.out.print(list);
				System.out.print(que);
				
				out.print("<html><head><link rel=\"stylesheet\" href=\"Style.css\"></head><body>");
				out.print("<h1>Successfully Logged into your Account </h1>");
				out.print("<h1>Answer this Security Question : </h1>" +"<h3 style='font-size:25px;'>"+que+"</h3>");
				out.print("</body></html>");
				
				List<String> list1 = new ArrayList<>();
				list1.add(rs.getString(3));
				list1.add(rs.getString(5));
				list1.add(rs.getString(7));
				list1.add(rs.getString(9));
				
				String ans = list1.get(x);
				System.out.print(ans);
				
				ctx.setAttribute("ans", ans);
				
			   out.print("<html><head><link rel=\"stylesheet\" href=\"Style.css\"></head><body>");
			   out.print("<form action='Question.jsp' style='text-align:center;'>");
			   out.print("<input type='text' name='ans1' style='padding:0.5% 5% 0.5% 1%;'><br><br>");
			   out.print("<input type='submit' value='Submit'id='btn_que' >");
			   out.print("</form>");
			   out.print("</body></html>");
  
			}
			else
			{
				out.print("<br><br><h3>Please enter correct PIN number...</h3>");
				req.getRequestDispatcher("Account.jsp").include(req, resp);
			}
		}
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
