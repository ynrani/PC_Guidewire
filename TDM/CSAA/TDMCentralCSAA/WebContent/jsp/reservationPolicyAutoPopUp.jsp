<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | My Reservation Record</title>
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" >
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/custom.css">
  <script src="js/html5.js"></script>
  <link href="css/theme.default.css" rel="stylesheet">
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/main.js"></script>
  <script type="text/javascript" src="js/jquery.validate.min.js"></script>  
  <script src="js/common.js"></script>
</head>

<body>
  <div id="main"  class="wrapper">
    
    <div id="tabs-1" class="containerPopUp">
    <form:form id="reservationAutoDataFormPOP" name="reservationAutoDataFormPOP" action="${pageContext.request.contextPath}/myReservationAuto">
    <c:choose>
      <c:when test="${tdmPolicyAutoSearchResultDTO ne null}">
      
      							
        <div id="tabs-1" class="containerPopUp scrollingXPopUp">
          <table class="table outputtable tablesorter" border="0" cellpadding="0" cellspacing="1" style="width:100%; ">
            <thead>
              <tr>
	               <th bgcolor="#E3EFFB" height="25" class="whitefont"><spring:message code="label.policy.num" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.stage" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.state" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.term" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.effDt" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.expDt" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.coverage" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.noDrivers" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.noVehi" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.noViola" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.avlPays" /></th>
                   <th bgcolor="#E3EFFB" scope="col" class="whitefont"><spring:message code="label.policy.avlDocs" /></th>
              </tr>
            </thead>
            <tbody>
             
                <tr>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.policynumber}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.policyStage}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.policyState}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.policyTerm}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.policyEffectDt}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.policyExpDt}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.policyCovge}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.noOfDrivers}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.noOfVehi}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.noOfViola}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.assoPayReq}</td>
                  <td align="center">${tdmPolicyAutoSearchResultDTO.assoDocReq}</td>
              
                </tr>
             
            </tbody>
          </table>
        </div>
       
							
		    <table style="width:100%; border:0">
              <tbody>
                <tr>
                  <th scope="col">
                       <input type="submit" name="export" id="export" class="btn-primary btn-cell" value="ExportAll to Excel">
                   </th>
                </tr>
              </tbody>
            </table>	
      </c:when>
      <c:otherwise>
        <h3 style="float: left; width: 40%; border: 0; font-size: 14px;color: #E74949; padding-top: 15px">
				<u>No Test Data Reserved - In Policy Auto</u>
			</h3>
        <br />
      </c:otherwise>
    </c:choose>
    </form:form>
      
    </div>
    
  </div>
 
 <script>
  	$(".outputtable").tablesorter({
  	    widgets: ['zebra']
  	  });
  </script>
   
</body>

</html>