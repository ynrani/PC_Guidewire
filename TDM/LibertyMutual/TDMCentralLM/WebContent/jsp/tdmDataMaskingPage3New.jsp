<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | Data Masking</title>
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" >
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/custom.css">
  <link href="css/theme.default.css" rel="stylesheet">
  <script src="js/html5Shiv.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/main.js"></script>
  <script src="js/jquery.validate.min.js" type="text/javascript" ></script>  
  <script src="js/messages.js"></script>
  <script src="js/common.js"></script>
  <script src="js/jquery-migrate-1.2.1.min.js"></script>
<body>
 
 <div class="wrapper mainAll">
 <jsp:include page="indexHeader.jsp"></jsp:include>
  <c:if test="${readOnly ne null}">
	 <div style="float: right; width: 14%; border: 0; font-color: #163361 ;padding-top: 15px;padding-left: 74px;">
	      <a class="DbButton" href="${pageContext.request.servletContext.contextPath}/tdmDtMaskDashboard"><spring:message code="label.back.db" /></a>
	 </div>
 </c:if>	 
 <div class="container">
   
	  <ol class="breadcrumb">
	    <li><a class="hrefVisited" href="./index">Home</a></li>
	    <li>&#x2f;</li>
	    <li><a class="hrefVisited" href="./index">TDM Life Cycle</a></li>
	    <!-- <li>&#x2f;</li>
	    <li><a class="hrefVisited" href="./tdmDtMaskDashboard">Data Masking Dashboard</a></li> -->
	    <li>&#x2f;</li>
	    <li class="active">Data Masking</li>
	  </ol>  
	  <div class="three-step-container">
	      <div class="step1"><span class="step-number1">1</span><span class="step-heading">Requestor <small>Details</small></span></div>
	      <div class="step2"><span class="step-number2">2</span><span class="step-heading">Pre-<small>Requisites</small></span></div>
	      <div class="step3-active"><span class="step-number3">3</span><span class="step-heading">Masking <small>Details</small></span></div>
	   </div>
	   
      <h2 style="color: #0098cc;font-size: 14px;"><spring:message code="label.dm.dtl" /></h2>
      <hr>
      <c:if test="${result ne null}">
      
			<table style="width:100%; border:0; font-size: 14px; font-style: italic; color:#A56C33; cellpadding:4;">
              <tbody>
                <tr>
                  <td class="lable-title" align="left" valign="middle"> ${result}</td>
                  <td style="color: red"><a href="${pageContext.request.servletContext.contextPath}/tdmDtMaskDashboard">Click Here For Back To Dashboard</a></td>
                </tr>
              </tbody>
            </table>
       </c:if>     
       
      <div class="two-col">
      <form:form id="dataMaskingForm3" name="dataMaskingForm3" action="${pageContext.request.contextPath}/tdmDataMaskingPage3New" modelAttribute="tdgDataMaskingDTO">    
      <form:hidden path="status"/>
        <table style="width:100%; border:0; font-size: 13px; color: #0C5473; cellpadding:2;">
        <tbody>
          <%-- <tr>
        	<td class="lable-title" width="80%" align="left" valign="middle"><spring:message code="label.msk.q1" /> <span>*</span> </td>
            <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:textarea path="page3Q1" id="page3Q1" class="form-control" />
            </td>
          </tr> 
          <tr>  
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q2" /><br/></td>
            <td class="lable-title" align="left" valign="middle" scope="col">
           		 <form:textarea path="page3Q2" id="page3Q2" class="form-control" />
           </td>
          </tr>          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q3" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page3Q3" id="page3Q3" class="form-control" />
            </td>
          </tr>   --%>         
          <tr> 
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q4" /> <span>*</span> <br/>
            	&nbsp;&nbsp;<spring:message code="label.msk.q4a" /><br/>
            	&nbsp;&nbsp;<spring:message code="label.msk.q4b" /><br/>
            	&nbsp;&nbsp;<spring:message code="label.msk.q4c" /><br/>
            	&nbsp;&nbsp;<spring:message code="label.msk.q4d" /><br/>
            	&nbsp;&nbsp;<spring:message code="label.msk.q4e" /><br/>
            	&nbsp;&nbsp;<spring:message code="label.msk.q4f" /><br/>            
            </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page3Q4" id="page3Q4" class="form-control" />
            </td>
          </tr>          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q5" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page3Q5" id="page3Q5" class="form-control" />
            </td>
          </tr>          
          <tr>
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q6" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page3Q6" id="page3Q6" class="form-control" />
            </td>
          </tr>          
          <tr>
        	<td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q7" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page3Q7" id="page3Q7" class="form-control" />
            </td>
          </tr>          
           <tr> 
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q8" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page3Q8" id="page3Q8" class="form-control" />
            </td>             
           </tr>          
          <tr>
          	<td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q9" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page3Q9" id="page3Q9" class="form-control" />
            </td>
          </tr>          
          <tr>
          	<td class="lable-title" align="left" valign="middle"><spring:message code="label.msk.q10" /> <span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="page3Q10" id="page3Q10" class="form-control" />
            </td>
          </tr>
          </tbody>
        </table>    
        <br/>
        <br/>
    <div>
		<table style="width:100%;border:0; font-size: 13px; color: #0C5473;">
		<tr>
		<c:choose>
     	 <c:when test="${(readOnly eq null) && (disabled eq null)}">
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
	</div>	  
	
	<form:hidden path="vno" />
	<form:hidden path="id" />
		
    <br/>
    
    <c:if test="${changeReqYN eq true}">
        <table style="width:100%; border:0; font-size: 13px; color: #0C5473;; cellpadding:4;">
          <tbody>
           <tr>
              <td class="lable-title" width="35%" align="left" valign="middle">Change Request Description<span>*</span> </td>
              <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:textarea path="chngReqCmmt" id="chngReqCmmt"  charCount="1000" class="form-control" required="true"/>
              </td>
              <td class="lable-title" width="25%" align="left" valign="middle"></td>
              <td class="lable-title" width="20%" align="left" valign="middle"></td>
            </tr>
           </tbody>
         </table>
       </c:if>
     <c:choose>
      <c:when test="${(readOnly eq null) && (disabled eq null)}">
         <table  style="width:100%; border:0;font-size: 13px; color: #0C5473;align:center; ">
            <tbody>
               <tr>
                 <th scope="col">
                    <input type="button"  id="back" name="back" class="btn-primary btn-cell" value="Back"> 
                    <input type="submit" id="submit" name="submit" class="btn-primary btn-cell" value="Submit"> 
                    <input type="button"  id="cancel" name="cancel" class="btn-primary btn-cell" value="Cancel">                     
                 </th>
               </tr>
            </tbody>
         </table>
         </c:when> 
         <c:otherwise>
           <table style="width:100%; border:0; align:center;">
            <tbody>
              <tr>
                  <th scope="col">
                    <input type="button"  id="readBack" name="readBack" class="btn-primary btn-cell" value="Back"> 
                    <input type="button" name="export" id="export" class="btn-primary btn-cell" value="Export to Excel"> 
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

