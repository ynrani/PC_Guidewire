<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title> TDM Central | Provider Search</title>
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
   <jsp:include page="header.jsp"></jsp:include>
    <script src="include/menu.js"></script>
      <div id="tabs-1" class="container">
       <c:if test="${error ne null}">
	            <table class="my-error-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${error}</td>	                
	                </tr>
	              </tbody>
	            </table>
	           </c:if>           
        <form:form id="testDataForm" name="testDataForm" action="${pageContext.request.contextPath}/testdaUser" modelAttribute="tDMProvSearchDTO">
          <div class="">
            <input type="hidden" name="userId" value="${sessionScope.userId}" />
            <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td class="lable-title" width="35%" align="left" valign="middle"><spring:message code="label.env" /><span>*</span></td>
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
                  <td class="lable-title" width="25%" align="left" valign="middle"></td>
                  <td class="lable-title" width="20%" align="left" valign="middle" scope="col"></td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.type" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="provType" id="provType" class="down-control">
                    	<form:option value="">All</form:option>
                   	    <c:forEach items="${tDMProvSearchDTO.tdmProviderTypeParentDTOs}" var="tdmProviderTypeParentDTOs">
					        <form:option value="${tdmProviderTypeParentDTOs.providerTypeName}">${tdmProviderTypeParentDTOs.providerTypeName}</form:option>
					    </c:forEach>
                    </form:select>
                    <td class="lable-title" align="left" valign="middle" scope="col">
                      <spring:message code="label.prov.cat" />
                    </td>
                    <td class="flied-title" align="left" valign="middle" scope="col">
                      <form:select path="provCatgType" id="provCatgType" class="down-control" >
                      <form:option value="">All</form:option>
                       <c:forEach items="${tDMProvSearchDTO.tdmProviderCatParentDTOs}" var="tdmProviderCatParentDTOs">
					        <form:option value="${tdmProviderCatParentDTOs.providerCategoryName}">${tdmProviderCatParentDTOs.providerCategoryName}</form:option>
					    </c:forEach>
                      </form:select>
                    </td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.spec" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="provSpecType" id="provSpecType"  multiple="true" class="down-control">
                      <form:option value="">All</form:option>
                       <c:forEach items="${tDMProvSearchDTO.specDropdown}" var="specDropdown">
					        <form:option value="${specDropdown}">${specDropdown}</form:option>
					    </c:forEach> 
                    </form:select>
                  </td>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.state" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="provState" id="provState"  multiple="true" class="down-control">
                      <form:option value="">All</form:option>
                      <c:forEach items="${tDMProvSearchDTO.tdmUsStateDTOs}" var="tdmUsStateDTOs">
					     <form:option value="${tdmUsStateDTOs.stateName}">${tdmUsStateDTOs.stateName}</form:option>
					  </c:forEach>
                    </form:select>
                  </td>                  
                </tr>
              
              <tr>
                  <td class="flied-title" align="left">
                    <spring:message code="label.prov.atypical" />
                  </td>
                  <td class="flied-title">
                    <label class="checkbox-inline">
                      <form:checkbox path="provTypicalYn" id="provTypicalYn" value="Yes" />
                    </label>
                  </td>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.eft" />
                  </td>
                  <td class="flied-title">
                    <label class="checkbox-inline">
                      <form:checkbox path="provEFTYn" id="provEFTYn" value="Yes" />
                    </label>
                  </td>
                 </tr>                   
                <tr>                 
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.coverage" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="coverage" id="coverage" class="down-control">
                      <form:option value="">All</form:option>
                      <form:option value="Participating">Participating</form:option>
                      <form:option value="Non-Participating">Non-Participating</form:option>
                    </form:select>
                  </td>                  
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.contract" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="provContract" id="provContract" class="down-control">
                      <form:option value="">All</form:option>
                      <form:option value="Participating">Participating</form:option>
                      <form:option value="Non-Participating">Non-Participating</form:option>
                    </form:select>
                  </td>                  
                </tr>                
              </tbody>         

              <tbody id="myContent">
                <tr>
                  <td class="lable-title" align="left" valign="middle" scope="col">
                    <spring:message code="label.prov.taxo" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="taxonomyCode" id="taxonomyCode" class="form-control" maxlength="21" />
                  </td>
                  <td class="lable-title" align="left" valign="middle" scope="col">
                    <spring:message code="label.prov.effDt" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="effectiveDate" id="effectiveDate" class="date-control datepicker from"  readonly="ture"/>
                  </td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.tmDt" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input path="termDate" id="termDate" class="date-control datepicker to" readonly="ture"/>
                  </td>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.tin" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input path="tin" id="tin" class="form-control" maxlength="10" />
                  </td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.npi" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input path="nip" id="nip" class="form-control" maxlength="11" />
                  </td>

                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.mdId" />
                  </td>
                  <td class="flied-title" class="flied-title" align="left" valign="middle">
                    <form:input path="medicareId" id="medicareId" class="form-control" maxlength="51" />
                  </td>
                </tr>
               <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.prov.contractCode" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input path="contractCode" id="contractCode" class="form-control" maxlength="51"/>
                  </td>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.gender" />
                  </td>
                  <td class="flied-title" class="flied-title" align="left" valign="middle">
                    <label class="radio-inline">
                      <form:radiobutton path="gender" id="gender" value="Male" /><spring:message code="label.male" /></label>
                    <label class="radio-inline">
                      <form:radiobutton path="gender" id="gender" value="FeMale" /><spring:message code="label.female" />
                    </label>
                    <label class="radio-inline">
                      <form:radiobutton path="gender" id="gender" value="Both" /><spring:message code="label.both" />
                    </label>
                  </td>
                </tr>
              </tbody>
              
              <tbody id="headerDiv">
                <tr>
                  <td align="left" valign="middle"></td>
                  <td align="left" valign="middle"></td>
                  <td align="left" valign="middle"></td>
                  <td class="lable-title" align="left" valign="middle">
                    <a id="myHeader" href="javascript:toggle2('myContent','myHeader');">
                      <spring:message code="label.showLink" />
                    </a>
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
                    <input type="reset" value="Reset" onClick="clearFields('./testdaUser');">
                  </td>
                </tr>
              </tbody>
            </table>

          </div>
          <br/>
          <br/>
          
          
          
            
            <c:if test="${tDMProvSearchDTO.tDMProvSearchResultListDTOs eq null}">
            
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
	          
	          <c:if test="${tDMProvSearchDTO.autoEmailDTOs ne null && empty tDMProvSearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          
	          <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.recFndByyou" /></td>
	                 
	                </tr>
	              </tbody>
	            </table>
	          
	          
	          </c:if>
	          
	          <c:if test="${tDMProvSearchDTO.autoEmailDTOs ne null &&  not empty tDMProvSearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          
	          
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
                  <c:forEach items="${tDMProvSearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">
                    <tr>
                      <td>${autoEmailDTOs.userId}</td>
                      <td>${autoEmailDTOs.testCaseId}</td>
                      <td>${autoEmailDTOs.testCaseName}</td>
                      <td  class="buttonsAll8">
    						<input type="button" value="Email" id="jqxButton"  onclick="popup('./popupEmailUser?user=${autoEmailDTOs.userId}&result=${result}&reserveId=${autoEmailDTOs.testCaseId}','Un-Reserve Request','popup','popupOverlay','550');"/>
    				  </td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tDMProvSearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">

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
			   									<li><a href="testdaUser?page=<%= 1 %>" onClick="showLoading();">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="testdaUser?page=<%= currentPage-1 %>" onClick="showLoading();">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="testdaUser?page=<%= 1 %>" onClick="showLoading();">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="testdaUser?page=<%= currentPage-1 %>" onClick="showLoading();">&lt;</a><div>&lt;</div>
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
			    										<li><a href="testdaUser?page=<%= i %>" id="employeeLink" onClick="showLoading();"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="testdaUser?page=<%= currentPage+1 %>" onClick="showLoading();">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="testdaUser?page=<%= noOfPages %>" onClick="showLoading();">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="testdaUser?page=<%= currentPage+1 %>" onClick="showLoading();">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="testdaUser?page=<%= noOfPages %>" onClick="showLoading();">&gt;&gt;</a><div>&gt;&gt;</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->
							
	       
	          </c:if>
	          
	          <c:if test="${tDMProvSearchDTO.autoEmailDTOs eq null && empty tDMProvSearchDTO.autoEmailDTOs}">
	          
	            <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.noRec"/></td>
	                </tr>
	                
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"  class="buttonsAll8"><spring:message code="label.email.l1l2" /> 
	               		<input type="button" value="Email"  onclick="popup('./popupEmail?result=${result}','L1/L2 Support','popup','popupOverlay','550');" />
                      </td>
	                </tr>
	              </tbody>
	            </table>
	       
	          </c:if>
	       
	          </c:if>
	        </c:if>
	        
	        
	         <c:if test="${tDMProvSearchDTO.tDMProvSearchResultListDTOs eq null}">
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

          <c:if test="${tDMProvSearchDTO.tDMProvSearchResultListDTOs ne null &&  not empty tDMProvSearchDTO.tDMProvSearchResultListDTOs}">
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
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.prov.fname" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.lname" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.atypical" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.ptype" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.catg" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.speciality" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.licenseNo" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.tin" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.npi" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.medicareId" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.contract" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.eft" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.gender" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.termdt" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.addLine1" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.addLine2" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.city" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.prov.state" /></th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${tDMProvSearchDTO.tDMProvSearchResultListDTOs}" var="tDMProvSearchResultListDTOs" varStatus="status">
                    <tr>
                      <c:if test="${tDMProvSearchResultListDTOs.reservedYN eq null }">
                        <td>
                          <label class="checkbox-inline">
                            <form:checkbox path="tDMProvSearchResultListDTOs[${status.index}].reservedYN" id="tDMProvSearchResultListDTOs[${status.index}].reservedYN" class="cb_class checkBoxCls" value="Yes" />
                          </label>
                        </td>
                      </c:if>

                      <td>${tDMProvSearchResultListDTOs.firstName}</td>
                      <td>${tDMProvSearchResultListDTOs.lastName}</td>
                      <td>${tDMProvSearchResultListDTOs.atypical}</td>
                      <td>${tDMProvSearchResultListDTOs.provType}</td>
                      <td>${tDMProvSearchResultListDTOs.provCatgType}</td>
                      <td>${tDMProvSearchResultListDTOs.specialityDescription}</td>
                      <td>${tDMProvSearchResultListDTOs.licenseNo}</td>
                      <td>${tDMProvSearchResultListDTOs.tin}</td>
                      <td>${tDMProvSearchResultListDTOs.npi}</td>
                      <td>${tDMProvSearchResultListDTOs.medicareId}</td>
                      <td>${tDMProvSearchResultListDTOs.provContactType}</td>
                      <td>${tDMProvSearchResultListDTOs.provFET}</td>
                      <td>${tDMProvSearchResultListDTOs.provGender}</td>
                      <td>${tDMProvSearchResultListDTOs.terminationDate}</td>
                      <td>${tDMProvSearchResultListDTOs.provAddr1}</td>
                      <td>${tDMProvSearchResultListDTOs.provAddr2}</td>
                      <td>${tDMProvSearchResultListDTOs.provCity}</td>
                      <td>${tDMProvSearchResultListDTOs.provState}</td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tDMProvSearchDTO.tDMProvSearchResultListDTOs}" var="tDMProvSearchResultListDTOs" varStatus="status">

                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].providerId" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].firstName" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].lastName" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].atypical" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].provType" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].provCatgType" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].specialityDescription" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].licenseNo" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].tin" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].npi" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].medicareId" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].provContactType" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].provFET" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].provGender" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].terminationDate" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].provAddr1" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].provAddr2" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].provCity" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].provState" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].testCaseId" />
                    <form:hidden path="tDMProvSearchResultListDTOs[${status.index}].testCaseName" />
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
			   									<li><a href="testdaUser?page=<%= 1 %>" onClick="showLoading();" >&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="testdaUser?page=<%= currentPage-1 %>" onClick="showLoading();" >&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="testdaUser?page=<%= 1 %>"  onClick="showLoading();" >&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="testdaUser?page=<%= currentPage-1 %>" onClick="showLoading();" >&lt;</a><div>&lt;</div>
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
			    										<li><a href="testdaUser?page=<%= i %>" id="employeeLink"  onClick="showLoading();" ><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="testdaUser?page=<%= currentPage+1 %>"   onClick="showLoading();">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="testdaUser?page=<%= noOfPages %>"  onClick="showLoading();" >&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="testdaUser?page=<%= currentPage+1 %>"  onClick="showLoading();">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="testdaUser?page=<%= noOfPages %>"  onClick="showLoading();">&gt;&gt;</a><div>&gt;&gt;</div></li>
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
                      <input type="submit" name="export" id="export"  value="Export to Excel">
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
  menu_highlight('Provider_Search');
  menu_highlight('services');
  menu_highlight('services_ftd');
  menu_highlight('services_ftd_insu');
  menu_highlight('services_ftd_insu_health');
  
  $body.removeClass("loading");
  var checkboxes = $('.cb_class');
  
  function showLoading(){
	  $body.addClass("loading"); 
  } 
   
  $(document).ready(function () {
    var showHide = '${tDMProvSearchDTO.showHideFlag}';
    if (showHide == 'true') {
      toggle2('myContent', 'myHeader');
    }
  });
  /* $(".datepicker").datepicker(); */
  
  $("#myContent").css("display", "none");
  $("#search_output_table").tablesorter({
    widgets: ['zebra']
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

	$(".table tr:odd").css('background-color','#ffffff');
	$(".table tr:even").addClass('even');


	$(function() {
	$('[placeholder]').focus(function() {
	  var input = $(this);
	  if (input.val() == input.attr('placeholder')) {
	    input.val('');
	    input.removeClass('placeholder');
	  }
	}).blur(function() {
	  var input = $(this);
	  if (input.val() == '' || input.val() == input.attr('placeholder')) {
	    input.addClass('placeholder');
	    input.val(input.attr('placeholder'));
	  }
	}).blur().parents('form').submit(function() {
	  $(this).find('[placeholder]').each(function() {
	    var input = $(this);
	    if (input.val() == input.attr('placeholder')) {
	      input.val('');
	    }
	  })
	});
	});
    
  providerSearchValidation();
   
  
  
  $(document).ready(function() {
	    $('#provCatgType').change(function() {
	        var selectedValue = $(this).val();
	        var servletUrl = 'testdaSpecility?value=' + selectedValue;

	        $.getJSON(servletUrl, function(options) {
	             var provSpec = $('#provSpecType');
	            $('>option', provSpec).remove(); // Clean old options first.
	            if (options) {
	            	 provSpec.append($('<option/>').text("All"));
	                 $.each(options, function(value, value) {
	                	provSpec.append($('<option/>').val(value).text(value));
	                });
	            } else {
	            	provSpec.append($('<option/>').text("Please select Category"));
	            }
	        });
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
 