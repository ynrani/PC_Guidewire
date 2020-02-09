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
				style="float: right; width: 14%; border: 0; font-color: #163361; padding-top: 15px; padding-left: 74px;">
				<a class="DbButton"
					href="${pageContext.request.servletContext.contextPath}/tdmDtMaskDashboard"><spring:message
						code="label.back.db" /></a>
			</div>
		</c:if>
		<div class="container">
			<form:form id="dataMaskingForm3" name="dataMaskingForm3"
				action="${pageContext.request.contextPath}/tdmDataMaskingPage3"
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
					<div class="step2">
						<span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span>
					</div>
					<div class="step3-active">
						<span class="step-number3">3</span><span class="step-heading">Masking
							<small>Details</small>
						</span>
					</div>
				</div>

				<h2 style="color: #0098cc; font-size: 14px;">
					<spring:message code="label.dm.dtl" />
				</h2>
				<hr>
				<c:if test="${result ne null}">
					<table
						style="width: 100%; border: 0; font-size: 14px; font-style: italic; color: #A56C33; cellpadding: 4;">
						<tbody>
							<tr>
								<td class="lable-title" align="left" valign="middle">
									${result}</td>
								<td style="color: red"><a
									href="${pageContext.request.servletContext.contextPath}/tdmDtMaskDashboard">Click
										Here For Back To Dashboard</a></td>
							</tr>
						</tbody>
					</table>
				</c:if>

				<div class="two-col">
					<table
						style="width: 100%; border: 0; font-size: 13px; color: #0C5473; cellpadding: 2;">
						<tbody>
							<%-- <tr>
        	<td class="lable-title" width="80%" align="left" valign="middle"><spring:message code="label.msk.q1" /> <span>*</span> </td>
            <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:textarea path="page3Q1" id="page3Q1" class="form-control" />
            </td>
          </tr> 
          <tr>  
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q2" /><br/></td>
            <td class="lable-title" align="left" valign="middle" scope="col">
           		 <form:textarea path="page3Q2" id="page3Q2" class="form-control" />
           </td>
          </tr>          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q3" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page3Q3" id="page3Q3" class="form-control" />
            </td>
          </tr>   --%>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.msk.q4" /> <span>*</span> <br /> &nbsp;&nbsp;<spring:message
										code="label.msk.q4a" /><br /> &nbsp;&nbsp;<spring:message
										code="label.msk.q4b" /><br /> &nbsp;&nbsp;<spring:message
										code="label.msk.q4c" /><br /> &nbsp;&nbsp;<spring:message
										code="label.msk.q4d" /><br /> &nbsp;&nbsp;<spring:message
										code="label.msk.q4e" /><br /> &nbsp;&nbsp;<spring:message
										code="label.msk.q4f" /><br /></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page3Q4" id="page3Q4" class="form-control" /></td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.msk.q5" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page3Q5" id="page3Q5" class="form-control" /></td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.msk.q6" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page3Q6" id="page3Q6" class="form-control" /></td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.msk.q7" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page3Q7" id="page3Q7" class="form-control" /></td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.msk.q8" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page3Q8" id="page3Q8" class="form-control" /></td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.msk.q9" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page3Q9" id="page3Q9" class="form-control" /></td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.msk.q10" /> <span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:textarea
										path="page3Q10" id="page3Q10" class="form-control" /></td>
							</tr>
						</tbody>
					</table>
					<br /> <br />
					<div class="filter-rght">
						<table
							style="width: 40%; border: 0; font-size: 13px; color: #0C5473;">
							<tr>
								<td style="font-size: 14px;">No. of Applications</td>
								<td style="font-size: 14px;"><form:select
										path="page3NoOfApps" id="mydropdownid">
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
									<td style="font-size: 14px;">Application Name<span>*</span></td>
									<td style="font-size: 14px;">DataBase<span>*</span></td>
									<td style="font-size: 14px;">No of Tables<span>*</span></td>
								</tr>
								<tr>
									<td><form:input
											path="tdgDataMaskingNoOfAppsDTOs[0].appName" id="appName"
											maxlength="120" size="17%" style=""
											class="form-control listValidator" /></td>
									<td><form:input
											path="tdgDataMaskingNoOfAppsDTOs[0].dbName" id="dbName"
											maxlength="120" class="form-control listValidator" /></td>
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
												id="noOfTables" maxlength="12"
												class="form-control listValidatorNumber" /></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<form:hidden path="vno" />
					<form:hidden path="id" />

					<br />
					<c:choose>
						<c:when test="${(readOnly eq null) && (disabled eq null)}">
							<table
								style="width: 100%; border: 0; font-size: 13px; color: #0C5473; align: center;">
								<tbody>
									<tr>
										<th scope="col"><input type="button" id="back"
											name="back" class="btn-primary btn-cell" value="Back">
											<input type="submit" id="submit" name="submit"
											class="btn-primary btn-cell" value="Submit"> <input
											type="button" id="cancel" name="cancel"
											class="btn-primary btn-cell" value="Cancel"></th>
									</tr>
								</tbody>
							</table>
						</c:when>
						<c:when test="${changeReqYN eq true}">
							<table
								style="width: 100%; border: 0; font-size: 13px; color: #0C5473;; cellpadding: 4;">
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
							<table
								style="width: 100%; border: 0; font-size: 13px; color: #0C5473; align: center;">
								<tbody>
									<tr>
										<th scope="col"><input type="submit" id="submit"
											name="submit" class="btn-primary btn-cell" value="Submit">
											<input type="button" id="cancel" name="cancel"
											class="btn-primary btn-cell" value="Cancel"></th>
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
											<input type="button" name="export" id="export"
											class="btn-primary btn-cell" value="Export to Excel">
										</th>
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
tdgDataMaskingValidationPage3();

