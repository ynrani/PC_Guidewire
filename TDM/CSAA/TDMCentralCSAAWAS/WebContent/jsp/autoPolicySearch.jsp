<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Central | Policy Auto Search</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link href="css/theme.default.css" rel="stylesheet">
<link href="css/elements.css" rel="stylesheet">
<script src="js/html5Shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/main.js"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
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
				action="${pageContext.request.contextPath}/policyAuto"
				modelAttribute="tdmPolicyAutoSearchDTO">
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
										<form:option value="DS ITE" selected="selected">DS ITE </form:option>
									</form:select>
								</td>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.prodType" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="addproductType" id="addproductType" class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="AAA_CSA">AAA_CSA</form:option>
										<form:option value="AAA_SS">AAA_SS</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td class="lable-title" align="left" valign="middle" scope="col">
									<spring:message code="label.policy.stage" />
								</td>
								<td class="flied-title" align="left" valign="middle" scope="col">
									<form:select path="policyStage" id="policyStage"
										class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="Active">Active</form:option>
										<form:option value="Cancelled">Cancelled</form:option>
										<form:option value="Pending">Pending</form:option>


									</form:select>
								</td>

								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.state" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="policyState" id="policyState" class="down-control">
										<form:option value="">Any</form:option>
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
									</form:select></td>


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

								<td class="lable-title" align="left"><spring:message
										code="label.policy.assoPayReq" /></td>
								<td class="flied-title" class="flied-title" align="left"
									valign="middle"><label class="radio-inline"> <form:radiobutton
											path="assoPayReq" id="assoPayReq1" value="Y" /> <spring:message
											code="label.yes" /></label> <label class="radio-inline"> <form:radiobutton
											path="assoPayReq" id="assoPayReq2" value="N" /> <spring:message
											code="label.no" />
								</label> <label class="radio-inline"> <form:radiobutton
											path="assoPayReq" id="assoPayReq3" value="" /> <spring:message
											code="label.any" />
								</label></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.coverage" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="policyCovge" id="policyCovge" class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="UMBI">UMBI</form:option>
										<form:option value="COMPDED">COMPDED</form:option>
										<form:option value="COLLDED">COLLDED</form:option>
										<form:option value="PD">PD</form:option>
										<form:option value="UIMBI">UIMBI</form:option>
										<form:option value="MEDPM">MEDPM</form:option>
										<form:option value="ETEC">ETEC</form:option>
										<form:option value="BI">BI</form:option>
										<form:option value="ALLRISK">ALLRISK</form:option>
									</form:select></td>
							</tr>

							<tr>

								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.riskCov" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="riskCovge" id="riskCovge" class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="RREIM">RREIM</form:option>
										<form:option value="ADB">ADB</form:option>
										<form:option value="BI">BI</form:option>
										<form:option value="SPECEQUIP">SPECEQUIP</form:option>
										<form:option value="TOWINGLABOR">TOWINGLABOR</form:option>
										<form:option value="LOAN">LOAN</form:option>

									</form:select></td>

								<td class="lable-title" width="25%" align="left" valign="middle"></td>
								<td class="lable-title" width="20%" align="left" valign="middle"
									scope="col"></td>


							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.assoDoc" /></td>
								<td class="flied-title" class="flied-title" align="left"
									valign="middle"><label class="radio-inline"> <form:radiobutton
											path="assoDocReq" id="assoDocReq1" value="Y" /> <spring:message
											code="label.yes" /></label> <label class="radio-inline"> <form:radiobutton
											path="assoDocReq" id="assoDocReq2" value="N"  /> <spring:message
											code="label.no" />
								</label> <label class="radio-inline"> <form:radiobutton
											path="assoDocReq" id="assoDocReq3" value="Any"/> <spring:message
											code="label.any" />
								</label></td>

  	 						</tr>
						</tbody>

  	 						</tr>
					    </tbody>

						<%-- <tbody id="paymethodContent">
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.payType" /></td>
								<td class="flied-title" class="flied-title" align="left"
									valign="middle"><form:select path="payMethod"
										id="payMethod" class="down-control">
										<form:option value="">Any</form:option>
										<form:option value="AAAPaymentDetailsPCICreditCard">AAAPaymentDetailsPCICreditCard</form:option>
										<form:option value="PaymentDetailsCheque">PaymentDetailsCheque</form:option>
										<form:option value="PaymentDetailsCash">PaymentDetailsCash</form:option>
										<form:option value="PaymentDetailsCreditCard">PaymentDetailsCreditCard</form:option>
										<form:option value="AAAPaymentDetailsEFT">AAAPaymentDetailsEFT</form:option>
									</form:select></td>
							</tr>
						</tbody> --%>

