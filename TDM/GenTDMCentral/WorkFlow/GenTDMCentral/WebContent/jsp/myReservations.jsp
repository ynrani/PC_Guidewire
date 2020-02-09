<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | My Reservation Records</title>
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
    <jsp:include page="headerBank.jsp"></jsp:include>
    
    <script src="include/revMenuBank.js"></script>   
    <div class="container">           
    <form:form id="reservationDtlsdashBoard" name="reservationDtlsdashBoard" action="./unReserveRecords"  modelAttribute="tdmAccountDTO">
           <c:if test="${error ne null}">
	            <table class="my-error-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${error}</td>	                
	                </tr>
	              </tbody>
	            </table>
	     </c:if>    
    <c:choose>
      <c:when test="${tdmAccountDTO.resrvationDTOsList ne null}">      
      							<%-- <%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%>  --%>
        <div class="container scrollingX">
          <table id="search_output_table" class="table tablesorter " style="width:100%;  font-size: 13px;">            
	             <thead>
								<tr>
								    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.unreserve" /></th>
									<th bgcolor="#E3EFFB" height="25" class="whitefont">Account Number
										</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Customer ID
										</th>
								    <th bgcolor="#E3EFFB" scope="col" class="whitefont">First Name
										</th>
								    <th bgcolor="#E3EFFB" scope="col" class="whitefont">Last Name
										</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Branch</th>
									
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Account Status
										</th>
								    <th bgcolor="#E3EFFB" scope="col" class="whitefont">Account Balance
										</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Testcase ID
										</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Testcase Name
										</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">City
										</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Country
										</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Zip code</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Reserve Date
										</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Creditcard Number</th>
								</tr>
							</thead>
            <tbody>
              <c:forEach items="${tdmAccountDTO.resrvationDTOsList}" var="resrvationDTOsList" varStatus="status">
                <tr>
                   <c:if test="${tdmNonStandReservationDtos.unreserveYN eq null }">
									<td><label class="checkbox-inline">
									<form:checkbox path="resrvationDTOsList[${status.index}].unreserveYN"
									id="resrvationDTOsList[${status.index}].unreserveYN"
														class="cb_class checkBoxCls" value="Yes" />							 
									</label></td>
                                    </c:if>
                  <td align="center">${resrvationDTOsList.accNum}</td>
                  <td align="center">${resrvationDTOsList.custNum}</td>
                  <td align="center">${resrvationDTOsList.custName}</td>
                  <td align="center">${resrvationDTOsList.custSurName}</td>
                  <td align="center">${resrvationDTOsList.branchCode}</td>
                  <td align="center">${resrvationDTOsList.accStatus}</td>      
                  <td align="center">${resrvationDTOsList.accBal}</td>
                  <td align="center">${resrvationDTOsList.testCaseId}</td>
                  <td align="center">${resrvationDTOsList.testCaseName}</td>
                  <td align="center">${resrvationDTOsList.city}</td>
                  <td align="center">${resrvationDTOsList.country}</td>
                  <td align="center">${resrvationDTOsList.zipCode}</td>
                  <td align="center">${resrvationDTOsList.reserveDate}</td>
                  <td align="center">${resrvationDTOsList.creditCardNum}</td> 
                </tr>
              </c:forEach>
              
              
            </tbody>
          
          </table>
            
            <c:if test="${tdmAccountDTO.resrvationDTOsList ne null &&  not empty tdmAccountDTO.resrvationDTOsList}">
                 
					<c:forEach
						items="${tdmAccountDTO.resrvationDTOsList}"
						var="resrvationDTOsList" varStatus="status">
						<form:hidden
							path="resrvationDTOsList[${status.index}].accNum" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].custNum" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].custName" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].custSurName" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].branchCode" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].accStatus" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].accBal" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].testCaseId" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].testCaseName" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].city" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].country" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].zipCode" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].reserveDate" />
						<form:hidden
							path="resrvationDTOsList[${status.index}].creditCardNum" />
					</c:forEach>
					</c:if>
        </div>
        <!-- Pagination Starts -->
    								<%-- <ul class="grdPagination">
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
									</ul> --%>
						 
							<!-- Pagination Ends -->
							
		    <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col" class="buttonsAll15">
                  <input type="button" name="back" id="back" value="Back">
                   <input type="submit" name="unreserve"
									 id="unreserve" value="Un Reserve">
                       <input type="submit" name="export" id="export" value="ExportAll to Excel">
                   </th>
                </tr>
              </tbody>
            </table>	
      </c:when>
      <c:otherwise>
        <h3 style="float: left; width: 40%; border: 0; font-size: 14px;color: #E74949; padding-top: 15px">
				No Test Data Reserved 
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
 menu_highlight('Bank_Rev');
 menu_highlight('services');
 menu_highlight('services_ftd');
 menu_highlight('services_ftd_bank');
 
 $(document).ready(function() {
     $("#back").click(function(){
        	document.location.href="./testdaAccount";
   	  });
   });
 
 
 $(document).ready(function() {
	    $("#unreserve").click(function(){
	    	$('.mandetCls1').next(".my-error-class").remove(); 
	    	$('.mandetCls2').next(".my-error-class").remove(); 
	    	$('#search_output_table').next(".my-error-class").remove(); 
	    	var checkboxes = $('.checkBoxCls');
	      	  var selected = checkboxes.filter(":checked").length;
	    	    if (selected == false) {
	    		  $('#search_output_table').after('<div class="my-error-class">There is no selection of the records from Search Result</div>');
	    		  return false;
	      	    }     	  
	         });   
	  });
  </script>
</body>

</html>