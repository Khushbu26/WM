<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<section id="subscribe" class="grey_section">
        <div class="container">
            <div class="row">
                <div class="blocksubscribe">
                    <div class="col-sm-6 topic">
                        <i class="rt-icon-mail"></i>
                        <h3>Subscribe to our Newsletter</h3>
                    </div>
                    <div class="col-sm-6">
                       <!--  <form  action="/" method="get"> -->
                        <form id="signup" action="<%=request.getContextPath()%>/UEmailController"
						Class="contact-form" method="post">
                            <div class="form-group">
                                <input name="email" id="mailchimp_email" type="email" class="form-control" placeholder="Enter your email address">
                            </div>
                            <input type="hidden" name="flag" value="insert">
                            <button type="submit" class="theme_btn2">Subscribe</button>
                            <div id="response"></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>