<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form id="createStamentDTOForm" name="createStamentDTOForm" action="#" modelAttribute="createStamentDTO">
		<table style="width:80%; border:0; font-size: 13px;  cellpadding:4;">
              <tbody>
                <tr>
                  <td class="flied-title" align="left" valign="middle">
                    <form:textarea id="createStmt" path="createStmt" class="message" charCount="4000"/>
                  </td>
                </tr>
             </tbody>
          </table>    
          
           <table style="width:80%; border:0; font-size: 13px; ">
               <tbody>     
                <tr>
                 <td class="flied-title" align="left" valign="middle">
                 	<form:input path="tabName" id="tabName" class="form-control" required="required" placeholder="Enter Table Name.."/>
                 </td>
                  <td class="flied-title" align="left" valign="middle">
                 	<input type="button" id="run" value="Run" class="btn-primaryemail btn-cellemail" />
                 </td>
                </tr>
              </tbody>
          </table>
          <form:hidden path="userId"/>
          <form:hidden path="dbName"/>
          
</form:form>
