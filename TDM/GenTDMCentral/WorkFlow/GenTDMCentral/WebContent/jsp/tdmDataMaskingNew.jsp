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
  <div class="mainAll">
 <jsp:include page="indexHeader.jsp"></jsp:include>
  <c:if test="${readOnly ne null}">
	<div  class="backtoDashBoard">
	      <a class="DbButton" href="${pageContext.request.servletContext.contextPath}/tdmDtMaskDashboard"><spring:message code="label.back.db" /></a>
	 </div>
 </c:if> 
 <div class="container">
  <c:if test="${error ne null}">
	            <table class="my-error-class">
	              <tbody>
	                <tr>
	                  <td class="lable-title" align="left" valign="middle"> ${error}</td>	                
	                </tr>
	              </tbody>
	            </table>
	           </c:if>           
    
          
	  <c:choose>	  
	     <c:when test="${tdgDataMaskingDTO.dataSubsetting ne null &&  tdgDataMaskingDTO.dataRefresh ne null && tdgDataMaskingDTO.dataMasking ne null}">
	      <div class="five-step-container">
	      <div class="step1-active"><span class="step5-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
	      <div class="step2"><span class="step5-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
	      <div class="step3"><span class="step5-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>
	      <div class="step4"><span class="step5-number4">4</span><span class="step-heading">Subsetting <small>Details</small></span></div>
	      <div class="step5"><span class="step5-number5">5</span><span class="step-heading">Data Refreshing</span></div>
	    
	      </div>
	     </c:when>
	     <c:when test="${tdgDataMaskingDTO.dataSubsetting ne null && tdgDataMaskingDTO.dataMasking ne null}">
	        <div class="four-step-container">
		      <div class="step1-active"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>
		      <div class="step4"><span class="step4-number4">4</span><span class="step-heading">Subsetting <small>Details</small></span></div>		     
		         
	       </div>
	       </c:when>
	       <c:when test="${tdgDataMaskingDTO.dataSubsetting ne null && tdgDataMaskingDTO.dataRefresh ne null}">
	        <div class="four-step-container">
		      <div class="step1-active"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Subsetting <small>Details</small></span></div>
		      <div class="step4"><span class="step4-number4">4</span><span class="step-heading">Data Refreshing</span></div>
	       </div>
	       </c:when>
	     
	      <c:when test="${tdgDataMaskingDTO.dataRefresh ne null  && tdgDataMaskingDTO.dataMasking ne null}">
		       <div class="four-step-container">
			      <div class="step1-active"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
			      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
			      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>			     
			      <div class="step4"><span class="step4-number4">4</span><span class="step-heading">Data Refreshing</span></div>	     
		       </div>
		       </c:when>
	       <c:when test="${tdgDataMaskingDTO.dataRefresh ne null }">
		     <div class="three-step-container">
		      <div class="step1-active"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Data Refreshing</span></div>
		      </div>
	       </c:when>
	        <c:when test="${tdgDataMaskingDTO.dataMasking ne null }">
		       <div class="three-step-container">
		      <div class="step1-active"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>
		      </div>
	       </c:when>
	        <c:when test="${tdgDataMaskingDTO.dataSubsetting ne null }">	       
	        <div class="three-step-container">
		      <div class="step1-active"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
		      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
		      <div class="step3"><span class="step-number3">3</span><span class="step-heading">Subsetting <small>Details</small></span></div>
		      </div>
	      </c:when>	    
	      <c:otherwise>	      
		       <div class="two-step-container">
			      <div class="step1-active"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
			      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
			      <!-- <div class="step3"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div> -->
			  </div>	      
	      </c:otherwise>  
	  </c:choose>
	   
      <h2 style="color: #0098cc;font-size: 14px;"><spring:message code="label.dm.reqDtl" /></h2>
      <hr>
      
      <div class="two-col">
      <form:form id="dataMaskingForm" name="dataMaskingForm" action="${pageContext.request.contextPath}/tdmDataMaskingNew" modelAttribute="tdgDataMaskingDTO">
  	   <form:hidden path="id"/>
  	   <form:hidden path="reqTypeCR"/>
  	   <form:hidden path="status"/>
  	   <form:hidden path="edit"/>
  	   <form:hidden path="vno"/>
        <table style="width:100%; border:0; font-size: 13px; cellpadding:4;">
        <tbody>
          <tr>
        	<td class="lable-title" width="35%" align="left" valign="middle"><spring:message code="label.dm.name" /> <span>*</span> </td>
            <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:input path="userName" id="userName" class="form-control" />
            </td>
            <td class="lable-title" width="25%" align="left" valign="middle"><spring:message code="label.dm.uname" /></td>
            <td class="lable-title" width="20%" align="left" valign="middle" scope="col">
           		 <form:input path="userId" id="userId" class="form-control" readonly="true" />
           </td>
          </tr>          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.dm.email" /><span>*</span></td>
            <td class="flied-title" align="left" valign="middle">
            	<form:input path="emailId" id="emailId" class="form-control" />
            </td>
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.dm.phNo" /></td>
            <td class="lable-title" align="left" valign="middle" scope="col">
           		 <form:input path="phoneNo" id="phoneNo" class="form-control" />
           </td>
          </tr>          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.dm.deptName" /><span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:input path="deptName" id="deptName" class="form-control" />
            </td>
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.dm.needBy" /></td>
            <td class="lable-title" align="left" valign="middle" scope="col">
           	   <form:select path="neededBy" id="neededBy" class="down-control">
                  <form:option value="">--Select--</form:option>
                  <form:option value="Tester">Tester</form:option>
                  <form:option value="Lead">Lead</form:option>
                  <form:option value="Architect">Architect</form:option>
                  <form:option value="Manager">Manager</form:option>
                  <form:option value="Client">Client</form:option>                  
               </form:select>
           </td>
          </tr>
          <tr>
         	<td class="lable-title" align="left" valign="middle"><spring:message code="label.dm.projName" /><span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:select path="projName" id="projName" class="down-control">
                  <form:option value="">--Select--</form:option>
                  <form:option value="Project1">Project1</form:option>
                  <form:option value="Project2">Project2</form:option>
                  <form:option value="Project3">Project3</form:option>
                  <form:option value="Project4">Project4</form:option>                
               </form:select>
            </td>
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.dm.projPhase" /></td>
            <td class="flied-title" align="left" valign="middle">
             	<form:select path="projPhase" id="projPhase" class="down-control">
                  <form:option value="">--Select--</form:option>
                  <form:option value="Project1_Phase_1">Project1_Phase_1</form:option>
                  <form:option value="Project1_Phase_2">Project1_Phase_2</form:option>
                  <form:option value="Project2_Phase_1">Project2_Phase_1</form:option>
                  <form:option value="Project2_Phase_2">Project2_Phase_2</form:option>
                  <form:option value="Project3_Phase_1">Project3_Phase_1</form:option>
                  <form:option value="Project3_Phase_2">Project3_Phase_2</form:option>
                  <form:option value="Project4_Phase_1">Project4_Phase_1</form:option>
                  <form:option value="Project4_Phase_2">Project4_Phase_2</form:option>
               </form:select>
            </td> 
           </tr>
          <tr>
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.dm.projId" /></td>
            <td class="flied-title" align="left" valign="middle">
            	<form:input path="projectId" id="projectId" class="form-control" />
            </td> 
          	<td class="lable-title" align="left" valign="middle"><spring:message code="label.env" /><span>*</span> </td>
          	<td class="flied-title" align="left" valign="middle">
               <form:select path="envType" id="envType" class="down-control">
                  <form:option value="">--Select--</form:option>
                  <form:option value="Project1_Env_1">Project1_Env_1</form:option>
                  <form:option value="Project1_Env_2">Project1_Env_2</form:option>
                  <form:option value="Project2_Env_1">Project2_Env_1</form:option>
                  <form:option value="Project2_Env_2">Project2_Env_2</form:option>
                  <form:option value="Project3_Env_1">Project3_Env_1</form:option>
                  <form:option value="Project3_Env_2">Project3_Env_2</form:option>
                  <form:option value="Project4_Env_1">Project4_Env_1</form:option>
                  <form:option value="Project4_Env_2">Project4_Env_2</form:option>
               </form:select>
             </td>
          </tr>
          </tbody>
        </table> 
        
      
       <c:choose>
       <c:when test="${readOnly eq null}">        
        <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col" class="buttonsAll15" align="center">
                    <input type="submit" name="submit"   value="Save and Continue"> 
                 </th>
               </tr>
            </tbody>
         </table> 
         </c:when>
        <c:when test="${changeReqYN eq true}">        
        <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col" class="buttonsAll15" align="center">
                    <input type="submit" id="submit" name="submit" value="Save and Continue"> 
                 </th>
               </tr>
            </tbody>
         </table> 
         </c:when>
         <c:otherwise>
           <table style="width:100%; border:0" >
              <tbody>
                <tr>
                  <th scope="col" class="buttonsAll8" align="center">
                    <input type="submit" id="submit"  name="submit"  value="Continue"> 
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

tdgDataMaskingValidation();

$(function() {
	$( document ).tooltip({
		position: {
			my: "center bottom-20",
			at: "center top",
			using: function( position, feedback ) {
				$( this ).css( position );
				$( "<div>" )
					.addClass( "arrow" )
					.addClass( feedback.vertical )
					.addClass( feedback.horizontal )
					.appendTo( this );
			}
		}
	});
});

$(document).ready(function() {
	$(document).ready(function() {
		var readOnly = '${readOnly}';
		if(readOnly=='true'){
			
			disablePage();
		}
		  
      
  });	
});
</script>
</body>
</html>