<!-- 						<tbody id="docContent"> -->
<!-- 							<tr> -->
<%-- 								<td class="lable-title" align="left"><spring:message --%>
<%-- 										code="label.policy.docType" /></td> --%>
<%-- 								<td class="flied-title" align="left"><form:select --%>
<%-- 										path="assoDocType" id="assoDocType" --%>
<%-- 										class="down-control docType"> --%>
<%-- 										<form:option value="">Any</form:option> --%>
<%-- 										<form:option value="Declaration Page">Declaration Page</form:option> --%>
<%-- 										<form:option value="Insurance ID card">Insurance ID card</form:option> --%>
<%-- 										<form:option value="Quote Letter">Quote Letter</form:option> --%>
<%-- 										<form:option value="Identification Card">Identification Card</form:option> --%>
<%-- 										<form:option value="Insurance Identification Card">Insurance Identification Card</form:option> --%>
<%-- 										<form:option value="AutoPay Schedule">AutoPay Schedule</form:option> --%>
<%-- 										<form:option value="Welcome Letter">Welcome Letter</form:option> --%>
<%-- 										<form:option value="AutoPay Authorization Form">AutoPay Authorization Form</form:option> --%>
<%-- 										<form:option value="Request For Information">Request For Information</form:option> --%>
<%-- 										<form:option value="Declaration Form">Declaration Form</form:option> --%>
<%-- 									</form:select></td> --%>
<!-- 							</tr> -->
<!-- 						</tbody> -->
						<%-- <tbody id="myContent">
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.noDrivers" /></td>
								<td class="flied-title" align="left"><form:input
										path="noOfDrivers" id="noOfDrivers" class="form-control"
										maxlength="2" /></td>
								<td class="lable-title" align="left"><spring:message
										code="label.policy.noVehi" /></td>
								<td class="flied-title" align="left"><form:input
										path="noOfVehi" id="noOfVehi" class="form-control"
										maxlength="2" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.policy.noInsu" /></td>
								<td class="flied-title" align="left"><form:input
										path="noOfNamedInsu" id="noOfNamedInsu" class="form-control"
										maxlength="2" /></td>
								<td class="lable-title" align="left"><spring:message
										code="label.policy.noViola" /></td>
								<td class="flied-title" align="left"><form:input
										path="noOfViola" id="noOfViola" class="form-control"
										maxlength="3" /></td>
							</tr>

						</tbody>
 --%>
