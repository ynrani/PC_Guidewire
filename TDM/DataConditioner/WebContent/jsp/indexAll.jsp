<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!doctype html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Data Conditioner | Index</title>
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
<script type="text/javascript" src="js/jquery.form.js"></script>
  
</head>
<body>

	<div class="mainAll">

		<jsp:include page="indexHeader.jsp"></jsp:include>
		<section class="bodySec" >
			<div class="container">
				<c:set var="threeStepsClass1" value="step1"/>
				<c:set var="threeStepsClass2" value="step2"/>
				<c:set var="threeStepsClass3" value="step3"/>
				<c:set var="threeStepsClass4" value="step4"/>
				<c:if test="${empty dbList and null eq dumpMsg and empty listTabs}">
					<c:set var="threeStepsClass1" value="step1-active"/>
				</c:if>
				<c:if test="${not empty dbList}">
					<c:set var="threeStepsClass2" value="step2-active"/>
				</c:if>
				<c:if test="${not empty listTabs}">
					<c:set var="threeStepsClass3" value="step3-active"/>
				</c:if>
				<c:if test="${null ne dumpMsg}">
					<c:set var="threeStepsClass4" value="step4-active"/>
				</c:if>
			<div class="three-step-container">
	      		<div class="${threeStepsClass1}"><span class="step-number1">1</span><span class="step-heading">Upload <small>and Preview</small></span></div>
	      		<div class="${threeStepsClass2}"><span class="step-number2">2</span><span class="step-heading">Select <small>DB </small></span></div>
	      		<div class="${threeStepsClass3}"><span class="step-number3">3</span><span class="step-heading">Select <small>Tables</small></span></div>
	      		<div class="${threeStepsClass4}"><span class="step-number4">4</span><span class="step-heading">Dump <small>into DB</small></span></div>
	   		</div>			
			<form:form id="uploadForm" name="uploadForm" action="${pageContext.request.servletContext.contextPath}/index" modelAttribute="uploadDTO" enctype="multipart/form-data">
			   <c:if test="${empty dbList and null eq dumpMsg and empty listTabs}">
          	 	<div class="two-col">
          	 	<h2 style="color: #0098cc ;   padding-top: 2%;">File Upload</h2>
          	 	  <table style="width:100%; border:0; font-size: 13px; cellpadding:2;   padding: 2% 0% 0% 0%; ">
          	 	   <tbody>
                	 <tr>
                		<td class="lable-title" width="20%" align="left" valign="middle">Upload Dump File<span>*</span></td>
                  		<td class="flied-title" width="30%" align="left" valign="middle">
                    	   <form:input type="file" path="file" id="file" required="required" accept=".csv,text/plain,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" class="file-control" onchange="checkfile(this);"/>
                  		</td>
                 	  </tr>
					</tbody>          	 	
          	 	  </table>
          	 	   
				<div id="status"></div>
				
          	 	  
				  <table style="width:50%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td colspan="2" align="center" valign="middle" class="buttonsAll15">
					  	 <input type="submit" name="upload" id="upload" value="Upload">
					   </td>
					 </tr>
					</tbody>
				  </table>
				  
         	    </div>
         	    
         	   <c:if test="${not empty listToUi}">
         	    <h2 style="color: #0098cc ;   padding-top: 2%;">Result Data Preview</h2>
         	     <div class="scrollingX"  id="myid" >
         	      <table id="search_output_table" class="table tablesorter" style="width:100%;font-size: 13px;border:0; cellpadding:0; cellspacing:1">
                   <thead>
                     <c:forEach items="${listToUi}" var="listToUiFirst">
                      <tr> 
				       <c:forEach items="${listToUiFirst}" var="listToUiSecond">
          	 	 		    <td> <c:out value="${listToUiSecond}" /></td>
				       </c:forEach>
	  				  	</tr>
				      </c:forEach> 
				    </thead>   	 	
          	 	  </table>
          	    </div> 
          	    
         	     <table style="width:100%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td align="center" valign="middle" class="buttonsAll8">
					  	 <input type="submit" name="next1" id="next1" value="Next">
					  	 <input type="submit" name="cancel" id="cancel" value="Cancel">
					   </td>
					 </tr>
					</tbody>
				  </table>
				  
         	     </c:if>
         	    </c:if> 
         	   
         	     
         	   <c:if test="${not empty dbList}">
         	    <h2 style="color: #0098cc ;   padding-top: 5%;">Select Target Data Base</h2>
         	     <table style="width:70%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td class="lable-title" align="left" valign="middle">
                 	    Available target DB's are : <span> *</span> 
                 	   </td>
                  	   <td class="flied-title" align="left" valign="middle">
                    	<form:select path="dbValues" id="dbValues" items="${dbList}" multiple="true" class="down-control-min" required="required" />
                  	   </td>
                  	 </tr>
					 <tr>
					   <td class="lable-title" align="left" valign="middle"/>
                  	   <td class="flied-title" align="left" valign="middle" style="color: #EC974C;">
                    	Above values displaying in following order : DB Type >> Host Name >> Port No >> SID/Service/DB Name >> User Name
                  	   </td>
					 </tr>
					</tbody>
				  </table> 
         	     <table style="width:100%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td align="center" valign="middle" class="buttonsAll8">
					  	 <input type="submit" name="next2" id="next2" value="Next">
					  	 <input type="submit" name="cancel" id="cancel" value="Cancel">
					   </td>
					 </tr>
					</tbody>
				  </table>
			    </c:if>  
			    
			    <c:if test="${not empty listTabs}">
         	    <h2 style="color: #0098cc ;   padding-top: 5%;">Select Target Table(s)</h2>
         	     <table style="width:70%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					 <c:forEach items="${listTabs}" var="tableMap" varStatus="tableMapStatus">
					    <td class="lable-title" align="left" valign="middle">
                 	     Select the target table(s) in ${tableMap.key}: <span> *</span> 
                 	    </td>
                  	    <td class="flied-title" align="left" valign="middle">
                    	  <form:select path="${tableNames[valueStatus]}" id="tableNames" class="down-control" required="required" >
      						  <c:forEach items="${tableMap.value}" var="currentTableMap" varStatus="valueStatus">
      						     <form:option value="${currentTableMap}">${currentTableMap}</form:option>
      						  </c:forEach>
      						</form:select>
      					  </td>
                  	   </c:forEach>
                  	 </tr>
					</tbody>
				  </table>
				  
				   <table style="width:100%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td align="center" valign="middle" class="buttonsAll8">
					  	 <input type="submit" name="next3" id="next3" value="Next">
					  	 <input type="submit" name="cancel" id="cancel" value="Cancel">
					   </td>
					 </tr>
					</tbody>
				  </table>
         	    </c:if>
         	     
         	   <c:if test="${dumpMsg ne null}">
         	    <h2 style="color: #0098cc ;   padding-top: 5%;">Dump Message</h2>
         	    <table style="width:70%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td class="lable-title" align="left" valign="middle">
                 	   Dumped successfully
                 	   </td>
                  	 </tr>
					</tbody>
				  </table>
         	    </c:if>
         	    
         	  </form:form>
			</div>
		</section>
		<script src="include/footer.js"></script>
	</div>
	<script>
		menu_highlight('uploads');
		menu_highlight('uploads_single');
	 
		 $("#search_output_table").tablesorter({
			    widgets: ['zebra']
		});
		
		 $(".table tr:odd").css('background-color','#EFF4FA');
		 $(".table tr:even").addClass('even');
			  
		
		 
	/* 	$(function() {

		    var bar = $('.bar');
		    var percent = $('.percent');
		    var status = $('#status');

		    $('#uploadForm').ajaxForm({
		        beforeSend: function() {
		            status.empty();
		            var percentVal = '0%';
		            bar.width(percentVal);
		            percent.html(percentVal);
		        },
		        uploadProgress: function(event, position, total, percentComplete) {
		            var percentVal = percentComplete + '%';
		            bar.width(percentVal);
		            percent.html(percentVal);
		        },
		        complete: function(xhr) {
		            status.html(xhr.responseText);
		        }
		    });
		}); 
		 */
		 
	</script>
</body>
</html>
