<html>
<head>
<script>

	$("#WishListForm").submit(function() {
		var url = "addWishAction"; // the script where you handle the form input.
		
		if(validate()){
		$.ajax({
			type : "POST",
			url : url,
			data : $("#WishListForm").serialize(), // serializes the form's elements.
			success : function(result) {
				if (result == null || result == '') {
					document.forms[0].action = 'logout';
					document.forms[0].submit();
					return;
				}
				 $("#saveSuccess").fadeIn(1000).fadeOut(6000);
				$("#saveSuccess").html(result);
				document.getElementById("WishListForm").reset();
			}
		});
		}
		return false; // avoid to execute the actual submit of the form.
	});
	
	
	function validate(){
		var numeric = new RegExp("[0-9]");
		var bookName=document.forms["WishListForm"].bookName;
		if(bookName.value.trim()==""){
			$(bookName).parent().next().text('Please Enter Book Name').css({"color":"red","font-weight":"bold"});
			return false;
		}
		$(bookName).parent().next().text('');
		
		var author=document.forms["WishListForm"].author;
		if(author.value.trim()==""){
			$(author).parent().next().text('Please Enter Author Name.').css({"color":"red","font-weight":"bold"});
			return false;
		}
		$(author).parent().next().text('');
		
		var wishType=document.forms["WishListForm"].wishType;
		if(wishType.value.trim()==""){
			$(wishType).parent().next().text('Please Select Wish Type.').css({"color":"red","font-weight":"bold"});
			return false;
		}
		$(wishType).parent().next().text('');
		
		var quantity=document.forms["WishListForm"].quantity;
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
<h1>WishList</h1>
<div>
	<p>Add books that you don't have and wish to exchange/borrow from
		other users who work in your company or study in your school/college
		or reside in the same locality/building.</p>
</div>
<div id="wishlist" class="wishListDetails">
<form name="WishListForm" id="WishListForm"  method="post">
	<table width="100%">
		<tr>
			<td><input type="text" class="input" name="bookName" id="bookName" placeholder="Book Name" /></td>
			<td></td>
		</tr>
		<tr>
			<td><input type="text" class="input" name="author" id="author" placeholder="Author Name" /></td>
			<td></td>
		</tr>
		<tr>
			<td><Select name="wishType" id="wishType" class="input"
				style="width: 240px;">
					<option value="">Select</option>
					<option value="BORROW">Borrow</option>
					<option value="EXCHANGE">Exchange</option>
					<option value="BUY">Buy</option>
			</Select></td>
			<td></td>
		</tr>
		<tr>
			<td><input type="text" name="quantity" id ="quantity" class="input" placeholder="Quantity" /></td>
			<td></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add" class="button"></td>
		</tr>
	</table>
	<div id="saveSuccess" class="faddingMessage"></div>
	</form>
		
</div>
</html>