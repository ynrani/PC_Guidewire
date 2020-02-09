<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM CentralData | Masking Dashboard</title>
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
<body>
	<div class="wrapper mainAll">
		<jsp:include page="indexHeader.jsp"></jsp:include>
		<script src="include/dashboardmenu.js"></script>
		 
		<div class="container">
				<!-- <ol class="breadcrumb">
					<li><a class="hrefVisited" href="./index">Home</a></li>
					<li>&#x2f;</li>
					<li><a  class="hrefVisited" href="./index">TDM Life Cycle</a></li>
					<li>&#x2f;</li>
					<li class="active">Data Masking Dashboard</li>
				</ol> 
	      <h2 style="color: #0098cc"><spring:message code="label.dm.dashboard"/></h2> -->
	       <c:if test="${error ne null}">
	            <table class="my-error-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle">${error}</td>	                
	                </tr>
	              </tbody>
	            </table>
	       </c:if>           
	<form:form id="tdmMaskingCRDataForm" name="tdmMaskingCRDataForm" action="${pageContext.request.contextPath}/tdmMaskingCR">  
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
						<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Project Name</th>
						<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Project Phase</th>						
						<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Requested Time</th>
						<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th>
			            <th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Change Request Comment</th>												
					</tr>
				</thead>
			 <tbody>
                 <c:forEach items="${tdgDtMaskRequestListDTOs}" var="tdgDtMaskRequestListDTOs" varStatus="status">
                   <tr onmouseover="this.style.cursor='pointer'" onClick="getRequestDtls('${tdgDtMaskRequestListDTOs.id}','${tdgDtMaskRequestListDTOs.status}')">
                     <td align="left">${tdgDtMaskRequestListDTOs.id}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.desc}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.userName}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.projName}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.projPhase}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.reqTime}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.status}</td>
                     <td align="left">${tdgDtMaskRequestListDTOs.chngReqCmmt}</td>                      
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
			   									<li><a href="tdmDtMaskDashBoardCR?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li><a href="tdmDtMaskDashBoardCR?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="tdmDtMaskDashBoardCR?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li class="disable"><a href="tdmDtMaskDashBoardCR?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
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
			    										<li><a href="tdmDtMaskDashBoardCR?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="tdmDtMaskDashBoardCR?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="tdmDtMaskDashBoardCR?page=<%= noOfPages %>">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="tdmDtMaskDashBoardCR?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="tdmDtMaskDashBoardCR?page=<%= noOfPages %>">Last</a><div>Last</div></li>
										<%
											    }
											}
										%>
									</ul>
									
		  <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col">
                       <input type="submit" name="export" id="export" class="btn-primary btn-cell" value="ExportAll to Excel">
                   </th>
                </tr>
              </tbody>
            </table>	
        
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


<script>
menu_highlight('tdm_command_center1');
menu_highlight('CRMRDashBoard');
window.location.hash = "myid";
   function getRequestDtls(reqId,status){
	   document.location.href="./tdmDataMaskingNew?reqId="+reqId+"&status="+status;
   }
   
   $("#search_output_table").tablesorter({
	    widgets: ['zebra']
	  });
   $(".table tr:odd").css('background-color', '#ffffff');
   $(".table tr:even").addClass('even'); 
</script>
</body>
</html>