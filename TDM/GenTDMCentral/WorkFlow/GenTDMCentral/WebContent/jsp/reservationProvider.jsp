<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | My Reservation Record</title>
  <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/custom.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css" />
	<link rel="stylesheet" type="text/css" href="css/style1.css" />
	<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
	<link rel="stylesheet" type="text/css" href="css/menu.css" />
	<link rel="stylesheet" type="text/css" href="css/theme.default.css">
	<link rel="stylesheet" type="text/css" href="css/stylesNew.css">
	    
	<script type="text/javascript" src="js/html5.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
</head>

<body>
  <div id="main" class="wrapper mainAll">
  	<!-- <script src="include/header.js"></script> -->
    <jsp:include page="header.jsp"></jsp:include>
    <script src="include/revMenu.js"></script>
    
    <div id="tabs-1" class="container">
     <c:if test="${error ne null}">
	            <table class="my-error-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${error}</td>
	                
	                </tr>
	              </tbody>
	            </table>
	           </c:if>           
    <form:form id="reservationProviderDataForm" name="reservationProviderDataForm" action="${pageContext.request.contextPath}/myReservationExportProv" modelAttribute="tDMProvSearchDTO">
    <c:choose>
      <c:when test="${tDMProvSearchDTO.tDMProvSearchResultListDTOs ne null}">
      
      							<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%> 
        <div id="tabs-1" class="container scrollingX">
          <table id="prov_reservtable" class="table outputtable" style="width:100%; border:0; cellpadding:0; cellspacing:1;">
            <thead>
              <tr>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="lebel.chkbUnResrv" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.expOn" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcId" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcName" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.provId" /></th>
	               <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.prov.fname" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.lname" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.atypical" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.catg" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.ptype" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.speciality" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.licenseNo" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.tin" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.npi" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.medicareId" /></th>
	                <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.contract" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.eft" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.gender" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.termdt" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.addLine1" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.addLine2" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.city" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.state" /></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${tDMProvSearchDTO.tDMProvSearchResultListDTOs}" var="tDMProvSearchResultListDTOs" varStatus="status">
                <tr>
                   <c:if test="${tDMProvSearchResultListDTOs.unReservedYN eq null }">
					<td><label class="checkbox-inline">
					<form:checkbox path="tDMProvSearchResultListDTOs[${status.index}].unReservedYN"
									id="tDMProvSearchResultListDTOs[${status.index}].unReservedYN"
														class="cb_class checkBoxCls" value="Yes" />							 
				    </label></td>
                   </c:if>
                  <td align="center">${tDMProvSearchResultListDTOs.expairDate}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.testCaseId}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.testCaseName}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.providerId}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.firstName}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.lastName}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.atypical}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.provCatgType}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.provType}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.specialityDescription}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.licenseNo}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.tin}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.npi}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.medicareId}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.provContactType}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.provFET}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.provGender}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.terminationDate}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.provAddr1}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.provAddr2}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.provCity}</td>
                  <td align="center">${tDMProvSearchResultListDTOs.provState}</td>
              
                </tr>
              </c:forEach>
            </tbody>
          </table>
           <c:if test="${tDMProvSearchDTO.tDMProvSearchResultListDTOs ne null &&  not empty tDMProvSearchDTO.tDMProvSearchResultListDTOs}">
                 
					<c:forEach
						items="${tDMProvSearchDTO.tDMProvSearchResultListDTOs}"
						var="tDMProvSearchResultListDTOs" varStatus="status">
						<form:hidden
							path="tDMProvSearchResultListDTOs[${status.index}].recordId" />
					    <form:hidden
							path="tDMProvSearchResultListDTOs[${status.index}].providerId" />
						<form:hidden
							path="tDMProvSearchResultListDTOs[${status.index}].testCaseId" />
					    <form:hidden
							path="tDMProvSearchResultListDTOs[${status.index}].testCaseName" />
					
					</c:forEach>
					</c:if>
        </div>
        <!-- Pagination Starts -->
    								<ul class="grdPagination">
			                  			<%
			                  				int noOfPages = (Integer) request.getAttribute("noOfPages");
			                  				int startPage = (Integer) request.getAttribute("startPage");
			                  				int lastPage = (Integer) request.getAttribute("lastPage");
			                  		  
											if (currentPage != 1) {
			   							%>
			   									<li><a href="myReservationProv?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li><a href="myReservationProv?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="myReservationProv?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li class="disable"><a href="myReservationProv?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								 	}
			   								}
											if(noOfPages > 1) {
			    								for (int i=startPage; i<=lastPage; i++) {
			    									if(currentPage == i) {
			   			 				%>
			   											<li class="active"><a href="#"><%= i %></a><div><%= i %></div></li>
			   							<%
			    									} else {
			    						%>
			    										<li><a href="myReservationProv?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="myReservationProv?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="myReservationProv?page=<%= noOfPages %>">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="myReservationProv?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="myReservationProv?page=<%= noOfPages %>">Last</a><div>Last</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->
							
		    <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col" class="buttonsAll15">
                   	   <input type="button" name="back" id="back" value="Back">
                   	   <input type="submit" name="unreserve" id="unreserve" value="Un Reserve">
                       <input type="submit" name="export" id="export" value="ExportAll to Excel">
                   </th>
                </tr>
              </tbody>
            </table>	
      </c:when>
      <c:otherwise>
        <h3 style="float: left; width: 40%; border: 0; font-size: 14px;color: #E74949; padding-top: 15px">
				<div>No Test Data Reserved - In Providers</div>
			</h3>
        <br />
        <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col" class="buttonsAll8">
                   	   <input type="button" name="back" id="back" value="Back">
                   </th>
                </tr>
              </tbody>
            </table>
      </c:otherwise>
    </c:choose> 
    </form:form>
      
    </div>
    <script src="include/footer.js"></script>
  </div>
  <script src="include/copyrtfooter.js"></script>
 <script>
  	menu_highlight('Provider_Rev');
  	 menu_highlight('services');
  	  menu_highlight('services_ftd');
  	  menu_highlight('services_ftd_insu');
  	  menu_highlight('services_ftd_insu_health');
   
    $(".outputtable").tablesorter({
      widgets: ['zebra']
    });
    
    
    $(document).ready(function() {
        $("#back").click(function(){
           	document.location.href="./testdaUserBack";
      	  });
        
        $("#unreserve").click(function(){
	    	$('.mandetCls1').next(".my-error-class").remove(); 
	    	$('.mandetCls2').next(".my-error-class").remove(); 
	    	$('#prov_reservtable').next(".my-error-class").remove(); 
	    	var checkboxes = $('.checkBoxCls');
	      	  var selected = checkboxes.filter(":checked").length;
	    	    if (selected == false) {
	    		  $('#prov_reservtable').after('<div class="my-error-class">Please select atleast one record to unreserve.</div>');
	    		  return false;
	      	    }     	  
	         });	 
      });
    
     
  </script>
</body>

</html>