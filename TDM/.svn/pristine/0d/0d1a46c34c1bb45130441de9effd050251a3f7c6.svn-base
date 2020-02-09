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
    <jsp:include page="headerPC.jsp"></jsp:include>
    <script src="include/revMenuPC.js"></script>
    
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
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.claimNo" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.policyNo" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.comp" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.prodName" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.poilcySts" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.faceAmt" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.insuFname" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.insuLname" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.ssn" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.dob" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont">Riders</th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont">Benefits</th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont">Owner</th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont">Beneficiary</th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont">Payment Mode</th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont">Payment Method</th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont">Cash Accumulated</th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont">Loan Amount</th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont">Loan Repay Amount</th>
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
                  <td align="center">${tdmClaimSearchResultDTOs.companyName}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.productName}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.policySts}</td>
                  <td align="right">${tdmClaimSearchResultDTOs.faceAmt}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.fristName}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.lastName}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.ssn}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.dob}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.riders}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.benefits}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.owner}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.beneficiary}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.paymentMethod}</td>
                  <td align="center">${tdmClaimSearchResultDTOs.paymentMode}</td>
                  <td align="right">${tdmClaimSearchResultDTOs.cashAccum}</td>
                  <td align="right">${tdmClaimSearchResultDTOs.loanAmt}</td>
                  <td align="right">${tdmClaimSearchResultDTOs.loanRepayAmt}</td>
              
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
			   									<li><a href="myReservationClaimSearch?page=<%= 1 %>" onClick="showLoading();">First</a><div>First</div></li>
			   									<li><a href="myReservationClaimSearch?page=<%= currentPage-1 %>" onClick="showLoading();">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="myReservationClaimSearch?page=<%= 1 %>" onClick="showLoading();">First</a><div>First</div></li>
			   									<li class="disable"><a href="myReservationClaimSearch?page=<%= currentPage-1 %>" onClick="showLoading();">&lt; Prev</a><div>&lt; Prev</div>
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
			    										<li><a href="myReservationClaimSearch?page=<%= i %>" id="employeeLink" onClick="showLoading();"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="myReservationClaimSearch?page=<%= currentPage+1 %>" onClick="showLoading();">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="myReservationClaimSearch?page=<%= noOfPages %>" onClick="showLoading();">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="myReservationClaimSearch?page=<%= currentPage+1 %>" onClick="showLoading();">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="myReservationClaimSearch?page=<%= noOfPages %>" onClick="showLoading();">Last</a><div>Last</div></li>
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
                       <input type="submit" name="export" id="export" value="ExportAll to Excel">
                   </th>
                </tr>
              </tbody>
            </table>	
      </c:when>
      <c:otherwise>
        <h3 style="float: left; width: 40%; border: 0; font-size: 14px;color: #E74949; padding-top: 15px">
				<div>No Test Data Reserved - In Life - Calims</div>
			</h3>
        <br />
        <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col"  class="buttonsAll8">
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
 $("body").removeClass("loading");
  	menu_highlight('ClaimSearch_Rev');
  	 function showLoading(){
  		$("body").addClass("loading"); 
  	  } 
   
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