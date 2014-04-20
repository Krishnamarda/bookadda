<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>

<style type="text/css">
h1 {
	margin-right: 10px;
	padding-left: 10px;
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
}</style>

<script>
var panel2="#p1";
  $(".rightPanItem").click(function(){
     var temp='#'+$(this).next().attr('id');
     if((panel2!='' || panel2!='undefined' )&& panel2!=temp){
    		 $(panel2).slideUp();
     }
     $(this).next().toggle("fast");
     panel2=temp;
     
  });



$('#country').change(function(){
    var id=$(this).val();
    $.get('loadStates',{id:id},function(data){
        $("#state").html(data);
    });
});
</script>

</head>
<s:bean name="com.ba.pojo.UserDetails" var="userDetails" />
			<h1>Profile</h1>
			<ul class="rightPanList">
			<li>
				<div class="rightPanItem">Pesonal Details</div>
				<div id="p1" class="personalDetails">
				<table width="100%">
					<tr>
						<td>First Name</td>
						<td><s:textfield name="userDetails.fname" cssClass="input"></s:textfield></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><s:textfield name="userDetails.lname" cssClass="input"></s:textfield></td>	
					</tr>
					<tr>
						<td>Email</td>
						<td><s:textfield name="userDetails.email" cssClass="input"></s:textfield></td>	
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" class="input" disabled="disabled"/></td>	
					</tr>
					<tr>
						<td style="padding:15px 0px 0px 0px;">Gender</td>
						<td style="padding:15px 0px 0px 35px;">Male<input type=radio name="gender" value="M">&nbsp;
						Female<input type=radio name="gender" value="F"></td>
					</tr>
				</table>
				</div>
			</li>
			<li>
				<div class="rightPanItem">Institution Details</div>
				<div id="p2" class="rAddressDetails" style="display : none;">
				<table width="100%">
					<!-- <tr>
						<td>Working&nbsp;<input type="radio" name="occ" value="work"></td>
						<td>Studying&nbsp;<input type="radio" name="occ" value="study"></td>						
					</tr> -->
					
					<tr>
						<td>Country</td>
						<td><Select name="country" id="country" class="input" style="width:240px;">
						<option value="">Select</option>
						<option value="IN">India</option>
						<option value="AU">Australia</option>
						<option value="US">USA</option>
						<option value="EN">England</option>
						</Select></td>						
					</tr>
					<tr>
						<td>State</td>
						<td><Select name="state" id="state" class="input" style="width:240px;">
						<option value="">Select</option>
						</Select></td>					
					</tr>
					<tr>
						<td>City</td>
						<td><Select name="city" class="input" style="width:240px;">
						<option value="">Select</option>
						<option value="pune">Pune</option>
						<option value="mumbai">Mumbai</option>
						<option value="nagpur">Nagpur</option>
						<option value="satara">Satara</option>
						</Select></td>						
					</tr>
					<tr>
						<td>Area</td>
						<td><Select name="city" class="input" style="width:240px;">
						<option value="">Select</option>
						<option value="hinjewadi">Hinjewadi</option>
						<option value="magarpatta">Magarpatta</option>
						<option value="kothrud">Kothrud</option>
						<option value="sbroad">S.B. Road</option>
						</Select></td>						
					</tr>
					<tr>
						<td>Company</td>
						<td><Select name="city" class="input" style="width:240px;">
						<option value="">Select</option>
						<option value="infosys1">Infosys Phase 1</option>
						<option value="infosys2">Infosys Phase 2</option>
						<option value="ibm">IBM</option>
						<option value="wipro1">Wipro Phase 1</option>
						<option value="wipro2">Wipro Phase 2</option>
						<option value="mindtree">Mindtree</option>
						</Select></td>						
					</tr>
				</table>
				</div>
			</li>
			
			</ul>
</html>		
		