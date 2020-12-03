<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
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
</style> <title>Log Activity</title>
  </head>
  <body>
    <header>
      <div class="blueSpace">
        <h2>Welcome to the</h2>
        <h1>Anonymous Bank - COVID Tracking System</h1>
      </div>
    </header>
    <div style="background-color: #1a1a1a;">
      <ul>
        <li><a href="welcome">Homepage</a></li>
        <li><a href="locations" style = "background-color: gray;">Log Locations</a></li>
        <li><a href="history">Check History</a></li>
        <li><a href="status">Report Positive Case</a></li>
        <li><a href="log_out">Log Out</a></li>
      </ul>
    </div>
    <form style="width: 50%; margin: 0 auto;" action="/logloc" method="get">
      <p>Office:<br>
        <select name="office" required="">
          <option style="display:none;" disabled="disabled" selected="selected"

            value=""></option>
          <option value="Lobby">Lobby</option>
          <option value="ConferenceRoom">Conference Room</option>
          <option value="WestHallway">West Hallway</option>
          <option value="EastHallway">East Hallway</option>
          <option value="ManagerOffice">Manager's Office</option>
          <option value="BreakRoom">Break Room</option>
        </select>
      </p>
      <p>Date:<br>
        <input name="date" value="" required="" type="date"> </p>
      <p>Time In:<br>
        <input name="tin" value="" required="" pattern="[0-9]{2}:[0-9]{2}" type="time"> </p>
      <p>Time Out:<br>
        <input name="tout" value="" required="" pattern="[0-9]{2}:[0-9]{2}" type="time"> </p>
      <button type="submit"> Submit </button> </form>
    <footer>
      <p>To make any changes to the recorded log, please contact the site
        administrator at covid@abank.com</p>
    </footer>
    
  </body>
</html>
