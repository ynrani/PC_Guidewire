<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title> TDM Central | Subscriber Search</title>
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
  <div id="main"  class="wrapper mainAll">
    
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
        <form:form id="testDataFormSubsc" name="testDataFormSubsc" class="testval" action="${pageContext.request.contextPath}/testdaSubscUser" modelAttribute="tDMSubscSearchDTO">
        <div class="">
          <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
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
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.gender"/></td>
                <td class="flied-title" align="left" valign="middle" scope="col">
                  <label class="radio-inline">
                    <form:radiobutton path="subscGender" id="subscGender" value="Male" /><spring:message code="label.male"/></label>
                  <label class="radio-inline">
                    <form:radiobutton path="subscGender" id="subscGender" value="FeMale" /><spring:message code="label.female"/>
                  </label>
                  <label class="radio-inline">
                      <form:radiobutton path="subscGender" id="gender" value="Both" /><spring:message code="label.both" />
                   </label>
                </td>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.subc.type"/></td>
                <td class="flied-title" align="left" valign="middle" scope="col">

                  <form:select path="subscType" id="subscType" class="down-control">
                  	 	<form:option value="">All</form:option>
                   	    <c:forEach items="${tDMSubscSearchDTO.tdmSubscTypeMastDTOs}" var="tdmSubscTypeMastDTOs">
					        <form:option value="${tdmSubscTypeMastDTOs.subscTypeDesc}">${tdmSubscTypeMastDTOs.subscTypeDesc}</form:option>
					    </c:forEach>
			      </form:select>
                </td>
              </tr>

              <tr>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.subc.status"/></td>
                <td class="flied-title" align="left" valign="middle">

                  <form:select path="subscStatus" id="subscStatus"  multiple="true" class="down-control">
                 	<form:option value="">All</form:option>
                    <c:forEach items="${tDMSubscSearchDTO.tdmSubscStatusMastDTOs}" var="tdmSubscStatusMastDTOs">
						<form:option value="${tdmSubscStatusMastDTOs.subscStatusDesc}">${tdmSubscStatusMastDTOs.subscStatusDesc}</form:option>
				    </c:forEach>
                  </form:select>

                </td>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.subc.state"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:select path="subscState" id="subscState"  multiple="true" class="down-control">
                  		<form:option value="">All</form:option>
                    	<c:forEach items="${tDMSubscSearchDTO.tdmUsStateDTOs}" var="tdmUsStateDTOs">
							<form:option value="${tdmUsStateDTOs.stateName}">${tdmUsStateDTOs.stateName}</form:option>
						</c:forEach>
                  </form:select>
                </td>
              </tr>
              <tr>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.subc.lob"/></td>
                <td class="flied-title" align="left" valign="middle">

                  <form:select path="subscLOB" id="subscLOB"  multiple="true" class="down-control">
                  	<form:option value="">All</form:option>
                   	<c:forEach items="${tDMSubscSearchDTO.tdmSubscLobMastDTOs}" var="tdmSubscLobMastDTOs">
						<form:option value="${tdmSubscLobMastDTOs.subscLobDesc}">${tdmSubscLobMastDTOs.subscLobDesc}</form:option>
					</c:forEach>
                   </form:select>
                </td>

			     <td>
					<table style="padding-bottom: 15px; cellpadding:10;">
						<tr>
						  <td class="lable-title" align="left" valign="middle"><spring:message code="label.subc.age"/></td>
						</tr>
	                	<tr>
	                	   <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.subc.cob"/></td>
	                	</tr>
	              	</table>
                 </td>
                 <td>
					<table style="padding-bottom: 15px; cellpadding:10;">
					  <tr>
               			 <td class="flied-title" align="left" valign="middle"><spring:message code="label.subc.between"/>
               			   <form:input path="subscAgeStart" id="subscAgeStart" size="5" maxlength="2" class="form-control-half" /><spring:message code="label.subc.and"/>
                  		  <form:input path="subscAgeEnd" id="subscAgeEnd" size="5" maxlength="2" class="form-control-half greaterThan" />
                		</td>
                	  </tr>
                	  <tr>
                	   <td class="flied-title" class="flied-title" align="left" valign="middle">
		                <label class="checkbox-inline">
		                  <form:checkbox path="subscWithCOB" id="subscWithCOB" value="C" />
		                </label>
                       </td>
                      </tr>
                     </table>
                    </td>
               </tr>
               
              </tbody>

            

            <tbody id="myContent">
              <tr>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.subc.subcId"/></td>
                <td class="flied-title" align="left" valign="middle" scope="col">
                  <form:input path="subscriberId" id="subscriberId" class="form-control" maxlength="51" />
                </td>
                <td class="lable-title" align="left" valign="middle" scope="col"><spring:message code="label.subc.ssn"/></td>
                <td class="flied-title" align="left" valign="middle" scope="col">
                  <form:input path="ssn" id="ssn" class="form-control" maxlength="15" />
                </td>
              </tr>

              <tr>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.subc.dob"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="dob" id="dob" class="datepicker date-control" />
                </td>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.subc.planid"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="planID" id="planID" class="form-control" maxlength="21" />
                </td>
              </tr>
              <tr>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.subc.plnname"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="planName" id="planName" class="form-control" maxlength="21" />
                </td>

                <td class="lable-title" align="left" valign="middle"><spring:message code="label.subc.trmDt"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="termDate" id="termDate" class="datepicker date-control" />
                </td>
              </tr>

              <tr>
                <td class="lable-title" align="left" valign="middle"><spring:message code="label.subc.contractCode"/></td>
                <td class="flied-title" align="left" valign="middle">
                  <form:input path="contractCode" id="contractCode" class="form-control" maxlength="21"/>
                </td>
                <td class="lable-title" align="left" valign="middle"></td>
                <td class="lable-title" align="left" valign="middle">

                </td>
              </tr>

            </tbody>
            
            <tbody id="headerDiv">
              <tr>
                <td align="left" valign="middle"></td>
                <td align="left" valign="middle"></td>
                <td align="left" valign="middle"></td>
                <td class="lable-title" align="left" valign="middle">
                  <a id="myHeader" href="javascript:toggle2('myContent','myHeader');"><spring:message code="label.showLink"/></a>
                </td>
              </tr>
            </tbody>

            <tr>
              <td class="lable-title" align="left"><spring:message code="label.noOfRec"/></td>
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

          <table style="width:100%; border:0; cellpadding:4;">
            <tbody>
              <tr>
                <td colspan="4" align="center" valign="middle">
                  <input type="submit" name="search" id="Search" class="btn-primary btn-cell" value="Search">
                  <input type="reset" value="Reset" class="btn-primary btn-cell" onClick="clearFields('./testdaSubscUser');">
                </td>
              </tr>
            </tbody>
          </table>

          </div>
             <br/>
	          <br/>


 		<c:if test="${tDMSubscSearchDTO.tDMSubscSearchResultListDTOs eq null}">
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
	            
	            
	         <c:if test="${tDMSubscSearchDTO.autoEmailDTOs ne null && empty tDMSubscSearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.recFndByyou" /></td>
	                 
	                </tr>
	              </tbody>
	            </table>
	          </c:if>
	          
	          
	       <c:if test="${tDMSubscSearchDTO.autoEmailDTOs ne null &&  not empty tDMSubscSearchDTO.autoEmailDTOs && reserveFlag eq null}">
	          
	          
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
                  <c:forEach items="${tDMSubscSearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">
                    <tr>
                      <td>${autoEmailDTOs.userId}</td>
                      <td>${autoEmailDTOs.testCaseId}</td>
                      <td>${autoEmailDTOs.testCaseName}</td>
                      <td>
    						<input type="button" value="Email" id="jqxButton" class="btn-primaryemail btn-cellemail" onclick="popup('./popupEmailUser?user=${autoEmailDTOs.userId}&result=${result}&reserveId=${autoEmailDTOs.testCaseId}','Un-Reserve Request','popup','popupOverlay','550');"/>
    				  </td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tDMSubscSearchDTO.autoEmailDTOs}" var="autoEmailDTOs" varStatus="status">

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
			   									<li><a href="testdaSubscUser?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="testdaSubscUser?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="testdaSubscUser?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="testdaSubscUser?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
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
			    										<li><a href="testdaSubscUser?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="testdaSubscUser?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="testdaSubscUser?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="testdaSubscUser?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="testdaSubscUser?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
										<%
											    }
											}
										%>
									</ul>
						 
							<!-- Pagination Ends -->	       
	       
	          </c:if>
	          
	          <c:if test="${tDMSubscSearchDTO.autoEmailDTOs eq null && empty tDMSubscSearchDTO.autoEmailDTOs}">
	          
	            <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.noRec"/></td>
	                </tr>
	                
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.email.l1l2"/> 
	               		<input type="button" value="Email" id="jqxButton" class="btn-primaryemail btn-cellemail" onclick="popup('./popupEmail?result=${result}','L1/L2 Support','popup','popupOverlay','550');"/>
                      </td>
	                </tr>
	              </tbody>
	            </table>
	       
	          </c:if>
	          
            </c:if>
           </c:if>
            
            
           <c:if test="${tDMSubscSearchDTO.tDMSubscSearchResultListDTOs eq null}">
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
            
          <c:if test="${tDMSubscSearchDTO.tDMSubscSearchResultListDTOs ne null &&  not empty tDMSubscSearchDTO.tDMSubscSearchResultListDTOs}">
								<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%>
								
			<table style="width:100%; border:0; font-size: 12px;font-style: italic; color:#7C6DC2; cellpadding:4;">
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
              <table id="search_output_table" class="table tablesorter" style="width:100%;border:0; cellpadding:0; cellspacing:1">
                <thead>
                  <tr>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="lebel.chkb"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.subcId"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.dependId"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.ssn"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.fname"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.lname"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.gender"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.dob"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.status"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.grp"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.effDt"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.stype"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.addLine1"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.addLine2"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.city"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.state"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.zip"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.contractCode"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.lob"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.planid"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.plnname"/></th>
                    <th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message code="label.subc.pcp"/></th>
                  </tr>
                </thead>

                <tbody>
                  <c:forEach items="${tDMSubscSearchResultListDTOs}" var="tDMSubscSearchResultListDTOs" varStatus="status">
                    <tr>

                      <c:if test="${tDMSubscSearchResultListDTOs.reservedYN eq null }">
                        <td>
                          <form:checkbox path="tDMSubscSearchResultListDTOs[${status.index}].reservedYN" id="tDMSubscSearchResultListDTOs[${status.index}].reservedYN" class="cb_class checkBoxCls" value="Yes" />
                        </td>
                      </c:if>
                      
                      <td>${tDMSubscSearchResultListDTOs.subscriberId}</td>
                      <td>${tDMSubscSearchResultListDTOs.dependentId}</td>
                      <td>${tDMSubscSearchResultListDTOs.ssn}</td>
                      <td>${tDMSubscSearchResultListDTOs.firstName}</td>
                      <td>${tDMSubscSearchResultListDTOs.lastName}</td>
                      <td>${tDMSubscSearchResultListDTOs.gender}</td>
                      <td>${tDMSubscSearchResultListDTOs.birthDate}</td>
                      <td>${tDMSubscSearchResultListDTOs.subcStatus}</td>
                      <td>${tDMSubscSearchResultListDTOs.subscriberNames}</td>
                      <td>${tDMSubscSearchResultListDTOs.dateChanged}</td>
                      <td>${tDMSubscSearchResultListDTOs.subcType}</td>
                      <td>${tDMSubscSearchResultListDTOs.subcAddr1}</td>
                      <td>${tDMSubscSearchResultListDTOs.subcAddr2}</td>
                      <td>${tDMSubscSearchResultListDTOs.subcCity}</td>
                      <td>${tDMSubscSearchResultListDTOs.subcState}</td>
                      <td>${tDMSubscSearchResultListDTOs.subcZip}</td>
                      <td>${tDMSubscSearchResultListDTOs.subcContCode}</td>
                      <td>${tDMSubscSearchResultListDTOs.lob}</td>
                      <td>${tDMSubscSearchResultListDTOs.planId}</td>
                      <td>${tDMSubscSearchResultListDTOs.planName}</td>
                      <td>${tDMSubscSearchResultListDTOs.pcp}</td>
                    </tr>
                  </c:forEach>
                </tbody>

                <c:forEach items="${tDMSubscSearchDTO.tDMSubscSearchResultListDTOs}" var="tDMSubscSearchResultListDTOs" varStatus="status">

                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subscriberId" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].dependentId" />
                  
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].ssn" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].firstName" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].lastName" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].gender" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].birthDate" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subcStatus" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subscriberNames" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].dateChanged" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subcType" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subcAddr1" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subcAddr2" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subcCity" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subcState" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subcZip" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].subcContCode" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].lob" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].planId" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].planName" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].pcp" />
                  
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].testCaseId" />
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].testCaseName" />
                  
                  <form:hidden path="tDMSubscSearchResultListDTOs[${status.index}].userId" />

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
			   									<li><a href="testdaSubscUser?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="testdaSubscUser?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="testdaSubscUser?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="testdaSubscUser?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
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
			    										<li><a href="testdaSubscUser?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="testdaSubscUser?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="testdaSubscUser?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="testdaSubscUser?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="testdaSubscUser?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
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
                      <input type="submit" name="reserve" id="reserve" class="btn-primary btn-cell" value="Reserve">
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
  menu_highlight('Subscriber_Search');
  enableParentScroll($('#searchResultTbl'), true);
  
  subscriberSearchValidation();
    
  $(document).ready(function () {
    var showHide = '${tDMSubscSearchDTO.showHideFlag}';
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