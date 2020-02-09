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
<title>Data Conditioner | Upload</title>
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
	      		<div class="step1-active"><span class="step-number1">1</span><span class="step-heading">Upload <small>File</small></span></div>
	      		<div class="step2"><span class="step-number2">2</span><span class="step-heading">Preview <small>and Select data</small></span></div>
	      		<div class="step3"><span class="step-number3">3</span><span class="step-heading">Select <small>Data Base</small></span></div>
	      		<div class="step4"><span class="step-number4">4</span><span class="step-heading">Select <small>Tables and Dump</small></span></div>
	   		</div>			
			<form:form id="uploadForm" name="uploadForm" action="${pageContext.request.servletContext.contextPath}/dataConPage1" modelAttribute="uploadDTO" enctype="multipart/form-data">
			  	<div class="two-col">
          	 	<h2 style="color: #0098cc ;   padding-top: 2%;">File Upload</h2>
          	 	  <c:set var="disbleTrue" value="false"/>
				  <c:if test="${stopUpload ne null}">
          	 		<c:set var="disbleTrue" value="true"/>
         	    	<table style="width:70%; border:0; font-size: 13px; color: #ED114B; padding: 1% 0% 0% 0%; ">
						<tbody>
						 <tr>
						   <td class="lable-title" align="left" valign="middle">
            	     	 	  No Connection were found. Atleast one connection is required to upload.
                	 	   </td>
	                  	 </tr>
						</tbody>
					  </table>
         		  </c:if>
          	 	  <table style="width:100%; border:0; font-size: 13px; cellpadding:2;   padding: 2% 0% 0% 0%; ">
          	 	   <tbody>
                	 <tr>
                		<td class="lable-title" width="20%" align="left" valign="middle">Upload Dump File<span>*</span></td>
                  		<td class="flied-title" width="30%" align="left" valign="middle">
                    	   <form:input type="file" path="file" id="file" readonly="${disbleTrue}" required="required" accept=".csv,text/plain,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" class="file-control" onchange="checkfile(this);"/>
                    	   <span style="color: #E0434C;"> Only .csv, .txt, .xls(x) are allowed.</span>
                  		</td>
                 	  </tr>
					</tbody>          	 	
          	 	  </table>
          		<div id="status"></div> 
				  <table style="width:50%; border:0; font-size: 13px; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td colspan="2" align="center" valign="middle" class="buttonsAll15">
					  	 <input type="submit" name="upload" id="upload" value="Upload" readonly="${disbleTrue}">
					   </td>
					 </tr>
					</tbody>
				  </table>
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
