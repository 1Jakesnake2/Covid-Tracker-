<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    <style>
  html * {
    font-family: Segoe UI;
  }
	body * {text-align: center;}
      
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
  .formRegister {
    border-style: none;
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
  	
    .regTD{text-align: right;
    	margin: 10px 10px;}
    	
    .tdwidth {width: 75px;}
    
    
    table.registration {margin: auto;}
    
    td {text-align: right;}
    form {text-align: center;}
    
</style> <title>Registration</title>
  </head>
  <body>
    <header>
      <div class="blueSpace">
        <h2>Welcome to the</h2>
        <h1>Anonymous Bank - COVID Tracking System</h1>
      </div>
    </header>
    <p><br>
      REGISTRATION</p>
  
    <form class="formRegister" action="/create" method="get">
    <table id = "formTable" style = "  margin-left:auto; margin-right:auto;">
    	<tr><td><p id = "fname" class = "regTD">First Name: <input name="fname" type="text" value=""/></p></td>
    	<td class = "tdwidth"></td> 
      	<td><p id = "lname" class = "regTD">Last Name: <input name="lname" type="text" value=""/></p> </td></tr>
      	<tr><td><p id = "username" class = "regTD">Username: <input name="username" type="text" value=""/></p>
      	</td><td class = "tdwidth"></td>
        <td><p id = "password" class = "regTD">Password: <input name="password" type="text" value=""/></p></td></tr>
        <tr><td><p id = "email" class = "regTD">Email: <input name="email" type="text" value=""/></p></td></tr>
        </table>
      <button type="submit" class = "regTD"> Submit </button>  <button onclick="location.href='/'" type="button">Return to login</button>
      </form>
    
    <footer>
      <p>For assistance in creating an account, please contact the site
        administrator at covid@abank.com</p>
    </footer>
  </body>
</html>
