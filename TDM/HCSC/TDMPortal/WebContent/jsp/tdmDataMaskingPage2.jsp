<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Central | Data Masking</title>
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
		<c:if test="${readOnly ne null}">
			<div
				style="float: right; width: 11%; border: 0; font-color: #163361; padding-top: 15px; padding-left: 74px;">
				<a class="DbButton"
					href="${pageContext.request.servletContext.contextPath}/tdmDtMaskDashboard"><spring:message
						code="label.back.db" /></a>
			</div>
		</c:if>
		<div class="container">
			<form:form id="dataMaskingForm2" name="dataMaskingForm2"
				action="${pageContext.request.contextPath}/tdmDataMaskingPage2"
				modelAttribute="tdgDataMaskingDTO">

				<ol class="breadcrumb">
					<li><a class="hrefVisited" href="./index">Home</a></li>
					<li>&#x2f;</li>
					<li><a class="hrefVisited" href="./index">TDM Life Cycle</a></li>
					<!-- <li>&#x2f;</li>
	    <li><a class="hrefVisited" href="./tdmDtMaskDashboard">Data Masking Dashboard</a></li> -->
					<li>&#x2f;</li>
					<li class="active">Data Masking</li>
					<c:if test="${oldReqId ne null}">
						<li>&#x2f;</li>
						<li style="font-size: 14px; color: #0098CC;">Request ID :
							${oldReqId}</li>
					</c:if>
				</ol>
				<div class="three-step-container">
					<div class="step1">
						<span class="step-number1">1</span><span class="step-heading">Requestor
							<small>Details</small>
						</span>
					</div>
					<div class="step2-active">
						<span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span>
					</div>
					<div class="step3">
						<span class="step-number3">3</span><span class="step-heading">Masking
							<small>Details</small>
						</span>
					</div>
				</div>
				<h2 style="color: #0098cc; font-size: 14px;">
					<spring:message code="label.dm.preReqs" />
				</h2>
				<hr>

				<div class="two-col">
					<table
						style="width: 100%; border: 0; font-size: 13px; color: #0C5473; cellpadding: 2;">
						<tbody>
							<tr>
								<td class="lable-title" width="80%" align="left" valign="middle"><spring:message
										code="label.pre.q1" /> <span>*</span></td>
								<td class="flied-title" width="20%" align="left" valign="middle">
									<form:textarea path="page2Q1" id="page2Q1" class="form-control" />
								</td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q2" /><br /> &nbsp;&nbsp;<spring:message
										code="label.pre.q2a" /><br /> &nbsp;&nbsp;<spring:message
										code="label.pre.q2b" /><br /> &nbsp;&nbsp;<spring:message
										code="label.pre.q2c" /><br /> &nbsp;&nbsp;<spring:message
										code="label.pre.q2d" /><br /></td>
								<td class="lable-title" align="left" valign="middle" scope="col">
									<form:textarea path="page2Q2" id="page2Q2" class="form-control" />
								</td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q3" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page2Q3" id="page2Q3" class="form-control" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q4" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page2Q4" id="page2Q4" class="form-control" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q5" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page2Q5" id="page2Q5" class="form-control" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q6" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page2Q6" id="page2Q6" class="form-control" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q7" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page2Q7" id="page2Q7" class="form-control" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q8" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><label
									class="radio-inline"> <form:radiobutton path="page2Q8"
											id="page2Q8" value="Y" /> <spring:message code="label.yes" /></label>
									<label class="radio-inline"> <form:radiobutton
											path="page2Q8" id="page2Q8" value="N" /> <spring:message
											code="label.no" />
								</label></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q9" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><label
									class="radio-inline"> <form:radiobutton path="page2Q9"
											id="page2Q9" value="Y" /> <spring:message code="label.yes" /></label>
									<label class="radio-inline"> <form:radiobutton
											path="page2Q9" id="page2Q9" value="N" /> <spring:message
											code="label.no" />
								</label></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q10" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page2Q10" id="page2Q10" class="form-control" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q11" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page2Q11" id="page2Q11" class="form-control" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.pre.q12" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><label
									class="radio-inline"> <form:radiobutton path="page2Q12"
											id="page2Q12" value="Y" /> <spring:message code="label.yes" /></label>
									<label class="radio-inline"> <form:radiobutton
											path="page2Q12" id="page2Q12" value="N" /> <spring:message
											code="label.no" />
								</label></td>
							</tr>

						</tbody>
					</table>

					<c:choose>
						<c:when test="${readOnly eq null}">
							<table
								style="width: 100%; border: 0; font-size: 13px; color: #0C5473; align: center;">
								<tbody>
									<tr>
										<th scope="col"><input type="button" id="back"
											name="back" class="btn-primary btn-cell" value="Back">
											<input type="submit" name="submit"
											class="btn-primary btn-cell" value="Save and Continue">
										</th>
									</tr>
								</tbody>
							</table>
						</c:when>
						<c:when test="${changeReqYN eq true}">
							<table style="width: 100%; border: 0">
								<tbody>
									<tr>
										<th scope="col"><input type="button" id="SaveAndContinue"
											class="btn-primary btn-cell" value="Save and Continue">
										</th>
									</tr>
								</tbody>
							</table>
						</c:when>
						<c:otherwise>
							<table style="width: 100%; border: 0; align: center;">
								<tbody>
									<tr>
										<th scope="col"><input type="button" id="readBack"
											name="readBack" class="btn-primary btn-cell" value="Back">
											<input type="button" id="continue"
											class="btn-primary btn-cell" value="Continue"></th>
									</tr>
								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</div>
			</form:form>
		</div>
		<script src="include/footer.js"></script>
	</div>

	<script>
menu_highlight('tdm_life_cycle1');
tdgDataMaskingValidationPage2();

$(document).ready(function() {
	var readOnly = '${readOnly}';
	if(readOnly=='true'){
		$("input").prop('disabled', 'disabled');
		$("select").prop('disabled', 'disabled');
		$("textarea").prop('disabled', 'disabled');
		$("radiobutton").prop('disabled', 'disabled');
		$("#continue").removeAttr('disabled');
		$("#readBack").removeAttr('disabled');		
	}
	
    $("#continue").click(function(){
         document.location.href="./getDataMaskRequestDtlsForPage3";
      }); 
    
    $("#back").click(function(){
       	document.location.href="./tdmDataMaskingPage2?back=back";
  	  });
    
    $("#readBack").click(function(){
       	document.location.href="./tdmDataMaskingPage2?readBack=readBack";
  	  });
    
    $("#SaveAndContinue").click(function(){
       	document.location.href="./getDataMaskRequestDtlsForPage3?edit=true";    	    		
	 });  
  });
  
  
</script>

</body>
</html>
