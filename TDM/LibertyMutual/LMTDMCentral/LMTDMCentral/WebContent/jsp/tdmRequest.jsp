<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | Request</title>
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
     <br />
     
     <br />
     <br />
	      
	   
      <h2 style="color: #0098cc;font-size: 14px;">TDM Work Intake - New Item</h2>
      <hr>
      
      <div class="two-col">
      <form:form id="tdmRequestForm" name="tdmRequestForm" action="${pageContext.request.contextPath}/tdmRequest" modelAttribute="tdmRequestDTO" >
  	   <form:hidden path="id"/>
  	   <form:hidden path="status"/>
  	   <form:hidden path="edit"/>
  	   <form:hidden path="vno"/>
  	   <form:hidden path="userId"/>
  	   
        <table style="width:100%; border:0; font-size: 13px; cellpadding:4;">
        <tbody>
          <tr>
        	<td class="lable-title" width="35%" align="left" valign="middle">Project Name <span>*</span> </td>
            <td class="flied-title" width="20%" align="left" valign="middle">
            	<form:input path="projName" id="projName" required="required" class="form-control" />
            </td>
            <td class="lable-title" width="25%" align="left" valign="middle">Project Number<span>*</span></td>
            <td class="lable-title" width="20%" align="left" valign="middle" scope="col">
           		 <form:input path="projNum" id="projNum" required="required" class="form-control" />
           </td>
          </tr>          
          <tr>
          	<td class="flied-title" align="left">Domain Area</td>
            <td class="flied-title">
               <label class="checkbox-inline">
                 <form:checkbox path="domainArea" id="domainArea" value="Information Management" /> Information Management
                </label>
            </td>
                    
            <td class="lable-title" align="left" valign="middle" scope="col">CI Simplification</td>
                <td class="flied-title" align="left" valign="middle" scope="col">
                  <label class="radio-inline">
                    <form:radiobutton path="ci" id="ci" value="Yes" />Yes</label>
                  <label class="radio-inline">
                    <form:radiobutton path="ci" id="ci" value="No" />No
                  </label>
                </td>
             
           
          </tr>          
          <tr>
          
           <td class="lable-title" align="left" valign="middle">Application <span>*</span></td>
            <td class="lable-title" align="left" valign="middle" scope="col">
           		 <form:input path="app" id="app" required="required" class="form-control" />
           </td>
           
           
        	<td class="lable-title" align="left" valign="middle">Status </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:select path="sts" id="sts" class="down-control">
                  <form:option value="">--Select--</form:option>
                  <form:option value="Submitted">Submitted</form:option>
                  <form:option value="Pending">Pending</form:option>
               </form:select>
            </td>
            
          </tr>
          <tr>
          
          <td class="lable-title" align="left" valign="middle">Additional Details</td>
            <td class="lable-title" align="left" valign="middle" scope="col">
           	   <form:textarea path="addiInfo" id="addiInfo" class="form-control" placeholder="Enter Text here..."/>
           </td>
           
         	<td class="lable-title" align="left" valign="middle">Project Folder</td>
            <td class="flied-title" align="left" valign="middle">
            	<form:textarea path="projFolder" id="projFolder" class="form-control" placeholder="Enter Text here..."/>
            </td>
            
            
            
           </tr>
          <tr>
           
            <td class="lable-title" align="left" valign="middle">Priority </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:select path="priority" id="priority" class="down-control">
                  <form:option value="">--Select--</form:option>
                  <form:option value="High">High</form:option>
                  <form:option value="Normal">Normal</form:option>
                  <form:option value="Low">Low</form:option>
               </form:select>
            </td>
            
            <td class="lable-title" align="left" valign="middle">Requestor</td>
            <td class="flied-title" align="left" valign="middle">
             	<form:input path="requestor" id="requestor" class="form-control" />
            </td> 
              
            
          </tr>
          
          <tr>
           
           <td class="lable-title" align="left" valign="middle">TDM Priority </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:select path="tdmPriority" id="tdmPriority" class="down-control">
                  <form:option value="">--Select--</form:option>
                  <form:option value="High">High</form:option>
                  <form:option value="Normal">Normal</form:option>
                  <form:option value="Low">Low</form:option>
               </form:select>
            </td>
            
            <td class="lable-title" align="left" valign="middle">Estimate</td>
            <td class="flied-title" align="left" valign="middle">
             	<form:input path="estimate" id="estimate" class="form-control" />
            </td> 
             
          	 
          </tr>
          
          
          <tr>
           
            <td class="lable-title" align="left" valign="middle">TDM Phase </td>
            <td class="flied-title" align="left" valign="middle">
            	<form:select path="tdmPhase" id="tdmPhase" class="down-control">
                  <form:option value="">--Select--</form:option>
                  <form:option value="Initial Discovery">Initial Discovery</form:option>
                  <form:option value="Assessment/Recommendation">Assessment/Recommendation</form:option>
               </form:select>
            </td>
            
            <td class="lable-title" align="left" valign="middle">Request Type</td>
            <td class="flied-title" align="left" valign="middle">
            <form:select path="reqType" id="reqType" class="down-control">
             	 <form:option value="">--Select--</form:option>
                  <form:option value="Copy Down">Copy Down</form:option>
                  <form:option value="Create New">Create New</form:option>
                  <form:option value="Data Refresh">Data Refresh</form:option>
                 </form:select>
            </td> 
              
            
          </tr>
          
           <tr>
           
           <td class="lable-title" align="left" valign="middle">Request Category</td>
            <td class="flied-title" align="left" valign="middle" scope="col">
                  <label class="radio-inline">
                    <form:radiobutton path="reqCategory" id="ci" value="New TDM request" />New TDM request</label>
                  <label class="radio-inline">
                    <form:radiobutton path="reqCategory" id="ci" value="Supplementary  TDM request" />Supplementary  TDM request
                  </label>
                </td>
            
               <td class="lable-title" align="left" valign="middle">Attachment</td>
               <td class="flied-title" align="left" valign="middle">
             	<form:input type="file" path="file" id="file" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" class="file-control"/>
               </td> 
             </tr>
           
          </tbody>
        </table>   
       
           
       
      
       <table  style="width:100%; border:0;font-size: 13px; color: #0C5473;align:center; ">
            <tbody>
               <tr>
                 <th scope="col" class="buttonsAll8">
                    <input type="submit" id="submit" name="submit" class="btn-primary btn-cell" value="Submit"> 
                    <input type="reset"  id="reset" name="reset" class="btn-primary btn-cell" value="Reset">                     
                 </th>
               </tr>
            </tbody>
         </table>
               
        </form:form>           
      </div>       
  </div>
    <script src="include/footer.js"></script>
</div> 
<script src="include/copyrtfooter.js"></script>
<script>

menu_highlight('services');
menu_highlight('services_mask');

 

tdmReqCreate();

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
