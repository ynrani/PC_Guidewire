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
        <form:form id="testDataForm" name="testDataForm" action="${pageContext.request.contextPath}/testdaAccount" modelAttribute="tdmAccountDTO">
          <div class="">
            <input type="hidden" name="userId" value="${sessionScope.userId}" />
            <table style="width:100%; border:0; font-size: 13px; cellpadding:4;">
              <tbody>
               <tr style="border-bottom: 1px solid black;">
               <td style="font-size: 15px"> <b> Account : </b></td>
               </tr>   
                	<tr>
		                <td class="lable-title" width="35%" align="left" valign="middle">
		                    <spring:message code="label.ns.ac.actype" />
		                  </td>
		                  <td  width="20%" class="flied-title" align="left" valign="middle">
		                    <form:select path="accoutnType" id="accoutnType" class="down-control">
		                     <form:option value="Classic">Classic</form:option>
		                        <form:option value="Current">Current</form:option>
		                      <form:option value="Platinum Saver">Platinum Saver</form:option>
		                       <form:option value="Regular Saver">Regular Saver</form:option> 
		                      <form:option value="Savings">Savings</form:option>
		                    </form:select>
		                  </td>
		                
		                
		                 <td  width="20%" class="lable-title" align="left" valign="middle" scope="col" >
                          <spring:message code="label.ns.ac.bal" />
                        </td>
		                 <td class="flied-title" align="left" valign="middle" scope="col">
                         From:<form:input path="balFrom" id="balFrom"  class="form-control-half" />
                        </td>
                        
                         <td class="flied-title" align="left" valign="middle" scope="col">
                          To: <form:input path="balTo" id="balTo" class="form-control-half" />
                        </td>
                	</tr>
              
                <tr>               
                  <td scope="col" class="lable-title" align="left" valign="middle">
                    <spring:message code="label.ns.ac.acStat" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="accountStatus" id="accountStatus" class="down-control">
                     <form:option value="Active">Active</form:option>
                        <form:option value="Closed">Closed</form:option>
                      <form:option value="Dormant">Dormant</form:option>
                        <form:option value="Inactive">Inactive</form:option>
                    </form:select>
                  </td>
                
                  <td class="lable-title"  align="left" valign="middle" scope="col" ><spring:message code="label.ns.ac.overDraft" /></td>
                  <td class="flied-title" scope="col" ><label class="radio-inline" >
								<form:radiobutton path="overDraftEnabled" value="1" checked="true" />Enable
						</label> </td><td class="flied-title" scope="col" ><label class="radio-inline"> <form:radiobutton
									path="overDraftEnabled" value="0" />Disable
						</label>   </td>             
                  
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle" scope="col" >
                    <spring:message code="label.ns.ac.brnchcode" />
                  </td>
                   <td class="flied-title" align="left" valign="middle" scope="col" >
                   <form:input path="branchCode" id="branchCode" class="form-control" />
                   </td>                                                      
                </tr>
                
                <tr></tr>  
                <tr></tr>              
               <tr style="border-bottom: 1px solid #000;">
               <td style="font-size: 15px"> <b> Customer : </b></td>
               </tr>               
                
                <tr></tr> 
                <tr>
                  <td class="lable-title"  width="35%" align="left" valign="middle" scope="col" >
                    <spring:message code="label.ns.ac.custtype" />
                  </td>
                  <td class="flied-title" align="left" valign="middle" scope="col" >
                    <form:select path="custmerType" id="custmerType" class="down-control">
                     <form:option value="">--Select--</form:option>
                        <form:option value="Sole">Sole</form:option>
                      <form:option value="Joint">Joint</form:option>
                    </form:select>
                  </td>
                    <td class="lable-title"  align="left" valign="middle" scope="col" ><spring:message code="label.ns.ac.gender" /></td>
                  <td class="flied-title" scope="col" ><label class="radio-inline" >
								<form:radiobutton path="gender" value="1" checked="true" />Male
						</label></td><td class="flied-title" scope="col" > <label class="radio-inline"> <form:radiobutton
									path="gender" value="0" />Female
						</label></td>                  
                </tr> 
                
                <tr>
                <td class="lable-title" align="left" valign="middle" scope="col">
                          <spring:message code="label.ns.ac.dob" />
                        </td>
		                 <td class="flied-title" align="left" valign="middle" scope="col" >
                         <form:input path="dobFrom" id="dobFrom" class="datepicker date-control" />
                        </td>
                 <td class="lable-title"align="left" valign="middle" scope="col" ><spring:message code="label.ns.ac.ccCard" /></td>
                  <td class="flied-title" scope="col" ><label class="radio-inline">
								<form:radiobutton path="creditCard" id="creditCardYes" value="1" />Yes
						</label></td> <td class="flied-title"scope="col" ><label class="radio-inline"> <form:radiobutton
									path="creditCard" id="creditCardNo"  value="0"  checked="true" />No
						</label></td>    
                </tr>     
                     
              </tbody> 
            </table>
                <table id= "crditcard" style="width:100%; border:0; font-size: 13px; cellpadding:4; display:none">
                <tbody>
                <tr>
                
                <td class="lable-title" width="30%" align="left" valign="middle">
                    <spring:message code="label.ns.ac.ccType" />
                  </td>
                  <td class="flied-title" width="30%"  align="left" valign="middle">
                    <form:select path="crditCardType" id="crditCardType" class="down-control">
                     <form:option value="">--Select--</form:option>
                        <form:option value="Gold">Gold</form:option>
                      <form:option value="Platinum">Platinum</form:option>
                      <form:option value="Silver">Silver</form:option>
                    </form:select>
                  </td>
                  
                    <td width="20%"  class="lable-title" align="left" valign="middle">
                          <spring:message code="label.ns.ac.ccExpdate" />
                        </td>
		                 <td width="20%"  class="flied-title" align="left" valign="middle" title="Enter date format MM-YY like DEC-16" scope="col">
                         <form:input path="ccExpdateFrom" id="ccExpdateFrom" class="form-control-medium" />
                        </td>
                   </tr>
                   <tr>
                   <td class="lable-title" align="left" valign="middle" scope="col">
                          <spring:message code="label.ns.ac.cclimit" />
                        </td>
		                 <td class="flied-title" align="left" valign="middle" scope="col">
                         <form:input path="ccAvailablelimit" id="ccAvailablelimit" class="form-control" />
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
					test="${tdmAccountDTO.accountDTosList eq null}">

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
	        
	         <c:if test="${tdmAccountDTO.accountDTosList eq null}">
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

          <c:if test="${tdmAccountDTO.accountDTosList ne null &&  not empty tdmAccountDTO.accountDTosList}">
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
                    
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.ac.num" /></th>
                     <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.ac.title" /></th>
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.ac.custname" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.custSurName" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.email" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.custNum" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.bal" /></th>                    
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.brnchCode" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.acStat" /></th>                   
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.ac.addrLn1" /></th>
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.ac.addrLn2" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.city" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.contry" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.zip" /></th>                    
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.custtype" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.ccNum" /></th>                  
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${tdmAccountDTO.accountDTosList}" var="accountDTosList" varStatus="status">
                    <tr>
                      <c:if test="${tdmAccountDTO.reservedYN eq null }">
                        <td>
                          <label class="checkbox-inline">
                            <form:checkbox path="accountDTosList[${status.index}].reservedYN" id="accountDTosList[${status.index}].reservedYN" class="cb_class checkBoxCls" value="Yes" />
                          </label>
                        </td>
                      </c:if>

                      <td>${accountDTosList.accountNum}</td>
                      <td>${accountDTosList.title}</td>
                      <td>${accountDTosList.customerName}</td>
                      <td>${accountDTosList.custSurName}</td>
                      <td>${accountDTosList.customerEmail}</td>
                      <td>${accountDTosList.custmerId}</td>
                      <td>${accountDTosList.balance}</td>
                      <td>${accountDTosList.branchCode}</td>
                      <td>${accountDTosList.accountStatus}</td>
                      <td>${accountDTosList.addrLane1}</td>
                      <td>${accountDTosList.addrLane2}</td>
                      <td>${accountDTosList.city}</td>
                      <td>${accountDTosList.country}</td>
                       <td>${accountDTosList.zipCode}</td>
                      <td>${accountDTosList.custmerType}</td>
                      <td>${accountDTosList.creditCardNum}</td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tdmAccountDTO.accountDTosList}" var="accountDTosList" varStatus="status">

                    <form:hidden path="accountDTosList[${status.index}].accountNum" />
                     <form:hidden path="accountDTosList[${status.index}].title" />
                    <form:hidden path="accountDTosList[${status.index}].customerName" />
                    <form:hidden path="accountDTosList[${status.index}].custSurName" />
                     <form:hidden path="accountDTosList[${status.index}].customerEmail" />
                    <form:hidden path="accountDTosList[${status.index}].custmerId" />
                    <form:hidden path="accountDTosList[${status.index}].balance" />
                    <form:hidden path="accountDTosList[${status.index}].branchCode" />
                    <form:hidden path="accountDTosList[${status.index}].accountStatus" />
                    <form:hidden path="accountDTosList[${status.index}].addrLane1" />
                    <form:hidden path="accountDTosList[${status.index}].addrLane2" />
                    <form:hidden path="accountDTosList[${status.index}].city" />
                    <form:hidden path="accountDTosList[${status.index}].country" />
                    <form:hidden path="accountDTosList[${status.index}].zipCode" />
                    <form:hidden path="accountDTosList[${status.index}].custmerType" />
                    <form:hidden path="accountDTosList[${status.index}].creditCardNum" />
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
 