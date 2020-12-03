<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style>
	body {text-align: center;}
	nav a {text-decoration: none;
	padding: 5px 40px;
	text-align: center;
	border: 1px solid black;}
	table {border: 1px solid black;}
	.center {margin-left: auto;
			margin-right: auto;}
	th {border: 1px solid black;}
	td {border: 1px solid black;}
</style>

</head>
<body>
      <h2>Welcome to the</h2>
      <h1>Anonymous Bank - COVID Tracking System</h1>
      
      Please sign in below<br><br>
      
      <form action="/redirect" method="get">
      	<p> Username: <input name="username" type="text" value=""/> <br>
        <p> Password: <input name="password" type="password" value=""/> <br>
        <p> <button type = "submit"> Login </button> <button onclick="location.href='register'" type="button">Register</button>
        </p></form>
        <p><font color="red">Username and/or password not found. Please try again.</font></p>
</body>
</html>