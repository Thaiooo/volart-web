<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
	Volart
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<h1>403 - Access is denied</h1>
		<h2>${msg}</h2>
	</tiles:putAttribute>
</tiles:insertDefinition>