/* function addMoreRows(frm) {		
    $('#rowCount'+0).remove();
    $('#rowCount'+1).remove();
	$('#rowCount'+2).remove();
	var rowCount=$('#mydropdownid').val();
	for(var i=0 ; i < (rowCount-1);i++)
	{
		var recRow ='<div id="rowCount'+i+'"><table style="width:100%;border:0; font-size: 13px; color: #0C5473;"><tr id="rowId"><td><input type="text" id="appName" size="17%" maxlength="120" class="listValidator form-control"/></td><td><input type="text" id="dbName" size="17%" maxlength="120" class="listValidator form-control"/></td><td><input type="text" id="noOfTables" size="17%" maxlength="120" class="listValidator form-control"/></td><td><a href="javascript:void(0);" onclick="removeRow('+i+');">Delete</a></td></tr></table></div>';
		jQuery('#addedRows').append(recRow);
	} 	
} */

/*  function removeRow(removeNum) {
	$('#rowCount'+removeNum).remove();
} */

$(document).ready(function() {

	var readOnly = '${readOnly}';
	var disabled='${disabled}';
	if(readOnly =='true' || disabled =='true'){
		$("input").prop('disabled', 'disabled');
		$("select").prop('disabled', 'disabled');
		$("textarea").prop('disabled', 'disabled');
		$("radiobutton").prop('disabled', 'disabled');
		$("#export").removeAttr('disabled');
		$("#readBack").removeAttr('disabled');
	}
	
	$("#back").click(function(){
       	document.location.href="./tdmDataMaskingPage3?back=back";
  	  });
	
	$("#readBack").click(function(){
       	document.location.href="./tdmDataMaskingPage3?readBack=readBack";
  	  });
	
	$("#cancel").click(function(){
		 if (confirm('Are you sure to cancel?')) {
		       	document.location.href="./tdmDtMaskDashboard";
		    }
		 return false;  
  	  });
	
 	  
     $("#export").click(function(){
    	 document.location.href="./tdmDataMaskingPage3?export=true";
   	 });     

     $("#mydropdownid").change(function() {
    	    $("#tblrow2").hide();	
     	    $("#tblrow3").hide();	
	   	    var selectedValue = $(this).val();
	        if(selectedValue =='2'){
	        	$("#tblrow2").show();	
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
     
    /*  $("#page3NoOfApps").keyup(function() { 
   	  $("#dtMaskNoOfApps tbody tr").remove();
   	     var txtVal = $("#page3NoOfApps").val();
   	     $("#dtMaskNoOfApps").show();
   	     for(i=0;i < txtVal; i++){
   	    	 $("#dtMaskNoOfApps tbody").append('<tr>'+'<td><input type="text" id="appName" name="tdgDataMaskingNoOfAppsDTOs['+i+'].appName" size="17%" maxlength="120" class="listValidator form-control"/></td><td><input type="text" id="dbName" name="tdgDataMaskingNoOfAppsDTOs['+i+'].dbName" size="17%" maxlength="120" class="listValidator form-control"/></td><td><input type="text" id="noOfTables" name="tdgDataMaskingNoOfAppsDTOs['+i+'].noOfTables" size="17%" maxlength="120" class="listValidator form-control"/></td>'+'</tr>')
   	 }    	 	
    });  */
    
     
     
 });
 
 
</script>
</body>
</html>
