<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
 
    <jsp:include page="headerPC.jsp"></jsp:include>
  	 
    <script src="include/revMenuPC.js"></script>
    <div id="tabs-1" class="container">
        
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
	
    <form:form id="reservationAutoDataForm" name="reservationAutoDataForm" action="${pageContext.request.contextPath}/myReservationProp">
    <c:choose>
      <c:when test="${tdmPolicyPropertySearchResultDTOList ne null}">
      
      							<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%> 
        <div id="tabs-1" class="container scrollingX">
          <table class="table outputtable tablesorter" style="width:100%; ">
            <thead>
              <tr>
	                <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.action" /></th>
	                <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.policy.num" /></th>
	                <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.expOn" /></th>
	                <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.prodType" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.stage" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.state" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.term" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.effDt" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.expDt" /></th>
             
              
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.avlPays" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.docTypeAdd" /></th>              
	                <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcId" /></th>
	                <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcName" /></th>
	                <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.scenario" /></th>

        
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${tdmPolicyPropertySearchResultDTOList}" var="tdmPolicyPropertySearchResultDTOList" varStatus="status">
                <tr>
                  <td><a class="hrefVisited" href="${pageContext.request.servletContext.contextPath}/unreserveProp?id=${tdmPolicyPropertySearchResultDTOList.policynumber}"><spring:message code="label.unreserve"/></a>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.policynumber}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.expairDate}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.productType}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.policyStage}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.policyState}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.policyTerm}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.policyEffectDt}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.policyExpDt}</td>
           
       
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.assoPayReq}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.assoDocType}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.testCaseId}</td>
                  <td align="center">${tdmPolicyPropertySearchResultDTOList.testCaseName}</td>               	 
                  <td align="left">${tdmPolicyPropertySearchResultDTOList.scenario}</td>
<%--             <td align="center"><a class="hrefVisited" href="javascript:;" onclick="popupuser('./reservationPolicyPropertyPopUp?id=${tdmPolicyPropertySearchResultDTOList.policynumber}','Reserved Data','popup','popupOverlay','750');">${tdmPolicyPropertySearchResultDTOList.policynumber}</a></td> --%>
          
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
			   									<li><a href="myReservationProp?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li><a href="myReservationProp?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="myReservationProp?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li class="disable"><a href="myReservationProp?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
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
			    										<li><a href="myReservationProp?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="myReservationProp?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="myReservationProp?page=<%= noOfPages %>">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="myReservationProp?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="myReservationProp?page=<%= noOfPages %>">Last</a><div>Last</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->
							
		    <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col"  class="buttonsAll15">
                 	 <input type="button" name="back" id="back" value="Back">
                       <input type="submit" name="export" id="export" value="Export All to Excel">
                   </th>
                </tr>
              </tbody>
            </table>	
      </c:when>
      <c:otherwise>
        <h3 style="float: left; width: 40%; border: 0; font-size: 14px;color: #E74949; padding-top: 15px">
				<u>No Test Data Reserved - In Policy Property</u>
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
  	menu_highlight('Poly_Prop_Rev');
  	
  	$(".outputtable").tablesorter({
  	    widgets: ['zebra']
  	  });
  	
  	 $(document).ready(function() {
         $("#back").click(function(){
            	document.location.href="./policyPropBack";
       	  });
       });
     
   
  </script>
</body>

</html>