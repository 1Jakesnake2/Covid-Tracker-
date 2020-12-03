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
  .formSignIn {
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
</style> <title>Login</title>
  </head>
  <body>
    <header>
      <div class="blueSpace">
        <h2>Welcome to the</h2>
        <h1>Anonymous Bank - COVID Tracking System</h1>
      </div>
    </header>
    <p><br>
      LOGIN</p>
    <form class="formSignIn" action="/redirect" method="get"> 
    	<input name="email" placeholder="example@abank.com" required="" autofocus="" type="text"><br>
      	<input name="password" placeholder="Password" required="" type="password"><br>
      	 <input type="checkbox" id="reset" name="reset" value="reset">
  		<label for="reset">Reset status and test date.</label><br>
      <br>
      <button type = "submit"> Login </button> <button onclick="location.href='register'" type="button">Register</button> </form>

  </body>
</html>
