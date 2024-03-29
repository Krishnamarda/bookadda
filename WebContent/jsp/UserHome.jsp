<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/rightPanStyles.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
history.forward();
var panel='';
var menu = ['rightPanHome', 'rightPanProfile','rightPanWishList','rightPanOwnList','rightPanMessage'];
$(document).ready(function(){
	$.ajax({url:"homeAction",success:function(result){
		if(result==null || result==''){
			document.forms[0].action='logout';
			document.forms[0].submit();
			return;
		}
		$("#rightPanHome").html(result);
	  }});
	
	
  $(".rightPanItem").click(function(){
     var temp='#'+$(this).next().attr('id')
     if((panel!='' || panel!='undefined' )&& panel!=temp){
    		 $(panel).slideUp();
     }
     $(this).next().toggle("fast");
     panel=temp;
  });
  
});

function ticker() {
    $('.ticker p:first').slideUp(function() {
        $(this).appendTo($('.ticker')).slideDown();
    });
}
setInterval(ticker, 5000);

function setAction(linkNum) {
	var val = $(".leftPanList").children();
	
	if (linkNum == 5) {
		document.forms[0].action='logout';
		document.forms[0].submit();
		return;
	}
	var menuLen = menu.length;
	for ( var i = 0; i < menuLen; i++) {
		document.getElementById(menu[i]).style.display = 'none';
		$(val[i]).removeClass("selectedTab");
	}
	$(val[linkNum]).addClass("selectedTab");
	document.getElementById(menu[linkNum]).style.display = 'block';
	
	if(linkNum == 0){
		$.ajax({url:"homeAction",success:function(result){
			if(result==null || result==''){
				document.forms[0].action='logout';
				document.forms[0].submit();
				return;
			}
			$("#rightPanHome").html(result);
		  }});
	}
	
	if (linkNum == 1) {
		$.ajax({url:"profileAction",success:function(result){
			if(result==null || result==''){
				document.forms[0].action='logout';
				document.forms[0].submit();
				return;
			}
			$("#rightPanProfile").html(result);
			
			
		  }});
	}
	
	if(linkNum == 2){
		$.ajax({url:"wishListAction",success:function(result){
			if(result==null || result==''){
				document.forms[0].action='logout';
				document.forms[0].submit();
				return;
			}
			$("#rightPanWishList").html(result);
		  }});
	}
	
	if(linkNum == 3){
		$.ajax({url:"ownListAction",success:function(result){
			if(result==null || result==''){
				document.forms[0].action='logout';
				document.forms[0].submit();
				return;
			}
			$("#rightPanOwnList").html(result);
		  }});
	}
}


</script>
<title>Book Adda</title>

<style>
.body {
		
	/*  background: linear-gradient(#FFA319, #FFFF66, #FFFF66); */
	 background-repeat: no-repeat;
	 
}

#mainContainer {
	height: 100%;
	width : 1340px;
	position: absolute;
	top:50px;
	left:0px;
	background-color: white;
	/* box-shadow: 0px 0px 25px 0px grey; */
}

#header {
	width: 1350px;
	background: #CC3300;
	height: 50px;
	position : fixed;
	top : 0px;
	left: 0px;
	z-index : 10;
}

.DP {
	height: 150px;
	width: 150px;
	align: center;

}

#leftPan {
	position:fixed;
	width: 200px;
	height: 750px;
	border-right: 1px solid silver;
}

.rightPan{
	width: 770px;
	height: 750px;
	border-right: 1px solid silver;
	position : absolute;
	left : 200px;
	
}

.ticker p{
border-bottom: 1px solid silver;
float:left;
width:350px;
}

#searchText {
	font-family: 'Bree Serif', serif;
	font-size: 20px;
	padding: 13px 0px 0px 60px;
	float: left;
}

.input {
	width: 188px;
	padding: 11px 25px;
	font-family: "HelveticaNeue-Light", "Helvetica Neue Light",
		"Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif;
	font-weight: 400;
	font-size: 14px;
	color: #9d9e9e;
	text-shadow: 1px 1px 0 rgba(256, 256, 256, 1.0);
	margin-left: 30px;
	margin-top: 5px; float : left; background : #fff;
	border: 1px solid #fff;
	border-radius: 5px;
	box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.50);
	-moz-box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.50);
	-webkit-box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.50);
	background: #fff;
	float: left
}

.leftPanList li {
	list-style-type: none;
	 padding: 15px 0px 15px 5px;
	font-family: 'Bree Serif', serif;
	font-size: 18px;
	margin-top :5px;
}

.selectedTab{
background :#CC3300;
font-weight: bold;
}


.leftPanList li:hover {
/*background : #FEFF90;*/
background : #CC3300;
color : white;
cursor: pointer;
	
}

.rightPanList li {
	padding: 15px 20px 20px 0px;
	font-family: 'Bree Serif', serif;
	font-weight: 300;
	font-size: 18px;
	
}

.rightPanList li:hover {
/* background : #FEEF90; */
text-decoration: underline;
}