<%-- 
						<tbody id="headerDiv">
							<tr>
								<td align="left" valign="middle"></td>
								<td align="left" valign="middle"></td>
								<td align="left" valign="middle"></td>
								<td class="lable-title" align="left" valign="middle"><a
									id="myHeader" class="hrefVisited"
									href="javascript:toggle2('myContent','myHeader');"> <spring:message
											code="label.showLink" />
								</a></td>
							</tr>
						</tbody> --%>

						<!--               <tr> -->
						<!--                 <td class="lable-title" align="left"> -->
						<%--                   <spring:message code="label.noOfRec" /> --%>
						<!--                 </td> -->
						<!--                 <td class="flied-title"> -->
						<%--                   <form:select path="searchRecordsNo" id="searchRecordsNo" class="down-control-small"> --%>
						<%--                     <form:option value="5">5</form:option> --%>
						<%--                     <form:option value="10">10</form:option> --%>
						<%--                     <form:option value="15">15</form:option> --%>
						<%--                     <form:option value="20">20</form:option> --%>
						<%--                   </form:select> --%>
						<!--                 </td> -->
						<!--               </tr> -->

					</table>

					<table
						style="width: 100%; border: 0; font-size: 13px; cellpadding: 4;">
						<tbody>
							<tr>
								<td colspan="4" align="center" valign="middle"><input
									type="submit" name="search" id="Search"
									class="btn-primary btn-cell"
									value="<spring:message code="button.serch"/>"> <input
									type="reset" value="Reset" class="btn-primary btn-cell"
									onClick="clearFields('./policyAuto');"></td>
							</tr>
						</tbody>
					</table>

				</div>
				<br />
				<br />




				<c:if
					test="${tdmPolicyAutoSearchDTO.tdmPolicyAutoSearchResultDTOList eq null || empty tdmPolicyAutoSearchDTO.tdmPolicyAutoSearchResultDTOList}">

					<c:if test="${result ne null}">
						<table
							style="width: 100%; border: 0; font-size: 12px; font-style: italic; color: #7C6DC2; cellpadding: 4;">
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
							test="${tdmPolicyAutoSearchDTO.autoEmailDTOs ne null && empty tdmPolicyAutoSearchDTO.autoEmailDTOs && reserveFlag eq null}">

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
							test="${tdmPolicyAutoSearchDTO.autoEmailDTOs ne null &&  not empty tdmPolicyAutoSearchDTO.autoEmailDTOs && reserveFlag eq null}">


							<table
								style="width: 100%; border: 0; font-size: 14px; color: #EC0B2D; cellpadding: 4;">
								<tbody>
									<tr>
										<td class="lable-title" align="left" valign="middle"><spring:message
												code="label.msg.recFndByOth" /></td>

									</tr>
								</tbody>
							</table>

							<table class="table  tablesorter"
								style="width: 70%; font-size: 14px; border: 0; cellpadding: 0; cellspacing: 1;">
								<thead>
									<tr>
										<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
												code="label.userId" /></th>
										<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
												code="label.tcId" /></th>
										<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
												code="label.tcName" /></th>
										<%--  <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.msg"/></th> --%>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${tdmPolicyAutoSearchDTO.autoEmailDTOs}"
										var="autoEmailDTOs" varStatus="status">
										<tr>
											<td>${autoEmailDTOs.userId}</td>
											<td>${autoEmailDTOs.testCaseId}</td>
											<td>${autoEmailDTOs.testCaseName}</td>
											 
										</tr>
									</c:forEach>

									<c:forEach items="${tdmPolicyAutoSearchDTO.autoEmailDTOs}"
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
							test="${tdmPolicyAutoSearchDTO.autoEmailDTOs eq null && empty tdmPolicyAutoSearchDTO.autoEmailDTOs}">

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
					test="${tdmPolicyAutoSearchDTO.tdmPolicyAutoSearchResultDTOList eq null}">
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
					test="${tdmPolicyAutoSearchDTO.tdmPolicyAutoSearchResultDTOList ne null &&  not empty tdmPolicyAutoSearchDTO.tdmPolicyAutoSearchResultDTOList}">
					<%
						int currentPage = (Integer) request
										.getAttribute("currentPage");
								int count1 = currentPage - 1;
								count1 = count1 * 10;
					%>

					<table
						style="width: 100%; border: 0; font-size: 12px; font-style: italic; color: #7C6DC2; cellpadding: 4;">
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
											code="button.reserve" /> <span>*</span></th>
									<th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message
											code="label.policy.num" /></th>
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
											code="label.policy.coverage" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.riskCov" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.prodType" /></th>
									<%-- <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.noDrivers" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.noVehi" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.noViola" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.noInsu" /></th> --%>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.avlPays" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.policy.avlDocs" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach
									items="${tdmPolicyAutoSearchDTO.tdmPolicyAutoSearchResultDTOList}"
									var="tdmPolicyAutoSearchResultDTOList" varStatus="status">
									<tr>
										<c:if
											test="${tdmPolicyAutoSearchResultDTOList.reservedYN eq null }">
											<td><label class="checkbox-inline"> <form:checkbox
														path="tdmPolicyAutoSearchResultDTOList[${status.index}].reservedYN"
														id="tdmPolicyAutoSearchResultDTOList[${status.index}].reservedYN"
														class="cb_class checkBoxCls" value="Yes" />
											</label></td>
										</c:if>

										<td>${tdmPolicyAutoSearchResultDTOList.policynumber}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.policyStage}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.policyState}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.policyTerm}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.policyEffectDt}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.policyExpDt}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.policyCovge}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.riskCovge}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.productType}</td>
										<%-- <td>${tdmPolicyAutoSearchResultDTOList.noOfDrivers}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.noOfVehi}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.noOfViola}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.noOfNamedInsu}</td> --%>
										<td>${tdmPolicyAutoSearchResultDTOList.assoPayReq}</td>
										<td>${tdmPolicyAutoSearchResultDTOList.assoDocReq}</td>

									</tr>
								</c:forEach>

								<c:forEach
									items="${tdmPolicyAutoSearchDTO.tdmPolicyAutoSearchResultDTOList}"
									var="tdmPolicyAutoSearchResultDTOList" varStatus="status">

									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].policynumber" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].policyStage" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].policyState" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].policyTerm" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].policyEffectDt" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].policyExpDt" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].policyCovge" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].riskCovge" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].productType" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].noOfDrivers" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].noOfVehi" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].noOfViola" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].noOfNamedInsu" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].assoPayReq" />
									<form:hidden
										path="tdmPolicyAutoSearchResultDTOList[${status.index}].assoDocReq" />
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
						<li><a href="policyAuto?page=<%=1%>">&lt;&lt;</a>
							<div>&lt;&lt;</div></li>
						<li><a href="policyAuto?page=<%=currentPage - 1%>">&lt;</a>
							<div>&lt;</div> <%
 	} else {
 				if (noOfPages > 1) {
 %>
						<li class="disable"><a href="policyAuto?page=<%=1%>">&lt;&lt;</a>
							<div>&lt;&lt;</div></li>
						<li class="disable"><a
							href="policyAuto?page=<%=currentPage - 1%>">&lt;</a>
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
						<li><a href="policyAuto?page=<%=i%>" id="employeeLink"><%=i%></a>
							<div><%=i%></div></li>
						<%
							}
										}
									}
									if (currentPage < noOfPages) {
						%>
						<li><a href="policyAuto?page=<%=currentPage + 1%>">&gt;</a>
							<div>&gt;</div></li>
						<li><a href="policyAuto?page=<%=noOfPages%>">&gt;&gt;</a>
							<div>&gt;&gt;</div></li>
						<%
							} else {
										if (noOfPages > 1) {
						%>
						<li class="disable"><a
							href="policyAuto?page=<%=currentPage + 1%>">&gt;</a>
							<div>&gt;</div></li>
						<li class="disable"><a href="policyAuto?page=<%=noOfPages%>">&gt;&gt;</a>
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
								<th scope="col"><input type="submit" name="reserve"
									class="btn-primary btn-cell" id="reserve" value="Reserve">
									<input type="submit" name="export" id="export"
									class="btn-primary btn-cell" value="Export to Excel"></th>
							</tr>
						</tbody>
					</table>

				</c:if>
			</form:form>
		</div>
		<script src="include/footer.js"></script>
	</div>

	<script>
		menu_highlight('Policy_Auto_Search');

		var checkboxes = $('.cb_class');

		$(document).ready(function() {
			 $('#assoPayReq1').change(function() {
			    	$('#myErrorCls').next(".my-error-class").remove(); 
			  		if( $('#assoPayReq1').attr("checked", "checked")) {
			  			$('#myErrorCls').after('<div class="my-error-class">The functionality on "Associated Payment" is currently awaited for PAS to be updated to the latest version.</div>');
			  			 $('input[type="submit"]').attr('disabled','disabled');
			  		} else {
			  			$('input[type="submit"]').removeAttr('disabled');
			  			$('#myErrorCls').next(".my-error-class").remove(); 
			  		}
			    });
			 
				 $('#assoPayReq2').change(function() {
			    	$('#myErrorCls').next(".my-error-class").remove(); 
			  		if( $('#assoPayReq2').attr("checked", "checked")) {
			  			$('#myErrorCls').after('<div class="my-error-class">The functionality on "Associated Payment" is currently awaited for PAS to be updated to the latest version.</div>');
			  			 $('input[type="submit"]').attr('disabled','disabled');
			  		} else {
			  			$('input[type="submit"]').removeAttr('disabled');
			  			$('#myErrorCls').next(".my-error-class").remove(); 
			  		}
			    });
				 
				 $('#assoPayReq3').change(function() {
				    	$('#myErrorCls').next(".my-error-class").remove(); 
				  		if( $('#assoPayReq3').attr("checked", "checked")) {
				  			$('#myErrorCls').next(".my-error-class").remove(); 
				  	 		$('input[type="submit"]').removeAttr('disabled');
				  		}
				    });
			 
			});
		
		$(document).ready(function() {
			var showHide = '${tdmPolicyAutoSearchDTO.showHideFlag}';
			if (showHide == 'true') {
				toggle2('myContent', 'myHeader');
			}
		});

		$(document).ready(function() {
			//toggle3('docContent', 'N');
			toggle3('paymethodContent', 'N');
			$("#assoPayReq1").click(function() {
				toggle3('paymethodContent', $('#assoPayReq1').val());
			});
			$("#assoPayReq2").click(function() {
				toggle3('paymethodContent', $('#assoPayReq2').val());
			});
			$("#assoPayReq3").click(function() {
				toggle3('paymethodContent', 'N');
			});
 
			if ($("#assoPayReq1").is(":checked")) {
				toggle3('paymethodContent', 'Y');
			}
 
		});

		 

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

		policyAutoSearchValidation();
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
