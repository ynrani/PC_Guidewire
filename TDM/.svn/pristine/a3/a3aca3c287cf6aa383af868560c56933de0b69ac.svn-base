<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
  <title>TDG | Metrics</title>
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
 <div class="mainAll">
 <jsp:include page="indexHeader.jsp"></jsp:include>
 <div class="container">
    <form:form id="dataMaskingForm" name="dataMaskingForm" action="#" >
        <ol class="breadcrumb">
	    <li><a class="hrefVisited" href="./index">Home</a></li>
	    <li>&#x2f;</li>
	    <li><a class="hrefVisited" href="./indexCmdCtr">Command Center</a></li>
	    <li>&#x2f;</li>
	    <li class="active">Metrics</li>
	  </ol>  
	 
	     <div class="">
             
            <table id="search_output_table" class="table tablesorter" style="width:100%;font-size: 13px; background-color: #8B6868; border:0; cellpadding:0; cellspacing:1;">
              <tbody>
                <tr>
                  <th bgcolor="#E3EFFB" scope="col" width="20%" class="whitefont">Classification</th>
                  <th bgcolor="#E3EFFB" scope="col" width="20%" class="whitefont">Steady State Metrics</th>
                  <th bgcolor="#E3EFFB" scope="col" width="30%" class="whitefont">Definition</th>
                  <th bgcolor="#E3EFFB" scope="col" width="30%" class="whitefont">Computation</th>
                </tr>
                
                <tr>
                  <td rowspan="4">Manual Operation</td>
                  <td align="left" >Test Data Rejection Ratio (%)</td>
                  <td align="left" >Test data rejection ratio quantifies the effectiveness of the accuracy of the test data by the TDM team. Higher data rejection ratio indicates that is test data provisioned does not meet test  data  requested</td>
                  <td align="left" >No. of rejected test data provisioned* 100 / Total no. test data provisioned</td>
                </tr>
                <tr>
                  <td align="left" >Test Data  Productivity / Growth</td>
                  <td align="left" >Number of test data requests provisioned per team /per  day. High productivity indicates better efficiency.</td>
                  <td align="left" >No. of test data requests provisioned per team / Person efforts (Hrs.) spent of test data provisioning * No. of Persons in Team</td>
               </tr>
               <tr>
                  <td align="left" >Test Data Requirement Stability Index</td>
                  <td align="left" >To determine how well (completeness and correctness) teams defines test data requirements at first time. Higher requirement stability index indicates that the requirements were not defined correctly at the first time</td>
                  <td align="left" >(Total number of original test data requirements +Number of test data requirements updated  + Number of test data requirements deleted + Number of test data requirements added)  / (Total number of original test data requirements)</td>
               </tr>                   
                <tr>                 
                  <td align="left" >TDM Automated Coverage (%)</td>
                  <td align="left" >Test data scenarios automated vs TDM scenarios  identified  for automation</td>
                  <td align="left" >#TDM scenarios automated x 100 / Total # TDM scenarios identified can be automated per month</td>                  
                </tr>      
                
                <tr>
                  <td align="left" >On Boarding</td>
                  <td align="left" >Masking Coverage (%)</td>
                  <td align="left" >This metric will help to track data security coverage and data compliance</td>
                  <td align="left" >No. of sensitive elements masked x 100 / Total no of sensitive fields identified  / application</td>
                </tr>
                
                <tr>
                  <td align="left" >Trends</td>
                  <td align="left" >Data Refresh Trends</td>
                  <td align="left" >Number of data refresh requests processed Per release / per Month</td>
                  <td align="left" ></td>
                </tr>
                
                <tr>
                  <td align="left" >Portal</td>
                  <td align="left" >TDM Central Utilization</td>
                  <td align="left" >To determine the  actual utilization of TDM Central portal</td>
                  <td align="left" >Actual number of users who used TDM Central / Total number of registered TDM Central users</td>
                </tr>    
              </tbody>         
             </table>
          </div>
        	       <p><b>
                     For More <a class="hrefVisited" href="./tdmCmdCenterMetricsDownload">Download Template</a>
                   </b></p>	
    </form:form>
  </div>
  <script src="include/footer.js"></script>
</div> 
<script>
	menu_highlight('services');
	menu_highlight('services_chng');
	
	 
	$(".table tr:odd").css('background-color','#ffffff');
	$(".table tr:even").addClass('even');

	
	$("#search_output_table").tablesorter({
	    widgets: ['zebra']
	  });
</script>
</body>
</html>
