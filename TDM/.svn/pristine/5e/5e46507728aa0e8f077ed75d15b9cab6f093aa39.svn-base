<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Central | Policy Property Search</title>
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

		<jsp:include page="headerPC.jsp"></jsp:include>
		<script src="include/menuPC.js"></script>
		<div id="tabs-1" class="container">
			<c:if test="${error ne null}">
				<table class="my-error-class">
					<tbody>
						<tr>
							<td class="lable-title" align="left" valign="middle">
								${error}</td>
						</tr>
					</tbody>
				</table>
			</c:if>
			<div id="myErrorCls" >
			</div>
			<form:form id="testDataForm" name="testDataForm"
				action="${pageContext.request.contextPath}/policyProp"
				modelAttribute="tdmPolicyPropertySearchDTO">
				<div class="">
					<table
						style="width: 100%; border: 0; font-size: 13px; cellpadding: 4;">
						<tbody>
							<tr>
								<td class="lable-title" width="35%" align="left" valign="middle"><spring:message
										code="label.env" /><span>*</span></td>
								<td class="flied-title" width="20%" align="left" valign="middle">

									<form:select path="envType" id="envType" class="down-control"
										required="true">
										<form:option value="DS ITE" selected="selected">DS ITE</form:option>
									</form:select>
								</td>

								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.prodType" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="addproductType" id="addproductType" class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="HO4">HO4</form:option>
										<form:option value="HO6">HO6</form:option>
										<form:option value="DP3">DP3</form:option>
										<form:option value="HO3">HO3</form:option>
									</form:select></td>

							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle" scope="col"><spring:message
										code="label.policy.stage" /></td>
								<td class="flied-title" align="left" valign="middle" scope="col">
									<form:select path="policyStage" id="policyStage"
										class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="active">Active</form:option>
										<form:option value="cancelled">Cancelled</form:option>
										<form:option value="pending">Pending</form:option>
									</form:select>
								</td>


								<td class="lable-title" width="25%" align="left" valign="middle">
									<spring:message code="label.policy.state" />
								</td>
								<td class="flied-title" width="20%" align="left" valign="middle">
									<form:select path="policyState" id="policyState"
										class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="UT">UT</form:option>
										<form:option value="AZ">AZ</form:option>
										<form:option value="IN">IN</form:option>
										<form:option value="OK">OK</form:option>
										<form:option value="CO">CO</form:option>
										<form:option value="IN">IN</form:option>
										<form:option value="CA">CA</form:option>
									</form:select>
								</td>

						 
							</tr>

							<tr>
								<td class="lable-title" align="left"><spring:message
										code="label.policy.term" /></td>
								<td class="flied-title" align="left"><form:select
										path="policyTerm" id="policyTerm" class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="AN">ANNUAL</form:option>
										<form:option value="SA">SEMI-ANNUAL</form:option>
									</form:select></td>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.assoPayReqAdd" /></td>
								<td class="flied-title" class="flied-title" align="left"
									valign="middle"><label class="radio-inline"> <form:radiobutton
											path="addPayReq" id="addPayReq1" value="Y"/> <spring:message
											code="label.yes" /></label> <label class="radio-inline"> <form:radiobutton
											path="addPayReq" id="addPayReq2" value="N"/> <spring:message
											code="label.no" />
								</label> <label class="radio-inline"> <form:radiobutton
											path="addPayReq" id="addPayReq3" value="" /> <spring:message
											code="label.any" />
								</label></td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.riskCov" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="addRiskCovge" id="addRiskCovge" class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="CovA">CovA</form:option>
										<form:option value="CovC">CovC</form:option>
										<form:option value="CovD">CovD</form:option>
										<form:option value="CovE">CovE</form:option>
										<form:option value="CovF">CovF</form:option>
										<form:option value="DEDUCTIBLE">DEDUCTIBLE</form:option>
										<form:option value="UMB">UMB</form:option>
									</form:select></td>								
						   </tr>		
							<tr>
								<td class="lable-title" align="left"><spring:message
										code="label.policy.assoDocReqAdd" /></td>
								<td class="flied-title" class="flied-title" align="left"
									valign="middle"><label class="radio-inline"> <form:radiobutton
											path="addDocReq" id="addDocReq1" value="Y" /> <spring:message
											code="label.yes" /></label> <label class="radio-inline"> <form:radiobutton
											path="addDocReq" id="addDocReq2" value="N" /> <spring:message
											code="label.no" />
								</label> <label class="radio-inline"> <form:radiobutton
											path="addDocReq" id="addDocReq3" value="Any" /> <spring:message
											code="label.any" />
								</label></td>
							</tr>
						</tbody>
					  
					</table>

					<table
						style="width: 100%; border: 0; font-size: 13px; cellpadding: 4;">
						<tbody>
							<tr>
								<td colspan="4" align="center" valign="middle" class="buttonsAll8"><input
									type="submit" name="search" id="Search" 
									value="<spring:message code="button.serch"/>"> <input
									type="reset" value="Reset" 
									onClick="clearFields('./policyProp');"></td>
							</tr>
						</tbody>
					</table>

				</div>
				<br />
				<br />




				<c:if
					test="${tdmPolicyPropertySearchDTO.tdmPolicyPropertySearchResultDTOList eq null}">

					<c:if test="${result ne null}">
						<table
							style="width: 100%; border: 0; font-size: 14px; font-style: italic; color: #7C6DC2; cellpadding: 4;">
							<tbody>
								<tr>
									<td class="lable-title" align="left" valign="middle">
										${result}</td>

								</tr>
							</tbody>
						</table>
						<br />
						<br />

						<c:if
							test="${tdmPolicyPropertySearchDTO.autoEmailDTOs ne null && empty tdmPolicyPropertySearchDTO.autoEmailDTOs && reserveFlag eq null}">

							<table
								style="width: 100%; border: 0; font-size: 14px; color: #EC0B2D; cellpadding: 4;">
								<tbody>
									<tr>
										<td class="lable-title" align="left" valign="middle"><spring:message
												code="label.msg.recFndByyou" /></td>
									</tr>
								</tbody>
							</table>

						</c:if>

						<c:if
							test="${tdmPolicyPropertySearchDTO.autoEmailDTOs ne null &&  not empty tdmPolicyPropertySearchDTO.autoEmailDTOs && reserveFlag eq null}">

							<table
								style="width: 100%; border: 0; font-size: 14px; color: #EC0B2D; cellpadding: 4;">
								<tbody>
									<tr>
										<td class="lable-title" align="left" valign="middle"><spring:message
												code="label.msg.recFndByOth" /></td>
									</tr>
								</tbody>
							</table>

							<table class="table tablesorter"
								style="width: 70%; font-size: 14px; border: 0; cellpadding: 0; cellspacing: 1;">
								<thead>
									<tr>
										<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
												code="label.userId" /></th>
										<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
												code="label.tcId" /></th>
										<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
												code="label.tcName" /></th>
										<%-- <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.msg"/></th> --%>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${tdmPolicyPropertySearchDTO.autoEmailDTOs}"
										var="autoEmailDTOs" varStatus="status">
										<tr>
											<td>${autoEmailDTOs.userId}</td>
											<td>${autoEmailDTOs.testCaseId}</td>
											<td>${autoEmailDTOs.testCaseName}</td>
											 
										</tr>
									</c:forEach>

									<c:forEach items="${tdmPolicyPropertySearchDTO.autoEmailDTOs}"
										var="autoEmailDTOs" varStatus="status">

										<form:hidden path="autoEmailDTOs[${status.index}].userId" />
										<form:hidden path="autoEmailDTOs[${status.index}].testCaseId" />
										<form:hidden
											path="autoEmailDTOs[${status.index}].testCaseName" />

									</c:forEach>

								</tbody>
							</table>

							<%
								int currentPage = (Integer) request
														.getAttribute("currentPage");
												int count1 = currentPage - 1;
												count1 = count1 * 10;
							%>


							<!-- Pagination Starts -->
							<ul class="grdPagination">
								<%
									int noOfPages = (Integer) request
															.getAttribute("noOfPages");
													int startPage = (Integer) request
															.getAttribute("startPage");
													int lastPage = (Integer) request
															.getAttribute("lastPage");

													if (currentPage != 1) {
								%>
								<li><a href="policyProp?page=<%=1%>">&lt;&lt;</a>
									<div>&lt;&lt;</div></li>
								<li><a href="policyProp?page=<%=currentPage - 1%>">&lt;</a>
									<div>&lt;</div> <%
 	} else {
 						if (noOfPages > 1) {
 %>
								<li class="disable"><a href="policyProp?page=<%=1%>">&lt;&lt;</a>
									<div>&lt;&lt;</div></li>
								<li class="disable"><a
									href="policyProp?page=<%=currentPage - 1%>">&lt;</a>
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
								<li><a href="policyProp?page=<%=i%>" id="employeeLink"><%=i%></a>
									<div><%=i%></div></li>
								<%
									}
														}
													}
													if (currentPage < noOfPages) {
								%>
								<li><a href="policyProp?page=<%=currentPage + 1%>">&gt;</a>
									<div>&gt;</div></li>
								<li><a href="policyProp?page=<%=noOfPages%>">&gt;&gt;</a>
									<div>&gt;&gt;</div></li>
								<%
									} else {
														if (noOfPages > 1) {
								%>
								<li class="disable"><a
									href="policyProp?page=<%=currentPage + 1%>">&gt;</a>
									<div>&gt;</div></li>
								<li class="disable"><a
									href="policyProp?page=<%=noOfPages%>">&gt;&gt;</a>
									<div>&gt;&gt;</div></li>
								<%
									}
													}
								%>
							</ul>

							<!-- Pagination Ends -->


						</c:if>

						<c:if
							test="${tdmPolicyPropertySearchDTO.autoEmailDTOs eq null && empty tdmPolicyPropertySearchDTO.autoEmailDTOs}">

							<table
								style="width: 100%; border: 0; font-size: 14px; color: #EC0B2D; cellpadding: 4;">
								<tbody>
									<tr>
										<td class="lable-title" align="left" valign="middle"><spring:message
												code="label.msg.noRec" /></td>
									</tr>

									<tr>
								 

									</tr>
								</tbody>
							</table>

						</c:if>

					</c:if>
				</c:if>


				<c:if
					test="${tdmPolicyPropertySearchDTO.tdmPolicyPropertySearchResultDTOList eq null}">
					<c:if test="${reserveFlag ne null}">
						<table class="my-msg-class">
							<tbody>
								<tr>
									<td class="lable-title" align="left" valign="middle">
										${reserveFlag}</td>

								</tr>
							</tbody>
						</table>
					</c:if>
				</c:if>

				<c:if
					test="${tdmPolicyPropertySearchDTO.tdmPolicyPropertySearchResultDTOList ne null &&  not empty tdmPolicyPropertySearchDTO.tdmPolicyPropertySearchResultDTOList}">
					<%
						int currentPage = (Integer) request
										.getAttribute("currentPage");
								int count1 = currentPage - 1;
								count1 = count1 * 10;
					%>

					<table
						style="width: 100%; border: 0; font-size: 14px; font-style: italic; color: #7C6DC2; cellpadding: 4;">
						<tbody>
							<tr>
								<td class="lable-title" align="left" valign="middle">
									${result}</td>

							</tr>
						</tbody>
					</table>

					 <table style="width:100%; border:0; font-size: 14px; font-style: italic; color:#7C6DC2;cellpadding:4;">
             			<tbody>
               			  <tr>
               			  	 <td class="lable-title" align="right" valign="middle"><spring:message code="label.totRecFetc" />${totalRecords}</td>
               			  </tr>
              			</tbody>
           			 </table> 

					<table
						style="width: 80%; border: 0; font-size: 13px; cellpadding: 5;">
						<tbody>
							<tr>
								<td class="lable-title" width="10%" align="left" valign="middle"><spring:message
										code="label.tcId" /><span>*</span></td>
								<td class="flied-title"  width="10%"  align="left" valign="middle"><form:input
										path="testCaseId" id="testCaseId"
										class="down-control-small mandetCls1" /></td>
								<td class="lable-title" width="15%" align="left" valign="middle"><spring:message
										code="label.tcName" /><span>*</span></td>
								<td class="flied-title" width="10%" align="left" valign="middle"><form:input
										path="testCaseName" id="testCaseName"
										class="down-control-small mandetCls1 mandetCls2" /></td>
								<!-- Amruta -->
								<td class="lable-title" align="left" width="30%" valign="middle"><input type="submit" name="reserve"
									class="btn-primary btn-cell" id="reserve" value="Reserve"></td>
							</tr>
						</tbody>
					</table>

					<c:if test="${reserveFlag ne null}">
						<table class="my-msg-class">
							<tbody>
								<tr>
									<td class="lable-title" align="left" valign="middle">
										${reserveFlag}</td>

								</tr>
							</tbody>
						</table>
					</c:if>



					<div class="scrollingX" id="myid">
						<table id="search_output_table" class="table tablesorter"
							style="width: 100%; font-size: 13px; border: 0; cellpadding: 0; cellspacing: 1;">
							<thead>
								<tr>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="button.reserve" /><span>*</span></th>
									<th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message
											code="label.policy.num" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.prodType" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.stage" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.state" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.term" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.effDt" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.expDt" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.riskCov" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.avlPays" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.avlDocs" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Document Type</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach
									items="${tdmPolicyPropertySearchDTO.tdmPolicyPropertySearchResultDTOList}"
									var="tdmPolicyPropertySearchResultDTOList" varStatus="status">
									<tr>
										<c:if
											test="${tdmPolicyPropertySearchResultDTOList.reservedYN eq null }">
											<td><label class="checkbox-inline"> <form:checkbox
														path="tdmPolicyPropertySearchResultDTOList[${status.index}].reservedYN"
														id="tdmPolicyPropertySearchResultDTOList[${status.index}].reservedYN"
														class="cb_class checkBoxCls" value="Yes" />
											</label></td>
										</c:if>

										<td>${tdmPolicyPropertySearchResultDTOList.policynumber}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.productType}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.policyStage}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.policyState}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.policyTerm}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.policyEffectDt}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.policyExpDt}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.riskCovge}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.assoPayReq}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.assoDocType}</td>
										<td>${tdmPolicyPropertySearchResultDTOList.docType}</td>


									</tr>
								</c:forEach>

								<c:forEach
									items="${tdmPolicyPropertySearchDTO.tdmPolicyPropertySearchResultDTOList}"
									var="tdmPolicyPropertySearchResultDTOList" varStatus="status">

									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].policynumber" />
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].childProductType" />
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].policyStage" />
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].policyState" />
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].policyTerm" />
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].policyEffectDt" />
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].policyExpDt" />
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].riskCovge" />
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].assoPayReq" />
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].assoDocType" />
										
									<form:hidden
										path="tdmPolicyPropertySearchResultDTOList[${status.index}].docType" />	

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
						<li><a href="policyProp?page=<%=1%>" onClick="showLoading();">&lt;&lt;</a>
							<div>&lt;&lt;</div></li>
						<li><a href="policyProp?page=<%=currentPage - 1%>" onClick="showLoading();">&lt;</a>
							<div>&lt;</div> <%
 	} else {
 				if (noOfPages > 1) {
 %>
						<li class="disable"><a href="policyProp?page=<%=1%>" onClick="showLoading();">&lt;&lt;</a>
							<div>&lt;&lt;</div></li>
						<li class="disable"><a
							href="policyProp?page=<%=currentPage - 1%>" onClick="showLoading();">&lt;</a>
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
						<li><a href="policyProp?page=<%=i%>" id="employeeLink" onClick="showLoading();"><%=i%></a>
							<div><%=i%></div></li>
						<%
							}
										}
									}
									if (currentPage < noOfPages) {
						%>
						<li><a href="policyProp?page=<%=currentPage + 1%>" onClick="showLoading();">&gt;</a>
							<div>&gt;</div></li>
						<li><a href="policyProp?page=<%=noOfPages%>" onClick="showLoading();">&gt;&gt;</a>
							<div>&gt;&gt;</div></li>
						<%
							} else {
										if (noOfPages > 1) {
						%>
						<li class="disable"><a
							href="policyProp?page=<%=currentPage + 1%>" onClick="showLoading();">&gt;</a>
							<div>&gt;</div></li>
						<li class="disable"><a href="policyProp?page=<%=noOfPages%>" onClick="showLoading();">&gt;&gt;</a>
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
								<th scope="col" class="buttonsAll15"><input type="submit" name="reserve"
									id="reserve" value="Reserve">
									<input type="submit" name="export" id="export"
									value="Export to Excel"></th>
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
	 
	 menu_highlight('Policy_Property_Search');
	 menu_highlight('services');
	 menu_highlight('services_ftd_insu');
	 menu_highlight('services_ftd_insu_pc');
	 
	 $body.removeClass("loading");
	 
	 function showLoading(){
		  $body.addClass("loading"); 
	 } 
	 
		var checkboxes = $('.cb_class');

		$(document).ready(function() {
		 $('#addPayReq1').change(function() {
		    	$('#myErrorCls').next(".my-error-class").remove(); 
		  		if( $('#addPayReq1').attr("checked", "checked")) {
		  			$('#myErrorCls').after('<div class="my-error-class">The functionality on "Associated Payment" is currently awaited for PAS to be updated to the latest version.</div>');
		  			 $('input[type="submit"]').attr('disabled','disabled');
		  		} else {
		  			$('input[type="submit"]').removeAttr('disabled');
		  			$('#myErrorCls').next(".my-error-class").remove(); 
		  		}
		    });
		 
			 $('#addPayReq2').change(function() {
		    	$('#myErrorCls').next(".my-error-class").remove(); 
		  		if( $('#addPayReq2').attr("checked", "checked")) {
		  			$('#myErrorCls').after('<div class="my-error-class">The functionality on "Associated Payment" is currently awaited for PAS to be updated to the latest version.</div>');
		  			 $('input[type="submit"]').attr('disabled','disabled');
		  		} else {
		  			$('input[type="submit"]').removeAttr('disabled');
		  			$('#myErrorCls').next(".my-error-class").remove(); 
		  		}
		    });
			 
			 $('#addPayReq3').change(function() {
			    	$('#myErrorCls').next(".my-error-class").remove(); 
			  		if( $('#addPayReq3').attr("checked", "checked")) {
			  			$('#myErrorCls').next(".my-error-class").remove(); 
			  	 		$('input[type="submit"]').removeAttr('disabled');
			  		}
			    });
		 
		});
		 
		$(document).ready(function() {
			var showHide = '${tdmPolicyPropertySearchDTO.showHideFlag}';
			if (showHide == 'true') {
				toggle2('myContent', 'myHeader');
			}
		});

		$(document).ready(function() {	
// 	        toggle3('docContent', 'N');		
			toggle3('paymethodContent', 'N');			
		 $("#addPayReq1").click(function () {			 
				toggle3('paymethodContent', $('#addPayReq1').val());					 
	     });
		 $("#addPayReq2").click(function () {			 
				toggle3('paymethodContent', $('#addPayReq2').val());					 
	     });
		 $("#addPayReq3").click(function () {			 
				toggle3('paymethodContent', 'N');					 
	     });
// 		 $("#addDocReq1").click(function () {			 
// 				toggle3('docContent', $('#addDocReq1').val());					 
// 	     });
// 		 $("#addDocReq2").click(function () {			 
// 				toggle3('docContent', $('#addDocReq2').val());					 
// 	     });
// 		 $("#addDocReq3").click(function () {			 
// 				toggle3('docContent', 'N');					 
// 	     });
		 if($("#addPayReq1").is(":checked")){
				toggle3('paymethodContent', 'Y');
		   }
// 		 if($("#addDocReq1").is(":checked")){
// 				toggle3('docContent', 'Y');
// 		   }
		 
		});
		
		/* $(".datepicker").datepicker(); */

		$("#myContent").css("display", "none");
		$("#search_output_table").tablesorter({
			widgets : [ 'zebra' ]
		});

		$(function() {
			$(".from").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 1,
				onClose : function(selectedDate) {
					$(".to").datepicker("option", "minDate", selectedDate);
				}
			});
			$(".to").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 1,
				onClose : function(selectedDate) {
					$(".from").datepicker("option", "maxDate", selectedDate);
				}
			});
		});

		$(".table tr:odd").css('background-color', '#ffffff');
		$(".table tr:even").addClass('even');

		policyPropSearchValidation();

		window.location.hash = "myid";

		$(document)
				.ready(
						function() {
							$("#reserve")
									.click(
											function() {
												$('.mandetCls1').next(
														".my-error-class")
														.remove();
												$('.mandetCls2').next(
														".my-error-class")
														.remove();
												$('#search_output_table').next(
														".my-error-class")
														.remove();
												var checkboxes = $('.checkBoxCls');
												var selected = checkboxes
														.filter(":checked").length;
												if (selected == false) {
													$('#search_output_table')
															.after(
																	'<div class="my-error-class">There is no selection of the records from Search Result</div>');
													return false;
												}
												if ($('.mandetCls1').val() == '') {
													$('.mandetCls1')
															.after(
																	'<div class="my-error-class">This field is required.</div>');
													return false;
												}
												if ($('.mandetCls2').val() == '') {
													$('.mandetCls2')
															.after(
																	'<div class="my-error-class">This field is required.</div>');
													return false;
												}

											});
						});

		$(document)
				.ready(
						function() {
							$("#export")
									.click(
											function() {
												$('#search_output_table').next(
														".my-error-class")
														.remove();
												var checkboxes = $('.checkBoxCls');
												var selected = checkboxes
														.filter(":checked").length;
												if (selected == false) {
													$('#search_output_table')
															.after(
																	'<div class="my-error-class">There is no selection of the records from Search Result</div>');
													return false;
												}
											});
						});

		$(function() {
			$(document).tooltip(
					{
						position : {
							my : "center bottom-20",
							at : "center top",
							using : function(position, feedback) {
								$(this).css(position);
								$("<div>").addClass("arrow").addClass(
										feedback.vertical).addClass(
										feedback.horizontal).appendTo(this);
							}
						}
					});
		});
	</script>
</body>
</html>
