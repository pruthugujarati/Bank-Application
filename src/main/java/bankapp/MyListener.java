package bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servlet destroyed");

		ServletContext ctx = sce.getServletContext();
		Connection con = (Connection) ctx.getAttribute("con");
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent sce) {

		String url = "jdbc:mysql://localhost:3306/BankDB";
		String user = "root";
		String pass = "Pgujarati108@@";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);

			ServletContext ctx = sce.getServletContext();
			ctx.setAttribute("con", conn);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
