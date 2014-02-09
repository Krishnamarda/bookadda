function validate(){
var fname = document.forms[1].elements['rb.fname'];
var lname = document.forms[1].elements['rb.lname'];
var email = document.forms[1].elements['rb.email'];
var password = document.forms[1].elements['rb.password'];
if(fname.value.trim()==''){
	fname.style.border='1px solid red';
	document.getElementById('toolTipDiv').className='activeToolTip';
	document.getElementById('toolTipDiv').innerHTML='First Name is required.';
	return false;
}

if(lname.value.trim()==''){
	lname.style.border='1px solid red';
	document.getElementById('toolTipDiv').className='activeToolTip';
	document.getElementById('toolTipDiv').innerHTML='Last Name is required.';
	return false;
}

if(email.value.trim()==''){
	email.style.border='1px solid red';
	document.getElementById('toolTipDiv').className='activeToolTip';
	document.getElementById('toolTipDiv').innerHTML='Email is required.';
	return false;
}else{
	var emailText = email.value.trim();
    var pattern = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;
    if (!pattern.test(emailText)) {
    	document.getElementById('toolTipDiv').className='activeToolTip';
    	document.getElementById('toolTipDiv').innerHTML='Not a valid e-mail address.';
    	return false;
    }
}

if(password.value.trim()==''){
	password.style.border='1px solid red';
	document.getElementById('toolTipDiv').className='activeToolTip';
	document.getElementById('toolTipDiv').innerHTML='Password is Required.';
	return false;
}

if(password.value.trim().length<8){
	password.style.border='1px solid red';
	document.getElementById('toolTipDiv').className='activeToolTip';
	document.getElementById('toolTipDiv').innerHTML='Password should atlease be 8 character long.';
	return false;
}

document.forms[1].submit();

}

function resetFeild(obj){
	document.getElementById('toolTipDiv').className='idleToolTip';
	obj.style.border='1px solid #fff';
}