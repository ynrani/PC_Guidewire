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
<title>Data Conditioner | Select Table(s)</title>
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
			<div class="three-step-container">
	      		<div class="step1"><span class="step-number1">1</span><span class="step-heading">Upload <small>File</small></span></div>
	      		<div class="step2"><span class="step-number2">2</span><span class="step-heading">Preview <small>and Select data</small></span></div>
	      		<div class="step3"><span class="step-number3">3</span><span class="step-heading">Select <small>Data Base</small></span></div>
	      		<div class="step4-active"><span class="step-number4">4</span><span class="step-heading">Select <small>Tables and Dump</small></span></div>
	   		</div>			
			<form:form id="uploadForm" name="uploadForm" action="${pageContext.request.servletContext.contextPath}/dataConPage4" modelAttribute="uploadDTO" enctype="multipart/form-data">
			 <div class="two-col"> 
			   <c:if test="${not empty listTabs}">
			   <form:hidden path="selDbValues"/>
         	    <h2 style="color: #0098cc ;   padding-top: 5%;">Select Target Table(s)</h2>
         	     <table style="width:100%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <c:forEach items="${listTabs}" var="tableMap" varStatus="tableMapStatus">
					  <tr>
					    <td width="40%" class="lable-title" align="left" valign="middle">
                 	     Select the target table in ${tableMap.key}: <span> * </span> <span><small>( &lt;ConnectionType&gt;_&lt;Id&gt; )</small></span> 
                 	    </td>
                  	    <td  width="40%" class="flied-title" align="left" valign="middle">
                    	  <form:select path="uploadTableNameDTOs[${tableMapStatus.index}].selDbtab" id="tableNames" class="down-control" required="required" >
      						  <c:forEach items="${tableMap.value}" var="currentTableMap" varStatus="valueStatus">
      						     <form:option value="${currentTableMap}">${currentTableMap}</form:option>
      						  </c:forEach>
      						</form:select>
      						<form:hidden path="uploadTableNameDTOs[${tableMapStatus.index}].type" value="${tableMap.key}"/>
      					  </td>
      						 
      					 <td width="20%" class="lable-title" align="left" valign="middle" >
	               			<input type="button" value="Create Table ?"  class="btnRunStmt" onclick="popup('./createTable?create=${createStmt}&type=${tableMap.key}','Create Statemt','popup','popupOverlay','550');" />
                     	 </td>
                    
                        </tr>
                  	   </c:forEach>
                  	</tbody> 
                   
              
				  </table>
				   <table style="width:100%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td align="center" valign="middle" class="buttonsAll8">
					   	 <c:if test="${null eq dumpMsg }">
					  	  <input type="submit" name="next3" id="next3" value="Dump">
					  	 </c:if>
					  	 <c:if test="${null eq cancelBtn}">
					  	 	<input type="submit" name="cancel" id="cancel" value="Cancel">
					  	 </c:if>
					   </td>
					 </tr>
					</tbody>
				  </table>
         	    </c:if>
         	    
         	    <c:if test="${dumpMsg ne null}">
         	    <h2 style="color: #0098cc ;   padding-top: 5%;">Dump Message</h2>
         	    <table style="width:70%; border:0; font-size: 13px; color: #4AC010; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td class="lable-title" align="left" valign="middle">
                 	   Dumped successfully. Click <a href="./dataConPage1">here</a> to upload more.
                 	   </td>
                  	 </tr>
					</tbody>
				  </table>
         	    </c:if>
         	    
         	    <c:if test="${errMsg ne null}">
         	    <h2 style="color: #0098cc ;   padding-top: 5%;">Dump Message</h2>
         	    <table style="width:70%; border:0; font-size: 13px; color: #ED114B; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td class="lable-title" align="left" valign="middle">
                 	   Dumping Failed : Root Cause is : ${errMsg}
                 	   </td>
                  	 </tr>
					</tbody>
				  </table>
         	    </c:if>
         	    
         	    </div>
         	  </form:form>
			</div>
		</section>
		<script src="include/footer.js"></script>
	</div>
	<script>
	menu_highlight('uploads');
	menu_highlight('uploads_file_tab');
	menu_highlight('uploads_file_tab_single');
	 
		 $("#search_output_table").tablesorter({
			    widgets: ['zebra']
		});
		
		 $(".table tr:odd").css('background-color','#EFF4FA');
		 $(".table tr:even").addClass('even');
		 $("#myContent").css("display", "none");
		
		 
	</script>
</body>
</html>
