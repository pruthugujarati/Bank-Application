<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="ISO-8859-1">
<title>Question</title>
</head>
<body>
 
<%
try {
	
	String ans1 = request.getParameter("ans1");
	ServletContext ctx = getServletContext();
    String ans = (String)ctx.getAttribute("ans");
		if(ans.equalsIgnoreCase(ans1))
		{
			out.print("<h3>Authetication, Successfully done!!</h3>");
			
			request.getRequestDispatcher("Action.jsp").include(request, response);
		}
		else
		{
		  out.print("<html><head><link rel='stylesheet' ref='Style.css'></head><body>");
		  out.print("<h3>Sorry ... Try again!!</h3>");
	      request.getRequestDispatcher("Account.jsp").include(request, response);
	      out.print("</body></html>");
        }
}
catch(Exception e)
{
	System.out.println(e);
}
%>

</body>
</html>