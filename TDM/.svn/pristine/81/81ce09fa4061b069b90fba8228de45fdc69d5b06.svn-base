<%@page import="com.tdm.constant.AppConstant"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
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
				<img src="images/logo-cap.jpg" class="logo" alt="" />
			</div>	
			<div class="main-nav">
				<div id="cssmenu">
					<ul>
					  <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_TDMADMIN')">
						<li id="admin"><a href="#" >Admin</a>
							<ul>
						 		 
								<li id="admin_user_mgmt"><a href="#" >User Management</a>
									<ul>
										<li id="admin_user_mgmt_add"><a href="./tesdaCreateNewUser">Add Users</a></li>
										<li id="admin_user_mgmt_modify"><a href="./testdaAdmin">Modify Users</a></li>
										<li id="admin_user_mgmt_remov"><a href="./testdaAdmin">Remove Users</a></li>
									</ul>
								</li>
								
								 
								<li id="admin_cfg_mgmt"><a href="#" >Application Configuration Management</a>
								<ul>
										<li id="admin_cfg_mgmt_sensi"><a href="#">Sensitivity Profiler</a></li>
										<li id="admin_cfg_mgmt_dmass"><a href="#">DMASSK</a></li>
										<li id="admin_cfg_mgmt_tdg"><a href="#">TDG</a></li>
										<li id="admin_cfg_mgmt_ftd"><a href="#">Find Test Data</a></li>
										<li id="admin_cfg_mgmt_dash"><a href="#">Dash boarding</a>
											<ul>
												<li id="admin_cfg_mgmt_dash_lit"><a href="./tdmDtMaskDashBoardLst">Listing Dash board</a></li>
												<li id="admin_cfg_mgmt_dash_graph"><a href="./tdmDashBoard">Graphical Dash board</a></li>			
											
											
											</ul>
										</li>
									</ul>
								 </li>
							 
							</ul>
						</li>
						</sec:authorize>
						
						<li id="gover"><a href="#" >TDM Governance</a>
							<ul>
								<li id="gover_temp"><a href="#">Templates</a></li>
								<li id="gover_manu"><a href="#">Manual/Handbook</a></li>
								<li id="gover_tool"><a href="#">Tool Guidelines</a></li>
								<li id="gover_process"><a href="./blueBookPage">Process &amp; Bluebook</a></li>
								<li id="gover_faq"><a href="#">FAQ's</a></li>
							</ul>
						</li>
						<li id="services"><a href="#" >Services</a>
							<ul>
							 
								<li id="services_sensi"><a href="http://in-pnq-coe13/SensitivityProfilerApp/" TARGET="_NEW">Sensitivity Profiler</a></li>
								<li id="services_mask"><a href="./tdmDataMaskingNew">Data Masking </a></li>
								<li id="services_onb"><a href="./tdmOnboardReq">On Boarding Request</a></li>
								<li id="services_chng"><a href="./tdmChangeReqExt">Change Request</a></li>
								<li id="services_ftd"><a href="#">Find Test Data</a>
									<ul>
										<li id="services_ftd_insu"><a href="#">Insurance Domain</a>
											<ul>
												<li id="services_ftd_insu_health"><a href="#">Health Care</a>
													<ul>
														<li id="services_ftd_insu_health_ftd"><a href="./testdaUser">FTD</a></li>
														<li id="services_ftd_insu_health_rev"><a href="./myReservationProv">Reservation</a></li>
													</ul>
												</li>
												<li id="services_ftd_insu_pc"><a href="#">Property, Auto and Life</a>
													<ul>
														<li id="services_ftd_insu_pc_ftd"><a href="./policyProp">FTD</a></li>
														<li id="services_ftd_insu_pc_rev"><a href="./myReservationProp">Reservation</a></li>
													</ul>
												</li>
											</ul>	
										</li>
										<li id="services_ftd_bank"><a href="#">Banking Domain</a>
											<ul>
												<li id="services_ftd_bank_ftd"><a href="./testdaAccount">FTD</a></li>
												<li id="services_ftd_bank_rev"><a href="./myReservationRecords">Reservation</a></li>
											</ul>
										</li>
									</ul>
								</li>
								<li id="services_tdg"><a href="http://in-pnq-coe12:8080/TDG/" TARGET="_NEW">TDG</a></li>
								<li id="services_dash"><a href="./tdmDtMaskDashboard">Dash boarding</a></li>
							 <sec:authorize access="hasAnyRole('ROLE_TDMUSER','ROLE_TDMADMIN')">
								<li id="services_dash_Admin"><a href="tdmDtMaskDashBoardAdmin">Requests Dash board</a></li>
							</sec:authorize>
							</ul>
						</li>
						<li id="rep"><a href="#" >Report</a>
							 <ul>
							  
								<li id="rep_matric"><a href="#">Metrics</a></li>
							 
								<li id="rep"><a	href="http://in-pnq-coe05/qlikview/FormLogin.htm?opendocqs=%3Fdocument%3DTDM%2520Dashboard%2520V1.qvw%26host%3DQVS%2540in-pnq-coe05"
							TARGET="_NEW">LIVE Integration</a></li>
							 </ul>
						</li>
						<li id="train"><a href="#" >Training</a>
							 <ul>
								<li id="train_lear"><a href="#">E - Learning</a></li>
								<li id="train_vid"><a href="#">Videos</a></li>
							 </ul>
						</li>
						<li id=""><a href="#" >Quick Link</a>
							<ul>
							 
								<li id=""><a href="http://in-pnq-bid01/DMASSK/" TARGET="_NEW">Sensitivity Profiler</a></li>
								<li id=""><a href="./tdmDataMaskingNew">Data Masking</a></li>
								<li id=""><a href="./testdaUser">Data Finder</a></li>
								<li id=""><a href="http://in-pnq-coe12:8080/TDG/" TARGET="_NEW">TDG</a></li>
								<li id=""><a	href="http://in-pnq-coe05/qlikview/FormLogin.htm?opendocqs=%3Fdocument%3DTDM%2520Dashboard%2520V1.qvw%26host%3DQVS%2540in-pnq-coe05"
							TARGET="_NEW">Live</a></li>
							 
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
			 <sec:authorize access="hasRole('ROLE_USER')">
			<div class="advanced-search"><a href="./myReservationProp">My Reservations</a></div>
			 </sec:authorize>
		</section>
	</header>
</section>