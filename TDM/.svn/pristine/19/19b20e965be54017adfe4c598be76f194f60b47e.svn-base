<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | Search Request</title>
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
	<link rel="stylesheet" type="text/css" href="css/steps.css">
	    
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
  <div class="mainAll">
 <jsp:include page="indexHeader.jsp"></jsp:include>
   
 <div class="container">
  <c:if test="${error ne null}">
	            <table class="my-error-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${error}</td>	                
	                </tr>
	              </tbody>
	            </table>
	           </c:if>           
     <br />
     
     <br />
     <br />
	      
	   
      <h2 style="color: #0098cc;font-size: 14px;">TDM Work Intake - Search Item(s)</h2>
      <hr>
      
      <div class="two-col">
      <form:form id="tdmSearchRequestForm" name="tdmSearchRequestForm" action="${pageContext.request.contextPath}/tdmSearchRequest" commandName="tdmSearchRequestDTO" modelAttribute="tdmSearchRequestDTO">
  	   <form:hidden path="userId"/>
  	   
        <table style="width:100%; border:0; font-size: 13px; cellpadding:4;">
        <tbody>
          <tr>
        	<td class="lable-title" width="35%" align="left" valign="middle">Request ID</td>
            <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:input path="id" id="id" class="form-control" />
            </td>
            
            <td class="flied-title" align="left">Domain Area</td>
            <td class="flied-title">
               <label class="checkbox-inline">
                 <form:checkbox path="domainArea" id="domainArea" value="Information Management" /> Information Management
                </label>
            </td>
            
           
          </tr>          
          <tr>
          	
          	<td class="lable-title" width="25%" align="left" valign="middle">Application</td>
            <td class="lable-title" width="20%" align="left" valign="middle" scope="col">
           		 <form:input path="app" id="app" class="form-control" />
           </td>
                    
            	<td class="lable-title" align="left" valign="middle">Status </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:select path="sts" id="sts" class="down-control">
                  <form:option value="">--Select--</form:option>
                  <form:option value="Submitted">Submitted</form:option>
                  <form:option value="Pending">Pending</form:option>
               </form:select>
            </td>
             
           
          </tr>          
       
          </tbody>
        </table>   
       
           
       
      
       <table  style="width:100%; border:0;font-size: 13px; color: #0C5473;align:center; ">
            <tbody>
               <tr>
                 <th scope="col" class="buttonsAll8">
                    <input type="submit" id="submit" name="search" class="btn-primary btn-cell" value="Search"> 
                    <input type="reset"  id="reset" name="reset" class="btn-primary btn-cell" value="Reset">                     
                 </th>
               </tr>
            </tbody>
         </table>
       
       
       
       <c:if
					test="${tdmSearchRequestDTO.tdmSearchRequestDTOs ne null &&  not empty tdmSearchRequestDTO.tdmSearchRequestDTOs}">
					<%
						int currentPage = (Integer) request
										.getAttribute("currentPage");
								int count1 = currentPage - 1;
								count1 = count1 * 10;
					%>


					  <table style="width:100%; border:0; font-size: 14px; font-style: italic; color:#7C6DC2;cellpadding:4;">
             			<tbody>
               			  <tr>
               			  	 <td class="lable-title" align="right" valign="middle"><spring:message code="label.totRecFetc" />${totalRecords}</td>
               			  </tr>
              			</tbody>
           			 </table> 



					<div class="scrollingX" id="myid">
						<table id="search_output_table" class="table tablesorter"
							style="width: 100%; font-size: 13px; border: 0; cellpadding: 0; cellspacing: 1;">
							<thead>
								<tr>
									<th align="center" bgcolor="#E3EFFB" scope="col"class="whitefont">Request ID</th>
								  	<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Domain Area</th>
								    <th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Application</th>						  	
									<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th>	
									<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Project Name</th>
									<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Project Number</th>						
									<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Requestor</th>
									<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th>
									<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Created Date</th>	
								</tr>
							</thead>
							<tbody>
								<c:forEach
									items="${tdmSearchRequestDTO.tdmSearchRequestDTOs}"
									var="tdmSearchRequestDTOs" varStatus="status">
									<tr>
										<td align="left">${tdmSearchRequestDTOs.id}</td>
										<td align="left">${tdmSearchRequestDTOs.domainArea}</td>
										<td align="left">${tdmSearchRequestDTOs.app}</td>
										<td align="left">${tdmSearchRequestDTOs.sts}</td>
										<td align="left">${tdmSearchRequestDTOs.projName}</td>
										<td align="left">${tdmSearchRequestDTOs.projNum}</td>
										<td align="left">${tdmSearchRequestDTOs.requestor}</td>
										<td align="left">${tdmSearchRequestDTOs.sts}</td>
										<td align="left">${tdmSearchRequestDTOs.createdDate}</td>
									</tr>
								</c:forEach>

								<c:forEach items="${tdmSearchRequestDTO.tdmSearchRequestDTOs}" var="tdmSearchRequestDTOs" varStatus="status">
									<form:hidden path="tdmSearchRequestDTOs[${status.index}].id" />
									<form:hidden path="tdmSearchRequestDTOs[${status.index}].domainArea" />
									<form:hidden path="tdmSearchRequestDTOs[${status.index}].app" />
									<form:hidden path="tdmSearchRequestDTOs[${status.index}].sts" />
									<form:hidden path="tdmSearchRequestDTOs[${status.index}].projName" />
									<form:hidden path="tdmSearchRequestDTOs[${status.index}].projNum" />
									<form:hidden path="tdmSearchRequestDTOs[${status.index}].requestor" />
									<form:hidden path="tdmSearchRequestDTOs[${status.index}].sts" />
									<form:hidden path="tdmSearchRequestDTOs[${status.index}].createdDate" />
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
						<li><a href="tdmSearchRequest?page=<%=1%>">&lt;&lt;</a>
							<div>&lt;&lt;</div></li>
						<li><a href="tdmSearchRequest?page=<%=currentPage - 1%>">&lt;</a>
							<div>&lt;</div> <%
 	} else {
 				if (noOfPages > 1) {
 %>
						<li class="disable"><a href="tdmSearchRequest?page=<%=1%>">&lt;&lt;</a>
							<div>&lt;&lt;</div></li>
						<li class="disable"><a
							href="tdmSearchRequest?page=<%=currentPage - 1%>">&lt;</a>
							<div>&lt;</div> <%
 	}
 			}
 			if (noOfPages > 1) {
 				for (int i = startPage; i <= lastPage; i++) {
 					if (currentPage == i) {
 %>
						<li class="active"><a href="#"><%=i%></a>
							<div><%=i%></div></li>
						<%
							} else {
						%>
						<li><a href="tdmSearchRequest?page=<%=i%>" id="employeeLink"><%=i%></a>
							<div><%=i%></div></li>
						<%
							}
										}
									}
									if (currentPage < noOfPages) {
						%>
						<li><a href="tdmSearchRequest?page=<%=currentPage + 1%>">&gt;</a>
							<div>&gt;</div></li>
						<li><a href="tdmSearchRequest?page=<%=noOfPages%>">&gt;&gt;</a>
							<div>&gt;&gt;</div></li>
						<%
							} else {
										if (noOfPages > 1) {
						%>
						<li class="disable"><a
							href="tdmSearchRequest?page=<%=currentPage + 1%>">&gt;</a>
							<div>&gt;</div></li>
						<li class="disable"><a href="tdmSearchRequest?page=<%=noOfPages%>">&gt;&gt;</a>
							<div>&gt;&gt;</div></li>
						<%
							}
									}
						%>
					</ul>

					<!-- Pagination Ends -->
					<br>
					<table style="width: 100%; border: 0">
						<tbody>
							<tr>
								<th scope="col"  class="buttonsAll15">
									<input type="submit" name="export" id="export" value="Export to Excel">
								</th>
							</tr>
						</tbody>
					</table>

				</c:if>
       
       
       
       
       
       
       
               
        </form:form>           
      </div>       
  </div>
  <script src="include/footer.js"></script>
</div> 
<script src="include/copyrtfooter.js"></script>
<script>

menu_highlight('services');
menu_highlight('services_Search');

$("#search_output_table").tablesorter({
	widgets : [ 'zebra' ]
});

$(".table tr:odd").css('background-color', '#ffffff');
$(".table tr:even").addClass('even');

window.location.hash = "myid";

$(function() {
	$( document ).tooltip({
		position: {
			my: "center bottom-20",
			at: "center top",
			using: function( position, feedback ) {
				$( this ).css( position );
				$( "<div>" )
					.addClass( "arrow" )
					.addClass( feedback.vertical )
					.addClass( feedback.horizontal )
					.appendTo( this );
			}
		}
	});
});

$(document).ready(function() {
	$(document).ready(function() {
		var readOnly = '${readOnly}';
		if(readOnly=='true'){
			
			disablePage();
		}
		  
      
  });	
});
</script>
</body>
</html>
