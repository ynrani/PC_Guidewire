<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Portal | TDM Estimation Tool</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link href="css/theme.default.css" rel="stylesheet">
<script src="js/html5Shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/main.js"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/messages.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>

</head>

<body>
	<div class="wrapper mainAll">
		<jsp:include page="header.jsp"></jsp:include>
		<script src="include/menuEstTool.js"></script>
		<div id="tabs-1" class="container">
			<div class="">
				<table
					style="width: 100%; border: 0; font-size: 13px; cellpadding: 4;">
					<tbody>
						<tr>
							<td class="lable-title" width="35%" align="left" valign="middle"><b><spring:message
										code="label.tdmestTool" /></b></td>
						</tr>
						<tr>
							<td class="lable-title" width="35%" align="left" valign="middle"><p>
									<spring:message code="label.tdmestToolDesc" />
								</p></td>
						</tr>

						<tr>
							<td class="lable-title" align="left" valign="middle"><a
								class="hrefVisited" href="./downloadTdmEstTool">Download</a></td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
		<script src="include/footer.js"></script>
	</div>

	<script>
  menu_highlight('tdmEstimationTool');
   
  </script>
</body>
</html>
