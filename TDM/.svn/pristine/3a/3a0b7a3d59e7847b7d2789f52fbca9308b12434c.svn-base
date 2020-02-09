<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Portal | Change Request</title>
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

	<div id="main" class="wrapper mainAll">
		<jsp:include page="indexHeader.jsp"></jsp:include>
		<div class="container">
			<form:form id="dataChReqForm" name="dataChReqForm"
				action="./tdmChangeReqExt" modelAttribute="tdmChangeReqDTO">
				<ol class="breadcrumb">
					<li><a class="hrefVisited" href="./index">Home</a></li>
					<li>&#x2f;</li>
					<li><a class="hrefVisited" href="./index">TDM Life Cycle</a></li>
					<li>&#x2f;</li>
					<li class="active">Change Request</li>
				</ol>

				<h2 style="color: #0098cc">Change Request Details</h2>
				<hr>


				<div class="two-col">
					<table
						style="width: 100%; border: 0; font-size: 13px; color: #0C5473; cellpadding: 5;">
						<tbody>
							<tr>
								<td class="lable-title" width="20%" align="left" valign="middle">Enter
									Request ID</td>
								<td class="flied-title" width="20%" align="left" valign="middle">
									<div style="color: #F40E0E;">**Must start with TR/MR
										only**</div> <br /> <form:input path="reqId" id="reqId"
										class="form-control autosearch" maxlength="13" />

								</td>
								<td class="lable-title" width="20%" align="left" valign="middle"
									scope="col"><input type="submit" name="go"
									class="btn-primary btn-cell" id="go" value="Go"></td>

								<td class="lable-title" width="20%" align="left" valign="middle"></td>
								<td class="lable-title" width="20%" align="left" valign="middle"></td>

							</tr>
						</tbody>
					</table>
				</div>

			</form:form>
			<c:if test="${error ne null}">
				<table class="my-error-class">
					<tbody>
						<tr>
							<td class="lable-title" align="left" valign="middle">
								${error}</td>
						</tr>
					</tbody>
				</table>
			</c:if>
		</div>
		<script src="include/footer.js"></script>
	</div>

	<script>

menu_highlight('tdm_life_cycle1');
tdgChngReqValidation();

$(document).ready(function() {

	$( "#reqId" ).autocomplete({
		source: './tdmChangeReqId',
		minLength:2,
		scroll: true,
        scrollHeight: 180
	});
	
});



</script>



</body>
</html>
