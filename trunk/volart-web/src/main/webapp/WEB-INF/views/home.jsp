<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
	Volart
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<h1>Dashboard</h1>

		<p>
		<div class="ui-corner-all custom-corners">
			<div class="ui-bar ui-bar-a">
				<h3>Portfolio</h3>
			</div>
			<div class="ui-body ui-body-a">
				<p>
				<table
					class="ui-body-d ui-shadow table-stripe ui-responsive"
					data-role="table" data-column-popup-theme="a"
					data-column-btn-theme="b">
					<thead>
						<tr class="ui-bar-d">
							<th>Fund</th>
							<th data-priority="1">Asset</th>
							<th data-priority="1">P&L</th>
							<th data-priority="2">P&L D-1</th>
							<th data-priority="1">P&L Mtd</th>
							<th data-priority="2">P&L Mtd D-1</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>Offensive Overlay</th>
							<td>1234</td>
							<td>0.10%</td>
							<td>0.10%</td>
							<td>0.10%</td>
							<td>0.10%</td>
						</tr>
						<tr>
							<th>Gold</th>
							<td>1234</td>
							<td>0.10%</td>
							<td>0.10%</td>
							<td>0.10%</td>
							<td>0.10%</td>
						</tr>
					</tbody>
				</table>
				</p>

			</div>
		</div>
		</p>

		<p>
		<div class="ui-corner-all custom-corners">
			<div class="ui-bar ui-bar-a">
				<h3>Risk</h3>
			</div>
			<div class="ui-body ui-body-a">
				<p>
				<table data-role="table" data-column-btn-theme="b" data-mode="table"
					class="ui-body-d ui-shadow table-stripe ui-responsive">
					<thead>
						<tr class="th-groups">
							<td></td>
							<th colspan="3" data-priority="6">Var</th>
							<th colspan="3" data-priority="5">Greeks</th>
						</tr>
						<tr>
							<th>Fund</th>
							<th>Depth</th>
							<th>Level</th>
							<th>Var %</th>
							<th>Delta</th>
							<th>Vega</th>
							<th>Theta</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>Boston</th>
							<td>2,898</td>
							<td>739</td>
							<td>-5.8%</td>
							<td>3,647</td>
							<td>1,354</td>
							<td>+13.4%</td>
						</tr>
						<tr>
							<th>Chicago</th>
							<td>2,898</td>
							<td>739</td>
							<td>-5.8%</td>
							<td>3,647</td>
							<td>1,354</td>
							<td>+5.8%</td>
						</tr>
					</tbody>
				</table>
				</p>

			</div>
		</div>
		</p>

	</tiles:putAttribute>
</tiles:insertDefinition>
