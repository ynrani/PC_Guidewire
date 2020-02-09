<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Central | My Reservation Record</title>
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
		<!-- <script src="include/header.js"></script> -->
		<jsp:include page="header.jsp"></jsp:include>
		<div
			style="float: right; width: 10%; border: 0; font-color: #163361; padding-top: 15px; padding-left: 74px;">
			<a class="hrefButton" href="./tdmNSSearch"><spring:message
					code="label.back" /></a>
		</div>
		<script src="include/revMenu.js"></script>
		<div id="tabs-1" class="container">

			<form:form id="reservationNSDataForm" name="reservationNSDataForm"
				action="#">

				<div id="tabs-1" class="container scrollingX">
					<table class="table " style="width: 100%;">
						<thead>
							<tr>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
										code="label.action" /></th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
										code="label.expOn" /></th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
										code="label.tcId" /></th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">Application
									ID</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
										code="lebel.chkb" /></th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">Subscriber
									/ Member Id</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">Member
									Type</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
										code="label.prov.fname" /></th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
										code="label.prov.lname" /></th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">Date of
									Birth</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">Home
									Zip Code</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">A/C
									Number</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">A/C
									Name</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">EOB
									Suppressed?</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">Blend
									Government</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">Blend
									Group</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">Blend
									Retail</th>
								<th bgcolor="#E3EFFB" scope="col" class="whitefont">Coverage</th>
								<th />
							</tr>
						</thead>
						<tbody>

							<tr>
								<td>Un-Reserver</td>
								<td>05/20/2015</td>
								<td>BAM00127</td>
								<td>TBAM0012706</td>
								<td>S000123</td>
								<td>Subscriber</td>
								<td>Jhon</td>
								<td>Tony</td>
								<td>05/21/1987</td>
								<td>45687</td>
								<td>03258746952</td>
								<td>ABC</td>
								<td>Yes</td>
								<td>Yes</td>
								<td>No</td>
								<td>Yes</td>
								<td>Medical Only</td>
								<td>Medical Only</td>
							</tr>

							<tr>

								<td>Un-Reserver</td>
								<td>05/20/2015</td>
								<td>BAM00127</td>
								<td>TBAM0012706</td>
								<td>S000124</td>
								<td>Spouse</td>
								<td>Stack</td>
								<td>Tony</td>
								<td>05/21/1985</td>
								<td>45687</td>
								<td>03251234567</td>
								<td>LMN</td>
								<td>Yes</td>
								<td>Yes</td>
								<td>No</td>
								<td>Yes</td>
								<td>Dental Only</td>
								<td>Medical, Dental, Prescription</td>
							</tr>

							<tr>

								<td>Un-Reserver</td>
								<td>05/20/2015</td>
								<td>BAM00127</td>
								<td>TBAM0012706</td>
								<td>S000125</td>
								<td>Legal Guardian</td>
								<td>Maximus</td>
								<td>Glad</td>
								<td>05/21/1980</td>
								<td>45687</td>
								<td>03258712345</td>
								<td>PQR</td>
								<td>Yes</td>
								<td>Yes</td>
								<td>No</td>
								<td>Yes</td>
								<td>Medical, Dental, Prescription</td>
								<td>Medical and Dental</td>
							</tr>

							<tr>

								<td>Un-Reserver</td>
								<td>05/20/2015</td>
								<td>BAM00127</td>
								<td>TBAM0012706</td>
								<td>S000126</td>
								<td>Child</td>
								<td>Bruse</td>
								<td>Peter</td>
								<td>04/05/1992</td>
								<td>56248</td>
								<td>03258746999</td>
								<td>XYZ</td>
								<td>NO</td>
								<td>No</td>
								<td>No</td>
								<td>No</td>
								<td>Medical, Dental, Prescription</td>
								<td>Medical Only</td>
							</tr>

						</tbody>
					</table>
				</div>


				<table style="width: 100%; border: 0">
					<tbody>
						<tr>
							<th scope="col"><input type="button" name="export"
								id="export" class="btn-primary btn-cell"
								value="ExportAll to Excel"></th>
						</tr>
					</tbody>
				</table>

			</form:form>

		</div>

	</div>

	<script>
   menu_highlight('tdm_life_cycle1');
   menu_highlight('NS_Rev');
  </script>

</body>
</html>