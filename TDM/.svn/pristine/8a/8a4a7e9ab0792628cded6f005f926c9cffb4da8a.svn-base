<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Central | Test Data Search</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link href="css/theme.default.css" rel="stylesheet">
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
	<div class="wrapper mainAll">
		<jsp:include page="indexHeader.jsp"></jsp:include>
		<script src="include/menu.js"></script>
		<div  class="container">
			<form:form id="testDataFormNon" name="testDataFormNon"
				action="./tdmNSSearch" modelAttribute="tdmNonStandSearchDTO">
				<div class="nav" id="myid">
					<table
						style="width: 100%; border: 0; font-size: 13px; cellpadding: 4;">
						<tbody>
							<tr>
								<td class="lable-title" width="30%" align="left" valign="middle"><spring:message
										code="label.ns.memCatt" /><span>*</span></td>
								<td class="flied-title" width="20%" align="left" valign="middle">
									<form:select path="memCat" id="memCat" class="down-control">
										<form:option value="">--Select--</form:option>
										<c:forEach var="memcat" items="${tdmNonStandSearchDTO.nonStandSrchFldsDTO.memCatagories}">
											<c:choose>
												<c:when test="${result ne null}">
												  <form:option value="${memcat}">${memcat}</form:option>
												</c:when>
												<c:otherwise>
												  <form:option value="${memcat}" selected="${memcat == 'Group' ? 'selected' : ''}">${memcat}</form:option>
												</c:otherwise>
											</c:choose>											
										</c:forEach>
									</form:select>
								</td>								
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.ns.state" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle" scope="col">
									<form:select path="provState" id="provState"
										class="down-control">
										<c:forEach var="state" items="${tdmNonStandSearchDTO.nonStandSrchFldsDTO.stateTypes}">
										<c:choose>
												<c:when test="${result ne null}">
												  <form:option value="${state}">${state}</form:option>
												</c:when>
												<c:otherwise>
												  <form:option value="${state}" selected="${state == 'Any' ? 'selected' : ''}">${state}</form:option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</form:select>
								</td>								
							</tr>

							<tr>							
							<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.ns.cov" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle" scope="col">

									<form:select path="coverageCode" id="coverageCode" multiple="true"
										class="down-control">
										<c:forEach var="cover" items="${tdmNonStandSearchDTO.nonStandSrchFldsDTO.coverageTypes}">
										<c:choose>
												<c:when test="${result ne null}">
												  <form:option value="${cover}">${cover}</form:option>
												</c:when>
												<c:otherwise>
												  <form:option value="${cover}" selected="${cover == 'Medical' ? 'selected' : ''}">${cover}</form:option>
												</c:otherwise>
											</c:choose>	
										</c:forEach>
									</form:select>
								</td>								
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.ns.plnType" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle" scope="col">

									<form:select path="planType" id="planType" multiple="true"
										class="down-control">
										<c:forEach var="plan" items="${tdmNonStandSearchDTO.nonStandSrchFldsDTO.planTypes}">
											<c:choose>
												<c:when test="${result ne null}">
												  <form:option value="${plan}">${plan}</form:option>
												</c:when>
												<c:otherwise>
												  <form:option value="${plan}" selected="${plan == 'PPO+' ? 'selected' : ''}">${plan}</form:option>
												</c:otherwise>
											</c:choose>										
										</c:forEach>
									</form:select>
								</td>
							</tr>

							<tr>
							  <td class="lable-title" align="left" valign="middle" scope="col"><spring:message
										code="label.ns.subRep" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle" scope="col">
									<form:select path="subscRelation" id="subscRelation" class="down-control">
										<c:forEach var="subRel" items="${tdmNonStandSearchDTO.nonStandSrchFldsDTO.subscRelations}">
										<c:choose>
												<c:when test="${result ne null}">
												  <form:option value="${subRel}">${subRel}</form:option>
												</c:when>
												<c:otherwise>
												  <form:option value="${subRel}" selected="${subRel == 'Any' ? 'selected' : ''}">${subRel}</form:option>
												</c:otherwise>
											</c:choose>											
										</c:forEach>
									</form:select>
								</td>
								
								<td class="lable-title" align="left" width="30%" valign="middle"
									scope="col"><spring:message code="label.ns.ageGrp" /></td>
								<td class="flied-title" align="left" width="20%" valign="middle"
									scope="col"><form:select path="ageGroup"
										id="ageGroup" class="down-control">
										<c:forEach var="ageGrp" items="${tdmNonStandSearchDTO.nonStandSrchFldsDTO.ageGroups}">
											<c:choose>
												<c:when test="${result ne null}">
												  <form:option value="${ageGrp}">${ageGrp}</form:option>
												</c:when>
												<c:otherwise>
												  <form:option value="${ageGrp}" selected="${ageGrp == 'Any' ? 'selected' : ''}">${ageGrp}</form:option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</form:select></td>								
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.ns.sts" /><span>*</span></td>
								<td class="flied-title" align="left" valign="middle"><form:select
										path="subscStatus" id="subscStatus" class="down-control">
										<c:forEach var="memStat" items="${tdmNonStandSearchDTO.nonStandSrchFldsDTO.memStatus}">
										<c:choose>
												<c:when test="${result ne null}">
												  <form:option value="${memStat}">${memStat}</form:option>
												</c:when>
												<c:otherwise>
												 <form:option value="${memStat}" selected="${memStat == 'Any' ? 'selected' : ''}">${memStat}</form:option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</form:select></td>									
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.ns.extClm" /></td>
								<td class="flied-title" align="left" valign="middle" scope="col">
									<form:select path="extClaim" id="extClaim" multiple="true" class="down-control">
										<c:forEach var="clmType" items="${tdmNonStandSearchDTO.nonStandSrchFldsDTO.claimTypes}">
										<c:choose>
												<c:when test="${result ne null}">
												 <form:option value="${clmType}">${clmType}</form:option>
												</c:when>
												<c:otherwise>
												  <form:option value="${clmType}" selected="${clmType == 'Any' ? 'selected' : ''}">${clmType}</form:option>
												</c:otherwise>
											</c:choose>	
										</c:forEach>
									</form:select>
								</td>								
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.ns.acName" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="accountName" id="accountName" class="form-control autosearch" maxlength="21" /></td>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.ns.acNum" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="accountNum" id="accountNum" class="form-control autosearch"
										maxlength="21" /></td>								
							</tr>

							<tr>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.ns.subId" /></td>
								<td class="flied-title" align="left" valign="middle"><form:input
										path="subscId" id="subscId" class="form-control"
										maxlength="21" /></td>							</tr>

						</tbody>
						<tbody id="myContent">
						</tbody>
						<tr>
							<td class="lable-title" align="left"><spring:message
									code="label.noOfRec" /></td>
							<td class="flied-title"><form:select path="searchRecordsNo"
									id="searchRecordsNo" class="down-control-small">
									<form:option value="5">5</form:option>
									<form:option value="10">10</form:option>
									<form:option value="15">15</form:option>
									<form:option value="20">20</form:option>
									<form:option value="30">30</form:option>
								</form:select></td>
						</tr>
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
									onClick="clearFields('./tdmNonStandardSearch');"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<br />
				<br />
				<c:if
					test="${tdmNonStandSearchDTO.tdmNonStandardSrchResultListDTOs eq null}">

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
						<table
							style="width: 100%; border: 0; font-size: 12px; color: #EC0B2D; cellpadding: 4;">
							<tbody>
								<tr>
									<td class="lable-title" align="left" valign="middle">No
										Records Found <a href="javascript:;" class="l1l2Support"
								onclick="popupuser('./popupEmail','L1/L2 Support','popup','popupOverlay','500');"><label class="l1l2Support">contact for L1/L2 support.
									?</label></a></td>
								</tr>
							</tbody>
						</table>						
					</c:if>
				</c:if>

				<c:if
					test="${tdmNonStandSearchDTO.tdmNonStandardSrchResultListDTOs ne null &&  not empty tdmNonStandSearchDTO.tdmNonStandardSrchResultListDTOs}">


					<table
						style="width: 100%; border: 0; font-size: 12px; font-style: italic; color: #7C6DC2; cellpadding: 4;">
						<tbody>
							<tr>
								<td class="lable-title" align="left" valign="middle">
									${result}</td>

							</tr>
						</tbody>
					</table>

					<table
						style="width: 100%; border: 0; font-size: 12px; font-style: italic; color: #7C6DC2; cellpadding: 4;">
						<tbody>
							<tr>
								<td class="lable-title" align="right" valign="middle"><spring:message
										code="label.totRecFetc" />${totalRecords}</td>
							</tr>
						</tbody>
					</table>
				</c:if>
				<c:if test="${show eq true &&  not empty tdmNonStandSearchDTO.tdmNonStandardSrchResultListDTOs}">

					<table
						style="width: 100%; border: 0; font-size: 13px; cellpadding: 4;">
						<tbody>
							<tr>
								<td  class="lable-title" align="left" valign="middle"><spring:message
										code="label.tcId" /><span>*</span></td>
								<td  align="left" valign="middle"><form:input
										path="testCaseId" id="testCaseId"
										class="down-control-small mandetCls1" /></td>
								<td class="lable-title" align="left" valign="middle"><spring:message
										code="label.tcName" /><span>*</span></td>
								<td  align="left" valign="middle"><form:input
										path="testCaseName" id="testCaseName"
										class="down-control-small mandetCls2" /></td>
								<td align="left" valign="middle">Application
									ID</td>
								<td  align="left" valign="baseline"><form:input
										path="applicationId" id="applicationId"
										class="down-control-small mandetCls3" /></td>
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
											code="lebel.chkbResrv" /></th>
									<th bgcolor="#E3EFFB" height="25" class="whitefont">Subscriber ID</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Member
										Type</th>
									<th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message
											code="label.prov.fname" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message
											code="label.prov.lname" /></th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Date
										of Birth</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Home
										Zip Code</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">A/C
										Number</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">A/C
										Name</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">EOB
										Suppressed</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Blend
										Government</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Blend
										Group</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Blend
										Retail</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Coverage</th>
									<th bgcolor="#E3EFFB" scope="col" class="whitefont">Existing
										Claim</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="tdmNonStandardSrchResultListDTO" items="${tdmNonStandSearchDTO.tdmNonStandardSrchResultListDTOs}" varStatus="status">
							<tr>
							     <c:if test="${tdmNonStandardSrchResultListDTO.reservedYN eq null }">
									<td><label class="checkbox-inline">
									<form:checkbox path="tdmNonStandardSrchResultListDTOs[${status.index}].reservedYN"
									id="tdmNonStandardSrchResultListDTOs[${status.index}].reservedYN"
														class="cb_class checkBoxCls" value='${tdmNonStandardSrchResultListDTO.subscId}' />
							 
									</label></td>
                                    </c:if>
									<td>${tdmNonStandardSrchResultListDTO.subscId}</td>
									<td>${tdmNonStandardSrchResultListDTO.memType}</td>
									<td>${tdmNonStandardSrchResultListDTO.firstName}</td>
									<td>${tdmNonStandardSrchResultListDTO.lastName}</td>									
									<td>${tdmNonStandardSrchResultListDTO.dob}</td>
									<td>${tdmNonStandardSrchResultListDTO.homeZipCode}</td>
									<td>${tdmNonStandardSrchResultListDTO.acNum}</td>
									<td>${tdmNonStandardSrchResultListDTO.acName}</td>
									<td>${tdmNonStandardSrchResultListDTO.eobSuppressed}</td>
									<td>${tdmNonStandardSrchResultListDTO.blendGov}</td>
									<td>${tdmNonStandardSrchResultListDTO.blendGroup}</td>
									<td>${tdmNonStandardSrchResultListDTO.blendRetail}</td>
									<td>${tdmNonStandardSrchResultListDTO.coverageCode}</td>
									<td>${tdmNonStandardSrchResultListDTO.extClaim}</td>									
								</tr>
							</c:forEach>								
							</tbody>
						</table>
					</div>

					<br>
					<table style="width: 100%; border: 0">
						<tbody>
							<tr>
								<th scope="col"><input type="submit" name="reserve"
									class="btn-primary btn-cell" id="reserve" value="Reserve">
									<input type="submit" name="export" id="export"
									class="btn-primary btn-cell" value="ExportAll to Excel">
									<input type="button" name="generatex12" id="generatex12"
									class="btn-primary btn-cell" value="Generate X12">
									<input type="button" name="loadData" id="loadData"
									class="btn-primary btn-cell" value="Load Data"></th>									
							</tr>
						</tbody>
					</table>

				</c:if>
				<c:if
					test="${tdmNonStandSearchDTO.tdmNonStandardSrchResultListDTOs ne null &&  not empty tdmNonStandSearchDTO.tdmNonStandardSrchResultListDTOs}">
                 
					<c:forEach
						items="${tdmNonStandSearchDTO.tdmNonStandardSrchResultListDTOs}"
						var="tdmNonStandardSrchResultListDTOs" varStatus="status">
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].memId" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].subscId" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].memType" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].firstName" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].lastName" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].provState" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].homeZipCode" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].dob" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].acNum" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].acName" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].eobSuppressed" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].blendGov" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].blendGroup" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].blendRetail" />
						<form:hidden
							path="tdmNonStandardSrchResultListDTOs[${status.index}].extClaim" />
					</c:forEach>

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

				</c:if>
				<!-- Pagination Ends -->


			</form:form>
		</div>

	</div>
     <script src="include/footer.js"></script>
	<script>
  menu_highlight('Non_Standard_Search');
  testDataFormNon();
  $(document).ready(function() {
		$( "#accountName" ).autocomplete({
			source: './tdmNonStandAuto?type=acName',
			minLength:2,
			scroll: true,
	        scrollHeight: 180
		});
		
	});

