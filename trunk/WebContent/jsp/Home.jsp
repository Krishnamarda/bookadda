<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script>
/* var panel1="#h1";
  $(".rightPanItem").click(function(){
     var temp='#'+$(this).next().attr('id');
     if((panel1!='' || panel1!='undefined' )&& panel1!=temp){
    		 $(panel1).slideUp();
     }
     $(this).next().toggle("fast");
     panel1=temp;
     
  }); */
 </script>

</head>
<h1>Books available near your address</h1>
			<ul class="rightPanList">
			<s:iterator value="homeData" status="hDStatus" >
			<li style="text-decoration:none; list-style-type: none;">
				<div  class="rightPanItem" style="cursor:default;"><s:property value="ownlist_id"/><span><a href="#" style="float:right; font-size: 18px;">Leave a message</a></span></div>
				<s:div  cssClass="bookDesc" id="divId%{#hDStatus.count}">
				<table>
					<tr style="background:silver;">
					<td style="width:35%;"><b>Book</b></td>
					<td style="width:35%;"><b>Author</b></td>
					<td style="width:20%;"><b>Available Type</b></td>
					<td style="width:10%;"><b>Quantity</b></td>
					</tr>
					<tr>
						<td style="width:35%;"><s:property value="book_name"/></td>
						<td style="width:35%;"><s:property value="author"/></td>
						<td style="width:20%;"><s:property value="availtype"/></td>
						<td style="width:10%;"><s:property value="quantity"/> </td>
					</tr>
				</table>
			</s:div>
			</li>
			<hr/>
			</s:iterator>
			</ul>
</html>