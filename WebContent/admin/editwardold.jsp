<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html><html><head><meta charset="utf-8"><meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" /><meta name="apple-mobile-web-app-capable" content="yes" /><meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" /><title>FLAT - Basic forms</title> <link rel="stylesheet" href="css/bootstrap.min.css"><link rel="stylesheet" href="css/jquery-ui.min.css"><link rel="stylesheet" href="css/style.css"><link rel="stylesheet" href="css/themes.css"><script src="js/jquery.min.js"></script> <!--//--><script src="js/jquery.nicescroll.min.js"></script> <!--//--><script src="js/jquery.imagesloaded.min.js"></script> <!--//--><script src="js/jquery-ui.js"></script> <!--//--><script src="js/jquery.touch-punch.min.js"></script> <!--//--><script src="js/jquery.slimscroll.min.js"></script> <!--//--><script src="js/bootstrap.min.js"></script> <!--//--><script src="js/jquery.bootbox.js"></script> <!--//--><script src="js/eakroko.min.js"></script> <!--//--><script src="js/application.min.js"></script> <!--//--><script src="js/demonstration.min.js"></script> <!--[if lte IE 9]><script src="js/jquery.placeholder.min.js"></script> <script>
			$(document).ready(function() {
				$('input, textarea').placeholder();
			});
		</script> <![endif]--><!--//--><link rel="shortcut icon" href="img/favicon.ico" /><link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-precomposed.png" /></head><body><jsp:include page="navigation.jsp"></jsp:include>
	<div class="container-fluid" id="content">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="main">
			<div class="container-fluid">
				
				
				
				<div class="row">
					<div class="col-sm-12">
						<div class="box box-bordered box-color">
							<div class="box-title">
								<h3>
									<i class="fa fa-th-list"></i>Manage Ward</h3>
							</div>
							<div class="box-content nopadding">
							<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>					
						<c:forEach items="${sessionScope.editward }" var="y">
								<form action="<%=request.getContextPath()%>/Ward_Controller" method="POST" class='form-horizontal form-bordered'>
									<div class="form-group">
										<label for="textfield" class="control-label col-sm-2">Zone Name</label>
										<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
										<div class="col-sm-10">
										<select name="zone_id" id="bbb" data-rule-required="true" class="form-control">
												<c:forEach items="${sessionScope.zone }" var="x">
													<c:if test="${y.mc.zoneId eq x.zoneId}">
												<option selected value="${x.zoneId}"  selected="selected">${x.zoneName }</option>
												</c:if>
												
												<c:if test="${y.mc.zoneId ne x.zoneId}">
												<option value="${x.zoneId }">${x.zoneName }</option>
												</c:if>
											
												</c:forEach>
											</select>
											
										</div>
									</div>
									<div class="form-group">
										<label for="textfield" class="control-label col-sm-2">Add Ward</label>
										<div class="col-sm-10">
											<input type="text" name="ward" id="textfield" placeholder="Text input" class="form-control" value="${y.wardName}">
										</div>
									</div>
									
									
									<div class="form-group">
										<label for="textarea" class="control-label col-sm-2">Ward Description</label>
										<div class="col-sm-10">
											<textarea name="ward_des" id="textarea" rows="5" placeholder="Write Your Text Here..." class="form-control">${y.wardDes}</textarea>
										</div>
									</div>
										<input type="hidden" name="id" value="${y.wardId}">
										<input type="hidden" name="flag" value="update">
									<div class="form-actions col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-primary">Submit</button>
										<button type="button" class="btn">Cancel</button>
									</div>
								</form>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				
				
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push(['_setAccount', 'UA-38620714-4']);
	_gaq.push(['_trackPageview']);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
	</script>
</body>

</html>