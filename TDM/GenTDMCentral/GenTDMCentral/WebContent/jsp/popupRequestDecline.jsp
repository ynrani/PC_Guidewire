<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form id="requestApproveForm" name="requestApproveForm" action="${pageContext.request.contextPath}/popupRequestDecline" modelAttribute="tdgDataMaskingDTO">
		<table style="width:80%; border:0; font-size: 13px;  cellpadding:4;">
              <tbody>
              
               <form:hidden path="id"/>
               <form:hidden path="type"/>
               <form:hidden path="url"/>
                <tr>
                  <td class="lable-title" align="left" valign="middle"> Reason</td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:textarea style="margin: 0px;height: 144px; width: 545px;" id="reason" path="reason" class="message" charCount="2000"  required="required"/>
                  </td>
                  </tr>
              </tbody>
          </table>
	  	
	  		<table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td colspan="4" align="center" valign="middle" >
                   <input type="submit" name="Decline" id="Decline" value="Decline"  class="btn-primary btn-cell">
                  </td>
                </tr>
              </tbody>
            </table>
</form:form>
