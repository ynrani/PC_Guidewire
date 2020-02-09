<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | Data Masking</title>
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
 <c:if test="${readOnly ne null}">
	 <div class="backtoDashBoard">
	      <a class="DbButton" href="${pageContext.request.servletContext.contextPath}/tdmDtMaskDashboard"><spring:message code="label.back.db" /></a>
	 </div>
 </c:if>
  <div class="container">
  <c:choose>	  
	     <c:when test="${tdgDataMaskingDTO.dataSubsetting ne null &&  tdgDataMaskingDTO.dataRefresh ne null && tdgDataMaskingDTO.dataMasking ne null}">
	      <div class="five-step-container">
	      <div class="step1"><span class="step5-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
	      <div class="step2-active"><span class="step5-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
	      <div class="step3"><span class="step5-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>
	      <div class="step4"><span class="step5-number4">4</span><span class="step-heading">Subsetting <small>Details</small></span></div>
	      <div class="step5"><span class="step5-number5">5</span><span class="step-heading">Data Refreshing</span></div>
	    
	      </div>
	     </c:when>
	     <c:when test="${tdgDataMaskingDTO.dataSubsetting ne null && tdgDataMaskingDTO.dataMasking ne null}">
	        <div class="four-step-container">
		      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2-active"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>
		      <div class="step4"><span class="step4-number4">4</span><span class="step-heading">Subsetting <small>Details</small></span></div>		     
		         
	       </div>
	       </c:when>
	       <c:when test="${tdgDataMaskingDTO.dataSubsetting ne null && tdgDataMaskingDTO.dataRefresh ne null}">
	        <div class="four-step-container">
		      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2-active"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Subsetting <small>Details</small></span></div>
		      <div class="step4"><span class="step4-number4">4</span><span class="step-heading">Data Refreshing</span></div>
	       </div>
	       </c:when>
	     
	      <c:when test="${tdgDataMaskingDTO.dataRefresh ne null  && tdgDataMaskingDTO.dataMasking ne null}">
		       <div class="four-step-container">
			      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
			      <div class="step2-active"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
			      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>			     
			      <div class="step4"><span class="step4-number4">4</span><span class="step-heading">Data Refreshing</span></div>	     
		       </div>
		       </c:when>
	       <c:when test="${tdgDataMaskingDTO.dataRefresh ne null }">
		     <div class="three-step-container">
		      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2-active"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Data Refreshing</span></div>
		      </div>
	       </c:when>
	        <c:when test="${tdgDataMaskingDTO.dataMasking ne null }">
		       <div class="three-step-container">
		      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2-active"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>
		      </div>
	       </c:when>
	        <c:when test="${tdgDataMaskingDTO.dataSubsetting ne null }">	       
	        <div class="three-step-container">
		      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2-active"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Subsetting <small>Details</small></span></div>
		      </div>
	      </c:when>	    
	      <c:otherwise>	      
		       <div class="two-step-container">
			      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
			      <div class="step2-active"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
			      <!-- <div class="step3"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div> -->
			  </div>	      
	      </c:otherwise>  
	  </c:choose>
      <h2 style="color: #0098cc;font-size: 14px;"><spring:message code="label.dm.preReqs" /></h2>
      <hr>
      
      <div class="two-col">
      <form:form id="dataMaskingForm2" name="dataMaskingForm2" action="${pageContext.request.contextPath}/tdmDataMaskingPage2New" modelAttribute="tdgDataMaskingDTO">
      <form:hidden path="id"/>
      <form:hidden path="status"/>
        <table style="width:100%; border:0; font-size: 13px; color: #0C5473;cellpadding:2;" >
        <tbody>
          <tr>
        	<td class="lable-title" width="80%" align="left" valign="middle"><spring:message code="label.pre.q1" /> <span>*</span> </td>
            <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:textarea path="page2Q1" id="page2Q1" class="form-control" />
            </td>
          </tr>  
          <tr>  
            <td class="lable-title" align="left" valign="middle">
            	<spring:message code="label.pre.q2" /><br/>
            	&nbsp;&nbsp;<spring:message code="label.pre.q2a" /><br/>
            	&nbsp;&nbsp;<spring:message code="label.pre.q2b" /><br/>
            	&nbsp;&nbsp;<spring:message code="label.pre.q2c" /><br/>
            	&nbsp;&nbsp;<spring:message code="label.pre.q2d" /><br/>            	
            </td>
            <td class="lable-title" align="left" valign="middle" scope="col">
           		 <form:textarea path="page2Q2" id="page2Q2" class="form-control" />
           </td>
          </tr>
          
         <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q3" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page2Q3" id="page2Q3" class="form-control" />
            </td>
          </tr>
          
          <tr> 
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q4" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page2Q4" id="page2Q4" class="form-control" />
            </td>
          </tr>          
          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q5" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page2Q5" id="page2Q5" class="form-control" />
            </td>
          </tr> 
          
          <tr>
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q6" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page2Q6" id="page2Q6" class="form-control" />
            </td>
          </tr>
          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q7" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page2Q7" id="page2Q7" class="form-control" />
            </td>
          </tr>
             
          <tr> 
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q8" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
                 <label class="radio-inline">
                      <form:radiobutton path="page2Q8" id="page2Q8" value="Y" /><spring:message code="label.yes" /></label>
                 <label class="radio-inline">
                      <form:radiobutton path="page2Q8" id="page2Q8" value="N" /><spring:message code="label.no" />
                 </label>
             </td>
          </tr> 
          
          <tr>
          	<td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q9" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
               	 <label class="radio-inline">
                      <form:radiobutton path="page2Q9" id="page2Q9" value="Y" /><spring:message code="label.yes" /></label>
                 <label class="radio-inline">
                      <form:radiobutton path="page2Q9" id="page2Q9" value="N" /><spring:message code="label.no" />
                 </label>                 
            </td>
          </tr>
          
          <tr>
          	<td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q10" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page2Q10" id="page2Q10" class="form-control" />
            </td>
          </tr>
          
          <tr>
          	<td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q11" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page2Q11" id="page2Q11" class="form-control" />
            </td>
          </tr>
           
          <tr>
          	<td class="lable-title" align="left" valign="middle"><spring:message code="label.pre.q12" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
               	<label class="radio-inline">
                      <form:radiobutton path="page2Q12" id="page2Q12" value="Y" /><spring:message code="label.yes" /></label>
                <label class="radio-inline">
                      <form:radiobutton path="page2Q12" id="page2Q12" value="N" /><spring:message code="label.no" />
                </label>
            </td>
          </tr>
          
          <tr>
          	<td class="lable-title" align="left" valign="middle">Please choose the request type(User can choose more than one request): </td>
          </tr>
          <tr>
          <td class="lable-title" align="left" valign="middle"><spring:message code="label.chkbMskingReq" /></td>
          <td class="flied-title" align="left" valign="middle">
          <form:checkbox path="maskingReqChkbx" id="maskingReqChkbx" class="cb_class checkBoxCls" value="masking" />
          
          </td>
          </tr>
           <tr>
          <td class="lable-title" align="left" valign="middle"><spring:message code="label.chkbSubsetting" /></td>
          <td class="flied-title" align="left" valign="middle">
            <form:checkbox path="subsettingChkbx" id="subsettingChkbx" class="cb_class checkBoxCls" value="subsetting" />          
          </td>
          </tr>
           <tr>
          <td class="lable-title" align="left" valign="middle"><spring:message code="label.chkbDataRfrsh" /></td>
          <td class="flied-title" align="left" valign="middle">
          <form:checkbox path="dataRefershChkbx" id="dataRefershChkbx" class="cb_class checkBoxCls" value="datarefersh" />
          
          </td>
          </tr>   
          
          </tbody>
        </table>
        
       <c:choose>
       <c:when test="${readOnly eq null}">               
        <table  style="width:100%; border:0;font-size: 13px; color: #0C5473;align:center;">
            <tbody> 
                 <tr>
                  <th scope="col" class="buttonsAll15">
                    <input type="submit" name="submit" id="back" value="Back"> 
                    <input type="submit" name="submit" id="savncont" value="Save and Continue"> 
                    <input type="button"  id="cancel" name="cancel" value="Cancel">  
                 </th>
               </tr>
            </tbody>
         </table> 
         </c:when>
        <c:when test="${changeReqYN eq true}">        
        <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col" class="buttonsAll15">
                    <input type="submit" name="submit" id="SaveAndContinue" value="Save and Continue"> 
                 </th>
               </tr>
            </tbody>
         </table> 
         </c:when>
         <c:otherwise>
           <table style="width:100%; border:0;align:center; ">
            <tbody>             
              <tr> 
                  <th scope="col" class="buttonsAll8">
                    <input type="submit" name="submit" id="back2" value="Back">
                    <input type="submit" name="submit" id="contin"  value="Continue"> 
                 </th>
               </tr>
            </tbody>
         </table> 
         </c:otherwise>
       </c:choose>        
       </form:form>          
      </div>       
    
  </div>
  <script src="include/footer.js"></script>
</div> 
<script src="include/copyrtfooter.js"></script>

<script>
menu_highlight('services');
menu_highlight('services_mask');

if('${tdgDataMaskingDTO.maskingReqChkbx}' == 'true')
{
	$( "#maskingReqChkbx" ).prop( "checked", true );
}
if('${tdgDataMaskingDTO.subsettingChkbx}' == 'true')
{
	$( "#subsettingChkbx" ).prop( "checked", true );
}
if('${tdgDataMaskingDTO.dataRefershChkbx}' == 'true')
{
	$( "#dataRefershChkbx" ).prop( "checked", true );
}

tdgDataMaskingValidationPage2();

$(document).ready(function() {
	var readOnly = '${readOnly}';
	if(readOnly=='true'){
		
		$("#continue").removeAttr('disabled');
		$("#readBack").removeAttr('disabled');		
		disablePage();
	}
	
       
	$("#cancel").click(function(){
		confirmationForCancel('Cancel','Are you sure do you want to cancel ?',400,'YesNo','Yes','No','${tdgDataMaskingDTO.id}'); 
  	  });
	
  });
  
  
</script>

</body>
</html>
