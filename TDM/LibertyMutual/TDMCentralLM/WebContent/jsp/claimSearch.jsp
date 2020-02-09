<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title> TDM Central | Claim Search</title>
  <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" >
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/custom.css">
  <link href="css/theme.default.css" rel="stylesheet">
  <link href="css/elements.css" rel="stylesheet">
  <link href="css/jquery.alerts.css" rel="stylesheet">
  <script src="js/html5Shiv.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/main.js"></script>
  <script src="js/jquery.alerts.js"></script>
  <script src="js/jquery.validate.min.js" type="text/javascript" ></script>  
  <script src="js/messages.js"></script>
  <script src="js/common.js"></script>
  <script src="js/jquery-migrate-1.2.1.min.js"></script>	
</head>

<body>
    <div id="main" class="wrapper mainAll">
   <!--  <script src="include/header.js"></script> -->
   <jsp:include page="header.jsp"></jsp:include>
    <script src="include/menu.js"></script>
      <div id="tabs-1" class="container">
        <form:form id="claimSearchForm" name="claimSearchForm" action="${pageContext.request.contextPath}/claimSearch" modelAttribute="tdmPolicyClaimSearchDTO">
          <div class="">
            <input type="hidden" name="userId" value="${sessionScope.userId}" />
            <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td class="lable-title" width="35%" align="left" valign="middle"><spring:message code="label.env" /><span>*</span></td>
                  <td class="flied-title" width="20%" align="left" valign="middle">
                    <form:select path="envType" id="envType" class="down-control" required="required">
                      <form:option value="">--Select--</form:option>
                      <form:option value="TST 1">TST 1</form:option>
                      <form:option value="Dev Region 1">Dev Region 1</form:option>
                      <form:option value="Dev Region 2">Dev Region 2</form:option>
                      <form:option value="Pre-Prod 1">Test 1</form:option>
                      <form:option value="Pre-Prod 2">Test 2</form:option>
                      <form:option value="Test 1">Pre-Prod 1</form:option>
                      <form:option value="Test 2">Pre-Prod 2</form:option>
                    </form:select>
                  </td>
                  <td class="lable-title" width="25%" align="left" valign="middle"></td>
                  <td class="lable-title" width="20%" align="left" valign="middle" scope="col"></td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.claim.ds" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="dataSource" id="dataSource" class="down-control">
                       <form:option value="">--Select--</form:option>
                       <form:option value="Production">Production</form:option>
                       <form:option value="Test">Test</form:option>
                      
                    </form:select>
                    <td class="lable-title" align="left" valign="middle" scope="col">
                      <spring:message code="label.claim.srcSys" />
                    </td>
                    <td class="flied-title" align="left" valign="middle" scope="col">
                      <form:select path="sourceSystem" id="sourceSystem" class="down-control" >
                       <form:option value="">All</form:option>
                       <form:option value="10005">OCAS</form:option>
                      </form:select>
                    </td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.claim.lob" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="lob" id="lob" class="down-control">
                       <form:option value="">All</form:option>
                        <form:option value="10001">Businessowners Line</form:option>
						<form:option value="10002">Commercial Auto Line</form:option>
						<form:option value="10003">Commercial Property Line</form:option>
						<form:option value="10004">General Liability Line</form:option>
						<form:option value="10005">Homeowners Line</form:option>
						<form:option value="10006">Inland Marine Line</form:option>
						<form:option value="10007">Other Liability</form:option>
						<form:option value="10008">Personal Auto Line</form:option>
						<form:option value="10009">Personal Umbrella Line</form:option>
						<form:option value="10010">Travel</form:option>
						<form:option value="10011">Workers' Comp Line</form:option>
                    </form:select>
                  </td>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.claim.ClaimSts" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="claimStatus" id="claimStatus"  class="down-control">
                       <form:option value="">All</form:option>
                        <form:option value="10001">Archived</form:option>
						<form:option value="10002">Canceled</form:option>
						<form:option value="10003">Expired</form:option>
						<form:option value="10004">In force</form:option>
						<form:option value="10005">Pending Cancellation</form:option>
						<form:option value="10006">Pending Confirmation</form:option>
						<form:option value="10007">Payment past due</form:option>
                    </form:select>
                  </td>                  
                </tr>
                
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.claim.state" /> 
                  </td>
                   <td class="flied-title" align="left" valign="middle">
                    <form:select path="claimState" id="claimState"  class="down-control">
                      <form:option value="">All</form:option>
                     	<form:option value="CA">CA</form:option>
						<form:option value="AZ">AZ</form:option>
						<form:option value="IN">IN</form:option>
						<form:option value="OK">OK</form:option>
						<form:option value="UT">UT</form:option>
						<form:option value="OH">OH</form:option>
						<form:option value="NV">NV</form:option>
						<form:option value="WY">WY</form:option>
						<form:option value="MT">MT</form:option>
						<form:option value="VA">VA</form:option>
						<form:option value="PA">PA</form:option>
						<form:option value="CO">CO</form:option>
						<form:option value="KS">KS</form:option>
						<form:option value="MD">MD</form:option>
						<form:option value="NJ">NJ</form:option>
						<form:option value="NY">NY</form:option>
						<form:option value="DE">DE</form:option>
						<form:option value="CT">CT</form:option>
						<form:option value="OR">OR</form:option>
						<form:option value="DC">DC</form:option>
						<form:option value="SD">SD</form:option>
						<form:option value="WV">WV</form:option>
						<form:option value="ID">ID</form:option>
						<form:option value="KY">KY</form:option>
                    </form:select>
                  </td>    
                  <td class="lable-title" align="left" valign="middle" scope="col">
                     <spring:message code="label.claim.namedInsu" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="namedInsu" id="namedInsu" class="form-control" maxlength="21" />
                  </td>
                               
                </tr>
              
              
               <tr>
                  <td class="lable-title" align="left" valign="middle" scope="col">
                    <spring:message code="label.claim.policyNo" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="policyNo" id="policyNo" class="form-control" maxlength="21" />
                  </td>
                  <td class="lable-title" align="left" valign="middle" scope="col">
                    <spring:message code="label.claim.lossDt" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="lossDt" id="lossDt" class="date-control datepicker from" />
                  </td>
                </tr>
                           
              </tbody>          
              <tr>
                <td class="lable-title" align="left">
                  <spring:message code="label.noOfRec" />
                </td>
                <td class="flied-title">
                  <form:select path="searchRecordsNo" id="searchRecordsNo" class="down-control-small">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="20">20</form:option>
                  </form:select>
                </td>
              </tr>
            </table>

            <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td colspan="4" align="center" valign="middle">
                   <input type="submit" name="search" id="Search" class="btn-primary btn-cell" value="<spring:message code="button.serch"/>">
                    <input type="reset" value="Reset" class="btn-primary btn-cell" onClick="clearFields('./claimSearch');"/>
                  </td>
                </tr>
              </tbody>
            </table>

          </div>
          <br/>
          <br/>
          
           <c:if test="${tdmPolicyClaimSearchDTO.tdmClaimSearchResultDTOs eq null}">
            
            <c:if test="${result ne null}">
            <table style="width:100%; border:0; font-size: 12px; font-style: italic; color:#7C6DC2; cellpadding:4;">
              <tbody>
                <tr>
                  <td class="lable-title" align="left" valign="middle"> ${result}</td>                 
                </tr>
              </tbody>
            </table>
            
            
             <br/>
	          <br/>
	          
	          <c:if test="${tdmPolicyClaimSearchDTO.autoEmailDTOs ne null && empty tdmPolicyClaimSearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          
	          <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.recFndByyou" /></td>
	                 
	                </tr>
	              </tbody>
	            </table>
	          
	          
	          </c:if>
	          
	          <c:if test="${tdmPolicyClaimSearchDTO.autoEmailDTOs ne null &&  not empty tdmPolicyClaimSearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          
	          
	          <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.recFndByOth"/></td>
	                 
	                </tr>
	              </tbody>
	            </table>
	          
	           <table class="table " style="width:70%; font-size: 12px;border:0; cellpadding:0; cellspacing:1">
           		 <thead>
                  <tr>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.userId"/></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.tcId" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"> <spring:message code="label.tcName" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.msg"/></th>
                    </tr>
                   </thead>
	              <tbody>
                  <c:forEach items="${tdmPolicyClaimSearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">
                    <tr>
                      <td>${autoEmailDTOs.userId}</td>
                      <td>${autoEmailDTOs.testCaseId}</td>
                      <td>${autoEmailDTOs.testCaseName}</td>
                      <td>
    						<input type="button" value="Email" id="jqxButton" class="btn-primaryemail btn-cellemail"  onclick="popup('./popupEmailUser?user=${autoEmailDTOs.userId}&result=${result}&reserveId=${autoEmailDTOs.testCaseId}','Un-Reserve Request','popup','popupOverlay','550');"/>
    				  </td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tdmPolicyClaimSearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">

                    <form:hidden path="autoEmailDTOs[${status.index}].userId" />
                    <form:hidden path="autoEmailDTOs[${status.index}].testCaseId" />
                    <form:hidden path="autoEmailDTOs[${status.index}].testCaseName" />
                  
                  </c:forEach>
                
	              </tbody>
	            </table>
	            
	            
	    				         <%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%> 
	            
	            
	           				 <!-- Pagination Starts -->
    							<ul class="grdPagination">
			                  			<%
			                  				int noOfPages = (Integer) request.getAttribute("noOfPages");
			                  				int startPage = (Integer) request.getAttribute("startPage");
			                  				int lastPage = (Integer) request.getAttribute("lastPage");
			                  		  
											if (currentPage != 1) {
			   							%>
			   									<li><a href="claimSearch?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="claimSearch?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="claimSearch?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="claimSearch?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
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
			    										<li><a href="claimSearch?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="claimSearch?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="claimSearch?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="claimSearch?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="claimSearch?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->
							
	       
	          </c:if>
	          
	          <c:if test="${tdmPolicyClaimSearchDTO.autoEmailDTOs eq null && empty tdmPolicyClaimSearchDTO.autoEmailDTOs}">
	          
	            <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.noRec"/></td>
	                </tr>
	                
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.email.l1l2"/> 
	               		<input type="button" value="Email"  class="btn-primaryemail btn-cellemail" onclick="popup('./popupEmail?result=${result}','L1/L2 Support','popup','popupOverlay','550');" />
                      </td>
	                </tr>
	              </tbody>
	            </table>
	       
	          </c:if>
	       
	          </c:if>
	        </c:if>
	        
	        
	         <c:if test="${tdmPolicyClaimSearchDTO.tdmClaimSearchResultDTOs eq null}">
             <c:if test="${reserveFlag ne null}">
	            <table class="my-msg-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${reserveFlag}</td>
	                 
	                </tr>
	              </tbody>
	            </table>
	           </c:if> 
           </c:if> 

          <c:if test="${tdmPolicyClaimSearchDTO.tdmClaimSearchResultDTOs ne null &&  not empty tdmPolicyClaimSearchDTO.tdmClaimSearchResultDTOs}">
								<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%> 
            
            <table style="width:100%; border:0; font-size: 12px; font-style: italic; color:#7C6DC2; cellpadding:4;">
              <tbody>
                <tr>
                  <td class="lable-title" align="left" valign="middle"> ${result}</td>
                 
                </tr>
              </tbody>
            </table>
            
            <table style="width:100%; border:0; font-size: 12px; font-style: italic; color:#7C6DC2; cellpadding:4;">
              <tbody>
                <tr>
                  <td class="lable-title" align="right" valign="middle"><spring:message code="label.totRecFetc" />${totalRecords}</td>
                </tr>
              </tbody>
            </table>
            
            
            <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td class="lable-title" align="left" valign="middle"> <spring:message code="label.tcId" /></td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input path="testCaseId" id="testCaseId" class="down-control-small mandetCls1" />
                  </td>
                  <td class="lable-title" align="left" valign="middle"> <spring:message code="label.tcName" /></td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input path="testCaseName" id="testCaseName" class="down-control-small mandetCls2" />
                  </td>
                </tr>
              </tbody>
            </table>
            
              <c:if test="${reserveFlag ne null}">
	            <table class="my-msg-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${reserveFlag}</td>
	                
	                </tr>
	              </tbody>
	            </table>
	           </c:if> 



            <div class="scrollingX"  id="myid" >
              <table id="search_output_table" class="table tablesorter" style="width:100%;font-size: 13px;border:0; cellpadding:0; cellspacing:1">
                <thead>
                  <tr>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="lebel.chkb"/></th>
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.claim.claimNo" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.policyNo" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.insuPer" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.ClaimSts" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.srcSys" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.lossDt" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.amtTotPaid" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.amtNetInc" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.claim.lob" /></th>
                    
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${tdmPolicyClaimSearchDTO.tdmClaimSearchResultDTOs}" var="tdmClaimSearchResultDTOs" varStatus="status">
                    <tr>
                      <c:if test="${tdmClaimSearchResultDTOs.reservedYN eq null }">
                        <td>
                          <label class="checkbox-inline">
                            <form:checkbox path="tdmClaimSearchResultDTOs[${status.index}].reservedYN" id="tdmClaimSearchResultDTOs[${status.index}].reservedYN" class="cb_class checkBoxCls" value="Yes" />
                          </label>
                        </td>
                      </c:if>

                      <td>${tdmClaimSearchResultDTOs.claimNo}</td>
                      <td>${tdmClaimSearchResultDTOs.policyNo}</td>
                      <td>${tdmClaimSearchResultDTOs.primInsuPerson}</td>
                      <td>${tdmClaimSearchResultDTOs.claimStats}</td>
                      <td>${tdmClaimSearchResultDTOs.sourceSystem}</td>
                      <td>${tdmClaimSearchResultDTOs.lossDate}</td>
                      <td align="right">${tdmClaimSearchResultDTOs.amtTotPaid}</td>
                      <td align="right">${tdmClaimSearchResultDTOs.amtNetInc}</td>
                      <td>${tdmClaimSearchResultDTOs.lob}</td> 
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tdmPolicyClaimSearchDTO.tdmClaimSearchResultDTOs}" var="tdmClaimSearchResultDTOs" varStatus="status">
					<form:hidden path="tdmClaimSearchResultDTOs[${status.index}].claimId" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].claimNo" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].policyNo" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].primInsuPerson" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].claimStats" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].sourceSystem" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].lossDate" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].amtTotPaid" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].amtNetInc" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].lob" /> 
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].testCaseId" />
                    <form:hidden path="tdmClaimSearchResultDTOs[${status.index}].testCaseName" />
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
			   									<li><a href="claimSearch?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="claimSearch?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="claimSearch?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="claimSearch?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
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
			    										<li><a href="claimSearch?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="claimSearch?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="claimSearch?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="claimSearch?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="claimSearch?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->
            <br>
            <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col">
                      <input type="submit" name="reserve" class="btn-primary btn-cell" id="reserve" value="Reserve">
                      <input type="submit" name="export" id="export" class="btn-primary btn-cell" value="Export to Excel">
                  </th>
                </tr>
              </tbody>
            </table>
             
          </c:if>
       
        </form:form>
      </div>
    <script src="include/footer.js"></script>
  </div>
   
 <script>
  menu_highlight('Claim_Search');
  
  $("#search_output_table").tablesorter({
	    widgets: ['zebra']
  });
	  
  //claimSearchFormValidation();
  
  $(".table tr:odd").css('background-color','#ffffff');
  $(".table tr:even").addClass('even');

  window.location.hash = "myid";
	 
  $(document).ready(function() {
	 	$('.cb_class').on('change', function (e) {
	 	    if ($('.cb_class:checked').length > 5) {
		        $(this).prop('checked', false);
		        jAlert('Maximum 5 records allowed per search to reserve', ' OK ');
		    }
		});
	});

  $(function() {
	    $( ".from" ).datepicker({
	      defaultDate: "+1w",
	      changeMonth: true,
	      numberOfMonths: 1,
	      onClose: function( selectedDate ) {
	        $( ".to" ).datepicker( "option", "minDate", selectedDate );
	      }
	    });
	    $( ".to" ).datepicker({
	      defaultDate: "+1w",
	      changeMonth: true,
	      numberOfMonths: 1,
	      onClose: function( selectedDate ) {
	        $( ".from" ).datepicker( "option", "maxDate", selectedDate );
	      }
	    });
	  }); 
 
  
  $(document).ready(function() {
	    $("#export").click(function(){
	       	$('#search_output_table').next(".my-error-class").remove(); 
     	 var checkboxes = $('.checkBoxCls');
	      	 var selected = checkboxes.filter(":checked").length;
	    	  if (selected == false) {
	    		  $('#search_output_table').after('<div class="my-error-class">There is no selection of the records from Search Result</div>');
	    		  return false;
	      	    }
	  	  });  
	     
	  });
  
  $(document).ready(function() {
	    $("#reserve").click(function(){
	    	$('.mandetCls1').next(".my-error-class").remove(); 
	    	$('.mandetCls2').next(".my-error-class").remove(); 
	    	$('#search_output_table').next(".my-error-class").remove(); 
	    	var checkboxes = $('.checkBoxCls');
	      	  var selected = checkboxes.filter(":checked").length;
	    	    if (selected == false) {
	    		  $('#search_output_table').after('<div class="my-error-class">There is no selection of the records from Search Result</div>');
	    		  return false;
	      	    }
	        	if($('.mandetCls1').val()==''){
	        	  $('.mandetCls1').after('<div class="my-error-class">This field is required.</div>');
	        	  return false;
	        	}
	        	if($('.mandetCls2').val()==''){
	        	  $('.mandetCls2').after('<div class="my-error-class">This field is required.</div>');
	        	  return false;
	        	} 
	        	  
	         });  
	  });
  
  </script>
</body>
</html>
 