<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
 
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
	Volart
	</tiles:putAttribute>

    <tiles:putAttribute name="body">
    	<div class="center-div">
		    <form method="POST" name='loginForm' action="<c:url value='j_spring_security_check' />" data-ajax="false" >
		    	<h3>Please sign in</h3>
		    	
		    	<c:if test="${!empty error}">
		    		<h4 class="warning-message">Invalid username and password.</h4>
		    	</c:if>
		    	
		        <label for="un" class="ui-hidden-accessible">Username:</label>
		        <input type="text" name="j_username" id="un" value="" placeholder="username" data-theme="a">
		        <label for="pw" class="ui-hidden-accessible">Password:</label>
		        <input type="password" name="j_password" id="pw" value="" placeholder="password" data-theme="a">
		        <input type="submit" value="Sign in" data-role="button" data-theme="b"/>
		    </form>
		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>
