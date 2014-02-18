<html>
<head>
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

			<h1>Profile</h1>
			<ul class="rightPanList">
			<li>
				<div class="rightPanItem">Pesonal Details</div>
				<div id="p1" class="personalDetails">
				<table width="100%">
					<tr>
						<td>First Name</td>
						<td><input type="text" class="input"/></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" class="input"/></td>	
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" class="input"/></td>	
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" class="input"/></td>	
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
		