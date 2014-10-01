<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title><tiles:insertAttribute name="title" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
		<link rel="stylesheet" href="<c:url value="/resources/css/themes/default/jquery.mobile-1.4.4.min.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/css/jqm-datebox-1.4.4.min.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/css/volart.css" />">
		<script src="<c:url value="/resources/js/jquery.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.mobile-1.4.4.min.js" />"></script>
		<script src="<c:url value="/resources/js/jqm-datebox-1.4.4.comp.datebox.min.js" />"></script>
		
		<tiles:insertAttribute name="importScripts" ignore="true"/>
		
		<script type="text/javascript">	
			<tiles:insertAttribute name="otherScripts" ignore="true"/>
		</script>
	
	</head>
	<body>
		<div data-role="page">
			<tiles:insertAttribute name="header" />
			
			<!-- Main -->
			<div role="main" class="ui-content">
				<tiles:insertAttribute name="body" />
			</div><!-- End main -->

			<!-- Menu -->
			<tiles:insertAttribute name="menu" />
			<!-- End menu -->
			
			<!-- Popup rotate screen -->
			<div data-role="popup" id="popupDialog" data-overlay-theme="b" data-theme="a" data-dismissible="false" style="max-width:400px;">
		    	<img class="popphoto" src="<c:url value="/resources/images/device-rotate.png" />" style="max-height:200px;" alt="Rotate device">
		    </div><!-- End popup rotate screen -->
    
		</div>
		
	</body>
</html>