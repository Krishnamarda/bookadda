<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script>
	$("#OwnListForm").submit(function() {
		var url = "addOwnAction"; // the script where you handle the form input.
		if (validate()) {
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

	function validate() {
		var numeric = new RegExp("[0-9]");
		var bookName = document.forms["OwnListForm"].bookName;
		if (bookName.value.trim() == "") {
			$(bookName).parent().next().text('Please Enter Book Name').css({
				"color" : "red",
				"font-weight" : "bold"
			});
			return false;
		}
		$(bookName).parent().next().text('');

		var author = document.forms["OwnListForm"].author;
		if (author.value.trim() == "") {
			$(author).parent().next().text('Please Enter Author Name.').css({
				"color" : "red",
				"font-weight" : "bold"
			});
			return false;
		}
		$(author).parent().next().text('');

		var availType = document.forms["OwnListForm"].availType;
		if (availType.value.trim() == "") {
			$(availType).parent().next().text(
					'Please Select Type of Book Availability.').css({
				"color" : "red",
				"font-weight" : "bold"
			});
			return false;
		}
		$(availType).parent().next().text('');

		var quantity = document.forms["OwnListForm"].quantity;
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

	function showOwnListAddBox() {
		document.getElementById('ownlist').style.display = 'block';
		document.getElementById('showOwnlist').style.display = 'none';
		document.getElementById('ownAddButton').style.display = 'none';
		document.getElementById('ownListHeader').style.display = 'none';
	}

	function viewOwnList() {
		$.ajax({
			url : "ownListAction",
			success : function(result) {
				if (result == null || result == '') {
					document.forms[0].action = 'logout';
					document.forms[0].submit();
					return;
				}
				$("#rightPanOwnList").html(result);
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

.tableListTD {
	text-align: center;
	width: 25%;
}

tr {
	height: 30px;
}
</style>
</head>
<h1>OwnList</h1>
<div>
	<p style="font-size: 18px; padding: 0px 5px 0px 5px;">Books in your
		Ownlist are those which you already have, and you wish to
		exchange/lend to other users who work in your company or study in your
		school/college or reside in the same locality/building.</p>
</div>
<div style="padding-left: 500px; margin-top: -10px;" id="ownAddButton">
	<input type="button" value="Add Books to OwnList" class="button"
		onclick="showOwnListAddBox()" />
</div>
<table style="width: 100%; border-spacing: 0px;" id="ownListHeader">
	<tr style="background: grey;">
		<td class="tableListTD"><b>Book</b></td>
		<td class="tableListTD"><b>Author</b></td>
		<td class="tableListTD"><b>Available Type</b></td>
		<td class="tableListTD"><b>Quantity</b></td>
	</tr>
</table>
<div id="showOwnlist"
	style="height: 500px; overflow: auto; border-bottom: 1px solid silver;">
	<table style="width: 100%; border-spacing: 0px;">
		<s:iterator value="ownList" status="hDStatus">
			<s:div cssClass="bookDesc" id="divId%{#hDStatus.count}">
				<s:if test="#hDStatus.count%2==0">
					<tr style="background: silver;">
				</s:if>
				<s:else>
					<tr>
				</s:else>
				<td class="tableListTD"><s:property value="book_name" /></td>
				<td class="tableListTD"><s:property value="author" /></td>
				<td class="tableListTD"><s:property value="availtype" /></td>
				<td class="tableListTD"><s:property value="quantity" /></td>
				</tr>
			</s:div>
		</s:iterator>
	</table>
</div>

<div id="ownlist" class="ownListDetails" style="display: none;">
	<form name="OwnListForm" id="OwnListForm" method="post">
		<table width="100%">
			<tr>
				<td><input type="text" name="bookName" id="bookName"
					class="input" placeholder="Book Name" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" name="author" id="author" class="input"
					placeholder="Author Name" /></td>
				<td></td>
			</tr>
			<tr>
				<td><Select name="availType" id="availType" class="input"
					style="width: 240px;">
						<option value="">Availability Type</option>
						<option value="LEND">Lend</option>
						<option value="EXCHANGE">Exchange</option>
						<option value="SELL">Sell</option>
				</Select></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="quantity"
					id="quantity" placeholder="Quantity" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" class="button"></td>
				<td><input type="button" value="View OwnList" class="button"
					onclick="viewOwnList()"></td>
			</tr>
		</table>
		<div id="saveStatus" class="faddingMessage"></div>
	</form>
</div>
</html>