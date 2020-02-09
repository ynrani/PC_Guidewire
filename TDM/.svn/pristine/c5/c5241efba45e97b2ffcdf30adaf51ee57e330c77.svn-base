<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title> TDM Central | Claim Search</title>
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
    <jsp:include page="header.jsp"></jsp:include>
    <script src="include/menu.js"></script>
       <div id="tabs-2" class="container">
        <c:if test="${error ne null}">
	            <table class="my-error-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${error}</td>	                
	                </tr>
	              </tbody>
	            </table>
	           </c:if>           
        <form:form id="testDataFormClaim" name="testDataFormClaim" class="testval" action="${pageContext.request.contextPath}/testdaClaimUser" modelAttribute="tDMClaimSearchDTO">
          <table style="width:100%; border:0; font-size: 13px;cellpadding:4;">
            <tbody>
              <tr>
                <td class="lable-title" width="35%" align="left" valign="middle"><spring:message code="label.env"/><span>*</span> </td>
                <td class="flied-title" width="20%" align="left" valign="middle">
                <form:select path="envType" id="envType" class="down-control">
                  	<form:option value="">--Select--</form:option>
                    <form:option value="TST 1">TST 1</form:option>
                    <form:option value="Dev Region 1">Dev Region 1</form:option>
                    <form:option value="Dev Region 2">Dev Region 2</form:option>
                    <form:option value="Pre-Prod 1">Pre-Prod 1</form:option>
                    <form:option value="Pre-Prod 2">Pre-Prod 2</form:option>
                  </form:select>
                </td>
                <td class="lable-title" width="25%" align="left" valign="middle">
                <td class="lable-title" width="20%" align="left" valign="middle" scope="col">
              </tr>
              <tr>
              	<td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.dx.code"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="claimDXCode" id="claimdxCode" class="form-control" maxlength="21"/>
                </td>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.proc.code"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="claimProcCode" id="claimProcCode" class="form-control" maxlength="21" />
                </td>
               </tr>
              <tr>
                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.modifier"/></td>
	              <td class="flied-title" align="left" valign="middle">
	                  <form:input path="claimModifier" id="claimModifier" class="form-control" maxlength="10" />
	              </td>  
	             <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.source"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:select path="claimSource" id="claimSource" class="down-control">
                  		<form:option value="">All</form:option>
                    	<c:forEach items="${tDMClaimSearchDTO.tdmClaimSrcDTOs}" var="tdmClaimSrcDTOs">
							<form:option value="${tdmClaimSrcDTOs.claimSrcDesc}">${tdmClaimSrcDTOs.claimSrcDesc}</form:option>
						</c:forEach>
                  </form:select>
                </td>
              </tr>
               <tr>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.claimProviderTIN"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="claimProviderTIN" id="claimProviderTIN" class="form-control" maxlength="10" />
                </td>              
              	<td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.provider.NPI"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="claimProviderNPI" id="claimProviderNPI" class="form-control" maxlength="11" />
                </td>
              </tr>
              <tr>
              <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.claim.pos"/></td>
              <td class="flied-title" align="left" valign="middle" scope="col">
                 <form:select path="claimPOS" id="claimPOS" class="down-control">
                 	 	<form:option value="">All</form:option>
                  	    <c:forEach items="${tDMClaimSearchDTO.tdmClaimPOSMastDTOs}" var="tdmClaimPOSMastDTOs">
				        <form:option value="${tdmClaimPOSMastDTOs.claimPOSDesc}">${tdmClaimPOSMastDTOs.claimPOSDesc}</form:option>
				    </c:forEach>
   		      </form:select>
              </td>  
              <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.claim.type"/></td>
              <td class="flied-title" align="left" valign="middle" scope="col">
                  <form:select path="claimType" id="claimType" class="down-control">
                  	 	<form:option value="">All</form:option>
                   	    <c:forEach items="${tDMClaimSearchDTO.tdmClaimTypeMastDTOs}" var="tdmClaimTypeMastDTOs">
					        <form:option value="${tdmClaimTypeMastDTOs.claimTypeDesc}">${tdmClaimTypeMastDTOs.claimTypeDesc}</form:option>
					    </c:forEach>
    		      </form:select>
              </td>
              </tr>  
              <tr> 
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.status"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:select path="claimStatus" id="claimStatus" class="down-control">
                 	<form:option value="">All</form:option>
                    <c:forEach items="${tDMClaimSearchDTO.tdmClaimStatusMastDTOs}" var="tdmClaimStatusMastDTOs">
						<form:option value="${tdmClaimStatusMastDTOs.claimStatusDesc}">${tdmClaimStatusMastDTOs.claimStatusDesc}</form:option>
				    </c:forEach>
                  </form:select>
                </td>
               <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.groupnum"/></td>
               <td class="flied-title" align="left" valign="middle">
                  <form:input path="claimGrpNum" id="claimGrpNum" class="form-control" maxlength="21" />
               </td>
              </tr>
              <tr>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.typOfService"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="claimServiceType" id="claimServiceType" class="form-control" />
                </td>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.gender"/></td>
                <td class="flied-title" align="left" valign="middle" scope="col">
                  <label class="radio-inline">
                    <form:radiobutton path="claimGender" id="claimGender" value="Male" /><spring:message code="label.male"/></label>
                  <label class="radio-inline">
                    <form:radiobutton path="claimGender" id="claimGender" value="Female" /><spring:message code="label.female"/>
                  </label>
                  <label class="radio-inline">
                      <form:radiobutton path="claimGender" id="gender" value="Both" /><spring:message code="label.both" />
                    </label>
                </td>
              </tr>
                           
          </tbody>
         
        
           <tbody id="disOnFacilityClaimType">
                <tr>
	              <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.revenueCode"/></td>
	              <td class="flied-title" align="left" valign="middle">
	                  <form:input path="claimRevCode" id="claimRevCode" class="form-control" maxlength="21" />
	              </td>
	              <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.typeOfBill"/></td>
                  <td class="flied-title" align="left" valign="middle">
                  <form:select path="typeOfBill" id="typeOfBill" class="down-control">
                 	<form:option value="">All</form:option>
                    <c:forEach items="${tDMClaimSearchDTO.tdmClaimTypeOfBillsMastDTOs}" var="tdmClaimTypeOfBillsMastDTOs">
						<form:option value="${tdmClaimTypeOfBillsMastDTOs.claimTypeOfBillDesc}">${tdmClaimTypeOfBillsMastDTOs.claimTypeOfBillDesc}</form:option>
				    </c:forEach>
                  </form:select>
                </td> 
	            </tr>
	            <tr>
	               <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.admissiondt"/></td>
	               <td class="flied-title" align="left" valign="middle">
	                 <form:input path="admissiondt" id="admissiondt" class="datepicker date-control" />
	               </td>
	               <td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.dischargedt"/></td>
	               <td class="flied-title" align="left" valign="middle">
	                 <form:input path="dischargedt" id="dischargedt" class="datepicker date-control" />
	               </td>
               </tr> 
            </tbody>  
             
         
          <tbody id="myContent">
             <tr>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.claim.COB"/></td>
                <td class="flied-title" class="flied-title" align="left" valign="middle">
                  <label class="checkbox-inline">
                    <form:checkbox path="claimWithCOB" id="claimWithCOB" value="C" />
                  </label>
                </td>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.claim.auth"/></td>
                <td class="flied-title" class="flied-title" align="left" valign="middle">
                  <label class="checkbox-inline">
                    <form:checkbox path="claimAuthOn" id="claimAuthOn" value="C" />
                  </label>
                </td>
              </tr>
              <tr>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.claim.REF"/></td>
                <td class="flied-title" class="flied-title" align="left" valign="middle">
                  <label class="checkbox-inline">
                    <form:checkbox path="claimRefOn" id="claimRefOn" value="C" />
                  </label>
                </td>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.claim.interest"/></td>
                <td class="flied-title" class="flied-title" align="left" valign="middle">
                  <label class="checkbox-inline">
                    <form:checkbox path="claimIntOn" id="claimIntOn" value="C" />
                  </label>
                </td>
              </tr>
              <tr>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.subc.subcId"/></td>
                <td class="flied-title" align="left" valign="middle" scope="col">
                  <form:input path="subscriberId" id="subscriberId" class="form-control" maxlength="51"/>
                </td>              
              	<td class="lable-title" align="left" valign="middle"><spring:message code="label.claim.rcptdt"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="rcptdt" id="rcptdt" class="datepicker date-control" />
                </td>
              </tr>
              <tr>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.claim.claimId"/></td>
                 <td class="flied-title" align="left" valign="middle" scope="col">
                 <form:input path="claimId" id="claimId" class="form-control" maxlength="21"/>
               </td>
               <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.claim.statusCode"/></td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                 	 <form:input path="statusCode" id="statusCode" class="form-control" maxlength="21" />
                  </td> 
               </tr> 
          </tbody>  
                      
          <tbody id="headerDiv">
              <tr>
                <td align="left" valign="middle"></td>
                <td align="left" valign="middle"></td>
                <td align="left" valign="middle"></td>
                <td class="lable-title" align="right" valign="middle">
                  <a id="myHeader" href="javascript:toggle2('myContent','myHeader');"><spring:message code="label.showLink"/></a>
                </td>
             </tr>          
           </tbody>
        
        	 <tr>
              <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.noOfRec"/></td>
              <td class="flied-title" align="left" valign="middle">
                <form:select path="searchRecordsNo" id="searchRecordsNo" class="down-control-small">
                  <form:option value="5">5</form:option>
                  <form:option value="10">10</form:option>
                  <form:option value="15">15</form:option>
                  <form:option value="20">20</form:option>
                </form:select>
              </td>
            </tr>
            
        </table>   
          
    <table style="width:100%; border:0; cellpadding:4;">
            <tbody>
              <tr>
                <td colspan="4" align="center" valign="middle" class="buttonsAll8">
                  <input type="submit" name="search" id="Search" value="Search">
                  <input type="reset" value="Reset" onClick="clearFields('./testdaClaimUser');">                  
              
                </td>
              </tr>
            </tbody>
     </table>
      <br>
 		<c:if test="${tDMClaimSearchDTO.tDMClaimSearchResultListDTOs eq null}">
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
	         
             <c:if test="${tDMClaimSearchDTO.autoEmailDTOs ne null && empty tDMClaimSearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          
	          <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.recFndByyou" /></td>
	                 
	                </tr>
	              </tbody>
	            </table>
	          
	          
	          </c:if>
	          
	            <c:if test="${tDMClaimSearchDTO.autoEmailDTOs ne null &&  not empty tDMClaimSearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          
	          
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
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.email"/></th>
                    </tr>
                   </thead>
	              <tbody>
                  <c:forEach items="${tDMClaimSearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">
                    <tr>
                      <td>${autoEmailDTOs.userId}</td>
                      <td>${autoEmailDTOs.testCaseId}</td>
                      <td>${autoEmailDTOs.testCaseName}</td>
                      <td  class="buttonsAll8">
    						<input type="button" value="Email" id="jqxButton" onclick="popup('./popupEmailUser?user=${autoEmailDTOs.userId}&result=${result}&reserveId=${autoEmailDTOs.testCaseId}','Un-Reserve Request','popup','popupOverlay','550');"/>
    				  </td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tDMClaimSearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">

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
			   									<li><a href="testdaClaimUser?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="testdaClaimUser?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="testdaClaimUser?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="testdaClaimUser?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
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
			    										<li><a href="testdaClaimUser?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="testdaClaimUser?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="testdaClaimUser?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="testdaClaimUser?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="testdaClaimUser?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->
	       
	          </c:if>
	          
	          <c:if test="${tDMClaimSearchDTO.autoEmailDTOs eq null && empty tDMClaimSearchDTO.autoEmailDTOs}">
	          
	            <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.noRec"/></td>
	                </tr>
	                
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"  class="buttonsAll8"><spring:message code="label.email.l1l2"/> 
	               		<input type="button" value="Email" id="jqxButton" onclick="popup('./popupEmail?result=${result}','L1/L2 Support','popup','popupOverlay','550');"/>
                      </td>
	                </tr>
	              </tbody>
	            </table>
	       
	          </c:if>
            </c:if>
           </c:if>
           
           
           <c:if test="${tDMClaimSearchDTO.tDMClaimSearchResultListDTOs eq null}">
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
           
            
          <c:if test="${tDMClaimSearchDTO.tDMClaimSearchResultListDTOs ne null &&  not empty tDMClaimSearchDTO.tDMClaimSearchResultListDTOs}">
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
            					
			<div>				
            <table  style="width:100%; border:0; font-size: 12px;; cellpadding:4; align:center;">
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
            </div>	
           <div>	 
             <c:if test="${reserveFlag ne null}">
	            <table class="my-msg-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${reserveFlag}</td>
	                 
	                </tr>
	              </tbody>
	            </table>
	           </c:if> 
             </div>	
            <div class="scrollingX" id="myid">
              <table id="search_output_table" class="table tablesorter"  style="width:100%; border:0; cellpadding:0; cellspacing:1">
                <thead>
                  <tr>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="lebel.chkb"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.claimId"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.type"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.patientFirstName"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.patientLastName"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.patientId"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.status"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.dx.code"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.proc.code"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.modifier"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.revenueCode"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.source"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.pos"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.typOfService"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.claimProviderTIN"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.provider.NPI"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.rcptdt"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.gender"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.statusCode"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.groupnum"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.totalCharge"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.totalAllowed"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.totalPaid"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.deductible"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.copay"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.coins"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.admissiondt"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.dischargedt"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.claim.typeOfBill"/></th>
                 </tr>
                </thead>
                <tbody>
                  <c:forEach items="${tDMClaimSearchResultListDTOs}" var="tDMClaimSearchResultListDTOs" varStatus="status">
                    <tr>
                      <c:if test="${tDMClaimSearchResultListDTOs.reservedYN eq null }">
                        <td>
                          <form:checkbox path="tDMClaimSearchResultListDTOs[${status.index}].reservedYN" id="tDMClaimSearchResultListDTOs[${status.index}].reservedYN" class="cb_class checkBoxCls" value="Yes" />
                        </td>
                      </c:if>
                      
                    <%--    <c:if test="${tDMClaimSearchResultListDTOs.reservedYN ne null }">
                        <td>
                         <form:checkbox path="tDMClaimSearchResultListDTOs[${status.index}].reservedYN" id="tDMClaimSearchResultListDTOs[${status.index}].reservedYN" class="cb_class checkBoxCls" value="Yes" disabled="true" />
                        </td>
                        <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].reservedYN" />
                      </c:if>  --%>
                      
                      <td>${tDMClaimSearchResultListDTOs.claimId}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimType}</td>
                      <td>${tDMClaimSearchResultListDTOs.patientFirstName}</td>
                      <td>${tDMClaimSearchResultListDTOs.patientLastName}</td>
                      <td>${tDMClaimSearchResultListDTOs.patientId}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimStatus}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimDXCode}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimProcCode}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimModifier}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimRevCode}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimSource}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimPOS}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimServiceType}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimProviderTIN}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimProviderNPI}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimReceiptDate}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimPatientGender}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimStatusCode}</td>
                      <td>${tDMClaimSearchResultListDTOs.claimGrpNum}</td>
                      <td>${tDMClaimSearchResultListDTOs.totalCharge}</td>
                      <td>${tDMClaimSearchResultListDTOs.totalAllowed}</td>
                      <td>${tDMClaimSearchResultListDTOs.totalPaid}</td>
                      <td>${tDMClaimSearchResultListDTOs.deductible}</td>
                      <td>${tDMClaimSearchResultListDTOs.copay}</td>
                      <td>${tDMClaimSearchResultListDTOs.coins}</td>
                      <td>${tDMClaimSearchResultListDTOs.admissionDate}</td>
                      <td>${tDMClaimSearchResultListDTOs.dischargeDate}</td>
                      <td>${tDMClaimSearchResultListDTOs.typeofBill}</td> 
                   </tr>
                  </c:forEach>
                </tbody>
                <c:forEach items="${tDMClaimSearchDTO.tDMClaimSearchResultListDTOs}" var="tDMClaimSearchResultListDTOs" varStatus="status">
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimId" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimType" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].patientFirstName" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].patientLastName" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].patientId" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimStatus" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimDXCode" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimProcCode" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimModifier" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimRevCode" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimSource" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimPOS" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimServiceType" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimProviderTIN" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimReceiptDate" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimPatientGender" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].claimGrpNum" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].totalCharge" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].totalAllowed" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].totalPaid" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].deductible" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].copay" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].coins" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].admissionDate" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].dischargeDate" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].typeofBill" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].testCaseId" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].testCaseName" />
                  <form:hidden path="tDMClaimSearchResultListDTOs[${status.index}].userId" />
               </c:forEach>
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
			   									<li><a href="testdaClaimUser?page=<%= 1 %>" onClick="showLoading();">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="testdaClaimUser?page=<%= currentPage-1 %>" onClick="showLoading();">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="testdaClaimUser?page=<%= 1 %>" onClick="showLoading();">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="testdaClaimUser?page=<%= currentPage-1 %>" onClick="showLoading();">&lt;</a><div>&lt;</div>
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
			    										<li><a href="testdaClaimUser?page=<%= i %>" id="employeeLink" onClick="showLoading();"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="testdaClaimUser?page=<%= currentPage+1 %>" onClick="showLoading();">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="testdaClaimUser?page=<%= noOfPages %>" onClick="showLoading();">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="testdaClaimUser?page=<%= currentPage+1 %>" onClick="showLoading();">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="testdaClaimUser?page=<%= noOfPages %>" onClick="showLoading();">&gt;&gt;</a><div>&gt;&gt;</div></li>
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
                  <th scope="col" class="buttonsAll15">
                      <input type="submit" name="reserve" id="reserve" value="Reserve">
                      <input type="submit" name="export" id="export" value="Export to Excel">
                   </th>
                </tr>
              </tbody>
            </table>
          </c:if>
        </form:form>
        <div class="pageloading"></div>
      </div>
    <script src="include/footer.js"></script>  
  </div>
  
  <script src="include/copyrtfooter.js"></script>

  <script>
  menu_highlight('Claim_Search');
  menu_highlight('services');
  menu_highlight('services_ftd');
  menu_highlight('services_ftd_insu');
  menu_highlight('services_ftd_insu_health');
  menu_highlight('services_ftd_insu_health_ftd');
 
  
   $(document).ready(function() {
	  $('#claimType').change(function() {
	        var selectedValue = $(this).val();
	        if(selectedValue=='Facility'){
	        	$("#disOnFacilityClaimType").show();	
	        } 
	        else{
	        	$("#disOnFacilityClaimType").hide();
	        }
	    });

	 var selectedValue = $('#claimType').val();
        if(selectedValue=='Facility'){
        	$("#disOnFacilityClaimType").show();	
        } 
        else{
        	$("#disOnFacilityClaimType").hide();	
        }
	});  
	
	
  claimSearchValidation();
  
  function showLoading(){
	  $("body").addClass("loading"); 
  } 
   

  $(document).ready(function () {
    var showHide = '${tDMClaimSearchDTO.showHideFlag}';
    if (showHide == 'true') {
      toggle2('myContent', 'myHeader');
    }
  });
 
  $(function() {
	    $( ".datepicker" ).datepicker({
	      defaultDate: "+1w",
	      changeMonth: true,
	      numberOfMonths: 1,
	    });
 });
  
  $("#myContent").css("display", "none"); 
  $("#search_output_table").tablesorter({
    widgets: ['zebra']
  });
  $(".table tr:odd").css('background-color', '#ffffff');
  $(".table tr:even").addClass('even');
  $(function () {
    $('[placeholder]').focus(function () {
      var input = $(this);
      if (input.val() == input.attr('placeholder')) {
        input.val('');
        input.removeClass('placeholder');
      }
    }).blur(function () {
      var input = $(this);
      if (input.val() == '' || input.val() == input.attr('placeholder')) {
        input.addClass('placeholder');
        input.val(input.attr('placeholder'));
      }
    }).blur().parents('form').submit(function () {
      $(this).find('[placeholder]').each(function () {
        var input = $(this);
        if (input.val() == input.attr('placeholder')) {
          input.val('');
        }
      })
    });
  });
  
 window.location.hash = "myid";
  
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
 	$('.cb_class').on('change', function (e) {
 	    if ($('.cb_class:checked').length > 5) {
	        $(this).prop('checked', false);
	        jAlert('Maximum 5 records allowed per search to reserve', ' OK ');
	    }
	});
});

</script>

</body>
</html>