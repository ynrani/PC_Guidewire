<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM CentralData | Masking Dashboard</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" >
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/custom.css">
  <link href="css/theme.default.css" rel="stylesheet">
  <script src="js/html5Shiv.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/main.js"></script>
  <script src="js/jquery.validate.min.js" type="text/javascript" ></script>  
  <script src="js/messages.js"></script>
  <script src="js/common.js"></script>
  <script src="js/jquery-migrate-1.2.1.min.js"></script>

<body>
	<div class="wrapper mainAll">
		<jsp:include page="indexHeader.jsp"></jsp:include>
		<div class="container">
		<form:form id="testDataReqForm" name="testDataReqForm" action="${pageContext.request.contextPath}/tdmTestDataRequest" modelAttribute="tdgTestDataRequestDTO">		
				<ol class="breadcrumb">
					<li><a class="hrefVisited" href="./index">Home</a></li>
					<li>&#x2f;</li>
					<li><a class="hrefVisited" href="./index">TDM Life Cycle</a></li>
					<li>&#x2f;</li>
					<li class="active">Test Data Request</li>
				</ol>
	    <h2 style="color: #0098cc"><spring:message code="label.tdm.tdr"/></h2>
	    <hr style="width: 100%">
	    <div class="nav" id="myid">	
		   <table id="testDataReqtable" class="hoverTable" style="width:100%;font-size: 12px;border:0; cellpadding:0; cellspacing:1;">
					<thead>
						<tr>
						  	<th align="center">Test Case No.(From QC)</th>
						    <th align="center">Requirement Description</th>						  	
							<th align="center">Functionality</th>	
							<th align="center">No of records</th>
							<th align="center">Request Type</th>						
							<th align="center">Priority</th>
							<th align="center">Estimated Time for completion</th>
							<th/>							
						</tr>
					</thead>
				 <tbody>
                    <tr onmouseover="this.style.cursor='pointer'">
                      <td align="left"><form:input path="testCaseNo" id="testCaseNo"/></td>
                      <td align="left"><form:input path="reqDesc" id="reqDesc"/></td>                          
                      <td align="left"><form:input path="functionality" id="functionality"/></td>
                      <td align="left"><form:input path="noOfRec" id="noOfRec"/></td>
                      <td align="left"><form:select path="reqType" id="reqType">
                          <form:option value="Select">Select</form:option>
	                      <form:option value="Data Mining">Data Mining</form:option>
	                      <form:option value="Data Update">Data Update</form:option>
	                      <form:option value="New Data generation">New Data generation</form:option>     
	                      </form:select>
	                  </td>
                      <td align="left"><form:select path="tdgTestDataRequestDTOList[0].priority" id="priority">
                          <form:option value="Select">Select</form:option>
	                      <form:option value="HIGH">HIGH</form:option>
	                      <form:option value="MEDIUM">MEDIUM</form:option>
	                      <form:option value="LOW">LOW</form:option>	                      
	                      </form:select>
	                  </td>
                      <td align="left"><form:input path="tdgTestDataRequestDTOList[0].etc" id="etc"/></td>
                      <td><input type="button" name="Add" id="add" value="Add"></td>                                                                                     
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
window.location.hash = "myid";

$(".table tr:odd").css('background-color', '#ffffff');
$(".table tr:even").addClass('even'); 

$(document).ready(function() {
$("#add").click(function(){
	var rowCount = $('#testDataReqtable >tbody >tr').length;
    $("#testDataReqtable tbody").append('<tr>'+'<td align="left"><input type="text" id="testCaseNo"/></td>'+
	'<td align="left"><input type="text" id="reqDesc"/></td>'+           
	'<td align="left"><input type="text" id="functionality"/></td>'+
	'<td align="left"><input type="text"id="noOfRec"/></td>'+
	'<td align="left"><select id="reqType"><option value="Select">Select</option><option value="Data Mining">Data Mining</option><option value="Data Update">Data Update</option><option value="New Data Generation">New Data Generation</option></select></td>'+
	'<td align="left"><select id="priority"><option value="Select">Select</option><option value="HIGH">HIGH</option><option value="MEDIUM">MEDIUM</option><option value="LOW">LOW</option></select></td>'+
	'<td align="left"><input type="text" id="etc"/></td>'+
	'<td><input type="button" name="Remove" id="remove" value="Remove"></td>'+
	'</tr>');  
 });
 
$("#testDataReqtable tbody").on('click', '#remove', function(){
    $(this).parent().parent().remove();
});

});

</script>
</body>
</html>