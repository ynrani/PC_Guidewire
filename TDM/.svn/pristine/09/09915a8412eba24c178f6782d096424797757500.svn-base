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
    <jsp:include page="indexHeader.jsp"></jsp:include>
    <div style="float: right; width: 14%; border: 0; font-color: #163361; padding-top: 15px; padding-left: 74px;">
	<a class="backButton"	href="${pageContext.request.servletContext.contextPath}/poloSearch"><spring:message
	    code="label.back" /></a>
    </div>
    <script src="include/reservationMenu.js"></script>   
    <div class="container">           
    <form:form id="reservationDtlsdashBoard" name="reservationDtlsdashBoard" action="./unReserveRecords"  modelAttribute="tdmPoloSearchDTO">
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
      <c:when test="${tdmPoloSearchDTO.poloResrvationDTOList ne null}">      
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
					 <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.polId" /></th>
                     <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.polHId" /></th>
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.fName" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.lName" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.addr1" /></th>
                     <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.addr2" /></th>
                      <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.addr3" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.city" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.region" /></th>                    
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.country" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.postCode" /></th>
								</tr>
							</thead>
            <tbody>
              <c:forEach items="${tdmPoloSearchDTO.poloResrvationDTOList}" var="poloResrvationDTOList" varStatus="status">
                <tr>
                   <c:if test="${poloResrvationDTOList.unreserveYN eq null }">
									<td><label class="checkbox-inline">
									<form:checkbox path="poloResrvationDTOList[${status.index}].unreserveYN"
									id="poloResrvationDTOList[${status.index}].unreserveYN"
														class="cb_class checkBoxCls" value="Yes" />							 
									</label></td>
                                    </c:if>
                  <td align="center">${poloResrvationDTOList.insPolId}</td>
                  <td align="center">${poloResrvationDTOList.policyId}</td>
                  <td align="center">${poloResrvationDTOList.firstName}</td>
                  <td align="center">${poloResrvationDTOList.lastName}</td>
                  <td align="center">${poloResrvationDTOList.add1}</td>
                  <td align="center">${poloResrvationDTOList.add2}</td>      
                  <td align="center">${poloResrvationDTOList.add3}</td>
                  <td align="center">${poloResrvationDTOList.city}</td>
                  <td align="center">${poloResrvationDTOList.policyHolderRegion}</td>
                  <td align="center">${poloResrvationDTOList.country}</td>
                  <td align="center">${poloResrvationDTOList.postalCode}</td>
                </tr>
              </c:forEach>
              
              
            </tbody>
          
          </table>
            
            <c:if test="${tdmPoloSearchDTO.poloResrvationDTOList ne null &&  not empty tdmPoloSearchDTO.poloResrvationDTOList}">
                 
					<c:forEach
						items="${tdmPoloSearchDTO.poloResrvationDTOList}"
						var="poloResrvationDTOList" varStatus="status">
						<form:hidden
							path="poloResrvationDTOList[${status.index}].insPolId" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].policyId" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].firstName" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].lastName" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].add1" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].add2" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].add3" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].city" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].policyHolderRegion" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].country" />
						<form:hidden
							path="poloResrvationDTOList[${status.index}].postalCode" />
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
                  <th scope="col">
                   <input type="submit" name="unreserve"
									class="btn-primary btn-cell" id="unreserve" value="Un Reserve">
                       <input type="submit" name="export" id="export" class="btn-primary btn-cell" value="ExportAll to Excel">
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
      </c:otherwise>
    </c:choose>
    </form:form>
      
    </div>
    <script src="include/footer.js"></script>
  </div>
 <script>
 menu_highlight('Non_Standard_Reserv');
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