<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
  <title>TDG | Data Masking</title>
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
<body>
 
  <div id="main" class="wrapper mainAll">
<jsp:include page="indexHeader.jsp"></jsp:include>
  <div class="container">
    <form:form id="dataChMgmtForm" name="dataChMgmtForm" action="${pageContext.request.contextPath}/tdmDataChMgmt" modelAttribute="tdgChangeMgmtDTO">
	    <ol class="breadcrumb">
	    <li><a class="hrefVisited" href="./index">Home</a></li>
	    <li>&#x2f;</li>
	    <li><a class="hrefVisited" href="./index">TDM Life Cycle</a></li>
	    <li>&#x2f;</li>
	    <li class="active">Change Management</li>
	  </ol>
  
      <h2 style="color: #0098cc"><spring:message code="label.chmgmt.dtl"/></h2>
      <hr>
      <div class="two-col">
        <table style="width:100%; border:0; font-size: 13px; color: #0C5473;cellpadding:2;" >
        <tbody>
          <tr> 
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.chmgmt.q1"/><span>*</span> <br/>
            	&nbsp;&nbsp;<spring:message code="label.chmgmt.q1a"/><br/>
            	&nbsp;&nbsp;<spring:message code="label.chmgmt.q1b"/><br/>
            	&nbsp;&nbsp;<spring:message code="label.chmgmt.q1c"/><br/>
            	&nbsp;&nbsp;<spring:message code="label.chmgmt.q1d"/><br/>
            	&nbsp;&nbsp;<spring:message code="label.chmgmt.q1e"/><br/>
            	&nbsp;&nbsp;<spring:message code="label.chmgmt.q1f"/><br/>            
            </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="pageDtChMgmt1" id="pageDtChMgmt1" class="form-control" />
            </td>
          </tr>
          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.chmgmt.q2"/><span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="pageDtChMgmt2" id="pageDtChMgmt2" class="form-control" />
            </td>
          </tr>
          </tbody>
        </table>    
        <br/>
         <table style="width:100%; border:0; ">
            <tbody>
              <tr>
                  <th scope="col" class="buttonsAll8">
                    <input type="button" name="submit" value="Submit"> 
                 </th>
               </tr>
            </tbody>
         </table>
       </div>
    </form:form>
  </div>
  <script src="include/footer.js"></script>
</div>

<script>
 
menu_highlight('services');
menu_highlight('services_ftd');

tdgDataChMgmtValidation();

	


</script>

</body>
</html>
