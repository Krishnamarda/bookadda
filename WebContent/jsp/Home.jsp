<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script>
var panel1="#h1";
  $(".rightPanItem").click(function(){
     var temp='#'+$(this).next().attr('id');
     if((panel1!='' || panel1!='undefined' )&& panel1!=temp){
    		 $(panel1).slideUp();
     }
     $(this).next().toggle("fast");
     panel1=temp;
     
  });
 </script>

</head>
<h1>Books available near your address</h1>
			<ul class="rightPanList">
			<s:iterator value="homeData" status="hDStatus" >
			<li>
				<div  class="rightPanItem"><s:property value="ownlist_id"/></div>
				<s:div  cssClass="bookDesc" id="divId%{#hDStatus.count}">
				<table width="100%">
					<tr>
					<td><b>Book</b></td>
					<td><b>Author</b></td>
					<td><b>Available Type</b></td>
					<td><b>Quantity</b></td>
					</tr>
					<tr>
						<td><s:property value="book_name"/></td>
						<td><s:property value="author"/></td>
						<td><s:property value="availtype"/></td>
						 <td><s:property value="quantity"/> </td>
						<td align="right"><a href="#">Leave a message</a></td>
					</tr>
				</table>
			</s:div>
			</li>
			</s:iterator>
			</ul>
</html>