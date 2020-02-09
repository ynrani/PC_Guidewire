<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
  <title>TDG | Master Dictionary</title>
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
			 $('#success').html('${tdgDictionaryDTO.message}');
				$('#success').show(); 
		 }else if("${tdgDictionaryDTO.messageConstant}" == 'FAILED'){
			 $('#success').html('');
				$('#success').hide();
				$('#errors').html('${tdgDictionaryDTO.message}');
				$('#errors').show();
		 }
		
	})
	function showAjaxLoad(){
	  $(".modal").show();
  }
  </script>

</head>
<body>
   <div id="main" class="wrapper">
    <!-- <script src="include/indexHeader.js"></script> -->
    <jsp:include page="indexHeader.jsp"></jsp:include>
      <div id="tabs-1" class="container">
		
		<form:form name="masterDictionary" action="${pageContext.request.contextPath}/tesdaMasterDictionary" modelAttribute="tdgDictionaryDTO" enctype="multipart/form-data">
		<div id="errors" class="errorblock" style = "display:none" ></div>
		<div id="success" class="successblock" style = "display:none" ></div>
			<table style="width:100%; border:0; font-size: 13px; padding-left: 90px; padding-right: 350px; padding-top: 35px;" >
			<tbody>
				<tr>
					<th class="lable-title">File to upload: </th>
					<th class="flied-title"><form:input type="file" path="maltiPartFile" class="form-control" /></th>
				</tr>				
				<tr>
					<th>
							<input type="submit" value="Submit" onclick="showAjaxLoad();" class="btn-primary btn-cell"  id="submit">
					</th>			
				</tr>
			</tbody>	
			</table>
		</form:form>
	  </div>
  </div>
  <script>
 	menu_highlight('tdm_command_center1');
  </script>  
</body>
</html>