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
                   
                    <spring:message code="label.policy.ds" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="dataSource" id="dataSource" class="down-control">
                       <form:option value="">--Select--</form:option>
                       <form:option value="Production">Production</form:option>
                       <form:option value="Test">Test</form:option>
                      
                    </form:select>
                    <td class="lable-title" align="left" valign="middle" scope="col">
                    <spring:message code="label.policy.srcsys" />
                      
                    </td>
                    <td class="flied-title" align="left" valign="middle" scope="col">
                      <form:select path="sourceSystem" id="sourceSystem" class="down-control" >
                       <form:option value="">All</form:option>
                       <form:option value="eCLIQ">eCLIQ</form:option>
                       <form:option value="TINA">TINA</form:option>
                      </form:select>
                    </td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.policy.lob" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="lob" id="lob" class="down-control">
                       <form:option value="">All</form:option>
                       <form:option value="WC">WC</form:option>
                       <form:option value="Auto">Auto</form:option>
                       <form:option value="Home">Home</form:option>
                    </form:select>
                  </td>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.policy.policySts" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="policyStatus" id="policyStatus"  class="down-control">
                     	<form:option value="">All</form:option>
                      	<form:option value="4">Declined</form:option>
						<form:option value="5">Expired</form:option>
						<form:option value="7">Quoted</form:option>
						<form:option value="9">Bound</form:option>
						<form:option value="10003">Canceling</form:option>
						<form:option value="10008">Rescinded</form:option>
						<form:option value="1">Draft</form:option>
						<form:option value="3">Withdrawn</form:option>
						<form:option value="10009">Reinstating</form:option>
                    </form:select>
                  </td>                  
                </tr>
                
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                     
                    <spring:message code="label.policy.state" />
                  </td>
                   <td class="flied-title" align="left" valign="middle">
                    <form:select path="policyState" id="policyState"  class="down-control">
                      <form:option value="">All</form:option>
                     	<form:option value="10001">AB</form:option>
						<form:option value="10002">ACT</form:option>
						<form:option value="10003">AK</form:option>
						<form:option value="10004">AL</form:option>
						<form:option value="10005">AR</form:option>
						<form:option value="10006">AZ</form:option>
						<form:option value="10007">BBg</form:option>
						<form:option value="10008">BC</form:option>
						<form:option value="10009">BE</form:option>
						<form:option value="10010">BW</form:option>
						<form:option value="10011">BY</form:option>
						<form:option value="10012">CA</form:option>
						<form:option value="10013">CO</form:option>
						<form:option value="10014">CT</form:option>
						<form:option value="10015">DC</form:option>
						<form:option value="10016">DE</form:option>
						<form:option value="10017">FL</form:option>
						<form:option value="10018">GA</form:option>
						<form:option value="10019">HB</form:option>
						<form:option value="10020">HE</form:option>
						<form:option value="10021">HH</form:option>
						<form:option value="10022">HI</form:option>
						<form:option value="10023">IA</form:option>
						<form:option value="10024">ID</form:option>
						<form:option value="10025">IL</form:option>
						<form:option value="10026">IN</form:option>
						<form:option value="10027">KS</form:option>
						<form:option value="10028">KY</form:option>
						<form:option value="10029">LA</form:option>
						<form:option value="10030">MA</form:option>
						<form:option value="10031">MB</form:option>
						<form:option value="10032">MD</form:option>
						<form:option value="10033">ME</form:option>
						<form:option value="10034">MI</form:option>
						<form:option value="10035">MN</form:option>
						<form:option value="10036">MO</form:option>
						<form:option value="10037">MS</form:option>
						<form:option value="10038">MT</form:option>
						<form:option value="10039">MV</form:option>
						<form:option value="10040">NB</form:option>
						<form:option value="10041">NC</form:option>
						<form:option value="10042">ND</form:option>
						<form:option value="10043">NE</form:option>
						<form:option value="10044">NH</form:option>
						<form:option value="10045">NI</form:option>
						<form:option value="10046">NJ</form:option>
						<form:option value="10047">NL</form:option>
						<form:option value="10048">NM</form:option>
						<form:option value="10049">NS</form:option>
						<form:option value="10050">NSW</form:option>
						<form:option value="10051">NT</form:option>
						<form:option value="10052">NT</form:option>
						<form:option value="10053">NU</form:option>
						<form:option value="10054">NV</form:option>
						<form:option value="10055">NW</form:option>
						<form:option value="10056">NY</form:option>
						<form:option value="10057">OH</form:option>
						<form:option value="10058">OK</form:option>
						<form:option value="10059">ON</form:option>
						<form:option value="10060">OR</form:option>
						<form:option value="10061">PA</form:option>
						<form:option value="10062">PE</form:option>
						<form:option value="10063">PR</form:option>
						<form:option value="10064">QC</form:option>
						<form:option value="10065">QLD</form:option>
						<form:option value="10066">RI</form:option>
						<form:option value="10067">RP</form:option>
						<form:option value="10068">SA</form:option>
						<form:option value="10069">SC</form:option>
						<form:option value="10070">SD</form:option>
						<form:option value="10071">SH</form:option>
						<form:option value="10072">SK</form:option>
						<form:option value="10073">SL</form:option>
						<form:option value="10074">SN</form:option>
						<form:option value="10075">ST</form:option>
						<form:option value="10076">TAS</form:option>
						<form:option value="10077">TH</form:option>
						<form:option value="10078">TN</form:option>
						<form:option value="10079">TX</form:option>
						<form:option value="10080">UT</form:option>
						<form:option value="10081">VA</form:option>
						<form:option value="10082">VIC</form:option>
						<form:option value="10083">VT</form:option>
						<form:option value="10084">WA</form:option>
						<form:option value="10085">WA</form:option>
						<form:option value="10086">WI</form:option>
						<form:option value="10087">WV</form:option>
						<form:option value="10088">WY</form:option>
						<form:option value="10089">YT</form:option>

                    </form:select>
                  </td>    
                  <td class="lable-title" align="left" valign="middle" scope="col">
                    <spring:message code="label.policy.namedInsu" /> 
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="namedInsu" id="namedInsu" class="form-control" maxlength="21" />
                  </td>
                               
                </tr>
              
              
               <tr>
                  <td class="lable-title" align="left" valign="middle" scope="col">
                    <spring:message code="label.policy.policyNo" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="policyNo" id="policyNo" class="form-control" maxlength="21" />
                  </td>
                  <td class="lable-title" align="left" valign="middle" scope="col">
                    <spring:message code="label.policy.accNo" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col">
                    <form:input path="accNo" id="accNo" class="form-control" maxlength="21" />
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
                    <input type="reset" value="Reset" class="btn-primary btn-cell" onClick="clearFields('./policySearch');"/>
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
                      <td>
    						<input type="button" value="Email" id="jqxButton" class="btn-primaryemail btn-cellemail"  onclick="popup('./popupEmailUser?user=${autoEmailDTOs.userId}&result=${result}&reserveId=${autoEmailDTOs.testCaseId}','Un-Reserve Request','popup','popupOverlay','550');"/>
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
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.policy.policyNo" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.priInsuPer" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.productName" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.policySts" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.effective" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.expire" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.accNo" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.producer" /></th>
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
                      <td>${tdmPolicySearchResultDTOs.primInsuPerson}</td>
                      <td>${tdmPolicySearchResultDTOs.productName}</td>
                      <td>${tdmPolicySearchResultDTOs.policyStats}</td>
                      <td>${tdmPolicySearchResultDTOs.effecDate}</td>
                      <td>${tdmPolicySearchResultDTOs.expairDate}</td>
                      <td>${tdmPolicySearchResultDTOs.accNo}</td>
                      <td>${tdmPolicySearchResultDTOs.producer}</td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tdmPolicySearchDTO.tdmPolicySearchResultDTOs}" var="tdmPolicySearchResultDTOs" varStatus="status">

					<form:hidden path="tdmPolicySearchResultDTOs[${status.index}].policyId" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].policyNo" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].primInsuPerson" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].productName" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].policyStats" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].effecDate" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].expairDate" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].accNo" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].producer" />
                    <form:hidden path="tdmPolicySearchResultDTOs[${status.index}].policyState" /> 
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
  menu_highlight('Policy_Search');
  
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
  
  </script>
</body>
</html>
 