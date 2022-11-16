<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="ISO-8859-1">
<title>Action</title>
</head>
<body>
<br><br>
<h3>|| Select Performance ||</h3>
<div id="action">
<form action="Deposit.jsp" >
  <input type="submit" value="Deposit Money" class="action">
</form>

<form action="Withdraw.jsp" >
  <input type="submit" value="Withdraw Money" class="action">
</form>

<form action="View" method="post" >
  <input type="submit" value="View Balance" class="action">
</form>

<form action="index.jsp" >
   <input type = "submit" value="Home Page" class="action">
</form>
</div>
</body>
</html>