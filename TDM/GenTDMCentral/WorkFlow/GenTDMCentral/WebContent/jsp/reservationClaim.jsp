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
    <form:form id="reservationClaimDataForm" name="reservationClaimDataForm" action="${pageContext.request.contextPath}/myReservationExportClaim" modelAttribute="tDMClaimSearchDTO">
     <c:choose>
      <c:when test="${tDMClaimSearchDTO.tDMClaimSearchResultListDTOs ne null}">
      
            				   <%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%> 
        <div id="tabs-1" class="container scrollingX">
          <table id="claim_reservtable" class="table outputtable" style="width:100%; border:0; cellpadding:0; cellspacing:1;">
            <thead>
              <tr>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="lebel.chkbUnResrv" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.expOn" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcId" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcName" /></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.claimId"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.type"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.patientFirstName"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.patientLastName"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.patientId"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.status"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.dx.code"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.proc.code"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.modifier"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.revenueCode"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.source"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.pos"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.typOfService"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.claimProviderTIN"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.provider.NPI"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.rcptdt"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.patientGender"/></th>
                   <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.groupnum"/></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${tDMClaimSearchDTO.tDMClaimSearchResultListDTOs}" var="tDMClaimSearchResultListDTOs" varStatus="status">
                <tr>
                  <c:if test="${tDMClaimSearchResultListDTOs.unReservedYN eq null }">
					<td><label class="checkbox-inline">
					<form:checkbox path="tDMClaimSearchResultListDTOs[${status.index}].unReservedYN"
									id="tDMClaimSearchResultListDTOs[${status.index}].unReservedYN"
														class="cb_class checkBoxCls" value="Yes" />							 
				    </label></td>
                   </c:if>
                  <td align="center">${tDMClaimSearchResultListDTOs.expireDate}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.testCaseId}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.testCaseName}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimId}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimType}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.patientFirstName}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.patientLastName}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.patientId}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimStatus}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimDXCode}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimProcCode}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimModifier}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimRevCode}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimSource}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimPOS}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimServiceType}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimProviderTIN}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimProviderNPI}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimReceiptDate}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimPatientGender}</td>
                  <td align="center">${tDMClaimSearchResultListDTOs.claimGrpNum}</td>
               </tr>
              </c:forEach>
            </tbody>
          </table>
           <c:if test="${tDMClaimSearchDTO.tDMClaimSearchResultListDTOs ne null &&  not empty tDMClaimSearchDTO.tDMClaimSearchResultListDTOs}">
             <c:forEach	items="${tDMClaimSearchDTO.tDMClaimSearchResultListDTOs}" var="tDMClaimSearchResultListDTOs" varStatus="status">
				<form:hidden
							path="tDMClaimSearchResultListDTOs[${status.index}].recordId" />
				 <form:hidden
							path="tDMClaimSearchResultListDTOs[${status.index}].claimId" />
				 <form:hidden
							path="tDMClaimSearchResultListDTOs[${status.index}].testCaseId" />
				 <form:hidden
							path="tDMClaimSearchResultListDTOs[${status.index}].testCaseName" />					
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
			   									<li><a href="myReservationClaim?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li><a href="myReservationClaim?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="myReservationClaim?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li class="disable"><a href="myReservationClaim?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
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
			    										<li><a href="myReservationClaim?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="myReservationClaim?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="myReservationClaim?page=<%= noOfPages %>">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="myReservationClaim?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="myReservationClaim?page=<%= noOfPages %>">Last</a><div>Last</div></li>
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
					<div>No Test Data Reserved - In Claims</div>
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
  	menu_highlight('Claim_Rev');
  	 menu_highlight('services');
  	  menu_highlight('services_ftd');
  	  menu_highlight('services_ftd_insu');
  	  menu_highlight('services_ftd_insu_health');
  	
  	$(".outputtable").tablesorter({
        widgets: ['zebra']
      });
  	
    $(document).ready(function() {
        $("#back").click(function(){
           	document.location.href="./testdaClaimUserBack";
      	  });
        
        $("#unreserve").click(function(){
	    	$('.mandetCls1').next(".my-error-class").remove(); 
	    	$('.mandetCls2').next(".my-error-class").remove(); 
	    	$('#claim_reservtable').next(".my-error-class").remove(); 
	    	var checkboxes = $('.checkBoxCls');
	      	  var selected = checkboxes.filter(":checked").length;
	    	    if (selected == false) {
	    		  $('#claim_reservtable').after('<div class="my-error-class">Please select atleast one record to unreserve.</div>');
	    		  return false;
	      	    }     	  
	         });
      });
 	
  </script>

</body>
</html>