<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<html>
<head>
<title>Login Form | TestData Application</title>
<meta charset="utf-8">
<title>Search Test Data</title>
<link href="${pageContext.request.contextPath}/jQueryAssets/jquery.ui.core.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/jQueryAssets/jquery.ui.theme.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/jQueryAssets/jquery.ui.tabs.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/Styles.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/jQueryAssets/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jQueryAssets/jquery.ui-1.10.4.tabs.min.js"	type="text/javascript"></script>
<script> </script>
</head>
<body>
	<div align="center"
		style="text-align: center; padding: 100px; width: 1200px;">
		<h2>Login To TestData</h2>
		<div align="center"	style="text-align: center; padding: 50px; border: 2px solid green; width: 300px;">
			<%
				if (request.getParameter("auth") != null && request.getParameter("auth").equalsIgnoreCase("fail")) {
					out.println("Invalid Username and Password");
				}
				if (request.getParameter("logout") != null && request.getParameter("logout").equalsIgnoreCase("true")) {
					out.println("Logout Successfully");
				}
			%>
			<form action="${pageContext.request.contextPath}/tesdaLogin" method="post">
				<table style="width: 100%">
					<tr>
						<td>Username:</td>
						<td><input id='username' type='text' name='userid' /></td>
					</tr>
					<tr></tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='password'></td>
					</tr>
					<tr></tr>
					<tr>
						<td align="center" colspan='4'><input name="submit"
							type="submit" value="Submit"></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td align="right" colspan='4'><a
							href="${pageContext.request.contextPath}/fPassword">Forgot	Password?</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
