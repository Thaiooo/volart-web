<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
 
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
	Portfolio: ${PTF}
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
		
		$(document).ready(function(){
			$( "#ptfDate" ).change(function() {
				var objDate = $("#ptfDate").datebox('getTheDate');
				var date = $("#ptfDate").datebox('callFormat', '%0d-%m-%Y', objDate);
				var url = '<c:url value="/portfolio/${PTF}/"/>' + date;
				$(location).attr('href', url);
			});
		});
		
	</tiles:putAttribute>
	
    <tiles:putAttribute name="body">
    	<!-- Fund Name -->    
		<div id="volartHeader" class="ui-grid-b">
			<div class="ui-block-a partCoin" ><strong>Asset:</strong> <fmt:formatNumber type="number" maxFractionDigits="3" value="${ptf.asset}" /></div>
			<div class="ui-block-b"><h3 align="center">Portfolio: ${PTF}</h3>	</div>
			<div class="ui-block-c partCoinRight" align="right">
				<div class="dateInput" >
					<input id="ptfDate" 
						type="text" 
						data-role="datebox" 
						value="<fmt:formatDate value="${ptf.date}" pattern="dd/MM/yyyy"/>" 
						data-options='{"mode":"datebox", "popupPosition":"center", "overrideDateFormat":"%0d/%m/%Y", "overrideHeaderFormat":"%0d/%m/%Y", "maxYear":2014}'
					>
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
		
		<!-- Portfolio Table -->
    	<table id="ptf" class="ui-body-d ui-shadow table-stripe ui-responsive volart-table" id="table-custom-2" data-role="table" data-mode="columntoggle" data-column-popup-theme="a" data-column-btn-text="Columns" data-column-btn-theme="b">
			<thead>
				
				<tr class="ui-bar-d">
					<th data-priority="critical">Date</th>
					<th data-priority="1"><abbr title="Quantity 1">Qt1</abbr></th>			 
					<th data-priority="6">Nav</th>
					<th data-priority="6">Nav fnd%</th>
					<th data-priority="6"><abbr title="Quantity 2">Qt2</abbr></th>			
					<th data-priority="1">Instrument</th>
					<th data-priority="1">Type</th>
					<th data-priority="1">Maturity</th>
					<th data-priority="1">Strike</th>
					<th data-priority="6"><abbr title="Volatility">Vol</abbr></th>
					<th data-priority="6"><abbr title="Yesterday Volatility">Vol D-1</abbr></th>
					<th data-priority="2">P&L%</th>
					<th data-priority="6"><abbr title="P&L Month To Date %">P&L Mtd%</abbr></th>
					<th data-priority="6">P&L </th>
					<th data-priority="3"><abbr title="Price">Px</abbr></th>
					<th data-priority="6"><abbr title="Yesterday Price">Px D-1</abbr></th>
				</tr>
			</thead>
			<tbody>   
				<c:forEach var="line" items="${ptf.lines}">
					<c:choose>
						<c:when test="${ line.type  == 'LEAF'}">
							<c:set scope="page" var="lineClass" value="levelLeaf" />
						</c:when>
						<c:otherwise>
							<c:set scope="page" var="lineClass" value="level${line.level}" />
						</c:otherwise>
					</c:choose>
				
					<tr class="${lineClass}">
						<!-- Date -->
						<th nowrap class="colName">${line.name}</th>
						<!-- Qt1 -->
						<th><fmt:formatNumber type="number" maxFractionDigits="3" value="${line.quantity1}" /></th>
						<!-- Nav -->
						<th><fmt:formatNumber type="number" maxFractionDigits="3" value="${line.nav}" /></th>
						<!-- Nav fnd% -->
						<th><fmt:formatNumber minFractionDigits="2" value="${line.navFundPercent}" type="percent"/></th>
						<!-- Qt2 -->
						<th><fmt:formatNumber type="number" maxFractionDigits="3" value="${line.quantity2}" /></th>
						<!-- Inst -->
						<th>${line.instrument}</th>
						<!-- Type -->
						<th>${line.instrumentType}</th>
						<!-- Mat -->
						<th><fmt:formatDate value="${line.maturity}" pattern="dd/MM/yyyy"/></th>
						<!-- Strike -->
						<th><fmt:formatNumber type="number" maxFractionDigits="3" value="${line.strike}" /></th>
						<!-- Vol -->
						<th><fmt:formatNumber minFractionDigits="2" value="${line.vol}" type="percent"/></th>
						<!-- Vol D-1 -->
						<th><fmt:formatNumber minFractionDigits="2" value="${line.volD1}" type="percent"/></th>
						<!-- P&L %-->
						<th><fmt:formatNumber minFractionDigits="2" value="${line.pnlPercent}" type="percent"/></th>
						<!-- P&L Mtd % -->
						<th><fmt:formatNumber minFractionDigits="2" value="${line.pnlMtDPercent}" type="percent"/></th>
						<!-- P&L -->
						<th><fmt:formatNumber type="number" maxFractionDigits="3" value="${line.pnl}" /></th>
						<!-- Px -->
						<th><fmt:formatNumber type="number" maxFractionDigits="3" value="${line.price}" /></th>
						<!-- Px D-1 -->
						<th><fmt:formatNumber type="number" maxFractionDigits="3" value="${line.priceD1}" /></th>
					</tr>
				</c:forEach>
			</tbody>
		</table><!-- /Portfolio Table -->
		
    </tiles:putAttribute>
</tiles:insertDefinition>
