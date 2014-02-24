
function validateRegister(){
var fname = document.forms[1].elements['rb.fname'];
var lname = document.forms[1].elements['rb.lname'];
var email = document.forms[1].elements['rb.email'];
var password = document.forms[1].elements['rb.password'];
var patt=new RegExp("[a-zA-Z]");

if(fname.value.trim()==''){
	fname.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='First Name is required.';
	fname.id='inValid';
	return false;
}
if(!patt.test(fname.value.trim())){
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Only alphabets are allowed in First Name';
	fname.id='inValid';
	return false;
}
fname.id='';
if(lname.value.trim()==''){
	lname.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Last Name is required.';
	lname.id='inValid';
	return false;
}

if(!patt.test(lname.value.trim())){
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Only alphabets are allowed in Last Name';
	lname.id='inValid';
	return false;
}
lname.id='';
if(email.value.trim()==''){
	email.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Email is required.';
	email.id='inValid';
	return false;
}else{
	var emailText = email.value.trim();
    var pattern = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;
    if (!pattern.test(emailText)) {
    	document.getElementById('toolTipDiv2').className='activeToolTip';
    	document.getElementById('toolTipDiv2').innerHTML='Not a valid e-mail address.';
    	email.id='inValid';
    	return false;
    }
}
email.id='';
if(password.value.trim()==''){
	password.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Password is Required.';
	password.id='inValid';
	return false;
}

if(password.value.trim().length<8){
	password.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Password should atlease be 8 character long.';
	password.id='inValid';
	return false;
}
password.id='';
}

function resetFeild(obj){
	$(obj).siblings("div").addClass("idleToolTip");
	obj.style.border='1px solid #fff';
	console.log($(obj).attr('id'));
	if($(obj).attr('id')=='inValid'){
		obj.value='';
	}
}

function  validateLogin(){
	var unm = document.forms[0].elements['username'];
	var pwd = document.forms[0].elements['password'];
	
	if(unm.value.trim()==''){
		unm.style.border='1px solid red';
		document.getElementById('toolTipDiv1').className='activeToolTip';
		document.getElementById('toolTipDiv1').innerHTML='Email is required.';
		console.log(unm.id);
		unm.id='inValid';
		return false;
	}else{
		var unmText = unm.value.trim();
	    var pattern = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;
	    if (!pattern.test(unmText)) {
	    	document.getElementById('toolTipDiv1').className='activeToolTip';
	    	document.getElementById('toolTipDiv1').innerHTML='Not a valid e-mail address.';
	    	unm.id='inValid';
	    	return false;
	    }
	}
	unm.id='';
	if(pwd.value.trim()==''){
		pwd.style.border='1px solid red';
		document.getElementById('toolTipDiv1').className='activeToolTip';
		document.getElementById('toolTipDiv1').innerHTML='Password is required.';
		pwd.id='inValid';
		return false;
	}
	pwd.id='';
}