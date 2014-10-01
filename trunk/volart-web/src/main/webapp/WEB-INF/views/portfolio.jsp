<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
 
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
	Indicator
	</tiles:putAttribute>

	<tiles:putAttribute name="otherScripts">
		$( window ).resize(function() {
			var width = $( window ).width();
			console.log(width);
			if(width < 490){
				setTimeout(function() { $( "#popupDialog" ).popup( "open" ) }, 100 );
			}else{
				setTimeout(function() { $( "#popupDialog" ).popup( "close" ) }, 100 );
			}
		});
		
		$( document ).on( "pageinit", function() {
			var width = $( window ).width();
			console.log(width);
			if(width < 490){
				console.log('Open');
				setTimeout(function() { $( "#popupDialog" ).popup( "open" ) }, 100 );
			}
		});
	</tiles:putAttribute>
	
    <tiles:putAttribute name="body">
    	<!-- Fund Name -->    
		<div id="volartHeader" class="ui-grid-b">
			<div class="ui-block-a partCoin" ><strong>Asset:</strong> <fmt:formatNumber type="number" maxFractionDigits="3" value="${ptf.asset}" /></div>
			<div class="ui-block-b"><h3 align="center">Portfolio: ${ptf.fund.name}</h3>	</div>
			<div class="ui-block-c partCoinRight" align="right">
				<div class="dateInput" >
					<input type="text" data-role="datebox" value="<fmt:formatDate value="${ptf.date}" pattern="dd/MM/yyyy"/>" data-options='{"mode":"datebox", "overrideDateFormat":"%0d/%m/%Y"}'>
				</div>
			</div>
		</div><!-- /Fund Name -->
		
		
		
		<!-- Indicator -->		
		<div class="ptf-indicator">
			<div class="ui-block-a"><div class="ui-body ui-body-d"><strong>P&L: </strong><fmt:formatNumber minFractionDigits="2" value="${ptf.pnlD}" type="percent"/></div></div>
			<div class="ui-block-b"><div class="ui-body ui-body-d"><strong>P&L D-1: </strong><fmt:formatNumber minFractionDigits="2" value="${ptf.pnlD1}" type="percent"/></div></div>
			<div class="ui-block-c"><div class="ui-body ui-body-d"><strong>P&L Mtd: </strong><fmt:formatNumber minFractionDigits="2" value="${ptf.pnlMtD}" type="percent"/></div></div>
			<div class="ui-block-d"><div class="ui-body ui-body-d"><strong>P&L Mtd D-1: </strong><fmt:formatNumber minFractionDigits="2" value="${ptf.pnlMtDD1}" type="percent"/></div></div>
			<div class="ui-block-e"><div class="ui-body ui-body-d"><strong>Delta: </strong><fmt:formatNumber minFractionDigits="2" value="${ptf.delta}" type="percent"/></div></div>
			<div class="ui-block-f"><div class="ui-body ui-body-d"><strong>Vega: </strong><fmt:formatNumber minFractionDigits="2" value="${ptf.vega}" type="percent"/></div></div>
			<div class="ui-block-g"><div class="ui-body ui-body-d"><strong>Theta: </strong><fmt:formatNumber minFractionDigits="2" value="${ptf.theta}" type="percent"/></div></div>
			<div class="ui-block-h"><div class="ui-body ui-body-d"><strong>Inv. Prem.: </strong><fmt:formatNumber minFractionDigits="2" value="${ptf.invPrem}" type="percent"/></div></div>
		</div><!-- /Indicator -->
		
		
		
		<%--  
		<!-- Portfolio Table -->
    	<table id="ptf" class="ui-body-d ui-shadow table-stripe ui-responsive volart-table" id="table-custom-2" data-role="table" data-mode="columntoggle" data-column-popup-theme="a" data-column-btn-text="Columns" data-column-btn-theme="b">
			<thead>
				<tr class="ui-bar-d">
					<c:forEach var="col" items="${ptf.ptfHeaderCols}">
						<th data-priority="${col.dataPriority}">${col.name}</th>
					</c:forEach>
				</tr>
			</thead>
			<tbody>           
				<c:forEach var="line" items="${ptf.ptfContent}">
					<tr class="level4">
						<!-- Date -->
						<th nowrap >SB2</th>
						<!-- Qt1 -->
						<th></th>
						<!-- Nav -->
						<th></th>
						<!-- Nav fnd% -->
						<th>0.00%</th>
						<!-- Qt2 -->
						<th></th>
						<!-- Inst -->
						<th></th>
						<!-- Type -->
						<th></th>
						<!-- Mat -->
						<th></th>
						<!-- Strike -->
						<th></th>
						<!-- Vol -->
						<th></th>
						<!-- Vol D-1 -->
						<th></th>
						<!-- P&L %-->
						<th></th>
						<!-- P&L Mtd % -->
						<th></th>
						<!-- P&L -->
						<th></th>
						<!-- Px -->
						<th></th>
						<!-- Px D-1 -->
						<th></th>
					</tr>
				</c:forEach>
			</tbody>
		</table><!-- /Portfolio Table -->
		--%>
		
    </tiles:putAttribute>
</tiles:insertDefinition>
