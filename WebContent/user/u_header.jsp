<header id="header" class="light_section">

        <div class="container">
        
            <div class="row">
           
                <a class="navbar-brand" href="u_index.jsp"><img src="example/logo.png" alt=""></a>
                <div class="col-sm-12 mainmenu_wrap">
              
                    <div class="main-menu-icon visible-xs">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    
                    <nav>
                    
                        <ul id="mainmenu" class="menu sf-menu responsive-menu superfish">
                            <li class="active">
                                <a href="u_index.jsp">Home</a>
                            </li>
                            <li class="">
                                <a href="about_us.jsp">About</a>
                            </li>
                            
                            <!-- <li class="dropdown">                                
                                <a href="./blog.html">Blog</a>
                                <ul class="dropdown-menu">                                    
                                    <li class="">
                                        <a href="./blog.html">With Large Image</a>
                                    </li>    
                                    <li class="">
                                        <a href="./blog-2.html">With Small Image</a>
                                    </li>                                
                                    
                                </ul>
                            </li>       -->
                            <li class="dropdown">                                
                                <a href="think_green.jsp">Think Green</a>
                                
                            </li>  
                            <li class="">
                                <a href="#">Customer Services</a>
                                 <ul class="dropdown-menu"> 
                                 	<li class="">
                                        <a href="<%=request.getContextPath()%>/WasteInfoController?flag=load">Post Waste Information</a>
                                    </li> 
                                    <li class="">
                                        <a href="<%=request.getContextPath()%>/UScheduleController?flag=load">Check Schedule</a>
                                    </li> 
                                   <!--  <li class="">
                                        <a href="./blog.html"> Request For Garbage Allocation </a>
                                    </li> -->
                                    <li class="">
                                       <a href="./track_dustbin.jsp">
												Track Dustbin</a>
                                    </li>                                            
                                    <li class="">
                                        <a href="<%=request.getContextPath()%>/UComplaintController?flag=load">Complaint</a>
                                    </li> 
                                    <li class="">
                                        <a href="./blog.html">Progress Line</a>
                                    </li>       
                                     <li class="">
                                        <a href="./blog-2.html"> FAQ </a>
                                    </li>                              
                                    
                                </ul>
                             </li>                       
                            <li class="">
                                <a href="../admin/login.jsp">Login</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </header>