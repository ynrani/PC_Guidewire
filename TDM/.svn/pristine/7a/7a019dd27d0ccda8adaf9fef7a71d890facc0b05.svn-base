<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
  <title> TDG | DashBoard</title>
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
	<script type="text/javascript">
	$(document).ready(function() {
		if("${tdgRequestListDTO.messageConstant}" == 'SUCCESS'){
			$('#errors').html('');
			 $('#success').html('${tdgRequestListDTO.message}');
				$('#success').show(); 
		 }else if("${tdgRequestListDTO.messageConstant}" == 'FAILED'){
			 $('#success').html('');
				$('#success').hide();
				$('#errors').html('${tdgRequestListDTO.message}');
				$('#errors').show();
		 }
	});
	
	</script>
</head>

<body>
  <div id="main" class="mainAll">
   <!--  <script src="include/header.js"></script> -->
   <jsp:include page="indexHeader.jsp"></jsp:include>
      <div id="tabs-1" class="container">
        <form:form id="tdgDashBoardForm" name="tdgDashBoardForm" action="${pageContext.request.contextPath}/tdgDashBoardDetails" modelAttribute="tdgRequestListDTO">
          <div id="errors" class="errorblock" style = "display:none" ></div>
		  <div id="success" class="successblock" style = "display:none" ></div>
            <input type="hidden" name="userId" value="${sessionScope.userId}" />
            <table style="width:100%; border:0; font-size: 13px;" >
              <tbody>
              
                <tr>
                <td class="lable-title" width="35%" align="left"
											valign="middle">Request ID : </td>
											<td class="flied-title" width="20%" align="left"
											valign="middle"><form:input path="requestid" class="form-control" /></td>
                </tr>
              </tbody>
            </table>

            <table style="width:100%; border:0; font-size: 13px;" >
              <tbody>
                <tr>
                  <td colspan="4" align="center" valign="middle">
                   <input type="submit" name="search" id="Search" class="btn-primary btn-cell" value="<spring:message code="button.serch"/>" >
                    <input type="reset" value="Reset" id="reset" class="btn-primary btn-cell" onClick="clearFields('./tdgDashBoardDetails');">
                  </td>
                </tr>
              </tbody>
            </table>
          <br/>
          <br/>
         
							
          <c:choose>
      <c:when test="${tdgRequestListDTO ne null  && tdgRequestListDTO.listTdgRequestListDTO ne null }">
      
      							<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%> 
							 <div class="scrollingX" id="searchResult">
		  <div class="nav" id="myid">	
		   <table id="search_output_table" class="hoverTable" style="width:100%; font-size: 13px;">
					<thead>
						<tr>
						  	<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Request Id</th>
						    <th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Dictionary Name</th>
						    <th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Records Generated</th>
						    <th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th>
						    <th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Generation Type</th>
						    <th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status Description</th>
						    <th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Conditions</th>	  	
							<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Created By</th>	
							<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Data File</th>										
						</tr>
					</thead>
				 <tbody>
                  <c:forEach items="${tdgRequestListDTO.listTdgRequestListDTO}" var="tdgRequestListDTOs" varStatus="status">
                    <tr>
                      <td align="left">${tdgRequestListDTOs.requestid}</td>
                      <td align="left">${tdgRequestListDTOs.schemaname}</td>
                      <td align="left">${tdgRequestListDTOs.requestCount}</td>
                      <td align="left">${tdgRequestListDTOs.status}</td>
                      <td align="left">${tdgRequestListDTOs.generationType}</td>
                      <td align="left">
                      <c:if test="${tdgRequestListDTOs.status == 'Success' && tdgRequestListDTOs.generationType != 'DB'}">
                      <%-- <c:if test="${tdgRequestListDTOs.status == 'Success'}"> --%>
                      <a style="font-style: italic;" href="javascript:;" onclick="downloadFlatFiles('${tdgRequestListDTOs.requestid}')"> Click here </a> to download the generated files
                      <%-- </c:if>
                      <c:if test="${dgRequestListDTOs.status != 'Success'}">${tdgRequestListDTOs.statusdescription} --%>
                      </c:if>
                      <c:if test="${tdgRequestListDTOs.status == 'Failed' && tdgRequestListDTOs.generationType != 'DB'}">
                      ${tdgRequestListDTOs.statusdescription}
                      </c:if>
                      <%-- </c:if> --%>
                      <c:if test="${tdgRequestListDTOs.generationType == 'DB'}">${tdgRequestListDTOs.statusdescription}</c:if>
                      </td>
                      
                      <td align="left">${tdgRequestListDTOs.conditions}</td>
                      <td align="left">${tdgRequestListDTOs.userid}</td>
                      
                      <td align="left">
                      <c:if test="${tdgRequestListDTOs.requestCount gt 0 }">
                      <form:select path="dataFile" id="dataFile${status.index}">                      
                      <form:option value=".xls">xls</form:option>
                      <form:option value=".pdf">pdf</form:option>
                      <form:option value=".csv">csv</form:option>
                    </form:select><a id="dhref" href="#" onclick="performTdgRequestDownload('${tdgRequestListDTOs.conditions}','${tdgRequestListDTOs.requestid}','${status.index}')"><img src="./images/download.png" alt="download" height="25" width="25"></a>
                    </c:if>   
                    </td>
                   </tr>
                  </c:forEach>
                </tbody>
			</table>							
		 </div>		 
		 </div>
		 <ul class="grdPagination">
			                  		    <%
			                  				int noOfPages = (Integer) request.getAttribute("noOfPages");
			                  				int startPage = (Integer) request.getAttribute("startPage");
			                  				int lastPage = (Integer) request.getAttribute("lastPage");
			                  		  
											if (currentPage != 1) {
			   							%>
			   									<li><a href="tdgDashBoardDetails?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li><a href="tdgDashBoardDetails?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="tdgDashBoardDetails?page=<%= 1 %>">First</a><div>First</div></li>
			   									<li class="disable"><a href="tdgDashBoardDetails?page=<%= currentPage-1 %>">&lt; Prev</a><div>&lt; Prev</div>
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
			    										<li><a href="tdgDashBoardDetails?page=<%= i %>" id="employeeLink"><u><%= i %></u></a></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="tdgDashBoardDetails?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li><a href="tdgDashBoardDetails?page=<%= noOfPages %>">Last</a><div>Last</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="tdgDashBoardDetails?page=<%= currentPage+1 %>">Next &gt;</a><div>Next &gt;</div></li>
			    		     					<li class="disable"><a href="tdgDashBoardDetails?page=<%= noOfPages %>">Last</a><div>Last</div></li>
										<%
											    }
											}
										%>
									</ul>	
								 </c:when>     
    </c:choose>
    
        </form:form>
      </div>
    <script src="include/footer.js"></script>
  </div>
   
 <script>
	menu_highlight('admin');
	menu_highlight('admin_user_mgmt');
	menu_highlight('admin_user_mgmt_add');
    $("#search_output_table").tablesorter({
 	    widgets: ['zebra']
 	  });
    $(".table tr:odd").css('background-color', '#ffffff');
    $(".table tr:even").addClass('even'); 
    
    var performTdgRequestDownload=function(conditions,reqId,index){
       	  if(conditions == ''){
 		  	$('#errors').html('Conditions are absent unable to perform the export');
 			$('#errors').show();
 			 return;
    	}else{
	    	var selected=$("#dataFile"+index).val();
	    	if(selected == ".csv"){
	         	document.location.href='${pageContext.request.contextPath}/downloadTdgCSVRequest?dataFile='+selected+'&reqId='+reqId;
	    	}
	    	else{
	         	document.location.href='${pageContext.request.contextPath}/downloadTdgRequest?dataFile='+selected+'&reqId='+reqId;
	    	}
    	}
     }
    
    var downloadFlatFiles=function(reqId){
	         	document.location.href='${pageContext.request.contextPath}/downloadFlatFiles?reqId='+reqId;
   }
</script>
</body>
</html>
 