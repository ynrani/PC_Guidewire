<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central</title>  
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" >
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/custom.css">
  <link href="css/theme.default.css" rel="stylesheet">
  <script src="js/html5Shiv.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/main.js"></script>
  <script src="js/jquery.validate.min.js" type="text/javascript" ></script>  
  <script src="js/messages.js"></script>
  
  <script src="js/common.js"></script>
  <script src="js/jquery.popupwindow.js"></script>
  <script src="js/jquery-migrate-1.2.1.min.js"></script>
</head>

<body>
<div class="mainAll">

<script src="include/loginHeader.js"></script>
<section class="bodySec">
<div class="login-bg2">
  <div class="container">
    <div class="login-container">
      <div class="top-blue-line"></div>
      <img src="${pageContext.request.contextPath}/images/login-icon.png" style="width: 35%; height: auto;"/>
      <h2>Login</h2>      
	      <div align="center">  
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
	   <form:form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/tesdaLogin" method="post">
	     
					<input type="text" value="" placeholder="User ID" name="userid" class="inputText">
			
					<input type="password" value="" placeholder="Password" name="password" class="inputText">
				
					<input type="text"  id="projectId" name="projectId" placeholder="Project ID" class="inputText">
				
					<input type="checkbox" value="" checked> <label>Remember Me</label>
				
					<a href="javascript:;" class="forgot-password" onclick="popupuser('./loginforgotPassword','Forgot Password','popup','popupOverlay','300');"><label>Forgot password?</label></a>
				
					<input type="submit" value="Login" name="submit" id="submit" class="btn-primarylog btn-celllog">
				
			  
      </form:form>          
     </div>
    <div class="clearfloat">&nbsp;</div>
  </div>
  
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
