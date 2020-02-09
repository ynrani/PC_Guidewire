<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Portal | Non Standard Search</title>
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
	<div id="main" class="wrapper">
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
			<form:form id="testDataFormNon" name="testDataFormNon"
				action="${pageContext.request.contextPath}/testdaNonStand"
				modelAttribute="tdmNonStandSearchDTO">
				<div class="">
					<input type="hidden" name="userId" value="${sessionScope.userId}" />
					<table style="width: 100%; border: 0; font-size: 13px;">
						<tbody>
							<tr>
								<td class="lable-title" width="35%" align="left" valign="middle"><spring:message
										code="label.env" /><span>*</span></td>
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
								<td class="lable-title" width="20%" align="left" valign="middle"
									scope="col">
							</tr>
							<tr>

								<td class="lable-title" align="left" valign="middle" scope="col"><spring:message
										code="label.subc.type" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle" scope="col">

									<form:select path="subscType" id="subscType"
										class="down-control">
										<form:option value="">--Select--</form:option>
										<c:forEach
											items="${tdmNonStandSearchDTO.tdmSubscTypeMastDTOs}"
											var="tdmSubscTypeMastDTOs">
											<form:option value="${tdmSubscTypeMastDTOs.subscTypeDesc}">${tdmSubscTypeMastDTOs.subscTypeDesc}</form:option>
										</c:forEach>
									</form:select>
								</td>

								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.gender" /></td>
								<td class="flied-title" class="flied-title" align="left"
									valign="middle"><label class="radio-inline"> <form:radiobutton
											path="gender" id="gender" value="Male" /> <spring:message
											code="label.male" /></label> <label class="radio-inline"> <form:radiobutton
											path="gender" id="gender" value="FeMale" /> <spring:message
											code="label.female" />
								</label> <label class="radio-inline"> <form:radiobutton
											path="gender" id="gender" value="Both" /> <spring:message
											code="label.both" />
								</label></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.prov.type" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="provType" id="provType" class="down-control">
										<form:option value="">--Select--</form:option>
										<c:forEach
											items="${tdmNonStandSearchDTO.tdmProviderTypeParentDTOs}"
											var="tdmProviderTypeParentDTOs">
											<form:option
												value="${tdmProviderTypeParentDTOs.providerTypeName}">${tdmProviderTypeParentDTOs.providerTypeName}</form:option>
										</c:forEach>
									</form:select>
								<td class="lable-title" align="left" valign="middle" scope="col">
									<spring:message code="label.prov.cat" />
								</td>
								<td class="flied-title" align="left" valign="middle" scope="col">
									<form:select path="provCatgType" id="provCatgType"
										class="down-control">
										<form:option value="">All</form:option>
										<c:forEach
											items="${tdmNonStandSearchDTO.tdmProviderCatParentDTOs}"
											var="tdmProviderCatParentDTOs">
											<form:option
												value="${tdmProviderCatParentDTOs.providerCategoryName}">${tdmProviderCatParentDTOs.providerCategoryName}</form:option>
										</c:forEach>
									</form:select>
								</td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.prov.spec" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="provSpecType" id="provSpecType" multiple="true"
										class="down-control">
										<form:option value="">All</form:option>
										<c:forEach items="${tdmNonStandSearchDTO.specDropdown}"
											var="specDropdown">
											<form:option value="${specDropdown}">${specDropdown}</form:option>
										</c:forEach>
									</form:select></td>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.state" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="provState" id="provState" multiple="true"
										class="down-control">
										<form:option value="">All</form:option>
										<c:forEach items="${tdmNonStandSearchDTO.tdmUsStateDTOs}"
											var="tdmUsStateDTOs">
											<form:option value="${tdmUsStateDTOs.stateName}">${tdmUsStateDTOs.stateName}</form:option>
										</c:forEach>
									</form:select></td>

							</tr>
							<tr>

								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.subc.status" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="subscStatus" id="subscStatus" class="down-control">
										<form:option value="">All</form:option>
										<c:forEach
											items="${tdmNonStandSearchDTO.tdmSubscStatusMastDTOs}"
											var="tdmSubscStatusMastDTOs">
											<form:option
												value="${tdmSubscStatusMastDTOs.subscStatusDesc}">${tdmSubscStatusMastDTOs.subscStatusDesc}</form:option>
										</c:forEach>
									</form:select></td>

								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.prov.contract" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="provContract" id="provContract" class="down-control">
										<form:option value="">All</form:option>
										<form:option value="Participating">Participating</form:option>
										<form:option value="Non-Participating">Non-Participating</form:option>
									</form:select></td>
							</tr>


							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.claim.status" /></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="claimStatus" id="claimStatus" class="down-control">
										<form:option value="">All</form:option>
										<c:forEach
											items="${tdmNonStandSearchDTO.tdmClaimStatusMastDTOs}"
											var="tdmClaimStatusMastDTOs">
											<form:option
												value="${tdmClaimStatusMastDTOs.claimStatusDesc}">${tdmClaimStatusMastDTOs.claimStatusDesc}</form:option>
										</c:forEach>
									</form:select></td>
							</tr>

						</tbody>



						<tbody id="myContent">

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.subc.dob" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="dob" id="dob" class="datepicker date-control" /></td>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.prov.tmDt" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="termDate" id="termDate" class="date-control datepicker"
										readonly="ture" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.claim.dx.code" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="claimDXCode" id="claimdxCode" class="form-control"
										maxlength="21" /></td>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.claim.proc.code" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="claimProcCode" id="claimProcCode" class="form-control"
										maxlength="21" /></td>
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.claim.groupnum" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="claimGrpNum" id="claimGrpNum" class="form-control"
										maxlength="21" /></td>
							</tr>
						</tbody>

						<tbody id="headerDiv">
							<tr>
								<td align="left" valign="middle"></td>
								<td align="left" valign="middle"></td>
								<td align="left" valign="middle"></td>
								<td class="lable-title" align="left" valign="middle"><a
									id="myHeader"
									href="javascript:toggle2('myContent','myHeader');"> <spring:message
											code="label.showLink" />
								</a></td>
							</tr>
						</tbody>

						<tr>
							<td class="lable-title" align="left"><spring:message
									code="label.noOfRec" /></td>
							<td class="flied-title"><form:select path="searchRecordsNo"
									id="searchRecordsNo" class="down-control-small">
									<form:option value="10">10</form:option>
									<form:option value="15">20</form:option>
									<form:option value="20">30</form:option>
								</form:select></td>
						</tr>

					</table>

					<table style="width: 100%; border: 0; font-size: 13px;">
						<tbody>
							<tr>
								<td colspan="4" align="center" valign="middle"><input
									type="submit" name="search" id="Search"
									class="btn-primary btn-cell"
									value="<spring:message code="button.serch"/>"> <input
									type="reset" value="Reset" class="btn-primary btn-cell"
									onClick="clearFields('./testdaNonStand');"></td>
							</tr>
						</tbody>
					</table>

				</div>
				<br />
				<br />




				<c:if
					test="${tdmNonStandSearchDTO.tdmNonStandardResultListDTOs eq null}">

					<c:if test="${result ne null}">
						<table
							style="width: 100%; border: 0; font-size: 12px; font-style: italic; color: #7C6DC2">
							<tbody>
								<tr>
									<td class="lable-title" align="left" valign="middle">
										${result}</td>

								</tr>
							</tbody>
						</table>


						<br />
						<br />
						<table
							style="width: 100%; border: 0; font-size: 12px; color: #EC0B2D">
							<tbody>
								<tr>
									<td class="lable-title" align="left" valign="middle">No
										Records Found</td>

								</tr>
							</tbody>
						</table>
					</c:if>
				</c:if>

				<c:if
					test="${tdmNonStandSearchDTO.tdmNonStandardResultListDTOs ne null &&  not empty tdmNonStandSearchDTO.tdmNonStandardResultListDTOs}">
					<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%>

					<table
						style="width: 100%; border: 0; font-size: 12px; font-style: italic; color: #7C6DC2">
						<tbody>
							<tr>
								<td class="lable-title" align="left" valign="middle">
									${result}</td>

							</tr>
						</tbody>
					</table>

					<table
						style="width: 100%; border: 0; font-size: 12px; font-style: italic; color: #7C6DC2">
						<tbody>
							<tr>
								<td class="lable-title" align="right" valign="middle"><spring:message
										code="label.totRecFetc" />${totalRecords}</td>
							</tr>
						</tbody>
					</table>

					<table style="width: 100%; border: 0; font-size: 13px;">
						<tbody>
							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.tcId" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="testCaseId" id="testCaseId"
										class="down-control-small mandetCls1" /></td>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.tcName" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="testCaseName" id="testCaseName"
										class="down-control-small mandetCls2" /></td>
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
							style="width: 100%; font-size: 13px;">
							<thead>
								<tr>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="lebel.chkb" /></th>
									<th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message
											code="label.subc.subcId" /></th>
									<th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message
											code="label.prov.fname" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.lname" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.subc.stype" /></th>
									<th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message
											code="label.subc.grp" /></th>
									<th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message
											code="label.subc.state" /></th>
									<th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message
											code="label.subc.zip" /></th>
									<th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message
											code="label.subc.ssn" /></th>

									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.provId" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.ptype" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.catg" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.speciality" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.tin" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.npi" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.contract" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.termdt" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.state" /></th>

									<th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message
											code="label.claim.claimId" /></th>
									<th bgcolor="#0328FF" scope="col" class="whitefont"><spring:message
											code="label.claim.status" /></th>


								</tr>
							</thead>
							<tbody>
								<c:forEach
									items="${tdmNonStandSearchDTO.tdmNonStandardResultListDTOs}"
									var="tdmNonStandardResultListDTOs" varStatus="status">
									<tr>
										<c:if
											test="${tdmNonStandardResultListDTOs.reservedYN eq null }">
											<td><label class="checkbox-inline"> <form:checkbox
														path="tdmNonStandardResultListDTOs[${status.index}].reservedYN"
														id="tdmNonStandardResultListDTOs[${status.index}].reservedYN"
														class="cb_class checkBoxCls" value="Yes" />
											</label></td>
										</c:if>

										<td>${tdmNonStandardResultListDTOs.subscriberId}</td>
										<td>${tdmNonStandardResultListDTOs.firstName}</td>
										<td>${tdmNonStandardResultListDTOs.lastName}</td>
										<td>${tdmNonStandardResultListDTOs.subcType}</td>
										<td>${tdmNonStandardResultListDTOs.subscriberNames}</td>
										<td>${tdmNonStandardResultListDTOs.subcState}</td>
										<td>${tdmNonStandardResultListDTOs.subcZip}</td>
										<td>${tdmNonStandardResultListDTOs.ssn}</td>

										<td>${tdmNonStandardResultListDTOs.providerId}</td>
										<td>${tdmNonStandardResultListDTOs.provType}</td>
										<td>${tdmNonStandardResultListDTOs.specialityDescription}</td>
										<td>${tdmNonStandardResultListDTOs.provCatgType}</td>
										<td>${tdmNonStandardResultListDTOs.tin}</td>
										<td>${tdmNonStandardResultListDTOs.npi}</td>
										<td>${tdmNonStandardResultListDTOs.provContactType}</td>
										<td>${tdmNonStandardResultListDTOs.terminationDate}</td>
										<td>${tdmNonStandardResultListDTOs.provState}</td>

										<td>${tdmNonStandardResultListDTOs.claimId}</td>
										<td>${tdmNonStandardResultListDTOs.claimStatus}</td>
									</tr>
								</c:forEach>

								<c:forEach
									items="${tdmNonStandSearchDTO.tdmNonStandardResultListDTOs}"
									var="tdmNonStandardResultListDTOs" varStatus="status">

									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].subscriberId" />

									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].firstName" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].lastName" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].subcType" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].subscriberNames" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].subcState" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].subcZip" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].ssn" />

									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].providerId" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].provType" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].specialityDescription" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].provCatgType" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].provState" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].tin" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].npi" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].provContactType" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].terminationDate" />

									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].claimId" />
									<form:hidden
										path="tdmNonStandardResultListDTOs[${status.index}].claimStatus" />

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
						<li><a href="testdaNonStand?page=<%= 1 %>">&lt;&lt;</a>
							<div>&lt;&lt;</div></li>
						<li><a href="testdaNonStand?page=<%= currentPage-1 %>">&lt;</a>
							<div>&lt;</div> <%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
						<li class="disable"><a href="testdaNonStand?page=<%= 1 %>">&lt;&lt;</a>
							<div>&lt;&lt;</div></li>
						<li class="disable"><a
							href="testdaNonStand?page=<%= currentPage-1 %>">&lt;</a>
							<div>&lt;</div> <%
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
						<li><a href="testdaNonStand?page=<%= i %>" id="employeeLink"><%= i %></a>
							<div><%= i %></div></li>
						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
						<li><a href="testdaNonStand?page=<%= currentPage+1 %>">&gt;</a>
							<div>&gt;</div></li>
						<li><a href="testdaNonStand?page=<%= noOfPages %>">&gt;&gt;</a>
							<div>&gt;&gt;</div></li>
						<%
											} else {
											    if(noOfPages > 1) {
										%>
						<li class="disable"><a
							href="testdaNonStand?page=<%= currentPage+1 %>">&gt;</a>
							<div>&gt;</div></li>
						<li class="disable"><a
							href="testdaNonStand?page=<%= noOfPages %>">&gt;&gt;</a>
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
									<!--  <input type="submit" name="export" id="export" class="btn-primary btn-cell" value="Export to Excel"> -->
								</th>
							</tr>
						</tbody>
					</table>
				</c:if>
			</form:form>
		</div>

	</div>

	<script>
  menu_highlight('Non_Standard_Search');
  /* var checkboxes = $('.cb_class');
  checkboxes.on('click', function () {
    var limit = '${count}';
    var curLimit = Math.abs(limit - 5);
    var selected = checkboxes.filter(":checked").length;
    if (selected > curLimit) {
      alert("You cannot 'Reserve' more than  " + curLimit + " in this selection.");
      $(this).prop('checked', false);
    }
  }); */
  $(document).ready(function () {
    var showHide = '${tdmNonStandSearchDTO.showHideFlag}';
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
  testDataFormNon();
  
  
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
  
  </script>
</body>
</html>
