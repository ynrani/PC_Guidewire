<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>L1 L2 Support</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link href="css/theme.default.css" rel="stylesheet">
<link href="css/elements.css" rel="stylesheet">
<script src="js/html5Shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/main.js"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/messages.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<form:form id="x12GenerationForm" name="x12GenerationForm" action="./generateX12File"
	modelAttribute="tdmNonStandSearchDTO">
	<table style="width: 100%; border: 0; font-size: 13px; cellpadding: 4;">
		<tbody>
		<tr>
		  <td class="lable-title" width="30%" align="left" valign="middle">First Name</td>
		   <td class="flied-title" align="left" valign="middle">
		     <form:input path="firstName" id="firstName" class="x12form-control" maxlength="21" />
		   </td>
		   <td class="lable-title" width="30%" align="left" valign="middle">Last Name</td>
		   <td class="flied-title" align="left" valign="middle">
			 <form:input path="lastName" id="lastName" class="x12form-control" maxlength="21" />
		   </td>
	   </tr>
	   
	   <tr>
	   <td class="lable-title" width="30%" align="left" valign="middle">Middle Name</td>
		 <td class="flied-title" align="left" valign="middle">
		   <form:input	path="middleName" id="middleName" class="x12form-control"/>
		 </td>
		<td class="lable-title" width="30%" align="left" valign="middle">Date Of Birth</td>
		 <td class="flied-title" align="left" valign="middle">
		   <form:input	path="dob" id="dob" class="date-control datepicker"	readonly="ture" />
		 </td>		 
	   </tr>
	   
	    <tr>	    
	     <td class="lable-title" width="30%" align="left" valign="middle">Gender</td>
			<td class="flied-title" align="left" valign="middle">
				<form:input	id="gender" path="gender"  class="x12form-control" />
			</td>
		   <td class="lable-title" width="30%" align="left" valign="middle">Corp ID/State</td>
			 <td class="flied-title" align="left" valign="middle">
			 <form:input id="corpId" path="corpId"  class="x12form-control"  /></td> 
		</tr>
		
		 <tr>
		   <td class="lable-title" width="30%" align="left" valign="middle">Zip Code</td>
			<td class="flied-title" align="left" valign="middle">
			 <form:input	id="homeZipCode" path="homeZipCode"  class="x12form-control"/>
			</td>			
			 <td class="lable-title" width="30%" align="left" valign="middle">Address 1</td>
			<td class="flied-title" align="left" valign="middle">
				<form:input	id="addrLine1" path="addrLine1"  class="x12form-control" />
			</td>						
		</tr>
		
		<tr>
		   <td class="lable-title"  width="30%" align="left" valign="middle">Address 2</td>
			 <td class="flied-title" align="left" valign="middle">
			 <form:input id="addrLine2" path="addrLine2"  class="x12form-control"  /></td>			 
			 <td class="lable-title" width="30%" align="left" valign="middle">City</td>
			<td class="flied-title" align="left" valign="middle">
			 <form:input id="city" path="city"  class="x12form-control" /></td>			
		</tr>
	
		<tr>
	      <td class="lable-title" width="30%" align="left" valign="middle">Coverage</td>
			 <td class="flied-title" align="left" valign="middle">
			 <form:input id="coverage" path="coverage"  class="x12form-control"  /></td>			 
			 <td class="lable-title" width="30%" align="left" valign="middle">Group Number</td>
			<td class="flied-title" align="left" valign="middle">
			 <form:input	id="groupNum" path="groupNum"  class="x12form-control" /></td>		  			
		</tr>			
		
		<tr>
		 <td class="lable-title" width="30%" align="left" valign="middle">Sponsor Name</td>
			<td class="flied-title" align="left" valign="middle">
				<form:input	id="sponsorName" path="sponsorName"  class="x12form-control" />
		</td>
		 <td class="lable-title" width="30%" align="left" valign="middle">Sponsor TIN Number</td>
			<td class="flied-title"  align="left" valign="middle">
				<form:input	id="sponsorTIN" path="sponsorTIN"  class="x12form-control" />
			</td>
		</tr>
		
		<tr>	
	       <td class="lable-title" width="30%" align="left" valign="middle">Payer Provider Name</td>
			<td class="flied-title" align="left" valign="middle">
				<form:input	id="providerName" path="providerName"  class="x12form-control" />
			</td>
		   <td class="lable-title" width="30%" align="left" valign="middle">Payer Provider Number</td>
			 <td class="flied-title" align="left" valign="middle">
			 <form:input id="providerNum" path="providerNum"  class="x12form-control"  /></td> 			
		</tr>	
		
		<tr>
	       
		   <td class="lable-title" width="30%" align="left" valign="middle">Member Reference ID</td>
			 <td class="flied-title" align="left" valign="middle">
			 <form:input id="memRefId" path="memRefId"  class="x12form-control"  /></td> 			
		    <td class="lable-title" width="30%" align="left" valign="middle">Product Type</td>
			<td class="flied-title" align="left" valign="middle">
				<form:input	id="planType" path="planType" class="x12form-control"/>
			</td>
	   </tr>
	    
	    <tr>		
			  <td class="lable-title" width="30%" align="left" valign="middle">Member Effective Start Date</td>
			<td class="flied-title" align="left" valign="middle">
				<form:input	id="memEffStartDt" path="memEffStartDt" class="date-control datepicker"	readonly="ture" />
			</td>
		   <td class="lable-title" width="30%" align="left" valign="middle">Member End Date</td>
			 <td class="flied-title" align="left" valign="middle">
			 <form:input id="memEndDate" path="memEndDate" class="date-control datepicker"	readonly="ture" /></td>
			 		
		</tr>	
		
		<tr>
		<td class="lable-title" width="30%" align="left" valign="middle">MCGS Effective Date</td>
			<td class="flied-title" align="left" valign="middle">
				<form:input	id="mcgsEffDate" path="mcgsEffDate"  class="date-control datepicker" readonly="ture" />
			</td> 		       
		   <td class="lable-title"  width="30%" align="left" valign="middle">MCGS End Date</td>
			 <td class="flied-title" align="left" valign="middle">
			 <form:input id="mcgsEndDate" path="mcgsEndDate"  class="date-control datepicker" readonly="ture" /></td> 			
		</tr>				
	 </tbody>
	</table>
	<br>	
	<table style="width: 100%; border: 0; font-size: 13px; cellpadding: 4;">
	  <tbody>
		<tr>
		 <td colspan="4" align="center" valign="middle">
		   <input type="submit" name="generateX12File" id="generateX12File"
			           value="Export To X12" class="btn-primary btn-cell" />
	     </td>
		</tr>
	  </tbody>
	</table>	
</form:form>
<script type="text/javascript">

$("#generateX12File").click(function(){
	hidePopup('popup','popupOverlay');
});

$(".datepicker" ).datepicker({
    defaultDate: "+1w",
    changeMonth: true,
    numberOfMonths: 1,
    changeYear:true,
  });

</script>
</body>
</html>
