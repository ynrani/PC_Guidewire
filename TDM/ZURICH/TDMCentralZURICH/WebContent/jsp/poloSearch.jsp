<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title> TDM Central | Data Search</title>
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
       <c:if test="${error ne null}">
	            <table class="my-error-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${error}</td>	                
	                </tr>
	              </tbody>
	            </table>
	           </c:if>           
        <form:form id="testDataForm" name="testDataForm" action="${pageContext.request.contextPath}/poloSearch" modelAttribute="tdmPoloSearchDTO">
          <div class="">
            <input type="hidden" name="userId" value="${sessionScope.userId}" />
            <table style="width:100%; border:0; font-size: 13px; cellpadding:4;">
              <tbody>
               <tr style="border-bottom: 1px solid black;">
               <td style="font-size: 15px"> <b> Policy Variables : </b></td>
               </tr>   
                	<tr>
		                <td class="lable-title" width="35%" align="left" valign="middle">
		                    <spring:message code="label.polo.db" />
		                  </td>
		                  <td  width="20%" class="flied-title" align="left" valign="middle">
		                    <form:select path="database" id="database" class="down-control">
		                     <form:option value="POLO">POLO</form:option>
		                        <form:option value="FAME">FAME</form:option>
		                      <form:option value="UNITY">UNITY</form:option>
		                       <form:option value="CHS">CHS</form:option> 
		                      <form:option value="COPYDB">COPYDB</form:option>
		                      <form:option value="DUCKGREEK">DUCKGREEK</form:option>
		                    </form:select>
		                  </td>
		                
		                
		                 <td  width="20%" class="lable-title" align="left" valign="middle" scope="col" >
                          <spring:message code="label.polo.lob" />
                        </td>
		                  <td  width="25%" class="flied-title" align="left" valign="middle">
		                    <form:select path="lineOFBusiness" id="lineOFBusiness" class="down-control">
		                     <form:option value="Personal Lines">Personal Lines</form:option>
		                        <form:option value="Commercial Lines">Commercial Lines</form:option>
		                      <form:option value="Property">Property</form:option>
		                       <form:option value="Vehicle">Vehicle</form:option> 
		                      <form:option value="Auto Insurance">Auto Insurance</form:option>
		                    </form:select>
		                  </td>
                	</tr>
              
                <tr>               
                  <td scope="col" class="lable-title" align="left" valign="middle">
                    <spring:message code="label.polo.stat" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="status" id="status" class="down-control">
                     <form:option value="Active">Active</form:option>
                        <form:option value="Inactive">Inactive</form:option>   
                      <form:option value="Dormant">Dormant</form:option>                     
                        <form:option value="Closed">Closed</form:option>
                        <form:option value="Open">Open</form:option>
                    </form:select>
                  </td>
                
                  <td class="lable-title"  align="left" valign="middle" scope="col" >
                  <spring:message code="label.polo.pType" /></td>
                   <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="prodType" id="prodType" class="down-control">
                     <form:option value="Product1">Product1</form:option>
                        <form:option value="Product2">Product2</form:option>   
                      <form:option value="Product3">Product3</form:option>                     
                        <form:option value="Product4">Product4</form:option>
                        <form:option value="Product5">Product5</form:option>
                    </form:select>
                  </td>            
                  
                </tr>
                <tr>
                  <td class="lable-title"  align="left" valign="middle" scope="col" >
                  <spring:message code="label.polo.subDiv" /></td>
                   <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="subsDivision" id="subsDivision" class="down-control">
                     <form:option value="Selection Criteria 1">Selection Criteria 1</form:option>
                        <form:option value="Selection Criteria 2">Selection Criteria 2</form:option>   
                      <form:option value="Selection Criteria 3">Selection Criteria 3</form:option>                     
                        <form:option value="Selection Criteria 4">Selection Criteria 4</form:option>
                    </form:select>
                  </td>                                                            
                </tr>
                
                <tr>
                  <td class="lable-title"  align="left" valign="middle" scope="col" >
                  <spring:message code="label.polo.covTSDT" /></td>
		                 <td class="flied-title" align="left" valign="middle" scope="col" >
                         <form:input path="covTermStartDate" id="covTermStartDate" class="datepicker date-control" />
                        </td>
                        
                  <td class="lable-title"  align="left" valign="middle" scope="col" >
                  <spring:message code="label.polo.covTEDT" /></td>
		            <td class="flied-title" align="left" valign="middle" scope="col" >
                      <form:input path="covTermEndDate" id="covTermEndDate" class="datepicker date-control" />
                     </td>                                                             
                </tr>
                
                 <tr>               
                  <td scope="col" class="lable-title" align="left" valign="middle">
                    <spring:message code="label.polo.vGrp" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="vehicleGrp" id="vehicleGrp" class="down-control">
                     <form:option value="Group1">Group1</form:option>
                        <form:option value="Group2">Group2</form:option>   
                      <form:option value="Group3">Group3</form:option>                     
                        <form:option value="Group4">Group4</form:option>
                        <form:option value="Group5">Group5</form:option>
                    </form:select>
                  </td>
                
                  <td class="lable-title"  align="left" valign="middle" scope="col" >
                  <spring:message code="label.polo.pTypeCode" /></td>
                   <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="premTypeCode" id="premTypeCode" class="down-control">
                     <form:option value="Type1">Type1</form:option>
                        <form:option value="Type2">Type2</form:option>   
                      <form:option value="Type3">Type3</form:option>                     
                        <form:option value="Type4">Type4</form:option>
                        <form:option value="Type5">Type5</form:option>
                    </form:select>
                  </td>            
                  
                </tr>
                
                
                  <tr>               
                  <td scope="col" class="lable-title" align="left" valign="middle">
                    <spring:message code="label.polo.ipHStCode" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="insurncePolHStatCode" id="insurncePolHStatCode" class="down-control">
                     <form:option value="Group1">Group1</form:option>
                       <form:option value="Group2">Group2</form:option>   
                      <form:option value="Group3">Group3</form:option>                     
                        <form:option value="Group4">Group4</form:option>
                        <form:option value="Group5">Group5</form:option>
                    </form:select>
                  </td>  
                </tr>
                
                <tr></tr>  
                <tr></tr>              
               <tr style="border-bottom: 1px solid #000;">
               <td style="font-size: 15px"> <b> Policy Holder Variables : </b></td>
               </tr>               
                
                <tr></tr> 
                <tr>
                  <td class="lable-title"  width="35%" align="left" valign="middle" scope="col" >
                    <spring:message code="label.polo.pht" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="policyHoldrType" id="policyHoldrType" class="down-control">
                     <form:option value="">--Select--</form:option>
                        <form:option value="Sole">Sole</form:option>
                      <form:option value="Joint">Joint</form:option>
                       <form:option value="Organization">Organization</form:option>
                      <form:option value="Individual">Individual</form:option>
                    </form:select>
                  </td>
                    <td class="lable-title"  width="35%" align="left" valign="middle" scope="col" >
                    <spring:message code="label.polo.phi" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="policyHistoryId" id="policyHistoryId" class="down-control">
                     <form:option value="">--Select--</form:option>
                        <form:option value="Id1">ID1</form:option>
                      <form:option value="ID2">ID2</form:option>
                       <form:option value="ID3">ID3</form:option>
                      <form:option value="ID4">ID4</form:option>
                    </form:select>
                  </td>                
                </tr> 
                
                <tr>
                  <td class="lable-title"  width="35%" align="left" valign="middle" scope="col" >
                    <spring:message code="label.polo.phr" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="policyHolderRegion" id="policyHolderRegion" class="down-control">
                     <form:option value="">--Select--</form:option>
                        <form:option value="Sole">Sole</form:option>
                      <form:option value="Joint">Joint</form:option>
                       <form:option value="Organization">Organization</form:option>
                      <form:option value="Individual">Individual</form:option>
                    </form:select>
                  </td>
                    <td class="lable-title"  width="35%" align="left" valign="middle" scope="col" >
                    <spring:message code="label.polo.mtd" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col" >
                   <form:input path="mfuTypeDSC" id="mfuTypeDSC" class="form-control" />
                  </td>       
                </tr>     
                     
              </tbody> 
            </table>
           
            <table style="width:100%; border:0; font-size: 13px; cellpadding:4;">
              <tbody>
               <tr>
				<td class="lable-title" align="left" width="30%"><spring:message
									code="label.noOfRec" /></td>
							<td width="30%" class="flied-title"><form:select path="searchRecordsNo"
									id="searchRecordsNo" class="down-control-small">
									<form:option value="5">5</form:option>
									<form:option value="10">10</form:option>
									<form:option value="15">15</form:option>
									<form:option value="20">20</form:option>
									<form:option value="30">30</form:option>
								</form:select></td>
								  <td class="lable-title" width="20%" align="left" valign="middle">
                                  <td class="lable-title" width="20%" align="left" valign="middle">
						</tr>
                <tr>
                  <td colspan="4" align="center" valign="middle">
                   <input type="submit" name="search" id="Search" class="btn-primary btn-cell" value="<spring:message code="button.serch"/>">
                    <input type="reset" value="Reset" class="btn-primary btn-cell" >
                  </td>
                </tr>
              </tbody>
            </table>

          </div>
          <br/>
          <br/>            
            <c:if
					test="${tdmPoloSearchDTO.poloSearchResultList eq null}">

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
	        
	         <c:if test="${tdmPoloSearchDTO.poloSearchResultList eq null}">
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

          <c:if test="${tdmPoloSearchDTO.poloSearchResultList ne null &&  not empty tdmPoloSearchDTO.poloSearchResultList}">
							<%-- 	<%
									int currentPage = (Integer) request.getAttribute("currentPage");
									int count1 = currentPage - 1;
									count1 = count1 * 10;
					 
								%>  --%>
            
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
                    
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.polId" /></th>
                     <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.polHId" /></th>
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.fName" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.lName" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.addr1" /></th>
                     <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.addr2" /></th>
                      <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.addr3" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.city" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.region" /></th>                    
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.country" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.postCode" /></th>             
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${tdmPoloSearchDTO.poloSearchResultList}" var="poloSearchResultList" varStatus="status">
                    <tr>
                      <c:if test="${poloSearchResultList.reservedYN eq null }">
                        <td>
                          <label class="checkbox-inline">
                            <form:checkbox path="poloSearchResultList[${status.index}].reservedYN" id="poloSearchResultList[${status.index}].reservedYN" class="cb_class checkBoxCls" value="Yes" />
                          </label>
                        </td>
                      </c:if>

                      <td>${poloSearchResultList.insPolId}</td>
                      <td>${poloSearchResultList.policyHolderId}</td>
                      <td>${poloSearchResultList.firstName}</td>
                      <td>${poloSearchResultList.lastName}</td>
                      <td>${poloSearchResultList.address1}</td>
                      <td>${poloSearchResultList.address2}</td>
                      <td>${poloSearchResultList.address3}</td>
                      <td>${poloSearchResultList.city}</td>
                      <td>${poloSearchResultList.region}</td>
                      <td>${poloSearchResultList.country}</td>
                      <td>${poloSearchResultList.postalCode}</td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tdmPoloSearchDTO.poloSearchResultList}" var="poloSearchResultList" varStatus="status">

                    <form:hidden path="poloSearchResultList[${status.index}].insPolId" />
                     <form:hidden path="poloSearchResultList[${status.index}].policyHolderId" />
                    <form:hidden path="poloSearchResultList[${status.index}].firstName" />
                    <form:hidden path="poloSearchResultList[${status.index}].lastName" />
                     <form:hidden path="poloSearchResultList[${status.index}].address1" />
                      <form:hidden path="poloSearchResultList[${status.index}].address2" />
                       <form:hidden path="poloSearchResultList[${status.index}].address3" />
                    <form:hidden path="poloSearchResultList[${status.index}].city" />
                    <form:hidden path="poloSearchResultList[${status.index}].region" />
                    <form:hidden path="poloSearchResultList[${status.index}].country" />
                    <form:hidden path="poloSearchResultList[${status.index}].postalCode" />
                  </c:forEach>
                </tbody>
              </table>
            </div>
							<%-- 	<!-- Pagination Starts -->
    								<ul class="grdPagination">
			                  			<%
			                  				int noOfPages = (Integer) request.getAttribute("noOfPages");
			                  				int startPage = (Integer) request.getAttribute("startPage");
			                  				int lastPage = (Integer) request.getAttribute("lastPage");
			                  		  
											if (currentPage != 1) {
			   							%>
			   									<li><a href="testdaUser?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li><a href="testdaUser?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
			   							<%
			   								} else {
			   								 	if(noOfPages > 1) {
			   							%>
			   								 	<li class="disable"><a href="testdaUser?page=<%= 1 %>">&lt;&lt;</a><div>&lt;&lt;</div></li>
			   									<li class="disable"><a href="testdaUser?page=<%= currentPage-1 %>">&lt;</a><div>&lt;</div>
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
			    										<li><a href="testdaUser?page=<%= i %>" id="employeeLink"><%= i %></a><div><%= i %></div></li>
			    						<%
			    									}
			    								}
			    							}
											if(currentPage < noOfPages) {
										%>
			    		     					<li><a href="testdaUser?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li><a href="testdaUser?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
			    		   				<%
											} else {
											    if(noOfPages > 1) {
										%>
			    		     					<li class="disable"><a href="testdaUser?page=<%= currentPage+1 %>">&gt;</a><div>&gt;</div></li>
			    		     					<li class="disable"><a href="testdaUser?page=<%= noOfPages %>">&gt;&gt;</a><div>&gt;&gt;</div></li>
										<%
											    }
											}
										%>
									</ul>
						  --%>
							<!-- Pagination Ends -->
            <br>
            <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col">
                      <input type="submit" name="reserve" class="btn-primary btn-cell" id="reserve" value="Reserve">
                      <input type="submit" name="export" id="export" class="btn-primary btn-cell" value="ExportAll to Excel">
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
  menu_highlight('Provider_Search');
  
  var checkboxes = $('.cb_class');
   
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
	    $( ".datepicker" ).datepicker({
	      defaultDate: "+1w",
	      changeMonth: true,
	      numberOfMonths: 1,
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

$('#creditCardNo').change(function() {
    $('#crditcard').hide();
});

$('#creditCardYes').change(function() {
    $('#crditcard').show();
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
 