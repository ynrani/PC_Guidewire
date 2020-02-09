<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
  <title>TDG</title>  

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
	  
  
</head>

<body>
<div class="mainAll">

<script src="include/loginHeader.js"></script>
<section class="bodySec">
	<div class="login-bg2">
    		<div id="container_demo" >
                    <div id="wrapper">
                        <div id="login" class="animate form"> 
                        	<div align="center" style="color:#886EFE">  
							    <% if(request.getParameter("auth")!=null && request.getParameter("auth").equals("fail")){
								    	out.println("Invalid Username or Password");
								 }		
								  else if(request.getParameter("logout")!=null && request.getParameter("logout").equals("true")){
										out.println("Logout Successfully");
								 }
								  else if(request.getParameter("session")!=null && request.getParameter("session").equals("expired")){
										out.println("Session Expired");
								 }else if(request.getParameter("session")!=null && request.getParameter("session").equals("alreadyLogged")){
										out.println("User Already Logged In");
								 }
								%>
								<b style="font-size: 11px;color: #ED2121;padding: 4% 0% 0% 0%;">
									${msg}
								</b>
						    </div>	
                            <form:form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/tesdaLogin" method="post" autocomplete="on"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Username </label>
                                    <input id="userid" name="userid" required="required" type="text" placeholder="User ID"  class="fontClass"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="Password" class="fontClass"/> 
                                </p>
                               <!--  <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Project Name/Id </label>
                                    <input id="projectId" name="projectId" required="required" type="text" placeholder="12345 / TDMCentral"  class="fontClass"/> 
                                </p> -->
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                 
                            </form:form>
                        </div>
                    </div>
                </div>  
   
   	 
    <div class="clearfloat">&nbsp;</div>
  </div>
 
</section>
 <script src="include/footer.js"></script>
 </div>
<script type="text/javascript"> 

 loginValidation();
  
 window.history.forward();
	function noBack()
	{
		window.history.forward();
	}
	
	
	$(function() { 
		$('[placeholder]').focus(function() { 
		  var input = $(this); 
		  if (input.val() == input.attr('placeholder')) { 
		    input.val(''); 
		    input.removeClass('placeholder'); 
		  } 
		}).blur(function() { 
		  var input = $(this); 
		  if (input.val() == '' || input.val() == input.attr('placeholder')) { 
		    input.addClass('placeholder'); 
		    input.val(input.attr('placeholder')); 
		  } 
		}).blur().parents('form').submit(function() { 
		  $(this).find('[placeholder]').each(function() { 
		    var input = $(this); 
		    if (input.val() == input.attr('placeholder')) { 
		      input.val(''); 
		    } 
		  }) 
		}); 
		});
 
 
</script>
</body>
</html>
