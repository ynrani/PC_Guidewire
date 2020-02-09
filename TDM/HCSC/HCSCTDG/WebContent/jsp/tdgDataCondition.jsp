<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<title>TDG | Data Conditioner</title>
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
	$(document).ready(
			function() {
				$('#errors').html('');
				$('#errors').hide();
				$('#success').html('');
				$('#success').hide();
				if ("${tdgDataConditionalDTO.errors}" == null
						|| typeof '${tdgDataConditionalDTO.errors}' == ''
						|| '${tdgDataConditionalDTO.errors}' == '') {
					$('#errors').html('');
					$('#errors').hide();

				} else {
					if ('${tdgDataConditionalDTO.getErrors().size()}' > 0) {
						var iLength = '${tdgDataConditionalDTO.getErrors().size()}';
						errorInfo = "";
						for (i = 0; i < iLength; i++) {
							errorInfo += " \n "
									+ "${tdgDataConditionalDTO.getErrors().get(i)}";
						}
						$('#errors').html('${tdgDataConditionalDTO.errors}');
						$('#errors').show();
					}
				}

				if ("${tdgDataConditionalDTO.messageConstant}" == 'FAILED') {
					$('#success').html('');
					$('#success').hide();
					$('#errors').html('${tdgDataConditionalDTO.message}');
					$('#errors').show();
				}else if ("${tdgDataConditionalDTO.messageConstant}" == 'SUCCESS') {
					$('#success').html('${tdgDataConditionalDTO.message}');
					$('#success').show();
					$('#errors').html('');
					$('#errors').hide();
				}

			})
			
</script>

</head>
<body>
	<div id="main" class="wrapper">
		<jsp:include page="indexHeader.jsp"></jsp:include>
		<div id="tabs-1" class="container">
			<ol class="breadcrumb">
				<li><a href="./index">Home</a></li><li>&#x2f;</li>
				<li class="active">Data Conditioner Details</li>
			</ol>

			<form:form name="masterDictionary"
				action="${pageContext.request.contextPath}/tdgDataConditional"
				modelAttribute="tdgDataConditionalDTO" enctype="multipart/form-data">
				<div id="errors" class="errorblock" style="display: none"></div>
				<div id="success" class="successblock" style="display: none"></div>
				<table
					style="width: 100%; border: 0; font-size: 13px; padding-left: 90px; padding-right: 350px; padding-top: 35px;"
					cellpadding="2">
					<tbody>
						<tr>
							<td class="lable-title">User Name :</td>
							<td class="flied-title"><form:input path="username"
									class="form-control" /></td>
						</tr>
						<tr>
							<td class="lable-title">Password :</td>
							<td class="flied-title"><form:input path="password"
									class="form-control"/></td>
						</tr>
						<tr>
							<td class="lable-title">Url :</td>
							<td class="flied-title"><form:input path="url"
									class="form-control"/></td>
						</tr>
						<tr>
							<td class="lable-title">File to upload:</td>
							<td class="flied-title"><form:input type="file"
									path="maltiPartFile" class="form-control" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" 
								class="btn-primary btn-cell" ></td>
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