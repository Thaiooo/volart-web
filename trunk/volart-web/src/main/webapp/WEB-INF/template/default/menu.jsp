<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<!-- menupanel -->
	<div data-role="panel" id="menupanel" data-display="overlay">
	
		<c:set scope="page" var="pos" value='<%=session.getAttribute("POSITION")%>' />
		<c:set scope="page" var="ptf" value='<%=session.getAttribute("PTF")%>' />
		
		<ul data-role="listview" data-divider-theme="a">
			<li data-icon="power" data-theme="b" >
				<a href="<c:url value="/j_spring_security_logout" />" rel="external">Logout</a>
			</li>
			<li data-role="list-divider">Portfolio</li>
			<c:choose>
				<c:when test="${ pos  == 'ptf' && ptf  == 'Offensive Overlay' }">
					<c:set scope="page" var="classSelected" value="b" />
				</c:when>
				<c:otherwise>
					<c:set scope="page" var="classSelected" value="a" />
				</c:otherwise>
			</c:choose>
			<li data-theme='<c:out value="${classSelected}" />'>
				<a href="<c:url value="/portfolio/Offensive Overlay"/>" rel="external">Offensive Overlay</a>
			</li>
			<c:choose>
				<c:when test="${ pos  == 'ptf' && ptf  == 'Short Bias GS' }">
					<c:set scope="page" var="classSelected" value="b" />
				</c:when>
				<c:otherwise>
					<c:set scope="page" var="classSelected" value="a" />
				</c:otherwise>
			</c:choose>
			<li data-theme='<c:out value="${classSelected}" />'>
				<a href="<c:url value="/portfolio/Short Bias GS"/>" rel="external">Short Bias GS</a>
			</li>
			<li data-role="list-divider">Risk</li>
			<c:choose>
				<c:when test="${ pos  == 'risk' && ptf  == 'Offensive Overlay' }">
					<c:set scope="page" var="classSelected" value="b" />
				</c:when>
				<c:otherwise>
					<c:set scope="page" var="classSelected" value="a" />
				</c:otherwise>
			</c:choose>
			<li data-theme='<c:out value="${classSelected}" />'>
				<a href="<c:url value="/risk/Offensive Overlay"/>" rel="external">Offensive Overlay</a>
			</li>
			<c:choose>
				<c:when test="${ pos  == 'risk' && ptf  == 'Short Bias GS' }">
					<c:set scope="page" var="classSelected" value="b" />
				</c:when>
				<c:otherwise>
					<c:set scope="page" var="classSelected" value="a" />
				</c:otherwise>
			</c:choose>
			<li data-theme='<c:out value="${classSelected}" />'>
				<a href="<c:url value="/risk/Short Bias GS"/>" rel="external">Short Bias GS</a>
			</li>
			<li data-role="list-divider">Indicator</li>
			<c:choose>
				<c:when test="${ pos  == 'indicator' }">
					<c:set scope="page" var="classSelected" value="b" />
				</c:when>
				<c:otherwise>
					<c:set scope="page" var="classSelected" value="a" />
				</c:otherwise>
			</c:choose>
			<li data-theme='<c:out value="${classSelected}" />'>
				<a href="<c:url value="/indicator"/>" rel="external">DStat, Relative Value, Beta Target</a>
			</li>
		</ul>
	</div>
	<!-- End menupanel -->

</sec:authorize>