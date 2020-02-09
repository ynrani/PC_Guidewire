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
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" >
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/custom.css">
  <link href="css/theme.default.css" rel="stylesheet">
  <link href="css/elements.css" rel="stylesheet">
  <script src="js/html5Shiv.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/main.js"></script>
  <script src="js/jquery.validate.min.js" type="text/javascript" ></script>  
  <script src="js/messages.js"></script>
  <script src="js/common.js"></script>
  <script src="js/jquery-migrate-1.2.1.min.js"></script>
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
    <form:form id="reservationClaimSearchDataForm" name="reservationClaimSearchDataForm" action="${pageContext.request.contextPath}/myReservationExportClaimSearch">
    <c:choose>
      <c:when test="${tdmClaimSearchResultDTOs ne null}">
      
      							<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%> 
        <div id="tabs-1" class="container scrollingX">
          <table class="table outputtable" style="width:100%; border:0; cellpadding:0; cellspacing:1;">
            <thead>
              <tr>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.action" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.expOn" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcId" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcName" /></th>
	               <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.claim.claimNo" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.policyNo" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.insuPer" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.ClaimSts" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.srcSys" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.lossDt" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.amtTotPaid" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.amtNetInc" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.lob" /></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${tdmClaimSearchResultDTOs}" var="tdmClaimSearchResultDTOs" varStatus="status">
                <tr>
                  <td><a href="${pageContext.request.servletContext.contextPath}/unreserveClaimSearch?id=${tdmClaimSearchResultDTOs.claimNo}"><spring:message code="label.unreserve"/></a>
                  <td align="center">${tdmClaimSearchResultDTOs.revExpairDate}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.testCaseId}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.testCaseName}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.claimNo}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.policyNo}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.primInsuPerson}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.claimStats}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.sourceSystem}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.lossDate}</td>
                  <td align="right">${tdmClaimSearchResultDTOs.amtTotPaid}</td>
                  <td align="right">${tdmClaimSearchResultDTOs.amtNetInc}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.lob}</td> 
              
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- Pagination Starts -->
    								<ul class="grdPagination">
			                  			<%
			                  				int noOfPages = (Integer) request.getAttribute("noOfPages");
			                  				int startPage = (Integer) request.getAttribute("startPage");
			                  				int lastPage = (Integer) request.getAttribute("lastPage");
			                  		  
											if (currentPage != 1) {
			   							%>
			   									<li><a href="myReservationClaimSearch?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li><a href="myReservationClaimSearch?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="myReservationClaimSearch?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li class="disable"><a href="myReservationClaimSearch?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
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
			    										<li><a href="myReservationClaimSearch?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="myReservationClaimSearch?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="myReservationClaimSearch?page=<%= noOfPages %>">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="myReservationClaimSearch?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="myReservationClaimSearch?page=<%= noOfPages %>">Last</a><div>Last</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->
							
		    <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col">
                   	   <input type="button" name="back" id="back" class="btn-primary btn-cell" value="Back">
                       <input type="submit" name="export" id="export" class="btn-primary btn-cell" value="ExportAll to Excel">
                   </th>
                </tr>
              </tbody>
            </table>	
      </c:when>
      <c:otherwise>
        <h3 style="float: left; width: 40%; border: 0; font-size: 14px;color: #E74949; padding-top: 15px">
				<div>No Test Data Reserved - In Calims</div>
			</h3>
        <br />
        <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col">
                   	   <input type="button" name="back" id="back" class="btn-primary btn-cell" value="Back">
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
 <script>
  	menu_highlight('ClaimSearch_Rev');
  	
   
    $(".outputtable").tablesorter({
      widgets: ['zebra']
    });
    
    
    $(document).ready(function() {
        $("#back").click(function(){
           	document.location.href="./claimSearchBack";
      	  });
      });
    
     
  </script>
</body>

</html>