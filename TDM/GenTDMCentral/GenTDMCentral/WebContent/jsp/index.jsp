<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!doctype html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>TDM Central | Index</title>
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
<link rel="stylesheet" type="text/css" href="css/magnific-popup.css">

<script type="text/javascript" src="js/html5.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/jquery.magnific-popup.js"></script>
<script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>


</head>
<body>

	<div class="mainAll">

		<jsp:include page="indexHeader.jsp"></jsp:include>
		<section class="bodySec">
			<div class="container tdm-central">

				<jsp:include page="dataConslide.jsp"></jsp:include>

			</div>
		 
		<br /> <br />
		 
	
			<div class="edms_se1 edms_se2">
				<div class="freedownloadbox">
					<dt class="frico8 icon_background"></dt>
					<h1>White Paper</h1>
					<p class="freedownloadtxt">This paper discusses the (TDM) service and 
						provides...</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<div class="edms_boxlnk">
						<a
							href="javascript:void(0)"
							title="Extending Information Security to Non Production Environments"><span
							class="learn"
							onclick="popup('./tdmWhitePaper','White Paper','popup','popupOverlay','750');"	>
							Learn More</span><span class="arrow_More"></span></a>
					</div>
					<div class="cl"></div>
					<p></p>
				</div>
			</div>
			<div class="edms_se1 edms_se3">
				<div class="freedownloadbox">
					<dt class="frico9 icon_background"></dt>
					<h1>Success Story</h1>
					<p class="freedownloadtxt">Check how Capgemini partnered to help a
						A large bank in UK company to 
						find...</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<div class="edms_boxlnk">
						<a
							href="./tdmSuccessStory"
							title="Implementing an archiving and data subsetting project for Arqiva"><span
							class="learn">Learn More</span><span class="arrow_More"></span></a>
					</div>
					<div class="cl"></div>
					<p></p>
				</div>
			</div>
			<div class="edms_se1">
				<div class="freedownloadbox">
					<dt class="frico10 icon_background"></dt>
					<h1>On-Demand Webinar</h1>
					<p class="freedownloadtxt">How Capgemini improved business
						agility with a test data management solution</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<div class="edms_boxlnk">
						<a href="javascript:void(0)" class="watch_webinar"
							title="Case Study How Duke Energy significantly improved business agility by implementing a Test Data Management Strategy"><span
							class="learn"
							onclick="popup('./tdmOnDemondWebnair','Demo Video','popup','popupOverlay','570');"
							>Watch Now</span><span class="arrow_More"></span></a>
					</div>
					<div class="cl"></div>
					<p></p>
				</div>
			</div>

		</section>


		<section>
			<script src="include/footer.js"></script>
		</section>
	</div>
	
	<!-- <script src="include/copyrtfooter.js"></script> -->
	
	<script>
		//menu_highlight('tdm_life_cycle1');
	</script>

</body>
</html>
