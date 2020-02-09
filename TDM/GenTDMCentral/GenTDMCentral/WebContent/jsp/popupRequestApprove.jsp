<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form id="requestApproveForm" name="requestApproveForm" action="${pageContext.request.contextPath}/popupRequestApprove" modelAttribute="tdgDataMaskingDTO">
		<table style="width:80%; border:0; font-size: 13px;  cellpadding:4;">
              <tbody>
              
               <form:hidden path="id"/>
               <form:hidden path="type"/>
               <form:hidden path="url"/>
                <tr>
                  <td class="lable-title" width="30%" align="left" valign="middle"> Assign To </td>
                  <td class="flied-title" width="70%" align="left" valign="middle">
                    <form:select path="assignTo" id="assignTo"  required="required" class="down-control">
                      <form:option value="">--Select--</form:option>
                      <form:option value="Masking Team">Masking Team</form:option>
                      <form:option value="Data Refresh Team">Data Refresh Team</form:option>
                      <form:option value="Sub setting Team">Sub setting Team</form:option>
                      <form:option value="FTD Team">FTD Team</form:option>
                      <form:option value="TDM Team">TDM Team</form:option>
                    </form:select>
                </td>
                </tr>
                
              </tbody>
          </table>
	  		
	  		<table style="width:100%; border:0; font-size: 13px;; cellpadding:4;">
              <tbody>
                <tr>
                  <td colspan="4" align="center" valign="middle">
                   <input type="submit" name="Approve" id="Approve" value="Approve"  class="btn-primary btn-cell">
                  </td>
                </tr>
              </tbody>
            </table>
</form:form>
