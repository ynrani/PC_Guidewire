<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>L1 L2 Support</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link href="css/theme.default.css" rel="stylesheet">
<link href="css/elements.css" rel="stylesheet">
<script src="js/html5Shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/main.js"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/messages.js"></script>
<script src="js/common.js"></script>
</head>
<body>
<form:form id="autoEmailForm" name="autoEmailForm" action="#"
	modelAttribute="autoEmailDTO">
	<table style="width: 80%; border: 0; font-size: 13px; cellpadding: 4;">
		<tbody>
			<tr>
				<td class="lable-title" align="left" valign="middle">To</td>
				<td class="flied-title" align="left" valign="middle"><form:input
						id="to" path="to" class="popUp-ctl email" /></td>
			<tr>
				<td class="lable-title" align="left" valign="middle">Cc</td>
				<td class="flied-title" align="left" valign="middle"><form:input
						id="cc" path="cc" class="popUp-ctl email" /></td>
			</tr>
			<tr>
				<td class="lable-title" align="left" valign="middle">Subject</td>
				<td class="flied-title" align="left" valign="middle"><form:input
						id="subject" path="subject" class="popUp-ctl email" /></td>
			</tr>
			<tr>
				<td class="lable-title" align="left" valign="middle">Message</td>
				<td class="flied-title" align="left" valign="middle"><form:textarea
						id="msg" path="msg" class="message" charCount="2000" /></td>
				<form:hidden path="from" />
			</tr>
			<tr>
			<td align="center">
			<input type="button" name="submit"						value="Send Email" class="btn-primary btn-cell"
				title="Experiencing highly connectivity problem with SMTP Server. Please try after some time..." />
		   </td>
			</tr>
		</tbody>
	</table>	
</form:form>
</body>
</html>
