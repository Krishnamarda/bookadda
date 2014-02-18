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
			<li>
				<div  class="rightPanItem">Harry Potter</div>
				<div id="h1" class="bookDesc">
				<table width="100%">
					<tr>
						<td>User-1</td>
						<td>Pimple Saudagar, Kunal Icon</td>
						<td align="right"><a href="#">Leave a message</a></td>
					</tr>
					<tr>
						<td>User-2</td>
						<td>Infosys Phase2</td>
						<td align="right"><a href="#">Leave a message</a></td>
					</tr>
				</table>
				</div>
			</li>
			<li>
				<div class="rightPanItem">Shiva Triology - Oath of vayuputra</div>
				<div id="h2" class="bookDesc" style="display : none;">
				<table width="100%">
					<tr>
						<td>User-1</td>
						<td>Pimple Saudagar, Kunal Icon</td>
						<td align="right"><a href="#">Leave a message</a></td>
					</tr>
					<tr>
						<td>User-2</td>
						<td>Infosys Phase2</td>
						<td align="right"><a href="#">Leave a message</a></td>
					</tr>
				</table>
				</div>
			</li>
			</ul>
</html>