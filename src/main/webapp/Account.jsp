<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.Random, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h2>Account Page </h2>

<div class="box1">
<h1>Please,Login to Access your Account</h1>

<form action="Account" method="post" id="act_id">

<p><b>Enter Account Number :</b><br>
  <input type="text" name="actnumber" required></p>
<p><b> Enter Pin Number : </b> <br>
  <input type="text" name="pin" required></p>
  <br>
   

  <input type="submit" value="Submit" id="submit_btn">
</form>
</div>
</body>
</html>