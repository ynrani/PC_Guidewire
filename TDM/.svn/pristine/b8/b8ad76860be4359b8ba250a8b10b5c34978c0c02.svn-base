<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>TDM Central | Data Subsetting</title>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
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
 <div id="main" class="wrapper">
 <jsp:include page="indexHeader.jsp"></jsp:include>
  <div class="container">
    <form id="governanceForm" name="governanceForm">
       
      <h2 style="color: #0098cc"><spring:message code="label.dtsub.dtl" /></h2>
      <hr>
      <div class="two-col">
        <table style="width:100%; border:0; font-size: 13px; color: #0C5473;" cellpadding="2">
        <tbody>
          <tr>
        	<td class="lable-title" width="80%" align="left" valign="middle"><spring:message code="label.dtsub.q1"/></td>
          </tr>
          <tr>
           <td class="lable-title" align="left" valign="middle"><spring:message code="label.dtsub.q11"/><span>*</span></td>            	
           <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:textarea path="pageDtSub1" id="pageDtSub1" class="form-control" />
           </td>
          </tr>  
          <tr>  
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.dtsub.q2"/><span>*</span></td>
            <td class="lable-title" align="left" valign="middle" scope="col">
           		 <form:textarea path="pageDtSub2" id="pageDtSub2" class="form-control" />
           </td>
          </tr>          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.dtsub.q3" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="pageDtSub3" id="pageDtSub3" class="form-control" />
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
    </form>
  </div>
  <script src="include/footer.js"></script>
</div>
<script src="include/copyrtfooter.js"></script>
<script>
menu_highlight('tdm_life_cycle1');
tdgDataSubsettingValidation();
</script>
</body>
</html>
