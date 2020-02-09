<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
  <title>TDG | Master Dictionary</title>
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
  <script>
  $(document).ready(function() {
	  $('#errors').html('');
		$('#errors').hide();
		$('#success').html('');
		$('#success').hide();
		if("${error}" == null || typeof '${error}' == '' ||  '${error}' == ''){
			$('#error').html('');
			$('#error').hide();
			
		}else{
			$('#error').html('${error}');
			$('#error').show(); 
		}			
	})
  </script>

</head>
<body>
   <div id="main" class="wrapper">
    <!-- <script src="include/indexHeader.js"></script> -->
    <jsp:include page="indexHeader.jsp"></jsp:include>
      <div id="tabs-1" class="container">
		
 <form:form name="masterDictionary"
				action="${pageContext.request.contextPath}/tdgMasterDictionaryDashboard" modelAttribute="baseDTO">
				<div id="errors" class="errorblock" style="display: none"></div>
				<div id="success" class="successblock" style="display: none"></div>
				<c:choose>
					<c:when
						test="${tdgSchemaDTOList ne null && not empty tdgSchemaDTOList }">
						<%
				int currentPage = (Integer) request.getAttribute("currentPage");
				int count1 = currentPage - 1;
				count1 = count1 * 10;
 			%>
						<div class="scrollingX" id="myid">
							<table id="search_output_table" class="hoverTable" border="0"
								cellpadding="0" cellspacing="1"
								style="width: 100%; font-size: 13px;">
								<thead>
									<tr>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Request Schema Id</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">User Name</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">User Id</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Url</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Schema Name</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Manual Dictionary</th>
										<!-- 					<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Edit Action</th>-->
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Delete Action</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Delete Manual Dictionary</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${tdgSchemaDTOList}" var="tdgSchemaDTOList"
										varStatus="status">
										<tr>
											<td align="left">${tdgSchemaDTOList.reqschemaid}</td>
											<%-- <td align="left"><a href="${pageContext.request.contextPath}/uploadManualDictionary?reqSchemaId=${tdgSchemaDTOList.reqschemaid}" title="click here to upload manual dictionary"></a></td> --%>
											<td align="left"><a href="javascript:;" onclick="popup('./uploadManualDictionary?reqSchemaId=${tdgSchemaDTOList.reqschemaid}','Upload Manual Dictionary','popup','popupOverlay','500');" title="click here to upload manual dictionary">${tdgSchemaDTOList.username}</a></td>
											<%-- <td align="left">${tdgSchemaDTOList.username}</td> --%>
											<td align="left">${tdgSchemaDTOList.userid}</td>
											<td align="left">${tdgSchemaDTOList.url}</td>
											<td align="left">${tdgSchemaDTOList.schemaname}</td>
											<td align="left">${tdgSchemaDTOList.manualdictionary}</td>
											<%--                 <td><a	href="${pageContext.request.contextPath}/editTdgReqDictionary(?reqschemaid=${tdgSchemaDTOList.reqschemaid}">Edit</a></td> --%>
											<td><a href="#"
												onClick="deleteTdgReqDictionary('${tdgSchemaDTOList.reqschemaid}','')">delete</a></td>
											<td>
											<c:choose>
											<c:when test="${tdgSchemaDTOList.manualdictionary != null && tdgSchemaDTOList.manualdictionary != ''}">
											<a href="#"
												onClick="deleteTdgReqDictionary('${tdgSchemaDTOList.reqschemaid}','${tdgSchemaDTOList.manualdictionary}')">delete</a>
											</c:when>
											<c:otherwise></c:otherwise>
											</c:choose>
												</td>
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
							<li><a href="tdgMasterDictionaryDashboard?page=<%= 1 %>">First</a>
								<div>First</div></li>
							<li><a
								href="tdgMasterDictionaryDashboard?page=<%= currentPage-1 %>">&lt;
									Prev</a>
								<div>&lt; Prev</div> <%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
							<li class="disable"><a
								href="tdgMasterDictionaryDashboard?page=<%= 1 %>">First</a>
								<div>First</div></li>
							<li class="disable"><a
								href="tdgMasterDictionaryDashboard?page=<%= currentPage-1 %>">&lt;
									Prev</a>
								<div>&lt; Prev</div> <%
			   								 	}
			   								}
											if(noOfPages > 1) {
			    								for (int i=startPage; i<=lastPage; i++) {
			    									if(currentPage == i) {
			   			 				%>
							<li class="active"><a href="#"><%= i %></a>
								<div><%= i %></div></li>
							<%
			    									} else {
			    						%>
							<li><a href="tdgMasterDictionaryDashboard?page=<%= i %>"
								id="employeeLink"><u><%= i %></u></a></li>
							<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
							<li><a
								href="tdgMasterDictionaryDashboard?page=<%= currentPage+1 %>">Next
									&gt;</a>
								<div>Next &gt;</div></li>
							<li><a
								href="tdgMasterDictionaryDashboard?page=<%= noOfPages %>">Last</a>
								<div>Last</div></li>
							<%
											} else {
											    if(noOfPages > 1) {
										%>
							<li class="disable"><a
								href="tdgMasterDictionaryDashboard?page=<%= currentPage+1 %>">Next
									&gt;</a>
								<div>Next &gt;</div></li>
							<li class="disable"><a
								href="tdgMasterDictionaryDashboard?page=<%= noOfPages %>">Last</a>
								<div>Last</div></li>
							<%
											    }
											}
										%>
						</ul>

					</c:when>
					<c:otherwise>
						<h3
							style="float: left; width: 40%; border: 0; font-size: 14px; color: black; padding-top: 15px">
							<u>No TDG Master Dictionary Available</u>
						</h3>
						<br />
					</c:otherwise>
				</c:choose>
			</form:form>
	</div>
	<script src="include/footer.js"></script>
  </div>		
</body>
  <script>
  menu_highlight('tdm_command_center1');
  $("#search_output_table").tablesorter({
	    widgets: ['zebra']
	  });
  
  function deleteTdgReqDictionary(reqId,manId){
 		 if (confirm('Are you sure to delete the dictionary?')) {
 	 	   document.location.href="./deleteTdgMasterDictionaryByReqSchemaId?reqSchemaId="+reqId+"&manualDictionaryId="+manId;
 		  }
  }    
  </script>  
</body>
</html>