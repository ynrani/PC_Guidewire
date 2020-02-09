<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | Data Refresh</title>
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
	<link rel="stylesheet" type="text/css" href="css/steps.css">
	    
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
  <div class="wrapper mainAll">
 <jsp:include page="indexHeader.jsp"></jsp:include>
 <div class="container">
    <form:form id="dataRefreshForm" name="dataRefreshForm" action="${pageContext.request.contextPath}/tdmDataRefresh" modelAttribute="tdgDataMaskingDTO">
    
	    <ol class="breadcrumb">
	    <li><a class="hrefVisited" href="./index">Home</a></li>
	    <li>&#x2f;</li>
	    <li><a class="hrefVisited" href="./index">TDM Life Cycle</a></li>
	    <li>&#x2f;</li>
	    <li class="active">Data Refresh</li>
	  </ol>
	  
	  <c:choose>	  
	     <c:when test="${tdgDataMaskingDTO.dataMasking ne null &&  tdgDataMaskingDTO.dataSubsetting ne null}">
	      <div class="five-step-container">
	      <div class="step1"><span class="step5-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
	      <div class="step2"><span class="step5-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
	      <div class="step3"><span class="step5-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>
	      <div class="step4"><span class="step5-number4">4</span><span class="step-heading">Subsetting <small>Details</small></span></div>
	      <div class="step5-active"><span class="step5-num5">5</span><span class="step-heading">Data Refreshing</span></div>
	    
	      </div>
	     </c:when>
	      <c:when test="${tdgDataMaskingDTO.dataMasking ne null }">
	        <div class="four-step-container">
		      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>
		      <div class="step4-active"><span class="step-num4">4</span><span class="step-heading">Data Refreshing</span></div>		     
		         
	       </div>
	      </c:when>
	       <c:when test="${tdgDataMaskingDTO.dataSubsetting ne null }">
		       <div class="four-step-container">
			      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
			      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
			       <div class="step3"><span class="step-number3">3</span><span class="step-heading">Subsetting <small>Details</small></span></div>			     
			      <div class="step4-active"><span class="step-num4">4</span><span class="step-heading">Data Refreshing</span></div>	     
		       </div>
	       </c:when>	    
	      <c:otherwise>	      
		      <div class="three-step-container">
		      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3-active"><span class="step-number3">3</span><span class="step-heading">Data Refreshing</span></div>
		      </div>	      
	      </c:otherwise>  
	  </c:choose>   
      <h2 style="color: #0098cc"><spring:message code="label.dtref.dtl" /></h2>
      <hr>
      <div class="two-col">
      <table style="width:100%; border:0; font-size: 13px; color: #0C5473;cellpadding:2;">
        <tbody>
          <tr>
        	<td class="lable-title" width="80%" align="left" valign="middle"><spring:message code="label.dtref.q1"/><span>*</span> </td>
            <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:textarea path="dataRefreshQ1" id="dataRefreshQ1" class="form-control" />
            </td>
          </tr>  
          <tr>  
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.dtref.q2"/><span>*</span><br/></td>
            <td class="lable-title" align="left" valign="middle" scope="col">
           		 <form:textarea path="dataRefreshQ2" id="dataRefreshQ2" class="form-control" />
           </td>
          </tr>          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.dtref.q3"/><span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="dataRefreshQ3" id="dataRefreshQ3" class="form-control" />
            </td>
          </tr>
        </tbody>
      </table> 
       <form:hidden path="id" />
     <c:if test="${tdgDataMaskingDTO.dataMasking eq null  &&  tdgDataMaskingDTO.dataSubsetting eq null}">
	      <table style="width:100%;border:0; font-size: 13px; color: #0C5473;">
			<tr>
			<c:choose>
	     	 <c:when test="${(readOnly eq null) && (disabled eq null) && (tdgDataRefreshDTO.dataMasking eq null  &&  tdgDataRefreshDTO.dataSubsetting eq null)}">
	           <th class="lable-title" width="10%" style="font-size:14px; ">Action</th>
	         </c:when> 
	        </c:choose> 
			 
				<th class="lable-title" width="30%" style="font-size:14px; ">Application Name<span>*</span></th>
				<th class="lable-title" width="30%" style="font-size:14px; ">DataBase<span>*</span></th>
				<th class="lable-title" width="30%" style="font-size:14px; ">No of Tables<span>*</span></th>
			</tr>
		   <tbody class="tbodyContainer">
				<input type="hidden" name="tdgDataMaskingNoOfAppsDTOs_hidden" id="tdgDataMaskingNoOfAppsDTOs_hidden" value="${fn:length(tdgDataMaskingDTO.tdgDataMaskingNoOfAppsDTOs)-1}"/>
				<c:forEach items="${tdgDataMaskingDTO.tdgDataMaskingNoOfAppsDTOs}" varStatus="status" var="tdgDataMaskingNoOfAppsDTOs">
					<c:set var ="frRow" value="${status.index+1}"/>
					<c:set var="listSize" value="${fn:length(tdgDataMaskingDTO.tdgDataMaskingNoOfAppsDTOs)}"/> 
				  <tr id='${tdgDataMaskingNoOfAppsDTOs.id}'>
				  <c:choose>
	     	 		<c:when test="${(readOnly eq null) && (disabled eq null)}">
	     	 			<td class="noWrapTxt algnRght" >
	           			<c:choose>
							<c:when test="${frRow==listSize}">
								<a href="javascript:;" class="sprite icon-add  addRow_DMASK" id="tdgDataMaskingNoOfAppsDTOs">Add</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:;" class="delRowFromDB_DMASK sprite icon-delete" id="tdgDataMaskingNoOfAppsDTOs">Delete</a>
							</c:otherwise>
	  					</c:choose>
	  					</td>
	         		</c:when> 
	        	  </c:choose>
	           	  <form:hidden path="tdgDataMaskingNoOfAppsDTOs[${status.index}].id" id="tdgDataMaskingNoOfAppsDTOs[${status.index}].id" /> 
				  <td><form:input path ="tdgDataMaskingNoOfAppsDTOs[${status.index}].appName" id="tdgDataMaskingNoOfAppsDTOs[${status.index}].appName" class="form-control listValidator mandateField" /></td>
				  <td><form:input path ="tdgDataMaskingNoOfAppsDTOs[${status.index}].dbName" id="tdgDataMaskingNoOfAppsDTOs[${status.index}].dbName"  class="form-control listValidator mandateField"/></td> 
				  <td><form:input path ="tdgDataMaskingNoOfAppsDTOs[${status.index}].noOfTables" id="tdgDataMaskingNoOfAppsDTOs[${status.index}].noOfTables"  class="form-control listValidator mandateField"/></td>
			     </tr>
			  </c:forEach> 
		    </tbody>
		  </table> 	  
	   </c:if>  
      <br/>
         <table style="width:100%; border:0;">
            <tbody>
              <tr>
                  <th scope="col" class="buttonsAll8">
                    <input type="button"  id="back" name="back" value="Back">
                    <input type="submit" name="submit" value="Submit"> 
                    <input type="button"  id="cancel" name="cancel" value="Cancel">
               </tr>
            </tbody>
         </table>
       </div>
    </form:form>
  </div>
  <script src="include/footer.js"></script>
</div>
<script src="include/copyrtfooter.js"></script>
<script>
menu_highlight('services');
menu_highlight('services_ref');
tdgDataRefreshValidation('${tdgDataMaskingDTO.id}');
$("#back").click(function(){
	if('${tdgDataMaskingDTO.dataMasking}' == 'Datamasking')
		{
		 document.location.href="./tdmDataMaskingPage3New?reqId=${tdgDataMaskingDTO.id}&status=${tdgDataMaskingDTO.status}";
		}
	else if('${tdgDataMaskingDTO.dataSubsetting}' == 'Subsetting')
		{
	    	document.location.href="./tdmDataSubSettingNew?reqId=${tdgDataMaskingDTO.id}&status=${tdgDataMaskingDTO.status}";
		}  
	else
		{
		  document.location.href="./tdmDataMaskingPage2New?reqId=${tdgDataMaskingDTO.id}&status=${tdgDataMaskingDTO.status}";
		}
	  });
	  
  $("#cancel").click(function(){
 	confirmationForCancel('Cancel','Are you sure do you want to cancel ?',400,'YesNo','Yes','No','${tdgDataMaskingDTO.id}'); 
	  });

</script>

</body>
</html>
