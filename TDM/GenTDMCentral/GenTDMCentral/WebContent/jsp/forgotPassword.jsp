<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" >
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
     <form:form action="${pageContext.request.contextPath}/loginforgotPassword" modelAttribute="forgotPasswordDto">
          <div align="center" style="text-align: center; padding: 10%; width: 50%;">
            <table style="text-align: center; padding: 10%; width: 50%;">               
                <tr>
                    <td>
                        <table style="width: 50%" border="0">
                        	<tr>
                                <td><form:input path="userId" id="userId"  class="formcontrolForgot" placeholder="User ID" required="true"/></td>
                            </tr>
                            <tr>
                                <td><form:input path="emailId" id="emailId"  class="formcontrolForgot" placeholder="Email ID"  required="true"/></td>
                            </tr>
                            <tr>
                                <td align="center" class="buttonsAll">
                               		<input type="button" name="submit" value="Send Email" title="Experiencing highly connectivity problem with SMTP Server. Please try after some time..."/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
          </div>  
      </form:form>
 </body>
</html>