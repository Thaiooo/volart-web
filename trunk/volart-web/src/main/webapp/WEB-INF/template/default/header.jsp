<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- Header -->
<div data-role="header" data-theme="b" data-position="fixed">
	<sec:authorize access="isAuthenticated()">
		<a href="#menupanel" class="ui-btn-left ui-btn ui-btn-inline ui-mini ui-corner-all ui-btn-icon-left ui-icon-bars">Menu</a>
		<a href="#" data-icon="gear" class="ui-btn-right">Options</a>
	</sec:authorize>
	<span class="ui-title"><img alt="Volart" src="<c:url value='/resources/images/logo.png' />" ></span>
</div>
<!-- End header -->
