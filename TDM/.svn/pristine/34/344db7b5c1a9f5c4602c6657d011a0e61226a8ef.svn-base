<section class="headerDiv">
	<header>
		<section class="top-blue-nav">
			<div class="primary-nav">
				<nav>
					<ul>
						<li><a href="./index"><img src="images/home-icon.png" width="20" height="20" alt="" /> Home</a></li>
						<li><a href="http://www.capgemini.com/about-capgemini" TARGET="_NEW"><img src="images/about-icon.png" width="20" height="20" alt="" /> About Us</a></li>
						<li><a href="http://www.in.capgemini.com/contact-capgemini" TARGET="_NEW"><img src="images/contact-icon.png" width="20" height="20" alt="" /> Contact Us</a></li>
						<li><a href="./logout?logout=true"><img src="images/logout-icon.png" width="20" height="20" alt="" />Logout</a></li>
					</ul>
				</nav>
			</div>
			<div class="welcome">
				<h5>
					Welcome
					<%
					out.println((String) session.getAttribute("UserId"));
				%>
				</h5>
			</div>
		</section>
		<section class="navigation">
			<div class="logo">
				<img src="images/csa.jpg" class="logo" alt="" />
				<!-- <img src="images/logo-cap.jpg" class="logo" alt="" /> -->
			</div>	
			<div class="main-nav">
				<nav>
					<ul>
						<li id="tdm_governance"><a id="tdm_governance1" href="#">TDM Governance</a></li>
						<li id="tdm_life_cycle"><a id="tdm_life_cycle1" href="./index" class="active">TDM Life Cycle</a></li>
						<li id="tdm_command_center"><a id="tdm_command_center1" href="#">Command Center</a></li>
						<li id="tdm_training"><a id="tdm_training1" href="#">Training</a></li>
					</ul>
				</nav>
			</div>
		</section>
		<section class="title-band">
			<div class="title">
				<h3 class="h3Tdm">TDM Central</h3>
			</div>
			<div class="advanced-search"><a href="./myReservationProp">My Reservations</a></div>
			<div class="quicklink-container">
				<div class="quicklink-sh">
					<a href="#">Quick Link</a>
				</div>
				<div class="quicklink-list">
					<ul>
						<!-- <li><a href="./policyProp">Data Finder</a></li> -->
						<li><a href="./policyProp" class="refresh"><label>Refresh</label></a></li>
					</ul>
				</div>
			</div>
		</section>
	</header>
</section>
<script>

$('.refresh').click(function (event){ 
    event.preventDefault(); 
    $.ajax({
       url: './policyRefresh',
       success: function(response) {
    	   console.log(response);
    	   if(response == 'false'){
           alert('Refresh failed');
    	   }else{
    		   alert('Refresh Successfully completed');
    	   }
       }
    })
    return false; //for good measure
});
</script>