.button {
	float:left;
	padding: 9px 15px;
	font-family: 'Bree Serif', serif;
	font-weight: 300;
	font-size: 18px;
	color: #fff;
	text-shadow: 0px 1px 0 rgba(0,0,0,0.25);
	margin-left: 30px;
	margin-top: 5px;
	background: #56c2e1;
	border: 1px solid #46b3d3;
	border-radius: 5px;
	cursor: pointer;
	
	box-shadow: inset 0 0 2px rgba(256,256,256,0.75);
	-moz-box-shadow: inset 0 0 2px rgba(256,256,256,0.75);
	-webkit-box-shadow: inset 0 0 2px rgba(256,256,256,0.75);
}

.button:hover {
	background: #3f9db8;
	border: 1px solid rgba(256,256,256,0.75);
	
	box-shadow: inset 0 1px 3px rgba(0,0,0,0.5);
	-moz-box-shadow: inset 0 1px 3px rgba(0,0,0,0.5);
	-webkit-box-shadow: inset 0 1px 3px rgba(0,0,0,0.5);
}

.button:focus {
	position: relative;
	bottom: -1px;
	
	background: #56c2e1;
	
	box-shadow: inset 0 1px 6px rgba(256,256,256,0.75);
	-moz-box-shadow: inset 0 1px 6px rgba(256,256,256,0.75);
	-webkit-box-shadow: inset 0 1px 6px rgba(256,256,256,0.75);
}
.home{
    height: 50px;
	width: 50px;
	align: center;
	float:left;
	padding-left : 5px;
	cursor : pointer;
}
.img{
padding-left:20px;
padding-top:5px;
}

.rightPan h1{
font-family: 'Bree Serif', serif;
	font-weight: 300;
	font-size: 28px;
color:  #999966;
border-bottom: 1px solid silver;
}

.rightPanItem{
font-family: 'Bree Serif', serif;
	font-weight: 300;
	font-size: 25px;
	cursor : pointer;
}

#welcomeUser{
font-family: 'Bree Serif', serif;
font-size: 20px;
float:right;
padding:13px 30px 13px 30px; 
background:grey;
color:white;
}
</style>
</head>
<body class="body">

<form>	
<s:bean name="com.ba.pojo.UserDetails" var="ud" />
	<div id="mainContainer">
		<div id="header">
			<!-- <div class="home"><img src="images/home.png"  class="home"></div> -->
			<div id="searchText">Search Books</div>
			<div id="searchTextBox">
				<input type="text" class="input"
					placeholder="Book Name, Author Name, Location etc." style="width: 388px;"/>
			</div>
			<div id="searchButton">
				<input type="button" name="button" value="Search" class="button" />
			</div>
		
			<div id="welcomeUser">Welcome, <s:property value="ud.fname"/> </div>
		</div>
		<div id="leftPan">
			<div class="DP">
				<img src="images/user_2.png" class="DP img">
			</div>
			<div class="leftPanContent">
				<ul class="leftPanList">
					<li onclick="setAction(0);" class="selectedTab">Home</li>
					<li onclick="setAction(1);">Profile</li>
					<li onclick="setAction(2);">My Wishlist</li>
					<li onclick="setAction(3);">My OwnList</li>
					<li onclick="setAction(4);">Messages</li>
					<li onclick="setAction(5);">Logout</li>
				</ul>
			</div>
		</div>
		
	<!-- ------------------------- HOME SECTION STARTS HERE ------------------------- -->	
	
		<div id="rightPanHome" class="rightPan"></div>
		
	<!-- ------------------------- PROFILE SECTION STARTS HERE ------------------------- -->	
	
		<div id="rightPanProfile" style="display:none;" class="rightPan"></div>
		
	<!-- ------------------------- WISHLIST SECTION STARTS HERE ------------------------- -->	
		
		<div id="rightPanWishList" style="display:none;" class="rightPan"></div>
		
		
	<!-- ------------------------- OWNLIST SECTION STARTS HERE ------------------------- -->	
		
		<div id="rightPanOwnList" style="display:none;" class="rightPan"></div>
		
		<!-- ------------------------- MESSAGE SECTION STARTS HERE ------------------------- -->	
		
		<div id="rightPanMessage" style="display:none;" class="rightPan">
			<h1>Inbox</h1>
				<div id="message" class="messageDetails">
				<table width="100%">
				<tr>
				<td>User 1 </td></tr>
				<tr><td>User 2 </td></tr>
				<tr><td>User 3 </td>
				</tr>	
				</table>
				</div>
		</div>
		
		<!-- ------------------------- TICKER SECTION STARTS HERE ------------------------- -->	
			<!-- <div  class="ticker">
					<p>Harrypotter has been added to the Wishlist by user 1</p>
					<p>Headfirst sql has been added to the Wishlist by user 2</p>
					<p>Oracle handbook has been added to the Ownlist by user 1</p>
					<p>Mein Kamf has been added to the OwnList by user 3</p>
					<p>God Father has been added to the Wishlist by user 3</p>
			</div> -->
			
	</div>
	
	</form>
	
</body>
</html>