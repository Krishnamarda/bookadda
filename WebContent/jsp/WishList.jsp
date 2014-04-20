<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script>
	$("#WishListForm").submit(function() {
		var url = "addWishAction"; // the script where you handle the form input.

		if (validate()) {
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

	function validate() {
		var numeric = new RegExp("[0-9]");
		var bookName = document.forms["WishListForm"].bookName;
		if (bookName.value.trim() == "") {
			$(bookName).parent().next().text('Please Enter Book Name').css({
				"color" : "red",
				"font-weight" : "bold"
			});
			return false;
		}
		$(bookName).parent().next().text('');

		var author = document.forms["WishListForm"].author;
		if (author.value.trim() == "") {
			$(author).parent().next().text('Please Enter Author Name.').css({
				"color" : "red",
				"font-weight" : "bold"
			});
			return false;
		}
		$(author).parent().next().text('');

		var wishType = document.forms["WishListForm"].wishType;
		if (wishType.value.trim() == "") {
			$(wishType).parent().next().text('Please Select Wish Type.').css({
				"color" : "red",
				"font-weight" : "bold"
			});
			return false;
		}
		$(wishType).parent().next().text('');

		var quantity = document.forms["WishListForm"].quantity;
		if (quantity.value.trim() == "") {
			$(quantity).parent().next().text(
					'Please Enter Quantity of Book Available.').css({
				"color" : "red",
				"font-weight" : "bold"
			});
			return false;
		}
		$(quantity).parent().next().text('');
		if (!numeric.test(quantity.value.trim())) {
			$(quantity).parent().next().text('Quantity should be numeric.')
					.css({
						"color" : "red",
						"font-weight" : "bold"
					});
			return false;
		}
		$(quantity).parent().next().text('');

		return true;
	}

	function showWishListAddBox() {
		document.getElementById('wishlist').style.display = 'block';
		document.getElementById('showWishlist').style.display = 'none';
		document.getElementById('wishAddButton').style.display = 'none';
		document.getElementById('wishListHeader').style.display = 'none';
	}

	function viewWishList() {
		$.ajax({
			url : "wishListAction",
			success : function(result) {
				if (result == null || result == '') {
					document.forms[0].action = 'logout';
					document.forms[0].submit();
					return;
				}
				$("#rightPanWishList").html(result);
			}
		});
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
	display: none;
	text-align: center;
	padding-top: 10px;
}

.tableListTD{
	text-align: center;
	width: 25%;
}

tr {
	height: 30px;
}
</style>
</head>
<h1>WishList</h1>
<div>
	<p style="font-size: 18px; padding: 0px 5px 0px 5px;">Books in your
		Wishlist are those which you don't have and wish to exchange/borrow
		from other users who work in your company or study in your
		school/college or reside in the same locality/building.</p>
</div>
<div style="padding-left: 500px; margin-top: -10px;" id="wishAddButton">
	<input type="button" value="Add Books to WishList" class="button"
		onclick="showWishListAddBox();" />
</div>
<table style="width: 100%; border-spacing: 0px;" id="wishListHeader">
	<tr style="background: grey;">
		<td class="tableListTD"><b>Book</b></td>
		<td class="tableListTD"><b>Author</b></td>
		<td class="tableListTD"><b>Wish Type</b></td>
		<td class="tableListTD"><b>Quantity</b></td>
	</tr>
</table>
<div id="showWishlist"
	style="height: 500px; overflow: auto; border-bottom: 1px solid silver;">
	<table style="width: 100%; border-spacing: 0px;">
		<s:iterator value="wishList" status="hDStatus">
			<s:div cssClass="bookDesc" id="divId%{#hDStatus.count}">
				<s:if test="#hDStatus.count%2==0">
					<tr style="background: silver;">
				</s:if>
				<s:else>
					<tr>
				</s:else>
				<td class="tableListTD"><s:property value="book_name" /></td>
				<td class="tableListTD"><s:property value="author" /></td>
				<td class="tableListTD"><s:property value="wishtype" /></td>
				<td class="tableListTD"><s:property value="quantity" /></td>
				</tr>
			</s:div>
		</s:iterator>
	</table>

</div>

<div id="wishlist" class="wishListDetails" style="display: none;">
	<form name="WishListForm" id="WishListForm" method="post">
		<table width="100%">
			<tr>
				<td><input type="text" class="input" name="bookName"
					id="bookName" placeholder="Book Name" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="author" id="author"
					placeholder="Author Name" /></td>
				<td></td>
			</tr>
			<tr>
				<td><Select name="wishType" id="wishType" class="input"
					style="width: 240px;">
						<option value="">Wish Type</option>
						<option value="BORROW">Borrow</option>
						<option value="EXCHANGE">Exchange</option>
						<option value="BUY">Buy</option>
				</Select></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" name="quantity" id="quantity"
					class="input" placeholder="Quantity" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" class="button"></td>
				<td><input type="button" value="View WishList" class="button"
					onclick="viewWishList()"></td>
			</tr>
		</table>
		<div id="saveSuccess" class="faddingMessage"></div>
	</form>

</div>
</html>