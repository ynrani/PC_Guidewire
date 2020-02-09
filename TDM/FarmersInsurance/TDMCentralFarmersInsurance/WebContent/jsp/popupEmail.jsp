<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form id="autoEmailForm" name="autoEmailForm" action="#" modelAttribute="autoEmailDTO">
		<table style="width:80%; border:0; font-size: 13px;  cellpadding:4;">
              <tbody>
                <tr>
                  <td class="lable-title" align="left" valign="middle"> To </td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input id="to" path="to" class="popUp-ctl email"/>
                </td>
                <tr>
                  <td class="lable-title" align="left" valign="middle"> Cc</td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input id="cc" path="cc" class="popUp-ctl email"/>
                  </td>
                </tr>
                 <tr>
                  <td class="lable-title" align="left" valign="middle"> Subject</td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:input id="subject" path="subject" class="popUp-ctl email"/>
                  </td>
                </tr>
                <tr>
                  <td class="lable-title" align="left" valign="middle"> Message</td>
                  <td class="flied-title" align="left" valign="middle">
                    <form:textarea id="msg" path="msg" class="message" charCount="2000"/>
                  </td>
                  <form:hidden path="from"/>
                </tr>
              </tbody>
          </table>
	  <a href="javascript:%20check_empty()" class="btn-primaryemail btn-cellemail" id="submit" title="Experiencing highly connectivity problem with SMTP Server. Please try after some time...">Send</a>
</form:form>
