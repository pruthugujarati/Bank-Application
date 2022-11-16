<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="ISO-8859-1">
<title>Open Account</title>
</head>
<body>

<h2>Open Account</h2>
<div class="box">
<h1>Fill out this form to open your account.</h1>
<br>
<form action="OpenAccount" method="post" id="openact_id">

<p>
<h3>Select account type:</h3> 
 <input type="radio" id="type1" name="choice" value="Saving Account" required><b>Saving Account</b> 
 <input type="radio" id="type2" name="choice" value="Current Account" required><b>Current Account</b> <br>
 </p>
<p>
 <b>Account Holder Name :</b>
 <input type="text" name="name" id="name" required></p>
 
 <p><b>Your BirthDate :</b> 
 <input type="date" name="bdate" id="bdate" required></p>
 <p><b>Enter Driving License Number :</b>
 <input type="text" name="drnumber" id="drnumber" required></p>
 <p><b>Enter Pin Number :</b>
 <input type="number" name="pin" id="pin" required></p>
 
 <h3>Select security questions :</h3>
 <b>Select Security Question 1:</b>
 <select name="q1" class="que">
   <option>Select Question 1</option>
   <option value="Your mother's maiden name." >Your mother's maiden name.</option>
   <option value="Your first school." >Your first school.</option>
   <option value="Name of city where you born." >Name of city where you born.</option>
   <option value="Your home town." >Your home town.</option>
   <option value="Your favorite colour." >Your favorite colour.</option>
   <option value="Your favorite movie name." >Your favorite movie name.</option>
 </select>
 <input type="text" name="ans1" id="ans">
 
 <br>
 <br>
<b>Select Security Question 2:</b>
 <select name="q2" class="que">
   <option>Select Question 2</option>
   <option value="Your mother's maiden name." >Your mother's maiden name.</option>
   <option value="Your first school." >Your first school.</option>
   <option value="Name of city where you born." >Name of city where you born.</option>
   <option value="Your home town." >Your home town.</option>
   <option value="Your favorite colour." >Your favorite colour.</option>
   <option value="Your favorite movie name." >Your favorite movie name.</option>
 </select>
 <input type="text" name="ans2" id="ans">

 <br><br>
<b>Select Security Question 3:</b>
 <select name="q3" class="que">
   <option>Select Question 3</option>
   <option value="Your mother's maiden name." >Your mother's maiden name.</option>
   <option value="Your first school." >Your first school.</option>
   <option value="Name of city where you born." >Name of city where you born.</option>
   <option value="Your home town." >Your home town.</option>
   <option value="Your favorite colour." >Your favorite colour.</option>
   <option value="Your favorite movie name." >Your favorite movie name.</option>
 </select>
 <input type="text" name="ans3" id="ans">

 <br><br>
 <b>Select Security Question 4:</b>
 <select name="q4" class="que">
   <option>Select Question 4</option>
   <option value="Your mother's maiden name." >Your mother's maiden name.</option>
   <option value="Your first school." >Your first school.</option>
   <option value="Name of city where you born." >Name of city where you born.</option>
   <option value="Your home town." >Your home town.</option>
   <option value="Your favorite colour." >Your favorite colour.</option>
   <option value="Your favorite movie name." >Your favorite movie name.</option>
 </select>
 <input type="text" name="ans4" id="ans">
 <br>
 <br><p>
<b>Enter Initial Amount : $</b>
 <input type="text" name="deposit"></p>

<input type="checkbox"  name="condition" value="checked" required />Agree Terms and Condition.

<input type="submit" value="Submit" id="btn_open"><br>
 <a href="Account.jsp" class="ref">Already have an Account?</a>
</form>

</div>
</body>
</html>