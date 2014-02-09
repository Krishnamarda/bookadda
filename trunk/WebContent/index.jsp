<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<meta name="generator" content="Web Page Maker V2">
<link rel="stylesheet" type="text/css" href="css/loginForm.css">
<script type="text/javascript"  src="js/common.js"></script>
</head>
<body class="body">
<div id="logo">
<h1>Book Adda</h1>
<hr/>
</div>
<form name="loginForm" action="#" method="post">
	<div id="mainContainer">
	<div id="login" style="float:left;" class="login-form">
			<div class="header">
				<h1>Login</h1>
			</div>
			<div class="content">
				<input name="lb.username" type="text" class="input" placeholder="Email" />
				<input name="lb.password" type="password" class="input" placeholder="Password" />
			</div>

			<div class="footer">
				<input type="submit" name="button" value="Forget Password?" class="button" />
				<input type="submit" name=button value="Login" class="button" />
			</div>
	</div>
	</form>
	<form name="registerForm" action="doRegister" method="post" onsubmit="return validate();">
	<div id="register" style="float:left;width:450px;" class="login-form">
			<div class="header">
				<h1>Register</h1>
			</div>
			<div class="content">
			<div id="toolTipDiv" class="idleToolTip"></div>
			<input name="rb.fname" type="text" class="input" placeholder="First Name" onfocus="resetFeild(this);"/>
			<input name="rb.lname" type="text" class="input" placeholder="Last Name" onfocus="resetFeild(this);"/>
			<input name="rb.email" type="text" class="input" placeholder="Email" onfocus="resetFeild(this);" />
			<input name="rb.password" type="password" class="input" placeholder="Password" onfocus="resetFeild(this);" />
			</div>

			<div class="footer">
				<input type="submit" name="button" value="Register" class="button" />
			</div>
	</div>
	</div>
	</form>
	<div style="position:absolute; left: 0%; top: 90%; width:100%; text-align:center;">
	Copyright &#169 2013 BookAdda.com - All rights are Reserved <BR/><a href=#>Terms & Privacy</a>

	
	</div>
</body>
</html>
