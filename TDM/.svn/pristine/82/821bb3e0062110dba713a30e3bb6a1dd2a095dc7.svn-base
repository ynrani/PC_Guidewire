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
<title>Data Conditioner | Preview</title>
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
	      		<div class="step2-active"><span class="step-number2">2</span><span class="step-heading">Preview <small>and Select data</small></span></div>
	      		<div class="step3"><span class="step-number3">3</span><span class="step-heading">Select <small>Data Base</small></span></div>
	      		<div class="step4"><span class="step-number4">4</span><span class="step-heading">Select <small>Tables and Dump</small></span></div>
	   		</div>			
			<form:form id="uploadForm" name="uploadForm" action="${pageContext.request.servletContext.contextPath}/dataConPage2" modelAttribute="uploadDTO" enctype="multipart/form-data">
			  <div class="two-col">
          	   <c:if test="${not empty listToUi}">
         	    <h2 style="color: #0098cc ;   padding-top: 2%;">Result Data Preview</h2>
         	     <div class="scrollingX"  id="myid" >
         	      <table id="search_output_table" class="table tablesorter" style="width:100%;font-size: 13px;border:0; cellpadding:0; cellspacing:1">
                   <thead>
                    <c:forEach items="${uploadDTO.selectedColumns}" var="selectedColumnsFirst" >
                      <tr> 
                      <c:forEach items="${selectedColumnsFirst}" var="selectedColumnsSecond" varStatus="status">
				        <td>
				        	 <form:checkbox path="selectedColumns" value="selectedColumns${status.index}" checked="true"/>
				        	  
				        </td>
				        </c:forEach>
				      </tr>
				     </c:forEach> 
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
			   

	</script>
</body>
</html>
