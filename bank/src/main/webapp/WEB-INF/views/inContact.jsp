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
</style> <title>WARNING</title>
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
        <li><a href="locations">Log Locations</a></li>
        <li><a href="history">Check History</a></li>
        <li><a href="status">Report Positive Case</a></li>
        <li><a href="log_out">Log Out</a></li>
      </ul> 
    </div>
    <footer>
      <p>To make any changes to the recorded log, please contact the site
        administrator at covid@abank.com</p>
    </footer>
    <h1><font-color="red"><b>STOP</b></font-color="red"></h1>
    <p></p>
    <p>You have been in contact with someone who has tested positive for COVID-19. 
      Please contact your supervisor by phone for further direction.</p>
     <form class="formSignIn" action="/log" method="get"> 
    <p><button type = "submit">EXIT</button> </p>
    </form>
  </body>
</html>
