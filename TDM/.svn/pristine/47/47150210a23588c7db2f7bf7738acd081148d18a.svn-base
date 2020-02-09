<%@page import="com.tdm.constant.AppConstant"%>
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
					out.println((String) session.getAttribute("UserName"));
				%>
				</h5>
			</div>
		</section>
		<section class="navigation">
			<div class="logo">
				<img src="images/logo-cap.jpg" width="197" height="47" class="logo" alt="" />
			</div>	
			<div class="main-nav">
				<div id="cssmenu">
					<ul>
					
						<li id="admin"><a href="#" >Admin</a>
							<ul>
								
								<li id="admin_user_mgmt"><a href="#" >User Management</a>
									<ul>
										<li id="admin_user_mgmt_add"><a href="./tesdaCreateNewUser">Add Users</a></li>
										<li id="admin_user_mgmt_modify"><a href="./testdaAdmin">Modify/Remove Users</a></li>
									</ul>
								</li>
								
								<li id="admin_cfg_mgmt"><a href="#" >Application Configuration Management</a>
								<ul>
										<li id="admin_cfg_mgmt_dash"><a href="#">Dash boarding</a></li>
									</ul>
								 </li>
								 
							</ul>
						</li>
					
						<li id="services"><a href="#" >Services</a>
							<ul>
								<li id="services_mask"><a href="./tdmRequest">Create Request</a></li>
								<li id="services_chng"><a href="./tdmSearchRequestList">Edit/Cancel Request</a></li>
								<li id="services_Search"><a href="./tdmSearchRequest">Search Request</a></li>
							</ul>
						</li>
						
					</ul>
				</div>
			</div>
		</section>
		<section class="title-band">
			<div class="title">
				<h3 class="h3Tdm">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>
			</div>
		</section>
	</header>
</section>