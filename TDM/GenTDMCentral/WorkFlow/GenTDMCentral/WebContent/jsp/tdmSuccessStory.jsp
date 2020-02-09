<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!doctype html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Central | Index</title>
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

	<div class="mainAll">
		<jsp:include page="indexHeader.jsp"></jsp:include>
			<div class="container tdm-central">
		 		<form:form id="successStoryForm" name="successStoryForm" action="#">
	
				<h2 class="h2cls">Successes stories:</h2>
				<hr> 
				<p>
					<b>Client</b> : A large regulatory bank in UK
				</p>
				<p>
					<b>Solution Offered</b> : Enterprise-wide TDM, roadmap and TDM strategy
				</p>
				<p>
					<b>Benefits</b> : Capgemini initially provided a roadmap with collaboration and commitment from key stakeholders. Later implemented the enterprise wide solution using incremental approach, taking into account the data security critical applications.
				</p>
				<br/>
				<p>
					<b>Client</b> : A leading North America Life Insurance and Leading Investment bank
				</p>
				<p>
					<b>Solution Offered</b> : Metadata driven framework
				</p>
				<p>
					<b>Benefits</b> : Capgemini implemented this solution with 50% cost and effort savings when running in BAU. Adhered to data privacy compliance laws thus reducing business risk and supported compliance.
				</p>
				<br/>
				<p>
					<b>Client</b> : A leading auto-insurance bank in US
				</p>
				<p>
					<b>Solution Offered</b> : Test data creation and reservation
				</p>
				<p>
					<b>Benefits</b> : Capgemini "Self-service Portal" enabled tester to find "fit for purpose data" and "data reservation" which resulted in less data duplicity issues, leading to cycle time reduction, and reduction of post production defects and overall cost for the release. Solution utilized internal Accelerators for test data creation and large volume data generation
				</p>
				
				
			<table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col" class="buttonsAll8">
                   	   <input type="button" name="back" id="back" value="Home">
                   </th>
                </tr>
              </tbody>
            </table>
				
			</form:form>
			
			</div>
		<script src="include/footer.js"></script>
	</div>
	<script src="include/copyrtfooter.js"></script>
	<script>
	/* menu_highlight('gover');
	menu_highlight('gover_process'); */
	
	 $(document).ready(function() {
	        $("#back").click(function(){
	           	document.location.href="./index";
	      	  });
	      });
	</script>
</body>
</html>

 