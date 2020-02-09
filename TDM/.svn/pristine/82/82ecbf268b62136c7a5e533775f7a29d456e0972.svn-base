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
<title>Data Conditioner | Result</title>
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
 
</head>
<body>

	<div class="mainAll">

		<jsp:include page="indexHeader.jsp"></jsp:include>
		<section class="bodySec">
			<div class="container">
			  <form:form id="tdmUploadForm" name="tdmUploadForm" action="${pageContext.request.servletContext.contextPath}/index" modelAttribute="tdmUploadDTO" enctype="multipart/form-data">
          	 	<div class="two-col">
          	 	<h2 style="color: #0098cc ;   padding-top: 5%;">Result Data Preview</h2>
          	 	  <table style="width:100%; border:0; font-size: 13px; cellpadding:2;   padding: 2% 0% 0% 0%; ">
          	 	   <c:forEach items="${listToUi}" var="listToUiFirst"> 
				     <c:forEach items="${listToUiFirst}" var="listToUiSecond">
          	 	 	   <tbody>
                		 <tr>
               		        <td> <c:out value="${listToUiSecond.field1}" /></td>
				          </tr>
	  				   </tbody>      
					 </c:forEach>
				    </c:forEach>    	 	
          	 	  </table>
          	 	  
				  <table style="width:50%; border:0; font-size: 13px; cellpadding:4; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td colspan="2" align="center" valign="middle" class="buttonsAll15">
					  	 <input type="submit" name="upload" id="upload" value="Upload">
					  	 <input type="submit" name="cancel" id="cancel" value="Cancel">
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
		menu_highlight('uploads_single');
	 
		
		 
	</script>
</body>
</html>
