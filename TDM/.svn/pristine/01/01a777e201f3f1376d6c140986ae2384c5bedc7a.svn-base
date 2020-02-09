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
    <form:form id="reservationSubscDataForm" name="reservationSubscDataForm" action="${pageContext.request.contextPath}/myReservationExportSubc" modelAttribute="tDMSubscSearchDTO">
    <c:choose>
      <c:when test="${tDMSubscSearchDTO.tDMSubscSearchResultListDTOs ne null}">
      							<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%> 
        <div id="tabs-1" class="container scrollingX">
          <table id="subscr_reservtable" class="table outputtable" style="width:100%;  border:0; cellpadding:0; cellspacing:1;">
            <thead>
              <tr>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="lebel.chkbUnResrv" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.expOn" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcId" /></th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcName" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.subcId"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.ssn"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.fname"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.lname"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.gender"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.dob"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.status"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.grp"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.effDt"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.stype"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.addLine1"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.addLine2"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.city"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.state"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.zip"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.contractCode"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.lob"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.planid"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.plnname"/></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.subc.pcp"/></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${tDMSubscSearchDTO.tDMSubscSearchResultListDTOs}" var="tDMSubscSearchResultListDTOs" varStatus="status">
                <tr>
                  <c:if test="${tDMSubscSearchResultListDTOs.unReservedYN eq null }">
					<td><label class="checkbox-inline">
					<form:checkbox path="tDMSubscSearchResultListDTOs[${status.index}].unReservedYN"
									id="tDMSubscSearchResultListDTOs[${status.index}].unReservedYN"
														class="cb_class checkBoxCls" value="Yes" />							 
				    </label></td>
                   </c:if>
                  <td align="center">${tDMSubscSearchResultListDTOs.expairDate}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.testCaseId}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.testCaseName}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subscriberId}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.ssn}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.firstName}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.lastName}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.gender}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.birthDate}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subcStatus}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subscriberNames}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.dateChanged}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subcType}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subcAddr1}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subcAddr2}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subcCity}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subcState}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subcZip}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.subcContCode}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.lob}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.planId}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.planName}</td>
                  <td align="center">${tDMSubscSearchResultListDTOs.pcp}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          <c:if test="${tDMSubscSearchDTO.tDMSubscSearchResultListDTOs ne null &&  not empty tDMSubscSearchDTO.tDMSubscSearchResultListDTOs}">
             <c:forEach	items="${tDMSubscSearchDTO.tDMSubscSearchResultListDTOs}" var="tDMSubscSearchResultListDTOs" varStatus="status">
				<form:hidden
							path="tDMSubscSearchResultListDTOs[${status.index}].recordId" />
				 <form:hidden
							path="tDMSubscSearchResultListDTOs[${status.index}].subscriberId" />
				 <form:hidden
							path="tDMSubscSearchResultListDTOs[${status.index}].testCaseId" />
				 <form:hidden
							path="tDMSubscSearchResultListDTOs[${status.index}].testCaseName" />					
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
			   									<li><a href="myReservationSubc?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li><a href="myReservationSubc?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="myReservationSubc?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li class="disable"><a href="myReservationSubc?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
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
			    										<li><a href="myReservationSubc?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="myReservationSubc?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="myReservationSubc?page=<%= noOfPages %>">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="myReservationSubc?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="myReservationSubc?page=<%= noOfPages %>">Last</a><div>Last</div></li>
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
					<div>No Test Data Reserved - In Subscribers</div>
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
  	menu_highlight('Subscriber_Rev');
  	 menu_highlight('services');
  	  menu_highlight('services_ftd');
  	  menu_highlight('services_ftd_insu');
  	  menu_highlight('services_ftd_insu_health');
  	menu_highlight('services_ftd_insu_health_rev');
  	
  	 
  	$(".outputtable").tablesorter({
        widgets: ['zebra']
      });
  	
    $(document).ready(function() {
        $("#back").click(function(){
           	document.location.href="./testdaSubscUserBack";
      	  });
        
        $("#unreserve").click(function(){
	    	$('.mandetCls1').next(".my-error-class").remove(); 
	    	$('.mandetCls2').next(".my-error-class").remove(); 
	    	$('#subscr_reservtable').next(".my-error-class").remove(); 
	    	var checkboxes = $('.checkBoxCls');
	      	  var selected = checkboxes.filter(":checked").length;
	    	    if (selected == false) {
	    		  $('#subscr_reservtable').after('<div class="my-error-class">Please select atleast one record to unreserve.</div>');
	    		  return false;
	      	    }     	  
	         });
      });
  </script>

</body>
</html>