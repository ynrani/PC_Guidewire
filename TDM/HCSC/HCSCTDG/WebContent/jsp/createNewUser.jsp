<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<title>TDG | Create User</title>
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

<script type="text/javascript">
	$(document).ready(function() {
		$('#error').hide();
		$('#userid').blur(function() {
			var userid = $('#userid').val().trim();
			if (userid != null && userid != '') {
				$.ajax({
					type : "POST",
					url : "./validateUserId",
					data : "userid=" + userid,
					success : function(response) {
						if (response.status == "SUCCESS") {
							$('#error').html("");
							$('#error').hide();
							$("#submit").removeAttr('disabled');
						} else {
							$("#submit").prop('disabled', 'disabled');
							errorInfo = "";
							for (i = 0; i < response.result.length; i++) {
								errorInfo += " \n " + response.result[i];
							}

							$('#error').html(errorInfo);
							$('#error').show();
						}
					},
					error : function(e) {
						$("#submit").prop('disabled', 'disabled');
					}
				});
			}
		})
		$('#submit').click(function() {
			var userid = $('#userid').val().trim();

			if ($.trim($('#userid').val()) == "") {
				alert("UserId can not be blank");
				$('#userid').focus();
				return false;
			}
			if ($.trim($('#username').val()) == "") {
				alert("Username can not be blank");
				$('#username').focus();
				return false;
			}
			if ($.trim($('#emailId').val()) == "") {
				alert("EmailId cannot be blank");
				$('#emailId').focus();
				return false;
			} else {
				/* if (!(validateEmail(document.getElementById("emailId"), $.trim($('#emailId').val())))) {
					return false;
				} */
			}
			if ($.trim($('#mobilenum').val()) == "") {
				alert("Mobile number can not be blank");
				$('#mobilenum').focus();
				return false;
			} else {
				if (!(validateMobileNo($.trim($('#mobilenum').val())))) {
					return false;
				}
			}
		})

	})
	function updateEditStatus(id) {
		if (id.length > 0) {
			document.getElementById("userid").disabled = true;
		}

	}
	function validateMobileNo(mobileno) {

		if (isNaN(mobileno) || mobileno.indexOf(" ") != -1) {
			alert("Enter numeric value for mobile no.")
			return false;
		}
		if (mobileno.length > 10 || mobileno.length < 10) {
			alert("enter 10 characters for mobile no.");
			return false;
		}
		return true;

	}
</script>
</head>
<body>
	<div class="mainAll">
		<!-- <script src="include/indexHeader.js"></script> -->
		<jsp:include page="indexHeader.jsp"></jsp:include>

		<div id="tabs-1" class="container">
			<c:if test="${error ne null}">
				<table class="my-error-class">
					<tbody>
						<tr>
							<td class="lable-title" align="left" valign="middle">
								${error}</td>
						</tr>
					</tbody>
				</table>
			</c:if>

			<form:form name="createuser"
				action="${pageContext.request.contextPath}/tesdaUserCreate"
				method="post" modelAttribute="userdo">
				<div id="error" class="errorblock"></div>
				<form:hidden path="created" value="${userdo.isCreated()}" />
				<table
					style="width: 100%; border: 0; font-size: 13px; padding-left: 90px; padding-right: 350px; padding-top: 35px;cellpadding:2;">

					<tr>
						<td class="lable-title">User Id</td>
						<td class="flied-title"><form:input id="userid" path="userId"
								class="form-control" disabled="${userdo.isCreated() != 'true'}" /></td>
					</tr>
					<tr>
						<td class="lable-title">User Name</td>
						<td class="flied-title"><form:input path="username"
								id="username" class="form-control" /></td>
					</tr>
					<tr>
						<td class="lable-title">EmailId</td>
						<td class="flied-title"><form:input path="emailId"
								id="emailId" placeholder="abc.xyz@capgemini.com"
								onfocus="this.placeholder=''"
								onblur="this.placeholder='abc.xyz@capgemini.com'"
								class="text ui-widget-content form-control" /></td>
					</tr>
					<tr>
						<td class="lable-title">Mobile no.</td>
						<td class="flied-title"><form:input path="mobileNo"
								id="mobilenum" class="form-control" /></td>
					</tr>
					<tr>
						<td class="lable-title">Active</td>
						<td class="flied-title"><label class="radio-inline">
								<form:radiobutton path="enabled" value="1" checked="true" />Yes
						</label> <label class="radio-inline"> <form:radiobutton
									path="enabled" value="0" />No
						</label></td>
					</tr>
					<tr>
						<td class="lable-title">Role</td>
						<td class="flied-title"><label class="radio-inline">
								<form:radiobutton path="tdmUserAuthDTO.role" value="ROLE_ADMIN"
									checked="true" />Admin
						</label> <label class="radio-inline"> <form:radiobutton
									path="tdmUserAuthDTO.role" value="ROLE_USER" />User
						</label></td>
					</tr>
					<tr>
						<td class="buttonsAll22"><c:if test="${userdo.userId==null || userdo.isCreated()}">
								<input type="submit" value="Add User"
									 id="submit">
							</c:if> <!-- onclick="submitUser();return false;" --></td>
						<td class="buttonsAll22"><c:if
								test="${userdo.userId!=null && userdo.isCreated() != 'true'}">
								<form:hidden path="userId" value="${userdo.userId}" />
								<input type="submit" value="Update User" id="submit">
							</c:if></td>
					</tr>
				</table>
			</form:form>
		</div>
		<script src="include/footer.js"></script>
	</div>
	<script>
		menu_highlight('admin');
		menu_highlight('admin_user_mgmt');
		menu_highlight('admin_user_mgmt_add');
	</script>

</body>
</html>