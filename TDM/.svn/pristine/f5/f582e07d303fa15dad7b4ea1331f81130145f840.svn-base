<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>TDM Central | Dash Board</title>
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
	
	<!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css"> -->
    
    <script type="text/javascript" src="js/jquery.knob.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
  
<body>
  <div class="mainAll">
 <jsp:include page="indexHeader.jsp"></jsp:include>
   
 <div class="container">
     
      <h2 style="color: #0098cc;font-size: 14px; padding: 4% 0% 0% 0%;">DashBoarding</h2>
      <hr>
      
      <div class="two-col">
       
       
       <!--Masking Request -->

	    <div class="panel panel-default">
	        <a href="#page-stats" class="panel-heading" data-toggle="collapse">Masking Request</a>
	        <div id="page-stats" class="panel-collapse panel-body collapse in">
	
	                    <div class="row">
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="1000" data-displayPrevious="true" value="250" data-fgColor="#7092D0" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Submitted</h3>
	                            </div>
	                        </div>
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="500" data-displayPrevious="true" value="99" data-fgColor="#DAC62A" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Pending</h3>
	                            </div>
	                        </div>
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="200" data-displayPrevious="true" value="40" data-fgColor="#39AF6F" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Completed</h3>
	                            </div>
	                        </div>
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="500" data-displayPrevious="true" value="59" data-fgColor="#A04949" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Cancelled</h3>
	                            </div>
	                        </div>
	                    </div>
	        </div>
	    </div>
 
 
	<!--Data Refresh Request -->

	    <div class="panel panel-default">
	        <a href="#page-stats2" class="panel-heading" data-toggle="collapse">Data Refresh Request</a>
	        <div id="page-stats2" class="panel-collapse panel-body collapse in">
	
	                   <div class="row">
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="1000" data-displayPrevious="true" value="250" data-fgColor="#7092D0" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Submitted</h3>
	                            </div>
	                        </div>
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="500" data-displayPrevious="true" value="99" data-fgColor="#DAC62A" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Pending</h3>
	                            </div>
	                        </div>
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="200" data-displayPrevious="true" value="40" data-fgColor="#39AF6F" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Completed</h3>
	                            </div>
	                        </div>
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="500" data-displayPrevious="true" value="59" data-fgColor="#A04949" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Cancelled</h3>
	                            </div>
	                        </div>
	                    </div>
	        </div>
	    </div>
	
	
		<!--On boarding Request -->
	
	    <div class="panel panel-default">
	        <a href="#page-stats3" class="panel-heading" data-toggle="collapse">On boarding Request</a>
	        <div id="page-stats3" class="panel-collapse panel-body collapse in">
	
	                   <div class="row">
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="1000" data-displayPrevious="true" value="250" data-fgColor="#7092D0" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Submitted</h3>
	                            </div>
	                        </div>
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="500" data-displayPrevious="true" value="99" data-fgColor="#DAC62A" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Pending</h3>
	                            </div>
	                        </div>
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="200" data-displayPrevious="true" value="40" data-fgColor="#39AF6F" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Completed</h3>
	                            </div>
	                        </div>
	                        <div class="col-md-3 col-sm-6">
	                            <div class="knob-container">
	                                <input class="knob" data-width="180" data-min="0" data-max="500" data-displayPrevious="true" value="59" data-fgColor="#A04949" data-readOnly=true;>
	                                <h3 class="text-muted text-center">Cancelled</h3>
	                            </div>
	                        </div>
	                    </div>
	        </div>
	    </div>
	       
       
                 
      </div>       
  </div>
</div> 
 
<script>

menu_highlight('services');
menu_highlight('services_dash');

$(function() {
    $(".knob").knob();
});

 
</script>
</body>
</html>
