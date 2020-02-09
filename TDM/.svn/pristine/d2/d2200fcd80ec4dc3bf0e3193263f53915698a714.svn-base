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
				<img src="images/logo-cap.jpg" class="logo" alt="" />
			</div>	
			<div class="main-nav">
				<div id="cssmenu">
					<ul>
					
						<li id="admin"><a href="#" >Admin</a>
							<ul>
								<%
									if(request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_TDMADMIN)){
								%>
								<li id="admin_user_mgmt"><a href="#" >User Management</a>
									<ul>
										<li id="admin_user_mgmt_add"><a href="./tesdaCreateNewUser">Add Users</a></li>
										<li id="admin_user_mgmt_modify"><a href="./testdaAdmin">Modify/Remove Users</a></li>
									</ul>
								</li>
								<% } %>
								<%
									if(!request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_USER)){
								%>
								<li id="admin_cfg_mgmt"><a href="#" >Application Configuration Management</a>
								<ul>
										<li id="admin_cfg_mgmt_sensi"><a href="#">Sensitivity Profiler</a></li>
										<li id="admin_cfg_mgmt_sub"><a href="#">Data Sub setting</a></li>
										<li id="admin_cfg_mgmt_dmass"><a href="#">DMASSK</a></li>
										<li id="admin_cfg_mgmt_tdg"><a href="#">TDG</a></li>
										<li id="admin_cfg_mgmt_ftd"><a href="#">Find Test Data</a></li>
										<li id="admin_cfg_mgmt_ref"><a href="#">Data Refresh</a></li>
										<li id="admin_cfg_mgmt_dash"><a href="./tdmDtMaskDashboard">Dash boarding</a></li>
									</ul>
								 </li>
								 <%  } %>
							</ul>
						</li>
					
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
								<%
								if(!request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_USER)){
								%>
								<li id="services_sensi"><a href="http://in-pnq-bid01/DMASSK/" TARGET="_NEW">Sensitivity Profiler</a></li>
								<li id="services_sub"><a href="./tdmDataMaskingNew?reqType=SS">Data Sub Setting</a></li>
								<li id="services_mask"><a href="./tdmDataMaskingNew?reqType=MR">Data Masking</a></li>
								<li id="services_ref"><a href="./tdmDataMaskingNew?reqType=DR">Data Refresh</a></li>
								<li id="services_onb"><a href="./tdmOnboardReq">On Boarding Request</a></li>
								<li id="services_chng"><a href="./tdmChangeReqExt">Change Request</a></li>
								<% } %>
								<li id="services_ftd"><a href="#">Find Test Data</a>
									<ul>
										<li id="services_ftd_insu"><a href="#">Insurance Domain</a>
											<ul>
												<li id="services_ftd_insu_health"><a href="./testdaUser">Health Care</a></li>
												<li id="services_ftd_insu_pc"><a href="./policyProp">Property, Auto and Life</a></li>
											</ul>	
										</li>
										<li id="services_ftd_bank"><a href="./testdaAccount">Banking Domain</a></li>
									</ul>
								</li>
								<%
								if(!request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_USER)){
								%>
								<li id="services_tdg"><a href="http://in-pnq-coe12:8080/TDG/" TARGET="_NEW">TDG</a></li>
								<li id="services_tdg"><a href="http://in-pnq-coe12:8080/DataConditioner/" TARGET="_NEW">DataConditioner</a></li>
								<li id="services_dash"><a href="./tdmDtMaskDashboard">Dash boarding</a></li>
								<% } %>
							</ul>
						</li>
						<li id="rep"><a href="#" >Report</a>
							 <ul>
							  <%
								if(!request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_USER) || request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_TDMUSER)){
							  %>
								<li id="rep_matric"><a href="#">Metrics</a></li>
							  <% } %>
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
						<li><a href="#" >Quick Link</a>
							<ul>
								<%
								if(!request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_USER) || request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_TDMUSER)){
								%>
								<li><a href="http://in-pnq-bid01/DMASSK/" TARGET="_NEW">Sensitivity Profiler</a></li>
								<li><a href="./tdmDataMaskingNew?reqType=SS">Data Sub Setting</a></li>
								<li><a href="./tdmDataMaskingNew?reqType=MR">Data Masking</a></li>
								<% } %>
								<li><a href="./testdaUser">Data Finder</a></li>
								<%
								if(!request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_USER) || request.getSession().getAttribute(AppConstant.ROLE).equals(AppConstant.ROLE_TDMUSER)){
								%>
								<li><a href="http://in-pnq-coe12:8080/TDG/" TARGET="_NEW">TDG</a></li>
								<li id="services_tdg"><a href="http://in-pnq-coe12:8080/DataConditioner/" TARGET="_NEW">DataConditioner</a></li>
								<li><a	href="http://in-pnq-coe05/qlikview/FormLogin.htm?opendocqs=%3Fdocument%3DTDM%2520Dashboard%2520V1.qvw%26host%3DQVS%2540in-pnq-coe05"
							TARGET="_NEW">Live</a></li>
								<% } %>
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