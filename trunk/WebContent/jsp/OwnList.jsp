<html>
<head>
<script>
	$("#OwnListForm").submit(function() {
		var url = "addOwnAction"; // the script where you handle the form input.
		if(validate()){
		$.ajax({
			type : "POST",
			url : url,
			data : $("#OwnListForm").serialize(), // serializes the form's elements.
			success : function(result) {
				if (result == null || result == '') {
					document.forms[0].action = 'logout';
					document.forms[0].submit();
					return;
				}
				 $("#saveStatus").fadeIn(1000).fadeOut(6000);
				$("#saveStatus").html(result);
				document.getElementById("OwnListForm").reset();
			}
		});
		}
		return false; // avoid to execute the actual submit of the form.
	});
	
	function validate(){
		var numeric = new RegExp("[0-9]");
		var bookName=document.forms["OwnListForm"].bookName;
		if(bookName.value.trim()==""){
			$(bookName).parent().next().text('Please Enter Book Name').css({"color":"red","font-weight":"bold"});
			return false;
		}
		$(bookName).parent().next().text('');
		
		var author=document.forms["OwnListForm"].author;
		if(author.value.trim()==""){
			$(author).parent().next().text('Please Enter Author Name.').css({"color":"red","font-weight":"bold"});
			return false;
		}
		$(author).parent().next().text('');
		
		var availType=document.forms["OwnListForm"].availType;
		if(availType.value.trim()==""){
			$(availType).parent().next().text('Please Select Type of Book Availability.').css({"color":"red","font-weight":"bold"});
			return false;
		}
		$(availType).parent().next().text('');
		
		var quantity=document.forms["OwnListForm"].quantity;
		if(quantity.value.trim()==""){
			$(quantity).parent().next().text('Please Enter Quantity of Book Available.').css({"color":"red","font-weight":"bold"});
			return false;
		}
		$(quantity).parent().next().text('');
		if(!numeric.test(quantity.value.trim())){
			$(quantity).parent().next().text('Quantity should be numeric.').css({"color":"red","font-weight":"bold"});
			return false;
		}
		$(quantity).parent().next().text('');
		
		return true;
	}
</script>
<style>
.faddingMessage {
	width: 570px;
	height: 40px;
	margin: 20px 0px 40px 40px;
	background: silver;
	font-family: 'Bree Serif', serif;
	font-weight: 300;
	font-size: 20px;
	display : none;
	text-align: center;
	padding-top:10px;
}
</style>
</head>
<h1>OwnList</h1>
<div>
	<p>Add books that you have and wish to exchange/lend to other
		users.</p>
</div>
<div id="ownlist" class="ownListDetails">
	<form name="OwnListForm" id="OwnListForm" 
		method="post">
		<table width="100%">
			<tr>
				<td><input type="text" name="bookName" id="bookName" class="input" placeholder="Book Name" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" name="author" id="author" class="input" placeholder="Author Name" /></td>
				<td></td>
			</tr>
			<tr>
				<td><Select name="availType" id="availType" class="input"
					style="width: 240px;">
						<option value="">Select</option>
						<option value="LEND">Lend</option>
						<option value="EXCHANGE">Exchange</option>
						<option value="SELL">Sell</option>
				</Select></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="quantity" id="quantity" placeholder="Quantity" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" class="button"></td>
				<td></td>
			</tr>
		</table>
		<div id="saveStatus" class="faddingMessage"></div>
	</form>
</div>
</html>