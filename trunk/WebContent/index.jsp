 <% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="css/loginForm.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"  src="js/common.js"></script>

	
</head>
<body class="body">
<div id="logo">
<h1>Book Adda</h1>
<hr/>
</div>
<div id="mainContainer">
<form name="loginForm" action="doLogin" method="post" onsubmit="return validateLogin();">
<s:set name="loginVal" value="loginError"/>

	<div id="login" style="float:left;" class="login-form">
			<div class="header">
				<h1>Login</h1>
			</div>
			<div class="content">
				<div id="toolTipDiv1" class="idleToolTip"></div>
				<s:if test="%{#loginVal=='true'}"><div id="loginError" style="color: red;">Invalid Credentials.</div></s:if>
				<input name="username" type="text" class="input" placeholder="Email" onfocus="resetFeild(this);"/>
				<input name="password" type="password" class="input" placeholder="Password" onfocus="resetFeild(this);"/>
			</div>

			<div class="footer">
				<input type="submit" name="button" value="Forget Password?" class="button" />
				<input type="submit" name=button value="Login" class="button" />
			</div>
	</div>
	</form>
	<form name="registerForm" action="doRegister" method="post" onsubmit="return validateRegister();">
	<s:set name="regVal" value="isUserDuplicate"/>
	<div id="register" style="float:left;width:450px;" class="login-form">
			<div class="header">
				<h1>Register</h1>
			</div>
			<div class="content">
			<div id="toolTipDiv2" class="idleToolTip"></div>
			<s:if test="%{#regVal=='true'}"><div id="regError" style="color: red;">This email is already registered.</div></s:if>
			<input name="rb.fname" type="text" class="input" placeholder="First Name" onfocus="resetFeild(this);"/>
			<input name="rb.lname" type="text" class="input" placeholder="Last Name" onfocus="resetFeild(this);"/>
			<input name="rb.email" type="text" class="input" placeholder="Email" onfocus="resetFeild(this);" />
			<input name="rb.password" type="password" class="input" placeholder="Password" onfocus="resetFeild(this);" />
			</div>

			<div class="footer">
				<input type="submit" name="button" value="Register" class="button" />
			</div>
	</div>
	</form>
	</div>
	<div style="position:absolute; left: 0%; top: 90%; width:100%; text-align:center;">
	Copyright &#169 2013 BookAdda.com - All rights are Reserved <BR/><a href=#>Terms & Privacy</a>

	
	</div>
</body>
</html>
