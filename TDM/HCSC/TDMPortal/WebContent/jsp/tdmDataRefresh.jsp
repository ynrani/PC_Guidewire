<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Central | Data Refresh</title>
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
<body>
	<div class="wrapper mainAll">
		<jsp:include page="indexHeader.jsp"></jsp:include>
		<div class="container">
			<form:form id="dataRefreshForm" name="dataRefreshForm"
				action="${pageContext.request.contextPath}/tdmDataRefresh"
				modelAttribute="tdgDataRefreshDTO">

				<ol class="breadcrumb">
					<li><a class="hrefVisited" href="./index">Home</a></li>
					<li>&#x2f;</li>
					<li><a class="hrefVisited" href="./index">TDM Life Cycle</a></li>
					<li>&#x2f;</li>
					<li class="active">Data Refresh</li>
				</ol>
				<h2 style="color: #0098cc">
					<spring:message code="label.dtref.dtl" />
				</h2>
				<hr>
				<div class="two-col">
					<table
						style="width: 100%; border: 0; font-size: 13px; color: #0C5473; cellpadding: 2;">
						<tbody>
							<tr>
								<td class="lable-title" width="80%" align="left" valign="middle"><spring:message
										code="label.dtref.q1" /><span>*</span></td>
								<td class="flied-title" width="20%" align="left" valign="middle">
									<form:textarea path="pageDtRef1" id="pageDtRef1"
										class="form-control" />
								</td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.dtref.q2" /><span>*</span><br /></td>
								<td class="lable-title" align="left" valign="middle" scope="col">
									<form:textarea path="pageDtRef2" id="pageDtRef2"
										class="form-control" />
								</td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.dtref.q3" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="pageDtRef3" id="pageDtRef3" class="form-control" /></td>
							</tr>
						</tbody>
					</table>
					<br />
					<table style="width: 100%; border: 0;">
						<tbody>
							<tr>
								<th scope="col"><input type="button" name="submit"
									class="btn-primary btn-cell" value="Submit"></th>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
		<script src="include/footer.js"></script>
	</div>

	<script>
menu_highlight('tdm_life_cycle1');
 tdgDataRefreshValidation();
</script>

</body>
</html>
