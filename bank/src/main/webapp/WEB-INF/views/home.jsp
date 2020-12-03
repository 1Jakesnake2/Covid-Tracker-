<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<html>
<head>
 <style>
  html * {
    font-family: Segoe UI;
  }
	body * {text-align: center;background-color: #white;}
      
  .center {
  margin-left: auto;
  margin-right: auto;
  }
  .blueSpace {
    left: 0;
    top: -20;
    width: 100%;
    display:block;
    background-color: #1a1a1a;
  	color: white;
  	text-align: center;
  	padding: 20px 0px;
  	text-decoration: none;
    background-color: #3973ac;
  }
  ul {
  		list-style-type: none;
  		margin: 0;
  		padding: 0;
  		overflow: hidden;
    	display: inline-block;
  	}
  	li {
  		float: left;
  	}
  	li a{
  		display:block;
      background-color: #1a1a1a;
  		color: white;
  		text-align: center;
  		padding: 10px 15px;
  		text-decoration: none;
  	}
    footer * {
      position: fixed;
      left: 0;
      bottom: -20;
      width: 100%;
      display:block;
      background-color: #1a1a1a;
  		color: white;
  		text-align: center;
  		padding: 10px 0px;
  		text-decoration: none;
    }
</style> 
 <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    <title>Homepage</title>
</head>
<body>
		<body>
    <header>
      <div class="blueSpace">
        <h2>Welcome to the</h2>
        <h1>Anonymous Bank - COVID Tracking System</h1>
      </div>
    </header>
    <div style="background-color: #1a1a1a;">
      <ul>
        <li><a href="welcome" style = "background-color: gray;">Homepage</a></li>
        <li><a href="locations">Log Locations</a></li>
        <li><a href="history">Check History</a></li>
        <li><a href="status">Report Positive Case</a></li>
        <li><a href="log_out">Log Out</a></li>
      </ul>
    </div>
    <p><br>
    
      	<p>Below is your recent history of reported locations.<br>
      	A <b><font color="red">RED</font></b> status indicates you were in contact with an individual during that time.<br></p>
      	
      	<table class="center" width = "500">
		<tr>
			<td> Office </td>
			<td> Date</td>
			<td> Time In </td>
			<td> Time Out </td>
			<td> Status </td>
		</tr>
	
	<c:forEach items = "${locationlist}" begin = "0" end = "4" var = "loc">
		<tr>
			<td> ${loc.office} </td>
			<td> ${loc.date}</td>
			<td> ${loc.tin}</td>
			<td> ${loc.tout}</td>
			<td> ${loc.status}</td>
		
		</tr>
	</c:forEach>
		
	</table>
	<footer>
      <p>To make any changes to the recorded log, please contact the site
        administrator at covid@abank.com</p>
    </footer>
</body>
</html>