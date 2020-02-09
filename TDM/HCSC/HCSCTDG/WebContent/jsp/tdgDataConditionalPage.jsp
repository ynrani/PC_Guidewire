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
				if ("${tdgDataConditionDTO.errors}" == null
						|| typeof '${tdgDataConditionDTO.errors}' == ''
						|| '${tdgDataConditionDTO.errors}' == '') {
					$('#errors').html('');
					$('#errors').hide();

				} else {
					if ('${tdgDataConditionDTO.getErrors().size()}' > 0) {
						var iLength = '${tdgDataConditionDTO.getErrors().size()}';
						errorInfo = "";
						for (i = 0; i < iLength; i++) {
							errorInfo += " \n "
									+ "${tdgDataConditionDTO.getErrors().get(i)}";
						}
						$('#errors').html('${tdgDataConditionDTO.errors}');
						$('#errors').show();
					}
				}

				if ("${tdgDataConditionDTO.messageConstant}" == 'FAILED') {
					$('#success').html('');
					$('#success').hide();
					$('#errors').html('${tdgDataConditionDTO.message}');
					$('#errors').show();
				}else if ("${tdgDataConditionDTO.messageConstant}" == 'SUCCESS') {
					$('#success').html('${tdgDataConditionDTO.message}');
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
				<li> <a href="./tdgDataConditionalDashboard">TDG Data Conditioner Dashboard</a></li><li>&#x2f;</li>
				<li class="active">Data Conditioner Operations</li>
			</ol>

			<form:form name="masterDictionary"
				action="${pageContext.request.contextPath}/dataConditionalOperations"
				modelAttribute="tdgDataConditionDTO" >
				<div id="errors" class="errorblock" style="display: none"></div>
				<div id="success" class="successblock" style="display: none"></div>
				<table
					style="width: 100%; border: 0; font-size: 13px; padding-left: 90px; padding-right: 350px; padding-top: 35px;"
					cellpadding="2">
					<form:hidden path="username"/>
					<form:hidden path="password"/>
					<form:hidden path="url"/>
					<form:hidden path="tablename"/>
					<form:hidden path="id"/>
					<tbody>
						<tr>
							<td class="lable-title">User Name :</td>
							<td class="lable-title">${tdgDataConditionDTO.username}</td>
						</tr>
						<tr>
							<td class="lable-title">Password :</td>
							<td class="lable-title">${tdgDataConditionDTO.password}</td>
						</tr>
						<tr>
							<td class="lable-title">Url :</td>
							<td class="lable-title">${tdgDataConditionDTO.url}</td>
						</tr>
						<tr>
							<td class="lable-title">Table Name :</td>
							<td class="lable-title">${tdgDataConditionDTO.tablename}</td>
						</tr>
						<tr>
							<td class="lable-title">Create Records :</td>
							<td class="flied-title"><form:input 
									path="generateCount" class="form-control" /></td>
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