<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | Request Test Data List</title>
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
</head>

<body>
  <div id="main" class="mainAll">
   
    <jsp:include page="header.jsp"></jsp:include>
  	
    <div class="container">
    
    <br/>
    <br/>
      
      <h2 style="color: #0098cc;font-size: 14px;">Test Data Request(s)</h2>
      <hr>
     
    <form:form id="tdmReqTestDataForm" name="tdmReqTestDataForm" action="${pageContext.request.contextPath}/tdmReqTestDataList">
    <c:choose>
      <c:when test="${tdmReqTestDataDTOs ne null}">
      
      							<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%> 
        <div id="tabs-1" class="container scrollingX">
          <table class="table outputtable tablesorter" style="width:100%; border:0; cellpadding:0; cellspacing:1;">
            <thead>
              <tr>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont">Request Id</th>
	               <th bgcolor="#E3EFFB" height="25" class="whitefont">Policy Type</th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont">Policy Request Details</th>
	               <th bgcolor="#E3EFFB" height="25" class="whitefont">Requester Name</th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont">Requesting Team</th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont">Test Environment</th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont">Request Date</th>
	               <th bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th>
	                
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${tdmReqTestDataDTOs}" var="tdmReqTestDataDTOs" varStatus="status">
                <tr onmouseover="this.style.cursor='pointer'" onClick="getRequestDtls('${tdmReqTestDataDTOs.reqId}')">
                  <td align="center">${tdmReqTestDataDTOs.reqId}</td>
                  <td align="center">${tdmReqTestDataDTOs.policyType}</td>
                  <td align="center">${tdmReqTestDataDTOs.policyReqDtl}</td>
                  <td align="center">${tdmReqTestDataDTOs.reqName}</td>
                  
                  <td align="center">${tdmReqTestDataDTOs.reqTeam}</td>
                  <td align="center">${tdmReqTestDataDTOs.envType}</td>
                  <td align="center">${tdmReqTestDataDTOs.reqDate}</td>
                  <td align="center">${tdmReqTestDataDTOs.reqSts}</td>
       
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
			   									<li><a href="tdmReqTestDataList?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li><a href="tdmReqTestDataList?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="tdmReqTestDataList?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li class="disable"><a href="tdmReqTestDataList?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
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
			    										<li><a href="tdmReqTestDataList?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="tdmReqTestDataList?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="tdmReqTestDataList?page=<%= noOfPages %>">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="tdmReqTestDataList?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="tdmReqTestDataList?page=<%= noOfPages %>">Last</a><div>Last</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->
							
		    <!-- <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col">
                  		<input type="button" name="back" id="back" class="btn-primary btn-cell" value="Back">
                       <input type="submit" name="export" id="export" class="btn-primary btn-cell" value="Export All to Excel">
                   </th>
                </tr>
              </tbody>
            </table>	 -->
      </c:when>
      <c:otherwise>
        <h3 style="float: left; width: 40%; border: 0; font-size: 14px;color: #E74949; padding-top: 15px">
				<u>No Request Test Data Found</u>
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
  	menu_highlight('Poly_Auto_Rev');
  	
  	
  	 function getRequestDtls(reqId){
  	   document.location.href="./tdmReqTestData?reqId="+reqId;
     }
  	 
  	$(".outputtable").tablesorter({
  	    widgets: ['zebra']
  	  });
  	
  	 $(document).ready(function() {
         $("#back").click(function(){
            	document.location.href="./policyAutoBack";
       	  });
       });
     
  </script>
</body>

</html>