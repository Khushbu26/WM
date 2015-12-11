<aside id="sidebar-left" class="sidebar-left">
				
					<div class="sidebar-header">
						<div class="sidebar-title">
							Navigation
						</div>
						<div class="sidebar-toggle hidden-xs" data-toggle-class="sidebar-left-collapsed" data-target="html" data-fire-event="sidebar-left-toggle">
							<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
						</div>
					</div>
				
					<div class="nano">
						<div class="nano-content">
							<nav id="menu" class="nav-main" role="navigation">
								<ul class="nav nav-main">
									<li class="nav-active">
										<a href="index.html">
											<i class="fa fa-home" aria-hidden="true"></i>
											<span>Dashboard</span>
										</a>
									</li>
									<li>
										<a href="mailbox-folder.html">
											<span class="pull-right label label-primary">182</span>
											<i class="fa fa-envelope" aria-hidden="true"></i>
											<span>Mailbox</span>
										</a>
									</li>
									<li class="nav-parent">
										<a>
											<i class="fa fa-list-alt" aria-hidden="true"></i>
											<span>Company Registration</span>
										</a>
										<ul class="nav nav-children">
											<li>
												<a href="form.jsp">
													 View Company
												</a>
											</li>
											
										</ul>
									</li>
									<li class="nav-parent">
										<a>
											<i class="fa fa-user" aria-hidden="true"></i>
											<span>Manage Staff</span>
										</a>
										<ul class="nav nav-children">
											<li>
												<a href="c_staffReg.jsp">
													  Add Staff
												</a>
											</li>
											<li>
												<a href="<%=request.getContextPath()%>/CStaffRegController?flag=search">
													  Search Staff
												</a>
											</li>
											
										</ul>
									</li>
									<li class="nav-parent">
										<a>
											<i class="fa fa-map-marker" aria-hidden="true"></i>
											<span>Manage Assign Area</span>
										</a>
										<ul class="nav nav-children">
											<li>
												<a href="<%=request.getContextPath()%>/CAssignAreaController?flag=load">
													 Assign Area to Staff
												</a>
											</li>
											<li>
												<a href="<%=request.getContextPath()%>/CAssignAreaController?flag=search">
													Search Located Area
												</a>
											</li>
											
										</ul>
									</li><!-- <li class="nav-parent">
										<a>
											<i class="fa fa-list-alt" aria-hidden="true"></i>
											<span>Manage Complaint</span>
										</a>
										<ul class="nav nav-children">
											<li>
												<a href="c_view_complaint.jsp">
													 View Complaint
												</a>
											</li>
											
										</ul>
									</li> -->
									<li class="nav-parent">
										<a>
											<i class="fa fa-comments" aria-hidden="true"></i>
											<span>Notification</span>
										</a>
										<ul class="nav nav-children">
											<li>
												<a href="add_notification.jsp">
													Generate Notification
												</a>
											</li>
											<li>
												<a href="search_notification.jsp">
													View Notification
												</a>
											</li>
											
										</ul>
									</li>
									</ul>
									</nav>
									
									
							
				
							
				
							<div class="sidebar-widget widget-tasks">
								
							</div>
				
							<hr class="separator" />
				
							
						</div>
				
					</div>
				
				</aside>
