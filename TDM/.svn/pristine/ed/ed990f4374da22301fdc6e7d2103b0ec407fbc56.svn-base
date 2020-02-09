<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<title>TDG | Data Conditioner Dashboard</title>
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
  <script src="js/jquery-migrate-1.2.1.min.js"></script>
<script>
  $(document).ready(function() {
	$('#errors').html('');
						$('#errors').hide();
						$('#errors').html('');
						$('#success').html('');
						$('#success').hide();
						if ("${baseDTO.messageConstant}" == null || typeof '${baseDTO.messageConstant}' == ''
								|| '${baseDTO.messageConstant}' == '') {
							$('#error').html('');
							$('#error').hide();

						} else {
							if ('${baseDTO.messageConstant}' == 'SUCCESS') {
								$('#success').html('${baseDTO.message}');
								$('#success').show();
							} else {
								$('#error').html('${baseDTO.message}');
								$('#error').show();
							}
						}
					})
</script>

</head>
<body>
	<div id="main" class="wrapper">
		<!-- <script src="include/indexHeader.js"></script> -->
		<jsp:include page="indexHeader.jsp"></jsp:include>

		<div id="tabs-1" class="container">
			<ol class="breadcrumb">
				<li><a href="./index">Home</a></li><li>&#x2f;</li>
				<li class="active">TDG Data Conditioner Dashboard</li>
			</ol>

			<form:form name="dataConditionalDashboard"
				action="${pageContext.request.contextPath}/tdgDataConditionalDashboard" modelAttribute="baseDTO">
				<div id="errors" class="errorblock" style="display: none"></div>
				<div id="success" class="successblock" style="display: none"></div>
				<c:choose>
					<c:when
						test="${tdgDataConditionDTOList ne null && not empty tdgDataConditionDTOList }">
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
											class="whitefont">ID</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Url</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">User Name</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Password</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Table Name</th>
										<th align="center" bgcolor="#E3EFFB" scope="col"
											class="whitefont">Delete Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${tdgDataConditionDTOList}" var="tdgDataConditionDTO"
										varStatus="status">
										<tr>
										<td align="left"><a href="${pageContext.request.contextPath}/fetchdictionaryDetails?id=${tdgDataConditionDTO.id}" title="click here to do dump data into database">${tdgDataConditionDTO.id}</a></td>
											<td align="left">${tdgDataConditionDTO.url}</td>
											<td align="left">${tdgDataConditionDTO.username}</td>
											<td align="left">${tdgDataConditionDTO.password}</td>
											<td align="left">${tdgDataConditionDTO.tablename}</td>
											<td><a href="#"
												onClick="deleteTdgDataConditional('${tdgDataConditionDTO.id}','')">delete</a></td>
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
							<li><a href="tdgDataConditionalDashboard?page=<%= 1 %>">First</a>
								<div>First</div></li>
							<li><a
								href="tdgDataConditionalDashboard?page=<%= currentPage-1 %>">&lt;
									Prev</a>
								<div>&lt; Prev</div> <%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
							<li class="disable"><a
								href="tdgDataConditionalDashboard?page=<%= 1 %>">First</a>
								<div>First</div></li>
							<li class="disable"><a
								href="tdgDataConditionalDashboard?page=<%= currentPage-1 %>">&lt;
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
							<li><a href="tdgDataConditionalDashboard?page=<%= i %>"
								id="employeeLink"><u><%= i %></u></a></li>
							<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
							<li><a
								href="tdgDataConditionalDashboard?page=<%= currentPage+1 %>">Next
									&gt;</a>
								<div>Next &gt;</div></li>
							<li><a
								href="tdgDataConditionalDashboard?page=<%= noOfPages %>">Last</a>
								<div>Last</div></li>
							<%
											} else {
											    if(noOfPages > 1) {
										%>
							<li class="disable"><a
								href="tdgDataConditionalDashboard?page=<%= currentPage+1 %>">Next
									&gt;</a>
								<div>Next &gt;</div></li>
							<li class="disable"><a
								href="tdgDataConditionalDashboard?page=<%= noOfPages %>">Last</a>
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
							<u>No TDG Data Conditional Details Available</u>
						</h3>
						<br />
					</c:otherwise>
				</c:choose>
			</form:form>
		</div>
	</div>
</body>
<script src="include/footer.js"></script>
<script>
 	menu_highlight('tdm_command_center1');
    $("#search_output_table").tablesorter({
 	    widgets: ['zebra']
 	  });
    
    function deleteTdgDataConditional(reqId,manId){
   		 if (confirm('Are you sure to delete the Data conditional ?')) {
   	 	   document.location.href="./deleteTdgDataConditional?id="+reqId;
   		  }
    }    
  </script>
</body>
</html>