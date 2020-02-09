<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<title>Manual Dictionary</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<link rel="stylesheet" type="text/css" href="css/theme.default.css">
<link rel="stylesheet" type="text/css" href="css/stylesNew.css">
    
<script type="text/javascript" src="js/html5.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
  <script>
  $(document).ready(function() {
	  $('#errors').html('');
		$('#errors').hide();
		$('#success').html('');
		$('#success').hide();
		if("${tdgDictionaryDTO.errors}" == null || typeof '${tdgDictionaryDTO.errors}' == '' ||  '${tdgDictionaryDTO.errors}' == ''){
			$('#errors').html('');
			$('#errors').hide();
			
		}else{
			 if('${tdgDictionaryDTO.getErrors().size()}' > 0){
				var iLength = '${tdgDictionaryDTO.getErrors().size()}';
				errorInfo = "";
		    	  for(i =0 ; i < iLength ; i++){
		    		  errorInfo += " \n "+"${tdgDictionaryDTO.getErrors().get(i)}";
		    	  }
			$('#errors').html('${tdgDictionaryDTO.errors}');
			$('#errors').show(); 
		}			 
		}
		
		if("${tdgDictionaryDTO.messageConstant}" == 'SUCCESS'){	
			$(".modal").hide();
				alert('${tdgDictionaryDTO.message}');
				window.close(this);
		 }else if("${tdgDictionaryDTO.messageConstant}" == 'FAILED'){
			 $(".modal").hide();
			 alert('${tdgDictionaryDTO.message}');
		 }
		
		
	})
	function showAjaxLoad(){
	  $(".modal").show();
  }
  </script>
</head>
<body>
     <form:form action="${pageContext.request.contextPath}/uploadManualDictionary" modelAttribute="tdgDictionaryDTO" enctype="multipart/form-data">
     <form:hidden path="schemaid"/>
          <div align="center" style="text-align: center; padding: 5%; width: 80%;">
            <table style="text-align: center; padding: 1%; width: 80%;">               
                <tr>
                    <td>
                        <table style="width: 80%" >
                        	<tr>
							<td class="flied-title"><form:input type="file"
									path="maltiPartFile" class="form-control" /></td>
						</tr>
                            <tr>
                                <td align="center" colspan="2">
                               		<input type="submit" name="submit" onclick="showAjaxLoad();" value="Submit" class="btn-primary btn-cell" title="Upload Manual Dictionary"/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
          </div>  
      </form:form>
      <jsp:include page="ajaxfooter.jsp"></jsp:include>
 </body>
</html>