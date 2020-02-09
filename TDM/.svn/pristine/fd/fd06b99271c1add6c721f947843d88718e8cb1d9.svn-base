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

<body>
	<div class="wrapper mainAll">
		<jsp:include page="indexHeader.jsp"></jsp:include>
		<script src="include/dashboardmenugrph.js"></script>
		 
		<div class="container">
				 
	       <c:if test="${error ne null}">
	            <table class="my-error-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle">${error}</td>	                
	                </tr>
	              </tbody>
	            </table>
	       </c:if>           
	<form:form id="tdmOnBoardingExportFRForm" name="tdmOnBoardingExportFRForm" action="${pageContext.request.contextPath}/tdmOnBoardingExportFR">  
	<c:choose>
      <c:when test="${tdgDtMaskRequestListDTOs ne null}">      
 		   <%
				int currentPage = (Integer) request.getAttribute("currentPage");
				int count1 = currentPage - 1;
				count1 = count1 * 10;
 			%>								
	  <div class="nav" id="myid">	
	   <table id="search_output_table" class="hoverTable"  style="width:100%; font-size: 13px; border:0; cellpadding:0; cellspacing:1;">
				<thead>
					<tr>
					  	<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Request Id</th>
					    <th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Description</th>						  	
						<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Created By</th>	
						<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Application Name</th>
						<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Application Phase</th>						
						<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Requested Time</th>
						<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th>							
					</tr>
				</thead>
			 <tbody>
                 <c:forEach items="${tdgDtMaskRequestListDTOs}" var="tdgDtMaskRequestListDTOs" varStatus="status">
                   <tr>
                                    
                    <td title="Vew Request" align="left" onmouseover="this.style.cursor='pointer'"
											onClick="getRequestDtls('${tdgDtMaskRequestListDTOs.id}')">${tdgDtMaskRequestListDTOs.id}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.desc}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.userName}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.projName}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.projPhase}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.reqTime}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.status}</td>                   
                   </tr>
                 </c:forEach>
               </tbody>
		</table>							
	 </div>		 
		 
		 <ul class="grdPagination">
			                  			<%
			                  				int noOfPages = (Integer) request.getAttribute("noOfPages");
			                  				int startPage = (Integer) request.getAttribute("startPage");
			                  				int lastPage = (Integer) request.getAttribute("lastPage");
			                  		  
											if (currentPage != 1) {
			   							%>
			   									<li><a href="tdmOnBoardingDashBoardLst?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li><a href="tdmOnBoardingDashBoardLst?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="tdmOnBoardingDashBoardLst?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li class="disable"><a href="tdmOnBoardingDashBoardLst?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
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
			    										<li><a href="tdmOnBoardingDashBoardLst?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="tdmOnBoardingDashBoardLst?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="tdmOnBoardingDashBoardLst?page=<%= noOfPages %>">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="tdmOnBoardingDashBoardLst?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="tdmOnBoardingDashBoardLst?page=<%= noOfPages %>">Last</a><div>Last</div></li>
										<%
											    }
											}
										%>
									</ul>
									
											
   	    	
        
        </c:when>
      <c:otherwise>
        <h3 style="float: left; width: 40%; border: 0; font-size: 14px;color: black; padding-top: 15px">
				<div>No Masking Data available</div>
			</h3>
        <br/>
      </c:otherwise>
    </c:choose>
    </form:form>
	</div>
	<script src="include/footer.js"></script>
  </div>		
<script src="include/copyrtfooter.js"></script>
<script>
menu_highlight('admin');
menu_highlight('admin_cfg_mgmt');
menu_highlight('admin_cfg_mgmt_dash');
menu_highlight('admin_cfg_mgmt_dash_lit');

menu_highlight('TBRDashBoard');
window.location.hash = "myid";
   function getRequestDtls(reqId){
	   document.location.href="./tdmOnboardReq?reqId="+reqId;
   }
   
   function cancelRequest(reqId)
   {
	  confirmation_dialogYNCancelonBoardReq(reqId,'Submit','Are you sure do you want to cancel the request ?',400,'YesNo','Yes','No');
   }
   
   $("#search_output_table").tablesorter({
	    widgets: ['zebra']
	  });
   $(".table tr:odd").css('background-color', '#ffffff');
   $(".table tr:even").addClass('even'); 
</script>
</body>
</html>