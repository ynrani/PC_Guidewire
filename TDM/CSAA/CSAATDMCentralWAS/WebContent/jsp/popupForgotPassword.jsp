<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form id="forgotPassForm" name="forgotPassForm" action="#" modelAttribute="forgotPassDTO">
		<table style="width:80%; border:0; font-size: 13px; " cellpadding="4">
              <tbody>
                <tr>
                  <td class="lable-title" align="left" valign="middle">User ID</td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input id="userId" path="userId" class="popUp-ctl email"/>
                </td>
                <tr>
                  <td class="lable-title" align="left" valign="middle">Date of Joining</td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input id="doj" path="doj" class="popUp-ctl email"/>
                  </td>
                </tr>
                 <tr>
                  <td class="lable-title" align="left" valign="middle">Project Id</td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input id="projId" path="projId" class="popUp-ctl email"/>
                  </td>
                </tr>
              </tbody>
          </table>
	  <a href="#" class="btn-primaryemail btn-cellemail" id="submit" title="Experiencing highly connectivity problem with SMTP Server. Please try after some time...">Submit</a>
</form:form>
