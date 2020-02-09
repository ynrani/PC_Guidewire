<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | On-Boarding Request</title>
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

  <div class="container">
    <form:form id="dataOnboardReqForm" name="dataOnboardReqForm" action="./tdmOnboardReq" modelAttribute="tdmOnboardReqDTO">
	    <ol class="breadcrumb">
	    <li><a class="hrefVisited" href="./index">Home</a></li>
	    <li>&#x2f;</li>
	    <li><a class="hrefVisited" href="./index">TDM Life Cycle</a></li>
	    <li>&#x2f;</li>
	    <li class="active">TDM On-Board Request</li>
	    <c:if test="${reqId ne null}">
	    	<li>&#x2f;</li>
	    	<li style="font-size: 14px; color: #0098CC;">Request ID : ${reqId}</li>
	    </c:if>
	  </ol>
  
      <h2 style="color: #0098cc">TDM On-Board Request Details</h2>
      <hr>
      <div class="two-col">
        <table style="width:100%; border:0; font-size: 13px; color: #0C5473; cellpadding:4;">
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
          
         	<td class="lable-title" align="left" valign="middle">Application Name<span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
                 <form:input path="appName" id="appName" class="form-control" />
            </td>
                
          </tr>
          <tr>
            <td class="lable-title" align="left" valign="middle"><spring:message code="label.env" /><span>*</span> </td>
          	<td class="flied-title" align="left" valign="middle">
               <form:input path="envType" id="envType" class="form-control"/>
             </td>
           
           <td class="lable-title" align="left" valign="middle">Application Phase</td>
            <td class="flied-title" align="left" valign="middle">
             	<form:input path="appPhase" id="appPhase" class="form-control"/>
            </td> 
            
          </tr>
          
          <tr>
            <td class="lable-title" align="left" valign="middle">Application Description<span>*</span> </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="appDesc" id="appDesc" class="form-control" />
            </td>
           </tr>
           
           </tbody>
        </table>     
       </div>
       <br/>
        <br/>
     <div>	
    <table style="width:100%;border:0; font-size: 13px; color: #0C5473;">
		<tr>
			<th class="lable-title" width="10%" style="font-size:14px; ">Action</th>
			<th class="lable-title" width="30%" style="font-size:14px; ">Application Name<span>*</span></th>
			<th class="lable-title" width="30%" style="font-size:14px; ">DataBase<span>*</span></th>
			<th class="lable-title" width="30%" style="font-size:14px; ">No of Tables<span>*</span></th>
		</tr>
	   <tbody class="tbodyContainer">
			<input type="hidden" name="tdgDataMaskingNoOfAppsDTOs_hidden" id="tdgDataMaskingNoOfAppsDTOs_hidden" value="${fn:length(tdmOnboardReqDTO.tdgDataMaskingNoOfAppsDTOs)-1}"/>
			<c:forEach items="${tdmOnboardReqDTO.tdgDataMaskingNoOfAppsDTOs}" varStatus="status" var="tdgDataMaskingNoOfAppsDTOs">
				<c:set var ="frRow" value="${status.index+1}"/>
				<c:set var="listSize" value="${fn:length(tdmOnboardReqDTO.tdgDataMaskingNoOfAppsDTOs)}"/> 
			  <tr id='${tdgDataMaskingNoOfAppsDTOs.id}'>
				<td class="noWrapTxt algnRght" >
	  			<c:choose>
					<c:when test="${frRow==listSize}">
						<a href="javascript:;" class="sprite icon-add  addRow_ON_BOARD" id="tdgDataMaskingNoOfAppsDTOs">Add</a>
					</c:when>
					<c:otherwise>
						<a href="javascript:;" class="delRowFromDB_ON_BOARD sprite icon-delete" id="tdgDataMaskingNoOfAppsDTOs">Delete</a>
					</c:otherwise>
  				</c:choose>
				<form:hidden path="tdgDataMaskingNoOfAppsDTOs[${status.index}].id" id="tdgDataMaskingNoOfAppsDTOs[${status.index}].id" /> 
				<td><form:input path ="tdgDataMaskingNoOfAppsDTOs[${status.index}].appName" id="tdgDataMaskingNoOfAppsDTOs[${status.index}].appName" class="form-control listValidator mandateField" /></td>
				<td><form:input path ="tdgDataMaskingNoOfAppsDTOs[${status.index}].dbName" id="tdgDataMaskingNoOfAppsDTOs[${status.index}].dbName"  class="form-control listValidator mandateField"/></td> 
				<td><form:input path ="tdgDataMaskingNoOfAppsDTOs[${status.index}].noOfTables" id="tdgDataMaskingNoOfAppsDTOs[${status.index}].noOfTables"  class="form-control listValidator mandateField"/></td>
		      </tr>
			</c:forEach> 
	  </tbody> 
	  </table>
	  
		
		<c:if test="${chngeReqYN eq true}">
        <br/>
        <table style="width:100%; border:0; font-size: 13px; color: #0C5473; cellpadding:4;">
          <tbody>
           <tr>
              <td class="lable-title" width="35%" align="left" valign="middle">Change Request Description<span>*</span> </td>
              <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:textarea path="chngReqCmmt" id="chngReqCmmt"  charCount="1000" class="form-control"  required="true"/>
              </td>
              <td class="lable-title" width="25%" align="left" valign="middle"></td>
              <td class="lable-title" width="20%" align="left" valign="middle"></td>
            </tr>
           </tbody>
         </table>
         </c:if>
         
		<br/>
         <table style="width:100%; border:0; ">
            <tbody>
              <tr>
                  <th scope="col">
                    <input type="submit" name="submit" class="btn-primary btn-cell" value="Submit"> 
                 </th>
               </tr>
            </tbody>
         </table>
          	
	</div>	
	<form:hidden path="onboardReqId" />
	<form:hidden path="vno" />
    </form:form>
  </div>
  <script src="include/footer.js"></script>
</div>

<script>

menu_highlight('tdm_life_cycle1');

addNewRowItem('addRow_ON_BOARD','mandateField','','./tdmOnboardReqDelRow','delRowFromDB_ON_BOARD','ON','10','','');
 	
tdmOnboardingReqVali(); 	
 

 
</script>

</body>
</html>
