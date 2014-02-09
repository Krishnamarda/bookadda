<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style>
.body {
	background : linear-gradient(#A9CFC2, #A9CFC2, #A9CFC2);
	font-family: 'Bree Serif', serif;
	font-size: 18px;
	/* margin-left : 10px; */
	color: #414848;
	text-shadow: 0px 1px 0 rgba(256, 256, 256, 0.5);
}
</style>

</head>

<body class="body">

	<table width="100%">
		<tr>
			<td colspan=2 style="background: #0066FF;box-shadow: 10px 10px 5px;"><tiles:insertAttribute
					name="breadCrumb" /></td>
		</tr>
		<tr>
			<td width="100%" align="center" colspan=2><tiles:insertAttribute
					name="banner" /></td>
		</tr>

		<tr height="475px">
			<td width="20%" valign="top"
				style="border-right: 1px solid black; border-color: #204848;"><tiles:insertAttribute
					name="menu" /></td>
			<td width="80%" style="padding-left: 10px;"><tiles:insertAttribute
					name="body" /></td>
		</tr>
		<tr>
			<td width="100%" colspan=2
				style="border-top: 1px solid black; border-color: #204848;"><tiles:insertAttribute
					name="footer" /></td>
		</tr>
	</table>
</body>
</html>