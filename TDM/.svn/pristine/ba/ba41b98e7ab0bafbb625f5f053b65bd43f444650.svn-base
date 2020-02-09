<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title> TDM Central | Policy Search</title>
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
   <!--  <script src="include/header.js"></script> -->
   <jsp:include page="headerPC.jsp"></jsp:include>
    <script src="include/menuPC.js"></script>
      <div id="tabs-1" class="container">
        <form:form id="policySearchForm" name="policySearchForm" action="${pageContext.request.contextPath}/policySearch" modelAttribute="tdmPolicySearchDTO">
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
                   <spring:message code="label.policy.comp" />
                   
                    
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="company" id="company" class="down-control">
                       <form:option value="">All</form:option>
                        <form:option value="X_ Life Insurance Company (PERM)">X_ Life Insurance Company (PERM)</form:option>
                       <form:option value="Y_Life Insurance Company (TERM and ISWL)">Y_Life Insurance Company (TERM and ISWL)</form:option>
                       <form:option value="X_ Life and Annuity Company">X_ Life and Annuity Company</form:option>
                       <form:option value="Z_Life Insurance Company">Z_Life Insurance Company</form:option>
                      
                    </form:select>
                    <td class="lable-title" align="left" valign="middle" scope="col">
                   <spring:message code="label.policy.prodType" />
                    
                      
                    </td>
                    <td class="flied-title" align="left" valign="middle" scope="col">
                      <form:select path="productType" id="productType" class="down-control" >
                       <form:option value="">All</form:option>
                       <form:option value="Annuity">Annuity</form:option>
                       <form:option value="Group">Group</form:option>
                        <form:option value="Permanent">Permanent</form:option>
                       <form:option value="Term">Term</form:option>
                      </form:select>
                    </td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                   <spring:message code="label.policy.prodName" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="productName" id="productName" class="down-control">
                       <form:option value="">All</form:option>
                       <form:option value="ART_147">ART_147</form:option>
                       <form:option value="ART_149">ART_149</form:option>
                       <form:option value="ART_150">ART_150</form:option>
                       <form:option value="ART_151X">ART_151X</form:option>
                       <form:option value="Return of Premium Term 20_148">Return of Premium Term 20_148</form:option>
                       <form:option value="Return of Premium Term 25_148">Return of Premium Term 25_148</form:option>
                       <form:option value="TermOne">TermOne</form:option>
                       <form:option value="Accidental Death Coverage">Accidental Death Coverage</form:option>
                       <form:option value="Generic Term 150">Generic Term 150</form:option>
                       <form:option value="Permanent Plan Informal Phase 1">Permanent Plan Informal Phase 1</form:option>
                       <form:option value="Indexed Universal Life">Indexed Universal Life</form:option>
                       
                    </form:select>
                  </td>
                  <td class="lable-title" align="left" valign="middle">
                   <spring:message code="label.policy.poilcyNum" />
                    
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                     <form:input path="policyNo" id="policyNo" class="form-control" maxlength="21" />
                  </td>                  
                </tr>
                
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                  <spring:message code="label.policy.faceAmt" />
                     
                  </td>
                   <td class="flied-title" align="left" valign="middle">
                     <form:input path="faceAmt" id="faceAmt" class="form-control" maxlength="21" />
                  </td>    
                  <td class="lable-title" align="left" valign="middle" scope="col">
                   <spring:message code="label.policy.ssn" />
                   
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="ssn" id="ssn" class="form-control" maxlength="21" />
                  </td>
                </tr>
               
               <tr>
                  <td class="lable-title" align="left" valign="middle" scope="col">
                  <spring:message code="label.policy.insuFname" />
                     
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="insuFirstName" id="insuFirstName" class="form-control" maxlength="21" />
                  </td>
                   <td class="lable-title" align="left" valign="middle" scope="col">
                   <spring:message code="label.policy.insuLname" />
                      
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="insuLastName" id="insuLastName" class="form-control" maxlength="21" />
                  </td>
                 
                </tr>  
                 <tr> 
                 
                  <td class="lable-title" align="left" valign="middle" scope="col">
                  <spring:message code="label.gender" />
                    
                  </td>
                 <td class="flied-title" class="flied-title" align="left" valign="middle">
                    <label class="radio-inline">
                      <form:radiobutton path="gender" id="gender" value="Male" /><spring:message code="label.male" /></label>
                    <label class="radio-inline">
                      <form:radiobutton path="gender" id="gender" value="FeMale" /><spring:message code="label.female" />
                    </label>
                    <label class="radio-inline">
                      <form:radiobutton path="gender" id="gender" value="Both" /> Any
                    </label>
                  </td>
                
                  <td class="lable-title" align="left" valign="middle">
                  <spring:message code="label.policy.dob" />
                    
                  </td>
                   <td class="flied-title" align="left" valign="middle">
                     <form:input path="dob" id="dob" class="date-control datepicker from"  />
                  </td>   
                  
                  </tr>  
                 <tr> 
                  
                  <td class="lable-title" align="left" valign="middle" scope="col">
                  <spring:message code="label.policy.distChnl" />
                     
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="distChnl" id="distChnl" class="form-control " maxlength="21" />
                  </td>
                
                  <td class="lable-title" align="left" valign="middle">
                  <spring:message code="label.policy.agentId" />
                    
                  </td>
                   <td class="flied-title" align="left" valign="middle">
                     <form:input path="agntId" id="agntId" class="form-control" maxlength="21" />
                  </td>  
                  </tr>  
                
                 <tr> 
                   
                  <td class="lable-title" align="left" valign="middle" scope="col">
                  <spring:message code="label.policy.dateFrom" />
                    
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="fromDate" id="fromDate" class="date-control datepicker from" />
                  </td>
                  <td class="lable-title" align="left" valign="middle" scope="col">
                  <spring:message code="label.policy.dateTo" />
                
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="toDate" id="toDate" class="date-control datepicker to" />
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
                  <td colspan="4" align="center" valign="middle" class="buttonsAll8">
                   <input type="submit" name="search" id="Search" value="<spring:message code="button.serch"/>">
                    <input type="reset" value="Reset" onClick="clearFields('./policySearch');"/>
                  </td>
                </tr>
              </tbody>
            </table>

          </div>
          <br/>
          <br/>
          
          
             <c:if test="${tdmPolicySearchDTO.tdmPolicySearchResultDTOs eq null}">
            
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
	          
	          <c:if test="${tdmPolicySearchDTO.autoEmailDTOs ne null && empty tdmPolicySearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          
	          <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.recFndByyou" /></td>
	                 
	                </tr>
	              </tbody>
	            </table>
	          
	          
	          </c:if>
	          
	          <c:if test="${tdmPolicySearchDTO.autoEmailDTOs ne null &&  not empty tdmPolicySearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          
	          
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
                  <c:forEach items="${tdmPolicySearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">
                    <tr>
                      <td>${autoEmailDTOs.userId}</td>
                      <td>${autoEmailDTOs.testCaseId}</td>
                      <td>${autoEmailDTOs.testCaseName}</td>
                      <td class="buttonsAll8">
    						<input type="button" value="Email" id="jqxButton" onclick="popup('./popupEmailUser?user=${autoEmailDTOs.userId}&result=${result}&reserveId=${autoEmailDTOs.testCaseId}','Un-Reserve Request','popup','popupOverlay','550');"/>
    				  </td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tdmPolicySearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">

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
			   									<li><a href="policySearch?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="policySearch?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="policySearch?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="policySearch?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
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
			    										<li><a href="policySearch?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="policySearch?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="policySearch?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="policySearch?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="policySearch?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->
							
	       
	          </c:if>
	          
	          <c:if test="${tdmPolicySearchDTO.autoEmailDTOs eq null && empty tdmPolicySearchDTO.autoEmailDTOs}">
	          
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
	        
	        
	         <c:if test="${tdmPolicySearchDTO.tdmPolicySearchResultDTOs eq null}">
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

          <c:if test="${tdmPolicySearchDTO.tdmPolicySearchResultDTOs ne null &&  not empty tdmPolicySearchDTO.tdmPolicySearchResultDTOs}">
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
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.policyNo" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.comp" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.prodName" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.faceAmt" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.insuFname" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.insuLname" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.ssn" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.gender" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.dob" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.distChnl" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.agentId" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont">Riders</th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont">Benefits</th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont">Owner</th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont">Beneficiary</th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont">Payment Mode</th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont">Payment Method</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${tdmPolicySearchDTO.tdmPolicySearchResultDTOs}" var="tdmPolicySearchResultDTOs" varStatus="status">
                    <tr>
                      <c:if test="${tdmPolicySearchResultDTOs.reservedYN eq null }">
                        <td>
                          <label class="checkbox-inline">
                            <form:checkbox path="tdmPolicySearchResultDTOs[${status.index}].reservedYN" id="tdmPolicySearchResultDTOs[${status.index}].reservedYN" class="cb_class checkBoxCls" value="Yes" />
                          </label>
                        </td>
                      </c:if>

                      <td>${tdmPolicySearchResultDTOs.policyNo}</td>
                      <td>${tdmPolicySearchResultDTOs.companyName}</td>
                      <td>${tdmPolicySearchResultDTOs.productName}</td>
                      <td align="right">${tdmPolicySearchResultDTOs.faceAmt}</td>
                      <td>${tdmPolicySearchResultDTOs.fristName}</td>
                      <td>${tdmPolicySearchResultDTOs.lastName}</td>
                      <td>${tdmPolicySearchResultDTOs.ssn}</td>
                      <td>${tdmPolicySearchResultDTOs.gender}</td>
                      <td>${tdmPolicySearchResultDTOs.dob}</td>
                      
                      <td>${tdmPolicySearchResultDTOs.distChnal}</td>
                      <td>${tdmPolicySearchResultDTOs.agentId}</td>
                      <td>${tdmPolicySearchResultDTOs.riders}</td>
                      <td>${tdmPolicySearchResultDTOs.benefits}</td>
                      <td>${tdmPolicySearchResultDTOs.owner}</td>
                      <td>${tdmPolicySearchResultDTOs.beneficiary}</td>
                      <td>${tdmPolicySearchResultDTOs.paymentMethod}</td>
                      <td>${tdmPolicySearchResultDTOs.paymentMode}</td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tdmPolicySearchDTO.tdmPolicySearchResultDTOs}" var="tdmPolicySearchResultDTOs" varStatus="status">

					<form:hidden path="tdmPolicySearchResultDTOs[${status.index}].policyNo" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].productName" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].companyName" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].faceAmt" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].productType" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].fristName" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].lastName" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].ssn" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].gender" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].dob" /> 
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].distChnal" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].agentId" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].riders" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].benefits" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].owner" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].beneficiary" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].paymentMethod" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].paymentMode" />
                    
                    
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].testCaseId" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].testCaseName" />
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
			   									<li><a href="policySearch?page=<%= 1 %>"  onClick="showLoading();">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="policySearch?page=<%= currentPage-1 %>"  onClick="showLoading();">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="policySearch?page=<%= 1 %>"  onClick="showLoading();">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="policySearch?page=<%= currentPage-1 %>"  onClick="showLoading();">&lt;</a><div>&lt;</div>
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
			    										<li><a href="policySearch?page=<%= i %>" id="employeeLink"  onClick="showLoading();"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="policySearch?page=<%= currentPage+1 %>"  onClick="showLoading();">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="policySearch?page=<%= noOfPages %>"  onClick="showLoading();">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="policySearch?page=<%= currentPage+1 %>"  onClick="showLoading();">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="policySearch?page=<%= noOfPages %>"  onClick="showLoading();">&gt;&gt;</a><div>&gt;&gt;</div></li>
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
                      <input type="submit" name="reserve"  id="reserve" value="Reserve">
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
 $body = $("body");
 
 menu_highlight('Policy_Search');
 menu_highlight('services');
 menu_highlight('services_ftd_insu');
 menu_highlight('services_ftd_insu_pc');
 menu_highlight('services_ftd_insu_pc_ftd');
 
 $body.removeClass("loading");
 
 function showLoading(){
	  $body.addClass("loading"); 
 } 
  
  //policySearchFormValidation();
  	$("#search_output_table").tablesorter({
	    widgets: ['zebra']
	  });
	  
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
	 
  </script>
</body>
</html>
 