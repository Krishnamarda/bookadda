function validateRegister(){
var fname = document.forms[1].elements['rb.fname'];
var lname = document.forms[1].elements['rb.lname'];
var email = document.forms[1].elements['rb.email'];
var password = document.forms[1].elements['rb.password'];
if(fname.value.trim()==''){
	fname.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='First Name is required.';
	return false;
}

if(lname.value.trim()==''){
	lname.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Last Name is required.';
	return false;
}

if(email.value.trim()==''){
	email.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Email is required.';
	return false;
}else{
	var emailText = email.value.trim();
    var pattern = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;
    if (!pattern.test(emailText)) {
    	document.getElementById('toolTipDiv2').className='activeToolTip';
    	document.getElementById('toolTipDiv2').innerHTML='Not a valid e-mail address.';
    	return false;
    }
}

if(password.value.trim()==''){
	password.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Password is Required.';
	return false;
}

if(password.value.trim().length<8){
	password.style.border='1px solid red';
	document.getElementById('toolTipDiv2').className='activeToolTip';
	document.getElementById('toolTipDiv2').innerHTML='Password should atlease be 8 character long.';
	return false;
}

document.forms[1].submit();

}

function resetFeild(obj){
	$(obj).siblings("div").addClass("idleToolTip");
//document.getElementById('toolTipDiv2').className='idleToolTip';
	obj.style.border='1px solid #fff';
	obj.value='';
}

function  validateLogin(){
	var unm = document.forms[0].elements['username'];
	var pwd = document.forms[0].elements['password'];
	
	if(unm.value.trim()==''){
		unm.style.border='1px solid red';
		document.getElementById('toolTipDiv1').className='activeToolTip';
		document.getElementById('toolTipDiv1').innerHTML='Email is required.';
		return false;
	}else{
		var unmText = unm.value.trim();
	    var pattern = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;
	    if (!pattern.test(unmText)) {
	    	document.getElementById('toolTipDiv1').className='activeToolTip';
	    	document.getElementById('toolTipDiv1').innerHTML='Not a valid e-mail address.';
	    	return false;
	    }
	}
	
	if(pwd.value.trim()==''){
		pwd.style.border='1px solid red';
		document.getElementById('toolTipDiv1').className='activeToolTip';
		document.getElementById('toolTipDiv1').innerHTML='Password is required.';
		return false;
	}
	
}