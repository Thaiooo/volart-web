<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page session="false" %>
 
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
	Indicator
	</tiles:putAttribute>
	
	<tiles:putAttribute name="importScripts">
		<script src="<c:url value="/resources/js/volart.js" />"></script>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="otherScripts">
		$(document).ready(function() {		
			drawAllCanvas();
		});
		
		$( window ).resize(function() {
			drawAllCanvas();
		});
		
		function drawAllCanvas(){
			// Min, Max, Val
			drawGauge("divVar","canvasVar", ${risk.currentVar.min * 100}, ${risk.currentVar.max * 100}, ${risk.currentVar.var * 100});
	
			<c:if test="${!empty risk.drawDown}">
				drawGauge("divDrawDown","drawDown", 0, ${risk.drawDown.max * -100}, ${risk.drawDown.value * -100});
			</c:if>
	
			<c:forEach var="greek" items="${risk.greeks}">
				// Name, Min, Max, Val
				drawGauge("divGreeks","${greek.name}", ${greek.min * 100}, ${greek.max * 100}, ${greek.value * 100});
			</c:forEach>
			
		}
	</tiles:putAttribute>

    <tiles:putAttribute name="body">
		<!-- Fund Name -->    
		<div id="volartHeader" class="ui-grid-b">
			<div class="ui-block-a partCoin" ></div>
			<div class="ui-block-b"><h3 align="center">Portfolio: ${risk.fundName}</h3>	</div>
			<div class="ui-block-c partCoin" align="right"><strong>Date: </strong>${risk.date}</div>
		</div><!-- /Fund Name -->
		
			<div class="rwd-risk">
			
				<!-- Block a -->
				<div class="ui-block-a">
					<div class="ui-body ui-body-d">					
						<div class="ui-corner-all custom-corners">
							<div class="ui-bar ui-bar-a">
								<h3>Var</h3>
							</div>
							<div id="divVar" class="ui-body ui-body-a">
								<p>Var ${risk.currentVar.depth} <fmt:formatNumber value="${risk.currentVar.level}" type="percent"/>: <fmt:formatNumber value="${risk.currentVar.var}" type="percent"/></p>								
								<canvas id="canvasVar" width="100%" height="50px"></canvas>
								
								<p>
									<!-- Var -->
									<table class="ui-body-d ui-shadow table-stripe ui-responsive volart-table" id="table-custom-2" data-role="table" data-mode="columntoggle" data-column-popup-theme="a" data-column-btn-text="Columns" data-column-btn-theme="b">
									<thead>
										<tr class="ui-bar-d">
											<th data-priority="critical">Depth</th>
											<th data-priority="critical">Level</th>
											<th data-priority="critical">Var %</th>
											<th data-priority="3">Var Amount $</th>			
											<th data-priority="1">Date</th>
										</tr>
									</thead>
									<tbody>      
										<c:forEach var="var" items="${risk.vars}">
											<tr>
												<th>${var.depth}</th>											
												<th><fmt:formatNumber value="${var.level}" type="percent"/></th>
												<th><fmt:formatNumber value="${var.var}" type="percent"/></th>
												<th>
												<fmt:formatNumber type="number" maxFractionDigits="3" value="${var.varAmount}" />
												</th>
												<th><fmt:formatDate value="${var.date}" pattern="dd/MM/yyyy"/></th>								
											</tr>
										</c:forEach>     
									</tbody>
							   </table><!-- Fin Var -->
								</p>
							</div>
						</div>											
					</div>
				</div> <!-- Fin block a -->
				
				<!-- Block b -->
				<div class="ui-block-b">
					<div class="ui-body ui-body-d">						
						<div class="ui-corner-all custom-corners">
							<div class="ui-bar ui-bar-a">
								<h3>Greeks</h3>
							</div>
							<div id="divGreeks" class="ui-body ui-body-a">
								<c:forEach var="greek" items="${risk.greeks}">
									<p>${greek.name}: <fmt:formatNumber value="${greek.value}" type="percent"/></p>
									<canvas id="${greek.name}" width="100%" height="50px"></canvas>
								</c:forEach>
								
								<br/>
								<br/>
							</div>
						</div>					
					</div>
				</div> <!-- Fin block b -->
						
				<!-- Block c -->
				<div class="ui-block-c">
					<div class="ui-body ui-body-d">
						<div class="ui-corner-all custom-corners">
							<div class="ui-bar ui-bar-a">
								<h3>Draw Down</h3>
							</div>
							<div id="divDrawDown" class="ui-body ui-body-a">
								<c:if test="${!empty risk.drawDown}">
									<p>Draw Down: <fmt:formatNumber value="${risk.drawDown.value}" type="percent"/> 
									(<fmt:formatDate value="${risk.drawDown.startDate}" pattern="dd/MM/yyyy"/> 
									to <fmt:formatDate value="${risk.drawDown.endDate}" pattern="dd/MM/yyyy"/>)
									</p>
									<canvas id="drawDown" width="100%" height="50px"></canvas>
								</c:if>
								
								<br/>
								<br/>
							</div>
						</div>
					</div>
				</div> <!-- Fin block c -->
				
				<!-- Block b -->
				<div class="ui-block-d">
					<div class="ui-body ui-body-d">
						<div class="ui-corner-all custom-corners">
							<div class="ui-bar ui-bar-a">
								<h3>Others</h3>
							</div>
							<div class="ui-body ui-body-a">
								<p></p>
							</div>
						</div>
					</div>
				</div> <!-- Fin block b -->
			
			</div> <!-- RWD risk -->
			
    </tiles:putAttribute>
</tiles:insertDefinition>
