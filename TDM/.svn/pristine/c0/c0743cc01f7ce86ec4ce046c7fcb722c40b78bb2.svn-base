<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Portal | On-Boarding Request</title>
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
			<form:form id="dataOnboardReqForm" name="dataOnboardReqForm"
				action="./tdmOnboardReq" modelAttribute="tdmOnboardReqDTO">
				<ol class="breadcrumb">
					<li><a class="hrefVisited" href="./index">Home</a></li>
					<li>&#x2f;</li>
					<li><a class="hrefVisited" href="./index">TDM Life Cycle</a></li>
					<li>&#x2f;</li>
					<li class="active">TDM On-Board Request</li>
					<c:if test="${reqId ne null}">
						<li>&#x2f;</li>
						<li style="font-size: 14px; color: #0098CC;">Request ID :
							${reqId}</li>
					</c:if>
				</ol>

				<h2 style="color: #0098cc">TDM On-Board Request Details</h2>
				<hr>
				<div class="two-col">
					<table
						style="width: 100%; border: 0; font-size: 13px; color: #0C5473; cellpadding: 4;">
						<tbody>
							<tr>
								<td class="lable-title" width="35%" align="left" valign="middle"><spring:message
										code="label.dm.name" /> <span>*</span></td>
								<td class="flied-title" width="20%" align="left" valign="middle">
									<form:input path="userName" id="userName" class="form-control" />
								</td>
								<td class="lable-title" width="25%" align="left" valign="middle"><spring:message
										code="label.dm.uname" /></td>
								<td class="lable-title" width="20%" align="left" valign="middle"
									scope="col"><form:input path="userId" id="userId"
										class="form-control" readonly="true" /></td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.dm.email" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="emailId" id="emailId" class="form-control" /></td>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.dm.phNo" /></td>
								<td class="lable-title" align="left" valign="middle" scope="col">
									<form:input path="phoneNo" id="phoneNo" class="form-control" />
								</td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.dm.deptName" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="deptName" id="deptName" class="form-control" /></td>

								<td class="lable-title" align="left" valign="middle">Application
									Name<span>*</span>
								</td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="appName" id="appName" class="form-control" /></td>

							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.env" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="envType" id="envType" class="down-control">
										<form:option value="">--Select--</form:option>
										<form:option value="App1_Env_1">App1_Env_1</form:option>
										<form:option value="App1_Env_2">App1_Env_2</form:option>
										<form:option value="App2_Env_1">App2_Env_1</form:option>
										<form:option value="App2_Env_2">App2_Env_2</form:option>
										<form:option value="App3_Env_1">App3_Env_1</form:option>
										<form:option value="App3_Env_2">App3_Env_2</form:option>
										<form:option value="App4_Env_1">App4_Env_1</form:option>
										<form:option value="App4_Env_2">App4_Env_2</form:option>
									</form:select></td>

								<td class="lable-title" align="left" valign="middle">Application
									Phase</td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="appPhase" id="appPhase" class="down-control">
										<form:option value="">--Select--</form:option>
										<form:option value="App1_Phase_1">App1_Phase_1</form:option>
										<form:option value="App1_Phase_2">App1_Phase_2</form:option>
										<form:option value="App2_Phase_1">App2_Phase_1</form:option>
										<form:option value="App2_Phase_2">App2_Phase_2</form:option>
										<form:option value="App3_Phase_1">App3_Phase_1</form:option>
										<form:option value="App3_Phase_2">App3_Phase_2</form:option>
										<form:option value="App4_Phase_1">App4_Phase_1</form:option>
										<form:option value="App4_Phase_2">App4_Phase_2</form:option>
									</form:select></td>

							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle">Application
									Description<span>*</span>
								</td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="appDesc" id="appDesc" class="form-control" /></td>
							</tr>

						</tbody>
					</table>

				</div>

				<br />
				<br />
				<div class="filter-rght">
					<table
						style="width: 40%; border: 0; font-size: 13px; color: #0C5473;">
						<tr>
							<td class="lable-title" style="font-size: 14px;">No. of
								Applications</td>
							<td style="font-size: 14px;"><form:select path="noOfTabs"
									id="mydropdownid" class="down-control-small">
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
								</form:select></td>
						</tr>
					</table>
					<br /> <br />
				</div>
				<div>
					<table
						style="width: 100%; border: 0; font-size: 13px; color: #0C5473;">
						<tbody>
							<tr>
								<td class="lable-title" style="font-size: 14px;">Application
									Name<span>*</span>
								</td>
								<td class="lable-title" style="font-size: 14px;">DataBase<span>*</span></td>
								<td class="lable-title" style="font-size: 14px;">No of
									Tables<span>*</span>
								</td>
							</tr>
							<tr>
								<td><form:input
										path="tdgDataMaskingNoOfAppsDTOs[0].appName" id="appName"
										maxlength="120" size="17%" style=""
										class="form-control listValidator" /></td>
								<td><form:input path="tdgDataMaskingNoOfAppsDTOs[0].dbName"
										id="dbName" maxlength="120" class="form-control listValidator" /></td>
								<td><form:input
										path="tdgDataMaskingNoOfAppsDTOs[0].noOfTables"
										id="noOfTables" maxlength="120"
										class="form-control listValidator" /></td>
							</tr>
						</tbody>
					</table>
					<div id="tblrow2">
						<table
							style="width: 100%; border: 0; font-size: 13px; color: #0C5473;">
							<tbody>
								<tr>
									<td><form:input
											path="tdgDataMaskingNoOfAppsDTOs[1].appName" id="appName"
											maxlength="120" size="17%" style=""
											class="form-control listValidator" /></td>
									<td><form:input
											path="tdgDataMaskingNoOfAppsDTOs[1].dbName" id="dbName"
											maxlength="120" class="form-control listValidator" /></td>
									<td><form:input
											path="tdgDataMaskingNoOfAppsDTOs[1].noOfTables"
											id="noOfTables" maxlength="120"
											class="form-control listValidator" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div id="tblrow3">
						<table
							style="width: 100%; border: 0; font-size: 13px; color: #0C5473;">
							<tbody>
								<tr>
									<td><form:input
											path="tdgDataMaskingNoOfAppsDTOs[2].appName" id="appName"
											maxlength="120" size="17%" style=""
											class="form-control listValidator" /></td>
									<td><form:input
											path="tdgDataMaskingNoOfAppsDTOs[2].dbName" id="dbName"
											maxlength="120" class="form-control listValidator" /></td>
									<td><form:input
											path="tdgDataMaskingNoOfAppsDTOs[2].noOfTables"
											id="noOfTables" maxlength="120"
											class="form-control listValidatorNumber" /></td>
								</tr>
							</tbody>
						</table>
					</div>

					<form:hidden path="tdgDataMaskingNoOfAppsDTOs[0].id" />
					<form:hidden path="tdgDataMaskingNoOfAppsDTOs[1].id" />
					<form:hidden path="tdgDataMaskingNoOfAppsDTOs[2].id" />

					<form:hidden path="vno" />

					<c:if test="${chngeReqYN eq true}">
						<br />
						<table
							style="width: 100%; border: 0; font-size: 13px; color: #0C5473; cellpadding: 4;">
							<tbody>
								<tr>
									<td class="lable-title" width="35%" align="left"
										valign="middle">Change Request Description<span>*</span>
									</td>
									<td class="flied-title" width="20%" align="left"
										valign="middle"><form:textarea path="chngReqCmmt"
											id="chngReqCmmt" charCount="1000" class="form-control"
											required="true" /></td>
									<td class="lable-title" width="25%" align="left"
										valign="middle"></td>
									<td class="lable-title" width="20%" align="left"
										valign="middle"></td>
								</tr>
							</tbody>
						</table>
					</c:if>

					<br />
					<table style="width: 100%; border: 0;">
						<tbody>
							<tr>
								<th scope="col"><input type="submit" name="submit"
									class="btn-primary btn-cell" value="Submit"></th>
							</tr>
						</tbody>
					</table>



				</div>
				<form:hidden path="onboardReqId" />
			</form:form>
		</div>
		<script src="include/footer.js"></script>
	</div>

	<script>

menu_highlight('tdm_life_cycle1');

 	
tdmOnboardingReqVali(); 	

$(document).ready(function() {
     $("#mydropdownid").change(function() {
    	    $("#tblrow2").hide();	
     	    $("#tblrow3").hide();	
	   	    var selectedValue = $(this).val();
	        if(selectedValue =='2'){
	        	$("#tblrow2").show();
	        	$("#tblrow3").hide();
	        } 
	        if(selectedValue =='3'){
	        	$("#tblrow2").show();	
	        	$("#tblrow3").show();	
	        }
	    });	
     
     if($("#mydropdownid").val() == '2'){
       	 $("#tblrow2").show();
     }
     
     if($("#mydropdownid").val() == '3'){
    	 $("#tblrow2").show();
     	 $("#tblrow3").show();	
     }
     
     if($("#mydropdownid").val() == '1'){
    	 $("#tblrow2").hide();
     	 $("#tblrow3").hide();
     }	  
     
     
 });


 
</script>

</body>
</html>
