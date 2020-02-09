<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title> TDM Central | Provider Search</title>
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
        <form:form id="customerDataForm" name="customerDataForm" action="${pageContext.request.contextPath}/testdaAccount" modelAttribute="tdmCustomerDTO">
          <div class="">
            <input type="hidden" name="userId" value="${sessionScope.userId}" />
            <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td class="lable-title" width="35%" align="left" valign="middle"><spring:message code="label.ns.ac.num" /><span>*</span></td>
                  <td class="flied-title" width="20%" align="left" valign="middle">
                   <form:input path="accountNum" id="accountNum" class="form-control" />
                  </td>
                  <td class="lable-title" width="25%" align="left" valign="middle"></td>
                  <td class="lable-title" width="20%" align="left" valign="middle" scope="col"></td>
                  
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.ns.ac.name" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                   <form:input path="customerName" id="customerName" class="form-control" />
                    <td class="lable-title" align="left" valign="middle" scope="col">
                      <spring:message code="label.ns.ac.bal" />
                    </td>
                    <td class="flied-title" align="left" valign="middle" scope="col">
                      <form:select path="balance" id="balance" class="down-control" >
                      <form:option value="">--Select--</form:option>
                        <form:option value="Dev Region 1"> >=</form:option>
                      <form:option value="Dev Region 2"> = </form:option>
                      </form:select>
                    </td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.ns.ac.type" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="accoutnType" id="accoutnType" class="down-control">
                     <form:option value="">--Select--</form:option>
                        <form:option value="Current"> Current</form:option>
                      <form:option value="Savings">Savings</form:option>
                    </form:select>
                  </td>
                  <td class="lable-title" align="left" valign="middle">
                    <spring:message code="label.ns.ac.numApp" />
                  </td>
                  <td class="flied-title" align="left" valign="middle">
                   <form:input path="numOfApp" id="numOfApp" class="form-control" />
                  </td>                  
                </tr>              
                           
              </tbody> 
            </table>

            <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td colspan="4" align="center" valign="middle">
                   <input type="submit" name="search" id="Search" class="btn-primary btn-cell" value="<spring:message code="button.serch"/>">
                    <input type="reset" value="Reset" class="btn-primary btn-cell" onClick="clearFields('./testdaUser');">
                  </td>
                </tr>
              </tbody>
            </table>

          </div>
          <br/>
          <br/>
          
          
          
            
            <c:if test="${tdmAccountDTO.accountDTosList eq null}">
            
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
	         
	          
	          <c:if test="${tDMProvSearchDTO.autoEmailDTOs ne null &&  not empty tDMProvSearchDTO.autoEmailDTOs && reserveFlag eq null}">	          
	          
	          <table style="width:100%; border:0; font-size: 12px; color:#EC0B2D; cellpadding:4;">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"><spring:message code="label.msg.recFndByOth"/></td>
	                 
	                </tr>
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
						 
							<!-- Pagination Ends -->
							
	       
	          </c:if>
	          
	          <c:if test="${tdmAccountDTO.accountDTosList eq null && empty tdmAccountDTO.accountDTosList}">
	          
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
	        
	        
	         <c:if test="$tdmAccountDTO.accountDTosList eq null}">
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
                    <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.ns.ac.num" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.name" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.bal" /></th>
                    <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.ns.ac.type" /></th>                  
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

                      <td>${accountDTosList.firstName}</td>
                      <td>${accountDTosList.lastName}</td>
                      <td>${accountDTosList.atypical}</td>
                      <td>${accountDTosList.provType}</td>
                      <td>${accountDTosList.provCatgType}</td>
                      <td>${accountDTosList.specialityDescription}</td>
                      <td>${accountDTosList.licenseNo}</td>
                      <td>${accountDTosList.tin}</td>
                      <td>${accountDTosList.npi}</td>
                      <td>${accountDTosList.medicareId}</td>
                      <td>${accountDTosList.provContactType}</td>
                    </tr>
                  </c:forEach>

                  <c:forEach items="${tdmAccountDTO.accountDTosList}" var="accountDTosList" varStatus="status">

                    <form:hidden path="accountDTosList[${status.index}].providerId" />
                    <form:hidden path="accountDTosList[${status.index}].firstName" />
                    <form:hidden path="accountDTosList[${status.index}].lastName" />
                    <form:hidden path="accountDTosList[${status.index}].atypical" />
                    <form:hidden path="accountDTosList[${status.index}].provType" />
                    <form:hidden path="accountDTosList[${status.index}].provCatgType" />
                    <form:hidden path="accountDTosList[${status.index}].specialityDescription" />
                    <form:hidden path="accountDTosList[${status.index}].licenseNo" />
                    <form:hidden path="accountDTosList[${status.index}].tin" />
                    <form:hidden path="accountDTosList[${status.index}].npi" />
                    <form:hidden path="accountDTosList[${status.index}].medicareId" />
                    <form:hidden path="accountDTosList[${status.index}].provContactType" />
                    <form:hidden path="accountDTosList[${status.index}].provFET" />
                    <form:hidden path="accountDTosList[${status.index}].provGender" />
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
 