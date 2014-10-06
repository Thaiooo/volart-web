<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
 
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
	Indicator
	</tiles:putAttribute>
	
	<tiles:putAttribute name="importScripts">
		<script src="<c:url value="/resources/js/volart.dstat.js" />"></script>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="otherScripts">
		$(document).ready(function() {		
			drawAllCanvas();
		});
		
		$( window ).resize(function() {
			drawAllCanvas();
		});
		
		function drawAllCanvas(){
			<c:forEach var="dstatGroup" items="${indicator.dstatLines}">
				<c:forEach var="line" items="${dstatGroup.lines}">
					drawDStat("${line.id}", ${line.downDStat}, ${line.upDStat}, ${line.todayValue});
				</c:forEach>
			</c:forEach>
		}
	</tiles:putAttribute>
	
    <tiles:putAttribute name="body">
		<!-- Fund Name -->    
		<div id="volartHeader" class="ui-grid-b">
			<div class="ui-block-a partCoin" ></div>
			<div class="ui-block-b"><h3 align="center">Indicator</h3></div>
			<div class="ui-block-c partCoin" align="right"><strong>Date: </strong><fmt:formatDate value="${indicator.date}" pattern="dd/MM/yyyy"/></div>
		</div><!-- /Fund Name -->
		
			<p>
				<div class="ui-corner-all custom-corners">
					<div class="ui-bar ui-bar-a">
						<h3>DStat</h3>
					</div>
					<div class="ui-body ui-body-a">						
					
						<div data-role="collapsibleset" data-theme="a" data-content-theme="a">
							<c:forEach var="dstatGroup" items="${indicator.dstatLines}">
								<div data-role="collapsible">
									<h2>${dstatGroup.name}</h2>
									<table class="ui-body-d ui-shadow table-stripe ui-responsive volart-table" id="table-custom-2" data-role="table" data-mode="columntoggle" data-column-popup-theme="a" data-column-btn-text="Columns" data-column-btn-theme="b">
										<thead>
											<tr class="ui-bar-d">
												<th style="width: 50px;">Underlying</th>
												<th style="width: 150px;" data-priority="4"></th>			 
												<th data-priority="1">Down DStat</th>
												<th data-priority="1">Up DStat</th>
												<th data-priority="2">Today</th>			
												<th data-priority="3">Yesterday</th>										
											</tr>
										</thead>
										<tbody>           
											<c:forEach var="line" items="${dstatGroup.lines}">
												<tr>	
													<th>${line.underlying}</th>
													<th><canvas id="${line.id}" width="150px" height="15px"></canvas></th>
													<th>${line.downSpot} (${line.downDStat})</th>
													<th>${line.upSpot} (${line.upDStat})</th>
													<th>${line.todayValue}</th>
													<th>${line.yesterdayValue}</th>
												</tr>
											</c:forEach>									
										</tbody>     
									</table>
								</div>
							</c:forEach>
						</div>							
					</div>
				</div>
			</p>

			<p>
				<div class="ui-corner-all custom-corners">
					<div class="ui-bar ui-bar-a">
						<h3>Beta Target</h3>
					</div>
					<div class="ui-body ui-body-a">
						<p>
							<table class="ui-body-d ui-shadow table-stripe ui-responsive volart-table" id="table-custom-2" data-role="table" data-mode="columntoggle" data-column-popup-theme="a" data-column-btn-text="Columns" data-column-btn-theme="b">
								<thead>
									<tr class="ui-bar-d">
										<th >Instrument</th>
										<th data-priority="1">Today</th>			 
										<th data-priority="1">Yesterday</th>
										<th data-priority="2">Last Month Date</th>
										<th data-priority="2">Last Month Value</th>			
									</tr>
								</thead>
								<tbody>    
									<c:forEach var="col" items="${indicator.betaTargetLines}">
										<tr>										
											<th>${col.underlying}</th>
											<th><fmt:formatNumber minFractionDigits="2" value="${col.todayValue}" type="percent"/></th>
											<th><fmt:formatNumber minFractionDigits="2" value="${col.yesterdayValue}" type="percent"/></th>
											<th><fmt:formatDate value="${col.lastMonthDate}" pattern="dd/MM/yyyy"/></th>
											<th><fmt:formatNumber minFractionDigits="2" value="${col.lastMonthValue}" type="percent"/></th>
										</tr>
									</c:forEach>
								</tbody>  
							</table>
						</p>
					</div>
				</div>
			</p>
			
			<p>
				<div class="ui-corner-all custom-corners">
					<div class="ui-bar ui-bar-a">
						<h3>Relative Value</h3>
					</div>
					<div class="ui-body ui-body-a">
						<p>
							<table class="ui-body-d ui-shadow table-stripe ui-responsive volart-table" id="table-custom-2" data-role="table" data-mode="columntoggle" data-column-popup-theme="a" data-column-btn-text="Columns" data-column-btn-theme="b">
								<thead>
									<tr class="ui-bar-d">
										<th >Instrument</th>
										<th data-priority="1">Today</th>			 
										<th data-priority="1">Yesterday</th>
										<th data-priority="2">Last Month Date</th>
										<th data-priority="2">Last Month Value</th>			
									</tr>
								</thead>
								<tbody>    
									<c:forEach var="col" items="${indicator.relativeValueLines}">
										<tr>										
											<th>${col.underlying}</th>
											<th><fmt:formatNumber minFractionDigits="2" value="${col.todayValue}" type="percent"/></th>
											<th><fmt:formatNumber minFractionDigits="2" value="${col.yesterdayValue}" type="percent"/></th>
											<th><fmt:formatDate value="${col.lastMonthDate}" pattern="dd/MM/yyyy"/></th>
											<th><fmt:formatNumber minFractionDigits="2" value="${col.lastMonthValue}" type="percent"/></th>
										</tr>
									</c:forEach>
								</tbody>  
							</table>
						</p>
					</div>
				</div>
			</p>
		
    </tiles:putAttribute>
</tiles:insertDefinition>
