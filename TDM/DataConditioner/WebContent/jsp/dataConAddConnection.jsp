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
 
</head>
<body>

	<div class="mainAll">

		<jsp:include page="indexHeader.jsp"></jsp:include>
		<section class="bodySec">
			<div class="container">
			  <form:form id="tdmUploadForm" name="tdmUploadForm" action="${pageContext.request.servletContext.contextPath}/dataConAddConnection" modelAttribute="dbConnectionsDTO">
          	 	<div class="two-col">
          	 	<h2 style="color: #0098cc ;   padding-top: 5%;">Add Connection</h2>
          	 	  <table style="width:100%; border:0; font-size: 13px; cellpadding:2;   border-spacing: 5px;  padding: 2% 0% 0% 0%; ">
          	 	  <form:hidden path="conId"/>
          	 	   <tbody>
          	 	  	  <tr>
                		<td class="lable-title" width="20%" align="left" valign="middle">Data Base Type<span>*</span></td>
                		<td class="flied-title" width="30%" align="left" valign="middle">
                  		<form:select path="dbType" id="dbType" class="down-control">
	                      <form:option value="">--Select--</form:option>
	                      <form:option value="Oracle">Oracle</form:option>
	                      <form:option value="MySql">MySql</form:option>
	                      <form:option value="SqlServer">Sql Sever</form:option>
	                      <form:option value="DB2">DB2</form:option>
	                    </form:select>
	                    </td>
                 	  </tr>
                	 <tr>
                		<td class="lable-title" align="left" valign="middle">Host Name<span>*</span></td>
                  		<td class="flied-title" align="left" valign="middle">
                    	   <form:input path="hostName" id="hostName" required="required"  class="form-control" autocomplete="off"/>
                  		</td>
                 	  </tr>
                 	  <tr>
                		<td class="lable-title" align="left" valign="middle">Port Number<span>*</span></td>
                  		<td class="flied-title" align="left" valign="middle">
                    	   <form:input path="port" id="port" required="required"  class="form-control" autocomplete="off"/>
                  		</td>
                 	  </tr>
                 	  <tr>
                		<td class="lable-title" align="left" valign="middle">SID/Service/DB Name<span>*</span></td>
                  		<td class="flied-title" align="left" valign="middle">
                    	   <form:input path="sid" id="sid" required="required"  class="form-control" autocomplete="off"/>
                  		</td>
                 	  </tr>
                 	 
                 	  <tr>
                		<td class="lable-title" align="left" valign="middle">User Name<span>*</span></td>
                  		<td class="flied-title" align="left" valign="middle">
                    	   <form:input path="user" id="user" required="required"  class="form-control" autocomplete="off"/>
                  		</td>
                 	  </tr>
                 	   <tr>
                		<td class="lable-title" align="left" valign="middle">Password<span>*</span></td>
                  		<td class="flied-title" align="left" valign="middle">
                    	   <form:input path="pass" id="pass" required="required"  class="form-control" autocomplete="off"/>
                  		</td>
                 	  </tr>
                 	  
                 	  
					</tbody>          	 	
          	 	  </table>
          	 	  
          	 	  <c:if test="${status ne null}">
          	 	  	<table style="width:50%; border:0; font-size: 13px; color: #0B1CC5; padding: 1% 0% 0% 0%; ">
						<tbody>
						 <tr>
						   <td  align="center" valign="middle">
						   	${status}
						   </td>
						 </tr>
						</tbody>
				  </table>
          	 	  </c:if>
          	 	  <c:if test="${saveStatus ne null}">
          	 	  	<table style="width:50%; border:0; font-size: 13px; color: #0B1CC5; padding: 1% 0% 0% 0%; ">
						<tbody>
						 <tr>
						   <td  align="center" valign="middle">
						   	 ${saveStatus}
						   </td>
						 </tr>
						</tbody>
				  </table>
          	 	  </c:if>
				  <table style="width:50%; border:0; font-size: 13px; cellpadding:4; padding: 1% 0% 0% 0%; ">
					<tbody>
					 <tr>
					   <td colspan="2" align="center" valign="middle" class="buttonsAll22">
					  	 <input type="submit" name="testCon" id="testCon" value="Test Connection">
					  	 <input type="submit" name="create" id="create" value="Save Connection">
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
		menu_highlight('admin');
		menu_highlight('admin_db_connection');
		menu_highlight('db_connection');
		
		
		$(document).ready(function() {
			var btn =${btn};
		     if(btn  == false){
		        $('#create').prop('disabled', false);
		     }else{
		    	$('#create').prop('disabled', true);
		     }
		 });
	  
	</script>
</body>
</html>