$(document).ready(function() {
		$( "#accountNum" ).autocomplete({
			source: './tdmNonStandAuto?type=acNum',
			minLength:2,
			scroll: true,
	        scrollHeight: 180
		});
		
	});
	
$(document).ready(function() {
	$( "#subscId" ).autocomplete({
		source: './tdmNonStandAuto?type=subscID',
		minLength:2,
		scroll: true,
        scrollHeight: 180
	});
	
});
  
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
	    
	    $('#subscStatus').change(function() {
	    	$('#subscStatus').next(".my-error-class").remove(); 
	        var secondVal = $(this).val();
	        var selectedVal = $("#subscRelation").val(); 		
	  		if(secondVal == "Subscriber - Active with Active Dependent(s)" && selectedVal=="Subscriber Only")
	  		{
	  			$('#subscStatus').after('<div class="my-error-class">User initially requested Subscriber Only information.</div>');
	  			 $('input[type="submit"]').attr('disabled','disabled');
	  		}
	  		else
	  		{
	  			$('input[type="submit"]').removeAttr('disabled');
	  		}
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
	    	    if(selected > 5)
	    	    {
	    	     $('#search_output_table').after('<div class="my-error-class">Only 5 records are allowed for reservation.</div>');
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
	    
	    $("#generatex12").click(function(){
	    	$('.mandetCls1').next(".my-error-class").remove(); 
	    	$('.mandetCls2').next(".my-error-class").remove(); 
	    	$('#search_output_table').next(".my-error-class").remove(); 
	    	var checkboxes = $('.checkBoxCls');
	      	  var selected = checkboxes.filter(":checked").length;
	    	    if (selected == false) {
	    		  $('#search_output_table').after('<div class="my-error-class">There is no selection of the records from Search Result</div>');
	    		  return false;
	      	    }
	    	    if(selected > 1)
	    	    {
	    	     $('#search_output_table').after('<div class="my-error-class">Only 1 record is allowed to generate X12 format.</div>');
	    	    	  return false;
	    	    }
	    	    var slectedSubId;
	    	    
	    	    $('.checkBoxCls:checked').each(function () {
	    	    	slectedSubId = $(this).val() + ",";
	              });
	    	    popupuser('./x12Format?subId='+slectedSubId,'Generate X12 Format','popup','popupOverlay','700');
	        	     	  
	         });
	    
	    $("#loadData").click(function() {
	    	document.location.href="./tdmDataMaskingNew";
	    });
	    
	  });
  
  </script>
</body>
</html>
