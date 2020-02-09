<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Central | Request Test Data</title>
  <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" >
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/custom.css">
  <link href="css/theme.default.css" rel="stylesheet">
  <script src="js/html5Shiv.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/main.js"></script>
  <script src="js/jquery.validate.min.js" type="text/javascript" ></script>  
  <script src="js/messages.js"></script>
  <script src="js/common.js"></script>
  <script src="js/jquery-migrate-1.2.1.min.js"></script>
   
</head>

<body>
  <div class="mainAll">
   <!--  <script src="include/header.js"></script> -->
   <jsp:include page="header.jsp"></jsp:include>
    
      <div class="container">
      
      <br/>
      <br/>
      
     <h2 style="color: #0098cc;font-size: 14px;">Create Test Data Request</h2>
      <hr>
      <br/>
                  
        <form:form id="tdmReqTestDataForm" name="tdmReqTestDataForm" action="${pageContext.request.contextPath}/tdmReqTestData" modelAttribute="tdmReqTestDataDTO">
          <div class="">
            <input type="hidden" name="userId" value="${sessionScope.userId}" />
            <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                
                <tr>
                  <td class="lable-title" width="35%" align="left" valign="middle">Policy Type<span>*</span></td>
                  <td class="flied-title" width="20%" align="left" valign="middle">
                    <form:select path="policyType" id="policyType" class="down-control" required="true">
                      <form:option value="">--Select--</form:option>
                      <form:option value="AUTO">AUTO</form:option>
                      <form:option value="COMMERCIAL AUTO">COMMERCIAL AUTO</form:option>
                      <form:option value="COMMERCIAL NON AUTO">COMMERCIAL NON AUTO</form:option>
                      <form:option value="Commercial Property">Commercial Property</form:option>
                      <form:option value="HOMEOWNERS">HOMEOWNERS</form:option>
                      <form:option value="Marine">Marine</form:option>
                      <form:option value="Motorhome">Motorhome</form:option>
                      <form:option value="PROPERTY">PROPERTY</form:option>
                      <form:option value="Workers Comp">Workers Comp</form:option>
                    </form:select>
                  </td>
                  <td class="lable-title"  width="35%"  align="left" valign="middle">Policy State Code</td>
					<td class="flied-title" width="20%"  align="left" valign="middle"><form:select
							path="policyStateCode" id="policyStateCode" class="down-control">
							<form:option value="">Any</form:option>
							<form:option value="UT">UT</form:option>
							<form:option value="AZ">AZ</form:option>
							<form:option value="IN">IN</form:option>
							<form:option value="OK">OK</form:option>
							<form:option value="CO">CO</form:option>
							<form:option value="IN">IN</form:option>
							<form:option value="CA">CA</form:option>
							<form:option value="Other">Other</form:option>
						</form:select></td>
                </tr>
                
                
                <tr>
                  <td class="lable-title" align="left" valign="middle">Source System</td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:select path="srcSys" id="srcSys" class="down-control">
                      <form:option value="">--Select--</form:option>
                      <form:option value="BW">BW</form:option>
                      <form:option value="Commercial Property">Commercial Property</form:option>
                      <form:option value="COS">COS</form:option>
                      <form:option value="CLS">CLS</form:option>
                      <form:option value="FARMERS">FARMERS</form:option>
                      <form:option value="21ST DRC">21ST DRC</form:option>
                      <form:option value="FOREMOST">FOREMOST</form:option>
                    </form:select>
                  </td>
                  <td class="lable-title"   align="left" valign="middle">Test Environment</td>
					<td class="flied-title"  align="left" valign="middle">
						<form:select path="envType" id="envType" class="down-control">
				 			<form:option value="QA">QA</form:option>
           					<form:option value="MaintDM">MaintDM</form:option>
           					<form:option value="MaintReg">MaintReg</form:option>
           					<form:option value="Other">Other</form:option>
						</form:select>
					</td>
                </tr>
                
                
                 <tr>
                  <td class="lable-title" align="left" valign="middle">Policy Request Details</td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:textarea path="policyReqDtl" id="policyReqDtl" class="form-control" />
                     
                  </td>
                  <td class="lable-title"   align="left" valign="middle">Policy Status</td>
					<td class="flied-title"  align="left" valign="middle">
						<form:select path="policySts" id="policySts" class="down-control">
				 			<form:option value="ACTIVE">ACTIVE</form:option>
           					<form:option value="AUTO">AUTO</form:option>
           					<form:option value="INACTIVE">INACTIVE</form:option>
           				</form:select>
						 
					</td>
                </tr>
                
                
                <tr>
                  
                  <td class="lable-title"   align="left" valign="middle">Requesting Team</td>
					<td class="flied-title"  align="left" valign="middle">
						<form:select path="reqTeam" id="reqTeam" class="down-control">
				 			<form:option value="Dev-Hero">Dev-Hero</form:option>
							<form:option value="Dev-CMA">Dev-CMA</form:option>
							<form:option value="Dev-OSB">Dev-OSB</form:option>
							<form:option value="Dev-Siebel">Dev-Siebel</form:option>
							<form:option value="QA">QA</form:option>
							<form:option value="QA-Hero">QA-Hero</form:option>
							<form:option value="QA-CMA">QA-CMA</form:option>
							<form:option value="QA-Siebel">QA-Siebel</form:option>
							<form:option value="QA-NWCS">QA-NWCS</form:option>
							<form:option value="QA-INET">QA-INET</form:option>
							<form:option value="UAT">UAT</form:option>
           					
           					
           				</form:select>
						 
					</td>
					
					<td class="lable-title" align="left" valign="middle">Requester Name</td>
                  	<td class="flied-title" align="left" valign="middle">
                  	  <form:input path="reqName" id="reqName" class="form-control" readonly="true"/>
                 	</td>
                </tr>
                              
              </tbody>         
    
              
            </table>

            <c:if test="${reqId eq null}">

            <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td colspan="4" align="center" valign="middle" >
                   <input type="submit" name="search" id="Search" class="btn-primary btn-cell" value="Submit">
                    <input type="reset" value="Reset" class="btn-primary btn-cell" onClick="clearFields('./tdmReqTestData');">
                  </td>
                </tr>
              </tbody>
               
            </table>
            </c:if>
            
            <c:if test="${reqId ne null}">
			 <table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td colspan="4" align="center" valign="middle" >
                   <input type="submit" name="search" id="Search" class="btn-primary btn-cell" value="Update">
                  </td>
                </tr>
              </tbody>
              </table>
			</c:if>

          </div>
          <br/>
          <br/>  
            
        </form:form>
        <div class="pageloading"></div>
      </div>
 	<script src="include/footer.js"></script>
	</div>

	<script>
		menu_highlight('Policy_Property_Search');

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

		tdmTestDataReq();

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