<script>
menu_highlight('tdm_life_cycle1');
tdgDataMaskingValidationPage3();
 
addNewRowItem('addRow_DMASK','mandateField','','./tdmDataMaskingPage3DelRow','delRowFromDB_DMASK','DM','10','','');

$(document).ready(function() {

	var readOnly = '${readOnly}';
	var disabled='${disabled}';
	if(readOnly =='true' || disabled =='true'){
		disablePage();
	}
	
	 
	
	$("#back").click(function(){
       	document.location.href="./tdmDataMaskingPage2New?reqId=${tdgDataMaskingDTO.id}&status=${tdgDataMaskingDTO.status}";
  	  });
	
	$("#readBack").click(function(){
		document.location.href="./tdmDataMaskingPage2New?reqId=${tdgDataMaskingDTO.id}&status=${tdgDataMaskingDTO.status}";
  	  });
	
	$("#cancel").click(function(){
		confirmationFotCancel('Cancel','Are you sure do you want to cancel ?',400,'YesNo','Yes','No','${tdgDataMaskingDTO.id}'); 
  	  });
	
 	  
     $("#export").click(function(){
    	 document.location.href="./tdmDataMaskingPage3NewExport?reqId=${tdgDataMaskingDTO.id}";
   	 });  
 
 });
 
 
</script>
</body>
</html>
